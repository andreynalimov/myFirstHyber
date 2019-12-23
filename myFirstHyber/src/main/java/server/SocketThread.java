package chatprom;



import models.UserMessage;
import services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;

import static chatprom.ThreadServer.serverList;

public class SocketThread extends Thread {
            private Socket fromClientSocket;
            private String clientName;
            private String str;
            private String strSplitName;
            private String strSplitMsg;
            private String[] strSplit;

            BufferedReader br ;
            PrintWriter pw ;

    public SocketThread(Socket fromClientSocket) throws IOException {
                    this.fromClientSocket = fromClientSocket;
                    this.clientName = this.getName();
                    this.br = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
                    this.pw = new PrintWriter(fromClientSocket.getOutputStream(),true);
                    start();

            }

            @Override
            public void run (){
                StringBuffer sb = new StringBuffer();
                try {
                    for (SocketThread st : ThreadServer.serverList) {
                        if (st.clientName.equals(this.clientName)){
                            st.pw.println("Hello, your nick: " + this.clientName);

                        }
                        sb.append(st.clientName + " ");

                    }

                    for (SocketThread st : ThreadServer.serverList) {
                         st.pw.println("Online : " + sb.toString());
                    }

                    while (true){
                        str = br.readLine();
                        if(str.equals("exit")) {
                            for (SocketThread st : ThreadServer.serverList) {
                                if (st.clientName.equals(this.clientName)) {
                                    st.pw.println("bye client");

                                }
                            }
                                fromClientSocket.close();
                                br.close();
                                pw.close();

                                Iterator<SocketThread> catIterator = serverList.iterator();
                                while(catIterator.hasNext()) {

                                    SocketThread nextCat = catIterator.next();
                                    if (nextCat.clientName.equals(this.clientName)) {
                                        nextCat.interrupt();
                                        catIterator.remove();
                                    }
                                }
                                break;
                            }

                        strSplit = str.split(":");
                        strSplitName = strSplit[0];
                        strSplitMsg = strSplit[1];
                        UserService userService = new UserService();



                            for (SocketThread st : ThreadServer.serverList) {
                                if (st.clientName.equals(strSplitName)){
                                    st.pw.println(this.clientName + ": " + strSplitMsg);


                                    UserMessage userMessage = new UserMessage(this.clientName, strSplitMsg, strSplitName);
                                    userService.saveUser(userMessage);


                                } else if (strSplitName.equals("all")){
                                    st.pw.println(this.clientName + ": " + str);

                                    UserMessage userMessage = new UserMessage(this.clientName, str, "all");
                                    userService.saveUser(userMessage);



                                }
                            }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


}
