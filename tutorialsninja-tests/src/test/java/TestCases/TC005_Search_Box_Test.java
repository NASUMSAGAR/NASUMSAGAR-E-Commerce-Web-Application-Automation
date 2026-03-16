
package TestCases;

import Pages.HomePage;
import Pages.ProductsPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_Search_Box_Test extends BaseTest {

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void verify_with_valid_text() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.searchBox("Mac");
            homePage.clickOnSearchButton();
            ProductsPage productsPage = new ProductsPage(driver);
            Assert.assertTrue(productsPage.isProductDisplayed(), "Product is not displayed.");
        } catch (Exception e) {
            Assert.fail("verify_with_valid_text failed: " + e.getMessage(), e);
        }
    }

    @Test(priority = 2, groups = {"regression"})
    public void verify_with_invalid_text() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.searchBox("Bike");
            homePage.clickOnSearchButton();
            ProductsPage productsPage = new ProductsPage(driver);
            Assert.assertTrue(productsPage.searchResult(),
                    "No product message not displayed.");
        } catch (Exception e) {
            Assert.fail("verify_with_invalid_text failed: " + e.getMessage(), e);
        }
    }

    @Test(priority = 3, groups = {"regression"})
    public void verify_with_number() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.searchBox("1234");
            homePage.clickOnSearchButton();
            ProductsPage productsPage = new ProductsPage(driver);
            Assert.assertTrue(productsPage.searchResult(),
                    "No product message not displayed.");
        } catch (Exception e) {
            Assert.fail("verify_with_number failed: " + e.getMessage(), e);
        }
    }
}