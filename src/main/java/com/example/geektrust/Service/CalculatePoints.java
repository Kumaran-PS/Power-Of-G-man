package com.example.geektrust.Service;

import com.example.geektrust.Utils.Constants;

public class CalculatePoints implements Constants {

    public static Direction direction = Direction.getInstance();

    public int calculateRemainingPower(int startDx, int startDy, int endDx, int endDy, String directionFacing) {
        int numberOfTurns;
        if (Math.abs(startDx - endDx) == 0 && Math.abs(startDy - endDy) == 0) {
            return MAX_AVAILABLE_POWER;
        }else {
            numberOfTurns = getNumberOfTurns(startDx, startDy, endDx, endDy, directionFacing);
            int powerUtilised = calculatePower(startDx, startDy, endDx, endDy, numberOfTurns);
            return MAX_AVAILABLE_POWER - powerUtilised;
        }
    }

    private static int getNumberOfTurns(int startDx, int startDy, int endDx, int endDy, String directionFacing){
        int numberOfTurns;
        if((startDx == endDx) || (startDy == endDy ))
            numberOfTurns = getNumberOfTurnsSameAxis(startDx, startDy, endDx, endDy, directionFacing);
        else
            numberOfTurns = getNumberOfTurnsDifferentAxis(startDx, startDy, endDx, endDy, directionFacing);
        return numberOfTurns;
    }

    private static int getNumberOfTurnsSameAxis(int startDx, int startDy, int endDx, int endDy, String directionFacing) {
        String optimalTravelDirection = direction.getOptimalPath(startDx,startDy,endDx,endDy);
        String adjacentDirection = direction.getAdjacentDirection(optimalTravelDirection);
        if(optimalTravelDirection.equalsIgnoreCase(directionFacing)) return 0;
        if(adjacentDirection.contains(directionFacing)) return 1;
        return 2;
    }

    private static int getNumberOfTurnsDifferentAxis(int startDx, int startDy, int endDx, int endDy, String directionFacing) {
        String optimalTravelDirection = direction.getOptimalPath(startDx,startDy,endDx,endDy);
        if (optimalTravelDirection.contains(directionFacing)) return 1;
        return 2;
    }

    private static int calculatePower(int startDx, int startDy, int endDx, int endDy, int numberOfTurns) {
        int coordinatesTravelled = Math.abs(endDx - startDx) + Math.abs(endDy - startDy);
        return (coordinatesTravelled * POINTS_FOR_MOVE) + (numberOfTurns * POINTS_FOR_TURN);
    }
}
