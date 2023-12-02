package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day1 {
    public static void main(String[] args) {
        int sum = 0;
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("D:\\git\\aoc2023\\day1\\input"));
            String line = reader.readLine();

            while (line != null) {
                // reduce input string to only numbers
                String numberString = line.replaceAll("[a-z]", "");

                // get first and last number of string
                char[] asArray = numberString.toCharArray();
                int first = asArray[0] - 0x30;
                int last = asArray[asArray.length - 1] - 0x30;
                System.out.printf("First: %d, Last: %d\n", first, last);

                // update sum
                int toAdd = first * 10 + last;
                sum += toAdd;
                System.out.printf("Adding %d to sum, current sum is %d.\n", toAdd, sum);

                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("\nFinal sum is %d.\n", sum);

    }
}
