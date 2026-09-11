package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPOM {
    WebDriver driver;
    Select select;
    Select select2;
    By Company = By.id("BillingNewAddress_Company");
    By County = By.id("BillingNewAddress_CountryId");
    By city = By.id("BillingNewAddress_City");
    By adress1 = By.id("BillingNewAddress_Address1");
    By code_postal = By.id("BillingNewAddress_ZipPostalCode");
    By phone_number = By.id("BillingNewAddress_PhoneNumber");
    By continueBtn = By.cssSelector("#billing-buttons-container input[value='Continue']");
    By continue2Btn = By.cssSelector("#payment-method-buttons-container input[value='Continue']");
    By continue3Btn = By.cssSelector("#payment-info-buttons-container input[value='Continue']");
    By confirm = By.cssSelector("input.confirm-order-next-step-button");

    

    By paymentCB = By.id("paymentmethod_2");
    By nameCard = By.id("CardholderName");
    By CardNumber = By.id("CardNumber");
    By expirateM = By.id("ExpireMonth");
    By expirateY = By.id("ExpireYear");
    By CardCode =  By.id("CardCode");

    


    public CheckoutPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void SelectExpirateDate(String m, String y) {
        
        select = new Select(driver.findElement(expirateM));
        select2 = new Select(driver.findElement(expirateY));

        select.selectByVisibleText(m);
        select2.selectByVisibleText(y);


    }


    public void SelectCountry(String S) {
        
        select = new Select(driver.findElement(County));
        select.selectByVisibleText(S);

    }

    public void SaisirCompany(String s){
        driver.findElement(Company).sendKeys(s);
    }
    public void SaisirCity(String s){
        driver.findElement(city).sendKeys(s);
    }

    public void SaisirAdress(String s){
        driver.findElement(adress1).sendKeys(s);
    }

    public void SaisirCodePostal(String s){
        driver.findElement(code_postal).sendKeys(s);
    }
    public void SaisirPhoneNumber(String s){
        driver.findElement(phone_number).sendKeys(s);
    }
    public void ClickContinue(){
        driver.findElement(continueBtn).click();
    }

    public void ClickContinue2(){
        driver.findElement(continue2Btn).click();
    }

    public void ClickContinue3(){
        driver.findElement(continue3Btn).click();
    }


    public void ClickConfirme(){
        driver.findElement(confirm).click();
    }

    public void ClickCB(){
        driver.findElement(paymentCB).click();
    }


    public void RemplirChamps(String company, String country, 
        String city, String adress, String ZIP , String  PN){

            SaisirCompany(company);
            SelectCountry(country);
            SaisirCity(city);
            SaisirAdress(adress);
            SaisirCodePostal(ZIP);
            SaisirPhoneNumber(PN);
            ClickContinue();

        }
    
    public void SaisirNameCard(String s){
        driver.findElement(nameCard).sendKeys(s);
    }
    public void SaisirCardNumber(String s){
        driver.findElement(CardNumber).sendKeys(s);
    }

    public void SaisirCardCode(String s){
        driver.findElement(CardCode).sendKeys(s);
    }

    public void SaisirInfoCard(String name, String cardnumber, String m, String y, String code){
        SaisirNameCard(name);
        SaisirCardNumber(cardnumber);
        SelectExpirateDate(m,y);
        SaisirCardCode(code);
        ClickContinue3();

    }

}

