package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day1 {
    public static void main(String[] args) {
        // create map for replacements
        Map<String, Integer> numberWordMap = getStringIntegerMap();

        int sum = 0;
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("D:\\git\\aoc2023\\day1\\input"));
            String line = reader.readLine();

            while (line != null) {
                // list of digits
                List<Integer> list = new ArrayList<>();

                System.out.printf("Line: '%s'", line);

                // iterate over string, search for digits and written out digits
                while (!line.isEmpty()) {
                    int firstChar = line.charAt(0) - 0x30;
                    if (firstChar > 0 && firstChar < 10) {
                        // case first character is a digit
                        list.add(firstChar);
                    } else {
                        // case it is a letter: check if it is a written out digit (and if so, add the corresponding value to the list)
                        for (String key : numberWordMap.keySet()) {
                            if (line.startsWith(key)) {
                                list.add(numberWordMap.get(key));
                            }
                        }
                    }

                    // cut off first character (if it was a written out digit, this won't be found again)
                    line = line.substring(1);
                }
                System.out.printf(", found digits: " + list + "\n");

                // get first and last number of list
                int first = list.get(0);
                int last = list.get(list.size() - 1);
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

    private static Map<String, Integer> getStringIntegerMap() {
        Map<String, Integer> numberWordMap = new HashMap<>();
        // numberWordMap.put("zero", 0); // according to the task description, zero is not a valid value in this case
        numberWordMap.put("one", 1);
        numberWordMap.put("two", 2);
        numberWordMap.put("three", 3);
        numberWordMap.put("four", 4);
        numberWordMap.put("five", 5);
        numberWordMap.put("six", 6);
        numberWordMap.put("seven", 7);
        numberWordMap.put("eight", 8);
        numberWordMap.put("nine", 9);
        return numberWordMap;
    }
}
