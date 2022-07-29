package com.example.geektrust.Service;

import com.example.geektrust.Model.CoordinatesData;
import com.example.geektrust.Utils.Constants;

public class Direction implements Constants {

    private static Direction direction = null;

    private Direction() {}

    public static Direction getInstance() {
        if (direction != null) return direction;
        direction = new Direction();
        return direction;
    }

    public String getOptimalTravelDirection(CoordinatesData data){
        String optimalTravelDirection = EMPTY_STRING;
        if (data.getY2() > data.getY1() ) optimalTravelDirection = upwardPath(data);
        if (data.getY2() < data.getY1()) optimalTravelDirection = downwardPath(data);
        if(data.getY2() == data.getY1()) optimalTravelDirection = horizontalPath(data);
        return optimalTravelDirection;
    }

    public String getAdjacentDirection(String optimalTravelDirection) {
        String adjacentDirection = NORTH_SOUTH;
        if(optimalTravelDirection.equalsIgnoreCase(NORTH) || optimalTravelDirection.equalsIgnoreCase(SOUTH))
            adjacentDirection =  EAST_WEST;
        return adjacentDirection;
    }

    public String upwardPath(CoordinatesData data){
        if(data.getX2() > data.getX1()) return NORTH_EAST;
        if(data.getX2() < data.getX1()) return NORTH_WEST;
        return NORTH;
    }

    public String downwardPath(CoordinatesData data){
        if(data.getX2() > data.getX1()) return SOUTH_EAST;
        if(data.getX2() < data.getX1()) return SOUTH_WEST;
        return SOUTH;
    }

    public String horizontalPath(CoordinatesData data){
        if(data.getX2() > data.getX1()) return EAST;
        return  WEST;
    }

}
