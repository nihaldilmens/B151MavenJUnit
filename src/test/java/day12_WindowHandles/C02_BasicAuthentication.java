package day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

public class C02_BasicAuthentication extends TestBase {

    /*
    Aşağıdaki bilgileri kullanarak authentication yapınız:
    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin

    /Basic authentication' larda kullanici adi ve sifrenin bize mutlaka verilmesi gerekir.
        //https://Kullanici Adi:Sifre@internetsitesi seklinde bir kullanimla handle edebiliriz

     */

    @Test
    public void test01() {

        //Başarılı girişi doğrulayın.

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Congratulations! yazısının çıktığını doğrulayın
        String tebrikYazisi = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(tebrikYazisi.contains("Congratulations!"));


        //Elemental Selenium yazisina tiklayalim
        driver.findElement(By.xpath("(//a)[2]")).click();
        driver.switchTo().
                window(driver.getWindowHandles().toArray()[1].toString());//-->Acilan yeni pencereye gectik

        //Basligin "Elemental Selenium" oldugunu dogrulayin
        System.out.println(driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());

        //DDM' den Java secelim
        WebElement ddm = driver.findElement(By.xpath("//*[@class='dropdown-language']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");

        selectVisibleText(ddm,"Java"); //--> Method ile






    }
}























