package bai_tap_lam_them.quan_ly_xe.service;

import bai_tap_lam_them.quan_ly_xe.model.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class CarService implements IManagerService {
    static Scanner input = new Scanner(System.in);
    private static ArrayList<Car> carArrayList = new ArrayList<>();

    static {
        carArrayList.add(new Car("47F-1234", "Toyota", "2012", "Tuan", "7", "Xe gia dinh"));
        carArrayList.add(new Car("47F-1235", "Ford", "2013", "Long", "12", "Du lich"));
        carArrayList.add(new Car("47F-1236", "Huyndai", "2014", "Hung", "24", "Xe khach"));

    }

    @Override
    public void add() {
        System.out.println("Nhap bien so: ");
        String plateNumberOfCar = input.nextLine();
        System.out.println("Nhap hang san xuat: ");
        String producerOfCar = input.nextLine();
        System.out.println("Nhap nam san xuat: ");
        String yearOfProductionOfCar = input.nextLine();
        System.out.println("Nhap chu so huu: ");
        String ownerOfCar = input.nextLine();
        System.out.println("Nhap so cho ngoi cua xe: ");
        String seatNumberOfCar = input.nextLine();
        System.out.println("Nhap loai xe: ");
        String typeOfCar = input.nextLine();

        carArrayList.add(new Car(plateNumberOfCar, producerOfCar, yearOfProductionOfCar, ownerOfCar, seatNumberOfCar, typeOfCar));
        System.err.println("Them moi thanh cong");
    }

    @Override
    public void display() {
        for (Car car:carArrayList){
            System.out.println(car);
        }

    }

    @Override
    public void remove() {

    }

    @Override
    public void stop() {

    }
}
