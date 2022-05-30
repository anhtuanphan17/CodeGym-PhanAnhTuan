package case_study.models;

public class Facility {
    String facilityCode;
    String nameOfService;
    double squareMeter;
    double rentalPrice;
    int maxCapacity;
    String rentalType;

    public Facility(String facilityCode, String nameOfService, double squareMeter, double rentalPrice, int maxCapacity, String rentalType) {
        this.facilityCode = facilityCode;
        this.nameOfService = nameOfService;
        this.squareMeter = squareMeter;
        this.rentalPrice = rentalPrice;
        this.maxCapacity = maxCapacity;
        this.rentalType = rentalType;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public double getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(double squareMeter) {
        this.squareMeter = squareMeter;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getFacilityInfo(){
        return this.facilityCode+","+this.nameOfService+","+this.squareMeter+","+this.rentalPrice+","+this.maxCapacity+","+this.rentalType;
    }

}
