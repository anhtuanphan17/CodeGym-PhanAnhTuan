package bai_tap_lam_them.quan_ly_xe.controller;

import bai_tap_lam_them.quan_ly_xe.service.BikeService;
import bai_tap_lam_them.quan_ly_xe.service.CarService;

import bai_tap_lam_them.quan_ly_xe.service.TruckService;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        TruckService truckService = new TruckService();
        CarService carService = new CarService();
        BikeService bikeService = new BikeService();


        Scanner input = new Scanner(System.in);


        while (true) {

            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "chọn chương trình\n" +
                    "1.Thêm mới phương tiện\n" +
                    "2. Hiển Thị Phương Tiện\n" +
                    "3. Xóa Phương Tiện\n" +
                    "4. Thoát\n");

            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("which means of transportation you want to add: \n" +
                            "1. Xe May\n" +
                            "2. Xe Hoi\n" +
                            "3. Xe Tai");
                    int choose1 = input.nextInt();
                    switch (choose1) {
                        case 1:
                            bikeService.add();
                            break;
                        case 2:
                            carService.add();
                            break;
                        case 3:
                            truckService.add();
                            break;
                    }
                    break;

                case 2:
                    System.out.println("which means of transportation you want to show: \n" +
                            "1. Xe May\n" +
                            "2. Xe Hoi\n" +
                            "3. Xe Tai");
                    int choose2 = input.nextInt();
                    switch (choose2) {
                        case 1:
                            bikeService.display();
                            break;
                        case 2:
                            carService.display();
                            break;
                        case 3:
                            truckService.display();
                            break;
                    }

                case 3:
                    System.out.println("Nhap vao bien kiem soat can xoa");
                    String inputPlateNumber = input.nextLine();


                    break;
                case 4:
                    System.exit(4);
                    break;


            }


        }


    }

}

