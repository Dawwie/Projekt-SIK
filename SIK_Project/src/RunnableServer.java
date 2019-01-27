import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//this class pass the clientsocket() information
//and then RunnableServer know how to communicate with the client
public class RunnableServer implements Runnable{
    protected Socket clientSocket = null;
    //private Game g;

    public RunnableServer(Socket clientSocket){//there we store the information about clientsocket
        this.clientSocket = clientSocket;
    }// end RunnableServer()
    public void run(){//this method would be facilitates connection with the client
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//There we passed into Buffer new InputStream, that we got from clientSocket
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true); //There server sending information to client
            System.out.println(in.readLine() + "\n");
            out.println("POŁĄCZONO Z SERWEREM");
        }catch(IOException e){
            e.printStackTrace();
        }//end 1. try

        /*try{

        }catch(IOException e){
            e.printStackTrace();
        }//end 2. try
        */
    }// end run()
}
