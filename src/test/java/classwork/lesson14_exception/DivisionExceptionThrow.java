package classwork.lesson14_exception;

import java.util.Scanner;

public class DivisionExceptionThrow {
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
                int div = a / b;
                System.out.println("a / b = " + div);
            }
            catch (ArithmeticException ex){
                System.out.println("Division by 0");
            }
        }
    }
}

