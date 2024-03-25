package chatSystem.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;

import chatSystem.controller.Controller;
import chatSystem.model.Personne;
import chatSystem.view.Adapter.UserListMouseAdapter;
import chatSystem.view.Listener.SendmessageButtonActionListerner;

public class GuiChatSystem extends JFrame {

    private JTextArea chatArea;
    private JList<String> userList;
    private List<Personne> users;
    private JButton sendButton;
    private JTextField userInputField;
    private List<GuiPrivateChat> privateChats = new ArrayList<>();
    private final Controller controller;

    public GuiChatSystem(List<Personne> users) {
        this.users = users;
        this.controller = new Controller(this);
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
        userList.addMouseListener(new UserListMouseAdapter(userList, this));
        JScrollPane userScrollPane = new JScrollPane(userList);
        userScrollPane.setPreferredSize(new Dimension(100, 0));
        getContentPane().add(userScrollPane, BorderLayout.EAST);

        // Message field
        userInputField = new JTextField();
        getContentPane().add(userInputField, BorderLayout.SOUTH);

        // Send button
        sendButton = new JButton("Send");
        sendButton.addActionListener(new SendmessageButtonActionListerner(this));
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(userInputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        // Display the JFrame
        setVisible(true);
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

    public Controller getController() {
        return controller;
    }

}