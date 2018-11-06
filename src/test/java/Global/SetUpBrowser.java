package Global;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SetUpBrowser {

   public WebDriver driver;
   public WebDriverWait Wait;

    public void OpenChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();

    }

}
