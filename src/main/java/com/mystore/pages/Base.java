package com.mystore.pages;

import com.mystore.drivers.Driver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    public <T extends Base> T getInstanceOf(Class<T> page){
        Object obj = PageFactory.initElements(Driver.getDriver(),page);
        return page.cast(obj);
    }
}
