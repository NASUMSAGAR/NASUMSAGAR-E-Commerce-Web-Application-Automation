
package TestCases;

import Pages.ForgottenPasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC009_ForgottenPasswordTest extends BaseTest {

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void verify_with_registered_email() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(prop.getProperty("login.email"));
        loginPage.clickOnForgottenPassword();
        ForgottenPasswordPage fp = new ForgottenPasswordPage(driver);
        fp.emailField(prop.getProperty("login.email"));
        fp.clickOnContinue();
        Assert.assertTrue(fp.successAlert(), "Password reset success alert not displayed.");
    }

    @Test(priority = 2, groups = {"regression"})
    public void verify_with_unregistered_email() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(prop.getProperty("login.email"));
        loginPage.clickOnForgottenPassword();
        ForgottenPasswordPage fp = new ForgottenPasswordPage(driver);
        fp.emailField("unregistered_xyz@gmail.com");
        fp.clickOnContinue();
        Assert.assertTrue(fp.failedAlert(), "Password reset failure alert not displayed.");
    }
}