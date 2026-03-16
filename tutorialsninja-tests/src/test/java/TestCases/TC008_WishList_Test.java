
package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductsPage;
import Pages.WishListPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC008_WishList_Test extends BaseTest {

    private void loginAndAddMacBookToWishlist() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(prop.getProperty("login.email"));
        loginPage.enterPassword(prop.getProperty("login.password"));
        loginPage.clickLogin();
        homePage.searchBox("MacBook");
        homePage.clickOnSearchButton();
        new ProductsPage(driver).clickOnMacBook();
        new ProductsPage(driver).clickWishListButton();
        homePage.clickonWhishList();
    }

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void verify_wishlist_requires_login() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnMacBook();
        productsPage.clickWishListButton();
        new HomePage(driver).clickonWhishList();
        WishListPage wishListPage = new WishListPage(driver);
        Assert.assertTrue(wishListPage.isLoginFormDisplayed(),
                "Wishlist did not redirect to login page for unauthenticated user.");
    }

    @Test(priority = 2, groups = {"sanity", "regression"})
    public void verify_wishList_with_login() {
        loginAndAddMacBookToWishlist();
        WishListPage wishListPage = new WishListPage(driver);
        Assert.assertTrue(wishListPage.wishListProductDisplayed(),
                "Product not shown in WishList after adding.");
    }

    @Test(priority = 3, groups = {"regression"})
    public void verify_cancel_wishList_product() {
        loginAndAddMacBookToWishlist();
        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.removeProduct();
        try {
            Assert.assertFalse(wishListPage.wishListProductDisplayed(),
                    "Product still shown in wishlist after removal.");
        } catch (org.openqa.selenium.TimeoutException e) {
            // Element not found = product removed = PASS
        }
    }
}