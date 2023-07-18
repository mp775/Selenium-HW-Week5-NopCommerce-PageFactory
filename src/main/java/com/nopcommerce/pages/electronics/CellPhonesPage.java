package com.nopcommerce.pages.electronics;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CellPhonesPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[2]/a[1]")
    WebElement electronicsTab;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")
    WebElement cellPhonesTab;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Cell phones']")
    WebElement cellPhoneProductCategory;

    @CacheLookup
    @FindBy(css = "a[title='List']")
    WebElement listViewTab;

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]")
    WebElement specificProduct;

    @CacheLookup
    @FindBy(css = "div[class='product-name'] h1")
    WebElement productName;

    @CacheLookup
    @FindBy(css = "#price-value-20")
    WebElement price;

    @CacheLookup
    @FindBy(xpath = "//input[@id='product_enteredQuantity_20']")
    WebElement quantity;

    @CacheLookup
    @FindBy(css = "#add-to-cart-button-20")
    WebElement addToCartBtn;

    @CacheLookup
    @FindBy(css = ".content")
    WebElement productAddedNotification;

    @CacheLookup
    @FindBy(css = "span[title='Close']")
    WebElement closeBtn;


    public void mouseHoverOnElectronicsTab() {
        mouseHoverToElement(electronicsTab);
    }

    public void mouseHoverAndClickOnCellPhonesTab() {
        mouseHoverToElementAndClick(cellPhonesTab);
    }

    public String getCellPhonesText() {
        return getTextFromElement(cellPhoneProductCategory);
    }

    public void clickOnListViewTab() {
        waitUntilVisibilityOfElementLocated(listViewTab, 30);
        clickOnElement(listViewTab);
    }

    public void clickOnSpecificProduct() {
        for (int retry = 0; retry < 3; retry++) {
            try {
                clickOnElement(specificProduct);
            } catch (StaleElementReferenceException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public String getProductName() {
        return getTextFromElement(productName);
    }

    public String getProductPrice() {
        return getTextFromElement(price);
    }

    public void changeQuantity(String quantityNumber) {
        waitUntilVisibilityOfElementLocated(quantity, 30);
        clearTextFromField(quantity);
        sendTextToElement(quantity, quantityNumber);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartBtn);
        CustomListeners.test.log(Status.PASS,"click on add to cart");
    }

    public String getProductAddedNotification() {
        return getTextFromElement(productAddedNotification);
    }

    public void clickOnCloseButton() {
        clickOnElement(closeBtn);
        CustomListeners.test.log(Status.PASS,"click on close button");
    }
}
