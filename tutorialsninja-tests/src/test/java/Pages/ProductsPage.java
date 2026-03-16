package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "iMac")
    private WebElement macResult;

    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
    private WebElement noProduct;

    @FindBy(linkText = "MacBook")
    private WebElement macBookProduct;

    @FindBy(linkText = "iPhone")
    private WebElement iPhoneProduct;

    @FindBy(linkText = "Apple Cinema 30")
    private WebElement appleCinemaProduct;

    @FindBy(linkText = "Canon EOS 5D")
    private WebElement canonProduct;

    @FindBy(linkText = "Description")
    private WebElement descriptionArea;

    @FindBy(linkText = "Specification")
    private WebElement specificationArea;

    @FindBy(linkText = "Reviews (0)")
    private WebElement reviewsArea;

    @FindBy(id = "input-quantity")
    private WebElement quantityField;

    @FindBy(xpath = "//button[@id='button-cart']")
    private WebElement addCartButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement cartAddedConfirmMessage;

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    private WebElement wishListButton;


    public boolean isProductDisplayed(){
        return macResult.isDisplayed();
    }

    public boolean searchResult(){
        return noProduct.isDisplayed();
    }

    public void clickOnMacBook(){
        wait.until(ExpectedConditions.elementToBeClickable(macBookProduct)).click();
    }

    public void clickOnIPhone(){
        iPhoneProduct.click();
    }
    public void clickOnAppleCinema(){
        appleCinemaProduct.click();
    }
    public void clickCanon(){
        canonProduct.click();
    }
    public void clickOnDescription(){
        descriptionArea.click();
    }
    public void clickOnSpecification(){
        specificationArea.click();
    }
    public void clickOnReviews(){
        reviewsArea.click();
    }
    public void clickQuantity(String number){
        quantityField.clear();
        quantityField.sendKeys(number);
    }
    public void clickAddToCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addCartButton)).click();
    }

    public boolean productConfirm(){
        return cartAddedConfirmMessage.isDisplayed();
    }

    public void clickWishListButton(){
        wait.until(ExpectedConditions.elementToBeClickable(wishListButton)).click();
    }
}
