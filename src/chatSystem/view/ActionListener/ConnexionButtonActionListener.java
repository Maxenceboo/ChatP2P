package chatSystem.view.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import chatSystem.model.Personne;
import chatSystem.view.GuiChatSystem;
import chatSystem.view.GuiConnexion;

public class ConnexionButtonActionListener implements ActionListener {
    private GuiConnexion guiConnexion;

    public ConnexionButtonActionListener(GuiConnexion guiConnexion) {
        this.guiConnexion = guiConnexion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pseudo = this.guiConnexion.getTextField().getText();
        if (pseudo.length() > 0) {
            this.guiConnexion.dispose();
            // request the user to enter a pseudo in the chat system
            
            
            List<Personne> users = new ArrayList<Personne>();
            new GuiChatSystem(users);
        }
    }

}
