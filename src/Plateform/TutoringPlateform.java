package Plateform;

import commun.IStudent;
import commun.ITutor;
import commun.ITutoringPlateform;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class TutoringPlateform extends UnicastRemoteObject implements ITutoringPlateform {

    ArrayList<ITutor> tutors = new ArrayList<ITutor>();

    protected TutoringPlateform() throws RemoteException {
    }

    @Override
    public void addTutor(ITutor tutor) throws RemoteException, MalformedURLException {
        System.out.println("adding tutor");
        tutors.add(tutor);
        System.out.println("total number of tutors after adding is "+ tutors.size());
    }

    @Override
    public ArrayList<ITutor> getTutorsByDomain(String domain) throws RemoteException, MalformedURLException {
        System.out.println("getting by domain");
        ArrayList<ITutor> result = new ArrayList<ITutor>();
        tutors.forEach(t->{
            try {
                if (Arrays.stream(t.getDomain().toArray()).filter(x -> x.equals(domain)).toArray().length > 0) {
                    result.add(t);
                }
            } catch (MalformedURLException | RemoteException e) {
                e.printStackTrace();
            }
        });
        System.out.println("number of tutors found with domain "+domain+" is "+result.size());
        return result;
    }

    @Override
    public void addStudentToWaitingList(IStudent student, ITutor tutor, Date[] spot) throws MalformedURLException, RemoteException {
        System.out.println("adding to waiting list");
        tutor.addToWaitingList(student,spot);
    }
}
