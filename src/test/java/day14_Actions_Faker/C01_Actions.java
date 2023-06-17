package day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {

        //techpro sayfasına gidelim

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();


        //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();


    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);

        //sayfanın en üstüne scroll yapalım
        Actions actions1 = new Actions(driver);
        actions.sendKeys(Keys.END);

        //sayfanin en ustune scroll gidelim
        actions.sendKeys(Keys.HOME).build().perform();

        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar
        //Eger yapilan islemin cok hizli olmasini istemiyorsak build()
        // kullanmak yerine her action'dan sonra perform() kullanmamiz gerekir.

        /*
her actions dan sonra perform kullanmazsak olay cok seri gerceklesir.
build kullandigimizda olay milisaniye icinde gerceklesir.
araya bekle methodu koysak bile java build methodunun oldugu kisimda sayfayi asagi yaparak hizli sekilde gerceklestirir

release() methodu kutuyu bir yerrden sürükleme veya eslestirme gibi konulari yaparken
mouseyi cekip birakmali sorularda release() methodu kullanilir
actionsta mouseta sürükleme islemi yapiyorsak serbest birakma islemi icin release() methodu kullanilir.
 */

    }

    @Test
    public void test03() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 1500).perform();

        //sayfanin ustune dogru gidelim
        actions.scrollByAmount(0, -1500).perform();

        /*
scrollByAmount(0,1500) kartezyen koordinat sistemi olan yatay ve düsey yönleri x ve y olarak adlandirdigimiz sistemde x=0 ile y=+1500 arasinda
gidecektir. pozitif(+) yön kuzey secilmistir
 */


    }
}