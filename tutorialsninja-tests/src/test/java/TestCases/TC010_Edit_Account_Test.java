
package TestCases;

import Pages.AccountPage;
import Pages.EditAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC010_Edit_Account_Test extends BaseTest {

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void verify_account_update() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(prop.getProperty("admin.email"));
        loginPage.enterPassword(prop.getProperty("admin.password"));
        loginPage.clickLogin();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnEditAccount();
        EditAccountPage editAccountPage = new EditAccountPage(driver);
        editAccountPage.setFirstName("Joe");
        editAccountPage.clickOnContinueButton();
        Assert.assertTrue(accountPage.isAccountUpdateMessageDisplayed(),
                "Account update confirmation not displayed.");
    }

    @Test(priority = 2, groups = {"regression"})
    public void verify_account_update_with_existing_email() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(prop.getProperty("admin.email"));
        loginPage.enterPassword(prop.getProperty("admin.password"));
        loginPage.clickLogin();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnEditAccount();
        EditAccountPage editAccountPage = new EditAccountPage(driver);
        editAccountPage.setEmailField("joe@example.com");
        editAccountPage.clickOnContinueButton();
        Assert.assertTrue(accountPage.isAccountFailedMessageDisplayed(),
                "Account update failure message not displayed.");
    }
}