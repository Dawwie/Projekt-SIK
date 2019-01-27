public class Server {
    public static void main(String arg[]){
        System.out.println("KDICE GAME\n");
        SocketServer s = new SocketServer();
        s.runServer();
    }
}
