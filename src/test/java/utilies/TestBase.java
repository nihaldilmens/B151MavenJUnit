package utilies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public  abstract class TestBase {

    /*
   TestBase class'ından obje oluşturmanın önüne geçmek için bu class'ı abstract yapabiliriz
     TestBase testBase = new TestBase(); yani bu şekilde obje oluşturmanın önüne geçmiş oluruz.
    Bu class'a extends yaptığımız test class'larından ulaşabiliriz

    */
    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {

        driver.quit();
    }

    //AcceptAlert

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    //DismissAlert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    //getTextAlert
    public boolean getTextAlert(){
        driver.switchTo().alert().getText();
        return false;
    }

    //sendKeysAlert
    public void sendKeysAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //DropDown Index
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    //SwitchTo Window
    public void SwitchToWindow(int index){

        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }

    //SwitchTo Window-2
    public void window(int index){

        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

}




























