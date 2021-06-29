package model;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {

    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<AppoinmentDoctor> appoinmentDoctors = new ArrayList<>();
    private ArrayList<AppoinmentNurse> appoinmentNurses = new ArrayList<>();

    public ArrayList<AppoinmentDoctor> getAppoinmentDoctors() {
        return appoinmentDoctors;
    }

    public void addAppoinmentDoctors(Doctor doctor, Date date, String time) {
        AppoinmentDoctor appoinmentDoctor = new AppoinmentDoctor(this, doctor);
        appoinmentDoctor.schedule(date, time);
        appoinmentDoctors.add(appoinmentDoctor);
    }

    public ArrayList<AppoinmentNurse> getAppoinmentNurses() {
        return appoinmentNurses;
    }

    public void setAppoinmentNurses(ArrayList<AppoinmentNurse> appoinmentNurses) {
        this.appoinmentNurses = appoinmentNurses;
    }

    public Patient(String name, String email){
        super(name,email);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeight(){
        return this.weight + " Kg.";
    }

    public String getHeight() {
        return height + " Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Age: " + birthday + "\n Weight: " +
                getWeight() + "\n Height: " +
                getHeight() + "\n Blood: " + getBlood();
    }

    @Override
    public void showDataUser() {
        System.out.println("Patient");
        System.out.println("Full History");
    }
}