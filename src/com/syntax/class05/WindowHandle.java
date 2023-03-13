package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {

        //        tell your project where the webdriver is located.
//        for mac user please do not use .exe with chromedriver
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");

        //        create an instance of WebDriver
        WebDriver driver = new ChromeDriver();
//        max the window
        driver.manage().window().maximize();

//        go to syntaxprojects.com
        driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S1124777528%3A1678243316882480&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AWnogHdBKVhQDT97r7vecnS_cxDDo_A4QtHKHAlP1v8NfkHzHVRh1aCSgbF8_1oKXZusaFXVfEuJFw");

        //        click on the help button
        driver.findElement(By.xpath("//a[text()='Help']")).click();
//        click on privacy
        driver.findElement(By.xpath("//a[text()='Privacy']")).click();

//        get the window handle of the parent window
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println(parentWindowHandle);


//        get window handles of all the windows that have been opened up
        Set<String> windowHandles = driver.getWindowHandles();
//        print all the window handles
        for(String wh:windowHandles){
            System.out.println(wh);

            String title=driver.getTitle();
            if(title.equalsIgnoreCase("Privacy Policy")){
                break;
            }
        }
        // to verify we switched to the right window;
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentWindowHandle);
    }
}