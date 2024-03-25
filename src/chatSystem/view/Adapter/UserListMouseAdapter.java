package chatSystem.view.Adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import chatSystem.model.Personne;
import chatSystem.view.GuiChatSystem;
import chatSystem.view.GuiPrivateChat;

public class UserListMouseAdapter extends MouseAdapter {

    private JList<String> userList;
    private GuiChatSystem guiChatSystem;

    public UserListMouseAdapter(JList<String> userList, GuiChatSystem guiChatSystem) {
        this.userList = userList;
        this.guiChatSystem = guiChatSystem;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            Personne selectedUser = guiChatSystem.getUsers().get(userList.getSelectedIndex());
            // check if private list with sender exists
            if (!this.guiChatSystem.getPrivateChats().contains(selectedUser)) {
                var privateChat = new GuiPrivateChat(selectedUser);
                this.guiChatSystem.addPrivateChats(privateChat);
            }
        }
    }
}