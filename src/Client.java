import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        String string;
        try {
            do{
            Scanner in = new Scanner(System.in);
            System.out.print("enter the string: ");
            string=in.nextLine();
            if(string.matches("[^a-zA-Z]+")){
                System.out.println("English, please:)");
            }
            else {
                Registry registry = LocateRegistry.getRegistry(host);
                Replace stub = (Replace) registry.lookup("Replace");
                String response = stub.doReplace(string);
                System.out.println("response: " + response);
            }
            } while(!"0".equals(string));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}