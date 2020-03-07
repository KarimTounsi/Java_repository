package Java.projects.Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class lottogame {

    static public void main(String[] args) {

        int[] userNumber = enterNumbers();
        System.out.println("chosen numbers are: " + Arrays.toString(userNumber));
        int[] randomNumbers = generateNumbers();
        System.out.println("Drawn numbers are: " + Arrays.toString(randomNumbers));
        int win = win(userNumber, randomNumbers);
        if (win >= 3) {
            System.out.println("You won! guessed numbers: " + win);
        } else {
            System.out.println("Unfortunately you didn't win.");
        }

    }

    static int[] enterNumbers() {

        int[] numbers = new int[6];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numbers.length; ) {

            System.out.println("Enter " + (i + 1) + " number:");

            String numbersInput = scanner.nextLine();

            try {
                int number = Integer.parseInt(numbersInput);

                if (number < 1 || number > 49) {
                    System.out.println("Number is out of range 1-49");
                    number = 0;
                } else {

                    for (int j = 0; j < i; j++) {
                        if (number == numbers[j]) {
                            System.out.println("Numbers are repeating");
                            number = 0;
                            break;
                        }
                    }
                }
                if (number > 0) {
                    numbers[i] = number;
                    i++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data");
            }
        }
        Arrays.sort(numbers);
        return numbers;
    }

    static int[] generateNumbers() {

        int[] randomNumbers = new int[6];
        Integer[] arr = new Integer[49];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));

        for (int i = 0; i < randomNumbers.length; i++) {
            if (arr[i] > 0) {
                randomNumbers[i] = arr[i];
            }
        }
        return randomNumbers;
    }

    static int win(int[] userNumbers, int[] randomNumbers) {

        int win = 0;
        for (int i = 0; i < userNumbers.length; i++) {
            for (int j = 0; i < randomNumbers.length; i++) {
                if (userNumbers[i] == randomNumbers[j]) {
                    win++;
                }
            }

        }
        return win;
    }
}