package statedesignpattern.documentworkflow;

public class Publish implements DocumentState{
    @Override
    public void submitForReview(Document document) {
        System.out.println("Document already in published state");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document already in published state");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document already in published state");
    }
}
