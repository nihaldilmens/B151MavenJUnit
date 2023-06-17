package day12_WindowHandles;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("Ilk Sayfa Handle Degeri = " + ilkSayfaHandle);
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);
        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);
        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//-->Yeni bir sekme acildi

        /*
            Bir button'a click yaptigimizda kontrolumuz disinda yeni bir sekme yada pencere acilirsa
        yeni acilan pencerenin handle degerini bilmedigim icin normal getWindowHandle ile driver' imi
        yeni pencereye geciremem. Bunu icin getWindowHandles() methoduyla acilan tum pencereleri bir Set' e assign edip
        ilk actigimiz pencere degilse ikinci acilan yeni penceredir mantigiyla bir loop icinde cozebiliriz
         */
        Set<String> pencereler = driver.getWindowHandles();
        for (String w : pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfaHandle)) { //0EDF2F482E49EA9F8FABCF880043CA19 --> ilk sayfa handle degeri
                driver.switchTo().window(w);//96E54F1F66480D93B32996081F1C376E --> ikinci sayfa handle degeri
            }
        }
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
        String ikinciSayfaHandle = driver.getWindowHandle();
        System.out.println("Ikinci Sayfa Handle Degeri = " + ikinciSayfaHandle);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle, ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandle);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandle);

        //Assert.assertTrue ==> isSelected, isEnable, isDisplay ve contains tarzinda boolean donduren ifadelerde kullanilir
        //Assert.assertTrue ==> ... oldugu gibi esitlik isteyen ifadelerde kullanilir


    }

    @Test
    public void test02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);
        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);
        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        /*
            getWindowHandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini bir arraylist' e atadaik
        Index 0(sifir)'dan basladigi icin kontrolum disinda acilan pencere 1. index de oldugundan
         driver.switchTo().window(pencereler.get(1)); yeni acilan pencereye gecis yaptik.
         */
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));

    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
          driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
          /*

           */
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */


        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.

        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.


        //  ilk sayfaya tekrar dönün.

    }

    @Test
    public void test04() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.

    /*
    Set ve ArrayList kullanmadan switchTo().window() methodu içine argüman olarak driver.getWindowHandles()
    methodunu ile bütün açılan pencereli bir array olarak alıp index belirterek isteğim pencereye geçiş yapabilirim.
     */
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */

        //  ilk sayfaya tekrar dönün.


    }
}































