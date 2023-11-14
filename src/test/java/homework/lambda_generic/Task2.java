package homework.lambda_generic;

import java.util.Scanner;

public class Task2 {
    @FunctionalInterface
    interface CompareStrings{
        String compare(String string1, String string2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first word");
        String string1 = scanner.nextLine();

        System.out.println("Enter your second word");
        String string2 = scanner.nextLine();

        CompareStrings compareStrings = (str1, str2) -> string1.length() >= string2.length() ? string1 : string2;

        String longer = compareStrings.compare(string1, string2);

        System.out.println("The longer string is: " + longer);
    }
}
