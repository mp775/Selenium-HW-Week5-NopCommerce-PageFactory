package com.nopcommerce.pages.computer;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerDesktopPage extends Utility {
    ArrayList<String> beforeFilterProductNameList = new ArrayList<>();
    ArrayList<String> afterFilterProductNameList = new ArrayList<>();

    //@CacheLookup
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[1]/a[1]")
    WebElement computerTab;

    @CacheLookup
    @FindBy(css = "h2[class='title'] a[title='Show products in category Desktops']")
    WebElement desktopTab;

    @CacheLookup
    @FindBy(id = "products-orderby")
    WebElement positionZtoA;

    @CacheLookup
    @FindBy(xpath = "//div[@class='buttons']/button")
    WebElement addToCartText;

    @CacheLookup
    @FindBy(id = "products-orderby")
    WebElement positionAtoZ;

    public void clickOnComputerTab() {
        clickOnElement(computerTab);
    }

    public void clickOnDesktopTab() {
        clickOnElement(desktopTab);
    }

    public ArrayList<String> desktopProductListBeforeFilter() {
        List<WebElement> beforeFilterProductName = driver.findElements(By.xpath("//h2[@class='product-title']"));
        for (WebElement products : beforeFilterProductName) {
            beforeFilterProductNameList.add(String.valueOf(products.getText()));
        }
        System.out.println("Product List before filter apply : " + beforeFilterProductNameList);
        Collections.reverse(beforeFilterProductNameList);
        System.out.println("Sort Array List in reverse Alphabetic Order : " + beforeFilterProductNameList);
        return beforeFilterProductNameList;
    }

    public ArrayList<String> desktopProductListAfterFilter() {
        List<WebElement> afterFilterProductName = driver.findElements(By.xpath("//h2[@class='product-title']"));
        for (WebElement products : afterFilterProductName) {
            afterFilterProductNameList.add(String.valueOf(products.getText()));
        }
        System.out.println("Product List after applying filter : " + afterFilterProductNameList);
        return afterFilterProductNameList;
    }

    public void selectShortByPositionAtoZ(String position) {
        selectByVisibleTextFromDropDown(positionZtoA, position);
        CustomListeners.test.log(Status.PASS,"select short by position");

    }

    public void selectShortByPositionZtoA(String position) {
        selectByVisibleTextFromDropDown(positionAtoZ, position);
        CustomListeners.test.log(Status.PASS,"select short by position Ato Z");
    }


    public void addToCart() {

        clickOnElement(addToCartText);
        CustomListeners.test.log(Status.PASS,"click on add to cart");
    }


}

