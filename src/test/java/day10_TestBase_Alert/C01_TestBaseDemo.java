package day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilies.TestBase;

public class C01_TestBaseDemo extends TestBase {

    WebDriver driver;

    @Test
    public void test01(){
    //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

    //Başlığın Bootcamp içerdiğini test edelim
    String actualTitle = driver.getTitle();
    String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

}

    //HARD WAIT(Bekleme Methodu)
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }






}


