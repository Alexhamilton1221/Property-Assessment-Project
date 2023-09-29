/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Lab #2 Location.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 
// package Lab2;

public class Location {
    private int neighbourhoodID;
    private String neighbourhood;
    private String ward;

    public Location(int neighbourhoodID, String neighbourhood, String ward) {
        this.neighbourhoodID = neighbourhoodID;
        this.neighbourhood = neighbourhood;
        this.ward = ward;
    }
    @Override
    public String toString() {
        return neighbourhood;
    }



    public int getNeighbourhoodID() {
        return neighbourhoodID;
    }

    public void setNeighbourhoodID(int neighbourhoodID) {
        this.neighbourhoodID = neighbourhoodID;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}
