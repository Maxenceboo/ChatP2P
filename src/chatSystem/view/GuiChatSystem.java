package chatSystem.view;

import javax.swing.*;


import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import chatSystem.controller.Controller;
import chatSystem.model.Personne;
import chatSystem.view.Adapter.UserListMouseAdapter;
// import chatSystem.view.Listener.SendmessageButtonActionListerner; // Commented out as it's related to sendButton

public class GuiChatSystem extends JFrame {

    private JTextArea chatArea;
    private JList<String> userList;
    private List<Personne> users;
    // private JButton sendButton; // Removed sendButton
    // private JTextField userInputField; // Removed userInputField
    private List<GuiPrivateChat> privateChats = new ArrayList<>();
    private Controller controller;
    private Personne me;
    private BufferedReader reader;
    private BufferedWriter writer;

    public GuiChatSystem(Personne user, BufferedReader reader, BufferedWriter writer) {
        this.me = user;
        this.reader = reader;
        this.writer = writer;
        this.controller = new Controller(this);
        this.users = this.controller.getUsers();
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
        userList.addMouseListener(new UserListMouseAdapter(this)); // Add a mouse listener to the user list
        JScrollPane userScrollPane = new JScrollPane(userList);
        userScrollPane.setPreferredSize(new Dimension(100, 0));
        getContentPane().add(userScrollPane, BorderLayout.EAST);

        // Commenting out the entire section related to userInputField and sendButton as they are removed
        /*
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
        */

        this.controller.sendBroadcastMessage("Hello, I'm " + me.getPseudo());

        // Display the JFrame
        setVisible(true);

        //  send broadcast message
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

    public Personne getMe() {
        return me;
    }

    public void setMe(Personne me) {
        this.me = me;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }


    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setUsers(List<Personne> users) {
        this.users = users;
    }

    public void setChatArea(JTextArea chatArea) {
        this.chatArea = chatArea;
    }

    public void setUserList(JList<String> userList) {
        this.userList = userList;
    }



}
