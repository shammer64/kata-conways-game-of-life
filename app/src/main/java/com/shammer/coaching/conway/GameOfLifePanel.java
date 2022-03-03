package com.shammer.coaching.conway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.util.stream.IntStream.range;

public class GameOfLifePanel extends JPanel implements ActionListener {

    private final GameOfLife gameEngine;
    private int PANEL_WIDTH = 500;
    private int PANEL_HEIGHT = 500;
    private int CELL_SIZE = 20;
    Timer timer;
    private int generation = 0;

    public GameOfLifePanel(GameOfLife gameEngine) {
        super();
        this.gameEngine = gameEngine;
        this.PANEL_WIDTH = gameEngine.width() * CELL_SIZE;
        this.PANEL_HEIGHT = gameEngine.height() * CELL_SIZE;
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        timer = new Timer(1000, this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Character[][] grid = gameEngine.currentGrid();
        range(0, grid.length)
                .forEach(row -> range(0, grid[row].length)
                        .forEach(col -> {
                            Character currCell = grid[row][col];
                            Color cellColor = currCell.equals(gameEngine.ALIVE) ? Color.RED : Color.WHITE;
                            g2D.setPaint(cellColor);
                            g2D.fillRect(row * CELL_SIZE, col * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        }));

        g2D.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        g2D.setPaint(Color.DARK_GRAY);
        g2D.drawString("Gen " + generation, 5, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameEngine.evolve();
        generation++;
        repaint();
    }
}
