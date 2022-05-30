package bai_tap_lam_them.quan_ly_xe.service;

import bai_tap_lam_them.quan_ly_xe.model.Bike;

import java.util.ArrayList;
import java.util.Scanner;

public class BikeService implements IManagerService {

    static Scanner input = new Scanner(System.in);

    private static ArrayList<Bike> bikeArrayList = new ArrayList<>();

    static {
        bikeArrayList.add(new Bike("48K-1278", "honda", "2019", "Hoang", "80"));
        bikeArrayList.add(new Bike("48K-1275", "yamaha", "2009", "Duy", "50"));
        bikeArrayList.add(new Bike("48K-1277", "wave", "2002", "Long", "150"));
    }

    @Override
    public void add() {
        System.out.println("Nhap bien so: ");
        String plateNumberOfBike = input.nextLine();
        System.out.println("Nhap hang san xuat: ");
        String producerOfBike = input.nextLine();
        System.out.println("Nhap nam san xuat: ");
        String yearOfProductionOfBike = input.nextLine();
        System.out.println("Nhap chu so huu: ");
        String ownerOfBike = input.nextLine();
        System.out.println("Nhap cong suat: ");
        String capacityOfBike = input.nextLine();
        bikeArrayList.add(new Bike(plateNumberOfBike, producerOfBike, yearOfProductionOfBike, ownerOfBike, capacityOfBike));
        System.err.println("Them moi thanh cong");
    }

    @Override
    public void display() {
        for (Bike bike : bikeArrayList) {
            System.out.println(bike);
        }
    }

    @Override
    public void remove() {

    }

    @Override
    public void stop() {

    }
}
