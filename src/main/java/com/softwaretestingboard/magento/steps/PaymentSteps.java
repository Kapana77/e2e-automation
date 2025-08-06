package com.softwaretestingboard.magento.steps;

import com.microsoft.playwright.Page;
import com.softwaretestingboard.magento.pages.PaymentPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class PaymentSteps {
    Page page;
    PaymentPage paymentPage;

    public PaymentSteps(Page page){
        this.page = page;
        this.paymentPage = new PaymentPage(page);
    }

    @Step("get total value of order")
    public double getOrderTotal(){
        return Double.parseDouble(paymentPage.total.textContent().replace("$",""));
    }

    public double getCartTotal(){
        return Double.parseDouble(paymentPage.cartTotal.textContent().replace("$",""));
    }
    @Step("get shipping price")
    public double getShippingPrice(){
        return Double.parseDouble(paymentPage.shipping.textContent().replace("$",""));
    }

    @Step("validate that info contains name: {name}")
    public PaymentSteps assertName(String name) {
        Assert.assertTrue(paymentPage.infoDetails.textContent().contains(name));
        return this;
    }


    @Step("validate that info contains street: {street}")
    public PaymentSteps assertStreet(String street) {
        Assert.assertTrue(paymentPage.infoDetails.textContent().contains(street));
        return this;
    }

    @Step("validate that info contains city: {city}")
    public PaymentSteps assertCity(String city) {
        Assert.assertTrue(paymentPage.infoDetails.textContent().contains(city));
        return this;
    }

    @Step("validate that info contains zip code: {zipCode}")
    public PaymentSteps assertZipCode(String zipCode) {
        Assert.assertTrue(paymentPage.infoDetails.textContent().contains(zipCode));
        return this;
    }

    @Step("validate that info contains country: {country}")
    public PaymentSteps assertCountry(String country) {
        Assert.assertTrue(paymentPage.infoDetails.textContent().contains(country));
        return this;
    }

    @Step("validate that info contains phone number: {number}")
    public PaymentSteps assertPhoneNumber(String number) {
        Assert.assertTrue(paymentPage.infoDetails.textContent().contains(number));
        return this;
    }

    @Step("place order")
    public PaymentSteps placeOrder(){
        paymentPage.placeOrder.click();
        return this;
    }

}
