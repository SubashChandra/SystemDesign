package ParkingLot;

import java.util.Scanner;

public class MainProgram {
    private static String create = "CREATE";
    private static String park = "PARK";
    private static String leave = "LEAVE";
    private static String status = "STATUS";
    private static String allocated = "ALLOCATED";
    private static String free = "free";
    private static String exit = "EXIT";



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        ParkingLot parkingLot = null;
        while(true){
            input = scanner.nextLine();
            String[] s = input.split(" ");
            if(create.equalsIgnoreCase(s[0])){
                int slots = Integer.parseInt(s[1]);
                if(parkingLot == null) {
                    parkingLot = new ParkingLot(slots);
                    System.out.println("Parking lot created");
                }
                else{
                    System.out.println("Parking lot already exists");
                }
            }
            else{
                if(parkingLot == null){
                    System.out.println("ERROR: Parking Lot not created");
                    continue;
                }
            }

            if(park.equalsIgnoreCase(s[0])){
                Boolean parkStatus = parkingLot.parkVehicle(s[1],s[2]);
                if(parkStatus){
                    System.out.println("Car parked successfully");
                }
                else{
                    System.out.println("Invalid Input or parking full");
                }
            }
            else if(leave.equalsIgnoreCase(s[0])){
                Boolean leaveStatus = parkingLot.leaveParking(Integer.parseInt(s[1]));
                if(leaveStatus){
                    System.out.println("Parking slot freed successfully");
                }
                else{
                    System.out.println("Invalid Input");
                }

            }
            else if(status.equalsIgnoreCase(s[0])){
                if(allocated.equalsIgnoreCase(s[1])){
                    parkingLot.allocatedSlotStatus();
                }
                else if(free.equalsIgnoreCase(s[1])){
                    parkingLot.printFreeSlotStatus();
                }
            }
            else if(exit.equalsIgnoreCase(s[0])){
                break;
            }
            else{

            }
        }
    }
}
