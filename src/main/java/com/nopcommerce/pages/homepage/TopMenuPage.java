package com.nopcommerce.pages.homepage;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class TopMenuPage extends Utility {
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='" + menu + "']"));
    }

    public String getPageName(String menu){
        return driver.findElement(By.xpath("//h1[normalize-space()='"+menu+"']")).getText();
    }
}


