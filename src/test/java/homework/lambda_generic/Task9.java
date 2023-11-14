package homework.lambda_generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Enter the number of strings: ");
        int numberOfStrings = 0;

        try {
            numberOfStrings = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for number of strings.");
            System.exit(1);
        }

        System.out.println("Enter the strings:");
        for (int i = 0; i < numberOfStrings; i++) {
            strings.add(scanner.nextLine());
        }

        List<String> longer = findLongerString(strings);
        System.out.println("\nLongest string(s):");
        for (String str : longer) {
            System.out.println(str);
        }
    }

    private static List<String> findLongerString(List<String> strings) {
        List<String> longer = new ArrayList<>();
        int maxLength = 0;

        for (String str : strings) {
            int length = str.length();
            if (length > maxLength) {
                maxLength = length;
                longer.clear();
                longer.add(str);
            } else if (length == maxLength) {
                longer.add(str);
            }
        }
        return longer;
    }
}
