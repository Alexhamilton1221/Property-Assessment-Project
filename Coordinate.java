/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Coordinate.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 
public class Coordinate {

    // Attributes

    private double latitude;
    private double longitude;
    private String pointLocation;

    // Constructor

    public Coordinate(double latitude, double longitude, String pointLocation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.pointLocation = pointLocation;
    }

    // Override Methods 

    @Override
    public String toString() {
        return "(" + latitude + ", " + longitude + ")";
    }

    // Getter/Setter Methods 

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getPointLocation() {
        return pointLocation;
    }

    public void setPointLocation(String pointLocation) {
        this.pointLocation = pointLocation;
    }
}
