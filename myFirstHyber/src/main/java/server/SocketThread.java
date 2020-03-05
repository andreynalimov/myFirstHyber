package server;

import main.MainThreadServer;
import models.UserMessage;
import services.UserService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;


public class SocketThread extends Thread {
    private Socket fromClientSocket;
    private String clientName;
    private String str;
    private String strSplitName;
    private String strSplitMsg;
    private String[] strSplit;

    BufferedReader br;
    PrintWriter pw;
    UserService userService;
    StringBuffer sb = new StringBuffer();

    public SocketThread(Socket fromClientSocket) throws IOException {
        this.fromClientSocket = fromClientSocket;
        this.clientName = this.getName();
        this.br = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
        this.pw = new PrintWriter(fromClientSocket.getOutputStream(), true);
        start();

    }

//    public void helloUser() {
//        for (SocketThread st : MainThreadServer.serverList) {
//            if (st.clientName.equals(this.clientName)) {
//                st.pw.println("Hello, your nick: " + this.clientName + "; message format: 'Nick: message'; ");
//
//            }
//
//        }
//
//    }

//    public void usersOnline() {
//        for (SocketThread st : MainThreadServer.serverList) {
//            sb.append(st.clientName + " ");
//
//        }
//        for (SocketThread st : MainThreadServer.serverList) {
//            st.pw.println("Online : " + sb.toString());
//
//        }
//
//    }

//    public void userRemove() {
//        Iterator<SocketThread> catIterator = MainThreadServer.serverList.iterator();
//        while (catIterator.hasNext()) {
//
//            SocketThread nextCat = catIterator.next();
//            if (nextCat.clientName.equals(this.clientName)) {
//                nextCat.interrupt();
//                catIterator.remove();
//            }
//        }
//    }

//    public void sendUserBye() {
//        for (SocketThread st : MainThreadServer.serverList) {
//            if (st.clientName.equals(this.clientName)) {
//                st.pw.println("bye client");
//
//            }
//        }
//    }



    @Override
    public void run() {
     // try {

        while (true) {

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (str.contains(":")) {
                if (MainThreadServer.serverList.containsKey(str)){
                    SocketThread st = (SocketThread) MainThreadServer.serverList.get(str);
                    st.pw.println("1");

                }

            } else {
                for (Map.Entry entry : MainThreadServer.serverList.entrySet()) {
                    SocketThread st = (SocketThread) entry.getValue();
                    st.pw.println("2");

                }

            }

        }

//            helloUser();
//            usersOnline();

     //       while (true) {
//                if (br == null){
//                    br.close();
//                    pw.close();
//                }
//
//                if (fromClientSocket.isClosed()) {
//                    fromClientSocket.close();
//                    br.close();
//                    pw.close();
//                }
//
//
//                str = br.readLine();
//                if (str.equals("exit")) {
//                    sendUserBye();
//                    userRemove();
//                    usersOnline();
//                    br.close();
//                    pw.close();
//
//                    break;
//                }
//
//                strSplit = str.split(":");
//                strSplitName = strSplit[0];
//                strSplitMsg = strSplit[1];
//                userService = new UserService();
//
//                for (SocketThread st : MainThreadServer.serverList) {
//                    if (st.clientName.equals(strSplitName)) {
//                        st.pw.println(this.clientName + ": " + strSplitMsg);
//
//                        UserMessage userMessage = new UserMessage(this.clientName, strSplitMsg, strSplitName);
//                        userService.saveUser(userMessage);
//
//                    } else if (strSplitName.equals("all")) {
//                        st.pw.println(this.clientName + ": " + str);
//
//                    }
//
//                }
//
//                if (strSplitName.equals("all")) {
//                    UserMessage userMessage = new UserMessage(this.clientName, strSplitMsg, "all");
//                    userService.saveUser(userMessage);
//
//                }
   //         }

//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
