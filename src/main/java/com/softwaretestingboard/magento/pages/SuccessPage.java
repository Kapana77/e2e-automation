package com.softwaretestingboard.magento.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SuccessPage {

    public Locator orderNum;

    public SuccessPage(Page page){
        this.orderNum = page.locator("//p/span").first();
    }
}
