package day08_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClassWork {

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        /*



        d.Checkbox2 seçili değilse onay kutusunu tıklayın

         */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a.Verilen web sayfasına gidin.
        https:
//the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b.Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));

        //c.Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()) { //secili degilse
            checkBox1.click(); //checkbox i click yap
        }
        Thread.sleep(2000);


        //d.Checkbox2 seçili değilse onay kutusunu tıklayın

        if (!checkBox2.isSelected()) { // seçili değilse
            checkBox2.click(); //checkbox'i click yap

        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();


    }
}