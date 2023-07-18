package com.nopcommerce.pages.electronics;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Utility {
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

    @CacheLookup
    @FindBy(css = "#shippingoption_2")
    WebElement secondDayShippingRadioBtn;

    @CacheLookup
    @FindBy(css = ".button-1.shipping-method-next-step-button")
    WebElement continueBtnShipping;

    @CacheLookup
    @FindBy(css = "#paymentmethod_1")
    WebElement creditCardRadioBtn;

    @CacheLookup
    @FindBy(css = "button[class='button-1 payment-method-next-step-button']")
    WebElement continueBtnPayment;

    @CacheLookup
    @FindBy(xpath = "//select[@id='CreditCardType']")
    WebElement creditCardDropdown;

    @CacheLookup
    @FindBy(xpath = "//input[@id='CardholderName']")
    WebElement cardHolderNameTextField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='CardNumber']")
    WebElement cardNumberTextField;

    @CacheLookup
    @FindBy(xpath = "//select[@id='ExpireMonth']")
    WebElement expireMonth;

    @CacheLookup
    @FindBy(xpath = "//select[@id='ExpireYear']")
    WebElement expireYear;

    @CacheLookup
    @FindBy(xpath = "//input[@id='CardCode']")
    WebElement cardCode;

    @CacheLookup
    @FindBy(css = ".button-1.payment-info-next-step-button")
    WebElement continueBtnPaymentInfo;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Credit Card']")
    WebElement paymentMethodWebEle;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='2nd Day Air']")
    WebElement shippingMethodWebEle;

    @CacheLookup
    @FindBy(css = ".product-subtotal")
    WebElement totalPriceAtCheckout;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement confirmBtn;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Thank you']")
    WebElement thankYouWebEle;

    @CacheLookup
    @FindBy(xpath = "//strong[normalize-space()='Your order has been successfully processed!']")
    WebElement orderNotification;

    @CacheLookup
    @FindBy(css = ".button-1.order-completed-continue-button")
    WebElement continueBtnOrderCompleted;

    @CacheLookup
    @FindBy(css = "div[class='topic-block-title'] h2")
    WebElement welcomeToStoreWebEle;

    @CacheLookup
    @FindBy(css = ".ico-logout")
    WebElement logOutBtn;


    public void selectCountryFromDropdown(String country) {
        selectByVisibleTextFromDropDown(countryDropdown, country);
    }

    public void enterCityName(String city) {
        sendTextToElement(cityTextField, city);
    }

    public void enterAddress(String address) {
        sendTextToElement(addressTextField, address);
    }

    public void enterPostcode(String postCode) {
        sendTextToElement(postCodeTextField, postCode);
    }

    public void enterPhoneNumber(String phoneNumber) {
        sendTextToElement(phoneNumberTextField, phoneNumber);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
    }

    public void clickOnSecondDayShippingRadioButton() {
        clickOnElement(secondDayShippingRadioBtn);
    }

    public void clickOnContinueButtonOnShippingSection() {
        clickOnElement(continueBtnShipping);
    }

    public void clickOnCreditCardRadioButton() {
        clickOnElement(creditCardRadioBtn);
    }

    public void clickOnContinueButtonOnPaymentSection() {
        clickOnElement(continueBtnPayment);
        CustomListeners.test.log(Status.PASS,"click on continue button");
    }

    public void selectCardTypeFromDropdown(String cardType) {
        selectByVisibleTextFromDropDown(creditCardDropdown, cardType);
        CustomListeners.test.log(Status.PASS,"select card type from drop down");
    }

    public void enterCardHolderName(String cardHolderName) {
        sendTextToElement(cardHolderNameTextField, cardHolderName);
        CustomListeners.test.log(Status.PASS,"enter card holder name");
    }

    public void enterCardNumber(String cardNumber) {
        sendTextToElement(cardNumberTextField, cardNumber);
        CustomListeners.test.log(Status.PASS,"enter card number");
    }

    public void selectExpireMonth(String month) {
        selectByVisibleTextFromDropDown(expireMonth, month);
        CustomListeners.test.log(Status.PASS,"select month ");
    }

    public void selectExpireYear(String year) {
        selectByVisibleTextFromDropDown(expireYear, year);
        CustomListeners.test.log(Status.PASS,"select year");
    }

    public void enterCardCode(String code) {
        sendTextToElement(cardCode, code);
        CustomListeners.test.log(Status.PASS,"enter car code ");
    }

    public void clickOnContinueButtonOnPaymentInfoPage() {
        clickOnElement(continueBtnPaymentInfo);
        CustomListeners.test.log(Status.PASS,"click on continue button payment page");
    }

    public String getPaymentMethodTextFromWebElement() {
        return getTextFromElement(paymentMethodWebEle);
    }

    public String getShippingMethodTextFromWebElement() {
        return getTextFromElement(shippingMethodWebEle);
    }

    public String getTotalPriceAtCheckout() {
        return getTextFromElement(totalPriceAtCheckout);
    }

    public void clickOnConfirmButton() {
        clickOnElement(confirmBtn);
        CustomListeners.test.log(Status.PASS,"click on continue button");
    }

    public String getThankYouTextFromWebElement() {
        return getTextFromElement(thankYouWebEle);
    }

    public String getOrderNotification() {
        return getTextFromElement(orderNotification);
    }

    public void clickOnContinueButtonOnOrderCompletion() {
        clickOnElement(continueBtnOrderCompleted);
        CustomListeners.test.log(Status.PASS,"click on continue button order com");
    }

    public String getWelcomeToStoreTextFromWebElement() {
        return getTextFromElement(welcomeToStoreWebEle);
    }

    public void clickOnLogOutButton() {
        clickOnElement(logOutBtn);
        CustomListeners.test.log(Status.PASS,"click on log out");
    }

}
