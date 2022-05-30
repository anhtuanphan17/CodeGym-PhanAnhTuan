package bai_tap_lam_them.quan_ly_xe.model;

public abstract class Vehicle {
    private String numberPlate;
    private String Producer;
    private String yearOfProduction;
    private String owner;

    public Vehicle() {

    }

    public Vehicle(String numberPlate, String producer, String yearOfProduction, String owner) {
        this.numberPlate = numberPlate;
        Producer = producer;
        this.yearOfProduction = yearOfProduction;
        this.owner = owner;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return
                "numberPlate='" + numberPlate + '\'' +
                        ", Producer='" + Producer + '\'' +
                        ", yearOfProduction='" + yearOfProduction + '\'' +
                        ", owner='" + owner + "," + '\'';
    }

}
