package chatSystem.view.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chatSystem.model.Message;
import chatSystem.view.GuiChatSystem;

public class SendmessageButtonActionListerner implements ActionListener{
    private GuiChatSystem guiChatSystem;
    
    public SendmessageButtonActionListerner(GuiChatSystem guiChatSystem) {
        this.guiChatSystem = guiChatSystem;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Send message to other user
        //get the message from the user input field
        String message = guiChatSystem.getUserInputField().getText();
        //send the message to the controller
        guiChatSystem.getController().sendMessage(new Message(message, guiChatSystem.getMe()));        
    } 
}
