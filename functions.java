/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Functions.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.nio.file.Paths;

public class Functions {

    /**
     * Get a Scanner object to read from a CSV file.
     *
     * @return A Scanner object to read from the specified CSV file.
     */
    public Scanner getFile() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CSV filename:");
        String filename = scanner.nextLine();
        Scanner inFile = null;
        try {
            inFile = new Scanner(Paths.get(filename));
        } catch (Exception e) {
            System.out.println(e);
        }
        return inFile;
    }

    /**
     * Load and process property data from a CSV file.
     */
    public void getProperties() {
        // Create an ArrayList for properties
        List<PropertyAssessment> allProperties = new ArrayList<>();
        String currentLine;

        // Create a Set to store unique ward values
        Set<String> uniqueWards = new HashSet<>();

        // Open file
        try {
            Scanner inFile = getFile();

            // Skip the first line (column headers)
            if (inFile.hasNextLine()) {
                inFile.nextLine();
            }

            while (inFile.hasNextLine()) {
                currentLine = inFile.nextLine();

                // Split line into array with comma delimiter
                String[] values = currentLine.split(",");

                // Create a Property object using the createProperty function
                PropertyAssessment newProperty = createProperty(values);

                // Add to list
                allProperties.add(newProperty);

                // Add the ward to the set of wards. Duplicates are dealt with already.
                uniqueWards.add(newProperty.getLocation().getWard());
            }

            // Print statistics for all properties
            printStatistics(allProperties, "Descriptive statistics of all property assessments");

            // Find property by account number
            searchByAccountNum(allProperties, 0);

            System.out.print("Neighbourhood: ");
            Scanner scanner = new Scanner(System.in);

            // Read a line of text (including spaces) entered by the user
            String neighbourhoodName = scanner.nextLine();

            // Find all properties in a neighbourhood
            List<PropertyAssessment> propertiesInNeighbourhood = findPropertiesByNeighbourhood(allProperties, neighbourhoodName);

            // Print statistics for Neighbourhood
            printStatistics(propertiesInNeighbourhood, "Statistics: (neighbourhood = " + neighbourhoodName + ")");

        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

    /**
     * Search for a property assessment by account number.
     *
     * @param properties            A list of PropertyAssessment objects.
     * @param accountNumberToFind   The account number for the property.
     */
    public void searchByAccountNum(List<PropertyAssessment> properties, int accountNumberToFind) {
        Scanner scanner = new Scanner(System.in);

        if (accountNumberToFind == 0) {
            System.out.print("\nFind a property assessment by account number: \n");
            accountNumberToFind = scanner.nextInt();
        }

        for (PropertyAssessment property : properties) {
            if (property.getAccount_Number() == accountNumberToFind) {
                // Print out Property Details
                System.out.println("Account Number = " + property.getAccount_Number());
                System.out.println("Address = " + property.get_StreetName());
                System.out.println("Assessed Value = " + property.getAssessed_Value());
                System.out.println("Assessment Class = " + property.getAssessment());
                System.out.println("Neighbourhood = " + property.getLocation());
                System.out.println("Location = " + property.getCoordinate());

                break;
            }
        }
    }

    /**
     * Print descriptive statistics for a list of property assessments.
     *
     * @param properties The list of PropertyAssessment objects.
     * @param title      A string to be displayed above the stats.
     */
    public void printStatistics(List<PropertyAssessment> properties, String title) {
        // Instance of Value Modifier class
        Statistics statistics = new Statistics();
        int count = properties.size();
        int minAssessedValue = statistics.findLowestAssessedValue(properties);
        int maxAssessedValue = statistics.findHighestAssessedValue(properties);
        int range = maxAssessedValue - minAssessedValue;
        int mean = statistics.find_mean(properties);
        int median = statistics.calculateMedian(properties);

        System.out.println("\n" + title);
        System.out.println("n = " + count);
        System.out.println("min = $" + minAssessedValue);
        System.out.println("max = $" + maxAssessedValue);
        System.out.println("range = $" + range);
        System.out.println("mean = $" + mean);
        System.out.println("median = $" + median);
    }

    /**
     * Create a PropertyAssessment object from an array of property values.
     *
     * @param values A line of strings from a file.
     * @return A PropertyAssessment object.
     */
    public PropertyAssessment createProperty(String[] values) {
        // Instance of Value Modifier class
        GenerateValues generateValues = new GenerateValues();

        // Process lines into values
        int accountNumber = generateValues.gen_accountNumber(values);
        int suite = generateValues.gen_suite(values);
        int houseNumber = generateValues.gen_housenum(values);
        String streetName = generateValues.gen_streetName(values);
        char garage = generateValues.gen_garage(values);
        int neighbourhoodId = generateValues.gen_neighbourhoodID(values);
        String neighbourhood = generateValues.gen_neighbourhood(values);
        String ward = generateValues.genWard(values);
        int assessedValue = generateValues.gen_acessed_value(values);
        float latitude = generateValues.gen_latitude(values);
        float longitude = generateValues.gen_longitude(values);
        String pointLocation = generateValues.gen_point_location(values);
        int assessmentClass1 = generateValues.gen_assessment_class1(values);
        int assessmentClass2 = generateValues.gen_assessment_class2(values);
        int assessmentClass3 = generateValues.gen_assessment_class3(values);
        String assessmentClass_1 = generateValues.gen_assessment_class_1(values);
        String assessmentClass_2 = generateValues.gen_assessment_class_2(values);
        String assessmentClass_3 = generateValues.gen_assessment_class_3(values);

        // Create an Assessment object
        Assessment assessment = new Assessment(assessmentClass1, assessmentClass2, assessmentClass3,
                assessmentClass_1, assessmentClass_2, assessmentClass_3);

        // Create a Coordinate object
        Coordinate coordinate = new Coordinate(latitude, longitude, pointLocation);

        // Create a Location object
        Location location = new Location(neighbourhoodId, neighbourhood, ward);

        // Create a Property object with the other objects included
        PropertyAssessment newProperty = new PropertyAssessment(accountNumber, suite, houseNumber, streetName, garage,
                location, assessedValue, coordinate, assessment);

        return newProperty;
    }

    /**
     * Find properties in a neighborhood and put them in a list.
     *
     * @param properties         The list of PropertyAssessment objects.
     * @param neighbourhoodToFind The name of the neighborhood to search for.
     * @return A list of PropertyAssessment objects in the specified neighborhood.
     */
    public List<PropertyAssessment> findPropertiesByNeighbourhood(List<PropertyAssessment> properties, String neighbourhoodToFind) {
        List<PropertyAssessment> matchingProperties = new ArrayList<>();

        // Find all properties in a neighbourhood, put in a new list
        for (PropertyAssessment property : properties) {
            if (property.getLocation().getNeighbourhood().equalsIgnoreCase(neighbourhoodToFind)) {
                matchingProperties.add(property);
            }
        }

        return matchingProperties;
    }
}
