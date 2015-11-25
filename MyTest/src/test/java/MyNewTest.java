import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class MyNewTest {
    WebDriver driver ;
    String google = "https://google.com";

    @BeforeMethod
    public void beforeTestMethod(){
        driver = new FirefoxDriver();

    }

    @Test
    public void MyTestMethod1() {
      driver.get(google);

    }

    @AfterMethod
    public void afterTestMethod(){
        driver.close();
    }
}

