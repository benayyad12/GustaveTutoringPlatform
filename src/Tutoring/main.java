package Tutoring;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import commun.ITutor;
import commun.ITutoringPlateform;

public class main {
    public static Date createDate(int year, int month,int day, int hour,int minute){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DATE,day);
        cal.set(Calendar.HOUR_OF_DAY,hour);
        cal.set(Calendar.MINUTE,minute);

        Date d = cal.getTime();

        return d;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, InterruptedException {

        ITutoringPlateform plateform;

        plateform = (ITutoringPlateform) Naming.lookup("tutorsPlateform");

        //creating a spot 1
        Date d1 = createDate(2023,12,2,17,30);
        Date d2 = createDate(2023,12,2,18,30);

        //creating a spot 2
        Date d3 = createDate(2023,12,5,17,30);
        Date d4 = createDate(2023,12,5,18,30);


        //creation d'un tuteur
        ITutor newProf = new Tutor("prof 1");
        newProf.addDomaine("informatique");
        newProf.addAvailability(d1,d2);

        //creation d'un tuteur
        ITutor newProf2 = new Tutor("prof 2");
        newProf2.addDomaine("medecine");
        newProf2.addAvailability(d1,d2);

        //creation d'un tuteur
        ITutor newProf3 = new Tutor("prof 3");
        newProf3.addDomaine("informatique");
        newProf3.addAvailability(d3,d4);

        //ajouter le tuteur au systeme
        plateform.addTutor(newProf);
        Thread.sleep(1000);
        plateform.addTutor(newProf2);
        Thread.sleep(1000);
        plateform.addTutor(newProf3);
        Thread.sleep(1000);

        //Recherche par domaine informatique
        ArrayList<ITutor> tutors = plateform.getTutorsByDomain("informatique");
        System.out.println("number of tutors informatique "+tutors.size());

        //Recherche par domaine medecine
        ArrayList<ITutor> tutors2 = plateform.getTutorsByDomain("medecine");
        System.out.println("number of tutors medecine "+tutors2.size());

        //inscription d'un etudiant
        Student student = new Student("abir");

        //l'etudiant selectionne un tuteur et demande un
        Date[] spot = {d1,d2};
        plateform.addStudentToWaitingList(student,newProf,spot);

        //verifier la liste d'attente du prof
        System.out.println("nombre d'etudiants dans la liste d'attente est "+newProf.getWaitingListBySpot().size());

        //accept a student
        newProf.acceptAppointement(student,spot);
    }
}
