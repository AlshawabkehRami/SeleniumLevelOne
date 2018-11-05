package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Example3 {

    WebDriver driver;
    WebDriverWait Wait;

    @BeforeMethod
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Wait =new WebDriverWait(driver,10);

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

        driver.findElement(By.cssSelector("[href*=\"logout\"]"));


    }

    @Test(priority = 3, dependsOnMethods = {"Login"})
    public void RegisteraPatient() {
        Login();
        driver.findElement(By.cssSelector("[id*=referenceapplication-registr]")).click();
        if (!driver.findElement(By.cssSelector("[id=checkbox-unknown-patient]")).isSelected()){
            driver.findElement(By.cssSelector("[id=checkbox-unknown-patient]")).click();

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
       // driver.quit();

    }

}
