package com.wjr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        EdgeDriver driver = new EdgeDriver();
        int firstNumber = Integer.parseInt(args[0]);
        int secondNumber = Integer.parseInt(args[1]);
        int sum = firstNumber + secondNumber;
        System.out.println("sum=" + sum);
        try {
            driver.navigate().to("https://bing.com");

            WebElement element = driver.findElement(By.id("sb_form_q"));
            element.sendKeys("WebDriver");
            element.submit();

            Thread.sleep(5000);
        } finally {

            driver.quit();
        }
    }
}