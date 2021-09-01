package com.when_i_work.step_definitions;

import com.when_i_work.pages.ApplicationPage;
import com.when_i_work.utilities.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ScheduleStepDefinitions {
    ApplicationPage applicationPage = new ApplicationPage();
    WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), 30);

    @Given("User is on the scheduler page")
    public void user_is_on_the_scheduler_page() {
        applicationPage.schedulerTab.click();
        MyDriver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Then("User creates schedule")
    public void user_creates_schedule() throws InterruptedException {
        applicationPage.table9.click();
        applicationPage.timeInput.sendKeys("9:00AM");
        applicationPage.firstOption.click();
        applicationPage.timeInput.sendKeys("11:00AM");
        applicationPage.firstOption.click();
        applicationPage.breakTime.sendKeys("15");
        applicationPage.saveButton.click();
    }

    @Then("User closes the browser")
    public void user_closes_the_browser() {
        wait.until(ExpectedConditions.visibilityOf(applicationPage.newSchedule));
        MyDriver.closeDriver();
    }
}
