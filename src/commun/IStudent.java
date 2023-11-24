package commun;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStudent extends Remote {
    public String getID() throws RemoteException, MalformedURLException;
}
