package commun;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface ITutoringPlateform extends Remote {

    public void addTutor(ITutor tutor) throws RemoteException, MalformedURLException;

    public ArrayList<ITutor> getTutorsByDomain(String domain) throws RemoteException, MalformedURLException;

    public void addStudentToWaitingList(IStudent student, ITutor tutor, Date[] spot) throws MalformedURLException, RemoteException;

}
