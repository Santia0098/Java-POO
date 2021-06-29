package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu() {
        int respose = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());

            System.out.println("1. Book an appoinment");
            System.out.println("2. My appoinments");
            System.out.println("3. Logout");

            Scanner x = new Scanner(System.in);
            respose = Integer.valueOf(x.nextLine());

            switch (respose) {
                case 1:
                    showBookAppoinmentMenu();
                    break;
                case 2:
                    showPatientMyAppoinments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        } while (respose != 0);
        }
        private static void showBookAppoinmentMenu(){
        int response = 0;
        do {
            System.out.println("::Book an appoinment");
            System.out.println("::Select date: ");
            //date list
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;

            for (int i = 0; i < UIDoctorMenu.doctorAvailableAppoinments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorAvailableAppoinments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppoinments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k +". " + availableAppointments.get(j).getDate());
                    doctorAppoinments.put(Integer.valueOf(j), UIDoctorMenu.doctorAvailableAppoinments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppoinments);

                }

            }
            Scanner x = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(x.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            int indexDate = 0;
            Doctor doctorSelected = new Doctor(" ", "", "");
            for (Map.Entry<Integer, Doctor> doc:doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());


            System.out.println("Confirm your appoinment \n1. Yes \n2. Change data");
            response = Integer.valueOf(x.nextLine());

            if (response == 1) {
                UIMenu.patientLogged.addAppoinmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());

                showPatientMenu();
            }
        }while (response != 0);
     }

        private static void showPatientMyAppoinments() {
            int response = 0;
            do {
                System.out.println(":: My Appoinments");
                if (UIMenu.patientLogged.getAppoinmentDoctors().size() == 0) {
                    System.out.println("Dont have appoinments");
                    break;
                }

                for (int i = 0; i < UIMenu.patientLogged.getAppoinmentDoctors().size(); i++) {
                    int j = i + 1;
                    System.out.println(j + ". " +
                            "Date: " + UIMenu.patientLogged.getAppoinmentDoctors().get(i).getDate() +
                            "Time: " + UIMenu.patientLogged.getAppoinmentDoctors().get(i).getTime() +
                            "\n Doctor: " + UIMenu.patientLogged.getAppoinmentDoctors().get(i).getDoctor()
                            );
                }

                System.out.println("0. Return");

            }while (response != 0);
        }
}
