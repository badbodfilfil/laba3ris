import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("enter the string: ");
            String string=in.nextLine();
            Registry registry = LocateRegistry.getRegistry(host);
            Replace stub = (Replace) registry.lookup("Replace");
            String response = stub.doReplace(string);
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}