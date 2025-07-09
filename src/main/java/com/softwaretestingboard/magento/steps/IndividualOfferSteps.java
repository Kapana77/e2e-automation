package com.softwaretestingboard.magento.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.softwaretestingboard.magento.pages.IndividualOfferPage;
import io.qameta.allure.Step;

public class IndividualOfferSteps {
    Page page;
    IndividualOfferPage individualOfferPage;

    public IndividualOfferSteps(Page page){
        this.page = page;
        this.individualOfferPage = new IndividualOfferPage(page);
    }


    @Step("choose item size: {size}")
    public IndividualOfferSteps chooseSize(String size){
        individualOfferPage.sizes.filter(new Locator.FilterOptions().setHasText(size)).first().click();
        return this;

    }

    @Step("choose first color of item")
    public IndividualOfferSteps chooseColor(){
        individualOfferPage.colors.first().click();
        return this;
    }

    @Step("add item to cart")
    public IndividualOfferSteps addToCart(){
        individualOfferPage.addToCartButton.click();
        return this;
    }



}
