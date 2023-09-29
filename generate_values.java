/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Lab #2 generate_values.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 


public class generate_values {
    //Funtions to get and check/modify property attributes
public int gen_accountNumber(String[] values){
    int accountNumber = 0;
    
    try {
        accountNumber = Integer.parseInt(values[0]);
        
    } catch (Exception e) {
    }
    
        return accountNumber;
    }
    
    public int gen_suite(String[] values){
    int suite = 0;
    
    try {
         suite = Integer.parseInt(values[1]);
        
    } catch (Exception e) {
    }
        return suite;
    }
    
    public int gen_housenum(String[] values){
    int houseNumber = 0;
    
    try {
        houseNumber = Integer.parseInt(values[2]);
        
    } catch (Exception e) {
    }
        return houseNumber;
    }
    
    public String gen_streetName(String[] values){
    
        String streetname = values[3]; 
    
        if (streetname.isEmpty()) {
            streetname = "NONE";
        }
    
        return streetname;
    }
    
    public char gen_garage(String[] values){
    char garage = 'N';
    
    try {
        garage = values[4].charAt(0);
        
    } catch (Exception e) {
        garage='N';
    }
        return garage;
    }
    
    public int gen_neighbourhoodID(String[] values){
    int neighbourhood_id = 0;
    
    try {
        neighbourhood_id = Integer.parseInt(values[5]);
        
    } catch (Exception e) {
    }
        return neighbourhood_id;
    }
    
    public String gen_neighbourhood(String[] values){
        String neighbourhood = values[6]; 
    
        if (neighbourhood.isEmpty()) {
            neighbourhood = "NONE"; 
        }
    
        return neighbourhood;
    }
    
    public String genWard(String[] values){
        String ward = values[7];
    
        if (ward.isEmpty()) {
            ward = "NONE";
        }
    
        return ward;
    }
    
    public int gen_acessed_value(String[] values){
    int neighbourhood_id = 0;
    
    try {
        neighbourhood_id = Integer.parseInt(values[8]);
        
    } catch (Exception e) {
    }
        return neighbourhood_id;
    }
    
    
    public float gen_latitude(String[] values){
    float latitude = 0;
    
    try {
        latitude = Float.parseFloat(values[9]);
        
    } catch (Exception e) {
    }
        return latitude;
    }
    
    public float gen_longitude(String[] values){
    float longitude = 0;
    
    try {
        longitude = Float.parseFloat(values[10]);
        
    } catch (Exception e) {
    }
        return longitude;
    }
    
    public String gen_point_location(String[] values){
        String point_location = values[11];
    
        if (point_location.isEmpty()) {
            point_location = "NONE";
        }
    
        return point_location;
    }
    
    public int gen_assessment_class1(String[] values){
    int gen_assessment_class1 = 0;
    
    try {
        gen_assessment_class1 = Integer.parseInt(values[12]);
        
    } catch (Exception e) {
    }
        return gen_assessment_class1;
    }
    
    public int gen_assessment_class2(String[] values){
    int gen_assessment_class2 = 0;
    
    try {
        gen_assessment_class2 = Integer.parseInt(values[13]);
        
    } catch (Exception e) {
    }
        return gen_assessment_class2;
    }
    
    
    public int gen_assessment_class3(String[] values){
    int gen_assessment_class3 = 0;
    
    try {
        gen_assessment_class3 = Integer.parseInt(values[14]);
        
    } catch (Exception e) {
    }
        return gen_assessment_class3;
    }
    
    public String gen_assessment_class_1(String[] values) {
        String assessment_class_1 = values[15];
    
        if (assessment_class_1.isEmpty()) {
            assessment_class_1 = "NONE";
        }
    
        return assessment_class_1;
    }
        
    public String gen_assessment_class_2(String[] values) {
        if (values.length > 16) {
            String assessment_class_2 = values[16];
    
            if (assessment_class_2.isEmpty()) {
                assessment_class_2 = "NONE";
            }
    
            return assessment_class_2;
        } else {
            return "NONE"; 
        }
    }
    
    public String gen_assessment_class_3(String[] values) {
        if (values.length > 17) {
            String assessment_class_3 = values[17];
    
            if (assessment_class_3.isEmpty()) {
                assessment_class_3 = "NONE";
            }
    
            return assessment_class_3;
        } else {
            return "NONE"; 
        }
    }
    
}
