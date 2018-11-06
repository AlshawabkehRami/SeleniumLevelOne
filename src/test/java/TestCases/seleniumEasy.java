package TestCases;
import Global.SetUpBrowser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class seleniumEasy extends SetUpBrowser {

    @BeforeMethod
    public void SetStartUp() {
        OpenChromeDriver();
    }

    @Test
    private void test1() {

    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();

    }
}
