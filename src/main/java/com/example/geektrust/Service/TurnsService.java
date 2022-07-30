package com.example.geektrust.Service;

import com.example.geektrust.Model.Coordinates;
import com.example.geektrust.Utils.Constants;

public class TurnsService implements Constants {

    public static DirectionService directionService = DirectionService.getInstance();

    private static TurnsService turnsService = null;
    private TurnsService() {}
    public static TurnsService getInstance() {
        if (turnsService != null) return turnsService;
        turnsService = new TurnsService();
        return turnsService;
    }

    public static int getNumberOfTurns(Coordinates coordinates){
        int numberOfTurns;
        int startDx = coordinates.getStartX(); int endDx = coordinates.getEndX();
        int startDy = coordinates.getStartY(); int endDy = coordinates.getEndY();
        String directionFacing = coordinates.getInitialDirection();
        if((startDx == endDx) || (startDy == endDy ))
            numberOfTurns = turnsOnSameAxis(coordinates);
        else
            numberOfTurns = turnsOnDifferentAxis(coordinates);
        return numberOfTurns;
    }

    private static int turnsOnSameAxis(Coordinates coordinates) {
        int startDx = coordinates.getStartX(); int endDx = coordinates.getEndX();
        int startDy = coordinates.getStartY(); int endDy = coordinates.getEndY();
        String directionFacing = coordinates.getInitialDirection();
        String optimalTravelDirection = directionService.getOptimalPath(startDx,startDy,endDx,endDy);
        String adjacentDirection = directionService.getAdjacentDirection(optimalTravelDirection);
        if(optimalTravelDirection.equalsIgnoreCase(directionFacing)) return 0;
        if(adjacentDirection.contains(directionFacing)) return 1;
        return 2;
    }

    private static int turnsOnDifferentAxis(Coordinates coordinates) {
        int startDx = coordinates.getStartX(); int endDx = coordinates.getEndX();
        int startDy = coordinates.getStartY(); int endDy = coordinates.getEndY();
        String directionFacing = coordinates.getInitialDirection();
        String optimalTravelDirection = directionService.getOptimalPath(startDx,startDy,endDx,endDy);
        if (optimalTravelDirection.contains(directionFacing)) return 1;
        return 2;
    }
}
