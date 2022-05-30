package case_study.service.implement;

import case_study.models.Employee;
import case_study.service.IEmployeeService;
import case_study.service.IService;
import case_study.ultil.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IService, IEmployeeService {
    String employeeFilePath = "C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\case_study\\data\\employee.csv";
    private static List<Employee> employeesList = ReadAndWrite.readEmployeeFromCSV( "C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\case_study\\data\\employee.csv");

    static Scanner scanner = new Scanner(System.in);


    @Override
    public void displayListEmployees() {
        int i=1;
        for (Employee employee : employeesList) {
            System.out.println(i+ ". "+ employee.getInfoEmployee());
            i++;
        }
    }


    @Override
    public void addNewEmployee() {
        System.out.println("input employee Number: ");
        String employeeNumber = scanner.nextLine();
        System.out.println("input name");
        String name = scanner.nextLine();
        System.out.println("input dateOfBirth");
        String dateOfBirth = scanner.nextLine();
        System.out.println("input gender ");
        String gender = scanner.nextLine();
        System.out.println("input idNumber");
        String idNumber = scanner.nextLine();
        System.out.println("input phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("input email");
        String email = scanner.nextLine();
        System.out.println("input academic level");
        String academicLevel = scanner.nextLine();
        System.out.println("input position");
        String position = scanner.nextLine();
        System.out.println("input salary");
        String salary = scanner.nextLine();

        employeesList.add(new Employee(employeeNumber, name, dateOfBirth, gender, idNumber, phoneNumber, email, academicLevel, position, salary));
        ReadAndWrite.writeStringEmployeeToCSV(employeesList,employeeFilePath,false) ;
        System.err.println("added successfully");
        displayListEmployees();

    }


    @Override
    public void editEmployee() {
        System.out.println("Enter employee number you want to revise");
        String employeeNumber = scanner.nextLine();
        boolean flag =true;
        for (Employee employee : employeesList) {
            if (employee.getEmployeeNumber().equals(employeeNumber)) {
                System.out.println("input name");
                String name = scanner.nextLine();
                employee.setName(name);
                System.out.println("input dateOfBirth");
                String dateOfBirth = scanner.nextLine();
                employee.setDateOfBirth(dateOfBirth);
                System.out.println("input gender ");
                String gender = scanner.nextLine();
                employee.setGender(gender);
                System.out.println("input idNumber");
                String idNumber = scanner.nextLine();
                employee.setIdNumber(idNumber);
                System.out.println("input phoneNumber");
                String phoneNumber = scanner.nextLine();
                employee.setPhoneNumber(phoneNumber);
                System.out.println("input email");
                String email = scanner.nextLine();
                employee.setEmail(email);
                System.out.println("input academic level");
                String academicLevel = scanner.nextLine();
                employee.setAcademicLevel(academicLevel);
                System.out.println("input position");
                String position = scanner.nextLine();
                employee.setPosition(position);
                System.out.println("input salary");
                String salary = scanner.nextLine();
                employee.setSalary(salary);

                displayListEmployees();
                flag =false;
                break;


            }

        }if(flag){
            System.err.println("this employee number is not available in current list");
        }

    }

    @Override
    public void returnMainMenu() {

    }

}
