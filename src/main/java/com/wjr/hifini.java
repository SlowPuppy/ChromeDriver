package com.wjr;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class hifini {
    public static void main(String[] args) throws Exception {
        // EdgeDriver driver = new EdgeDriver();
        ChromeOptions chrome_options=new ChromeOptions();
        
        chrome_options.addArguments("--no-sandbox") ;//解决DevToolsActivePort文件不存在的报错
        chrome_options.addArguments("window-size=1920x1080"); // 指定浏览器分辨率
        chrome_options.addArguments("--disable-gpu") ;// 谷歌文档提到需要加上这个属性来规避bug
        chrome_options.addArguments("--headless") ;// 浏览器不提供可视化页面. linux下如果系统不支持可视化不加这条会启动失败
        
        WebDriver driver=new ChromeDriver(chrome_options);
        // WebDriver driver=new ChromeDriver();
        String userName = args[0];
        String passWord = args[1];
        try {
            driver.navigate().to("https://hifini.com/user-login.htm");

            WebElement username = driver.findElement(By.id("email"));
            username.sendKeys(userName);
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys(passWord);

            WebElement loginButton = driver.findElement(By.id("submit"));
            loginButton.click();

            Thread.sleep(5000);

            WebElement checkinButton = driver.findElement(By.id("sign"));
            checkinButton.click();

            Thread.sleep(3000);
        } finally {

            driver.quit();
        }
    }
}