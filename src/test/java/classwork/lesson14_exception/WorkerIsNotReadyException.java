package classwork.lesson14_exception;

public class WorkerIsNotReadyException extends Exception{
    public WorkerIsNotReadyException(String message){
        super(message);
    }
}
