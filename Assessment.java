/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Lab #2 Assessment.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 
// package Lab2;


public class Assessment {
    private int class1;
    private int class2;
    private int class3;
    private String class_1;
    private String class_2;
    private String class_3;

    public Assessment(int class1, int class2, int class3, String class_1, String class_2, String class_3) {
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.class_1 = class_1;
        this.class_2 = class_2;
        this.class_3 = class_3;
    }
    @Override
    public String toString() {
     return "["+class_1+" "+class1+"%, "+class_2+" "+class2+"%, "+class_3+" "+class3+"%]";   
    }

    public int getClass1() {
        return class1;
    }

    public void setClass1(int class1) {
        this.class1 = class1;
    }

    public int getClass2() {
        return class2;
    }

    public void setClass2(int class2) {
        this.class2 = class2;
    }

    public int getClass3() {
        return class3;
    }

    public void setClass3(int class3) {
        this.class3 = class3;
    }

    public String getClass_1() {
        return class_1;
    }

    public void setClass_1(String class_1) {
        this.class_1 = class_1;
    }

    public String getClass_2() {
        return class_2;
    }

    public void setClass_2(String class_2) {
        this.class_2 = class_2;
    }

    public String getClass_3() {
        return class_3;
    }

    public void setClass_3(String class_3) {
        this.class_3 = class_3;
    }
}
