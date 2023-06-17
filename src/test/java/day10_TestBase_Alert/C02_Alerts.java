package day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C02_Alerts extends TestBase {

    /*
Eger bir sayfadaki bir buttona tikladigimizda bir uyari penceresi cikiyorsa ve bu cikan pencereye sag click yapip locate alamiyorsak bu bir js Alert'tur.
js Alert'u handle edebilmek icin driverimizi o pencereye gecirmemiz gerekir. Bunun icin;
driver objemizi kullanarak switchTo() methodu ile alert() methodunu kullanarak js alert'e gecis yapmis oluruz.
accept() ya da dissmis() methodlari ile js Alert'u onaylar ya da iptal ederek kapatiriz.
 */
    WebDriver driver;
    @Test
    public void acceptAlert() {

        //Bir metod olusturun: acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("(//button)[1]")).click();
        driver.switchTo().//gecmek icin kullanilan method
                alert().//alerte gecis yapar
                accept(); //cikan alert te ok ya da tamam butonuna tiklar

        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi = "You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());

    }

    @Test
    //Bir metod olusturun: dismissAlert
    public void dismissAlert() {

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");


        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        driver.switchTo().
                alert().
                dismiss();//js Alert'teki iptal butonuna basar

        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenMetin = "successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenenMetin));

    }

    @Test
    public void sendKeysAlert() {

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");


        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("(//button)[3]")).click();

        driver.switchTo().alert().sendKeys("Erol");

        driver.switchTo().alert().accept();






    }
}
