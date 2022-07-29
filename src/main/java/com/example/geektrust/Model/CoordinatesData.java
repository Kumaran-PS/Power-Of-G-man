package com.example.geektrust.Model;

public class CoordinatesData {
    int x1;
    int y1;
    int x2;
    int y2;
    String directionFacing;

    public CoordinatesData(int x1, int y1, int x2, int y2, String directionFacing) {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
        this.directionFacing = directionFacing;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public String getDirectionFacing() {
        return directionFacing;
    }
}
