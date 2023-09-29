import java.util.List;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Scanner;
// import java.util.Set;
// import java.nio.file.Paths;

public class test_functions {
    //Test Functions
private void test_print_properties(List<PropertyAssessment> properties){
    System.out.println("Testing Run");


     for (PropertyAssessment property : properties) {
        System.out.println("Account Number: " + property.getAccount_Number());
        System.out.println("Suite Number: " + property.getSuite());
        System.out.println("House Number: " + property.getHouse_Number());
        System.out.println("StreetName: " + property.get_StreetName());
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
}
