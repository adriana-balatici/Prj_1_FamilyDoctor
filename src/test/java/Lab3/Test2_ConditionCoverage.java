package Lab3;

import controller.DoctorController;
import exceptions.ConsultationException;
import junit.framework.TestCase;
import model.Patient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adriana on 3/28/2018.
 */
//wbb
public class Test2_ConditionCoverage extends TestCase {
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
    public void testAddconsultation1() {
        System.out.println("Test case 1 - valid consultation with a valid patient");
        String consID, patientSSN, diag,date;
        List<String> meds = new ArrayList<String>();
        meds.add("sdsf");
        meds.add("dfgdf");
        consID="111";
        patientSSN="1111111111111";
        diag="sfsdf";
        date="fsdfsd";
        ctrl.getConsultationList().clear();
        Patient p = new Patient("adriana","1111111111111","adresa");


        try {
            ctrl.addConsultation(consID, patientSSN,diag ,meds, date);
        } catch (ConsultationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("the consultation was added", ctrl.getConsultationList().size()==1);
    }
    @Test
    public void testAddconsultation2() {
        System.out.println("Test case 2 - invalid consultation, invalid patient ssn");
        String consID, patientSSN, diag,date;
        List<String> meds = new ArrayList<String>();
        meds.add("sdsf");
        meds.add("dfgdf");
        consID="111";
        patientSSN="";
        diag="sfsdf";
        date="fsdfsd";
        ctrl.getConsultationList().clear();

        try {
            ctrl.addConsultation(consID, patientSSN,diag ,meds, date);
        } catch (ConsultationException e) {
            e.printStackTrace();
        }

        Assert.assertTrue("the consultation was added", ctrl.getConsultationList().size()==0);
    }

    @Test
    public void testAddconsultation3() {
        System.out.println("Test case 3 - invalid consultation, invalid meds");
        String consID, patientSSN, diag,date;
        List<String> meds = new ArrayList<String>();
        consID="111";
        patientSSN="1111111111111";
        diag="sfsdf";
        date="fsdfsd";
        ctrl.getConsultationList().clear();

        try {
            ctrl.addConsultation(consID, patientSSN,diag ,meds, date);
        } catch (ConsultationException e) {
            System.out.println(e.getMessage());
        }

        Assert.assertTrue("the consultation was added", ctrl.getConsultationList().size()==0);
    }
}
