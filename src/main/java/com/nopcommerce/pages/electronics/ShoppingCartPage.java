package com.nopcommerce.pages.electronics;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[@class='cart-label']")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Go to cart']")
    WebElement goToCart;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Shopping cart']")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//input[starts-with(@id,'itemquantity')]")
    WebElement quantityInCart;

    @CacheLookup
    @FindBy(css = ".product-subtotal")
    WebElement productSubtotalInCart;

    @CacheLookup
    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement termsOfService;

    @CacheLookup
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutBtn;

    public void moveToShoppingCart() {
        mouseHoverToElement(shoppingCart);
    }

    public void moveToGoToCartAndClick() {
        scrollDown(driver, goToCart);
        clickOnElement(goToCart);
        CustomListeners.test.log(Status.PASS,"click on go to cart text");
    }

    public String getShoppingCartTextFromElement() {
        String shoppingCart = getTextFromElement(shoppingCartText);
        CustomListeners.test.log(Status.PASS,"visible shopping cart text");
        return shoppingCart;
    }

    public String getQuantityInCartWebElementText() {
        waitUntilVisibilityOfElementLocated(quantityInCart, 30);
        scrollDown(driver,quantityInCart);
        return getTextFromElement(quantityInCart);
    }

    public String getProductSubtotalInCartWebElementText() {
        return getTextFromElement(productSubtotalInCart);
    }

    public void clickOnTermsOfServiceCheckBox() {
        clickOnElement(termsOfService);
        CustomListeners.test.log(Status.PASS,"click on  terms of checkbox");
    }

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutBtn);
        CustomListeners.test.log(Status.PASS,"click on check box");
    }

}
