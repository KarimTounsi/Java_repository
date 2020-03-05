package Java.projects.game;

import java.util.Random;
import java.util.Scanner;

public class guessingthenumber {

        static public void main (String[] args){

            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int randomNumber = random.nextInt(50)+1;
            int number=0;
            do {

                try {

                    System.out.println("Zgadnij liczbę");
                    String line = scanner.next();
                    number =Integer.parseInt(line);
                    if (number<randomNumber){
                        System.out.println("Za mało");
                    }
                    else if(number>randomNumber) {
                        System.out.println("Za dużo");
                    }
                } catch (NumberFormatException b){
                    System.err.println("Nie poprawne dane");
                }

            } while (number !=randomNumber);
            System.out.println("Zgadłeś");

        }
    }

