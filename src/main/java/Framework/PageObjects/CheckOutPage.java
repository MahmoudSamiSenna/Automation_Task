package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckOutPage extends HomePage{
    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="mat-input-0")
    WebElement domainSearchBox;
    @FindBy (xpath = "//span[normalize-space()='Search Domains']")
    WebElement domainSearchButton;
    @FindBy (xpath = "(//span[@class='ctw-float-right notranslate'])[3]")
    WebElement totalPrice;
    @FindBy (xpath = "(//div[@class='ctw-font-bold ctw-italic ctw-text-sm notranslate ng-star-inserted'])[1]")
    WebElement domainTitle;
    @FindBy (xpath = "(//mat-icon[@aria-label='Remove'][normalize-space()='delete'])[2]")
    WebElement deleteDomainButton;

    public void goToCheckOut (String domainName){
        domainSearchBox.sendKeys(domainName);
        domainSearchButton.click();
    }
    public String getTotalPrice () throws IOException {
        waitElementToBeVisible(totalPrice);
        getScreenshot("Final card view",driver);
        return totalPrice.getText();
    }
    public String getDomainTitle (){
        waitElementToBeVisible(domainTitle);
        return domainTitle.getText();
    }
    public void deleteDomain (){
        waitElementToBeVisible(deleteDomainButton);
        deleteDomainButton.click();
    }
    public void refreshPage(){
        waitElementToBeVisible(totalPrice);
        driver.navigate().refresh();
    }

}
