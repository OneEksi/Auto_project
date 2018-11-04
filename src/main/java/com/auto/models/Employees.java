package com.auto.models;

public class Employees {

    private int idEmployee;
    private String LastName;
    private String FirstName;
    private String MiddleName;
    private String ContTel;
    private String Address;
    private double Experience;


    public Employees(int idEmployee, String LastName, String FirstName, String MiddleName, String ContTel, String Addres,
                     double Experience) {

        this.setIdEmployee(idEmployee);
        this.setLastName(LastName);
        this.setFirstName(FirstName);
        this.setMiddleName(MiddleName);
        this.setContTel(ContTel);
        this.setAddress(Addres);
        this.setExperience(Experience);
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getContTel() {
        return ContTel;
    }

    public void setContTel(String contTel) {
        ContTel = contTel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getExperience() {
        return Experience;
    }

    public void setExperience(double experience) {
        Experience = experience;
    }
}
