package org.fcuellar.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class KiaValidaciones {

    String baseURL = "https://www.kia.com/mx/main.html";
    WebDriver driver;
    String expectedResult ="";
    String actualResult= "";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void abrirNavegador(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void cerrarPopUp () throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"notice_01\"]/div[1]/a[2]")).click();
    }

    @Test(priority = 2)
    public void verificarPaginaDeKia(){
        expectedResult = "Kia Motors México | The Power to Surprise";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "El título de la página no coincide");
    }

    @Test(priority = 3)
    public void VerificaMenu() throws InterruptedException {
        expectedResult = "SHOWROOM";
        actualResult = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[3]/ul/li[1]/a")).getText();
        Assert.assertEquals(actualResult, expectedResult, "El Menu no se muestra");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='header']/div/div[3]/ul/li[1]/a")).click();
    }

    @Test(priority = 4)
    public void ImagenKiaSoul() throws InterruptedException {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[3]/ul/li[1]/div/div[2]/ul/li[7]/div"));
        builder.moveToElement(element).build().perform();

        expectedResult = "KIA SOUL 2020";
        actualResult = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[3]/ul/li[1]/div/div[2]/ul/li[7]/div/div/p[1]/span[1]")).getText();
        Assert.assertEquals(actualResult, expectedResult, "El automovil es incorrecto");

        //Tiempo de espera - dar clic en ver mas (Kia)
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[3]/ul/li[1]/div/div[2]/ul/li[7]/div/div/p[2]/a[1]")).click();
    }
    @Test(priority = 5)
    public void PaginaDeKiaSoul(){
        expectedResult = "Showroom | KIA Soul 2020 | Kia Motors México";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "El título de la página no coincide");
    }

    @Test(priority = 6)
    public void cotizar() throws InterruptedException {
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
    }

    @Test(priority = 7)
    public void escogeVehiculo() throws InterruptedException {
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

        //Version/Precio
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/ol/li[1]/div[2]/ul/li[3]/div[2]/span/span/div/div")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/ol/li[1]/div[2]/ul/li[3]/div[2]/span/span/div/ul/li[2]/a")).click();

        //Tiempo de espera - slider
        Thread.sleep(3000);
        WebElement drag = driver.findElement(By.xpath("//*[@id=\"slider-range1\"]/span"));
        Thread.sleep(1000);
        Actions act = new Actions(driver);
        act.dragAndDropBy(drag,250,0).perform();

        Thread.sleep(3000);
        String carPrice = driver.findElement(By.id("precioStr")).getText();
        //int price = Integer.parseInt(carPrice);
        System.out.println(carPrice);
        Thread.sleep(3000);

        driver.findElement(By.id("1_Siguiente")).click();
    }

    @Test(priority = 8)
    public void distribuidorKia() throws InterruptedException {
        expectedResult = "Distribuidor KIA";
        actualResult = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/ol/li[2]/div[1]/div/strong")).getText();
        Assert.assertEquals(actualResult,expectedResult, "No estas en el sección de eleccion del distribuidor");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/ol/li[2]/div[2]/div[1]/div/div[1]/div[2]/a[16]/span")).click();

        ((JavascriptExecutor)driver).executeScript("scroll(0,150)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/ol/li[2]/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr[3]/th/span/label")).click();

        ((JavascriptExecutor)driver).executeScript("scroll(0,150)");

        driver.findElement(By.id("2_Siguiente")).click();
    }

    @Test(priority = 9)
    public void misDatos() throws InterruptedException {
        expectedResult = "Mis datos";
        actualResult = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[3]/ol/li[3]/div[1]/div[1]/strong")).getText();
        Assert.assertEquals(actualResult,expectedResult, "No estas en el sección de datos del contacto");


        driver.findElement(By.id("fname")).sendKeys("Yurin");

        driver.findElement(By.id("namef")).sendKeys("Perez");

        driver.findElement(By.id("namem")).sendKeys("Trino");

        driver.findElement(By.id("mphone1")).sendKeys("332-856-4529");

        driver.findElement(By.id("email")).sendKeys("YurinTheDog@gmail.com");

        driver.findElement(By.id("email_confirm")).sendKeys("YurinTheDog@gmail.com");

        driver.findElement(By.xpath("//*[@id='financecalculator']/ul/li[8]/ul/li/div/span[3]/label")).click();

        driver.findElement(By.xpath("//*[@id='financecalculator']/ul/li[9]/ul/li/div/span[1]/label")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"financecalculator\"]/ul/li[10]/div[2]/div/span/span/div/div")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//*[@id=\"financecalculator\"]/ul/li[10]/div[2]/div/span/span/div/ul/li[2]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"financecalculator\"]/span/label")).click();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[3]/ol/li[3]/div[2]/span/label")).click();

        driver.findElement(By.id("3_Siguiente")).click();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
