import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Lenovo Z on 23.02.2017.
 */
public interface Replace  extends Remote {
    String doReplace(String string) throws RemoteException;
}