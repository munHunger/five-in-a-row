package se.munhunger.fir.model;

public class Row
{
    /**
     * The length of the row
     */
    public int length;
    /**
     * if open, then it isn't blocked on both sides
     */
    public boolean isOpen;
    /**
     * if free, then there is nothing on both sides
     */
    public boolean isFree;

    public Row(){}

    public Row(int length, boolean isOpen, boolean isFree) {
        this.length = length;
        this.isOpen = isOpen;
        this.isFree = isFree;
    }
}
