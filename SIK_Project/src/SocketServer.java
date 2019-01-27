import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    int port = 44444;
    int clients = 0;
    ServerSocket serverSocket = null;

    public void runServer() { //create new server socket
        try {
            serverSocket = new ServerSocket(port);
            while (clients!=5) {//searching for connections
                try{
                    Socket clientSocket = serverSocket.accept();//every time the ServerSocket() accept connection form the client
                    RunnableServer r = new RunnableServer(clientSocket);//this is storing in clientSocket
                    new Thread(r).start();
                    clients++;
                    if(clients == 5){
                        serverSocket.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }//end 2. try }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }//end 1. try


    }// end run method
}
