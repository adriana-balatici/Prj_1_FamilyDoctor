package Lab2;

import controller.DoctorController;
import exceptions.PatientException;
import junit.framework.TestCase;
import model.Patient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.Repository;

import java.util.List;

/**
 * Created by Adriana on 3/14/2018.
 */
public class Test1_AddPatient extends TestCase {
    Repository repo;
    DoctorController ctrl;

    @Before
    public void setUp() throws Exception{
        super.setUp();
        String patients, consultations;
        patients = new String();
        consultations = new String();
        repo = new Repository("patients.txt", "consultations.txt");
        ctrl = new DoctorController(repo);
        //add a client with a normal name
        //Patient p = new Patient("adriana","1111111111111","adresa");
        //ctrl.addPatient(p);

    }

    @Test
    public void testAddPatient1() throws PatientException {
        System.out.println("Test ccase 1");
        Patient p = new Patient("adriana","1111111111111","adresa");
        ctrl.getPatientList().clear();
        ctrl.addPatient(p);
        List<Patient> patientsList = ctrl.getPatientList();
        System.out.println(patientsList.size() + " ");
        Assert.assertTrue("The  patient was not added", patientsList.size() == 1);
    }

    @Test
    public void testAddPatient2() throws PatientException {
        System.out.println("Test ccase 2");
        Patient p = new Patient("adriana","111111111","adresa");
        ctrl.getPatientList().clear();
        try {
            ctrl.addPatient(p);
        }
        catch(PatientException e)
        {
            e.getMessage();
        }
        List<Patient> patientsList = ctrl.getPatientList();
        System.out.println(patientsList.size() + " ");
        Assert.assertFalse("The  patient was not added", patientsList.size() == 1);
    }
}
