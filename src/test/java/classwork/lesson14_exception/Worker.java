package classwork.lesson14_exception;

public class Worker {
    String name;
    boolean isAtWork;
    boolean isProfessional;

    void setAtWork(){
        isAtWork = true;
    }

    void setProfessional(){
        isProfessional = true;
    }

    public Worker(String name){
        this.name = name;
    }

    public void work() throws WorkerIsNotReadyException{
        if (isAtWork && isProfessional){
            System.out.println("Worker " + name + " can work");
        }
        else {
            throw new WorkerIsNotReadyException("Worker " + name + " is not ready");
        }
    }

}
