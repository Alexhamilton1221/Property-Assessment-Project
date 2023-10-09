/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# PropertyAssessment.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/

import java.util.Objects;

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

    /**
     * Constructor to create a PropertyAssessment object from a string array of values.
     *
     * @param values An array of strings containing property attributes.
     */
    public PropertyAssessment(String[] values) {
        this.Account_Number = parseInteger(values[0]);
        this.Suite = parseInteger(values[1]);
        this.House_Number = parseInteger(values[2]);
        this.Street_Name = (values[3].isEmpty()) ? "NONE" : values[3];
        this.Garage = (values[4].isEmpty()) ? 'N' : values[4].charAt(0);
        this.location = new Location(
            parseInteger(values[5]),             // Neighbourhood ID
            (values[6].isEmpty()) ? "NONE" : values[6], // Neighbourhood
            (values[7].isEmpty()) ? "NONE" : values[7]  // Ward
        );
        this.Assessed_Value = parseInteger(values[8]);
        this.coordinate = new Coordinate(
            parseFloat(values[9]),              // Latitude
            parseFloat(values[10]),             // Longitude
            (values[11].isEmpty()) ? "NONE" : values[11]  // Point Location
        );
        this.assessment = new Assessment(
            parseInteger(values[12]),                // Assessment Class 1
            parseInteger(values[13]),                // Assessment Class 2
            parseInteger(values[14]),                // Assessment Class 3
            (values[15].isEmpty()) ? "NONE" : values[15], // Assessment Class 1 (String)
            (values.length > 16 && !values[16].isEmpty()) ? values[16] : "NONE", // Assessment Class 2 (String)
            (values.length > 17 && !values[17].isEmpty()) ? values[17] : "NONE"  // Assessment Class 3 (String)
        );
    }

    /**
     * Parses a string to an integer.
     *
     * @param value The string to parse as an integer.
     * @return The parsed integer value or 0 if the string is empty or cannot be parsed.
     */
    private int parseInteger(String value) {
        if (value.isEmpty()) {
            return 0; 
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0; 
        }
    }

    /**
     * Parses a string to a float.
     *
     * @param value The string to parse as a float.
     * @return The parsed float value or 0.0f if the string is empty or cannot be parsed.
     */
    private float parseFloat(String value) {
        if (value.isEmpty()) {
            return 0.0f; 
        }
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            return 0.0f; 
        }
    }

    // Override Methods
    @Override
    public int compareTo(PropertyAssessment other) {
        return Integer.compare(Assessed_Value, other.Assessed_Value);
    }

    public String toString() {
        return "";
    }

    public int hashCode() {
        return Objects.hash(location.getWard());
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
