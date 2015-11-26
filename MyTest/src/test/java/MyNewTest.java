import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyNewTest {

    WebDriver driver = new FirefoxDriver();

    String baseUrl = "https://www.yahoo.com/";
    String home = "//b";
    List<String> mycoolList = new ArrayList<String>(Arrays.asList(
            "//li[2]/a/span","//li[3]/a/span","//li[4]/a/span","//li[5]/a/span",
            "//li[6]/a/span","//li[7]/a/span","//li[8]/a/span","//li[9]/a/span",
            "//li[10]/a/span","//li[11]/a/span","//li[12]/a/span","//li[13]/a/span",
            "//li[14]/a/span","//li[15]/a/span","//li[16]/a/span","//li[17]/a/span",
            "//li[18]/a/span","//li[19]/a/span"));

    @BeforeMethod
    public void beforeTestMethod() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }


    @Test
    public void MyTestMethod1() {
        for (int i = 0; i < mycoolList.size(); i++) {
            driver.findElement(By.xpath(mycoolList.get(i))).click();
            if (i = );
        }
    }


    @AfterMethod
    public void afterTestMethod() {
        driver.close();
    }
}

