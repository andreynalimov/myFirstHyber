package chatprom;

import java.io.IOException;
import java.net.Socket;

public class ThreadClient {
    public static void main(String[] args) throws IOException {
        int portNumber = 1777;

        String str;

        System.out.println("client start");

        Socket socket = new Socket("localhost", 1777);

        new ClientThreadRead(socket);
        new ClientThreadWrite(socket);

    }


}