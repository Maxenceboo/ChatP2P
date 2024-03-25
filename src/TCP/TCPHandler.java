package TCP;

import java.io.*;
import java.net.*;

public class TCPHandler implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public TCPHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            // Handle incoming messages
            String message;
            while ((message = reader.readLine()) != null) {
                // Process the message
                processMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the socket and streams
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processMessage(String message) {
        // Implement your message processing logic here
        // For example, you can broadcast the message to other connected clients
        // or handle specific commands

        // TODO: Implement message processing logic
    }
}