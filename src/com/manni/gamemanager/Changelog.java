package com.manni.gamemanager;

import javax.swing.*;
import java.awt.*;

public class Changelog extends JFrame {

    public Changelog() {
        setTitle("Changelog");
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        //Label
        JLabel lb_changelog = new JLabel("Changelog");

        //Layout
        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));

        pane.add(lb_changelog);
    }
}
