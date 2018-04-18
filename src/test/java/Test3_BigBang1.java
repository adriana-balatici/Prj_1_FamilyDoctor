import Lab2.Test1_AddPatient;
import controller.DoctorController;
import exceptions.ConsultationException;
import exceptions.PatientException;
import junit.framework.TestCase;
import model.Patient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adriana on 4/18/2018.
 */
public class Test3_BigBang1{
    Repository repo;
    DoctorController ctrl;

    @Test
    public void Test1All3() throws PatientException {
        Repository repo;
        DoctorController ctrl;
        repo = new Repository("patients.txt", "consultations.txt");
        ctrl = new DoctorController(repo);

        System.out.println("lab 2 Test ccase 1 - valid product");
        Patient p = new Patient("adriana","1111111111111","adresa");
        //ctrl.getPatientList().clear();
        ctrl.addPatient(p);
        List<Patient> patientsList = ctrl.getPatientList();
        System.out.println(patientsList.size() + " ");


        System.out.println("lab 3 Test case 1 - valid consultation with a valid patient");
        String consID, patientSSN, diag,date;
        List<String> meds = new ArrayList<String>();
        meds.add("sdsf");
        meds.add("dfgdf");
        consID="111";
        patientSSN="1111111111111";
        diag="sfsdf";
        date="fsdfsd";
        ctrl.getConsultationList().clear();


        try {
            ctrl.addConsultation(consID, patientSSN,diag ,meds, date);
        } catch (ConsultationException e) {
            e.printStackTrace();
        }


        System.out.println("lab 4 Test case 1 - list the patients with a certain desease");
        consID="1";
        patientSSN="1111111111111";
        diag="boala";
        date="fsdfsd";
        //ctrl.getConsultationList().clear();
        //Patient p = new Patient("adriana","1111111111111","adresa");


        try {
            ctrl.addConsultation(consID, patientSSN,diag ,meds, date);
            ctrl.addConsultation("2","2111111111111", "boala", meds, date);
            ctrl.addConsultation("3","3111111111111", "boala", meds, date);
            List<Patient> sickPatients = ctrl.getPatientsWithDisease("boala");

        } catch (ConsultationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (PatientException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
