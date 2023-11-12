package classwork.lesson21_comparator.comperable;


public class Comparator_Main {
    public static void main(String[] args) {


        CatFromInterface cat = new CatFromInterface();
        FishFromInterface fish = new FishFromInterface();

        System.out.println("cat");
        System.out.println(cat.move());
        System.out.println(cat.sleep());
        System.out.println("+++++++++");

        System.out.println("fish");
        System.out.println(fish.move());
        System.out.println(fish.sleep());
    }
}