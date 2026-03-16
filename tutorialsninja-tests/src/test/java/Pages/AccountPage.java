package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    private WebElement myAccountConfirmation;

    @FindBy(xpath = "//i[@class='fa fa-user']")
    private WebElement myAccountDropDown;

    @FindBy(linkText = "Logout")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement continueButton;

    @FindBy(linkText = "Edit Account")
    private WebElement editAccount;

    @FindBy(linkText = "Password")
    private WebElement editPassword;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement accountUpdateConfirmation;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement accountUpdatedFail;

    public boolean accountConfirmation(){
        return myAccountConfirmation.isDisplayed();
    }
    public void clickOnAccountDropdown(){
        myAccountDropDown.click();
    }

    public void clickOnLogout(){
        logoutButton.click();
    }

    public void clickOnContinue(){
        continueButton.click();
    }

    public void clickOnEditAccount(){
        editAccount.click();
    }
    public void clickOnPassword(){
        editPassword.click();
    }

    public boolean isAccountUpdateMessageDisplayed(){
        return accountUpdateConfirmation.isDisplayed();
    }

    public boolean isAccountFailedMessageDisplayed(){
        return accountUpdatedFail.isDisplayed();
    }
}

