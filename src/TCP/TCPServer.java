package TCP;

import java.io.*;
import java.net.*;

public class TCPServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedWriter out;
    private BufferedReader in;

    public TCPServer(int port) throws IOException {
        this.start(port);
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started. Waiting for clients...");

        clientSocket = serverSocket.accept();
        System.out.println("Client connected.");
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        this.startReadingThread();
        // read message from client, message is the ip and port of the client
        while (true) {
            String message = in.readLine();
            if (message != null) {
                System.out.println("Message received: " + message);
            }
            
        }
    }

    public void startReadingThread() {
        Thread readThread = new Thread(() -> {
            System.out.println("Reading thread started");
            String receivedMessage;
            try {
                while ((receivedMessage = in.readLine()) != null) {
                    System.out.println("Client: " + receivedMessage);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        readThread.start();
    }

    // send message to one other client with ip and port
    public void sendMessage(String ip, int port, String message) throws IOException {
        Socket socket = new Socket(ip, port);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        out.write(message);
        out.close();
        socket.close();
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
