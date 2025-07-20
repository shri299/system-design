package statedesignpattern.documentworkflow;

public interface DocumentState {

    void submitForReview(Document document);
    void approve(Document document);
    void reject(Document document);
}
