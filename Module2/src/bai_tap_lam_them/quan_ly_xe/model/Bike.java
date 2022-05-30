package bai_tap_lam_them.quan_ly_xe.model;

public class Bike extends Vehicle {

     private String capacity;



    public Bike(String numberPlate, String producer, String yearOfProduction, String owner,String capacity) {
        super(numberPlate, producer, yearOfProduction, owner);
        this.capacity=capacity;
    }

    @Override
    public String toString() {
        return "Bike{" + super.toString()+
                "capacity='" + capacity + '\'' +
                '}';
    }

}
