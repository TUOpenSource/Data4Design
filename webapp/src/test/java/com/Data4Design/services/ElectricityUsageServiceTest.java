package com.Data4Design.services;

import org.junit.Test;

public class ElectricityUsageServiceTest {

    @Test
    public void testGetElectricityUsage() {
        ElectricityUsageService test = new ElectricityUsageService();
        test.getElectricityUsage("usa");
    }

}
