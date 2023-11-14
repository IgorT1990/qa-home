package homework.lambda_generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task7 {

    static class Pet {
        private String name;

        public Pet(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    static class Cat extends Pet {
        public Cat(String name) {
            super(name);
        }
    }

    static class Dog extends Pet {
        public Dog(String name) {
            super(name);

        }

        static class Parrot extends Pet {
            public Parrot(String name) {
                super(name);
            }
        }

        public static void main(String[] args) {

            Map<String, Pet> petsMap = new HashMap<>();

            petsMap.put("John", new Cat("Pushok"));
            petsMap.put("Jasy", new Dog("Richy"));
            petsMap.put("Alan", new Parrot("Foxi"));

            printKey(petsMap);

        }


        private static void printKey(Map<String, Pet> petsMap) {
            Set<String> key = petsMap.keySet();
            for (String keys : key) {
                System.out.println(keys);
            }
        }
    }

}
