import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Jules {
    public static void main(String[] args) throws InterruptedException {
        // Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C://chromedriver97.exe");

        //initializem un obiect de tip webdriver(Chrome driver)
        WebDriver driver = new ChromeDriver();

        //deschidem URL
        driver.get("https://jules.app/");

        //maximizam fereastra
        driver.manage().window().maximize();

        //punem wait
        Thread.sleep(3000);

        //verificam
        String actual = driver.getCurrentUrl();
        String expected = "https://jules.app/sign-in";
        Assert.assertEquals(actual, expected, "Am ajuns pe pagina gresita");

        //dau click pe forgot password
        driver.findElement(By.xpath("//a[text()=\"Forgot password?\"]")).click();

        //punem wait
        Thread.sleep(3000);

        //complete input with an invalid email (abc.com)
        driver.findElement(By.xpath("//input[@placeholder=\"Enter your email\"]")).sendKeys("abc.com");

    }
    }

