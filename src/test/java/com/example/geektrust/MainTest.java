package com.example.geektrust;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainTest {

    @Test
    public void testMain() throws IOException {
        System.out.println("main");
        String[] args = {""};
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("sample_input/input1.txt"));
        System.setIn(fips);
        Main.main(args);
        System.setIn(original);
    }
}