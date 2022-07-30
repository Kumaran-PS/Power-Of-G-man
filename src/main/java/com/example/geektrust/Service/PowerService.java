package com.example.geektrust.Service;

import com.example.geektrust.Model.Coordinates;
import com.example.geektrust.Utils.Constants;

public class PowerService implements Constants {

    public static DirectionService directionService = DirectionService.getInstance();
    public static TurnsService turnsService = TurnsService.getInstance();

    public int calculatePowerLeft(Coordinates coordinates) {
        int numberOfTurns;
        if ((coordinates.getStartX() == coordinates.getEndX())  && (coordinates.getStartY() == coordinates.getEndY())) {
            return MAX_AVAILABLE_POWER;
        }else {
            numberOfTurns = turnsService.getNumberOfTurns(coordinates);
            int powerUtilised = calculatePower(coordinates, numberOfTurns);
            return MAX_AVAILABLE_POWER - powerUtilised;
        }
    }



    private static int calculatePower(Coordinates coordinates, int numberOfTurns) {
        int coordinatesTravelled = Math.abs(coordinates.getEndX() - coordinates.getStartX()) +
                Math.abs(coordinates.getEndY() - coordinates.getStartY());
        return (coordinatesTravelled * POINTS_FOR_MOVE) + (numberOfTurns * POINTS_FOR_TURN);
    }
}
