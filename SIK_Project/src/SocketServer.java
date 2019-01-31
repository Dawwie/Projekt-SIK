import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class SocketServer {
    int port = 44444;
    public static int clients = 1;
    ServerSocket serverSocket = null;
    public static Map<Integer, Player> players;
    public static boolean allPlayers = false;
    public static int random = ThreadLocalRandom.current().nextInt(1, 5);
    public void runServer() { //create new server socket
    players = new HashMap<>();
        try {
            serverSocket = new ServerSocket(port);
            while(clients != 6) {//searching for connections
                try{
                    Socket clientSocket = serverSocket.accept();//every time the ServerSocket() accept connection form the client
                    RunnableServer r = new RunnableServer(clientSocket);//this is storing in clientSocket
                    new Thread(r).start();
                    clients++;
                    if(clients == 6){
                        allPlayers = true;
                        serverSocket.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }//end 2. try }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }//end 1. try
    }// end run method
}
