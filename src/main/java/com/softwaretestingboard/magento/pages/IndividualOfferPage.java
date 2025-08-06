package com.softwaretestingboard.magento.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class IndividualOfferPage {
    public Locator sizes,colors,addToCartButton,errorMessage,reviews,reviewsNav,reviewsFromPage,colorButton,
            addToWishlistButton,loginError,createAccountButton;


    public IndividualOfferPage(Page page){
        this.sizes =  page.locator("//div[@class='swatch-attribute size']").getByRole(AriaRole.LISTBOX)
                .getByRole(AriaRole.OPTION);
        this.colors = page.locator("//div[@class='swatch-attribute color']").getByRole(AriaRole.LISTBOX)
                .getByRole(AriaRole.OPTION);
        this.addToCartButton = page.getByTitle("Add to Cart");
        this.errorMessage = page.locator("//div[@class='message-error error message']");
        this.reviews = page.locator("//span[@itemprop='reviewCount']");
        this.reviewsNav = page.locator("#tab-label-reviews-title");
        this.reviewsFromPage = page.locator("#product-review-container").locator("ol")
                .locator("li");
        this.colorButton = page.locator("//div[@class='swatch-attribute color']");
        this.addToWishlistButton =  page.locator("//a[@data-action='add-to-wishlist']");
        this.loginError = page.locator("//div[@class='message-error error message']");
        this.createAccountButton = page.locator("//a[@class='action create primary']");


    }
}
