/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Test_Functions.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Test_Functions {

    /**
     * Test function to print property attributes.
     *
     * @param properties List of PropertyAssessment objects.
     */

    private void test_print_properties(List<PropertyAssessment> properties) {
        System.out.println("Testing Run");

        for (PropertyAssessment property : properties) {
            System.out.println("Account Number: " + property.getAccount_Number());
            System.out.println("Suite Number: " + property.getSuite());
            System.out.println("House Number: " + property.getHouse_Number());
            System.out.println("Street Name: " + property.get_StreetName());
            System.out.println("Garage: " + property.get_Garage());

            Location location = property.getLocation();
            System.out.println("Neighbourhood ID: " + location.getNeighbourhoodID());
            System.out.println("Neighbourhood: " + location.getNeighbourhood());
            System.out.println("Ward: " + location.getWard());

            System.out.println("Assessed Value: " + property.getAssessed_Value());

            Coordinate coordinate = property.getCoordinate();
            System.out.println("Latitude: " + coordinate.getLatitude());
            System.out.println("Longitude: " + coordinate.getLongitude());
            System.out.println("Point Location: " + coordinate.getPointLocation());

            Assessment assessment = property.getAssessment();
            System.out.println("Assessment Class 1: " + assessment.getClass_1());
            System.out.println("Assessment Class 2: " + assessment.getClass_2());
            System.out.println("Assessment Class 3: " + assessment.getClass_3());
            System.out.println("Assessment Class 1: " + assessment.getClass1());
            System.out.println("Assessment Class 2: " + assessment.getClass2());
            System.out.println("Assessment Class 3: " + assessment.getClass3());
            System.out.println("-------------------------------------");
        }
    }

    /**
     * Test run for get_properties()
     */
    public void test_get_properties() {

        // Create an ArrayList for properties
        List<PropertyAssessment> all_properties = new ArrayList<>();
        String current_line;

        // Create a Set to store unique ward values
        HashSet<PropertyAssessment> uniqueWards = new HashSet<>();

        //  Instance of functions class 
        Functions functionInstance = new Functions();

        // Open file
        try {
            Scanner inFile = new Scanner(Paths.get("Property_Assessment_Data_2022.csv"));

            // Skip the first line (column headers)
            if (inFile.hasNextLine()) {
                inFile.nextLine();
            }

            for (int i = 0; i < 20; i++) {
                current_line = inFile.nextLine();

                // Split line into array with comma delimiter
                String[] values = current_line.split(",");

                // Create a Property object using the createProperty function
                PropertyAssessment new_property = new PropertyAssessment(values);

                // Add to list
                all_properties.add(new_property);

                // Add the ward to the set of wards. Duplicates are dealt with already.
                uniqueWards.add(new_property);
            } // loop
            //int uniqueWardCount = uniqueWards.size();

            // Print all attributes
            test_print_properties(all_properties);

            // Print statistics for all properties
            functionInstance.printStatistics(all_properties, "Descriptive statistics of all property assessments");

            // Find property by account number
            System.out.println("\nPrinting property assessment for account 1034321");
            functionInstance.searchByAccountNum(all_properties, 1034321);

            String neighbourhood_name = "ELMWOOD";

            // Find all properties in a neighbourhood
            List<PropertyAssessment> propertiesInNeighbourhood = functionInstance.findPropertiesByNeighbourhood(all_properties, neighbourhood_name);

            // Print statistics for Neighbourhood
            functionInstance.printStatistics(propertiesInNeighbourhood, "Neighbourhood: " + neighbourhood_name);

        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }


    
}
