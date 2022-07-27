package com.example.geektrust;

import com.example.geektrust.Service.CalculatePoints;
import com.example.geektrust.Utils.Constants;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main implements Constants {
    public static void main(String[] args) {
        int startDx = 0;
        int startDy = 0;
        int endDx = 0;
        int endDy = 0;
        String directionFacing = EMPTY_STRING;
        try {
            FileInputStream inputFile = new FileInputStream(INPUT_FILE_PATH);
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();
                String[] inputData = inputLine.split(" ");
                switch (inputData[INPUT_TYPE]) {
                    case "SOURCE":
                        startDx = Integer.parseInt(inputData[SOURCE_INDEX_X]);
                        startDy = Integer.parseInt(inputData[SOURCE_INDEX_Y]);
                        directionFacing = inputData[DIRECTION_FACING_INDEX];
                        break;
                    case "DESTINATION":
                        endDx = Integer.parseInt(inputData[DESTINATION_INDEX_X]);
                        endDy = Integer.parseInt(inputData[DESTINATION_INDEX_Y]);
                        break;
                    case "PRINT_POWER":
                        CalculatePoints calculatePoints = new CalculatePoints();
                        int powerLeft = calculatePoints.calculateRemainingPower(startDx, startDy, endDx, endDy, directionFacing);
                        System.out.println("POWER " + powerLeft);
                        break;
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
