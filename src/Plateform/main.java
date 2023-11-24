package Plateform;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class main {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            TutoringPlateform tutoringPlateform = new TutoringPlateform();
            Naming.rebind("tutorsPlateform",tutoringPlateform);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}