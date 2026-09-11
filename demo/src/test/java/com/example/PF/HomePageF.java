package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageF {
    WebDriver driver;
    @FindBy(className = "ico-register")
    private WebElement btn_register;

    @FindBy(className = "ico-login")
    private WebElement btn_login;

    public HomePageF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickRegister() {
        btn_register.click();

    }

    public void ClickLogin() {
        btn_login.click();

    }
}
