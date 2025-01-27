package com.getir.tests;

import com.getir.pages.FitFormPage;
import com.getir.pages.HomePage;
import org.testng.annotations.Test;



public class CompareGranolaPriceTest extends BaseTest {

    @Test
    public void testGranolaProductWorkflow() {
        // 1. FitForm kategorisine git
        HomePage homePage = new HomePage(driver);
        FitFormPage fitFormPage = new FitFormPage(driver);

        homePage.clickFitFormCategory();
        fitFormPage.clickGranolaSubcategory();
        fitFormPage.checkBasketIsEmpty();
        fitFormPage.listGranolaCardDetails();

    }
}