package com.example.geektrust.Service;

import com.example.geektrust.Model.Coordinates;
import com.example.geektrust.Utils.Constants;

public class CalculatePoints implements Constants {

    public static Direction direction = Direction.getInstance();

    public int calculateRemainingPower(Coordinates coordinates) {
        int numberOfTurns;
        if ((coordinates.getStartX() == coordinates.getEndX())  && (coordinates.getStartY() == coordinates.getEndY())) {
            return MAX_AVAILABLE_POWER;
        }else {
            numberOfTurns = getNumberOfTurns(coordinates);
            int pointsUtilised = calculatePower(coordinates, numberOfTurns);
            return MAX_AVAILABLE_POWER - pointsUtilised;
        }
    }

    private static int getNumberOfTurns(Coordinates coordinates){
        int numberOfTurns;
        int startDx = coordinates.getStartX(); int endDx = coordinates.getEndX();
        int startDy = coordinates.getStartY(); int endDy = coordinates.getEndY();
        String directionFacing = coordinates.getInitialDirection();
        if((startDx == endDx) || (startDy == endDy ))
            numberOfTurns = getNumberOfTurnsSameAxis(coordinates);
        else
            numberOfTurns = getNumberOfTurnsDifferentAxis(coordinates);
        return numberOfTurns;
    }

    private static int getNumberOfTurnsSameAxis(Coordinates coordinates) {
        int startDx = coordinates.getStartX(); int endDx = coordinates.getEndX();
        int startDy = coordinates.getStartY(); int endDy = coordinates.getEndY();
        String directionFacing = coordinates.getInitialDirection();
        String optimalTravelDirection = direction.getOptimalPath(startDx,startDy,endDx,endDy);
        String adjacentDirection = direction.getAdjacentDirection(optimalTravelDirection);
        if(optimalTravelDirection.equalsIgnoreCase(directionFacing)) return 0;
        if(adjacentDirection.contains(directionFacing)) return 1;
        return 2;
    }

    private static int getNumberOfTurnsDifferentAxis(Coordinates coordinates) {
        int startDx = coordinates.getStartX(); int endDx = coordinates.getEndX();
        int startDy = coordinates.getStartY(); int endDy = coordinates.getEndY();
        String directionFacing = coordinates.getInitialDirection();
        String optimalTravelDirection = direction.getOptimalPath(startDx,startDy,endDx,endDy);
        if (optimalTravelDirection.contains(directionFacing)) return 1;
        return 2;
    }

    private static int calculatePower(Coordinates coordinates, int numberOfTurns) {
        int coordinatesTravelled = Math.abs(coordinates.getEndX() - coordinates.getStartX()) +
                Math.abs(coordinates.getEndY() - coordinates.getStartY());
        return (coordinatesTravelled * POINTS_FOR_MOVE) + (numberOfTurns * POINTS_FOR_TURN);
    }
}
