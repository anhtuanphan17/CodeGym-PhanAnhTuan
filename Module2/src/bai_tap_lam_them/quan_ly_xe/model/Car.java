package bai_tap_lam_them.quan_ly_xe.model;

public class Car extends Vehicle {
    private String seatNumber ;
    private String typeOfCar;


    public Car(String numberPlate, String producer, String yearOfProduction, String owner, String seatNumber, String typeOfCar) {
        super(numberPlate, producer, yearOfProduction, owner);
        this.seatNumber = seatNumber;
        this.typeOfCar = typeOfCar;
    }

    @Override
    public String toString() {
        return "Car{" +super.toString()+
                "seatNumber='" + seatNumber + '\'' +
                ", typeOfCar='" + typeOfCar + '\'' +
                '}';


    }


}
