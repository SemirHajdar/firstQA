package placelab.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import placelab.utilities.WebDriverSetup;

public class LoginTestForgotYourPassword {
    public WebDriver driver;
    private String host = System.getProperty("host");
    private String homePageUrl = "https://demo.placelab.com/dashboard/traffic";
    private String forgotPasswordUrl = "https://demo.placelab.com/password/forgot";
    private String forgotPasswordSecondUrl = "https://demo.placelab.com/email/sent";
    private String username = System.getProperty("username");


    @BeforeSuite
    public void initDriver() {

        driver = WebDriverSetup.getWebDriver("edge");
    }

    @Test
    public void testLoginPage() {

        driver.navigate().to(host);

        Assert.assertEquals(driver.getCurrentUrl(), host);
        Assert.assertEquals(driver.getTitle(), "PlaceLab");

        WebElement forgotYourPassword = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/form/div[2]/a"));
        forgotYourPassword.click();

        Assert.assertEquals(driver.getCurrentUrl(),forgotPasswordUrl);

        WebElement resetEmail = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/form/div/input"));
        resetEmail.sendKeys(username);

        WebElement continueButton = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/form/input[3]"));
        continueButton.click();

        Assert.assertEquals(driver.getCurrentUrl(),forgotPasswordSecondUrl);
    }
    @AfterSuite
    public void quitDriver() {
        driver.close();
    }
}
