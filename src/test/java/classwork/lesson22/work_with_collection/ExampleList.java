package classwork.lesson22.work_with_collection;
import java.util.*;

public class ExampleList {

    public static void main(String[] args) {
        // List
        List<String> list = new ArrayList<>();
        list.add("How");
        list.add("are");
        list.add("you");

        // get iterator for the list
        System.out.println("ArrayList: ");
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
        System.out.println("+++++++++++++");

        for (String listElement : list) {
            System.out.println(listElement);
        }
        System.out.println("+++++++++++++");
        System.out.println("+++++++++++++");

        // Set
        System.out.println("HashSet: ");
        Set<String> set = new HashSet<>();
        set.add("How");
        set.add("are");
        set.add("are");
        set.add("you");

        // get iterator for the set
        Iterator<String> iterator1 = set.iterator();
        while (iterator1.hasNext()) {
            String s1 = iterator1.next();
            System.out.println(s1);
        }
        System.out.println("+++++++++++++");

        for (String s2 : set) {
            System.out.println(s2);
        }
        System.out.println("++++++++++++");
        System.out.println("+++++++++++++");

        // Map (map elements keeps in pairs)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "How");
        map.put(2, "are");
        map.put(3, "you");

        System.out.println("Map: ");
        // get iterator for the map
        Iterator<Map.Entry<Integer, String>> iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            // get pairs of the elements
            Map.Entry<Integer, String> pair = iterator2.next();
            int key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ":" + value);
        }
        System.out.println("+++++++++++++");

        for (Map.Entry<Integer, String> s3 : map.entrySet()) {
            int key1 = s3.getKey();
            String value1 = s3.getValue();
            System.out.println(key1 + ":" + value1);
        }

        System.out.println("+++++++++++++");
        System.out.println("+++++++++++++");

        // LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("How");
        linkedList.add("are");
        linkedList.add("you");

        System.out.println("LinkedList: ");
        // get iterator for the LinkedList
        Iterator<String> iteratorLinkedList = linkedList.iterator();

        while (iteratorLinkedList.hasNext()){
            String s4 = iteratorLinkedList.next();
            System.out.println(s4);
        }
        System.out.println("+++++++++++++");

        for (String listElements : linkedList){
            System.out.println(listElements);
        }
    }


}
