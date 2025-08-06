package com.softwaretestingboard.magento.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    public Locator allProducts, search, startSearchButton, firstoffer, addtoCartButton, nameLocator, priceLocator,
            succesMessage, showCartIcon, showCart, viewCart, outOfStockOffer, navToggleButton, accountButton, menuButton, checkoutButton;

    public HomePage(Page page) {
        this.allProducts = page.locator(".product-items .product-item-info");
        this.search = page.locator("#search");
        this.startSearchButton = page.locator("//button[@title='Search']");
        this.firstoffer = allProducts.first();
        this.addtoCartButton = firstoffer.locator("div").locator(".product-item-inner")
                .locator("button");
        this.nameLocator = firstoffer.locator("div").locator("strong a");
        this.priceLocator = firstoffer.locator("span.price");
        this.succesMessage = page.locator("//div[@class='message-success success message']");
        this.showCartIcon = page.locator("//a[@class='action showcart']").locator("span.counter-number");
        this.showCart = page.locator("//a[@class='action showcart']");
        this.viewCart = page.locator("//a[@class='action viewcart']");
        this.outOfStockOffer = allProducts.nth(3);
        this.navToggleButton = page.locator("//span[@data-action='toggle-nav']");
        this.accountButton = page.locator("//a[@href='#store.links']");
        this.menuButton = page.locator("//a[@href='#store.menu']");

        this.checkoutButton = page.locator("#top-cart-btn-checkout");
    }

}
