package com.getir.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import com.getir.utils.TextUtils;


public class FitFormPage extends BasePage {

    @FindBy(xpath = "//span[@data-testid='text' and text()='Granola']")
    private WebElement granolaSubcategory;

    public FitFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);  ///bunu koymasam ne olur

    }

    public void clickGranolaSubcategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(granolaSubcategory));
        Assert.assertNotNull(element, "Granola alt kategorisi tıklanabilir değil!");
        granolaSubcategory.click();
        List<WebElement> productList = driver.findElements(By.cssSelector(".sc-7c0ec1ab-0"));  //Hatalı css selector
        Assert.assertFalse(productList.isEmpty(), "Granola ürünleri listelenemedi!");
    }

    public void checkBasketIsEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement basketMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".sc-8090775b-1")
        ));



        String actualMessage = TextUtils.normalizeText(basketMessage.getText());
        System.out.println("Normalized Text: " + actualMessage);
        System.out.println("Raw Text: " + basketMessage.getText());
        Assert.assertEquals(actualMessage, "Sepetiniz şu an boş", "Sepet mesajı eşleşmiyor!");

    }

    public void listGranolaCardDetails() {

        }

}



