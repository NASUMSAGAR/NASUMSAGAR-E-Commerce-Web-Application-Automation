package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "MacBook")
    private WebElement cartMacBook;

    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
    private WebElement noProductMessage;

    @FindBy(xpath = "//button[contains(@onclick,'remove')]//i[@class='fa fa-times-circle']")
    private WebElement cancelProduct;

    @FindBy(xpath = "//a[normalize-space()='Use Coupon Code']")
    private WebElement cuponDropDown;

    @FindBy(id = "input-coupon")
    private WebElement cuponField;

    @FindBy(xpath = "//input[@id='button-coupon']")
    private WebElement applyCuponButton;

    @FindBy(xpath = "//a[normalize-space()='Use Gift Certificate']")
    private WebElement giftCardDropDown;

    @FindBy(id = "input-voucher")
    private WebElement giftCardField;

    @FindBy(xpath = "//input[@id='button-voucher']")
    private WebElement applyGiftCardButton;


    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")


    private WebElement dangerAlert;


    @FindBy(linkText = "Checkout")
    private WebElement checkOutButton;

    public boolean cartMacBookConfirm() { 
    	return cartMacBook.isDisplayed(); 
    }
    
    public boolean noProductMessage()   { 
    	return noProductMessage.isDisplayed(); 
    }

    public void clickOnCancel() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cancelProduct));
            wait.until(ExpectedConditions.elementToBeClickable(cancelProduct)).click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Cancel button not clickable or cart is already empty.");
        }
    }

    public void clickOnCuponDropDown(){ 
    	cuponDropDown.click(); 
    }
    
    public void setCuponField(String cupon){ 
    	cuponField.sendKeys(cupon); 
    }
    
    public void clickOnCuponSubmit(){ 
    	applyCuponButton.click(); 
    }
    
    public void clickOnGiftDropDown(){ 
    	giftCardDropDown.click(); 
    }
    
    public void setGiftCardField(String g){ 
    	giftCardField.sendKeys(g); 
    }
    
    public void clickOnApplyGiftButton(){ 
    	applyGiftCardButton.click(); 
    }
    
    public void clickOnCheckoutButton(){ 
    	checkOutButton.click(); 
    }


    public boolean isDangerAlertDisplayed() {
    	return dangerAlert.isDisplayed();
    }

}