package homework.lambda_generic;

import java.util.Scanner;

public class Task1 {
    @FunctionalInterface
    interface CheckNumber{
        boolean check(int num);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your number:");
        int userNumber = input.nextInt();

        CheckNumber checkNumber = (number) -> number % 13 == 0;

        boolean result = checkNumber.check(userNumber);

        System.out.println(result);
    }
}
