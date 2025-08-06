package com.softwaretestingboard.magento.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PaymentPage {
    public Locator total,cartTotal,shipping,infoDetails,discounttoggle,discountInput,applyDiscount,placeOrder,
            discountError;

    public PaymentPage(Page page){
        this.total = page.locator("td[data-th='Order Total'] span.price");
        this.cartTotal = page.locator("td.amount span[data-th='Cart Subtotal']");
        this.shipping = page.locator("td.amount span[data-th='Shipping']");
        this.infoDetails = page.locator("div.billing-address-details");
        this.discounttoggle = page.locator("#block-discount-heading");
        this.discountInput = page.locator("#discount-code");
        this.applyDiscount = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply Discount"));
        this.discountError = page.getByRole(AriaRole.ALERT);
        this.placeOrder = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place Order"));

    }
}
