/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.shammer.coaching.conway;

import javax.swing.*;

import java.util.Random;

import static java.util.stream.IntStream.range;

public class App {

    public static final String ARGS_MSG = "Up to three positive integer args are expected: rows, columns and generations to run";

    public static void main(String[] args) {
        int rows = 80;
        int cols = 50;
        int generations = 500;
        try {
            if (args.length >= 1)
                rows = Integer.parseInt(args[0]);
            if (args.length >= 2)
                cols = Integer.parseInt(args[1]);
            if (args.length >= 3)
                generations = Integer.parseInt(args[2]);
            if (rows <= 0 || cols <= 0 || generations <= 0) throw new IllegalArgumentException(ARGS_MSG);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ARGS_MSG, e);
        }

        // generate random starting grid
        Character[][] initialGameGrid = generateRandomGrid(rows, cols);
        JFrame frame = new GameOfLifeFrame(new GameOfLife(initialGameGrid), generations);
    }

    private static Character[][] generateRandomGrid(int rows, int cols) {
        Character[][] grid = new Character[rows][cols];
        range(0, grid.length)
                .forEach(row -> range(0, grid[row].length)
                        .forEach(col -> {
                            double rnd = Math.random();
                            grid[row][col] = rnd > 0.5 ? GameOfLife.ALIVE : GameOfLife.DEAD;
                        }));
        return grid;
    }
}
