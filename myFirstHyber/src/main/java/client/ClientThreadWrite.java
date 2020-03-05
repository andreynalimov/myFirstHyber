package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThreadWrite extends Thread {
    private Socket socket;

    public ClientThreadWrite(Socket socket) {
        this.socket = socket;
        start();

    }


    @Override
    public void run() {
        String userWord;
        try {
            BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);


            while (true) {
                userWord = inUser.readLine();
                pw.println(userWord);

                if (userWord.equals("exit")) {
                    inUser.close();
                    pw.close();
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}



