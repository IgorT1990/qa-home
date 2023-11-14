package homework.lambda_generic;

import java.util.HashMap;
import java.util.Map;

public class Task6 {
    static class Toy {
        private String name;
        private double price;

        public Toy(String name, double price) {
            this.name = name;
            this.price = price;
        }
        public String getName(){
            return name;
        }

        public double getPrice(){
            return price;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Toy> toysMap = new HashMap<>();

        toysMap.put("Bear", new Toy("Big bear", 21.0));
        toysMap.put("Rabbit", new Toy("Small rabbit", 15.0));
        toysMap.put("Mouse", new Toy("Middle mouse", 13.0));

        printEntries(toysMap);
        printKeys(toysMap);
        printValue(toysMap);

    }

    public static void printEntries(HashMap<String, Toy> toysMap){
        for (Map.Entry<String, Toy> entry : toysMap.entrySet()){
            System.out.println("toy type: " + entry.getKey() + "Toy name: " + entry.getValue().getName() + "Toy price: " + entry.getValue().getPrice());
        }
    }

    public static void printKeys(HashMap<String, Toy> toysMap){
        for (String toyName : toysMap.keySet()){
            System.out.println("Toy name: " + toyName);
        }
    }

    public static void printValue(HashMap<String, Toy> toysMap){
        for (Toy toy : toysMap.values()) {
            System.out.println("Toy value: " + toy);
        }
    }

}
