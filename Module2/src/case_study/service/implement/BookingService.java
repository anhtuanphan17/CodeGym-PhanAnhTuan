package case_study.service.implement;

import case_study.models.Booking;
import case_study.models.Customer;
import case_study.models.Facility;
import case_study.service.IBookingService;
import case_study.ultil.BookingComparator;
import case_study.ultil.ReadAndWrite;


import java.util.*;

public class BookingService implements IBookingService {
   static String bookingFile  = "C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\case_study\\data\\booking.csv";
    static TreeSet<Booking> bookingSet = ReadAndWrite.readBookingTreeSetFromCSV(bookingFile,CustomerService.customerLinkedList,FacilityService.facilityList);

    static Scanner scanner = new Scanner(System.in);

    int number =1;

    @Override
    public void addNewBooking() {
        int bookingCode =number++;

        System.out.println("input startDay");
        String startDay = scanner.nextLine();
        System.out.println("input endDay");
        String endDay = scanner.nextLine();
        Customer customer = chooseCustomer();
        Facility facility =  chooseFacility();
        System.out.println("input nameOfServicee ");
        String nameOfService = scanner.nextLine();
        System.out.println("input type of service");
        String typeOfService = scanner.nextLine();
        Booking booking = new Booking(bookingCode, startDay, endDay, customer,facility, nameOfService, typeOfService);
        bookingSet.add(booking);

        ReadAndWrite.writeBookingTreeSetToCSV(bookingSet,bookingFile,false);
        System.err.println("added successfully");

    }

    public static Set<Booking> sendBooking(){
        return bookingSet;
    }

    public static Customer chooseCustomer() {
        System.out.println("Customers list");
        for (Customer customer : CustomerService.customerLinkedList) {
            System.out.println(customer.getCustomerInfo());
        }
        System.out.println("Input customer ID");
        String customerID = scanner.nextLine();

        boolean check = true;
        while (check) {
            for (Customer customer : CustomerService.customerLinkedList) {
                if (customerID.equals(customer.getCustomerNumber())) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("Input customer ID again");
                customerID = scanner.nextLine();
            }

        }
        return null;

    }


    public static Facility chooseFacility() {
        System.out.println("Facility list: \n");
        for (Map.Entry<Facility, Integer> facility : FacilityService.facilityList.entrySet()) {
            System.out.println(facility);
        }
        System.out.println("input facility code");
        String facilityCode = scanner.nextLine();
        boolean check = true;

        while (check) {
            for (Map.Entry<Facility, Integer> facility : FacilityService.facilityList.entrySet()) {
                if (facility.getKey().getFacilityCode().equals(facilityCode)) {
                    return facility.getKey();
                }
            }
            if (check) {
                System.out.println("Input facilityCode again");
                facilityCode = scanner.nextLine();
            }
        }
        return  null;
    }



    @Override
    public void displayListBooking() {
        List<Booking> bookingList = new ArrayList<>(bookingSet);
        Collections.sort(bookingList, new BookingComparator());
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }


      @Override
    public void returnMainMenu() {

    }
}
