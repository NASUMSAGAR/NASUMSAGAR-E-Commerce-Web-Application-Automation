package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationConfirmPage extends BasePage{
    public RegistrationConfirmPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement confirmMessage;

    public  boolean isMessageDisplayed(){
        return confirmMessage.isDisplayed();
    }
}
