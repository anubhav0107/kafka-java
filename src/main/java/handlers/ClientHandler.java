package handlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler {

    Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void handle() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            System.out.println("Inside Handler\n");
            in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            out = new PrintWriter(this.clientSocket.getOutputStream());
//            StringBuilder request = new StringBuilder();
//            int c;
//            while ((c = in.read()) != -1) {
//                request.append((char) c);
//            }

            out.write(new char[]{0, 0, 0, 0, 0, 0, 0, 7});
            out.flush();
            out.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
