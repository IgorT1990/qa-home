package homework.stream_api;

import java.util.Random;

public class Test2_random {
    public static void main(String[] args) {
        Random random = new Random();
        int numberAmount = 10;
        int [] numbers = new int[10];

        for (int i = 0; i < numberAmount; i ++){
            numbers[i] = random.nextInt(100);
        }

        int pairNumbers = 0;
        for (int number : numbers){
            if (number % 2 == 0){
                pairNumbers++;
            }
        }

        System.out.println("Random numbers: ");
        for (int number : numbers){
            System.out.println(number + " ");
        }

        System.out.println("Amount of pair numbers: " + pairNumbers);

    }
}
