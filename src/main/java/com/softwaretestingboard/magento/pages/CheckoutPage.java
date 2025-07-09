package com.softwaretestingboard.magento.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckoutPage {
    public Locator company,street,city,state,postalcode,country,phone,nextButton,shippingOpt,mail,firstname,lastname;


    public CheckoutPage(Page page){
        this.company = page.locator("//input[@name='company']");
        this.street = page.locator("//input[@name='street[0]']");
        this.city = page.locator("//input[@name='city']");
        this.state = page.locator("//select[@name='region_id']");
        this.firstname = page.locator("//input[@name='firstname']");
        this.lastname = page.locator("//input[@name='lastname']");
        this.mail = page.locator("//fieldset[@id='customer-email-fieldset']//input[@id='customer-email']").first();
        this.postalcode = page.locator("//input[@name='postcode']");
        this.country = page.locator("//select[@name='country_id']");
        this.phone = page.locator("//input[@name='telephone']");
        this.nextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next"));
        this.shippingOpt = page.locator("input[type='radio'][value='flatrate_flatrate']");


    }
}
