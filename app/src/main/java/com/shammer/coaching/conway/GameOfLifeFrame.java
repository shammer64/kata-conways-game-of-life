package com.shammer.coaching.conway;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeFrame extends JFrame {

    private final JPanel panel;

    public GameOfLifeFrame(GameOfLife gameEngine) throws HeadlessException {
        super();
        panel = new GameOfLifePanel(gameEngine);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
