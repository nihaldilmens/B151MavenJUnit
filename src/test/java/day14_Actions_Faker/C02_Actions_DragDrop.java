package day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C02_Actions_DragDrop extends TestBase {

    @Test
    public void test01() {

        //Given user is on https://jqueryui.com/droppable/

        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        //Drag me to my target webelementini Drop here webelementi üzerine birakalım

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();

        /*
            Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
         sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
         dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz

         //dragAndDrop() iki webelement ister, drag webelemntini alir, drop webelementin üstüne koyar.
//action objemizle yapacagimiz islemi uygulamasi icin veya sonlandirmasi icin perform() kullaniriz


       drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         driver.switchTo().frame(0);
         */

    }

    @Test

    public void test02() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
         */
        driver.switchTo().frame(0);
        WebElement drag1 = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop1 = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions1 = new Actions(driver);
        actions1.clickAndHold(drag1).//-->Bu method ile webelemente mouse ile basılı tuttuk
                moveToElement(drop1).//-->Bu method ile basılı tuttuğumuz we'ti diğer we'tin üzerine götürdük
                release().//-->Bu method ile basılı tuttuğumuz we'ti serbest bıraktık
                perform();//--> işlemi sonlandırdık


    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(84, 28).//-->Belirtmiş olduğumuz kordinatlara we'ti taşır
                release().perform();
    }

}