package chatSystem.view;

import javax.swing.JFrame;

import chatSystem.model.MessagePrivate;
import chatSystem.view.ActionListener.PrivateSendMessageButtonActionListener;

import javax.swing.*;
import java.awt.*;

public class GuiPrivateChat extends JFrame {

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private String userName;
    private MessagePrivate message;

    public GuiPrivateChat(MessagePrivate message) {
        this.message = message;
        this.userName = message.getSender().getPseudo();
        createGUI();
    }

    private void createGUI() {
        // Setting up the JFrame
        setTitle("ChatPrivate " + userName);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Chat area
        chatArea = new JTextArea("chatArea");
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        add(chatScrollPane, BorderLayout.CENTER);

        // Bottom panel with message field and send button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        bottomPanel.add(messageField, BorderLayout.CENTER);

        sendButton = new JButton("btnsend");
        sendButton.addActionListener(new PrivateSendMessageButtonActionListener());
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Display the JFrame
        setVisible(true);
    }

}
