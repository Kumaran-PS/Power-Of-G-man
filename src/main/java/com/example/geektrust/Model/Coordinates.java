package com.example.geektrust.Model;

public class Coordinates {
    int startX;
    int startY;
    int endX;
    int endY;
    String initialDirection;

    public Coordinates(int startX, int startY, int endX, int endY, String initialDirection) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.initialDirection = initialDirection;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public String getInitialDirection() {
        return initialDirection;
    }

}
