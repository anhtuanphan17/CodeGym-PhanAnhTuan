package case_study.models;

public class House extends Facility{
    private String roomStandard;
    private int floor;


    public House(String facilityCode,String nameOfService , double squareMeter, double rentalPrice, int maxCapacity, String rentalType,String roomStandard,int floor) {
        super(facilityCode,nameOfService,squareMeter, rentalPrice, maxCapacity, rentalType);
        this.roomStandard = roomStandard;
        this.floor =floor;


    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                "facilityCode='" + facilityCode + '\'' +
                ", nameOfService='" + nameOfService + '\'' +
                ", squareMeter=" + squareMeter +
                ", rentalPrice=" + rentalPrice +
                ", maxCapacity=" + maxCapacity +
                ", rentalType='" + rentalType + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", floor=" + floor +
                '}';
    }

    public String getHouseInfo(){
        return super.getFacilityInfo()+","+this.roomStandard+","+this.floor;
    }
}
