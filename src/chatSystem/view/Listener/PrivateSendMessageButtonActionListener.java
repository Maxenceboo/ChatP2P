package chatSystem.view.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chatSystem.view.GuiPrivateChat;

public class PrivateSendMessageButtonActionListener implements ActionListener {
    private GuiPrivateChat guiPrivateChat;
    
    public PrivateSendMessageButtonActionListener(GuiPrivateChat guiPrivateChat) {
        this.guiPrivateChat = guiPrivateChat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        guiPrivateChat.getChatArea().append("Me : " + guiPrivateChat.getMessageField().getText() + "\n");

        // TODO send message to other user (controller)

    }
}
