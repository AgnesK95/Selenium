import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JulesTema {
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
//
//        //verificam
//        String actual = driver.getCurrentUrl();
//        String expected = "https://jules.app/sign-in";
//        Assert.assertEquals(actual, expected, "Am ajuns pe pagina gresita");

        //enter email itfactory.ro@gmail.com
        //enter passw Start1232!
        driver.findElement(By.xpath("//input[@placeholder = \"Enter your email\"]")).sendKeys("itfactory.ro@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder = \"Enter your password\"]")).sendKeys("Start123!");
        driver.findElement(By.xpath("//span[text() = \"Log in\"]")).click();

        //punem wait
        Thread.sleep(3000);

        //verify correct url https://jules.app/search/all
        String actual =driver.getCurrentUrl();
        String expected = "https://jules.app/search/all";
        Assert.assertEquals(actual,expected,"Am ajuns pe pagina gresita");

        //clik pe my account
        driver.findElement(By.xpath("//*[@data-test-id =\"user-options-business-button\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();

        //punem wait
        Thread.sleep(3000);

        //verificam ca e displayed
        WebElement prenume = driver.findElement(By.xpath("//span[text()=\"First Name\"]"));
        Assert.assertTrue(prenume.isDisplayed());
        WebElement nume = driver.findElement(By.xpath("//span[text()=\"Last Name\"]"));
        Assert.assertTrue(nume.isDisplayed());
        WebElement numar_telefon=driver.findElement(By.xpath("//span[text()=\"Phone #\"]"));
        Assert.assertTrue(numar_telefon.isDisplayed());
}
}
