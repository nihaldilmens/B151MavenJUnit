package day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_ClassWork {

    /*
   1)https://amazon.com adresine gidin
   2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
       ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
       ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
       ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
       ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
    */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @Test
    public void titleTest() {
        //○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
    @Test
    public void imageTest() {
        //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(image.isDisplayed());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung", Keys.ENTER);
    }
    @Test
    public void searchBoxTest() {
        //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nokia", Keys.ENTER);
    }
    @Test
    public void wrongTitleTest() {
        //○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
        String actualTitle = driver.getTitle();//Amazon ....
        String expectedTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }

    public static class C03_Dropdown {

        static WebDriver driver;


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
            //programming languages ddm den istediğiniz 4 seçeneği seçiniz
            WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
            Select select = new Select(diller);
            select.selectByIndex(0);
            select.selectByIndex(2);
            select.selectByIndex(3);
            select.selectByIndex(4);
            //Eğer sadece seçili olan option'ları yani seçenekleri yazdırmak istersek;
            select.getAllSelectedOptions().forEach(w -> System.out.println(w.getText()));//-->Lambda ile

            System.out.println("**********************************************");


            //for ile
            for (WebElement e : select.getAllSelectedOptions()) {
                System.out.println(e.getText());
            }

            //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
            Assert.assertEquals(4, select.getAllSelectedOptions().size());

            //Seçtiğimiz seçeneklerden ilkini yazdıralım
            System.out.println("**********************************************");
            System.out.println("Seçilen seçeneklerden ilki : " + select.getFirstSelectedOption().getText());

            //Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım
            System.out.println("**********************************************");
            System.out.println("Seçilen seçeneklerden ilki : " + select.getFirstSelectedOption().getText());
            Assert.assertEquals("Java", select.getFirstSelectedOption().getText());

            //Sectigimiz seceneklerin hepsini kaldiralim

            select.deselectAll();

            //sendKeys() methodu ile istedigimiz bir secenegi gonderelim

            diller.sendKeys("C#");

            //visibleText olarak secim yapacagimiz
            // bir method olusturup programming languages ddm den bir secenek secelim

            bekle(3);
            //visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
            selectVisibleText(diller,"Java");
            bekle(2);

            //Index olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
            selectIndex(diller,2);
            bekle(2);

            //Value olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
            selectValue(diller,"js");


        }

        @AfterClass
        public void tearDown() throws Exception {

            driver.close();

        }

        public void selectVisibleText(WebElement ddm, String text){
            Select select = new Select(ddm);
            select.selectByVisibleText(text);
        }

        //Index olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        public void selectIndex(WebElement ddm,int index){
            Select select = new Select(ddm);
            select.selectByIndex(index);
        }
        //Value olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        public void selectValue(WebElement ddm,String value){
            Select select = new Select(ddm);
            select.selectByValue(value);
        }

        public void bekle(int saniye){
            try {
                Thread.sleep(saniye*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
