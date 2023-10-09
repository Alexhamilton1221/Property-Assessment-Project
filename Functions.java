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
import java.nio.file.Paths;
import java.text.DecimalFormat;

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
            System.out.println("Error: can't open file " + filename);
            System.exit(1);
        }
        return inFile;
    }

     /**
     * Formats money amounts with commas.
     *
     * @param amount The amount of money to format.
     * @return A string representation of the formatted amount with commas.
     */
    public static String formatMoney(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount);
    }


    /**
     * Load and process property data from a CSV file.
     */
    public void getProperties() {
        // Create an ArrayList for properties
        List<PropertyAssessment> allProperties = new ArrayList<>();
        String currentLine;

        // Create a Set to store unique ward values
        //Set<String> uniqueWards = new HashSet<>();
        HashSet<PropertyAssessment> uniqueWards = new HashSet<>();


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
                PropertyAssessment newProperty = new PropertyAssessment(values);

                // Add to list
                allProperties.add(newProperty);

                // Add the ward to the set of wards. Duplicates are dealt with already.
                uniqueWards.add(newProperty);

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
            System.out.print("\nFind a property assessment by account number: ");
            accountNumberToFind = scanner.nextInt();
        }
        boolean found = false; // Flag to track if a match is found


        for (PropertyAssessment property : properties) {
            if (property.getAccount_Number() == accountNumberToFind) {
                // Print out Property Details
                System.out.println("Account Number = " + property.getAccount_Number());
                System.out.println("Address = " + property.getHouse_Number()+" "+property.get_StreetName());
                System.out.println("Assessed Value = $" + formatMoney(property.getAssessed_Value()));
                System.out.println("Assessment Class = " + property.getAssessment());
                System.out.println("Neighbourhood = " + property.getLocation()+" ("+property.getLocation().getWard()+")");
                System.out.println("Location = " + property.getCoordinate());

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No property found with account number: " + accountNumberToFind);
        }


    }

    /**
     * Print descriptive statistics for a list of property assessments.
     *
     * @param properties The list of PropertyAssessment objects.
     * @param title      A string to be displayed above the stats.
     */
    public void printStatistics(List<PropertyAssessment> properties, String title) {

        if (properties.isEmpty()) {
            System.out.println("No properties to calculate statistics for.");
            return; // Exit the function if the list is empty
        }
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
        System.out.println("min = $" + formatMoney(minAssessedValue));
        System.out.println("max = $" + formatMoney(maxAssessedValue));
        System.out.println("range = $" + formatMoney(range));
        System.out.println("mean = $" + formatMoney(mean));
        System.out.println("median = $" + formatMoney(median));
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
        boolean found = false; // Flag to track if a match is found


        // Find all properties in a neighbourhood, put in a new list
        for (PropertyAssessment property : properties) {
            String propertyNeighbourhood = property.getLocation().getNeighbourhood().toLowerCase(); 

            if (propertyNeighbourhood.equals(neighbourhoodToFind.toLowerCase())) {
                matchingProperties.add(property);
                found = true; 
            }
        }
        
        if (!found) {
            System.out.println("No properties found in the neighborhood: " + neighbourhoodToFind);
        }
    

        return matchingProperties;
    }

}
