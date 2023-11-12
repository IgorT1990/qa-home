package classwork.lesson21_comparator.generics;

import java.util.ArrayList;
import java.util.List;

public class Wrapper_Main {
    public static void main(String[] args) {
        List list1 = new ArrayList();

        list1.add(5);
        list1.add(6);
        list1.add("8");

        for (int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }
        System.out.println("++++++++");

        List<MyNumber> list2 = new ArrayList<>();

        list2.add(new MyNumber(5));
        list2.add(new MyNumber(6));
        list2.add(new MyNumber(8));

        for (int i = 0; i < list2.size(); i ++){
            System.out.println(list2.get(i));
        }
        System.out.println("+++++++++");

        List<Integer> list3 = new ArrayList<>();

        list3.add(5);
        list3.add(6);
        list3.add(8);

        for (int i = 0; i < list3.size(); i ++){
            System.out.println(list3.get(i));
        }

        System.out.println("Value: " + 1);
    }
}
