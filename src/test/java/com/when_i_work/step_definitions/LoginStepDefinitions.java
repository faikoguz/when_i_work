package com.when_i_work.step_definitions;

import com.when_i_work.pages.ApplicationPage;
import com.when_i_work.pages.LoginPage;
import com.when_i_work.utilities.ConfigurationReader;
import com.when_i_work.utilities.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    ApplicationPage applicationPage = new ApplicationPage();
    WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 30);

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        MyDriver.getDriver().manage().window().maximize();
        MyDriver.getDriver().get(ConfigurationReader.getProperty("login_url"));
    }

    @Given("User provides email")
    public void user_provides_email() {
        wait.until(ExpectedConditions.titleContains("Log In"));
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("email"));
    }

    @Given("User provides password")
    public void user_provides_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @Then("User clicks LOG IN")
    public void user_clicks_log_in() {
        loginPage.loginButton.click();
    }

    @Then("User is on the dashboard")
    public void user_is_on_the_dashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(applicationPage.dashboardTab));
        String color = applicationPage.dashboardTab.getCssValue("color");
        Assert.assertEquals(color, "rgba(255, 255, 255, 1)"); //to verify the dashboard tab is selected
    }
}