package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private  WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private  WebElement loginWarning;

    @FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
    private WebElement forgottenPasswordLink;

    public  void  enterEmail(String email){
         emailField.sendKeys(email);
    }

    public  void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public boolean loginWarning(){
        return loginWarning.isDisplayed();
    }

    public void clickOnForgottenPassword(){
        wait.until(ExpectedConditions.elementToBeClickable(forgottenPasswordLink)).click();
    }
}
