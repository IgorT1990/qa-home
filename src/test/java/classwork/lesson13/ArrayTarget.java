package classwork.lesson13;

public class ArrayTarget {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        int length = array.length;
        boolean flag = false;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] + array[j] == target) {
                    System.out.println("[" + i + "," + j + "]");
                    flag = true;
                    break;
                }
            }

        }
        if (!flag) {
            System.out.println("There are no such numbers");
        }
    }
}
