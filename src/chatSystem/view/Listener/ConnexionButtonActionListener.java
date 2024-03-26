package chatSystem.view.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.Buffer;

import TCP.TCPClient;
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

        
        TCPClient client = new TCPClient();
        client.connectToServer("localhost", 1234);
        Socket socket = new Socket("localhost", 1234);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        new GuiChatSystem(new Personne(this.guiConnexion.getTextField().getText(), "" + (int) (Math.random() * 1000)), reader, writer);
    }

}
