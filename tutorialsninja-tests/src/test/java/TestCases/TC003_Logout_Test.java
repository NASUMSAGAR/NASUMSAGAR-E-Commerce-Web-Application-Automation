
package TestCases;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_Logout_Test extends BaseTest {

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verify_logout() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.selectLoginOption();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(prop.getProperty("login.email"));
            loginPage.enterPassword(prop.getProperty("login.password"));
            loginPage.clickLogin();
            AccountPage accountPage = new AccountPage(driver);
            accountPage.clickOnAccountDropdown();
            accountPage.clickOnLogout();
            accountPage.clickOnContinue();
            Assert.assertTrue(homePage.isFeaturedDisplayed(), "Logout failed.");
        } catch (Exception e) {
            Assert.fail("verify_logout failed: " + e.getMessage(), e);
        }
    }
}