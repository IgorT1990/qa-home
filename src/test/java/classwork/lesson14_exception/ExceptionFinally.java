package classwork.lesson14_exception;

public class ExceptionFinally {
    public static void main(String[] args) {
        int [] array = {10, 20};

        try {
            System.out.println("array[0] = " + array[0]);
            // System.exit(0);
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.err.println("Exception about index: " + exception);
        }
        finally {
            array[0] = 6;
            System.out.println("We are in block finally");
            System.out.println(array[0]);
        }
    }
}

