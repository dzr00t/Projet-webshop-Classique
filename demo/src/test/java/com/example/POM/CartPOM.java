package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPOM {
    WebDriver driver;
    By agree_terms = By.id("termsofservice");
    By checkout = By.id("checkout");

    public CartPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckAgree() {
        driver.findElement(agree_terms).click();
    }

    public void Checkout() {
        driver.findElement(checkout).click();
    }

}
