package statedesignpattern.documentworkflow;

public class Document {

    private DocumentState documentState;

    public Document (){
        this.documentState = new Draft();
    }

    public void setDocumentState(DocumentState state){
        this.documentState=state;
    }

    public void submitForReview(){
        documentState.submitForReview(this);
    }

    public void approve(){
        documentState.approve(this);
    }

    public void reject(){
        documentState.reject(this);
    }
}
