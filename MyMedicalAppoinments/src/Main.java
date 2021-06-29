import model.Doctor;
import model.ISchedulable;
import model.Patient;
import model.User;

import java.util.Date;

import static ui.UIMenu.showMenu;

public class Main {
    public static void main(String[] args) {

        showMenu();
        /*Doctor myDoctor = new Doctor("Miguel ", "General", "miguel@gmail.com");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");

        System.out.println(myDoctor);

        for (model.Doctor.AvailableAppointment aA: myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate() + " " + aA.getTime());
        }

        System.out.println("\n");
        Patient patient = new Patient("Edgardo", "edgard@mail.com");

        System.out.println(patient);

        User user = new Doctor("miguel", "general", "miguel@gmail");
        user.showDataUser();

        User user1 = new User("edgardo", "ed@gmail.com") {
            @Override
            public void showDataUser() {
                System.out.println("Doctor");
                System.out.println("Hospital: CV");
                System.out.println("Geriatrcs department");
            }
        };

        user1.showDataUser();*/





    }



}