package com.example.PF;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterResult {
    WebDriver driver;
    @FindBy(className = "ico-logout")
    private WebElement btn_Logout;

    @FindBy(className = "account")
    private WebElement email;

    @FindBy(className = "product-box-add-to-cart-button")
    private List<WebElement> listeBoutons;

    public RegisterResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void ClickLogout() {
        btn_Logout.click();
    }

    public Boolean getEmail() {
        return email.isDisplayed();

    }

    public void cliquerSurAddcart(int index) {
        listeBoutons.get(index).click();

    }
}
