package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {
    WebDriver driver;
    By email = By.id("Email");
    By password = By.id("Password");
    By btn_rememberMe = By.id("RememberMe");
    By btn_login = By.cssSelector(".login-button");

    public LoginPOM(WebDriver driver){
        this.driver = driver;
    }


    public void Login(String e, String p){
        driver.findElement(email).sendKeys(e);
        driver.findElement(password).sendKeys(p);
        driver.findElement(btn_rememberMe).click();
        driver.findElement(btn_login).click();

    }


}
