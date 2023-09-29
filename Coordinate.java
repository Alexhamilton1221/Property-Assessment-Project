/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Lab #2 coordinate.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 
public class Coordinate {
    private float latitude;
    private float longitude;
    private String pointLocation;

    public Coordinate(float latitude, float longitude, String pointLocation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.pointLocation = pointLocation;
    }

    @Override
    public String toString() {
     return "("+latitude+", "+longitude+")";
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
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
