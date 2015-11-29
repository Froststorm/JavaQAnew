import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class MyNewTest {

    WebDriver driver = new FirefoxDriver();

    String strBaseUrl = "https://www.yahoo.com/";
    String moreYahoo = "//a[contains(text(),'More Yahoo Sites')]";
    String strAllYahoo = "https://everything.yahoo.com/";
    String strFirstLevelList = "//*[@id='default-p_30345789-bd']/ul[1]/li[*]/a/span";
    String strThirdLevelList = "//*[@id='main-mod']/div[*]/dl[*]/dd[*]/a";
    String strSecondLevelList = "//*[@id='yui_3_8_1_1_1448759720052_869']/div/div/ul/li[*]/a";

    @BeforeTest
    public void beforeTestMethod() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void newTestMethod() {
        driver.get(strBaseUrl);
        /**
         * Метод прокликивает,пока что, лист первого уровня с проверкой времени загрузки страницы.Вывод в консоль
         * времени загрузки страницы и сообщения о выходе за пределы
         */
        for (int i = 0; true; i++) {
            long startTime = System.currentTimeMillis() / 1000;
            System.out.println("The start time is : " + startTime);
            List<WebElement> allElementsList = driver.findElements(By.xpath(strFirstLevelList));
            if (i >= allElementsList.size())
                break;
            allElementsList.get(i).click();

            System.out.println("Current page is: " + driver.getTitle());
            driver.navigate().back();
            long endTime = System.currentTimeMillis() / 1000;
            System.out.println("Page load time in seconds " + (endTime - startTime));

            if (endTime - startTime > 7) {
                System.out.println("Page load time exceeded");
            } else {
                System.out.println("Page load time normal");
            }
            System.out.println("Pass :" + (i + 1));
            System.out.println("----------------------------------------------\n");

        }

    }



    @AfterTest
        public void
        afterTestMethod () {
            driver.quit();
        }

    }



