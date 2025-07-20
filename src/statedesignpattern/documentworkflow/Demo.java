package statedesignpattern.documentworkflow;

public class Demo {

    public static void main(String[] args) {
        //draft -> review -> published
        Document doc = new Document();
        doc.approve(); // invalid in draft
        doc.submitForReview(); // goes to review
        doc.submitForReview(); // already in review
        doc.reject(); // goes back to draft
        doc.submitForReview(); // goes to review
        doc.approve(); // publishes
        doc.submitForReview(); // can't submit again
    }
}
