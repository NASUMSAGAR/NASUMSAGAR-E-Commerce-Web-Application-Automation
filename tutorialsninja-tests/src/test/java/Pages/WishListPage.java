package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Continue")
    private WebElement continueButton;


    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='MacBook']")
    private WebElement wishListProduct;

    @FindBy(xpath = "//i[@class='fa fa-times']")
    private WebElement wishListCancel;


    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }


    public void setEmailField(String email){ 
    	emailField.sendKeys(email); 
    }
    
    public void setPasswordField(String pass){ 
    	passwordField.sendKeys(pass); 
    }
    
    public void clickLogin(){ 
    	loginButton.click(); 
    }

    public boolean isLoginFormDisplayed() {
        return emailField.isDisplayed() && passwordField.isDisplayed();
    }

    public boolean wishListProductDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(wishListProduct)).isDisplayed();
    }

    public void removeProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(wishListCancel)).click();
    }
}