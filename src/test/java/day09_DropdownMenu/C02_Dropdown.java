package day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {

     /*
       DROPDOWN--> Altbaşlıkların olduğu açılır menü listesidir.
    Dropdown'u handle(automate) etmek için
    1- Dropdown menüyü ilk olarak locate ederiz.
    2- Select objesi oluştururuz.
    3-Select objesinini dropdown webelementinin içeriğine ve seçeneklerine
    erişim sağlaması için SELECT sınıfına argüman olarak locate ettiğimiz webelementi koyarız.
    SYNTAX:
          Select  select = new Select(dropdown webelementi)
    4- Select class'ı, sadece <select> tag'ı oluşturulmuş dropdown menülere uygulanabilir.
    5- select objesi dropdown'u handle edebilmek için 3 method kullanır.
               a- selectByVisibleText(() -> dropdown'daki web elemente görünür metin ile ulaşmak için kullanılır.
               b-selectByIndex() ->index ile ulaşmak için kullanılır.(index 0'dan başlar)
               c-selectByValue() -> Elementin değeri ulaşmak için kullanılır(option tag'larındaki değer (value)ile)
   6-getOprions() -> Locate ettigimiz ddm'deki tum secenekleri bize verir. (List'e atip loop ile yazdirabiliriz)
   7-getFirstSelectedOption() -> dropdown'daki seçili kalan ecenegi bize verir.Birden fazla secenek
   secildiyse bu secilenlerin ilkini bize verir.

   8-Ddm'ye sendKeys() methodu ile de ddm menudeki seceneklerden birini kullanarak gonderebiliriz.
     */


    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void test01() {
        //1.Method:
        //        a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay = driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun = driver.findElement(By.xpath("(//select)[4]"));

        //        b. Select objesi olustur

        Select select = new Select(yil);
        select.selectByIndex(5);//index 0'dan başlar 2018'i seçer


        //        c. Select object i kullaarak 3 farkli sekilde secim yapiniz

    }

    @Test
    public void test02() {
       // 2.Method:
       // a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);
        select.getOptions().forEach(w-> System.out.println("w = " + w.getText()));



        // 2.YOL
        List<WebElement> eyalet = driver.findElements(By.xpath("//select[@id='state']"));
        /** eyaletler.stream().forEach(t-> System.out.println(t.getText())); */
        for (WebElement w : eyalet) {
            System.out.println(w.getText());  // Foreach ile de yazdirabiliriz.
        }



    }

    @Test
    public void test03() {

        // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);
        String seciliOlanSecenek = select.getFirstSelectedOption().getText();
        System.out.println("seciliOlanSecenek = " + seciliOlanSecenek);

        Assert.assertEquals("Select a State",seciliOlanSecenek);
        Assert.assertTrue((seciliOlanSecenek.equals("Select a State")));

        Assert.assertTrue(seciliOlanSecenek.contains("Select"));


    }

    @AfterClass
    public  void tearDown() throws Exception {

        driver.close();



    }
}
