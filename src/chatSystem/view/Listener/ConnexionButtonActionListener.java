package chatSystem.view.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import chatSystem.model.Personne;
import chatSystem.view.GuiChatSystem;
import chatSystem.view.GuiConnexion;

public class ConnexionButtonActionListener implements ActionListener {
    private final GuiConnexion guiConnexion;

    public ConnexionButtonActionListener(GuiConnexion guiConnexion) {
        this.guiConnexion = guiConnexion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pseudo = this.guiConnexion.getTextField().getText();
        if (pseudo.isEmpty()) return;

        this.guiConnexion.dispose();

        // TODO: Create a list of users from other sources


        List<Personne> users = new ArrayList<Personne>();
        users.add(new Personne("tom", "789670" ));
        users.add(new Personne("jerry", "789670" ));
        users.add(new Personne("tintin", "789670" ));
        users.add(new Personne("milou", "789670" ));
        users.add(new Personne("dupont", "789670" ));
        new GuiChatSystem(users);
    }

}
