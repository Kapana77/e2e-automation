package com.softwaretestingboard.magento.steps;

import com.microsoft.playwright.Page;
import com.softwaretestingboard.magento.pages.CheckoutPage;
import io.qameta.allure.Step;

public class CheckoutSteps {
    Page page;
    CheckoutPage checkoutPage;


    public CheckoutSteps(Page page){
        this.page = page;
        this.checkoutPage = new CheckoutPage(page);

    }


    @Step("fill company: {company}")
    public CheckoutSteps fillCompany(String company){
        checkoutPage.company.fill(company);
        return this;
    }

    public CheckoutSteps fillEmail(String mail){
        checkoutPage.mail.fill(mail);
        return this;

    }

    public CheckoutSteps fillFirstName(String firstName){
        checkoutPage.firstname.fill(firstName);
        return this;

    }

    public CheckoutSteps fillLastName(String lastname){
        checkoutPage.lastname.fill(lastname);
        return this;

    }

    @Step("fill street: {street}")
    public CheckoutSteps fillStreet(String street){
        checkoutPage.street.fill(street);
        return this;
    }

    @Step("fill city: {city}")
    public CheckoutSteps fillCity(String city){
        checkoutPage.city.fill(city);
        return this;
    }

    @Step("select state: {state}")
    public CheckoutSteps selectState(String state){
        checkoutPage.state.selectOption(state);
        return this;
    }

    @Step("fill postal code: {code}")
    public CheckoutSteps fillZip(String code){
        checkoutPage.postalcode.fill(code);
        return this;
    }

    @Step("select country: {country}")
    public CheckoutSteps selectCountry(String country){
        checkoutPage.country.selectOption(country);
        return this;
    }

    @Step("fill phone number: {number}")
    public CheckoutSteps fillNumber(String number){
        checkoutPage.phone.fill(number);
        return this;
    }

    @Step("click next button")
    public CheckoutSteps goToNext(){
        checkoutPage.nextButton.click();
        return this;
    }

    @Step("choose shipping option")
    public CheckoutSteps chooseShipping(){
        checkoutPage.shippingOpt.click();
        return this;
    }
}
