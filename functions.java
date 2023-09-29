/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Lab #1 functions.java
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

public class functions{

public Scanner get_file(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("CSV filename:");
    String filename = scanner.nextLine();
    Scanner inFile=null;
    try{
    inFile = new Scanner(Paths.get(filename));
   //Scanner inFile = new Scanner(Paths.get("Property_Assessment_Data_2022.csv"));
    } catch (Exception e) {
    System.out.println(e);
}
    return inFile;

 }

public void test_get_properties() {

// Create an ArrayList for properties
List<PropertyAssessment> all_properties = new ArrayList<>();
String current_line; int count=0;

// Create a Set to store unique ward values
Set<String> uniqueWards = new HashSet<>();

//Open file
try {
    Scanner inFile = new Scanner(Paths.get("Property_Assessment_Data_2022.csv"));

    // Skip the first line (column headers)
    if (inFile.hasNextLine()) {
        inFile.nextLine();
    }

   for (int i = 0; i < 5; i++) { 
        current_line=inFile.nextLine();
        count++;

        // Split line into array with comma delimiter
        String[] values = current_line.split(",");

        // Create a Property object using the createProperty function
        PropertyAssessment new_property = createProperty(values);

        // Add to list
        all_properties.add(new_property);

        // Add the ward to the set of wards. Duplicates are dealt with already.
        uniqueWards.add(new_property.getLocation().getWard());
        }//loop
        int uniqueWardCount = uniqueWards.size();

        // Print all attributes
        //test_print_properties(all_properties);

        // Print statistics for all properties
        print_statistics(all_properties,"Descriptive statistics of all property assessments");

        //Find property by account number
        System.out.println("\nPrinting property assessment for account 1034321");
        searchbyaccountnum(all_properties,1034321);

        String neighbourhood_name="BELLE RIVE";

        //Find all properties in a neighbourhood
        List<PropertyAssessment> propertiesInNeighbourhood = findPropertiesByNeighbourhood(all_properties, neighbourhood_name);
        
        // Print statistics for Neighbourhood
        print_statistics(propertiesInNeighbourhood,"Neighbourhood: "+neighbourhood_name);

} catch (Exception e) {
    System.out.println(e);
    return;
}
}//test_get_properties

public void get_properties() {

// Create an ArrayList for properties
List<PropertyAssessment> all_properties = new ArrayList<>();
String current_line; 

// Create a Set to store unique ward values
Set<String> uniqueWards = new HashSet<>();


//Open file
try {
    Scanner inFile=get_file();

    // Skip the first line (column headers)
    if (inFile.hasNextLine()) {
        inFile.nextLine();
    }

    while (inFile.hasNextLine()) {

        current_line=inFile.nextLine();

        // Split line into array with comma delimiter
        String[] values = current_line.split(",");

        // Create a Property object using the createProperty function
        PropertyAssessment new_property = createProperty(values);

        // Add to list
        all_properties.add(new_property);

        // Add the ward to the set of wards. Duplicates are dealt with already.
        uniqueWards.add(new_property.getLocation().getWard());


        }//while

        //int uniqueWardCount = uniqueWards.size();

        // Print statistics for all properties
        print_statistics(all_properties,"Descriptive statistics of all property assessments");
        
        //inFile.close();

        //Find property by account number
        searchbyaccountnum(all_properties,0);

        System.out.print("Neighbourhood: ");
        Scanner scanner = new Scanner(System.in);

        // Read a line of text (including spaces) entered by the user
        String neighbourhood_name = scanner.nextLine();


        //Find all properties in a neighbourhood
        List<PropertyAssessment> propertiesInNeighbourhood = findPropertiesByNeighbourhood(all_properties, neighbourhood_name);
        
        
        // Print statistics for Neighbourhood
        print_statistics(propertiesInNeighbourhood,"Statistics: (neighbourhood = "+neighbourhood_name+")");




} catch (Exception e) {
    System.out.println(e);
    return;
    
}

}//get_properties



private void searchbyaccountnum(List<PropertyAssessment> properties,int accountNumberToFind){
    Scanner scanner = new Scanner(System.in);

    if (accountNumberToFind==0){
        System.out.print("\nFind a property assessment by account number: \n");
        accountNumberToFind = scanner.nextInt();
        
    }

        for (PropertyAssessment property : properties) {
           if (property.getAccount_Number() == accountNumberToFind) {
                //Print out Property Details
                System.out.println("Account Number = " + property.getAccount_Number());
                System.out.println("Address = " + property.get_StreetName());
                System.out.println("Assessed Value = " + property.getAssessed_Value());
                System.out.println("Assessment Class = " + property.getAssessment());
                System.out.println("Neighbourhood = " + property.getLocation());
                System.out.println("Location = " + property.getCoordinate());

                break;
            }
    }
    //scanner.close(); // Close the scanner after use
}


//Funtion to print out results
private void print_statistics(List<PropertyAssessment> properties,String title) {

    //Instance of Value Modifier class
    statistics statistics = new statistics();
    int count=properties.size();

    int min_assessed_value = statistics.findLowestAssessedValue(properties);
    int max_assessed_value = statistics.findHighestAssessedValue(properties);
    int range = max_assessed_value - min_assessed_value;
    int mean = statistics.find_mean(properties);
    int median = statistics.calculateMedian(properties);

    System.out.println("\n"+title);

    System.out.println("n = " + count);
    System.out.println("min = $" + min_assessed_value);
    System.out.println("max = $" + max_assessed_value);
    System.out.println("range = $" + range);
    System.out.println("mean = $" + mean);
    System.out.println("median = $" + median);
}

//Function to create a property 
private PropertyAssessment createProperty(String[] values) {

    //Instance of Value Modifier class
    generate_values generate_values = new generate_values();

        // Process lines into values
        int accountNumber=generate_values.gen_accountNumber(values);
        int suite = generate_values.gen_suite(values);
        int houseNumber = generate_values.gen_housenum(values);
        String streetname = generate_values.gen_streetName(values);
        char garage = generate_values.gen_garage(values);
        int neighbourhood_id = generate_values.gen_neighbourhoodID(values);
        String neighbourhood = generate_values.gen_neighbourhood(values);
        String ward = generate_values.genWard(values);
        int assessedValue = generate_values.gen_acessed_value(values);
        float latitude = generate_values.gen_latitude(values);
        float longitude = generate_values.gen_longitude(values);
        String pointLocation = generate_values.gen_point_location(values);
        int assessmentClass1 = generate_values.gen_assessment_class1(values);
        int assessmentClass2 = generate_values.gen_assessment_class2(values);
        int assessmentClass3 = generate_values.gen_assessment_class3(values);
        String assessmentClass_1 = generate_values.gen_assessment_class_1(values);
        String assessmentClass_2 = generate_values.gen_assessment_class_2(values);
        String assessmentClass_3 = generate_values.gen_assessment_class_3(values);
                
        // Create an Assessment object
        Assessment assessment = new Assessment(assessmentClass1, assessmentClass2, assessmentClass3,
        assessmentClass_1, assessmentClass_2, assessmentClass_3);

        // Create an Coordinate object
        Coordinate coordinate = new Coordinate(latitude, longitude, pointLocation);

        // Create a Location object
        Location location = new Location(neighbourhood_id, neighbourhood, ward);

        // Create a Property object with the other objects included
        PropertyAssessment new_property = new PropertyAssessment(accountNumber, suite, houseNumber, streetname, garage,
        location, assessedValue, coordinate,assessment); 

        return new_property;
}

public List<PropertyAssessment> findPropertiesByNeighbourhood(List<PropertyAssessment> properties, String neighbourhoodToFind) {
    List<PropertyAssessment> matchingProperties = new ArrayList<>();

    for (PropertyAssessment property : properties) {
        if (property.getLocation().getNeighbourhood().equalsIgnoreCase(neighbourhoodToFind)) {
            matchingProperties.add(property);
        }
    }

    return matchingProperties;
}



}//class