import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GoogleSearch {
    public static void main(String[] args) {
        // Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C://chromedriver97.exe");

        //initializem un obiect de tip webdriver(Chrome driver)
        WebDriver driver = new ChromeDriver();

        //deschidem URL
        driver.get("https://google.ro");

        //maximizam fereastra
        driver.manage().window().maximize();

        //stergem cookiurile
        driver.manage().deleteAllCookies();

        //refresh page
        driver.navigate().refresh();//in navigate gasim si back si forward

        //dam click pe "sunt de acord"
        /*
        roz=element web
        maro= atributul elementului
        albastru = valoarea atributului
        negru = textul elementului ( se vede in pagina)
         */
        driver.findElement(By.xpath("//div[text()='Sunt de acord']")).click();//am gasit dupa textul negru folosint xpath

        //trimitem text de la tastatura in inputul de cautare google dupa nume
        driver.findElement(By.name("q")).sendKeys("bebelus");

        //apasam enter
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //verificam titlul paginii
        String actual_title = driver.getTitle();
        String expected_title = "bebelus";
        Assert.assertTrue(actual_title.contains(expected_title));

        driver.quit();
    }
}
