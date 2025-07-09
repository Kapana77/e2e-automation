package com.softwaretestingboard.magento;

import com.github.javafaker.Faker;
import com.softwaretestingboard.magento.data.Constants;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"[Scenario Name – [SCRUM-T13]"})
@Link("https://tbcacademy-team.atlassian.net/projects/SCRUM?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCase/SCRUM-T13")
public class E2ETestAutomated extends BaseTest {

    Faker faker = new Faker();
    String company = faker.company().name();
    String street = faker.address().streetName();
    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String mail = faker.internet().emailAddress();
    String city = faker.address().cityName();
    String state = faker.address().state();
    String zipCode = faker.address().zipCode().replace("-", " ");
    String country = faker.address().country();
    String number = faker.phoneNumber().phoneNumber();
    private final String pass = faker.internet().password(8, 16) + "aA@1";
    private final String email = faker.internet().emailAddress();


    @Test(priority = 1)
    public void goToHomePage() {
        page.navigate("https://magento.softwaretestingboard.com/");
    }

    @Test(priority = 2)
    public void searchProduct() {
        homepageSteps.searchFor(Constants.SEARCH_VALUE).initiateSearch();
        String offerName = homepageSteps.offerTitle();

        Assert.assertEquals(offerName.trim(), Constants.SEARCH_VALUE.trim());

    }

    @Test(priority = 3)
    public void addProductToCart() {

        homepageSteps.goToFirstProduct();

        individualOfferSteps.chooseSize("M").chooseColor().addToCart();
        homepageSteps.validateCart().validateItemAdded();
    }

    @Test(priority = 4)
    public void goToCheckout() {
        homepageSteps.clickToShowCart().goToCheckout();
    }

    @Test(priority = 5)
    public void fillCheckoutInfo() {

        checkoutSteps.fillEmail(mail).fillFirstName(firstname)
                .fillLastName(lastname).fillCompany(company).fillStreet(street).fillCity(city).selectState(state)
                .fillZip(zipCode).selectCountry(country).fillNumber(number).chooseShipping().goToNext();

        Assert.assertEquals(paymentSteps.getOrderTotal(), paymentSteps.getCartTotal() + paymentSteps.getShippingPrice());


    }

    @Test(priority = 6)
    public void placePrder() {

        paymentSteps.assertName(firstname).assertCity(city).assertStreet(street).assertCountry(country)
                .assertZipCode(zipCode).assertPhoneNumber(number).placeOrder();

        successSteps.validateOrderNumber().validatePageTitle();

    }


}
