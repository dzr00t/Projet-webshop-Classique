package com.example.hook;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.PF.HomePageF;

public class BaseTest {
    public static WebDriver driver;
    public static HomePageF Hpf;
    @BeforeEach 
    public void setUp(){
        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Hpf = new HomePageF(driver);
    }

    @AfterEach 
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            driver = null; 
        }
    }

    
}
