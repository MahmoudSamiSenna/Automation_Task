package Framework.PageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//a[@title='Web Hosting']")
    WebElement webHostingMenu;
    @FindBy (xpath = "//a[@title='Domains']")
    WebElement domains;
    @FindBy (xpath = "//a[@title='All Web Hosting Plans']")
    WebElement allWebHostingPlans;
    public void goTo(){
        driver.get("https://www.inmotionhosting.com/");
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public void hoverOverWebHosting(){
        Actions actions = new Actions(driver);
        actions.moveToElement(webHostingMenu).perform();
    }
    public DomainPage clickOnDomains(){
        hoverOverWebHosting();
        domains.click();
        return new DomainPage(driver);
    }
    public WebHostingPlansPage clickOnWebHostingPlans(){
        hoverOverWebHosting();
        allWebHostingPlans.click();
        return new WebHostingPlansPage(driver);
    }







    public void waitElementToBeVisible (WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void getScreenshot(String screenshotName, WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"\\screenshots\\"+screenshotName+".png";
        File destination=new File(path);
        FileUtils.copyFile(source,destination);
    }
}
