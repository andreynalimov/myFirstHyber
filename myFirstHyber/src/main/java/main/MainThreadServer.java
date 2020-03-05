package main;

import server.SocketThread;
import server.UserServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class MainThreadServer {

    //public static List<SocketThread> serverList = Collections.synchronizedList(new ArrayList<SocketThread>());
      public static Map<String,SocketThread> serverList = new HashMap<>();


    public static void main(String[] args) {
        int port = 1777;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            String str;

            while (true) {
                System.out.println("Waiting for a connection on " + port);
                Socket fromClient = serverSocket.accept();
                //SocketThread socketThread = new SocketThread(fromClient);
                //serverList.add(new SocketThread(fromClient));
                BufferedReader br = new BufferedReader(new InputStreamReader(fromClient.getInputStream()));
                PrintWriter pw = new PrintWriter(fromClient.getOutputStream(), true);

                pw.println("Hello, input your nick");

                str = br.readLine();
                UserServer userServer = new UserServer(str);

                serverList.put(userServer.getUsername(),new SocketThread(fromClient));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
