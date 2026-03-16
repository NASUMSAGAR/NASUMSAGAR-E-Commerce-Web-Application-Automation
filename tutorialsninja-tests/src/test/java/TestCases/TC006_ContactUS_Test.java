
package TestCases;

import Pages.ContactUsPage;
import Pages.HomePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_ContactUS_Test extends BaseTest {

    @Test(priority = 1, groups = {"regression"})
    public void verify_contactUS_with_ValidInfo() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickOnContact();
            ContactUsPage contactUsPage = new ContactUsPage(driver);
            contactUsPage.enterName("Johncena");
            contactUsPage.enterEmail("cena@gmail.com");
            contactUsPage.enterEnquiry("My Account is Not working");
            contactUsPage.clickOnSubmit();
            contactUsPage.clickOnContinue();
            Assert.assertTrue(homePage.isFeaturedDisplayed(), "ContactUs submission failed.");
        } catch (Exception e) {
            Assert.fail("verify_contactUS_with_ValidInfo failed: " + e.getMessage(), e);
        }
    }
}