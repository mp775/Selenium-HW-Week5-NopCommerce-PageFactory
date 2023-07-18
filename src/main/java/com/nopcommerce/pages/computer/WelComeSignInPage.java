package com.nopcommerce.pages.computer;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class WelComeSignInPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement welcomeSignIn;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Checkout as Guest']")
    WebElement checkoutGuestBtn;

    @CacheLookup
    @FindBy(css = "#BillingNewAddress_FirstName")
    WebElement firstNameWebEle;

    @CacheLookup
    @FindBy(css = "#BillingNewAddress_LastName")
    WebElement lastNameWebEle;

    @CacheLookup
    @FindBy(css = "#BillingNewAddress_Email")
    WebElement emailWebEle;

    @CacheLookup
    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    WebElement countryDropdown;

    @CacheLookup
    @FindBy(xpath = "//input[@id='BillingNewAddress_City']")
    WebElement cityTextField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
    WebElement addressTextField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
    WebElement postCodeTextField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
    WebElement phoneNumberTextField;

    @CacheLookup
    @FindBy(xpath = "//button[@onclick='Billing.save()']")
    WebElement continueBtn;

    String firstName;
    String lastName;
    String email;

    public String getWelcomeSignInText() {
        return getTextFromElement(welcomeSignIn);
    }

    public void clickOnCheckOutAsGuestButton() {
        clickOnElement(checkoutGuestBtn);
    }

    public String getFirstName() {
        firstName = getRandomString(4);
        return firstName;
    }

    public String getLastName() {
        lastName = getRandomString(8);
        return lastName;
    }

    public String getEmail() {
        email = getRandomString(8) + "@gmail.com";
        return email;
    }

    public void selectCountryFromDropdown(String country) {
        selectByVisibleTextFromDropDown(countryDropdown, country);
        CustomListeners.test.log(Status.PASS,"select country");
    }

    public void enterCityName(String city) {
        sendTextToElement(cityTextField, city);
        CustomListeners.test.log(Status.PASS,"Enter city name" +city);
    }

    public void enterAddress(String address) {
        sendTextToElement(addressTextField, address);
        CustomListeners.test.log(Status.PASS,"enter address" + address);
    }

    public void enterPostcode(String postCode) {
        sendTextToElement(postCodeTextField, postCode);
        CustomListeners.test.log(Status.PASS,"enter post code" +postCode);
    }

    public void enterPhoneNumber(String phoneNumber) {
        sendTextToElement(phoneNumberTextField, phoneNumber);
        CustomListeners.test.log(Status.PASS,"click on continue button"+ phoneNumber);
    }

    public void enterFirstName(){
        sendTextToElement(firstNameWebEle, getFirstName());

    }

    public void enterLastName(){
        sendTextToElement(lastNameWebEle, getLastName());
    }

    public void enterEmail(){
        sendTextToElement(emailWebEle, getEmail());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"click on continue button");
    }
}