package com.vytrack.step_definations;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void setup(){
        System.out.println("test setup!");
    }


    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Test failed!");
        } else {

            System.out.println("Clean up!");
            System.out.println("Test completed!");
        }
    }


}
