package com.wjr;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class v2free {
    public static void main(String[] args) throws Exception {
        // EdgeDriver driver = new EdgeDriver();
        ChromeOptions chrome_options=new ChromeOptions();
        
        chrome_options.addArguments("--no-sandbox") ;//解决DevToolsActivePort文件不存在的报错
        chrome_options.addArguments("window-size=1920x1080"); // 指定浏览器分辨率
        chrome_options.addArguments("--disable-gpu") ;// 谷歌文档提到需要加上这个属性来规避bug
        chrome_options.addArguments("--headless") ;// 浏览器不提供可视化页面. linux下如果系统不支持可视化不加这条会启动失败
        
        // WebDriver driver=new ChromeDriver(chrome_options);
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

            WebElement confirmButton = driver.findElement(By.id("result_ok"));
            confirmButton.click();
            WebElement checkinButton = driver.findElement(By.id("checkin"));
            checkinButton.click();

            Thread.sleep(3000);
        } finally {

            driver.quit();
        }
    }
}