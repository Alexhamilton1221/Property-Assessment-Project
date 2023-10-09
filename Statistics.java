/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Statistics.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {

    /**
     * Calculates the median assessed value from a list of property assessments.
     *
     * @param properties A list of PropertyAssessment objects.
     * @return The median assessed value.
     */
    public int calculateMedian(List<PropertyAssessment> properties) {
        // Populate list of assessed values
        List<Integer> assessedValuesList = new ArrayList<>();
        for (PropertyAssessment property : properties) {
            assessedValuesList.add(property.getAssessed_Value());
        }
        // Sort Assessed Values
        List<Integer> sortedValues = new ArrayList<>(assessedValuesList);
        Collections.sort(sortedValues);

        int median;
        int size = sortedValues.size();

        // Find median, odd/even cases
        if (size % 2 == 0) {
            int middle1 = sortedValues.get(size / 2 - 1);
            int middle2 = sortedValues.get(size / 2);
            median = (middle1 + middle2) / 2;
        } else {
            median = sortedValues.get(size / 2);
        }

        return median;
    }

    /**
     * Calculates the mean assessed value from a list of property assessments.
     *
     * @param properties A list of PropertyAssessment objects.
     * @return The mean assessed value.
     */
    public long find_mean(List<PropertyAssessment> properties) {
        long sumAssessedValues = 0;

        // Get sum of all of the values
        for (PropertyAssessment property : properties) {
            sumAssessedValues += property.getAssessed_Value();
        }
        // Divide by the total number of entries
        double mean = (double) sumAssessedValues / properties.size();

        // Round it back to nearest integer
        long roundedMean = (int) Math.round(mean);

        return roundedMean;
    }

    /**
     * Finds the lowest assessed value from a list of property assessments.
     *
     * @param properties A list of PropertyAssessment objects.
     * @return The lowest assessed value.
     */
    public int findLowestAssessedValue(List<PropertyAssessment> properties) {
        PropertyAssessment lowestValue = properties.get(0);

        // Look for a value lower than the min value
        for (PropertyAssessment property : properties) {
            if (property.compareTo(lowestValue) < 0) {
                lowestValue = property;
            }
        }

        return lowestValue.getAssessed_Value();
    }

    /**
     * Finds the highest assessed value from a list of property assessments.
     *
     * @param properties A list of PropertyAssessment objects.
     * @return The highest assessed value.
     */
    public int findHighestAssessedValue(List<PropertyAssessment> properties) {
        PropertyAssessment highestValueProperty = properties.get(0);

        // Look for a value higher than the max value
        for (PropertyAssessment property : properties) {
            if (property.compareTo(highestValueProperty) > 0) {
                highestValueProperty = property;
            }
        }

        return highestValueProperty.getAssessed_Value();
    }
}
