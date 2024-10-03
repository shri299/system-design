package chainofresponsibility;

public class InfoLogProcessor extends LogProcessor{

    InfoLogProcessor (LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(int logType, String message){
        if (logType==INFO){
            System.out.println("INFO "+message);
        }else {
            super.log(logType,message);
        }
    }
}
