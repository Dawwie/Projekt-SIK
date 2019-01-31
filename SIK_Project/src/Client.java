import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

public class Client {
    public static void main(String[] args){
        //connection client with the server
        String hostName = "127.0.0.1";
        int port = 44444;
        String string= "";
        Socket clientSocket;
        PrintWriter out = null;
        BufferedReader in = null;
        InputStreamReader ir;
        ClientBoard board = new ClientBoard();
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
            out.println("LOGIN Player" + ThreadLocalRandom.current().nextInt(100, 300) + " is connected");
            while(true){
                string = in.readLine();
                System.out.println(string);
                if(string.startsWith("START")){
                    string = in.readLine();
                    System.out.println(string);
                }
                if(string.startsWith("PLANSZA")){
                    string = in.readLine();
                    System.out.println(string);
                    String[] parts = string.split(" ");
                    board.playerId[Integer.parseInt(parts[1])-1][Integer.parseInt(parts[2])-1] = Integer.parseInt(parts[3]);
                    board.cubes[Integer.parseInt(parts[1])-1][Integer.parseInt(parts[2])-1] = Integer.parseInt(parts[4]);


                }

            }

        }catch(Exception e){
            e.printStackTrace();
        }//end 2. try

    }//end main
}//end class
