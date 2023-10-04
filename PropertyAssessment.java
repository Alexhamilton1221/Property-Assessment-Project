/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# PropertyAssessment.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/

public class PropertyAssessment implements Comparable<PropertyAssessment> {

    /** Attributes */
    private int Account_Number;
    private int Suite;
    private int House_Number;
    private String Street_Name;
    private char Garage;
    private Location location;
    private int Assessed_Value;
    private Coordinate coordinate;
    private Assessment assessment;

    /** Constructor */
    public PropertyAssessment(int accountNumber, int suite, int houseNumber, String streetName, char garage,
            Location location, int assessedValue, Coordinate coordinate, Assessment assessment) {
        this.Account_Number = accountNumber;
        this.Suite = suite;
        this.House_Number = houseNumber;
        this.Street_Name = streetName;
        this.Garage = garage;
        this.location = location;
        this.Assessed_Value = assessedValue;
        this.coordinate = coordinate;
        this.assessment = assessment;
    }

    // Override Methods
    @Override
    public int compareTo(PropertyAssessment other) {
        return Integer.compare(Assessed_Value, other.Assessed_Value);
    }

    @Override
    public String toString() {
        return "";
    }

    // Getter/Setter Methods
    public int getAccount_Number() {
        return Account_Number;
    }

    public void setAccount_Number(int accountNumber) {
        this.Account_Number = accountNumber;
    }

    public int getSuite() {
        return Suite;
    }

    public void setSuite(int suite) {
        this.Suite = suite;
    }

    public int getHouse_Number() {
        return House_Number;
    }

    public void setHouse_Number(int houseNumber) {
        this.House_Number = houseNumber;
    }

    public String get_StreetName() {
        return Street_Name;
    }

    public void set_StreetName(String streetName) {
        this.Street_Name = streetName;
    }

    public char get_Garage() {
        return Garage;
    }

    public void set_Garage(char garage) {
        this.Garage = garage;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getAssessed_Value() {
        return Assessed_Value;
    }

    public void setAssessed_Value(int assessedValue) {
        this.Assessed_Value = assessedValue;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }
}
