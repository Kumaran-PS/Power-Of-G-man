package com.example.geektrust.Service;

import com.example.geektrust.Model.CoordinatesData;
import com.example.geektrust.Utils.Constants;

public class CalculatePoints implements Constants {

    public static Direction direction = Direction.getInstance();

    public int calculateRemainingPower(CoordinatesData data) {
        int numberOfTurns;
        if (data.getX1() == data.getX2() && data.getY1() == data.getY2()) {
            return MAX_AVAILABLE_POWER;
        }else {
            numberOfTurns = getNumberOfTurns(data);
            int powerUtilised = calculatePower(data , numberOfTurns);
            return MAX_AVAILABLE_POWER - powerUtilised;
        }
    }

    private static int getNumberOfTurns(CoordinatesData data){
        int numberOfTurns;
        if((data.getX1() == data.getX2()) || (data.getY1() == data.getY2()))
            numberOfTurns = getNumberOfTurnsSameAxis(data);
        else
            numberOfTurns = getNumberOfTurnsDifferentAxis(data);
        return numberOfTurns;
    }

    private static int getNumberOfTurnsSameAxis(CoordinatesData data) {
        String optimalTravelDirection = direction.getOptimalTravelDirection(data);
        String adjacentDirection = direction.getAdjacentDirection(optimalTravelDirection);
        if(optimalTravelDirection.equalsIgnoreCase(data.getDirectionFacing())) return 0;
        if(adjacentDirection.contains(data.getDirectionFacing())) return 1;
        return 2;
    }

    private static int getNumberOfTurnsDifferentAxis(CoordinatesData data) {
        String optimalTravelDirection = direction.getOptimalTravelDirection(data);
        if (optimalTravelDirection.contains(data.getDirectionFacing())) return 1;
        return 2;
    }

    private static int calculatePower(CoordinatesData data ,int numberOfTurns) {
        int coordinatesTravelled = Math.abs(data.getX1() - data.getX2()) + Math.abs(data.getY1() - data.getX2());
        return (coordinatesTravelled * POINTS_FOR_MOVE) + (numberOfTurns * POINTS_FOR_TURN);
    }
}
