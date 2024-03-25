package chatSystem.controller;

import chatSystem.model.Message;
import chatSystem.model.MessagePrivate;
import chatSystem.model.Personne;
import chatSystem.view.GuiChatSystem;
import chatSystem.view.GuiPrivateChat;

public class controller {
    private GuiChatSystem guiChatSystem;

    public controller(GuiChatSystem guiChatSystem) {
        this.guiChatSystem = guiChatSystem;
    }

    public void messageReceived(Message message) {
        if (!this.guiChatSystem.getUsers().contains(message.getSender())) return;
        this.guiChatSystem.getChatArea().append(message.toString() + "\n");
    }

    public void messageReceived(MessagePrivate message) {
        if (!this.guiChatSystem.getUsers().contains(message.getSender())) return;

        // check if private list with sender exists 
        if (!this.guiChatSystem.getPrivateChats().contains(message.getSender())) {
            this.guiChatSystem.addPrivateChats(new GuiPrivateChat(message));
        }
        var privateChat = this.guiChatSystem.getPrivateChats().get(this.guiChatSystem.getPrivateChats().indexOf(message.getSender()));

        this.guiChatSystem.getChatArea().append(message.toString() + "\n");
    }

    public void sendMessage(String message) {
        // send to other user
        this.guiChatSystem.getChatArea().append("Me : " + message + "\n");
    }
}
