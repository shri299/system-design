package parkinglot.fees;

public class TimeBased implements Fee{
    @Override
    public Double calcFee() {
        return 50.0;
    }
}
