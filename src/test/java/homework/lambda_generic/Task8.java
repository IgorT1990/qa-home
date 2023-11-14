package homework.lambda_generic;

import java.util.*;

public class Task8 {

    public static <T>Collection<T> removeDuplicates(Collection<T> collection){
        return new HashSet<>(collection);
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,2,2,4,5,6,6));
        System.out.println("Original list: " + intList);

        Collection<Integer> unique1 = removeDuplicates(intList);
        System.out.println("Duplicates removed: " + unique1);

        System.out.println("+++++++++++++++");

        List<String> stringList = new ArrayList<>(Arrays.asList("0ne", "One", "Two", "Three"));
        System.out.println("Original string list: " + stringList);

        Collection<String> unique2 = removeDuplicates(stringList);
        System.out.println("String without duplicates: " + unique2);
    }
}
