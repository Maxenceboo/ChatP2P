package TCP;


import java.io.BufferedWriter;

import chatSystem.view.GuiChatSystem;

public class TCPhandler {

    // send broadcast message to all clients
    public static void broadcastMessage(GuiChatSystem guiChatSystem,String message, BufferedWriter out) {
        // send message hello and ip and port to all clients
        // out.println(clientSocket.getInetAddress().getHostAddress() + ", " + message); // its adress of the client who sent the message to the server
    }

}
