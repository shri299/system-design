package templatedesignpattern;

public abstract class Payment {

    //these are abstract method and can be inherited and ech child can have its own logic

    public abstract void validateRequest();
    public abstract void debitAmount();
    public abstract void calculateFee();
    public abstract void creditAmount();

    public final void sendMoney(){ //a common template that ech child class must follow
        validateRequest();
        debitAmount();
        calculateFee();
        creditAmount();
    }

}
