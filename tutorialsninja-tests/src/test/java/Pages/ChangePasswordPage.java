package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage{
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='text-danger']")
    private WebElement passwordMismatch;

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword){
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public boolean isPasswordMismatched(){
        return passwordMismatch.isDisplayed();
    }

    public void clickOnContinuButton(){
        continueButton.click();
    }
}
