package com.example.geektrust.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatePointsTest {

    @Test
    void sameAxisNoTurn1(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(160,calculatePoints.calculateRemainingPower(2,1,2,5,"N"));
    }
    @Test
    void sameAxisOneTurn1(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(155,calculatePoints.calculateRemainingPower(1,1,5,1,"S"));
    }
    @Test
    void sameAxisTwoTurn1(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(150,calculatePoints.calculateRemainingPower(5,4,1,4,"E"));
    }
    @Test
    void sameAxisTwoTurn2(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(130,calculatePoints.calculateRemainingPower(0,3,6,3,"W"));
    }
    @Test
    void sameAxisOneTurn2(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(155,calculatePoints.calculateRemainingPower(2,1,6,1,"N"));
    }

    @Test
    void sameAxisOneTurn3(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(155,calculatePoints.calculateRemainingPower(2,1,2,5,"E"));
    }

    @Test
    void sameAxisOneTurn4(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(155,calculatePoints.calculateRemainingPower(2,5,2,1,"E"));
    }

    @Test
    void sameStartAndEndPoint(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(200,calculatePoints.calculateRemainingPower(6,3,6,3,"W"));
    }

    @Test
    void differentAxisTwoTurn1(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(170,calculatePoints.calculateRemainingPower(0,3,1,4,"W"));
    }
    @Test
    void differentAxisTwoTurn2(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(100,calculatePoints.calculateRemainingPower(6,1,2,6,"S"));
    }
    @Test
    void differentAxisOneTurn1(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(140,calculatePoints.calculateRemainingPower(5,1,1,2,"S"));
    }
    @Test
    void differentAxisOneTurn2(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(125,calculatePoints.calculateRemainingPower(5,5,1,2,"S"));
    }
    @Test
    void differentAxisOneTurn3(){
        CalculatePoints calculatePoints = new CalculatePoints();
        assertEquals(115,calculatePoints.calculateRemainingPower(2,5,6,1,"E"));
    }
}