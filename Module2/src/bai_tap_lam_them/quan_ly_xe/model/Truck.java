package bai_tap_lam_them.quan_ly_xe.model;

public class Truck extends Vehicle {
     private String truckLoad;



    public Truck(String numberPlate, String producer, String yearOfProduction, String owner, String truckLoad) {
        super(numberPlate, producer, yearOfProduction, owner);
        this.truckLoad = truckLoad;
    }


    @Override
    public String toString() {
        return "Truck{" + super.toString()+
                "truckLoad='" + truckLoad + '\'' +
                '}';
    }
}
