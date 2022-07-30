package com.example.geektrust.Service;

import com.example.geektrust.Model.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class calculatePointsTest {

    @Test
    void sameAxisNoTurnNorthFacing(){
        PowerService powerService = new PowerService();
        assertEquals(160, powerService.calculatePowerLeft(new Coordinates(2,1,2,5,"N")));
    }
    @Test
    void sameAxisOneTurnSouthFacing(){
        PowerService powerService = new PowerService();
        assertEquals(155, powerService.calculatePowerLeft(new Coordinates(1,1,5,1,"S")));
    }
    @Test
    void sameAxisTwoTurnEastFacing(){
        PowerService powerService = new PowerService();
        assertEquals(150, powerService.calculatePowerLeft(new Coordinates(5,4,1,4,"E")));
    }
    @Test
    void sameAxisTwoTurnWestFacing(){
        PowerService powerService = new PowerService();
        assertEquals(130, powerService.calculatePowerLeft(new Coordinates(0,3,6,3,"W")));
    }
    @Test
    void sameAxisOneTurnNorthFacing(){
        PowerService powerService = new PowerService();
        assertEquals(155, powerService.calculatePowerLeft(new Coordinates(2,1,6,1,"N")));
    }

    @Test
    void sameAxisOneTurnEastFacing(){
        PowerService powerService = new PowerService();
        assertEquals(155, powerService.calculatePowerLeft(new Coordinates(2,1,2,5,"E")));
    }

    @Test
    void sameAxisOneTurnEastDirection(){
        PowerService powerService = new PowerService();
        assertEquals(155, powerService.calculatePowerLeft(new Coordinates(2,5,2,1,"E")));
    }

    @Test
    void sameAxisOneEast(){
        PowerService powerService = new PowerService();
        assertEquals(185, powerService.calculatePowerLeft(new Coordinates(2,1,2,2,"E")));
    }

    @Test
    void sameStartAndEndPoint(){
        PowerService powerService = new PowerService();
        assertEquals(200, powerService.calculatePowerLeft(new Coordinates(6,3,6,3,"W")));
    }

    @Test
    void differentAxisTwoTurnWestFacing(){
        PowerService powerService = new PowerService();
        assertEquals(170, powerService.calculatePowerLeft(new Coordinates(0,3,1,4,"W")));
    }
    @Test
    void differentAxisTwoTurnSouthFacing(){
        PowerService powerService = new PowerService();
        assertEquals(100, powerService.calculatePowerLeft(new Coordinates(6,1,2,6,"S")));
    }
    @Test
    void differentAxisOneTurnSouthFacing(){
        PowerService powerService = new PowerService();
        assertEquals(140, powerService.calculatePowerLeft(new Coordinates(5,1,1,2,"S")));
    }
    @Test
    void differentAxisOneTurnSouthDirection(){
        PowerService powerService = new PowerService();
        assertEquals(125, powerService.calculatePowerLeft(new Coordinates(5,5,1,2,"S")));
    }
    @Test
    void differentAxisOneTurnEastFacing(){
        PowerService powerService = new PowerService();
        assertEquals(115, powerService.calculatePowerLeft(new Coordinates(2,5,6,1,"E")));
    }
}