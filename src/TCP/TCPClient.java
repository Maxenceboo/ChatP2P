package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    private Socket socket;
    // private PrintWriter out;
    private BufferedReader in;

    public TCPClient() {
    }

    public void connectToServer(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        // out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendMessage(String msg) {
        System.out.println("Client sending: " + msg);
        // out.println(msg);
    }

    public void stopConnection() throws IOException {
        in.close();
        // out.close();
        socket.close();
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
