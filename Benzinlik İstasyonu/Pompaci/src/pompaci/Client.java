// A Java program for a Client
package pompaci;

import java.net.*;
import java.io.*;

public class Client {
    // initialize socket and input output streams

    private Socket socket = null;
    private DataOutputStream out = null;
    private boolean connected = false;

    // constructor to put ip address and port
    public Client() {
        try {
            socket = new Socket("127.0.0.1", 123);
            System.out.println("Connected");
            connected = true;
            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessages(String message) {
        // establish a connection
        try {
            out.writeUTF(message);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (message != null) {
            System.out.println("Message sent to the server : " + message);
        }
        closeConnection();
    }

    public boolean isConnected() {
        return connected;
    }

    public void closeConnection() {
        try {
            socket.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
