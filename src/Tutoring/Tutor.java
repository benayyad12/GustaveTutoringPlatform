package Tutoring;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import commun.IStudent;
import commun.ITutor;

class Tutor extends UnicastRemoteObject implements ITutor {

    private static String name;

    private Map<IStudent, Date[]> students = new HashMap<IStudent, Date[]>();

    private Map<Date[], ArrayList<String>> waitingListBySpot = new HashMap<Date[], ArrayList<String>>();

    private ArrayList<String> domain = new ArrayList<String>();
    private double tarif = 0;

    private List<Date[]> availableSpots = new ArrayList<Date[]>();

    protected Tutor(String name) throws RemoteException {
        super();
        this.name = name;
    }

    @Override
    public List<Date[]> getAvailableSpots(){
        return this.availableSpots;
    }

    @Override
    public double getTarif(){
        return this.tarif;
    }

    @Override
    public Map getStudents(){
        return this.students;
    }

    @Override
    public Map getWaitingListBySpot(){
        return this.waitingListBySpot;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public void setName(String name){
        name =  this.name;
    }

    @Override
    public ArrayList<String> getDomain(){
        return this.domain;
    }

    @Override
    public void addToWaitingList(IStudent student, Date[] spot) throws RemoteException, MalformedURLException {
        //get waiters list
        ArrayList<String> waiters = new ArrayList<>();

        if(waitingListBySpot.get(spot)!=null){
            waiters = waitingListBySpot.get(spot);
        }
        //add to waiters list
        waiters.add(student.getID());
        //update the map
        waitingListBySpot.put(spot, waiters);
    }

    @Override
    public void acceptAppointement(IStudent student, Date[] spot) throws RemoteException, MalformedURLException {
        students.put(student,spot);
    }

    @Override
    public void addDomaine(String domaine) throws RemoteException, MalformedURLException {
        this.domain.add(domaine);
    }

    @Override
    public void setTarif(int tarif) throws RemoteException, MalformedURLException {
        this.tarif = tarif;
    }

    @Override
    public void addAvailability(Date debut, Date fin) throws RemoteException, MalformedURLException {
        Date[] spot = new Date[2];
        spot[0] = debut;
        spot[1] = fin;
        this.availableSpots.add(spot);
        this.waitingListBySpot.put(spot,new ArrayList());
    }

    @Override
    public void removeAvailability(Date[] spot) throws RemoteException, MalformedURLException {
        this.waitingListBySpot.remove(spot);
    }


}
