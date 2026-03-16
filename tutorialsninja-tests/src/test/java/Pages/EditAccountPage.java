package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends BasePage {

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailField;


    @FindBy(id = "input-telephone")
    private WebElement telephoneField;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    public void setFirstName(String fName) {
        firstNameField.clear();
        firstNameField.sendKeys(fName);
    }


    // FIX 2: was lastNameField.click() — should be .clear() to remove existing text

    public void setLastName(String lName) {

        lastNameField.clear();

        lastNameField.sendKeys(lName);
    }

    public void setEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setTelephone(String telephone) {
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}