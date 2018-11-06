package TestCases;

import Global.SetUpBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.LoggerFactory;

import java.util.List;


public class seleniumEasy extends SetUpBrowser {

    private static final Logger logger = LoggerFactory.getLogger(seleniumEasy.class);

    @BeforeMethod
    public void SetStartUp() {
        OpenChromeDriver();
    }

    @Test
    private void get_emp_Salary() {
        logger.info("*********************************************************");
        logger.info("GetSalary");
        logger.info("*********************************************************");
        driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");



        Select DDL = new Select(driver.findElement(By.name("example_length")));
        DDL.selectByVisibleText("100");

        List<WebElement> TabeRows = driver.findElements(By.xpath("//*[@id=\"example\"]/thead"));
        System.out.println(TabeRows.size());
        for (int i = 0; i < TabeRows.size(); i++) {
            String Name = TabeRows.get(i).getText();
            System.out.println(Name);

        }


    }

    @AfterMethod
    public void closeDriver() {
        //driver.quit();

    }
}
