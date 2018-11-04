package com.auto.models;

public class Auto {

    private int idAuto;
    private  String Model;
    private  double EngineCapacity;
    private double EnginePower;
    private String TypeOfShell;
    private String FuelType;
    private double AccelerationTime;
    private  String DriveUnit;
    private  int Cost;


    public Auto(int idAuto, String Model, double EngineCapacity,double EnginePower,
                String TypeOfShell, String FuelType, double AccelerationTime, String DriveUnit,
                int Cost){
        this.setIdAuto(idAuto);
        this.setModel(Model);
        this.setEngineCapacity(EngineCapacity);
        this.setEnginePower(EnginePower);
        this.setTypeOfShell(TypeOfShell);
        this.setFuelType(FuelType);
        this.setAccelerationTime(AccelerationTime);
        this.setDriveUnit(DriveUnit);
        this.setCost(Cost);
    }


    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public double getEngineCapacity() {
        return EngineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        EngineCapacity = engineCapacity;
    }

    public double getEnginePower() {
        return EnginePower;
    }

    public void setEnginePower(double enginePower) {
        EnginePower = enginePower;
    }

    public String getTypeOfShell() {
        return TypeOfShell;
    }

    public void setTypeOfShell(String typeOfShell) {
        TypeOfShell = typeOfShell;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }

    public double getAccelerationTime() {
        return AccelerationTime;
    }

    public void setAccelerationTime(double accelerationTime) {
        AccelerationTime = accelerationTime;
    }

    public String getDriveUnit() {
        return DriveUnit;
    }

    public void setDriveUnit(String driveUnit) {
        DriveUnit = driveUnit;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }
}
