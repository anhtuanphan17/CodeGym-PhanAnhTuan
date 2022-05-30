package case_study.models;

public class Customer extends Person{
    private String customerNumber;
    private String typeOfCustomer;
    private String address;

    public Customer(String name,String dateOfBirth,String gender,String idNumber, String phoneNumber,String email,String customerNumber,String typeOfCustomer,String address){
        super(name,dateOfBirth,gender,idNumber,phoneNumber,email);
        this.customerNumber = customerNumber;
        this.typeOfCustomer=typeOfCustomer;
        this.address=address;

    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber='" + customerNumber + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getCustomerInfo(){
        return this.name+","+this.dateOfBirth+","+this.gender+","+this.idNumber+","+this.phoneNumber+","+this.email+","+this.customerNumber+","+this.typeOfCustomer+","+this.address;

    }
}