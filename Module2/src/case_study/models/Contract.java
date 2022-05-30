package case_study.models;

public class Contract {
    private String contractNumber;
    private Booking booking;
    private int depositMoney;
    private int totalPayment;
    private Customer customer;

    public Contract(String contractNumber, Booking booking, int depositMoney, int totalPayment, Customer customer) {
        this.contractNumber = contractNumber;
        this.booking = booking;
        this.depositMoney = depositMoney;
        this.totalPayment = totalPayment;
        this.customer = customer;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Booking getBookingCode() {
        return booking;
    }

    public void setBookingCode(Booking bookingCode) {
        this.booking = bookingCode;
    }

    public int getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(int depositMoney) {
        this.depositMoney = depositMoney;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber='" + contractNumber + '\'' +
                ", bookingNumber='" + booking.getBookingCode() + '\'' +
                ", depositMoney=" + depositMoney +
                ", totalPayment=" + totalPayment +
                ", customerCode='" + customer.getCustomerNumber() + '\'' +
                '}';
    }

    public String getContractInfo() {
        return this.contractNumber + ',' + this.booking.getBookingCode() + ',' + this.depositMoney + ',' + this.totalPayment + ',' + this.customer.getCustomerNumber();
    }
}
