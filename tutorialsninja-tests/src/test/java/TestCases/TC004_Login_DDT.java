
package TestCases;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_Login_DDT extends BaseTest {

    @Test(dataProvider = "login-data-excel", dataProviderClass = DataProviders.class,
          groups = {"regression"})
    public void loginDataDriven(String email, String password, String expectedFlag) {
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginOption();
        LoginPage lp = new LoginPage(driver);
        lp.enterEmail(email);
        lp.enterPassword(password);
        lp.clickLogin();
        boolean expectSuccess = Boolean.parseBoolean(expectedFlag);
        if (expectSuccess) {
            Assert.assertTrue(new AccountPage(driver).accountConfirmation(),
                    "Expected successful login FAILED for: " + email);
        } else {
            Assert.assertTrue(lp.loginWarning(),
                    "Expected warning not shown for: " + email);
        }
    }
}