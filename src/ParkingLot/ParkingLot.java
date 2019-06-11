package ParkingLot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ParkingLot {

    private int slotCount;
    private TreeMap<Integer, Slot> slotInfo;
    Comparator<Slot> slotComparator = new Comparator<Slot>() {
        @Override
        public int compare(Slot s1, Slot s2) {
            return s1.getSlotNo() - s2.getSlotNo();
        }
    };
    private PriorityQueue<Slot> freeSlots;


    public ParkingLot(int slotCount) {
        this.slotCount = slotCount;
        slotInfo = new TreeMap<Integer, Slot>();
        freeSlots = new PriorityQueue<Slot>(slotComparator);
        populateParking();
    }

    private void populateParking() {
        for(int i = 1;i<=slotCount;i++){
            Slot newSlot = new Slot(i);
            slotInfo.put(i, newSlot);
            freeSlots.add(newSlot);
        }
    }

    public Boolean parkVehicle(String regNo, String color){
        if(freeSlots.size()==0)
            return false;

        Slot freeSlot = freeSlots.poll();
        freeSlot.setRegNo(regNo);
        freeSlot.setColor(color);
        freeSlot.setFree(false);
        return true;
    }

    public Boolean leaveParking(int slotNo){
        if(!slotInfo.containsKey(slotNo) || slotInfo.get(slotNo).isFree()){
            return false;
        }

        Slot curSlot = slotInfo.get(slotNo);
        curSlot.setFree(true);
        curSlot.setColor(null);
        curSlot.setRegNo(null);
        freeSlots.add(curSlot);
        return true;
    }

    public void printFreeSlotStatus(){
        System.out.println("Free Slot Status");
        for(Integer slotId: slotInfo.keySet()){
            Slot curSlot = slotInfo.get(slotId);
            if(curSlot.isFree())
                System.out.println(curSlot.getSlotNo() + "-> free" );
        }

        System.out.println("---------------------------");
    }

    public void allocatedSlotStatus(){
        System.out.println("Allocated Slots Status");
        for(Integer slotId: slotInfo.keySet()){
            Slot curSlot = slotInfo.get(slotId);
            if(!curSlot.isFree())
                System.out.println(curSlot.getSlotNo() + "-> " + curSlot.getRegNo() + " ; " + curSlot.getColor() );
        }

        System.out.println("---------------------------");
    }




}
