package homework.lambda_generic;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your numbers separated by commas: ");
        String lineInput = scanner.nextLine();

        String[] numbersLine = lineInput.split(",");
        List<String> list = Arrays.asList(numbersLine);
        Set<String> unique = new LinkedHashSet<>(list);
        String result = String.join(",", unique);
        System.out.println("Line without duplicates: " + result);
    }
}
