package com.shammer.coaching.conway;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeFrame extends JFrame {

    public GameOfLifeFrame(GameOfLife gameEngine, int generations) throws HeadlessException {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new GameOfLifePanel(gameEngine, generations));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
