package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static double GPA;
    private static double dividend;
    private static double divisor;
    private static List<Subject> subjectList = SecondGUI.subjectList;
    private int numOfSubjects;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public double calculator(ArrayList<Subject> arr){
        for (int i = 0; i < subjectList.size(); i++) {
            dividend += subjectList.get(i).getMultiplied();
            divisor += subjectList.get(i).getCreds();
        }

        GPA = dividend / divisor;

        return  GPA;
    }


    public double getGPA() {
        return GPA;
    }

}
