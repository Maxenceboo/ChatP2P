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
        // TODO Auto-generated method stub
    } 
}
