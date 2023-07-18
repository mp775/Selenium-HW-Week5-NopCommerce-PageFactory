package com.nopcommerce.testsuite;

import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.pages.homepage.TopMenuPage;
import com.nopcommerce.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    TopMenuPage topMenuPage;

    @BeforeMethod(groups = {"sanity","smoke","regression"})
    public void inIt(){
        topMenuPage = new TopMenuPage();
    }

    @Test(groups = {"sanity"})
    public void verifyPageNavigation() {
        topMenuPage.selectMenu("Computers");
        String expectedPageNavigationText = "Computers";
        String pageNavigateTo = topMenuPage.getPageName("Computers");
        Assert.assertEquals(pageNavigateTo,expectedPageNavigationText,"Page navigation not working");
    }
}
