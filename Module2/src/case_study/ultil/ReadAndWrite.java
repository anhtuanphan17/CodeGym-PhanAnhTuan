package case_study.ultil;

import case_study.models.*;

import java.io.*;
import java.util.*;

public class ReadAndWrite {
    public static void writeToCSV(List<String> stringList, String path, boolean append) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String line : stringList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static List<String> readFromCSV(String path) {
        List<String> stringList = new ArrayList<>();
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static void writeStringEmployeeToCSV(List<Employee> employeeList, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.getInfoEmployee());
        }
        writeToCSV(stringList, path, append);

    }

    public static List<Employee> readEmployeeFromCSV(String path) {
        List<String> stringList = ReadAndWrite.readFromCSV(path);
        List<Employee> employeeList = new ArrayList<>();

        String[] array = null;
        for (String line : stringList) {
            array = line.split(",");
            Employee employee = new Employee(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8], array[9]);
            employeeList.add(employee);
        }
        return employeeList;
    }

    public static void writeCustomerToCSV(List<Customer> customerList, String path, boolean append) {
        List<String> stringList = new ArrayList<>();

        for (Customer customer : customerList) {
            stringList.add(customer.getCustomerInfo());
        }
        writeToCSV(stringList, path, append);
    }


    public static List<Customer> readCustomerFromCSV(String path) {
        List<String> stringList = ReadAndWrite.readFromCSV(path);
        List<Customer> customerList = new LinkedList<>();
        String[] array = null;
        for (String line : stringList) {
            array = line.split(",");
            try {
                customerList.add(new Customer(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }


    public static void writeBookingTreeSetToCSV(TreeSet<Booking> bookingTreeSet, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Booking booking : bookingTreeSet) {
            stringList.add(booking.getBookingInfo());
        }
        writeToCSV(stringList, path, append);
    }

    public static TreeSet<Booking> readBookingTreeSetFromCSV(String path, List<Customer> customerLinkedList, Map<Facility, Integer> facilityList) {
        List<String> stringList = ReadAndWrite.readFromCSV(path);
        TreeSet<Booking> bookingTreeSet = new TreeSet<>();
        String[] array = null;


        for (String line : stringList) {
            array = line.split(",");
            Customer customer = customerValueOfBooking(path, customerLinkedList);
            for (Map.Entry<Facility, Integer> facility : facilityList.entrySet()) {
                if (facility.getKey().getFacilityCode().equals(array[4])) {

                    bookingTreeSet.add(new Booking(Integer.parseInt(array[0]), array[1], array[2], customer, facility.getKey(), array[5], array[6]));
                }

            }

        }
        return bookingTreeSet;
    }

    public static Customer customerValueOfBooking(String path, List<Customer> customerLinkedList) {
        List<String> stringList = ReadAndWrite.readFromCSV(path);
        TreeSet<Booking> bookingTreeSet = new TreeSet<>();
        String[] array = null;

        for (String line : stringList) {
            array = line.split(",");
            for (Customer customer : customerLinkedList) {
                if (customer.getCustomerNumber().equals(array[3])) ;
                return customer;
            }
        }
        return null;
    }


    public static void WriteContractStringToCSV(List<Contract> contractList, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Contract contract : contractList) {
            stringList.add(contract.getContractInfo());
        }
        writeToCSV(stringList, path, append);
    }


//
//
//            public static List<Contract> readListContracFromCSV (String path) {
//                List<String> stringList = ReadAndWrite.readFromCSV(path);
//                List<Contract> contractList = new ArrayList<>();
//                String[] array = null;
//                for (String line : stringList) {
//                    array = line.split(",");
//                    contractList.add(new Contract(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), array[4]));
//
//                }
//
//
//            }

    public static void writeVillaToCSV(Map<Villa, Integer> villaMap, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<Villa> villaSet = villaMap.keySet();
        for (Villa key : villaSet) {
            stringList.add(key.getVillaInfo() + "," + villaMap.get(key));

        }
        writeToCSV(stringList, path, append);

    }

    public static Map<Villa, Integer> readVillaFromCSV(String path) {
        List<String> stringList = ReadAndWrite.readFromCSV(path);
        Map<Villa, Integer> villaMap = new LinkedHashMap<>();
        String[] array = null;
        for (String line : stringList) {
            array = line.split(",");
            Villa villa = new Villa(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6], Double.parseDouble(array[7]), Integer.parseInt(array[8]));
            villaMap.put(villa, Integer.parseInt(array[9]));
        }
        return villaMap;
    }

    public static void writeHouseMapToCSV(Map<House, Integer> houseMap, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<House> villaSet = houseMap.keySet();
        for (House key : villaSet) {
            stringList.add(key.getHouseInfo() + "," + houseMap.get(key));

        }
        writeToCSV(stringList, path, append);

    }

    public static Map<House,Integer> readHouseMapFromCSV(String path){
        List<String> stringList = ReadAndWrite.readFromCSV(path);
        Map<House, Integer> houseMap = new LinkedHashMap<>();
        String[] array = null;
        for (String line : stringList) {
            array = line.split(",");
            House house = new House(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6], Integer.parseInt(array[7]));
            houseMap.put(house, Integer.parseInt(array[8]));
        }
        return houseMap;
    }

    public static void writeRoomMapToCSV(Map<Room, Integer> roomMap, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<Room> roomSet = roomMap.keySet();
        for (Room key : roomSet) {
            stringList.add(key.getRoomInfo() + "," + roomMap.get(key));

        }
        writeToCSV(stringList, path, append);

    }

    public static Map<Room,Integer> readRoomMapFromCSV(String path){
        List<String> stringList = ReadAndWrite.readFromCSV(path);
        Map<Room, Integer> roomMap = new LinkedHashMap<>();
        String[] array = null;
        for (String line : stringList) {
            array = line.split(",");
            Room room = new Room(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6]);
            roomMap.put(room, Integer.parseInt(array[7]));
        }
        return roomMap;
    }





}