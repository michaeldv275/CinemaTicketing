/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UltimateDesignChallenge;

/**
 *
 * @author Angel
 */
public class Cinema {
    
    private String name;
    private int numOfFloors;
    private int numOfSeatsInARow;
    private int numOfSeatsInACol;
    private float pricePerSeat;

    public Cinema(String name, int numOfFloors, int numOfSeatsInARow, int numOfSeatsInACol, float pricePerSeat) {
        this.name = name;
        this.numOfFloors = numOfFloors;
        this.numOfSeatsInARow = numOfSeatsInARow;
        this.numOfSeatsInACol = numOfSeatsInACol;
        this.pricePerSeat = pricePerSeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public int getNumOfSeatsInARow() {
        return numOfSeatsInARow;
    }

    public void setNumOfSeatsInARow(int numOfSeatsInARow) {
        this.numOfSeatsInARow = numOfSeatsInARow;
    }

    public int getNumOfSeatsInACol() {
        return numOfSeatsInACol;
    }

    public void setNumOfSeatsInACol(int numOfSeatsInACol) {
        this.numOfSeatsInACol = numOfSeatsInACol;
    }

    public float getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(float pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }
    
    
}
