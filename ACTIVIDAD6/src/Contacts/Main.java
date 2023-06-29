package Contacts;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
            JFrame frame = new JFrame("Contacts");
            frame.setContentPane(new Ventana().PanlePrincipal);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

    }
}