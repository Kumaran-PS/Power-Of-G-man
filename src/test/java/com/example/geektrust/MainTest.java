package com.example.geektrust;

import org.junit.jupiter.api.Test;



public class MainTest {

    @Test
    public void testMain()  {
        System.out.println("main");
        String[] args = {"SOURCE 0 5 W\n" +
                "DESTINATION 6 1\n" +
                "PRINT_POWER"};
        String arg[] = {""};
        Main.main(arg);
    }
}