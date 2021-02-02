package com.mystore.hooks;

import com.mystore.drivers.Driver;
import com.mystore.utilities.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @After(order = 2)
    public void tearDown(){
        Driver.closeDriver();
    }
}
