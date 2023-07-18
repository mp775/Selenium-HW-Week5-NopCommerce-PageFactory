package com.nopcommerce.testsuite;

import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.pages.electronics.*;
import com.nopcommerce.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class ElectronicsTest extends BaseTest {
    CellPhonesPage cellPhonesPage;
    ShoppingCartPage shoppingCartPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    @BeforeMethod(groups = {"sanity","smoke","regression"})
    public void inIt(){
        cellPhonesPage = new CellPhonesPage();
        shoppingCartPage = new ShoppingCartPage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        checkoutPage = new CheckoutPage();
        homePage = new HomePage();
    }

    @Test(groups = {"smoke"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        cellPhonesPage.mouseHoverOnElectronicsTab();
        cellPhonesPage.mouseHoverAndClickOnCellPhonesTab();
        String expectedProductCategoryText = "Cell phones";
        String actualProductCategoryText = cellPhonesPage.getCellPhonesText();
        Assert.assertEquals(actualProductCategoryText, expectedProductCategoryText, "Cell phones text is not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        cellPhonesPage.mouseHoverOnElectronicsTab();
        cellPhonesPage.mouseHoverAndClickOnCellPhonesTab();
        String expectedProductCategoryText = "Cell phones";
        String actualProductCategoryText = cellPhonesPage.getCellPhonesText();
        Assert.assertEquals(actualProductCategoryText, expectedProductCategoryText, "Cell phones text is not displayed");
        cellPhonesPage.clickOnListViewTab();
        Thread.sleep(1000);
        cellPhonesPage.clickOnSpecificProduct();
        String expectedProductName = "Nokia Lumia 1020";
        String actualProductName = cellPhonesPage.getProductName();
        Assert.assertEquals(actualProductName, expectedProductName, "Product name is not displayed");
        String actualProductPrice = cellPhonesPage.getProductPrice();
        Assert.assertEquals(actualProductPrice, "$349.00", "Product price displayed incorrectly");
        cellPhonesPage.changeQuantity("2");
        cellPhonesPage.clickOnAddToCartButton();
        String expectedProductAddedNotificationMsg = "The product has been added to your shopping cart";
        String actualProductAddedNotificationMsg = cellPhonesPage.getProductAddedNotification();
        Assert.assertEquals(actualProductAddedNotificationMsg, expectedProductAddedNotificationMsg, "Product added message not displayed correctly");
        cellPhonesPage.clickOnCloseButton();
        shoppingCartPage.moveToShoppingCart();
        shoppingCartPage.moveToGoToCartAndClick();
        String expectedCartTitle = "Shopping cart";
        refreshPage();
        String actualCartTitle = shoppingCartPage.getShoppingCartTextFromElement();
        Assert.assertEquals(actualCartTitle, expectedCartTitle, "Cart title is not displayed correctly");
        String actualQuantityInCart = shoppingCartPage.getQuantityInCartWebElementText();
        Assert.assertEquals(actualQuantityInCart, "2", "Quantity displayed incorrectly in the Cart");
        String actualProductSubtotalInCart = shoppingCartPage.getProductSubtotalInCartWebElementText();
        Assert.assertEquals(actualProductSubtotalInCart, "$698.00", "Product Subtotal displayed incorrectly");
        shoppingCartPage.clickOnTermsOfServiceCheckBox();
        shoppingCartPage.clickOnCheckoutButton();
        String expectedWelcomeMsg = "Welcome, Please Sign In!";
        String actualWelcomeMsg = loginPage.getWelcomeSignInText();
        Assert.assertEquals(actualWelcomeMsg, expectedWelcomeMsg, "Welcome Sign In message not displayed correctly");
        loginPage.clickOnRegisterButton();
        String actualRegisterText = registrationPage.getRegisterTextFromWebElement();
        Assert.assertEquals(actualRegisterText, "Register", "Register text is not displayed");
        registrationPage.fillRegistrationForm();
        registrationPage.clickOnRegisterButton();
        String expectedRegCompletedMsg = "Your registration completed";
        String actualRegCompletedMsg = registrationPage.getRegistrationCompletedWebEleText();
        Assert.assertEquals(actualRegCompletedMsg, expectedRegCompletedMsg, "Register Completed message is not displayed");
        registrationPage.clickOnContinueButton();
        loginPage.clickOnLoginLinkButton();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickOnLoginButton();
        shoppingCartPage.clickOnTermsOfServiceCheckBox();
        shoppingCartPage.clickOnCheckoutButton();
        checkoutPage.selectCountryFromDropdown("United Kingdom");
        checkoutPage.enterCityName("London");
        checkoutPage.enterAddress("101 Repton Street");
        checkoutPage.enterPostcode("BR5 1AB");
        checkoutPage.enterPhoneNumber("07122234554");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnSecondDayShippingRadioButton();
        checkoutPage.clickOnContinueButtonOnShippingSection();
        checkoutPage.clickOnCreditCardRadioButton();
        checkoutPage.clickOnContinueButtonOnPaymentSection();
        checkoutPage.selectCardTypeFromDropdown("Visa");
        checkoutPage.enterCardHolderName("Raj Patel");
        checkoutPage.enterCardNumber("4111 1111 1111 1111");
        checkoutPage.selectExpireMonth("09");
        checkoutPage.selectExpireYear("2025");
        checkoutPage.enterCardCode("123");
        checkoutPage.clickOnContinueButtonOnPaymentInfoPage();
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = checkoutPage.getPaymentMethodTextFromWebElement();
        Assert.assertEquals(actualPaymentMethod, expectedPaymentMethod, "Payment option text is incorrect");
        String expectedShippingMethod = "2nd Day Air";
        String actualShippingMethod = checkoutPage.getShippingMethodTextFromWebElement();
        Assert.assertEquals(actualShippingMethod, expectedShippingMethod, "Shipping option text is incorrect");
        String actualTotalPriceAtCheckout = checkoutPage.getTotalPriceAtCheckout();
        Assert.assertEquals(actualTotalPriceAtCheckout, "$698.00", "Total Price at Checkout displayed incorrectly");
        checkoutPage.clickOnConfirmButton();
        String actualThankYouMessage = checkoutPage.getThankYouTextFromWebElement();
        Assert.assertEquals(actualThankYouMessage, "Thank you", "Thank you text is not displayed");
        String expectedOrderNotification = "Your order has been successfully processed!";
        String actualOrderNotification = checkoutPage.getOrderNotification();
        Assert.assertEquals(actualOrderNotification, expectedOrderNotification, "Order notification is not displayed");
        checkoutPage.clickOnContinueButtonOnOrderCompletion();
        String expectedWelcomeToStoreNotification = "Welcome to our store";
        String actualWelcomeToStoreNotification = checkoutPage.getWelcomeToStoreTextFromWebElement();
        Assert.assertEquals(actualWelcomeToStoreNotification, expectedWelcomeToStoreNotification, "Welcome to Our Store notification is not displayed");
        checkoutPage.clickOnLogOutButton();
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = homePage.getUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Wrong URL displayed");
    }
}
