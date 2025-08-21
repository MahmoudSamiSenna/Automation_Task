package Framework.Tests;

import Framework.PageObjects.DomainPage;
import Framework.PageObjects.DomainSearchResultPage;
import Framework.PageObjects.CheckOutPage;
import Framework.PageObjects.WebHostingPlansPage;
import Framework.TestComponents.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebHostingTest extends BaseTest {
    String pageTitle ="InMotion Hosting";
    String domainName = "myautomationtest123.com";
    String invalidMessage="google.com is taken.";
    String invalidDomain= "google.com";
    String domainPrice ="$38.99 USD";
    String totalPrice="$109.35 USD";
    @Test (priority = 1)
    public void addDomainAndHostingPlanToCard() throws IOException, InterruptedException {
        softAssert.assertTrue(homePage.getPageTitle().contains(pageTitle));
        DomainPage domainPage = homePage.clickOnDomains();
        DomainSearchResultPage domainSearchResultPage = domainPage.searchForDomain(domainName);
        softAssert.assertTrue(domainSearchResultPage.checkTotalPriceAppearance());
        softAssert.assertEquals(domainSearchResultPage.getDomainPrice(), domainPrice);
        homePage.goTo();
        WebHostingPlansPage webHostingPlansPage=homePage.clickOnWebHostingPlans();
        CheckOutPage checkOutPage=webHostingPlansPage.clickOnSelectPlanButton();
        checkOutPage.goToCheckOut(domainName);
        softAssert.assertEquals(checkOutPage.getTotalPrice(),totalPrice);
        softAssert.assertEquals(checkOutPage.getDomainTitle(),domainName);
        checkOutPage.refreshPage();
        softAssert.assertEquals(checkOutPage.getTotalPrice(),totalPrice);
        softAssert.assertEquals(checkOutPage.getDomainTitle(),domainName);
        checkOutPage.deleteDomain();
    }
    @Test (priority = 2)
    public void InvalidDomain () throws IOException {
        DomainPage domainPage = homePage.clickOnDomains();
        domainPage.searchInvalidDomain(invalidDomain);
        softAssert.assertEquals(domainPage.getErrorMessage(),invalidMessage);
    }
}
