package chatSystem.controller;

import chatSystem.model.Message;
import chatSystem.model.MessagePrivate;
import chatSystem.view.GuiChatSystem;
import chatSystem.view.GuiPrivateChat;

public class Controller {
    private GuiChatSystem guiChatSystem;

    public Controller(GuiChatSystem guiChatSystem) {
        this.guiChatSystem = guiChatSystem;
    }

    public void messageReceived(Message message) {
        if (!this.guiChatSystem.getUsers().contains(message.getSender())) return;
        this.guiChatSystem.getChatArea().append(message.toString() + "\n");
    }

    @SuppressWarnings("unlikely-arg-type")
    public void messageReceived(MessagePrivate message) {
        if (!this.guiChatSystem.getUsers().contains(message.getSender())) return;

        // check if private list with sender exists 
        if (!this.guiChatSystem.getPrivateChats().contains(message.getSender())) {
            this.guiChatSystem.addPrivateChats(new GuiPrivateChat(message));
        }
        GuiPrivateChat privateChat = this.guiChatSystem.getPrivateChats().get(this.guiChatSystem.getPrivateChats().indexOf(message.getSender()));

        privateChat.getChatArea().append(message.toString() + "\n");
    }

    public void sendMessage(String message) {
        // send to other user
        this.guiChatSystem.getChatArea().append("Me : " + message + "\n");
    }
}
