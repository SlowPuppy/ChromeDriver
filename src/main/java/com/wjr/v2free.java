package com.wjr;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class v2free {
    public static void main(String[] args) throws Exception {
        EdgeDriver driver = new EdgeDriver();
        String userName = args[0];
        String passWord = args[1];
        System.out.println("userName=" + userName + "passWord="+passWord);
        try {
            driver.navigate().to("https://w1.v2free.net/auth/login");

            // WebElement element = driver.findElement(By.id("sb_form_q"));
            // element.sendKeys("WebDriver");
            // element.submit();

            Thread.sleep(5000);
        } finally {

            driver.quit();
        }
    }
}