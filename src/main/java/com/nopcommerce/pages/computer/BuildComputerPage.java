package com.nopcommerce.pages.computer;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BuildComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement buildOnYourComputer;
    @CacheLookup
    @FindBy(id = "product_attribute_1")
    WebElement processor;
    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement ram;
    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    WebElement hdd;
    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_4_9']")
    WebElement os;
    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_5_12']")
    WebElement software;
    @CacheLookup
    @FindBy(css = "#price-value-1")
    WebElement price;
    @CacheLookup
    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement prodAddMessage;
    @CacheLookup
    @FindBy(xpath = "//span[@title='Close']")
    WebElement close;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement shoppingCart1;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement goToCart;

    public String getBuildOnYourComputerText() {
        return getTextFromElement(buildOnYourComputer);
    }

    public void selectProcessorOption(String processorName) {
        selectByVisibleTextFromDropDown(processor, processorName);
    }

    public void selectRAMOption(String ramOption) {
        selectByVisibleTextFromDropDown(ram, ramOption);

    }

    public void selectHDDOption() {
        clickOnElement(hdd);
        CustomListeners.test.log(Status.PASS,"click on HDD option");
    }

    public void selectOSOption() {
        clickOnElement(os);
        CustomListeners.test.log(Status.PASS,"click on OS option");
    }

    public void selectSoftwareOption() {
        clickOnElement(software);
        CustomListeners.test.log(Status.PASS,"select Software option");
    }

    public String getPrice() {
        return getTextFromElement(price);

    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS,"click on add to cart");
    }

    public String getMessageProductHasBeenAddedToYourShoppingCart() {
        return getTextFromElement(prodAddMessage);

    }

    public void setClose() {
        clickOnElement(close);
        CustomListeners.test.log(Status.PASS,"click on set close option");
    }

    public void mouseHoverOnShoppingCartAndClick() {
        mouseHoverToElement(shoppingCart1);
        scrollDown(driver, goToCart);
        clickOnElement(goToCart);
        CustomListeners.test.log(Status.PASS,"click on Goto cart ");
    }
}



