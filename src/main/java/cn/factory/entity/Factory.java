package cn.factory.entity;

import java.util.Date;

public class Factory {

    //`id``model``Factoryprice``Dateofproduction`
    private Integer id;
    private String model;
    private double Factoryprice;
    private String dateofproduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFactoryprice() {
        return Factoryprice;
    }

    public void setFactoryprice(double factoryprice) {
        Factoryprice = factoryprice;
    }

    public String getDateofproduction() {
        return dateofproduction;
    }

    public void setDateofproduction(String dateofproduction) {
        this.dateofproduction = dateofproduction;
    }

    public Factory(){


    }

    public Factory(Integer id, String model, double factoryprice, String dateofproduction) {
        this.id = id;
        this.model = model;
        Factoryprice = factoryprice;
        this.dateofproduction = dateofproduction;
    }
}
