package ui;

import model.Doctor;
import model.Patient;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static String[] MONTHS = {"January","February","March","April","May","June","July","August", "September", "October", "November", "December"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. model.Doctor");
            System.out.println("2. model.Patient");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("model.Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);

                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("--Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i +". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("--My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);


    }

    private static void authUser(int userType) {
        //1 = doctor
        //2 = patient
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();

        doctors.add(new Doctor("miguel", "general", "m@gmail"));
        doctors.add(new Doctor("edgardo", "general", "e@gmail"));
        doctors.add(new Doctor("santiago", "general", "s@gmail"));

        ArrayList<Patient> patients = new ArrayList<Patient>();
        patients.add(new Patient("luissa", "l@gmail.com"));
        patients.add(new Patient("oralia", "o@gmail.com"));

        boolean emailCorrect = false;

        do {
            System.out.println("Insert your email: a@a.com");
            Scanner x = new Scanner(System.in);
            String email = x.nextLine();

            if (userType == 1){
                for (Doctor d: doctors) {
                    if (d.getEmail().equals(email)) {
                        emailCorrect = true;
                        //get logged user
                        doctorLogged = d;
                        //show doctor menu
                        UIDoctorMenu.showDoctorMenu();

                    }

                }
            }
            if (userType == 2){
                for (Patient p: patients) {
                    if (p.getEmail().equals(email)) {
                        emailCorrect = true;
                        //get logged user
                        patientLogged = p;
                        //show patient menu
                        UIPatientMenu.showPatientMenu();

                    }

                }

            }

        }while (!emailCorrect);
    }

}