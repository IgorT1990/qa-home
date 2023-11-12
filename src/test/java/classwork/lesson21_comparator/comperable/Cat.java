package classwork.lesson21_comparator.comperable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cat implements Comparable {
    String name;

    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//    @Override
//    public String toString() {
//        return "Cat{" +
//                "name='" + name + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public int compareTo(Object o) {
//        Cat cat = (Cat) o;
//        return this.getName().compareTo(cat.getName());
//    }

//    @Override
//    public int compareTo(Object o) {
//        Cat cat = (Cat) o;
//        return this.getName().compareTo(cat.getName()) * -1;
//    }

//    @Override
//    public int compareTo(Object o) {
//        Cat cat = (Cat) o;
//        return age - cat.getAge();
//    }

    @Override
    public int compareTo(Object o) {
        Cat cat = (Cat) o;
        return age - cat.getAge();
    }


    public static void main(String[] args) {
        List<Cat> catList = new ArrayList<>();

        Cat vaske = new Cat("Vaska", 2);
        Cat murka = new Cat("Murka", 6);
        Cat pushok = new Cat("Pushok", 1);

        catList.add(vaske);
        catList.add(murka);
        catList.add(pushok);

        Collections.sort(catList);

        for(Cat cat : catList) {
            System.out.println(cat.toString());
        }

    }
}