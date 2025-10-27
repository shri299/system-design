package stackoverflow;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Question implements Commentable,Votable{

    private final String id;
    private final String title;
    private final String content;
    private final User author;
    private final Date creationDate;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Tag> tags;
    private final List<Vote> votes;
    private Answer acceptedAnswer;

    public Question(User author, String title, String content, List<Tag> tags) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.title = title;
        this.content = content;
        this.creationDate = new Date();
        this.answers = new CopyOnWriteArrayList<>();
        this.votes = new CopyOnWriteArrayList<>();
        this.comments = new CopyOnWriteArrayList<>();
        this.tags = tags;
    }

    public String getId() {
        return this.id;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public void vote(User voter, VoteType type) {
        votes.removeIf(v -> v.getVoter().equals(voter));//also remove the points from reputation if already exists
        votes.add(new Vote(voter, type));
        author.updateReputation(type == VoteType.UPVOTE ? ReputationType.QUESTION_UPVOTE.getPoints() :
                ReputationType.QUESTION_DOWNVOTE.getPoints());
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                .mapToInt(v -> v.getType().getValue())
                .sum();
    }

    public void acceptAnswer(Answer answer) {
        this.acceptedAnswer=answer;
    }
}
