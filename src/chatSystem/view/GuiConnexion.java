package chatSystem.view;

import javax.swing.*;

import chatSystem.view.Listener.ConnexionButtonActionListener;

import java.awt.*;

public class GuiConnexion extends JFrame {

    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JButton button;


    public GuiConnexion() {
        this.init();
    }

    public void init() {
        this.panel = new JPanel();
        this.label = new JLabel("Entrez votre pseudo : ");
        this.textField = new JTextField();
        this.button = new JButton("Connexion");

        this.panel.setLayout(new GridLayout(3, 1));
        this.panel.add(this.label);
        this.panel.add(this.textField);
        this.panel.add(this.button);

        this.add(this.panel);
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        // add action listener to the button
        this.button.addActionListener(new ConnexionButtonActionListener(this));
    }

    public JButton getButton() {
        return this.button;
    }

    public JTextField getTextField() {
        return this.textField;
    }


}
