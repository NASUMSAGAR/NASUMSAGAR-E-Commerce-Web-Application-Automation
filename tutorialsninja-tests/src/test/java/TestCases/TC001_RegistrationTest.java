
package TestCases;

import Pages.HomePage;
import Pages.RegistrationConfirmPage;
import Pages.RegistrationPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

public class TC001_RegistrationTest extends BaseTest {

    @Test(priority = 1, groups = {"regression"})
    public void verify_account_registration() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.selectRegisterOption();
            RegistrationPage registrationPage = new RegistrationPage(driver);
            String email = "user_" + UUID.randomUUID() + "@test.com";
            registrationPage.enterFirstName("Allu");
            registrationPage.enterLastName("Ayan");
            registrationPage.enterEmail(email);
            registrationPage.enterTelephone("1234567894");
            registrationPage.enterPassword("Password123");
            registrationPage.enterConfirmPassword("Password123");
            registrationPage.selectPrivacyPolicy();
            registrationPage.clickContinue();
            RegistrationConfirmPage rcp = new RegistrationConfirmPage(driver);
            Assert.assertTrue(rcp.isMessageDisplayed(),
                    "Account creation confirmation not displayed.");
        } catch (Exception e) {
            Assert.fail("verify_account_registration failed: " + e.getMessage(), e);
        }
    }

    @Test(priority = 2, groups = {"regression"})
    public void verify_registration_with_existing_email() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.selectRegisterOption();
            RegistrationPage registrationPage = new RegistrationPage(driver);
            registrationPage.enterFirstName("Allu");
            registrationPage.enterLastName("Ayan");
            registrationPage.enterEmail("regret@gmail.com");
            registrationPage.enterTelephone("1234567894");
            registrationPage.enterPassword("Password123");
            registrationPage.enterConfirmPassword("Password123");
            registrationPage.selectPrivacyPolicy();
            registrationPage.clickContinue();
            Assert.assertTrue(registrationPage.isWarningMessageDisplayed(),
                    "Warning: E-Mail already registered was not displayed.");
        } catch (Exception e) {
            Assert.fail("verify_registration_with_existing_email failed: " + e.getMessage(), e);
        }
    }

    @Test(priority = 3, groups = {"regression"})
    public void verify_registration_without_privacy_policy() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.selectRegisterOption();
            RegistrationPage registrationPage = new RegistrationPage(driver);
            registrationPage.enterFirstName("Allu");
            registrationPage.enterLastName("Ayan");
            registrationPage.enterEmail("regret@gmail.com");
            registrationPage.enterTelephone("1234567894");
            registrationPage.enterPassword("Password123");
            registrationPage.enterConfirmPassword("Password123");
            registrationPage.clickContinue();
            Assert.assertTrue(registrationPage.isPrivacyWarningDisplayed(),
                    "Privacy Policy warning was not displayed.");
        } catch (Exception e) {
            Assert.fail("verify_registration_without_privacy_policy failed: " + e.getMessage(), e);
        }
    }
}