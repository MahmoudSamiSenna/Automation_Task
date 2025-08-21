package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DomainSearchResultPage extends HomePage{
    WebDriver driver;
    public DomainSearchResultPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = ".ctw-float-right")
    WebElement totalPrice;


    public String getTotalPrice(){
        return totalPrice.getText();
    }
    public boolean checkTotalPriceAppearance() {
        try {
            waitElementToBeVisible(totalPrice);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
