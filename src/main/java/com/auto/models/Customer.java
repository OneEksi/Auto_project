package com.auto.models;

public class Customer {


    private int idCustomer;
    private  String LastName;
    private  String FirstName;
    private  String MiddleName;
    private  String ContTel;
    private  String Address;


    public  Customer(int idCustomer,String LastName,String FirstName, String MiddleName, String ContTel, String Addres){

        this.setIdCustomer(idCustomer);
        this.setLastName(LastName);
        this.setFirstName(FirstName);
        this.setMiddleName(MiddleName);
        this.setContTel(ContTel);
        this.setAddress(Addres);
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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
}
