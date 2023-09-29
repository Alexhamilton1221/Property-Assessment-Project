/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Lab #2 statistics.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class statistics {
    
public int calculateMedian(List<PropertyAssessment> properties) {
    List<Integer> assessedValuesList = new ArrayList<>();
    for (PropertyAssessment property : properties) {
        assessedValuesList.add(property.getAssessed_Value());
    }

    List<Integer> sortedValues = new ArrayList<>(assessedValuesList);
    Collections.sort(sortedValues);

    int median;
    int size = sortedValues.size();

    if (size % 2 == 0) {
        int middle1 = sortedValues.get(size / 2 - 1);
        int middle2 = sortedValues.get(size / 2);
        median = (middle1 + middle2) / 2;
    } else {
        median = sortedValues.get(size / 2);
    }

    return median;
}

public int find_mean(List<PropertyAssessment> properties){
    int sumAssessedValues = 0;
    
    //Get sum of all of the values
    for (PropertyAssessment property : properties) {
        sumAssessedValues += property.getAssessed_Value();
    }
    //Divide by the total number of entries
    int mean = sumAssessedValues / properties.size();

    return mean;
}

/*Rewrite to use compare method */
public int findLowestAssessedValue(List<PropertyAssessment> properties) {
    int lowestValue = Integer.MAX_VALUE; //Initialize as highest integer

    //Look for value lower than max value
    for (PropertyAssessment property : properties) {
        int assessedValue = property.getAssessed_Value();
        if (assessedValue < lowestValue) {
            lowestValue = assessedValue;
        }
    }

    return lowestValue;
}
public int findHighestAssessedValue(List<PropertyAssessment> properties) {
    PropertyAssessment highestValueProperty = properties.get(0);

    for (PropertyAssessment property : properties) {
        if (property.compareTo(highestValueProperty) > 0) {
            highestValueProperty = property;
        }
    }

    return highestValueProperty.getAssessed_Value();
}

// public int findHighestAssessedValue(List<PropertyAssessment> properties) {
//     int highestValue = Integer.MIN_VALUE; //Initialize as lowest integer

//     //Look for value higher than min value
//     for (PropertyAssessment property : properties) {
//         int assessedValue = property.getAssessed_Value();
//         if (assessedValue > highestValue) {
//             highestValue = assessedValue;
//         }
//     }

//     return highestValue;
// }
 }
