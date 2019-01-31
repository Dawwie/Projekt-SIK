import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;


//this class pass the clientsocket() information
//and then RunnableServer know how to communicate with the client
public class RunnableServer<players> implements Runnable{
    protected Socket clientSocket;
    BufferedReader in = null;
    PrintWriter out = null;
    Player newPlayer = new Player();


    public RunnableServer(Socket clientSocket){//there we store the information about clientsocket
        this.clientSocket = clientSocket;
    }// end RunnableServer()
    public void run(){//this method would be facilitates connection with the client
        try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//There we passed into Buffer new InputStream, that we got from clientSocket
            out = new PrintWriter(clientSocket.getOutputStream(),true); //There server sending information to client
        }catch(IOException e){
            e.printStackTrace();
        }//end 1. try

        try{
            System.out.println(in.readLine() + "\n");
            newPlayer.setId(SocketServer.clients - 1);
            newPlayer.setScore(0);
            newPlayer.setPoints(0);
            SocketServer.players.put(newPlayer.getId(),newPlayer);
            out.println("Połączono z serwerem");
        }catch(IOException e){
            e.printStackTrace();
        }//end 2. try
        while(!SocketServer.allPlayers) {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //zrobic id i kostki
        try {
            out.println("START " + newPlayer.getId() + " " + SocketServer.random);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            out.println("-------------------------");
        }catch(Exception e){
            e.printStackTrace();
        }
    }// end run()

}
