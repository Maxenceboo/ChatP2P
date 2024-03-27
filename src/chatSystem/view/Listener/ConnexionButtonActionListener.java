package chatSystem.view.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

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
        if (pseudo.isEmpty())
            return;

        this.guiConnexion.dispose();

        String ip = "10.8.3.208";
        try (Socket socket = new Socket(ip, 12345)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new GuiChatSystem(new Personne(this.guiConnexion.getTextField().getText(), ip), reader, writer);
            // socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error de merde: " + ex.getMessage());
        }
    }

}
