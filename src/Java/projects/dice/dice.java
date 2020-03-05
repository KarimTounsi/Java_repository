package Java.projects.dice;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dice {

    static public void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write rules, patter \"X\"D\"Y\"+\"Z\", X- amount rolls," +
                " Y= wall cubes, Z-number (example 2D6+5) in second line wrtite \"n\" to get next throw." );
        String data3="";
        String  data = scanner.next();

        System.out.println(roll(data));

        String data2 = scanner.next();

        while (data2.equals("n")) {
            do {
                System.out.println(roll(data));
                break;
            }
            while (data2.equals("n"));
          data2 = scanner.next();
        }
    }

    static int roll(String input) {

        StringTokenizer stringTokenizer = new StringTokenizer(input, "Dd+-");
        int x = 1;
        if (!input.startsWith("D")) {
            x = Integer.parseInt(stringTokenizer.nextToken());
        }
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int z = 0;
        if (stringTokenizer.hasMoreTokens()) {
            z = Integer.parseInt(stringTokenizer.nextToken());
        }
        if (input.contains("-")) {
            z = -z;
        }
        int sum = 0;
        Random random = new Random();
        for (int i=0; i<x; i++){
            sum+= random.nextInt(y)+1;
        }

        return sum + z;
    }
}
