package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Example3 {

    WebDriver driver;
    WebDriverWait Wait;
    String PationRecored;

    @BeforeMethod
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Wait = new WebDriverWait(driver, 20);

        driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");


    }

    @Test(priority = 1)
    public void Login() {

        driver.findElement(By.id("username")).sendKeys("Admin");
        driver.findElement(By.id("password")).sendKeys("Admin123");
        driver.findElement(By.id("Inpatient Ward")).click();
        driver.findElement(By.id("loginButton")).click();

    }

    @Test(priority = 2, dependsOnMethods = {"Login"})
    public void Logout() {
        Login();

        driver.findElement(By.cssSelector("a[href*=\"logout.action\"]")).click();


    }

    @Test(priority = 3, dependsOnMethods = {"Login"})
    public void RegisteraPatient() {
        Login();
        driver.findElement(By.cssSelector("[id^=referenceapplication-registrationapp]")).click();

        By CheckBoxPatint = By.id("checkbox-unknown-patient");
        WebElement CheckBoxPatintEle = Wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBoxPatint));

        if (!CheckBoxPatintEle.isSelected()) {
            CheckBoxPatintEle.click();
        }

        Select GenderDDL = new Select(driver.findElement(By.id("gender-field")));
        GenderDDL.selectByVisibleText("Female");

        driver.findElement(By.id("confirmation_label")).click();
        driver.findElement(By.id("submit")).click();

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PationRecored = driver.findElement(By.xpath("//*[@id=\"content\"]/div[6]/div[2]/span")).getText();
        System.out.println("PationRecored                   "+PationRecored);
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    
    /*@Test(priority = 4)
    public void FindPatientRecord() {


    }

    @Test(priority = 5)
    public void ViewthePatient() {


    }

    @Test(priority = 6)
    public void SearchaPatient() {


    }

    @Test(priority = 7)
    public void BookanAppointment() {


    }

    @Test(priority = 8)
    public void CaptureVitals() {


    }
*/

    @AfterMethod
    public void closeDriver() {
        driver.quit();

    }

}
