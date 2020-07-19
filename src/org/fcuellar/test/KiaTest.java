package org.fcuellar.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KiaTest {

    public static void main(String[] args){
        WebDriver driver;
        String baseURL = "https://www.kia.com/mx/main.html";

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();




        driver.close();



    }
}
