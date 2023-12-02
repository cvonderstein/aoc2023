# Day 1

The test inputs per Part is stored in this README, the input for the final result is stored in the `input` file (in this directory).

## Part 1

### Task

Get first and last number per line of the input, both concatenated result in a two-digit number.
Sum up those two-digit numbers of all lines.

Test input:

```txt
1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
```

### Idea

For each line, first remove all characters, which can be detected by matching them to regex `[a-z]`.
Afterwards, convert the resulting string to an array, then `arr[0]` is the first and `arr[len-1]` is the last digit.
This directly covers the edge case (which was mentioned in the example) that there may be only one digit at all, which is then the first but also last digit of the line.

### Help

- How to iterate over lines in a file: [https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line](https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line)
- ASCII Table: [https://de.wikipedia.org/wiki/American_Standard_Code_for_Information_Interchange](https://de.wikipedia.org/wiki/American_Standard_Code_for_Information_Interchange)

## Part 2

### Task

Numbers can not only be in a digit form, but also written out as a string.
Those count too, otherwise its the same task.

Test input:

```txt
two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen
```

### Idea

Create a map that contains all the replacements (e.g. key: `one` and value `1`), for every line first iterate over this map and replace all matching words.
Afterwards do the same as before.

This might be a bit overkill, but probably cleaner than some other array version of this.

Update: This doesn't work like this, since there can be overlaps of two words.
In the given example, the second line is `eightwothree`, which contains `eight`, `two` and `three`.
The correct output for this line would be `83`, but unfortunately my attempt matches the `two` first (since the `two` comes first in the map) and therefore destroys the `eight` substring.
So now my new attempt is to iterate over all characters in the line, if it is a digit, add this digit to a list, if it is the start of a written out digit, add the corresponding digit to the list.
Then take this list for the later calculations.
Using this attempt I shouldn't miss any written out number.

> Quick notice: I could also iterate over all characters instead of the map and then just "destroy" later words (to not miss a first written out digit), but these later words might be required for the last digit contained, therefore I think that this is not a good option.

### Help

- How to iterate over a map: [https://www.baeldung.com/java-iterate-map](https://www.baeldung.com/java-iterate-map)
