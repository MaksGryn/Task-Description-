package Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class WebDriver {
    public ChromeDriver driver;
    public WebDriverWait wait;

    String FirstName = "TestName";
    String Surname = "TestSurname";
    String Street = "ExampleStreet";
    String ZipCode = "31-000";
    String City = "Cracow";
    String Email = "example@gmail.pl";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/prog/chromedriver.exe"); //select Chrome Driver and path to it
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15);
        System.out.println("Start Test");

    }



    @After
    public void setDown() throws InterruptedException {
        System.out.println("End Test");
        driver.wait(10);
        driver.quit();
    }
}
