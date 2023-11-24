package commun;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ITutor extends Remote {

    public List<Date[]> getAvailableSpots() throws RemoteException, MalformedURLException;

    public double getTarif() throws RemoteException, MalformedURLException;

    public Map<IStudent, Date[]> getStudents() throws RemoteException, MalformedURLException;

    public Map<Date[], String[]> getWaitingListBySpot() throws RemoteException, MalformedURLException;

    public ArrayList<String> getDomain() throws RemoteException, MalformedURLException;

    public String getName() throws RemoteException, MalformedURLException;

    public void setName(String name) throws RemoteException, MalformedURLException;

    public void addToWaitingList(IStudent student, Date[] spot) throws RemoteException, MalformedURLException;

    public void acceptAppointement(IStudent student, Date[] spot) throws RemoteException, MalformedURLException;

    public void addDomaine(String domaine) throws RemoteException, MalformedURLException;

    public void setTarif(int tarif) throws RemoteException, MalformedURLException;

    public void addAvailability(Date debut, Date fin) throws RemoteException, MalformedURLException;

    public void removeAvailability(Date[] spot) throws RemoteException, MalformedURLException;
}
