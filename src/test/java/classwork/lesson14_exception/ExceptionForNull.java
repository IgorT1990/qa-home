package classwork.lesson14_exception;

public class ExceptionForNull {
    public static void main(String[] args) {
        String str = null;

        // 1 case
        try {
            System.out.println(str.length());
        } catch (NullPointerException ex){
            System.out.println("String is null");
        }

        // 2 case
//        if (str != null){
//            System.out.println(str.length());
//        }

        System.out.println("After catch message");
    }
}