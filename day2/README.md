# Day 2

The test inputs per Part is stored in this README, the input for the final result is stored in the `input` file (in this directory).

## Part 1

### Task

You get a list of games, during which an elf each pulls some random cubes out of a bag, which he then shows you and puts them back.
The main question is how many cubes of each of the three colors (red, green and blue) are in the bag.

Since he puts the cubes back after each try, the only information we can have for sure is the maximum number of cubes we saw at once during a game.
Now, there is a limit set of 12 red, 13 green and 14 blue cubes, and the question is, which of the games are possible.

Test Input: 

```txt
Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
```

The required answer is the sum of the game numbers (every game has a number, which is printed at the beginning of each line) of all games that are possible under the restriction that was set before.

### Idea

The idea is pretty straight-forward, for every line we get the maximum number of cubes that were shown at once.
Then, if the game is possible (matches limit), we add the games to a list, which we later sum up.

Just like on day 1, not all of this is necessary (here: the list, we could just sum it up directly), but having a list of games is nice for debugging and doesn't add much extra work.

## Part 2

### Task

Now they defined the power as the product of the minimum number of cubes required to play a game.
So for the same test input, Game 1 requires at least 6 blue, 2 green and 4 red cubes, therefore the power is 6*2*4 = 48.
The result for the puzzle is the sum of the powers of all games.

### Idea

Since I basically already had all information I need, I only calculated the power (by multiplying the three amounts I already calculated), and stored in another ArrayList.
Again, this is not necessary for the solution, since I could initialize a sum with 0 in the beginning and just add the power when processing the game, but I think it's nice to have that information and there is also this kind of idea, that I might reuse some of those algorithms in the future, so having this information is probably not bad.
Afterwards, I just iterate over the List and sum all entries up and output the result.
