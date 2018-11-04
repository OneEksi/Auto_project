package com.auto.models;

public class EmployeeStat {
    private  int idEmployee;
    private  int NumberOfSales;
    private int AmountOfSales;

    public  EmployeeStat (int idEmployee, int NumberOfSales, int AmountOfSales){
        this.setIdEmployee(idEmployee);
        this.setNumberOfSales(NumberOfSales);
        this.setAmountOfSales(AmountOfSales);
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getNumberOfSales() {
        return NumberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        NumberOfSales = numberOfSales;
    }

    public int getAmountOfSales() {
        return AmountOfSales;
    }

    public void setAmountOfSales(int amountOfSales) {
        AmountOfSales = amountOfSales;
    }
}
