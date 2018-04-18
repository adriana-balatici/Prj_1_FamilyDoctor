package Lab4;

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
public class Test3_Integration1 extends TestCase {
    Repository repo;
    DoctorController ctrl;

    @Before
    public void setUp() throws Exception{
        super.setUp();
        repo = new Repository("patients.txt", "consultations.txt");
        ctrl = new DoctorController(repo);
        //add a client with a normal name
        //Patient p = new Patient("adriana","1111111111111","adresa");
        //ctrl.addPatient(p);

    }
    @Test
    public void testListPatients1() throws PatientException {
        System.out.println("Test case 1 - list the patients with a certain desease");
        String consID, patientSSN, diag,date;
        List<String> meds = new ArrayList<String>();
        meds.add("sdsf");
        meds.add("dfgdf");
        consID="1";
        patientSSN="1111111111111";
        diag="boala";
        date="fsdfsd";
        ctrl.getConsultationList().clear();
        //Patient p = new Patient("adriana","1111111111111","adresa");


        try {
            ctrl.addConsultation(consID, patientSSN,diag ,meds, date);
            ctrl.addConsultation("2","2111111111111", "boala", meds, date);
            ctrl.addConsultation("3","3111111111111", "boala", meds, date);
            List<Patient> sickPatients = ctrl.getPatientsWithDisease("boala");
            for(Patient p : sickPatients)
                System.out.println(p + " ");
        } catch (ConsultationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (PatientException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        Assert.assertTrue("the consultation was added", ctrl.getPatientsWithDisease("boala").size()==3);
    }
}
