package classwork.lesson14_exception;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker("John");
        worker.setAtWork();

        try {
            worker.work();
        }
        catch (WorkerIsNotReadyException exception){
            exception.printStackTrace();
        }
    }
}
