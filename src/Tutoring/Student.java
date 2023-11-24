package Tutoring;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import commun.IStudent;

public class Student extends UnicastRemoteObject implements Serializable, IStudent {

    private String ID;

    protected Student(String id) throws RemoteException {
        super();
        ID = id;
    }

    @Override
    public String getID(){
        return this.ID;
    }


}
