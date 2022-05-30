package bai_tap_lam_them.quan_ly_xe.service;

import bai_tap_lam_them.quan_ly_xe.model.Truck;

import java.util.ArrayList;
import java.util.Scanner;

public class TruckService implements IManagerService{

    static Scanner input = new Scanner(System.in);
  private static  ArrayList<Truck> truckArrayList = new ArrayList<>();
    static {
        truckArrayList.add(new Truck("47M-4567", "Huyndai", "2018", "Huy", "20"));
        truckArrayList.add(new Truck("47M-4568", "Huyndai", "2012", "Dung", "15"));
        truckArrayList.add(new Truck("47M-4569", "Huyndai", "2011", "Vinh", "28"));

    }

    @Override
    public void add() {
        System.out.println("Nhap bien so: ");
        String plateNumberOfTruck= input.nextLine();
        System.out.println("Nhap hang san xuat: ");
        String producerOfTruck = input.nextLine();
        System.out.println("Nhap nam san xuat: ");
        String yearOfProductionOfTruck= input.nextLine();
        System.out.println("Nhap chu so huu: ");
        String ownerOfTruck= input.nextLine();
        System.out.println("Nhap trong tai xe: ");
        String truckLoad= input.nextLine();

        truckArrayList.add(new Truck(plateNumberOfTruck,producerOfTruck,yearOfProductionOfTruck,ownerOfTruck,truckLoad));
        System.err.println("Them moi thanh cong");
    }

    @Override
    public void display() {
        for (Truck truck:truckArrayList){
            System.out.println(truck);
        }

    }

    @Override
    public void remove() {

    }

    @Override
    public void stop() {

    }
}
