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
        repo = new Repository("patients.txt", "consultations.txt");
        ctrl = new DoctorController(repo);
        //add a client with a normal name
        //Patient p = new Patient("adriana","1111111111111","adresa");
        //ctrl.addPatient(p);

    }

    @Test
    public void testAddPatient1() throws PatientException {
        System.out.println("Test ccase 1 - valid product");
        Patient p = new Patient("adriana","1111111111111","adresa");
        ctrl.getPatientList().clear();
        ctrl.addPatient(p);
        List<Patient> patientsList = ctrl.getPatientList();
        System.out.println(patientsList.size() + " ");
        Assert.assertTrue("The  patient was not added", patientsList.size() == 1);
    }

    @Test
    public void testAddPatient2() throws PatientException {
        System.out.println("Test ccase 2 - no valid ssn");
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
    @Test
    public void testAddPatient3() throws PatientException {
        System.out.println("Test ccase 3 - no valid name, emplty name");
        Patient p = new Patient("","11111111111","adresa");
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
    @Test
    public void testAddPatient4() throws PatientException {
        System.out.println("Test ccase 4 - one valid product, one invalid product");
        Patient p1 = new Patient("valid","11111111111","adresa");
        Patient p2 = new Patient("","11111","adresa");

        ctrl.getPatientList().clear();
        try {
            ctrl.addPatient(p1);
            ctrl.addPatient(p2);
        }
        catch(PatientException e)
        {
            e.getMessage();
        }
        List<Patient> patientsList = ctrl.getPatientList();
        System.out.println(patientsList.size() + " ");
        Assert.assertFalse("The invalid patient was not added", patientsList.size() == 1);
    }
    @Test
    public void testAddPatient5() throws PatientException {
        System.out.println("Test ccase 5 - no valid address, emplty address");
        Patient p = new Patient("nume","1111111111111","");
        ctrl.getPatientList().clear();
        try {
            ctrl.addPatient(p);
        }
        catch(PatientException e)
        {
            System.out.println(e.getMessage());
        }
        List<Patient> patientsList = ctrl.getPatientList();
        System.out.println(patientsList.size() + " ce lungime are lista?");
        Assert.assertFalse("The  patient was added", patientsList.size() == 1);
    }
}
