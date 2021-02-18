package Test;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestQR extends WebDriver {

    public void openSite(){
        driver.get("https://test-env-1.mobile-test.ticos-systems.cloud/ou-select");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Test Env - Ticket shop - Test Env - Ticket shop")); //check website
    }


    public void SelectTicket(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Pool Indoor']"))); //wait  Indoor pool
        driver.findElement(By.xpath("//*[text()='Pool Indoor']]")).click();  //select Indoor pool

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[text()='add']"))); //wait  ticket
        driver.findElement(By.xpath("//mat-icon[text()='add']")).click();   //add ticket
        driver.findElement(By.xpath("//span[text()='Next']")).click();  // click Next

    }

    public void Calendar(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Choose Time Slot']")));  //wait website
        driver.findElement(By.xpath("//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted']")).click(); //calendar
        driver.findElement(By.xpath("//div[text() = ' 20 ']")).click(); // data
        driver.findElement(By.xpath("//*[text() = '07:00 - 09:00']")).click();  // time

    }

    public  void Config(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Participants Configuration']"))); //wait website

        driver.findElement(By.xpath("//*[text() = 'First name']")).sendKeys(FirstName); //input Name
        driver.findElement(By.xpath("//*[text() = 'Surname']")).sendKeys(Surname);  //input Surname
        driver.findElement(By.xpath("//*[text() = 'Street']")).sendKeys(Street);  //input Street
        driver.findElement(By.xpath("//*[text() = 'Zip Code']")).sendKeys(ZipCode);  //input ZipCod
        driver.findElement(By.xpath("//*[text() = 'City']")).sendKeys(City);  //input City

        driver.findElement(By.xpath("//*[text() = ' Next ']")).click();
    }

    public void Verify(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Verify your details']")));
        driver.findElement(By.xpath("//*[text() = 'E-Mail Address']")).sendKeys(Email);
        driver.findElement(By.xpath("//div[@class = 'mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();

        driver.findElement(By.xpath("//*[text()=' TEST Buy now! ']")).click();
    }

    @Test
    public void testQRCode(){
        openSite();

        SelectTicket();

        Calendar();

        Config();

        Verify();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='qrcode']")));

    }


}
