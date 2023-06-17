package day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilies.TestBase;

public class C03_Alerts extends TestBase {


    WebDriver driver;


    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println(getTextAlert());//-->TestBase class'ında oluşturmuş olduğumuz method
        Assert.assertEquals("You clicked a button", getTextAlert());

        //Ve alert'ü kapatalım
        acceptAlert();//-->TestBase class'ında oluşturmuş olduğumuz method
    }

    @Test
    public void test02() {
        driver.get("https://demoqa.com/alerts");
        //On button click, confirm box will appear karşsindaki buttona basalım
        driver.findElement(By.xpath("(//button)[4]")).click();

        //Çıkan alertte iptal'e basalım
        dismissAlert();

        //sonuc yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel", sonucYazisi);

    }

    @Test
    public void test03() {

        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım

        driver.findElement(By.xpath("(//button)[5]")).click();

        //çıkan alerte ismimizi girelim
        sendKeysAlert("Erol");

        acceptAlert();
        //ismi girdiğimizi doğrulayalım
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Erol"));
    }
}