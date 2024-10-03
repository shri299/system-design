package chainofresponsibility;

public class Main {

    public static void main(String[] args) {
        LogProcessor obj = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        obj.log(LogProcessor.ERROR,"Exception Occurred");
        obj.log(LogProcessor.INFO,"Just For Info");
        obj.log(LogProcessor.DEBUG,"Debug this");
    }
}
