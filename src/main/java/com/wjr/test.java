package com.wjr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static void main(String[] args) throws Exception {
        // System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver=new ChromeDriver();
        String userName = args[0];
        String passWord = args[1];
        System.out.println("userName=" + userName + "passWord="+passWord);
        try {
            driver.navigate().to("https://w1.v2free.net/auth/login");

            WebElement username = driver.findElement(By.id("email"));
            username.sendKeys(userName);
            WebElement password = driver.findElement(By.id("passwd"));
            password.sendKeys(passWord);

            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();


            Thread.sleep(5000);
        } finally {

            driver.quit();
        }
    }
}