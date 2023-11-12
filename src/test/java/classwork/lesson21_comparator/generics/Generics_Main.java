package classwork.lesson21_comparator.generics;


public class Generics_Main {
    public static void main(String[] args) {
        MyDataSimple<Integer> dataSimple = new MyDataSimple<>(1);
        MyDataSimple<Integer> dataSimple2 = new MyDataSimple<>(3);

        int resultInteger = dataSimple.getT() + dataSimple2.getT();
        System.out.println("resultInteger: " + resultInteger);
        System.out.println("++++++++++");


        MyDataSimple<String> dataSimple3 = new MyDataSimple<>("one");
        MyDataSimple<String> dataSimple4 = new MyDataSimple<>("three");

        String resultString = dataSimple3.getT() + dataSimple4.getT();
        System.out.println("resultString: " + resultString);
        System.out.println("+++++++++++");


        MyDataComplex<Integer, String, Number, Double, Boolean, Object> dataComplex = new MyDataComplex<>();

    }
}
