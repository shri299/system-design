package templatedesignpattern;

public class PaymentToMerchant extends Payment{
    @Override
    public void validateRequest() {
        System.out.println("merchant");
    }

    @Override
    public void debitAmount() {
        System.out.println("merchant");
    }

    @Override
    public void calculateFee() {
        System.out.println("merchant");
    }

    @Override
    public void creditAmount() {
        System.out.println("merchant");
    }
}
