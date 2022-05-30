package case_study.models;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floor;


    public Villa(String facilityCode,String nameOfService ,double squareMeter, double rentalPrice, int maxCapacity, String rentalType,String roomStandard,double poolArea,int floor) {
        super(facilityCode,nameOfService,squareMeter, rentalPrice, maxCapacity, rentalType);
        this.roomStandard=roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "facilityCode='" + facilityCode + '\'' +
                ", nameOfService='" + nameOfService + '\'' +
                ", squareMeter=" + squareMeter +
                ", rentalPrice=" + rentalPrice +
                ", maxCapacity=" + maxCapacity +
                ", rentalType='" + rentalType + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floor=" + floor +
                '}';
    }

    public String getVillaInfo(){
        return super.getFacilityInfo()+this.roomStandard+","+this.poolArea+","+this.floor;
    }

}
