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
    private String userName;
    private MessagePrivate message;

    public GuiPrivateChat(MessagePrivate message) {
        this.message = message;
        this.userName = message.getSender().getPseudo();
        createGUI();
    }

    public GuiPrivateChat(Personne personne) {
        this.userName = personne.getPseudo();
        createGUI();
    }

    private void createGUI() {
        // Setting up the JFrame
        setTitle("ChatPrivate " + userName);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Chat area
        chatArea = new JTextArea("Chat with " + userName + ":\n");
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
        return userName;
    }

    public MessagePrivate getMessage() {
        return message;
    }

    public void setMessage(MessagePrivate message) {
        this.message = message;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        this.chatArea.append(this.userName + " : " + message + "\n");
    }

    public void close() {
        this.dispose();
    }



}
