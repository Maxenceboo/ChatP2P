package TCP;

import java.io.*;
import java.net.*;

public class TCPServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public TCPServer(int port) throws IOException {
        this.start(port);
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started. Waiting for clients...");

        clientSocket = serverSocket.accept();
        System.out.println("Client connected.");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Client: " + inputLine);
        }
    }

    // send message to one other client with ip and port
    public void sendMessage(String ip, int port, String message) throws IOException {
        Socket socket = new Socket(ip, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);
        out.close();
        socket.close();
    }

    // send message to all clients
    public void broadcastMessage(String message) {
        // send message hello and ip and port to all clients
        out.println(clientSocket.getInetAddress().getHostAddress() + ", " + message); // its adress of the client who sent the message to the server
    }


    public void sendHello() {
        out.println("Hello");
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    // Supprimer après intégration de la fenêtre
    public static void main(String[] args) throws IOException {
        new TCPServer(12345);        
    }
}
