package placelab.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import placelab.utilities.WebDriverSetup;

public class LoginTestSubtitles {
    public WebDriver driver;
    private String host = System.getProperty("host");
    private String homePageUrl = "https://demo.placelab.com/dashboard/traffic";

    @BeforeSuite
    public void initDriver() {

        driver = WebDriverSetup.getWebDriver("edge");
    }

    @Test
    public void testLoginPage() {

        driver.navigate().to(host);

        Assert.assertEquals(driver.getCurrentUrl(), host);
        Assert.assertEquals(driver.getTitle(), "PlaceLab");

        WebElement mainSubtitle = driver.findElement(By.xpath("/html/body/div/div[1]/div/p"));
        boolean subtitlePresent = mainSubtitle.isDisplayed();
        Assert.assertTrue(subtitlePresent);

        WebElement firstSubtitle = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/p"));
        boolean firstSubtitlePresent = firstSubtitle.isDisplayed();
        Assert.assertTrue(firstSubtitlePresent);

        WebElement secondSubtitle = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[2]/div[2]/p"));
        boolean secondSubtitlePresent = secondSubtitle.isDisplayed();
        Assert.assertTrue(secondSubtitlePresent);

        WebElement thirdSubtitle = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[3]/div[2]/p"));
        boolean thirdSubtitlePresent = thirdSubtitle.isDisplayed();
        Assert.assertTrue(thirdSubtitlePresent);

    }
    @AfterSuite
    public void quitDriver() {
        driver.close();
    }
}