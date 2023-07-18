package com.nopcommerce.pages.electronics;

import com.nopcommerce.utilities.Utility;

public class HomePage extends Utility {
    public String  getUrl(){
        return driver.getCurrentUrl();
    }
}
