package classwork.lesson14_exception;

import java.io.IOException;
import java.util.Scanner;

public class DivisionExceptionThrows {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        while(i < 5) {
            i ++;
            int a = input.nextInt();
            int b = input.nextInt();
            try {
                int mult = a * b;
                System.out.println("a * b = " + mult);

                if (b ==0){
                    throw new ArithmeticException();
                }
                int div = divide(a, b);
                System.out.println("a / b = " + div);
            }
            catch (ArithmeticException ex){
                System.out.println("Division by 0");
            }
            catch (IOException ex1){
                System.out.println(ex1);
            }
            catch (RuntimeException ex2){
                System.out.println(ex2);
            }
        }

    }
    private static int divide(int a, int b) throws ArithmeticException, IOException, RuntimeException {
        if (a == 1){
            throw new IOException();
        }
        return a/ b;
    }
}

