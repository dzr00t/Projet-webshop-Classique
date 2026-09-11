package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPF {
    WebDriver driver;
    @FindBy(id = "gender-male")
    private WebElement genderM;
    @FindBy(id = "gender-female")
    private WebElement genderF;
    @FindBy(id = "FirstName")
    private WebElement FirstName;
    @FindBy(id = "LastName")
    private WebElement LastName;
    @FindBy(id = "Email")
    private WebElement Email;
    @FindBy(id = "Password")
    private WebElement Password;
    @FindBy(id = "ConfirmPassword")
    private WebElement ConfirmPassword;
    @FindBy(id = "register-button")
    private WebElement btn_register;

    public RegisterPF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CheckGender(String s) {
        if (s.equalsIgnoreCase("Male")) {
            genderM.click();
        } else
            genderF.click();
    }

    public void SaisirFirstName(String s) {
        FirstName.sendKeys(s);
    }

    public void SaisirLastName(String s) {
        LastName.sendKeys(s);
    }

    public void SaisirEmail(String s) {
        Email.sendKeys(s);
    }

    public void SaisirPassword(String s) {
        Password.sendKeys(s);
    }

    public void SaisirConfirmPassword(String s) {
        ConfirmPassword.sendKeys(s);
    }

    public void ClickBtnRegister() {
        btn_register.click();

    }

    public void SaisirPersonalDetails(String Gender, String FN, String LN, String E, String P) {
        CheckGender(Gender);
        SaisirFirstName(FN);
        SaisirLastName(LN);
        SaisirEmail(E);
        SaisirPassword(P);
        SaisirConfirmPassword(P);
        ClickBtnRegister();

    }

}
