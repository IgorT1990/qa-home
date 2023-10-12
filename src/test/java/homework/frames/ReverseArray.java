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
    }
}