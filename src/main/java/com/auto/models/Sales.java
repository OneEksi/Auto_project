package com.auto.models;

public class Sales {

    private  int idSales;
    private  int idCustomer;
    private int idAuto;
    private int idEmployee;
    private String SaleDate;


    public Sales(int idSales,int idCustomer,int idAuto,int idEmployee,String SaleDate){

        this.setIdSales(idSales);
        this.setIdCustomer(idCustomer);
        this.setIdAuto(idAuto);
        this.setIdEmployee(idEmployee);
        this.setSaleDate(SaleDate);
    }

    public int getIdSales() {
        return idSales;
    }

    public void setIdSales(int idSales) {
        this.idSales = idSales;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getSaleDate() {
        return SaleDate;
    }

    public void setSaleDate(String saleDate) {
        SaleDate = saleDate;
    }
}
