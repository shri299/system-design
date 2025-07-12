package strategydesignpattern.discountstrategy;

public class Demo {

    public static void main(String[] args) {

        DiscountType input = DiscountType.FLAT;
        DiscountContext context = new DiscountContext();
        switch (input) {
            case FLAT: context.setStrategy(new FlatDiscount()); break;
            case PERCENTAGE: context.setStrategy(new PercentageDiscount()); break;
            case FESTIVAL: context.setStrategy(new FestivalDiscount()); break;
            case NONE: context.setStrategy(new NoDiscountStrategy()); break;
        }
        System.out.println(context.calcFinalCost(1000));
    }
}
