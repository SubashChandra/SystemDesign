package ParkingLot;

public class Slot {
    private int slotNo;
    private String regNo;
    private String color;
    private boolean free;

    public Slot(int slotNo) {
        this.slotNo = slotNo;
        this.free = true;
        this.regNo = null;
        this.color = null;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }


    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
