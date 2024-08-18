package br.com.coutsoft.screenmatch.view;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(String title) {
        this.setTitle(title);

        this.setSize(500, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
