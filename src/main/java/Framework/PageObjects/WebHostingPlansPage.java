package Framework.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebHostingPlansPage extends HomePage {
    WebDriver driver;
    public WebHostingPlansPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "(//a[@class='cta-link btn-primary'][normalize-space()='Select Plan'])[3]")
    WebElement selectPlanButton;
    @FindBy (xpath = "(//a[@type='button'][normalize-space()='Select'])[11]")
    WebElement selectPlanForOneYear;

    public CheckOutPage clickOnSelectPlanButton(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1800)");
        selectPlanButton.click();
        js.executeScript("window.scrollBy(0,800)");
        waitElementToBeVisible(selectPlanForOneYear);
        selectPlanForOneYear.click();
        return new CheckOutPage(driver);
    }
}
