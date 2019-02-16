<<<<<<< HEAD
import java.io.*;
import java.net.Socket;
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
    public void run() {//this method would be facilitates connection with the client
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//There we passed into Buffer new InputStream, that we got from clientSocket
            out = new PrintWriter(clientSocket.getOutputStream(), true); //There server sending information to client
        } catch (IOException e) {
            e.printStackTrace();
        }//end 1. try

        try {
            System.out.println(in.readLine() + "\n");
            newPlayer.setId(SocketServer.clients - 1);
            newPlayer.setScore(0);
            newPlayer.setPoints(0);
            SocketServer.players.put(newPlayer.getId(), newPlayer);
            out.println("Połączono z serwerem");
        } catch (IOException e) {
            e.printStackTrace();
        }//end 2. try
        //waiting for all players
        while (!SocketServer.allPlayers) {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //write Id and who is starting
        try {
            out.println("START " + newPlayer.getId() + " " + SocketServer.random);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Generate the field to play
        try {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    out.println("PLANSZA " + (i + 1) + " " + (j + 1) + " " + SocketServer.board.playerId[i][j] + " " + SocketServer.board.cubes[i][j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Send message to starting player
        if(newPlayer.getId() == SocketServer.random) {
                try {
                    out.println("TWOJ RUCH");
                    if(in.readLine().startsWith("PASS")) {
                        out.println("OK");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        //Lets game start
        try{
            for (int tour = 1; tour <= 10; tour++) {
                for (int round = 1; round <= 100; round++) {
                    System.out.println("RUNDA" + round);
                    for(int i = 1; i <=5; i++){
                        try{
                            out.println("   ");
                            if(in.readLine().startsWith("PASS")) {
                                System.out.println("PASS");
                                out.println("OK");
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    if(round != 100)
                    System.out.println("KONIEC RUNDY");
                    }
                System.out.println("KONIEC TURY");
                }
        }catch(Exception e){
            e.printStackTrace();
        }



    }// end run()
}
=======
import java.io.*;
import java.net.Socket;
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
    public void run() {//this method would be facilitates connection with the client
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//There we passed into Buffer new InputStream, that we got from clientSocket
            out = new PrintWriter(clientSocket.getOutputStream(), true); //There server sending information to client
        } catch (IOException e) {
            e.printStackTrace();
        }//end 1. try

        try {
            System.out.println(in.readLine() + "\n");
            newPlayer.setId(SocketServer.clients - 1);
            newPlayer.setScore(0);
            newPlayer.setPoints(0);
            SocketServer.players.put(newPlayer.getId(), newPlayer);
            out.println("Połączono z serwerem");
        } catch (IOException e) {
            e.printStackTrace();
        }//end 2. try
        //waiting for all players
        while (!SocketServer.allPlayers) {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //write Id and who is starting
        try {
            out.println("START " + newPlayer.getId() + " " + SocketServer.random);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Generate the field to play
        try {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    out.println("PLANSZA " + (i + 1) + " " + (j + 1) + " " + SocketServer.board.playerId[i][j] + " " + SocketServer.board.cubes[i][j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Send message to starting player
        if(newPlayer.getId() == SocketServer.random) {
                try {
                    out.println("TWOJ RUCH");
                    if(in.readLine().startsWith("PASS")) {
                        out.println("OK");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        try{
            for (int tour = 1; tour <= 10; tour++) {
                for (int round = 1; round <= 100; round++) {
                    System.out.println("RUNDA" + round);
                    for(int i = 1; i <=5; i++){
                        try{
                            out.println("   ");
                            if(in.readLine().startsWith("PASS")) {
                                System.out.println("PASS");
                                out.println("OK");
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    if(round != 100)
                    System.out.println("KONIEC RUNDY");
                    }
                System.out.println("KONIEC TURY");
                }
        }catch(Exception e){
            e.printStackTrace();
        }



    }// end run()
}
>>>>>>> 5b4c07dfc7ec3753ce4ab4fc6a508d995b9d58ee
