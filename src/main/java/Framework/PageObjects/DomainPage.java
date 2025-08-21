package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class DomainPage extends HomePage {
    WebDriver driver;
    public DomainPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (id="domain_search_domain")
    WebElement searchBox;
    @FindBy (id="domain_submit")
    WebElement searchButton;
    @FindBy (xpath = "(//span[@class='ctw-font-bold ctw-text-red-700'])[1]")
    WebElement invalidMessage;
    public DomainSearchResultPage searchForDomain (String domainName) throws IOException, InterruptedException {
        waitElementToBeVisible(searchBox);
        searchBox.sendKeys(domainName);
        searchButton.click();
        Thread.sleep(2000);
        getScreenshot("Domain search",driver);
        return new DomainSearchResultPage(driver);
    }
    public void searchInvalidDomain(String domainName)  {
        waitElementToBeVisible(searchBox);
        searchBox.sendKeys(domainName);
        searchButton.click();
    }
    public String getErrorMessage() throws IOException {
        waitElementToBeVisible(invalidMessage);
        getScreenshot("Invalid domain search",driver);
        return invalidMessage.getText();
    }
}
