package org.fcuellar.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KiaTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        String baseURL = "https://www.kia.com/mx/main.html";

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"notice_01\"]/div[1]/a[2]")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='header']/div/div[3]/ul/li[1]/a")).click();

        //mouseover sobre la imagen de Kia Soul
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[3]/ul/li[1]/div/div[2]/ul/li[7]/div"));
        builder.moveToElement(element).build().perform();

        //Tiempo de espera - dar clic en ver mas (Kia)
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[3]/ul/li[1]/div/div[2]/ul/li[7]/div/div/p[2]/a[1]")).click();

        //Tiempo de espera - Hacer scroll de 5550 pixeles en vertical
        //((JavascriptExecutor)driver).executeScript("scroll(0,5550)");
        Thread.sleep(500);
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
        Thread.sleep(500);
        ((JavascriptExecutor)driver).executeScript("scroll(0,2000)");
        Thread.sleep(500);
        ((JavascriptExecutor)driver).executeScript("scroll(0,2550)");

        //Tiempo de espera - Dar clic en cotizar
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='content']/div[12]/div[3]/ul/li[2]/a")).click();

        //Formulario

        //Año Modelo
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/ol/li[1]/div[2]/ul/li[1]/div[2]/span/span/div")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div[1]/ol/li[1]/div[2]/ul/li[1]/div[2]/span/span/div/ul/li[2]/a")).click();

        //Modelo
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/ol/li[1]/div[2]/ul/li[2]/div[2]/span/span/div")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/ol/li[1]/div[2]/ul/li[2]/div[2]/span/span/div/ul/li[10]/a")).click();

        //Tiempo de espera - slider
        Thread.sleep(3000);
        WebElement drag = driver.findElement(By.xpath("//*[@id=\"slider-range1\"]/span"));
        Thread.sleep(1000);
        Actions act = new Actions(driver);
        act.dragAndDropBy(drag,490,0).perform();


        //driver.findElement(By.id("1_Siguiente")).click();

        //Tiempo de espera - Cerrar navegador
        Thread.sleep(5000);
        //driver.close();



    }
}
