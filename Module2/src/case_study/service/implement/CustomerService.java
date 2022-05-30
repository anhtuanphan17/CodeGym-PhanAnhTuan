package case_study.service.implement;

import case_study.models.Customer;
import case_study.service.ICustomerService;
import case_study.service.IService;
import case_study.ultil.ReadAndWrite;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements IService, ICustomerService {
    String customerPathFile = "C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\case_study\\data\\customer.csv";
    static List<Customer> customerLinkedList = ReadAndWrite.readCustomerFromCSV("C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\case_study\\data\\customer.csv");

    static Scanner scanner = new Scanner(System.in);


    @Override
    public void displayListCustomer() {
        int i=1;
        for (Customer customer : customerLinkedList) {
            System.out.println(i+"."+customer.getCustomerInfo());
            i++;
        }
    }

    @Override
    public void addNewCustomer() {
        System.out.println("input customer number");
        String customerNumber = scanner.nextLine();
        System.out.println("input name");
        String name = scanner.nextLine();
        System.out.println("input date of birth");
        String dateOfBirth = scanner.nextLine();
        System.out.println("input gender");
        String gender = scanner.nextLine();
        System.out.println("input idNumber");
        String idNumber = scanner.nextLine();
        System.out.println("input phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("input email");
        String email = scanner.nextLine();
        System.out.println("input type of customer ");
        String typeOfCustomer = scanner.nextLine();
        System.out.println("input address");
        String address = scanner.nextLine();

        customerLinkedList.add(new Customer(customerNumber, name, dateOfBirth, gender, idNumber, phoneNumber, email, typeOfCustomer, address));
        ReadAndWrite.writeCustomerToCSV(customerLinkedList, customerPathFile, false);
        System.err.println("added successfully");

    }


    @Override
    public void editCustomer() {
        System.out.println("input customerID of customer you want to revise");
        String customerNumber = scanner.nextLine();
        boolean flag = true;
        for (Customer customer : customerLinkedList) {

            if (customer.getCustomerNumber().equals(customerNumber)) {
                System.out.println("input name");
                String name = scanner.nextLine();
                customer.setName(name);
                System.out.println("input date of birth");
                String dateOfBirth = scanner.nextLine();
                customer.setDateOfBirth(dateOfBirth);
                System.out.println("input gender");
                String gender = scanner.nextLine();
                customer.setGender(gender);
                System.out.println("input idNumber");
                String idNumber = scanner.nextLine();
                customer.setIdNumber(idNumber);
                System.out.println("input phone number");
                String phoneNumber = scanner.nextLine();
                customer.setPhoneNumber(phoneNumber);
                System.out.println("input email");
                String email = scanner.nextLine();
                customer.setEmail(email);
                System.out.println("input type of customer ");
                String typeOfCustomer = scanner.nextLine();
                customer.setTypeOfCustomer(typeOfCustomer);
                System.out.println("input address");
                String address = scanner.nextLine();
                customer.setAddress(address);
                flag = false;
                break;
            }

            if (flag) {
                System.err.println("this customer number is not available in current list");

            }
        }

    }

    @Override
    public void returnMainMenu() {

    }
}
