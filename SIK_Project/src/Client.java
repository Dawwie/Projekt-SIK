<<<<<<< HEAD
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

public class Client {
    public static void main(String[] args) {
        //connection client with the server
        String hostName = "127.0.0.1";
        int port = 44444;
        String string = "";
        Socket clientSocket;
        PrintWriter out = null;
        BufferedReader in = null;
        InputStreamReader ir;
        ClientBoard board = new ClientBoard();

        try {
            clientSocket = new Socket(hostName, port);
            //Create our IO streams
            //PrintWriter() try to send information form client to the server
            out = new PrintWriter(clientSocket.getOutputStream(), true); //autoflush buffer
            ir = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(ir);
        } catch (UnknownHostException e) {
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }//end 1. try

        try {
            //logging
            out.println("LOGIN " + "player" + ThreadLocalRandom.current().nextInt(100,200));
            while (true) {
                //read connection
                System.out.println(in.readLine());
                string = in.readLine();
                if (string.startsWith("START")) {
                    System.out.println(string);
                }
                //read board
                if (string.startsWith("PLANSZA")) {
                    System.out.println(string);
                    String[] parts = string.split(" ");
                    board.playerId[Integer.parseInt(parts[1]) - 1][Integer.parseInt(parts[2]) - 1] = Integer.parseInt(parts[3]);
                    board.cubes[Integer.parseInt(parts[1]) - 1][Integer.parseInt(parts[2]) - 1] = Integer.parseInt(parts[4]);

                }
                //read pass
                if (string.startsWith("TWOJ RUCH")) {
                    out.println("PASS");
                    System.out.println(string);

                }
                if(string.startsWith("   ")) {
                    out.println("PASS");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }//end 2. try

    }//end main
}//end class
=======
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

public class Client {
    public static void main(String[] args) {
        //connection client with the server
        String hostName = "127.0.0.1";
        int port = 44444;
        String string = "";
        Socket clientSocket;
        PrintWriter out = null;
        BufferedReader in = null;
        InputStreamReader ir;
        ClientBoard board = new ClientBoard();

        try {
            clientSocket = new Socket(hostName, port);
            //Create our IO streams
            //PrintWriter() try to send information form client to the server
            out = new PrintWriter(clientSocket.getOutputStream(), true); //autoflush buffer
            ir = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(ir);
        } catch (UnknownHostException e) {
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }//end 1. try
        //logging
        try {
            out.println("LOGIN " + "player" + ThreadLocalRandom.current().nextInt(100,200));
            while (true) {
                System.out.println(in.readLine());
                string = in.readLine();

                if (string.startsWith("START")) {
                    System.out.println(string);
                }
                if (string.startsWith("PLANSZA")) {
                    System.out.println(string);
                    String[] parts = string.split(" ");
                    board.playerId[Integer.parseInt(parts[1]) - 1][Integer.parseInt(parts[2]) - 1] = Integer.parseInt(parts[3]);
                    board.cubes[Integer.parseInt(parts[1]) - 1][Integer.parseInt(parts[2]) - 1] = Integer.parseInt(parts[4]);

                }
                if (string.startsWith("TWOJ RUCH")) {
                    out.println("PASS");
                    System.out.println(string);

                }
                if(string.startsWith("   ")) {
                    out.println("PASS");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }//end 2. try

    }//end main
}//end class
>>>>>>> 5b4c07dfc7ec3753ce4ab4fc6a508d995b9d58ee
