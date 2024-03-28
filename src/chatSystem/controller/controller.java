package chatSystem.controller;

import chatSystem.model.Message;
import chatSystem.view.GuiChatSystem;
import chatSystem.view.GuiPrivateChat;
import chatSystem.model.Personne;
import chatSystem.utils.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;




public class Controller {
    private GuiChatSystem guiChatSystem;

    public Controller(GuiChatSystem guiChatSystem) {
        this.guiChatSystem = guiChatSystem;
    }

    public void threadMessageReceived() {
        BufferedReader in = this.guiChatSystem.getReader();
        // thread message received
        @SuppressWarnings("unlikely-arg-type")
        Thread readThread = new Thread(() -> {
            String receivedMessage;
            Message messagePrivate;
            GuiPrivateChat guiPrivateChat;
            Personne hello;
            try {
                while ((receivedMessage = in.readLine()) != null) {
                    System.out.println("Client: " + receivedMessage);
                    if ((messagePrivate = utils.parseMessage(receivedMessage)) != null) {
                        //check if guiPrivateChat exist
                        if (!this.guiChatSystem.getPrivateChats().contains(messagePrivate.getSender())) {
                            // new GuiPrivateChat(selectedUser)
                            guiPrivateChat = new GuiPrivateChat(messagePrivate.getSender(), this.guiChatSystem);
                            guiPrivateChat.addMessage(messagePrivate.toString() + "\n");
                            this.guiChatSystem.addPrivateChats(guiPrivateChat);
                        }else {
                            // get the GuiPrivateChat
                            guiPrivateChat = this.guiChatSystem.getPrivateChats().get(this.guiChatSystem.getPrivateChats().indexOf(messagePrivate.getSender()));
                            guiPrivateChat.getChatArea().append(messagePrivate.getSender().getPseudo() + " : " + messagePrivate.getMessage() + "\n");
                        }
                        
                    }

                }
                if ((hello = utils.parseHello(receivedMessage,guiChatSystem)) != null) {
                    // add to list
                    this.guiChatSystem.addUsers(hello);
                    this.guiChatSystem.addUsersJList(hello);

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        readThread.start();
    }



    public void sendBroadcastMessage(String message) {
        // send to other user
        // this.guiChatSystem.getChatArea().append("Me : " + message + "\n");
        try {
            // this.guiChatSystem.getWriter() its a BufferedWriter
            this.guiChatSystem.getWriter().write(message);
            this.guiChatSystem.getWriter().newLine();
            this.guiChatSystem.getWriter().flush();

        } catch (IOException e) {
            // Handle the IOException here
            e.printStackTrace();
        }
    }

    public void sendHello() {
        // send hello message
        try {
            this.guiChatSystem.getWriter().write(utils.createHello(this.guiChatSystem.getMe()));
            this.guiChatSystem.getWriter().newLine();
            this.guiChatSystem.getWriter().flush();
        } catch (IOException e) {
            // Handle the IOException here
            e.printStackTrace();
        }
    }

    public void sendMessage(Message message) {
        // send message unicast to personne
        try (Socket socket = new Socket(message.getSender().getIp(), 12345)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            writer.write(message.toString());
            writer.newLine();
            writer.flush();
            // socket.close();
        } catch (IOException e) {
            // Handle the IOException here
            e.printStackTrace();
        }
        
        
        
    }

}
