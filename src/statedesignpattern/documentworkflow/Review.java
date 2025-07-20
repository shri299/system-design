package statedesignpattern.documentworkflow;

public class Review implements DocumentState{
    @Override
    public void submitForReview(Document document) {
        System.out.println("Document already in review state");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document approved, moving to published state");
        document.setDocumentState(new Publish());
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document rejected, moving to draft state");
        document.setDocumentState(new Draft());
    }
}
