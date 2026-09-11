package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.PF.*;
import com.example.POM.CartPOM;
import com.example.POM.CheckoutPOM;
import com.example.POM.LoginPOM;
import com.example.POM.ProductPOM;

import net.datafaker.Faker;

public class E2EwebshopTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePageF Hpf;
    RegisterPF Rpf;
    RegisterResult RR;
    LoginPOM lp;
    ProductPOM PP;
    CartPOM CP;
    CheckoutPOM ChP;

    String URL = "https://demowebshop.tricentis.com/";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        

        Hpf = new HomePageF(driver);
        Rpf = new RegisterPF(driver);
        RR = new RegisterResult(driver);
        lp = new LoginPOM(driver);
        PP = new ProductPOM(driver);
        CP = new CartPOM(driver);
        ChP = new CheckoutPOM(driver);

        driver.get(URL);

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    Faker faker = new Faker(new java.util.Locale("fr"));
    String nom = faker.name().lastName();
    String prenom = faker.name().malefirstName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();

    String email2 = faker.internet().emailAddress();
    String nom2 = faker.name().lastName();

    String company = faker.company().name();
    String country = "France";  
    String city = faker.address().city();
    String adress = faker.address().fullAddress();
    String ZIP = faker.address().zipCode(); 
    String  PN = faker.phoneNumber().phoneNumberInternational();

    String CardNumber = faker.finance().creditCard();

    @Test
    @Tag("Register")
    public void Register() {

        // on clique sur register
        Hpf.ClickRegister();
        // on veriffie le bon url
        assertTrue(driver.getCurrentUrl().contains("/register"));
        // on sessie les champs
        Rpf.SaisirPersonalDetails("Male", prenom, nom, email, password);
        assertTrue(driver.getCurrentUrl().contains("/registerresult/"));
        // logout
        RR.ClickLogout();
        assertTrue(driver.getCurrentUrl().equalsIgnoreCase(URL));
        // login
        Hpf.ClickLogin();
        assertTrue(driver.getCurrentUrl().contains("/login"));
        // saisir les info
        lp.Login(email, password);
        // assertion du email
        assertTrue(RR.getEmail());
        // choisir un element
        RR.cliquerSurAddcart(0);
        // assertion
        assertTrue(PP.getProductname());
        // metttre au cart
        PP.SaisirInfoReceiver(nom2, email2);
        PP.getSuccess();
        // clique cart
        PP.ClickCart();
        assertTrue(driver.getCurrentUrl().contains("/cart"));
        CP.CheckAgree();
        CP.Checkout();
        assertTrue(driver.getCurrentUrl().contains("/onepagecheckout"));
        //saisir les champs
        ChP.RemplirChamps(company,country,city,adress,ZIP,PN);
        // click sur la carte 
        ChP.ClickCB();
        ChP.ClickContinue2();
        ChP.SaisirInfoCard(nom + prenom, CardNumber,"08","2030","123");
        //confirmer
        ChP.ClickConfirme();
        //assertion finale
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/checkout/completed/"));
        assertTrue(driver.getCurrentUrl().contains("/checkout/completed"));
        


        

        

    }

}
