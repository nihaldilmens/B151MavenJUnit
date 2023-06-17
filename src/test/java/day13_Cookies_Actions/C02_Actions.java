package day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));

        //Sağ klik yapabilmek için öncelikle Actions class'ından bir obje oluşturmalıyız
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).//sağ klik yapma methodu kullandık
                perform();//actions objemizle yapacağımız işlemi uygulaması için veya sonlandırması için perform() kullanırız.


        //Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
        Assert.assertEquals("You selected a context menu",getTextAlert());
        //TestBase deki getTextAlert() methodu kullandık --> driver.switchTo().alert().getText();


        //Tamam diyerek alert’i kapatın
        acceptAlert();//-->TestBase deki methodu kullandık --> driver.switchTo().alert().accept()




        
    }
}
