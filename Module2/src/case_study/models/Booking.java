package case_study.models;

public class Booking implements Comparable<Booking> {
    private int bookingCode;
    private String startDay;
    private String endDay;
    private Customer customer;
    private Facility facilityCode;
    private String serviceName;
    private String typeOfService;


    public Booking(int bookingCode, String startDay, String endDay, Customer customer, Facility facilityCode, String serviceName, String typeOfService) {
        this.bookingCode = bookingCode;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customer = customer;
        this.facilityCode = facilityCode;
        this.serviceName = serviceName;
        this.typeOfService = typeOfService;
    }

    public Booking() {

    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(Facility facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{ " +
                " bookingCode='" + bookingCode + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", customerCode=" + customer.getCustomerNumber() + ", customerName= " + customer.getName() +
                ", facilityCode=" + facilityCode.getFacilityCode() +
                ", serviceName='" + serviceName + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        return this.bookingCode - o.bookingCode;
    }

    public String getBookingInfo(){
        return this.bookingCode+","+this.startDay+","+this.endDay+","+this.customer.getCustomerNumber()+","+this.facilityCode.getFacilityCode()+","+this.serviceName+","+this.typeOfService;
    }
}