
package TestCases;

import Pages.AccountPage;
import Pages.ChangePasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC011_Change_Password_Test extends BaseTest {

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void verify_with_new_password() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(prop.getProperty("admin.email"));
        loginPage.enterPassword(prop.getProperty("admin.old.password"));
        loginPage.clickLogin();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnPassword();
        ChangePasswordPage cpp = new ChangePasswordPage(driver);
        cpp.enterPassword(prop.getProperty("admin.password"));
        cpp.enterConfirmPassword(prop.getProperty("admin.password"));
        cpp.clickOnContinuButton();
        Assert.assertTrue(accountPage.isAccountUpdateMessageDisplayed(),
                "Password update confirmation not displayed.");
    }

    @Test(priority = 2, dependsOnMethods = "verify_with_new_password",
          groups = {"regression"})
    public void verify_with_different_password() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(prop.getProperty("admin.email"));
        loginPage.enterPassword(prop.getProperty("admin.password"));
        loginPage.clickLogin();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnPassword();
        ChangePasswordPage cpp = new ChangePasswordPage(driver);
        cpp.enterPassword("newpassword123");
        cpp.enterConfirmPassword("differentpassword456");
        cpp.clickOnContinuButton();
        Assert.assertTrue(cpp.isPasswordMismatched(), "Password mismatch error not displayed.");
    }
}