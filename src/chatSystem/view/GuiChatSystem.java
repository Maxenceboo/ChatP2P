package chatSystem.view;

import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import chatSystem.model.Personne;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiChatSystem extends JFrame {

    private JTextArea chatArea;
    private JList<String> userList;
    private List<Personne> users;
    private JButton sendButton;
    private JTextField userInputField;
    private List<GuiPrivateChat> privateChats = new ArrayList<>();

    public GuiChatSystem(List<Personne> users) {
        this.users = users;
        createGUI();
    }

    private void createGUI() {

        // Setting up the JFrame
        setTitle("Chat Application");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        getContentPane().add(chatScrollPane, BorderLayout.CENTER);

        // User list
        DefaultListModel<String> userListModel = new DefaultListModel<>();

        users.forEach(user -> userListModel.addElement(user.getPseudo()));

        userList = new JList<>(userListModel);
        userList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selectedUser = userList.getSelectedValue();
                    // Handle the double-click event on the user here
                    JOptionPane.showMessageDialog(GuiChatSystem.this,
                            "BOo :" + selectedUser);
                }
            }
        });
        JScrollPane userScrollPane = new JScrollPane(userList);
        userScrollPane.setPreferredSize(new Dimension(100, 0));
        getContentPane().add(userScrollPane, BorderLayout.EAST);

        // Message field
        userInputField = new JTextField();
        getContentPane().add(userInputField, BorderLayout.SOUTH);

        // Send button
        sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(userInputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        // Display the JFrame
        setVisible(true);
    }

    private void sendMessage() {
        String message = userInputField.getText();
        if (!message.isEmpty()) {
            chatArea.append("You: " + message + "\n");
            userInputField.setText("");
        }
    }

    public void receiveMessage(String sender, String message) {
        chatArea.append(sender + ": " + message + "\n");
    }

    public void addUser(Personne user) {
        DefaultListModel<String> userListModel = (DefaultListModel<String>) userList.getModel();
        userListModel.addElement(user.getPseudo());
    }

    public void removeUser(Personne user) {
        DefaultListModel<String> userListModel = (DefaultListModel<String>) userList.getModel();
        userListModel.removeElement(user.getPseudo());
        users.remove(user);
    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    public JList<String> getUserList() {
        return userList;
    }

    public List<Personne> getUsers() {
        return users;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public JTextField getUserInputField() {
        return userInputField;
    }

    public List<GuiPrivateChat> getPrivateChats() {
        return privateChats;
    }

    public void setPrivateChats(List<GuiPrivateChat> privateChats) {
        this.privateChats = privateChats;
    }

    public void addPrivateChats(GuiPrivateChat privateChat){
        this.privateChats.add(privateChat);
    }

    public void removePrivateChats(GuiPrivateChat privateChat){
        this.privateChats.remove(privateChat);
    }

}