
package TestCases;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_Login_Test extends BaseTest {

    @Test(priority = 1, groups = {"smoke", "sanity", "regression"})
    public void login_with_valid_credentials() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.selectLoginOption();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(prop.getProperty("login.email"));
            loginPage.enterPassword(prop.getProperty("login.password"));
            loginPage.clickLogin();
            AccountPage accountPage = new AccountPage(driver);
            Assert.assertTrue(accountPage.accountConfirmation(),
                    "Login failed — My Account page not displayed.");
        } catch (Exception e) {
            Assert.fail("login_with_valid_credentials failed: " + e.getMessage(), e);
        }
    }

    @Test(priority = 2, groups = {"sanity", "regression"})
    public void login_with_invalid_credentials() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.selectLoginOption();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail("invalid_user@gmail.com");
            loginPage.enterPassword("wrongpassword");
            loginPage.clickLogin();
            Assert.assertTrue(loginPage.loginWarning(),
                    "Warning message not displayed for invalid credentials.");
        } catch (Exception e) {
            Assert.fail("login_with_invalid_credentials failed: " + e.getMessage(), e);
        }
    }
}