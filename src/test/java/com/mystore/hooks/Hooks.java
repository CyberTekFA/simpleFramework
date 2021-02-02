package com.mystore.hooks;

import com.mystore.drivers.Driver;
import com.mystore.utilities.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before(order = 1)
    public void setUpDriver(){
        Driver.getDriver().get(ConfigurationReader.getInstance().getProperty("url"));
    }

    @After(order = 2)
    public void tearDown(){
        Driver.closeDriver();
    }
}
