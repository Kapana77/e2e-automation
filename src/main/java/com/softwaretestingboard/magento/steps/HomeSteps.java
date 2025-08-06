package com.softwaretestingboard.magento.steps;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.softwaretestingboard.magento.pages.HomePage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class HomeSteps {

    Page page;
    HomePage homePage;


    public HomeSteps(Page page) {
        this.page = page;
        homePage = new HomePage(page);
    }


    @Step("Search for {value}")
    public HomeSteps searchFor(String value){
        homePage.search.fill(value);
        return this;
    }


    @Step("start searching")
    public HomeSteps initiateSearch(){
        page.keyboard().press("Enter");
        return this;
    }

    @Step("get offer title")
    public String offerTitle(){
        return homePage.nameLocator.textContent().trim();
    }

    @Step("hover over first offer on page")
    public HomeSteps hoverOverFirstOffer(){
        homePage.firstoffer.hover();
        return this;
    }


    @Step("add product to cart")
    public HomeSteps addTocart(){
        homePage.addtoCartButton.click();
        return this;
    }


    @Step("get offer price")
    public String offerPrice(){
        return homePage.priceLocator.textContent().trim();
    }

    @Step("validate succes message of cart added")
    public HomeSteps validateCart(){
        PlaywrightAssertions.assertThat(homePage.succesMessage).isVisible();
        return this;
    }
    @Step("validate that one item has added to cart")
    public HomeSteps validateItemAdded(){
        PlaywrightAssertions.assertThat(homePage.showCartIcon).hasText("1");
        return this;
    }

    @Step("go to first product")
    public HomeSteps goToFirstProduct(){
        homePage.firstoffer.click();
        return this;
    }

    @Step("click show cart")
    public HomeSteps clickToShowCart(){
        homePage.showCart.click();
        return this;
    }

    @Step("go to checkout page")
    public HomeSteps goToCheckout(){
        homePage.checkoutButton.click();
        return this;
    }




}
