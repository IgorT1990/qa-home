package homework.lambda_generic;

import java.util.LinkedList;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> strings = new LinkedList<>();

        System.out.print("Enter the number of strings: ");
        int numberOfStrings = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter strings:");

        for (int i = 0; i < numberOfStrings; i++) {
            String input = scanner.nextLine();
            strings.addFirst(input);
        }

        System.out.println("\nStrings entered (in reverse order):");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}