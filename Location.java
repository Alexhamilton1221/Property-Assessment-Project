/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Lab #2 Location.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 

public class Location {

    // Attributes

    private int neighbourhoodID;
    private String neighbourhood;
    private String ward;

    // Constructor

    public Location(int neighbourhoodID, String neighbourhood, String ward) {
        this.neighbourhoodID = neighbourhoodID;
        this.neighbourhood = neighbourhood;
        this.ward = ward;
    }

    /** Override Methods */ 

    @Override
    public String toString() {
        return neighbourhood;
    }

    /** Getter/Setter Methods */ 


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
