/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Otomasyon;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mustafa
 */
public class ServerApp {

    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private String message = null;

    public ServerApp() {
        Thread xx = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server = new ServerSocket(123);
                    System.out.println("Server started");

                    System.out.println("Waiting for a client ...");

                    System.out.println("Client accepted");

                    // takes input from the client socket
                    String line = "";

                    // reads message from client until "Over" is sent
                    while (!line.equals("Over")) {
                        socket = server.accept();
                        in = new DataInputStream(
                                new BufferedInputStream(socket.getInputStream()));
                        try {
                            line = in.readUTF();
                            System.out.println(line);
                            message = line;
                        } catch (IOException i) {
                            System.out.println(i);
                        }
                    }
                    System.out.println("Closing connection");

                    // close connection
                    socket.close();
                    in.close();
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
        });
        xx.start();
    }
   
    public String getMessage()
    {
        return message;
    }
}
