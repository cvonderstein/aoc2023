# Day 1

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
