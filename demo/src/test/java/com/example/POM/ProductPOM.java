package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPOM {
    WebDriver driver;
    By product_name = By.className("product-name");
    By name_receiver = By.id("giftcard_2_RecipientName");
    By email_receiver = By.id("giftcard_2_RecipientEmail");
    By btn_addtocart = By.id("add-to-cart-button-2");
    By success = By.className("content");
    By cart = By.cssSelector("a[href$='/cart']");

    public ProductPOM(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean getProductname() {
        return driver.findElement(product_name).isDisplayed();
    }

    public void SaisirNameReceiver(String NR) {
        driver.findElement(name_receiver).sendKeys(NR);
    }

    public void SaisirEmailReceiver(String ER) {
        driver.findElement(email_receiver).sendKeys(ER);
    }

    public void ClickCart() {
        driver.findElement(cart).click();
    }

    public Boolean getSuccess() {
        return driver.findElement(success).isDisplayed();
    }

    public void SaisirInfoReceiver(String NR, String ER) {
        SaisirNameReceiver(NR);
        SaisirEmailReceiver(ER);
        driver.findElement(btn_addtocart).click();

    }

}
