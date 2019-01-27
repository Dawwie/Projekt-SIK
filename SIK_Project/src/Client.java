import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

public class Client {
    public static void main(String[] args){
        //connection client with the server
        String hostName = "127.0.0.1";
        int port = 44444;
        String string;
        Socket clientSocket;
        PrintWriter out = null;
        BufferedReader in = null;
        InputStreamReader ir;

        try{
            clientSocket = new Socket(hostName, port);
            //Create our IO streams
            //PrintWriter() try to send information form client to the server
            out = new PrintWriter(clientSocket.getOutputStream(),true); //autoflush buffer
            ir = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(ir);
        }catch(UnknownHostException e){
            System.exit(1);
        }catch(IOException e){
            e.printStackTrace();
        }//end 1. try

        //logging
        try{
            string = "Gracz" + ThreadLocalRandom.current().nextInt(100, 300) + " został połączony";
            out.println(string);
        }catch(Exception e){
            e.printStackTrace();
        }//end 2. try

        //connection message
        try{
            System.out.println(in.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }//end 3. try

        //reading from the server
        try{
            string = in.readLine();
            while(true){
               System.out.println(string);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }//end main
}//end class
