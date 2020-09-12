package com.manni.gamemanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.manni.snake.*;

public class Gamemanager extends JFrame {

    String version = "0.1";
    String[] comboBoxList = {
            "Snake",
            "Coming soon"
    };

    int selectedGameIndex;

    public Gamemanager() {
        setTitle("GameManager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        setLocationRelativeTo(null);

        //Label
        JLabel lb_welcome = new JLabel("Herzlich Wilkommen");
        JLabel lb_version = new JLabel("2D-Spielesammlung Version: " + version);
        JLabel lb_empty = new JLabel(" ");
        JLabel lb_empty2 = new JLabel(" ");
        JLabel lb_empty3 = new JLabel(" ");
        JLabel lb_selectGame = new JLabel("Wählen Sie das Spiel:");

        lb_selectGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        lb_empty.setAlignmentX(Component.CENTER_ALIGNMENT);
        lb_empty2.setAlignmentX(Component.CENTER_ALIGNMENT);
        lb_empty3.setAlignmentX(Component.CENTER_ALIGNMENT);
        lb_welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lb_version.setAlignmentX(Component.CENTER_ALIGNMENT);


        //JMenu
        JMenuBar jMenuBar = new JMenuBar();
        JMenu settingsJMenu = new JMenu("Einstellungen");
        JMenuItem changelogJMenuItem = new JMenuItem("Changelog");
        JMenuItem exitJMenuItem = new JMenuItem("Exit");

        exitJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        changelogJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Changelog changelog = new Changelog();
                changelog.setVisible(true);
            }
        });

        settingsJMenu.add(changelogJMenuItem);
        settingsJMenu.add(exitJMenuItem);
        jMenuBar.add(settingsJMenu);
        setJMenuBar(jMenuBar);

        //ComboBox
        JComboBox gameSelectionJComboBox = new JComboBox(comboBoxList);
        gameSelectionJComboBox.setMaximumSize(gameSelectionJComboBox.getPreferredSize());


        //Button
        JButton button_gameStart = new JButton("Spiel starten");
        button_gameStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedGameIndex = gameSelectionJComboBox.getSelectedIndex();
                switch (selectedGameIndex) {
                    case 0:
                        EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                //Snake snakeGame = new Snake();
                                //snakeGame.setVisible(true);
                            }
                        });
                        break;
                    default:
                        System.out.println("Mehr Spiele folgen bald");
                        break;
                }
            }
        });
        button_gameStart.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Layout
        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(lb_welcome);
        pane.add(lb_version);
        pane.add(lb_version);
        pane.add(lb_empty);
        pane.add(lb_empty);
        pane.add(lb_selectGame);
        pane.add(lb_empty2);
        pane.add(gameSelectionJComboBox);
        pane.add(lb_empty3);
        pane.add(button_gameStart);

    }
}
