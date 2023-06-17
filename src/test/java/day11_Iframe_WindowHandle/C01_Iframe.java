package day11_Iframe_WindowHandle;

import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C01_Iframe extends TestCase {

    WebDriver driver;

    /*
    Bir HTML dökümanin icine yerlestirilmis baska nir HTML dökümanina inline frame yani IDRAME denir
    Bir sayfada iframe varsa iframe icindeki WebElementi handle edebilmek icin  switchTo() methoduyla iframe'e gecis yapmamiz gerekir.
    eger gecis yapmazsak nosuchelementexception aliriz

   Alert'ten farki alert ciktiginda hicbir webelementi locate edemeyiz. iframe olsada locate
    ederiz fakat handler edemeyiz

 */

    public void iframe() {

        //➢ https://testcenter.techproeducation.com/index.php?page=iframe

        driver.get("testcenter.techproeducation.com");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));


      //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);// geçiş yapmazsak Nosuchelementexception hatası alırız
        String ApplicationListYazisi = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Applications lists", ApplicationListYazisi);

        //Son olarak sayfa başınlığında iframe yazısının görünür olduğunu test ediniz
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        //driver.get(driver.getCurrentUrl());
        //driver.switchTo().parentFrame();
        //driver.navigate().refresh();
        //driver.switchTo().defaultContent(); //-->Bizi iframe'den ana sayfaya getirir
        // Usttekilerin hepsi iframe'den ana sayfaya donmek icin kullanilir

        /*

         Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.

                /*Nested iframe' lerde defaultContent ile refresh hangi iframe' de olursa olsun direk anasayfaya gecerken
        parentFrame sadece bir ust frame' e gecer
         */





    }
}



















