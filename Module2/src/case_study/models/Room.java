package case_study.models;

public class Room extends Facility{
    private String freeIncludedService;

    public Room(String facilityCode,String nameOfService,double squareMeter, double rentalPrice,int maxCapacity,String rentalType,String freeIncludedService){
        super(facilityCode,nameOfService,squareMeter,rentalPrice,maxCapacity,rentalType);
        this.freeIncludedService=freeIncludedService;
    }

    public String getFreeIncludedService() {
        return freeIncludedService;
    }

    public void setFreeIncludedService(String freeIncludedService) {
        this.freeIncludedService = freeIncludedService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "facilityCode='" + facilityCode + '\'' +
                ", nameOfService='" + nameOfService + '\'' +
                ", squareMeter=" + squareMeter +
                ", rentalPrice=" + rentalPrice +
                ", maxCapacity=" + maxCapacity +
                ", rentalType='" + rentalType + '\'' +
                ", freeIncludedService='" + freeIncludedService + '\'' +
                '}';
    }

    public String getRoomInfo(){
        return super.getFacilityInfo()+","+this.freeIncludedService;
    }
}

