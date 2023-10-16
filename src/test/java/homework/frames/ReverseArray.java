package homework.frames;

public class ReverseArray {
    public static void main(String[] args) {
        String[] original = {"one", "two", "three", "four", "five"};
        for (String elements : original) {
            System.out.println(elements);
        }
        System.out.println("=============");

        int length = original.length;
        for (int i = 0; i < length / 2; i++) {
            String temp = original[i];
            original[i] = original[length - 1 - i];
            original[length - 1 - i] = temp;
        }

        for (String reverse : original) {
            System.out.println(reverse);


        }
        System.out.println("==========");

        int [] array = {1,2,3,4,5};
        for (Integer ar : array){
            System.out.println(ar);
        }

        int lenth = array.length;
        for (int i = 0; i < lenth/2; i ++){
            int temp = array[i];
            array[i] = array[lenth - 1 - i];
            array[lenth -1 - i] = temp;
        }
        for (Integer rever : array){
            System.out.println(rever);
        }
        System.out.println("============");

        int [] list = {1,2,3,4,5,6};
        for (int i = list.length - 1; i >= 0; i --){
            System.out.println(list[i]);
        }
    }
}
