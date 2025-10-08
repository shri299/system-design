package parkinglot.fees;

public class SizeBased implements Fee{


    @Override
    public Double calcFee() {
        return 20.0;
    }
}
