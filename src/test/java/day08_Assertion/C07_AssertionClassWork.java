package day08_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AssertionClassWork {

    static WebDriver driver;

    // 2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1)https://amazon.com adresine gidin
        driver.get("https://amazon.com");
    }

    //title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
    @Test
    public void titleTest() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }

    // ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest() {
        //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(image.isDisplayed());
    }


     //Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    @Test
    public void SearchBox() {

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());

    }
    //wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
    @Test
    public void wrongTitleTest() {
       String actualTitle=driver.getTitle();
       String expectedTitle ="amazon";
       Assert.assertFalse(actualTitle.contains(expectedTitle));


    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();

    }
}
