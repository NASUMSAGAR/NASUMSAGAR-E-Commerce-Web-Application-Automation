package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgottenPasswordPage extends BasePage{
    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement setEmailField;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement emailNotRegisteredAlert;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement resetLinkSent;

    public void emailField(String email){
        setEmailField.sendKeys(email);
    }

    public void clickOnContinue(){
        continueButton.click();
    }

    public boolean failedAlert(){
        return emailNotRegisteredAlert.isDisplayed();
    }

    public boolean successAlert(){
        return  resetLinkSent.isDisplayed();
    }
}
