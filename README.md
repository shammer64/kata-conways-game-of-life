# kata-conways-game-of-life

After several shortened attempts to complete this kata as part of code retreats, I finally got around to test driving the full solution. I also created a visual representation of the game using Java 2D Graphics. Simply run the Java app in the project to get a default simulation of a random starting board. Add up to 3 command line arguments for *width*, *height* and number of *generations* to run in the simulation.

![Codiga Analysis](https://api.codiga.io/project/31555/score/svg)

Excerpt from https://conwaylife.com/wiki/Conway%27s_Game_of_Life

The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, live or dead. Every cell interacts with its eight neighbours, which are the cells that are directly horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:

* Any live cell with fewer than two live neighbours dies (referred to as underpopulation or exposure[1]).
* Any live cell with more than three live neighbours dies (referred to as overpopulation or overcrowding).
* Any live cell with two or three live neighbours lives, unchanged, to the next generation.
* Any dead cell with exactly three live neighbours will come to life.

The initial pattern constitutes the 'seed' of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed — births and deaths happen simultaneously, and the discrete moment at which this happens is sometimes called a tick. (In other words, each generation is a pure function of the one before.) The rules continue to be applied repeatedly to create further generations.
