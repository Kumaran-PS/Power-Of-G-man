package com.example.geektrust.Service;

import com.example.geektrust.Utils.Constants;

public class Direction implements Constants {

    private static Direction direction = null;
    private Direction() {}
    public static Direction getInstance() {
        if (direction != null) return direction;
        direction = new Direction();
        return direction;
    }

    public String getOptimalTravelDirection(int startDx, int startDy, int endDx, int endDy){
        String optimalTravelDirection = EMPTY_STRING;
        if (endDy > startDy ) {
            if(endDx == startDx) optimalTravelDirection = NORTH;
            if(endDx > startDx) optimalTravelDirection = NORTH_EAST;
            if(endDx < startDx) optimalTravelDirection = NORTH_WEST;
        }
        if (endDy < startDy) {
            if(endDx == startDx) optimalTravelDirection = SOUTH;
            if(endDx > startDx) optimalTravelDirection = SOUTH_EAST;
            if(endDx < startDx) optimalTravelDirection = SOUTH_WEST;
        }
        if(endDy == startDy){
            if(endDx > startDx) optimalTravelDirection = EAST;
            if(endDx < startDx) optimalTravelDirection = WEST;
        }
        return optimalTravelDirection;
    }

    public String getAdjacentDirection(String optimalTravelDirection) {
        String adjacentDirection = NORTH_SOUTH;
        if(optimalTravelDirection.equalsIgnoreCase(NORTH) || optimalTravelDirection.equalsIgnoreCase(SOUTH))
            adjacentDirection =  EAST_WEST;
        return adjacentDirection;
    }
}
