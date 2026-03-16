package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    public  HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountDropMenu;

    @FindBy(linkText = "Register")
    private WebElement registerOption;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    @FindBy(xpath = "//h3[normalize-space()='Featured']")
    private WebElement homeFeatured;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement searchButton;

    @FindBy(xpath = "//i[@class='fa fa-phone']")
    private WebElement contactMenu;

    @FindBy(xpath = "//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")
    private WebElement cartMenu;

    @FindBy(xpath = "//a[@id='wishlist-total']//i[@class='fa fa-heart']")
    private WebElement whishListMenu;

    public  void clickOnMyAccount(){
        myAccountDropMenu.click();
    }

    public  void selectRegisterOption(){
        myAccountDropMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(registerOption)).click();
    }

    public  void selectLoginOption(){
        myAccountDropMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(loginOption)).click();
    }

    public  boolean isFeaturedDisplayed(){
        return homeFeatured.isDisplayed();
    }

    public void searchBox(String name){
        searchField.sendKeys(name);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void clickOnContact(){
        contactMenu.click();
    }

    public void clickOnCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartMenu)).click();
    }

    public  void clickonWhishList(){
        whishListMenu.click();
    }

}


