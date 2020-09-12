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
        JLabel lb_changelog_20200912 = new JLabel("12.09.2020 --> Fertige Implemetierung von Snake");

        //Layout
        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(lb_changelog_20200912);
    }
}
