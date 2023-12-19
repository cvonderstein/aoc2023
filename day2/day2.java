package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day2 {
    public static void main(String[] args) {
        BufferedReader reader;
        ArrayList<Integer> possibleGames = new ArrayList<>();
        int maxBlue = 14, maxRed = 12, maxGreen = 13;

        try {
            reader = new BufferedReader(new FileReader("/Users/cvonderstein/git/aoc2023/day2/input"));
            String line = reader.readLine();

            while (line != null) {
                int blue = 0, red = 0, green = 0;
                int gameNumber = Integer.parseInt(line.split(":")[0].replace("Game ", ""));
                String[] tries = line.split(":")[1].split(";"); // each String in this array represents one try

                for (String t : tries) {
                    String[] colors = t.split(",");
                    for (String color : colors) {
                        if (color.contains("blue")) {
                            int numBlue = Integer.parseInt(color.replace("blue", "").replace(" ", ""));
                            blue = Integer.max(blue, numBlue);
                        } else if (color.contains("red")) {
                            int numRed = Integer.parseInt(color.replace("red", "").replace(" ", ""));
                            red = Integer.max(red, numRed);
                        } else if (color.contains("green")) {
                            int numGreen = Integer.parseInt(color.replace("green", "").replace(" ", ""));
                            green = Integer.max(green, numGreen);
                        } else {
                            System.out.printf("Game %d contains an invalid color. String: %s\n", gameNumber, t);
                        }
                    }
                }
                // now, blue, red and green hold the least amount of cubes that we know for sure are contained

                System.out.printf("Game: %d, Blue: %d, Red: %d, Green: %d\n", gameNumber, blue, red, green);

                if (blue <= maxBlue && red <= maxRed && green <= maxGreen) {
                    possibleGames.add(gameNumber);
                }

                // read next line
                line = reader.readLine();
            }

            int possibleGameSum = 0;
            for (int i : possibleGames) {
                possibleGameSum += i;
            }

            System.out.printf("\nPossible Game Sum: %d, Game List: %s\n", possibleGameSum, possibleGames);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
