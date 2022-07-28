package com.example.geektrust.Service;

import com.example.geektrust.Utils.Constants;

public class CalculatePoints implements Constants {

    public int calculateRemainingPower(int startDx, int startDy, int endDx, int endDy, String directionFacing) {
        int numberOfTurns;
        if (Math.abs(startDx - endDx) == 0 && Math.abs(startDy - endDy) == 0) {
            return MAX_AVAILABLE_POWER;
        } else if ((startDx - endDx) == 0 || (startDy - endDy) == 0) {
            numberOfTurns = getNumberOfTurnsSameAxis(startDx, startDy, endDx, endDy, directionFacing);
            int powerUtilised = calculatePower(startDx, startDy, endDx, endDy, numberOfTurns);
            return MAX_AVAILABLE_POWER - powerUtilised;
        }else {
            numberOfTurns = getNumberOfTurnsDifferentAxis(startDx, startDy, endDx, endDy, directionFacing);
            int powerUtilised = calculatePower(startDx, startDy, endDx, endDy, numberOfTurns);
            return MAX_AVAILABLE_POWER - powerUtilised;
        }
    }

    private static int getNumberOfTurnsSameAxis(int startDx, int startDy, int endDx, int endDy, String directionFacing) {
        if ((startDx - endDx) == 0) {
            if (endDy < startDy) {
                if (directionFacing.equalsIgnoreCase(SOUTH)) return 0; // optimalTravelDirection = SOUTH;
                else if (directionFacing.equalsIgnoreCase(NORTH)) return 2;
                else return 1;
            } else {
                if (directionFacing.equalsIgnoreCase(NORTH)) return 0; // optimalTravelDirection = NORTH;
                else if (directionFacing.equalsIgnoreCase(SOUTH)) return 2;
                else return 1;
            }
        } else {
            if (endDx > startDx) {
                if (directionFacing.equalsIgnoreCase(EAST)) return 0; // optimalTravelDirection = EAST;
                else if (directionFacing.equalsIgnoreCase(WEST) ) return 2;
                else return 1;
            } else {
                if (directionFacing.equalsIgnoreCase(WEST)) return 0;  // optimalTravelDirection = WEST;
                else if (directionFacing.equalsIgnoreCase(EAST)) return 2;
                else return 1;
            }
        }
    }

    private static int getNumberOfTurnsDifferentAxis(int startDx, int startDy, int endDx, int endDy, String directionFacing) {
        String optimalTravelDirection;
        if (endDy > startDy && endDx > startDx) {
            optimalTravelDirection = NORTH_EAST;
            if (optimalTravelDirection.contains(directionFacing)) return 1;
        }
        if (endDy > startDy && endDx < startDx) {
            optimalTravelDirection = NORTH_WEST;
            if (optimalTravelDirection.contains(directionFacing)) return 1;
        }
        if (endDy < startDy && endDx > startDx) {
            optimalTravelDirection = SOUTH_EAST ;
            if (optimalTravelDirection.contains(directionFacing)) return 1;
        }
        if(endDy < startDy && endDx < startDx){
            optimalTravelDirection = SOUTH_WEST;
            if(optimalTravelDirection.contains(directionFacing) ) return 1;
        }
        return 2;
    }

    private static int calculatePower(int startDx, int startDy, int endDx, int endDy, int numberOfTurns) {
        int coordinatesTravelled = Math.abs(endDx - startDx) + Math.abs(endDy - startDy);
        return (coordinatesTravelled * POINTS_FOR_MOVE) + (numberOfTurns * POINTS_FOR_TURN);
    }
}
