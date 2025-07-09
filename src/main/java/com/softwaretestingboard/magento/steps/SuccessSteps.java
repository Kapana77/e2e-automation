package com.softwaretestingboard.magento.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.softwaretestingboard.magento.pages.SuccessPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class SuccessSteps {
    Page page;
    SuccessPage successPage;


    public SuccessSteps(Page page){
        this.page = page;
        this.successPage = new SuccessPage(page);
    }

    @Step("validate that order number shows")
    public SuccessSteps validateOrderNumber(){

        Assert.assertTrue(successPage.orderNum.textContent().matches("\\d+"));
        return this;

    }


    @Step("validate that page title text is : Success Page")
    public SuccessSteps validatePageTitle(){

        PlaywrightAssertions.assertThat(page).hasTitle("Success Page");
        return this;

    }
}
