//package LLD.DesignParkingLot;
//
//import java.util.*;
//
//
//// customer: pay for ticket,
////           take the ticket,
////           scan the ticket
//// Parking lot attendee: takes cash and give tickets,
////                       login logout
//// admin:   manage fair,
////          add parking spaces,
////          manage entrance and exits,
////          add Floors
//// system:  managing the parking lot like
////          calculating fare,
////          showing available spots,
////          guiding to the parking space,
////          assign a parking spot to vehicle
//
//// parking Lot -> floors -> parkingSpots
//// Ticket ->Vehicle
////        ->parkingSpot
////
//enum VehicleType
//{
//    CAR,
//    SUV,
//    VAN,
//    JEEP,
//    TRUCK
//}
//
//enum ParkingSpotType
//{
//    LARGEVEHICLES,
//    HANDICAPPED,
//    FOURWHEELERS,
//    COMPACTSIZE,
//    SUV
//}
//abstract class Vehicle
//{
//    private int licenseNo;
//    private  VehicleType vehicleType;
//    private ParkingTicket parkingTicket;
//
//    public Vehicle(int licenseNo, VehicleType vehicleType, ParkingTicket parkingTicket) {
//        this.licenseNo = licenseNo;
//        this.vehicleType = vehicleType;
//        this.parkingTicket = parkingTicket;
//    }
//
//    void assignTicket(ParkingTicket parkingTicket)
//    {
//        this.parkingTicket = parkingTicket;
//    }
//}
//
//
//class Truck extends Vehicle
//{
//    public Truck(int licenseNo,  ParkingTicket parkingTicket)
//    {
//        super( licenseNo, VehicleType.TRUCK,  parkingTicket);
//    }
//}
//class Car extends Vehicle
//{
//    public Car(int licenseNo,  ParkingTicket parkingTicket)
//    {
//        super( licenseNo, VehicleType.CAR,  parkingTicket);
//    }
//}
//
//class Suv extends Vehicle
//{
//    public Suv(int licenseNo,  ParkingTicket parkingTicket)
//    {
//        super( licenseNo, VehicleType.SUV,  parkingTicket);
//    }
//}
//abstract class ParkingSpot
//{
//    private String no;
//    private Vehicle vehicle;
//    private boolean free;
//
//    public ParkingSpotType getParkingSpotType() {
//        return parkingSpotType;
//    }
//
//    private ParkingSpotType parkingSpotType;
//
//    public ParkingSpot(String no, ParkingSpotType parkingSpotType) {
//        this.no = no;
//        this.parkingSpotType = parkingSpotType;
//    }
//
//    void AssignVehicle(Vehicle vehicle)
//    {
//        this.vehicle = vehicle;
//        this.free = false;
//    }
//    void removeVehicle(Vehicle vehicle)
//    {
//        this.vehicle = null;
//        free = true;
//    }
//}
//class  LargeSpot extends ParkingSpot
//{
//    public LargeSpot(String no ) {
//        super(no, ParkingSpotType.LARGEVEHICLES);
//    }
//}
//class HandicappedSpot extends ParkingSpot
//{
//    public HandicappedSpot(String no) {
//        super(no, ParkingSpotType.HANDICAPPED);
//    }
//}
//class CompactSpot extends ParkingSpot
//{
//
//    public CompactSpot(String no) {
//        super(no, ParkingSpotType.COMPACTSIZE);
//    }
//}
//class SuvSpot extends ParkingSpot
//{
//
//    public SuvSpot(String no) {
//        super(no, ParkingSpotType.SUV);
//    }
//}
//
//
//
// class ParkingTicket {
//
//    private String slotNumber;
//    private String vehicleNumber;
//    private Date date;
////    private Vehicle vehicle;
//
//    public ParkingTicket(String slotNumber, String vehicleNumber, Vehicle vehicle, Date date) {
//
//        this.slotNumber = slotNumber;
//        this.vehicleNumber = vehicleNumber;
//
////        this.setVehicle(vehicle);
//    }
//
//
//    @Override
//    public String toString() {
//        return "Ticket [slotNumber=" + slotNumber + ", vehicleNumber=" + vehicleNumber + ", date=" + date
//                + ", vehicleSize=";
//    }
//
//    public String getSlotNumber() {
//        return slotNumber;
//    }
//
//    public void setSlotNumber(String slotNumber) {
//        this.slotNumber = slotNumber;
//    }
//
//    public String getVehicleNumber() {
//        return vehicleNumber;
//    }
//
//    public void setVehicleNumber(String vehicleNumber) {
//        this.vehicleNumber = vehicleNumber;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
////    public Vehicle getVehicle() {
////        return vehicle;
////    }
////
////    public void setVehicle(Vehicle vehicle) {
////        this.vehicle = vehicle;
////    }
//}
//
//// 2 objects will be same as per hashcode = slotId+issued date hence the hashset can find
//class ParkingFloor
//{
//    HashMap<ParkingSpotType, PriorityQueue<ParkingSpot>> vacantSpots;
//    HashMap<ParkingSpotType, Set<ParkingSpot>> filledSpots;
//
//    ParkingFloor()
//    {
//        vacantSpots = new HashMap<>();
//        filledSpots = new HashMap<>();
//    }
//    void addSpots(ParkingSpotType parkingSpotType, ParkingSpot  parkingSpot)
//    {
//        PriorityQueue<ParkingSpot> existingSpots = vacantSpots.getOrDefault(parkingSpotType,new PriorityQueue<>());
//        existingSpots.add(parkingSpot);
//        vacantSpots.put(parkingSpotType,existingSpots);
//    }
//    ParkingSpot assignSpot(ParkingSpotType parkingSpotType, Vehicle vehicle)
//    {
//        if(vacantSpots.size()>0) {
//            PriorityQueue<ParkingSpot> existingSpots  = vacantSpots.get(parkingSpotType);
//            ParkingSpot parkingSpot = existingSpots.poll();
//            parkingSpot.AssignVehicle(vehicle);
//            List<ParkingSpot> fillingSpots = filledSpots.getOrDefault(parkingSpotType, new ArrayList<ParkingSpot>());
//            fillingSpots.add(parkingSpot);
//            filledSpots.put(parkingSpotType,fillingSpots);
//        }
//
//        return null;
//    }
//    ParkingSpot freeSpot(ParkingSpot parkingSpot)
//    {
//        List<ParkingSpot> list = filledSpots.get(parkingSpot.getParkingSpotType());
//        ParkingSpot freedSpot = list.get(parkingSpot);
//        vacantSpots.get(parkingSpotType).add();
//            ParkingSpot parkingSpot = .poll();
//            parkingSpot.AssignVehicle(vehicle);
//            List<ParkingSpot> fillingSpots = filledSpots.getOrDefault(parkingSpotType, new ArrayList<ParkingSpot>());
//            fillingSpots.add(parkingSpot);
//            filledSpots.put(parkingSpotType,fillingSpots);
//        }
//        else
//        {
//            return null;
//        }
//    }
//
//}
