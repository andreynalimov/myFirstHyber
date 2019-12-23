package chatprom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadServer {

    public static List<SocketThread> serverList =  Collections.synchronizedList(new ArrayList<SocketThread>());

    public static void main(String[] args) {
        int port = 1777;


        try {
            ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for a connection on " + port);
            Socket fromClient = serverSocket.accept();


                serverList.add(new SocketThread(fromClient));

        }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
