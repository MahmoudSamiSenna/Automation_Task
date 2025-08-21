package Framework.TestComponents;

import Framework.PageObjects.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public SoftAssert softAssert;

    public WebDriver initializeDriver() {
        softAssert = new SoftAssert();
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    @BeforeMethod
    public HomePage launchApp(){
        driver=initializeDriver();
        homePage=new HomePage(driver);
        homePage.goTo();
        return homePage;
    }
    @AfterMethod
    public void tearDown(){
        softAssert.assertAll();
        driver.quit();
    }


}
