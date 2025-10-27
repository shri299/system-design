package stackoverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflow {

    private static StackOverflow instance;
    private final Map<String, User> users;
    private final Map<String, Question> questions;
    private final Map<String, Answer> answers;
    private final Map<String, Tag> tags;

    private StackOverflow() {
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
    }

    //this can be choking, so you can go for double locking also
    public synchronized StackOverflow getInstance() {
        if (instance == null) {
            instance = new StackOverflow();
        }
        return instance;
    }

    public User createUser(String username, String email) {
        //basic validation check
        User user = new User(username, email);
        users.put(user.getUserId(), user);
        return user;
    }

    public Question postQuestion(String userId, String title, String content, List<String> questionTags) {
        User author = users.get(userId);
        List<Tag> tagList = new ArrayList<>();
        for (String qTag: questionTags) {
            Tag tag = tags.getOrDefault(qTag, new Tag(qTag));
            tagList.add(tag);
            tags.put(tag.getId(), tag);
        }
        Question question = new Question(author, title, content, tagList);
        questions.put(question.getId(), question);
        return question;
    }

    public Answer postAnswer(String userId, String questionId, String content) {
        User author = users.get(userId);
        Question question = questions.get(questionId);
        Answer answer = new Answer(author, question, content);
        question.addAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

//    The use of Commentable and Votable interfaces in your design provides several advantages over the alternative approach you suggested. Here's why they are beneficial:
//    Polymorphism: By using interfaces, both Question and Answer can be treated uniformly as Commentable or Votable. This allows you to write generic code that works with any Commentable or Votable object without needing to know whether it's a Question or Answer. For example:
//    public void addComment(String userId, Commentable commentable, String content) {
//        // Works for both Question and Answer
//        commentable.addComment(new Comment(users.get(userId), content));
//    }
//    Encapsulation: The interfaces abstract away the details of how comments or votes are managed internally by Question or Answer. This keeps the logic encapsulated within the respective classes and avoids exposing unnecessary details to the caller.
//    Extensibility: If you later add another entity (e.g., Post) that can also be commented on or voted on, you can simply implement the Commentable or Votable interfaces in that class. This avoids modifying existing code and adheres to the Open/Closed Principle.
//    Avoiding Factory Complexity: Using a factory method to retrieve objects based on an identifier and type adds complexity. You would need to maintain a mapping of IDs to objects and ensure the factory can distinguish between Question and Answer. This approach is less clean and introduces additional coupling.
//    Readability and Maintainability: The interface-based design is more intuitive and aligns with object-oriented principles. It makes the code easier to understand and maintain, as the behavior of Commentable and Votable is clearly defined.
//    While your alternative approach(factory method based on flags) could work, it sacrifices these benefits and introduces additional complexity.
    public Comment addComment(String userId, Commentable commentable, String content) {
        User author = users.get(userId);
        Comment comment = new Comment(author, content);
        commentable.addComment(new Comment(author, content));
        return comment;
    }

    public void vote(String userId, Votable votable, VoteType voteType) {
        User user = users.get(userId);
        votable.vote(user, voteType);
    }

//    Your suggestion to pass both the questionId and answerId as inputs and avoid maintaining a Question reference in the Answer object is valid and can simplify the Answer class. However, it comes with trade-offs:
//    Advantages:
//    Reduced Coupling: The Answer class no longer needs to maintain a reference to the Question, reducing coupling between the two classes.
//    Simpler Answer Class: The Answer class becomes lighter and easier to manage.
//    Disadvantages:
//    Increased Responsibility: The acceptAnswer method now needs to retrieve both the Question and Answer objects, increasing its responsibility.
//            Potential for Errors: If the answerId does not belong to the questionId, additional validation logic will be required to ensure consistency.
//            Performance: Retrieving both objects from their respective maps may slightly increase the overhead.

    public void acceptAnswer(String answerId) {
        Answer answer = answers.get(answerId);
        Question question = answer.getQuestion();
        answer.markAsAccepted();
        question.acceptAnswer(answer);
    }
}
