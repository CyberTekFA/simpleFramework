package com.mystore.stepdefs;

import com.github.javafaker.Faker;
import com.mystore.pages.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends SignUpPage {

    @Given("I as user enter a valid email into email field")
    public void i_as_user_enter_a_valid_email_into_email_field() {
        getInstanceOf(SignUpPage.class).loginButton.click();
    }

    @When("I click submit button")
    public void i_click_submit_button() {
        Faker faker = new Faker();
        getInstanceOf(SignUpPage.class).emailField.sendKeys(faker.name().firstName()+"@gmail.com");
    }
    @Then("I verify sign Up page displayed")
    public void i_verify_sign_up_page_displayed() {
        getInstanceOf(SignUpPage.class).createAccountButton.click();
    }
}
