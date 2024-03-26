package chatSystem.view;

import javax.swing.JFrame;

import chatSystem.model.MessagePrivate;
import chatSystem.model.Personne;
import chatSystem.view.Listener.PrivateSendMessageButtonActionListener;

import javax.swing.*;
import java.awt.*;

public class GuiPrivateChat extends JFrame {

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private Personne me;
    private Personne otherUser;

    public GuiPrivateChat(MessagePrivate message) {
        this.me = message.getReceiver();
        this.otherUser = message.getSender();
        this.chatArea.append(this.otherUser.getPseudo() + " : " + message.getMessage() + "\n");
        createGUI();
    }

    public GuiPrivateChat(Personne personne) {
        this.otherUser = personne;
        createGUI();
    }

    private void createGUI() {
        // Setting up the JFrame
        setTitle("ChatPrivate " + otherUser.getIp());
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Chat area
        chatArea = new JTextArea("Chat with " + otherUser.getPseudo() + ":\n");
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        add(chatScrollPane, BorderLayout.CENTER);

        // Bottom panel with message field and send button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        bottomPanel.add(messageField, BorderLayout.CENTER);

        sendButton = new JButton("Send");
        sendButton.addActionListener(new PrivateSendMessageButtonActionListener(this));
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Display the JFrame
        setVisible(true);
    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    public JTextField getMessageField() {
        return messageField;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public String getUserName() {
        return otherUser.getPseudo();
    }

    public void setUserName(String userName) {
        this.otherUser.setPseudo(userName);
    }

    public void setChatArea(JTextArea chatArea) {
        this.chatArea = chatArea;
    }

    public void setMessageField(JTextField messageField) {
        this.messageField = messageField;
    }

    public void setSendButton(JButton sendButton) {
        this.sendButton = sendButton;
    }

    public void sendMessage(String message) {
        this.chatArea.append("Me : " + message + "\n");
    }

    public void receiveMessage(String message) {
        this.chatArea.append(this.otherUser.getPseudo() + " : " + message + "\n");
    }

    public void close() {
        this.dispose();
    }


}
