import controller.DoctorController;
import model.Patient;

import org.junit.Test;
import repository.Repository;

import java.util.List;

/**
 * Created by Adriana on 3/14/2018.
 */
public class Test1_AddPatient {
    @Test
    public void testAddPatient() {
        Patient p = new Patient("adriana","1111111111111","adresa");
        String patients, consultations;
        patients = new String();
        consultations = new String();
        Repository repo = new Repository(patients, consultations);;
        List<Patient> patientList = repo.getPatientList();
        System.out.println(patientList.size());

    }
}
