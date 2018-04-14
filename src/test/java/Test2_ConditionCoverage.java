import controller.DoctorController;
import exceptions.ConsultationException;
import model.Patient;
import org.junit.Assert;
import org.junit.Test;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adriana on 3/28/2018.
 */
public class Test2_ConditionCoverage {
    @Test
    public void testAddconsultation() {
        String consID, patientSSN, diag,date;
        List<String> meds = new ArrayList<String>();
        meds.add("sdsf");
        meds.add("dfgdf");
        consID="111";
        patientSSN="1111111111111";
        diag="sfsdf";
        date="fsdfsd";
        Patient p = new Patient("adriana","1111111111111","adresa");
        String patients, consultations;
        patients = new String();
        consultations = new String();
        Repository repo = new Repository(patients, consultations);;
        DoctorController ctrl = new DoctorController(repo);
        try {
            ctrl.addConsultation(consID, patientSSN,diag ,meds, date);
        } catch (ConsultationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("the consultation was added", ctrl.getConsultationList().size()==1);
    }
}
