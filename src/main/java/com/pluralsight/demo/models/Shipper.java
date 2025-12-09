package com.pluralsight.demo.models;

public class Shipper {
    private int shipperID;
    private String CompanyName;
    private String phone;

    public Shipper(){

    }
    public Shipper(int shipperID, String companyName, String phone) {
        this.shipperID = shipperID;
        CompanyName = companyName;
        this.phone = phone;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
