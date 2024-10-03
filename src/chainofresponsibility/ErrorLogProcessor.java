package chainofresponsibility;

public class ErrorLogProcessor extends LogProcessor{

    ErrorLogProcessor (LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(int logType, String message){
        if (logType==ERROR){
            System.out.println("ERROR "+message);
        }else {
            super.log(logType,message);
        }
    }
}
