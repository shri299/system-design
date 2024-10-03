package chainofresponsibility;

public class DebugLogProcessor extends LogProcessor{

    DebugLogProcessor (LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(int logType, String message){
        if (logType==DEBUG){
            System.out.println("DEBUG "+message);
        }else {
            super.log(logType,message);
        }
    }
}
