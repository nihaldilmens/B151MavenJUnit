package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C02_Iframe extends TestBase {

    WebDriver driver;

    @Test
    public void iframe() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String editorYazisi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editorYazisi.contains("Editor"));
        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textbox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLinki = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());


        /*Eger iframe icinde bir yazi yazildiysa anasayfaya donmek icin refresh kullanilirsa yazilan yazi sayfa yenilendigi icin silinir
        ama defaultContent kullanirsak yazi silinmez
         */


    }
}

