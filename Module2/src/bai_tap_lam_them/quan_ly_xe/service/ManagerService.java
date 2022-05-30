//package bai_tap_lam_them.quan_ly_xe.service;
//
//import bai_tap_lam_them.quan_ly_xe.model.Bike;

//public class ManagerService  {
//

//     static ArrayList<Bike> bikeArrayList = new ArrayList<>();
//
//    static {
//        bikeArrayList.add(new Bike("48K-1278", "honda", "2019", "Hoang", "80"));
//        bikeArrayList.add(new Bike("48K-1275", "yamaha", "2009", "Duy", "50"));
//        bikeArrayList.add(new Bike("48K-1277", "wave", "2002", "Long", "150"));
//
//    }
//
//    private static ArrayList<Car> carArrayList = new ArrayList<>();
//
//    static {
//        carArrayList.add(new Car("47F-1234", "Toyota", "2012", "Tuan", "7", "Xe gia dinh"));
//        carArrayList.add(new Car("47F-1235", "Ford", "2013", "Long", "12", "Du lich"));
//        carArrayList.add(new Car("47F-1236", "Huyndai", "2014", "Hung", "24", "Xe khach"));
//
//    }
//
//    private static ArrayList<Truck> truckArrayList = new ArrayList<>();
//
//    static {
//        truckArrayList.add(new Truck("47M-4567", "Huyndai", "2018", "Huy", "20"));
//        truckArrayList.add(new Truck("47M-4568", "Huyndai", "2012", "Dung", "15"));
//        truckArrayList.add(new Truck("47M-4569", "Huyndai", "2011", "Vinh", "28"));
//
//    }
//
//
////    @Override
//    public void add() {
//
//        System.out.println("which means of transportation you want to add: \n"+
//                "1. Xe May\n"+
//                "2. Xe Hoi\n"+
//                "3. Xe Tai");
//
//        int choose = input.nextInt();
//        switch (choose) {
//            case 1:
//                System.out.println("Nhap bien so: ");
//                String plateNumberOfBike= input.nextLine();
//                System.out.println("Nhap hang san xuat: ");
//                String producerOfBike = input.nextLine();
//                System.out.println("Nhap nam san xuat: ");
//                String yearOfProductionOfBike= input.nextLine();
//                System.out.println("Nhap chu so huu: ");
//                String ownerOfBike= input.nextLine();
//                System.out.println("Nhap cong suat: ");
//                String capacityOfBike= input.nextLine();
//                bikeArrayList.add(new Bike(plateNumberOfBike,producerOfBike,yearOfProductionOfBike,ownerOfBike,capacityOfBike));
//                System.err.println("Them moi thanh cong");
//                break;
//            case 2:
//                System.out.println("Nhap bien so: ");
//                String plateNumberOfCar= input.nextLine();
//                System.out.println("Nhap hang san xuat: ");
//                String producerOfCar = input.nextLine();
//                System.out.println("Nhap nam san xuat: ");
//                String yearOfProductionOfCar= input.nextLine();
//                System.out.println("Nhap chu so huu: ");
//                String ownerOfCar= input.nextLine();
//                System.out.println("Nhap loai xe: ");
//                String seatNumberOfCar= input.nextLine();
//                System.out.println("Nhap loai xe: ");
//                String typeOfCar= input.nextLine();
//
//                carArrayList.add(new Car(plateNumberOfCar,producerOfCar,yearOfProductionOfCar,ownerOfCar,seatNumberOfCar,typeOfCar));
//                System.err.println("Them moi thanh cong");
//                break;
//            case 3:
//                System.out.println("Nhap bien so: ");
//                String plateNumberOfTruck= input.nextLine();
//                System.out.println("Nhap hang san xuat: ");
//                String producerOfTruck = input.nextLine();
//                System.out.println("Nhap nam san xuat: ");
//                String yearOfProductionOfTruck= input.nextLine();
//                System.out.println("Nhap chu so huu: ");
//                String ownerOfTruck= input.nextLine();
//                System.out.println("Nhap trong tai xe: ");
//                String truckLoad= input.nextLine();
//
//                truckArrayList.add(new Truck(plateNumberOfTruck,producerOfTruck,yearOfProductionOfTruck,ownerOfTruck,truckLoad));
//                System.err.println("Them moi thanh cong");
//        }
//    }
//
//
//    @Override
//    public void display() {
//
//    }
//
//    @Override
//    public void remove() {
//
//    }
//
//    @Override
//    public void stop() {
//
//    }
//}
