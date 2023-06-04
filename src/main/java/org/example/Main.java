package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    //null chekcerebi

    public static int numberOfSubjects;
    public static double gpa;

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());

                }
            }
        } catch (Exception e) {}


        FirstGUI firstGUI = new FirstGUI();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while(firstGUI.getFrame().isActive()){

        }

        numberOfSubjects = firstGUI.getNumOfSub();

        if(firstGUI.getFrame().isEnabled()) {
            SecondGUI secondGUI = new SecondGUI();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            while(secondGUI.getFrame().isActive()){}

        }


        ArrayList<Subject> subjectList = SecondGUI.subjectList;
        gpa = calculator.calculator(subjectList);

        ThirdGUI thirdGUI = new ThirdGUI();



    }



}