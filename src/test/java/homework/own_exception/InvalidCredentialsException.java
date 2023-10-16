package homework.own_exception;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message){
        super(message);
    }
}
