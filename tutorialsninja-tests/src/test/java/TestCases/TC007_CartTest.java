
package TestCases;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_CartTest extends BaseTest {

    @Test(priority = 1, groups = {"smoke", "sanity", "regression"})
    public void verify_cart_with_product() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnMacBook();
        productsPage.clickOnDescription();
        productsPage.clickOnSpecification();
        productsPage.clickOnReviews();
        productsPage.clickQuantity("1");
        productsPage.clickAddToCartButton();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.cartMacBookConfirm(), "Product not added to cart!");
    }

    @Test(priority = 2, groups = {"sanity", "regression"})
    public void verify_cancel_product() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnMacBook();
        productsPage.clickQuantity("1");
        productsPage.clickAddToCartButton();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCancel();
        Assert.assertTrue(cartPage.noProductMessage(), "Product not removed from cart.");
    }

    @Test(priority = 3, groups = {"regression"})
    public void verify_with_invalid_coupon_code() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnMacBook();
        productsPage.clickQuantity("1");
        productsPage.clickAddToCartButton();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCuponDropDown();
        cartPage.setCuponField("Flat50%");
        cartPage.clickOnCuponSubmit();
        Assert.assertTrue(cartPage.isDangerAlertDisplayed(), "Coupon alert not displayed.");
    }

    @Test(priority = 4, groups = {"regression"})
    public void verify_with_invalid_gift_certificate() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnMacBook();
        productsPage.clickQuantity("1");
        productsPage.clickAddToCartButton();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnGiftDropDown();
        cartPage.setGiftCardField("Flat50%");
        cartPage.clickOnApplyGiftButton();
        Assert.assertTrue(cartPage.isDangerAlertDisplayed(), "Gift certificate alert not displayed.");
    }

    @Test(priority = 5, groups = {"regression"})
    public void verify_checkout_with_outOfStock() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnMacBook();
        productsPage.clickQuantity("1");
        productsPage.clickAddToCartButton();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(cartPage.isDangerAlertDisplayed(), "Out of stock alert not displayed.");
    }
}