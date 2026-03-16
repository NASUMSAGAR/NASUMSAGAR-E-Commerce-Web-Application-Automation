package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="input-name")
    private WebElement nameField;

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-enquiry")
    private WebElement enquiryField;

    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitButton;

    @FindBy(linkText = "Continue")
    private WebElement continueButoon;

    public void enterName(String name){
        nameField.sendKeys(name);
    }

    public  void  enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterEnquiry(String enquiry){
        enquiryField.sendKeys(enquiry);
    }

    public void clickOnSubmit(){
        submitButton.click();
    }

    public void clickOnContinue(){
        continueButoon.click();
    }


}
