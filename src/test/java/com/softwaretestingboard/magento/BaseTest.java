package com.softwaretestingboard.magento;

import com.microsoft.playwright.*;
import com.softwaretestingboard.magento.steps.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;
    protected HomeSteps homepageSteps;
//    protected CartSteps cartSteps;
    protected IndividualOfferSteps individualOfferSteps;
//    protected RegisterSteps registerSteps;
//    protected WishListSteps wishListSteps;
//    protected LoginSteps loginSteps;
    protected CheckoutSteps checkoutSteps;
    protected PaymentSteps paymentSteps;
    protected SuccessSteps successSteps;

    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
//        launchOptions.setSlowMo(2000);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext();
        page = browserContext.newPage();
        homepageSteps = new HomeSteps(page);
//        cartSteps = new CartSteps(page);
        individualOfferSteps = new IndividualOfferSteps(page);
//        registerSteps = new RegisterSteps(page);
//        wishListSteps = new WishListSteps(page);
//        loginSteps = new LoginSteps(page);
        checkoutSteps = new CheckoutSteps(page);
        paymentSteps = new PaymentSteps(page);
        successSteps = new SuccessSteps(page);
    }

    @AfterClass
    public void tearDown(){
        browserContext.close();
        browser.close();
        playwright.close();
    }

}
