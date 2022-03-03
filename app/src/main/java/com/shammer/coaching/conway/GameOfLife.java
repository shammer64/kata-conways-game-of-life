package com.shammer.coaching.conway;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

public class GameOfLife {
    private Character[][] grid;
    public static final char ALIVE = 'X';
    public static final char DEAD = ' ';

    public GameOfLife(Character[][] seed) {
        super();
        this.grid = seed;
    }

    @Override
    public String toString() {
        return Arrays.stream(grid)
                .map(arr -> Arrays.stream(arr)
                        .map(c -> c.toString())
                        .collect(Collectors.joining())
                )
                .collect(Collectors.joining("\n"));
    }

    public void evolve() {
        Character[][] newGrid = new Character[grid.length][grid[0].length];
        range(0, grid.length)
                .forEach(row -> range(0, grid[row].length)
                        .forEach(col -> evolveCell(row, col, newGrid)));
        this.grid = newGrid;
    }

    private void evolveCell(int row, int col, Character[][] newGrid) {
        Character currCell = grid[row][col];
        int neighbors = neighbors(row, col);
        if (lonely(currCell, neighbors)) newGrid[row][col] = DEAD;
        else if (crowded(currCell, neighbors)) newGrid[row][col] = DEAD;
        else if (roomToGrow(currCell, neighbors)) newGrid[row][col] = ALIVE;
        else
            newGrid[row][col] = currCell;
    }

    private boolean roomToGrow(Character currCell, int neighbors) {
        return currCell.equals(DEAD) && neighbors == 3;
    }

    private boolean crowded(Character currCell, int neighbors) {
        return currCell.equals(ALIVE) && neighbors > 3;
    }

    private boolean lonely(Character currCell, int neighbors) {
        return currCell.equals(ALIVE) && neighbors < 2;
    }

    public int neighbors(int row, int col) {
        AtomicInteger liveCount = new AtomicInteger();
        Bounds bounds = getBounds(row, col);
        //System.out.format("Row %d,%d Col %d,%d\n", lowerRowBound, upperRowBound, lowerColBound, upperColBound);

        rangeClosed(bounds.lowerRowBound, bounds.upperRowBound)
                .forEach(x -> IntStream.rangeClosed(bounds.lowerColBound, bounds.upperColBound)
                        .filter(y -> x != row || y != col)
                        .filter(y -> grid[x][y].equals(ALIVE))
                        .forEach(y -> {
                            liveCount.getAndIncrement();
                            // System.out.format("%d,%d %s\n", x, y, grid[x][y]);
                        })
                );
        return liveCount.get();
    }

    private Bounds getBounds(int row, int col) {
        Bounds bounds = new Bounds();
        bounds.lowerRowBound = row > 0 ? row - 1 : 0;
        bounds.upperRowBound = row < grid.length - 1 ? row + 1 : grid.length - 1;
        bounds.lowerColBound = col > 0 ? col - 1 : 0;
        bounds.upperColBound = col < grid[row].length - 1 ? col + 1 : grid[row].length - 1;
        return bounds;
    }

    public int width() {
        return grid.length;
    }

    public int height() {
        return grid[0].length;
    }

    public Character[][] currentGrid() {
        return this.grid;
    }

    private class Bounds {
        public int lowerRowBound;
        public int upperRowBound;
        public int lowerColBound;
        public int upperColBound;
    }
}
