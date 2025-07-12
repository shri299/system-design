package templatedesignpattern;

public class PaymentToFriend extends Payment{
    @Override
    public void validateRequest() {
        System.out.println("Friend");
    }

    @Override
    public void debitAmount() {
        System.out.println("Friend");
    }

    @Override
    public void calculateFee() {
        System.out.println("Friend");
    }

    @Override
    public void creditAmount() {
        System.out.println("Friend");
    }
}
