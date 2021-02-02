package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends Base {

    @FindBy(className = "header_user_info")
    public WebElement loginButton;
    @FindBy(id = "email_create")
    public WebElement emailField;
    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;

}
