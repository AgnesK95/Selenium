import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Formy {
    public static void main(String[] args) throws InterruptedException {
        // Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C://chromedriver97.exe");

        //initializem un obiect de tip webdriver(Chrome driver)
        WebDriver driver = new ChromeDriver();

        //deschidem URL
        driver.get("https://formy-project.herokuapp.com/form");

        //maximizam fereastra
        driver.manage().window().maximize();

        // gasim un element dupa xpath - in f de atribut=valoare
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Andy");
        // last name
        driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys("S");

        // doar cand avem id, putem gasi direct dupa id
        // salvam elem intr-o variabila de tip WebElement
        // accesam metodele cu nume_variabila.
        WebElement job_title = driver.findElement(By.id("job-title"));
        job_title.sendKeys("Automation ");
        job_title.sendKeys("Tester");

        // gasim mai multe elemente de acelasi tip si le salvam intr-o lista
        List<WebElement> education_list = driver.findElements(By.xpath("//input[@type='radio']"));
        // dau click pe primul
        education_list.get(0).click();
        // dau click pe elem 2
        education_list.get(1).click();

        // gasim lista de gender
        List<WebElement> gender_list = driver.findElements(By.xpath("//input[@type='checkbox']"));
        //dam click pe male (primul)
        gender_list.get(0).click();

        // deschidem dropdown
        driver.findElement(By.xpath("//select[@id='select-menu']")).click();


        // selectez valoarea 10+, folosind textul vizibil in pagina
        driver.findElement(By.xpath("//option[text()='10+']")).click();



        // punem un wait ca sa vedem ce se intampla
        Thread.sleep(3000);

        // dam click pe submit, dupa text
        driver.findElement(By.xpath("//a[text()='Submit']")).click();



        // punem un wait sa asteptam sa se incarce noua pagina
        Thread.sleep(3000);

        // verificam ca am ajuns pe pagina corecta
        String actual = driver.getCurrentUrl();
        String expected = "https://formy-project.herokuapp.com/thanks";
        // comparam actual cu expected
        // daca ele nu sunt egale, pica testul si se afiseaza mesajul de eroare
        Assert.assertEquals(actual, expected, "Am ajuns pe pagina gresita");

        // gasesc titlul
        WebElement thank_you = driver.findElement(By.xpath("//h1"));
        // din titlu iau textul (actual)
        String thank_you_msg = thank_you.getText();
        // in expected, pun ce AR TREBUI SA FIE
        String expected_msg = "Thanks for submitting your form";
        // le compar cu un assert
        Assert.assertEquals(thank_you_msg, expected_msg, "Thank you msg e incorect");

        // verificam ca un element este VIZIBIL pe pagina
        Assert.assertTrue(thank_you.isDisplayed(), "Mesajul nu este vizibil");

        // inchide browser
        driver.quit();



    }
}
