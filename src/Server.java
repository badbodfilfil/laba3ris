import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Lenovo Z on 23.02.2017.   javac Server.java Client.java Replace.java
 */
public class Server implements Replace {
    public Server() {
    }

    public String doReplace(String string) {
        string.replaceAll("(?i:[aeiouy])","*");
        return string;
    }

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            Replace stub = (Replace) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Replace", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}