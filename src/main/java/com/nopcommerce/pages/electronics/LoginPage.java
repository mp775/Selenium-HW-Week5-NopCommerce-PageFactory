package com.nopcommerce.pages.electronics;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    RegistrationPage registrationPage = new RegistrationPage();

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement welcomeSignIn;

    @CacheLookup
    @FindBy(css = ".button-1.register-button")
    WebElement registerBtn;

    @CacheLookup
    @FindBy(css = ".ico-login")
    WebElement loginBtnHeader;

    @CacheLookup
    @FindBy(css = "#Email")
    WebElement emailTextField;

    @CacheLookup
    @FindBy(css = "#Password")
    WebElement passwordTextField;

    @CacheLookup
    @FindBy(css = "button[class='button-1 login-button']")
    WebElement loginBtn;

    public String getWelcomeSignInText() {
        String welcome = getTextFromElement(welcomeSignIn);
        CustomListeners.test.log(Status.PASS,"welcome sign in text displayed");
        return welcome;
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerBtn);
        CustomListeners.test.log(Status.PASS,"click on register button");
    }

    public void clickOnLoginLinkButton() {
        clickOnElement(loginBtnHeader);
        CustomListeners.test.log(Status.PASS,"click on login button");
    }

    public void enterEmail() {
        sendTextToElement(emailTextField, registrationPage.email);
        CustomListeners.test.log(Status.PASS,"enter email ");
    }

    public void enterPassword() {
        sendTextToElement(passwordTextField, registrationPage.password);
        CustomListeners.test.log(Status.PASS,"enter password");
    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"click on login button");
    }
}
