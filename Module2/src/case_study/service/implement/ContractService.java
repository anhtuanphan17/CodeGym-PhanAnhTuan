package case_study.service;

import case_study.models.Booking;
import case_study.models.Contract;
import case_study.models.Customer;
import case_study.service.implement.BookingService;

import java.util.*;

public class ContractService implements IContractService {
    static  Scanner scanner = new Scanner(System.in);


    List<Contract> contractList = new ArrayList<>();


    @Override
    public void createNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = BookingService.sendBooking();

        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();
            System.out.println("Creating contract for this booking"+ booking.toString());
            System.out.println("Creating contract for this customer"+ customer.toString());
            System.out.println("Input contract number");
            String contractNumber = scanner.nextLine();
            System.out.println("deposit money");
            int depositMoney = scanner.nextInt();
            System.out.println("input total money");
            int totalMoney = scanner.nextInt();
            Contract contract = new Contract(contractNumber,booking,depositMoney,totalMoney,customer);
            contractList.add(contract);
            System.out.println("added successfully \n"+contract.toString() );


        }
    }

    @Override
    public void displayListContract() {
        for(Contract contract: contractList){
            System.out.println(contract);
        }

    }

    @Override
    public void editContract() {

    }

    @Override
    public void returnMainMenu() {

    }
}