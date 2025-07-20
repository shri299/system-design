package statedesignpattern.documentworkflow;

public class Draft implements DocumentState{
    @Override
    public void submitForReview(Document document) {
        System.out.println("Moving draft document to review state");
        document.setDocumentState(new Review());
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document in draft, cannot approve");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document in draft, cannot reject");
    }
}
