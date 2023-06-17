package day07_MavenUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void techproedTest2() {
        driver.get("https://techproeducation.com");
    }

    @Test
    public void amazonTest1() {

        driver.get("https://www.amazon.de");
    }

    @After
    public void tearDown() throws Exception {

        driver.close();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her classtan sonra bir kez calisir");
    }
}
