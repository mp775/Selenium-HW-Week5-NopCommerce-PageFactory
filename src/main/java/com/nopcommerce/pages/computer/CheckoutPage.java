package com.nopcommerce.pages.computer;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Shopping cart']")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//td[@class='quantity']/input")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//button[@id='updatecart']")
    WebElement update;

    @CacheLookup
    @FindBy(xpath = "//span[@class='product-subtotal']")
    WebElement totalPrice;

    @CacheLookup
    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement checkBoxAgree;

    @CacheLookup
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkOut;

    @CacheLookup
    @FindBy(css = "#shippingoption_1")
    WebElement shippingNexDayRadioBtn;

    @CacheLookup
    @FindBy(css = ".button-1.shipping-method-next-step-button")
    WebElement continueBtnShippingMethod;

    @CacheLookup
    @FindBy(css = "#paymentmethod_1")
    WebElement creditCardRatioBtn;

    @CacheLookup
    @FindBy(css = "button[class='button-1 payment-method-next-step-button']")
    WebElement continueBtnCreditCardMethod;

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
    @FindBy(xpath = "//span[normalize-space()='Next Day Air']")
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


    public String getMessageShoppingCart() {
        return getTextFromElement(shoppingCartText);

    }

    public void changeQtyNumber(String quantityNumber) {
        clearTextFromField(quantity);
        sendTextToElement(quantity, quantityNumber);
    }

    public void clickOnUpdateShoppingCart() {
        clickOnElement(update);
    }

    public String getTotalPrice() {
        return getTextFromElement(totalPrice);
    }

    public void clickOnCheckout() {
        clickOnElement(checkOut);
        CustomListeners.test.log(Status.PASS,"click on check out");
    }

    public void clickOnTermsOfServiceCheckBox() {
        clickOnElement(checkBoxAgree);
        CustomListeners.test.log(Status.PASS,"click on check box agree");
    }

    public void clickOnShippingNextDayRadioButton() {
        clickOnElement(shippingNexDayRadioBtn);
        CustomListeners.test.log(Status.PASS,"shipping next day radio button");
    }

    public void clickOnContinueButtonShippingSection() {
        clickOnElement(continueBtnShippingMethod);
        CustomListeners.test.log(Status.PASS,"click on continue button");

    }

    public void clickOnCreditCardRadioButton() {
        clickOnElement(creditCardRatioBtn);
        CustomListeners.test.log(Status.PASS,"click on credit card button");
    }

    public void clickOnContinueButtonCreditCardSection() {
        clickOnElement(continueBtnCreditCardMethod);
        CustomListeners.test.log(Status.PASS,"click credit card section");
    }

    public void selectCardTypeFromDropdown(String cardType) {
        selectByVisibleTextFromDropDown(creditCardDropdown, cardType);
        CustomListeners.test.log(Status.PASS,"select card type from dropdown");
    }

    public void enterCardHolderName(String name) {
        sendTextToElement(cardHolderNameTextField, name);
    }

    public void enterCardNumber(String cardNumber) {
        sendTextToElement(cardNumberTextField, cardNumber);
    }

    public void selectExpireMonth(String month) {
        selectByVisibleTextFromDropDown(expireMonth, month);
        CustomListeners.test.log(Status.PASS,"Select expire month");
    }

    public void selectExpireYear(String year) {
        selectByVisibleTextFromDropDown(expireYear, year);
        CustomListeners.test.log(Status.PASS,"select expire year");
    }

    public void enterCardCode(String code) {
        sendTextToElement(cardCode, code);
    }

    public void clickOnContinueButtonOnPaymentInfoPage() {
        clickOnElement(continueBtnPaymentInfo);
        CustomListeners.test.log(Status.PASS,"click on continue button on payment page");
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
        CustomListeners.test.log(Status.PASS,"click on continue button order completed");
    }

    public String getWelcomeToStoreTextFromWebElement() {
        return getTextFromElement(welcomeToStoreWebEle);
    }
}
