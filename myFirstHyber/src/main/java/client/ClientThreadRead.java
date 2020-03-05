package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThreadRead extends Thread {

    private Socket socket;

    private Socket socket1;

    public ClientThreadRead(Socket socket) throws IOException {
        this.socket = socket;
        start();

    }

    @Override
    public void run() {

        String str;

        try {
            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                str = br.readLine();
                if (str.equals("bye client")) {
                    System.out.println(str);
                    br.close();
                    //socket.close();


                    break;
                }

                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);

        }
    }


}