package com.when_i_work.pages;

import com.when_i_work.utilities.MyDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationPage {
    public ApplicationPage() {
        PageFactory.initElements(MyDriver.getDriver(), this);
    }

    @FindBy(xpath = "//header/ul[1]/li[2]/a[1]")
    public WebElement dashboardTab;

    @FindBy(xpath = "//header/ul[1]/li[3]/a[1]")
    public WebElement schedulerTab;

    @FindBy(xpath = "(//div[@class='shift-holder'])[9]")
    public WebElement table9;

    @FindBy(xpath = "//input[@aria-controls='react-autowhatever-1']")
    public WebElement timeInput;

    @FindBy(xpath = "//li[@id='react-autowhatever-1--item-0']")
    public WebElement firstOption;

    @FindBy(name = "break_time")
    public WebElement breakTime;

    @FindBy(name = "save")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(),'9a')]")
    public WebElement newSchedule;

}
