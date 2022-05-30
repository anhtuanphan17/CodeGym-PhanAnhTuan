package case_study.controller;

import case_study.service.ContractService;
import case_study.service.implement.*;


import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();
        CustomerService customerService = new CustomerService();
        FacilityService facilityService = new FacilityService();
        BookingService bookingService = new BookingService();
        case_study.service.ContractService contractService = new ContractService();
        PromotionService promotionService = new PromotionService();
        Scanner scanner = new Scanner(System.in);
        int choose =0;

        while (true) {
            System.out.println("Main Menu: \n" +
                    "1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");

            System.out.println("Enter function you want to use: ");

            try{
                choose =Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("please input correct number");
            }
            switch (choose) {
                case 1:
                    System.out.println("Menu: \n" +
                            "1\tDisplay list employees\n" +
                            "2\tAdd new employee\n" +
                            "3\tEdit employee\n" +
                            "4\tReturn main menu\n");
                    System.out.println("enter function you want to use");
                    int chooseEmployee = 0;
                    try{
                        chooseEmployee = Integer.parseInt(scanner.nextLine());
                    }
                    catch (NumberFormatException e){
                        System.out.println("please input correct number");
                    }
                    switch (chooseEmployee) {
                        case 1:
                            employeeService.displayListEmployees();
                            break;
                        case 2:
                            employeeService.addNewEmployee();
                            break;
                        case 3:
                            employeeService.editEmployee();
                            break;
                        case 4:
                            employeeService.returnMainMenu();
                            break;
                    }

                    break;
                case 2:
                    System.out.println("Menu: \n" +
                            "1.\tDisplay list customers\n" +
                            "2.\tAdd new customer\n" +
                            "3.\tEdit customer\n" +
                            "4.\tReturn main menu\n");
                    System.out.println("Enter service you want to use");
                    int chooseCustomer = 0;
                    try{
                        chooseCustomer = Integer.parseInt(scanner.nextLine());
                    }catch (NumberFormatException e){
                        System.out.println("please input correct number");
                    }
                    switch (chooseCustomer) {
                        case 1:
                            customerService.displayListCustomer();
                            break;
                        case 2:
                            customerService.addNewCustomer();
                            break;
                        case 3:
                            customerService.editCustomer();
                            break;
                        case 4:
                            customerService.returnMainMenu();
                            break;
                    }

                    break;

                case 3:
                    System.out.println("Menu: \n" +
                            "1\tDisplay list facility\n" +
                            "2\tAdd new facility\n" +
                            "3\tDisplay list facility maintenance\n" +
                            "4\tReturn main menu\n");
                    System.out.println("Enter service you want to use");
                    int chooseFacility = 0;
                    try {
                        chooseFacility = Integer.parseInt(scanner.nextLine());
                    }catch (NumberFormatException e){
                        System.out.println("please input correct number");
                    }

                    switch (chooseFacility) {
                        case 1:
                            facilityService.displayFacilityList();
                            break;
                        case 2:
                            System.out.println("Which facility you want to add\n" +
                                    "1.Villa\n" +
                                    "2.House\n" +
                                    "3.Room\n");

                            System.out.println("Enter facility you want to add");
                            int choose31 = scanner.nextInt();
                            switch (choose31) {
                                case 1:
                                    facilityService.addNewVilla();
                                    break;
                                case 2:
                                    facilityService.addNewHouse();
                                    break;
                                case 3:
                                    facilityService.addNewRoom();
                                    break;
                            }
                            break;
                        case 3:

                        case 4:
                    }

                    break;
                case 4:
                    System.out.println("Menu: \n" +
                            "1.\tAdd new booking\n" +
                            "2.\tDisplay list booking\n" +
                            "3.\tCreate new contracts\n" +
                            "4.\tDisplay list contracts\n" +
                            "5.\tEdit contracts\n" +
                            "6.\tReturn main menu\n");

                    System.out.println("Enter service you want to use");
                    int chooseBookings =0;

                    try{
                        chooseBookings = Integer.parseInt(scanner.nextLine());
                    }catch (NumberFormatException e){
                        System.out.println("please input correct number");
                    }

                    switch (chooseBookings) {
                        case 1:
                            bookingService.addNewBooking();
                            break;
                        case 2:
                            bookingService.displayListBooking();
                            break;
                        case 3:
                            contractService.createNewContract();
                            break;
                        case 4:
                            contractService.displayListContract();
                            break;
                        case 5:
                        case 6:
                    }

                    break;
                case 5:
                    System.out.println("Menu: \n" +
                            "1.\tDisplay list customers use service\n" +
                            "2.\tDisplay list customers get voucher\n" +
                            "3.\tReturn main menu\n");
                    System.out.println("Enter service you want to use");
                    int choosePromotion = 0;
                    try{
                        choosePromotion =Integer.parseInt(scanner.nextLine());
                    }catch (NumberFormatException e){
                        System.out.println("please input correct number");
                    }

                    switch (choosePromotion) {
                        case 1:
                            promotionService.displayCustomersUseService();
                            break;
                        case 2:
                            promotionService.displayListCustomersGetVoucher();
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 6:
                    System.exit(6);

            }

        }

    }

}