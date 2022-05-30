package case_study.service.implement;

import case_study.models.Facility;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;
import case_study.service.IFacilityService;
import case_study.ultil.ReadAndWrite;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityService implements IFacilityService {
    static String villaFile = "C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\case_study\\data\\villa.csv";
    static String houseFile = "C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\case_study\\data\\house.csv";
    static String roomFile = "C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\case_study\\data\\room.csv";
    static Map<Villa, Integer> villaIntegerMap = ReadAndWrite.readVillaFromCSV(villaFile);
    static Map<House, Integer> houseIntegerMap = ReadAndWrite.readHouseMapFromCSV(houseFile);
    static Map<Room, Integer> roomIntegerMap = ReadAndWrite.readRoomMapFromCSV(roomFile);

    static Scanner scanner = new Scanner(System.in);
    static Map<Facility, Integer> facilityList = new LinkedHashMap<>();


    @Override
    public void displayFacilityList() {
        for (Map.Entry<Villa, Integer> villa : villaIntegerMap.entrySet()) {
            System.out.println(villa.getKey() + "times used " + villa.getValue());
        }
        for (Map.Entry<House, Integer> house : houseIntegerMap.entrySet()) {
            System.out.println(house.getKey() + "times used " + house.getValue());
        }
        for (Map.Entry<Room, Integer> room : roomIntegerMap.entrySet()) {
            System.out.println(room.getKey() + "times used " + room.getValue());
        }

    }


    @Override
    public void addNewVilla() {
        System.out.println("input facility code");
        String facilityCode = scanner.nextLine();
        System.out.println("input nameOfService");
        String nameOfService = scanner.nextLine();
        System.out.println("input squareMeter");
        double squareMeter = scanner.nextDouble();
        System.out.println("input rentalPrice");
        double rentalPrice = scanner.nextDouble();
        System.out.println("input maxCapacity");
        int maxCapacity = scanner.nextInt();
        System.out.println("input rentalType");
        String rentalType = scanner.nextLine();
        System.out.println("input roomStandard");
        String roomStandard = scanner.nextLine();
        System.out.println("input poolArea");
        double poolArea = scanner.nextDouble();
        System.out.println("input floor");
        int floor = scanner.nextInt();
        villaIntegerMap.put(new Villa(facilityCode, nameOfService, squareMeter, rentalPrice, maxCapacity, rentalType, roomStandard, poolArea, floor), 0);
        ReadAndWrite.writeVillaToCSV(villaIntegerMap, villaFile, false);
        System.err.println("added villa successfully");


    }


    @Override
    public void addNewHouse() {
        System.out.println("input facility code");
        String facilityCode = scanner.nextLine();
        System.out.println("input nameOfService");
        String nameOfService = scanner.nextLine();
        System.out.println("input squareMeter");
        double squareMeter = scanner.nextDouble();
        System.out.println("input rentalPrice");
        double rentalPrice = scanner.nextDouble();
        System.out.println("input maxCapacity");
        int maxCapacity = scanner.nextInt();
        System.out.println("input rentalType");
        String rentalType = scanner.nextLine();
        System.out.println("input roomStandard");
        String roomStandard = scanner.nextLine();
        System.out.println("input floor");
        int floor = scanner.nextInt();

        houseIntegerMap.put(new House(facilityCode, nameOfService, squareMeter, rentalPrice, maxCapacity, rentalType, roomStandard, floor), 0);
        ReadAndWrite.writeHouseMapToCSV(houseIntegerMap, houseFile, false);
        System.err.println("added successfully");

    }


    @Override
    public void addNewRoom() {
        System.out.println("input facility code");
        String facilityCode = scanner.nextLine();
        System.out.println("input nameOfService");
        String nameOfService = scanner.nextLine();
        System.out.println("input squareMeter");
        double squareMeter = scanner.nextDouble();
        System.out.println("input rentalPrice");
        double rentalPrice = scanner.nextDouble();
        System.out.println("input maxCapacity");
        int maxCapacity = scanner.nextInt();
        System.out.println("input rentalType");
        String rentalType = scanner.nextLine();
        System.out.println("input free included service");
        String freeIncludedService = scanner.nextLine();

        roomIntegerMap.put(new Room(facilityCode, nameOfService, squareMeter, rentalPrice, maxCapacity, rentalType, freeIncludedService), 0);
        ReadAndWrite.writeRoomMapToCSV(roomIntegerMap, roomFile, false);
        System.err.println("added Successfully");

    }


    @Override
    public void displayListFacilityMaintenance() {

    }


    public void timeOfUsed(String nameOfService) {
        for (Map.Entry<Villa, Integer> villa : villaIntegerMap.entrySet()) {
           if(villa.getKey().getNameOfService().equals(nameOfService)){
               villa.setValue(villa.getValue()+1);
           }
        }
        for (Map.Entry<House, Integer> house : houseIntegerMap.entrySet()) {
            if (house.getKey().getNameOfService().equals(nameOfService)) {
                house.setValue(house.getValue() + 1);
            }
        }
        for (Map.Entry<Room, Integer> room : roomIntegerMap.entrySet()) {
            if (room.getKey().getNameOfService().equals(nameOfService)) {
                room.setValue(room.getValue() + 1);
            }
        }


    }

    @Override
    public void backToMainMenu() {

    }
}
