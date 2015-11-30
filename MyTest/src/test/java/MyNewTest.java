import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyNewTest {

    WebDriver driver = new FirefoxDriver();

    String strBaseUrl = "https://www.yahoo.com/";
    String strMoreYahoo = "//*[@id='Navigation']//a[@class='fz-xxs more-link rapidnofollow']";
    String strAllYahoo = "https://everything.yahoo.com/";
    String strFirstLevelList = "//*[@id='default-p_30345789-bd']/ul[1]/li[*]/a/span";
    String strThirdLevelList = "//*[@id='main-mod']/div[*]/dl[*]/dd[*]/a";
    String strSecondLevelList = "//*[@id='Navigation']//li//li//a";
    List<Object> lstIterateLevels = new ArrayList<Object>(Arrays.asList(strFirstLevelList,strThirdLevelList,strSecondLevelList));


    @BeforeTest
    public void beforeTestMethod() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(strBaseUrl);


    }

    @Test(priority = 0)
    public void TestMethod1() {

        /**
         * Метод может прокликивать все 3 уровня.
         * Время загрузки страницы и сообщения о выходе за пределы
         */
        for (Object lstIterateLevel : lstIterateLevels) {
            String item = (String) lstIterateLevel;

            for (int i = 0; true; i++) {

                if (item.equals(strThirdLevelList)) {
                    driver.navigate().to(strAllYahoo);
                }

                List<WebElement> allElementsList = driver.findElements(By.xpath(item));

                if (item.equals(strSecondLevelList)) {
                    driver.findElement(By.xpath(strMoreYahoo)).click();
                    if (driver.getCurrentUrl().equals(strAllYahoo)){
                        driver.navigate().back();
                        allElementsList.get(i).click();
                    }
                }
                System.out.println("Current element list size :" + allElementsList.size());                //Здесь выводится размер листа
                System.out.println(item);

                if (i >= allElementsList.size())                                                            //Здесь должен быть размер списка для прокликивания
                    break;
                allElementsList.get(i).click();
                //------------------------------------------------------------------------------------------------------
                //Блок служебной консольной инфы
                long startTime = System.currentTimeMillis() / 1000;
                System.out.println("The start time is : " + startTime);

                System.out.println("Current page is: " + driver.getTitle());

                long endTime = System.currentTimeMillis() / 1000;
                System.out.println("Page load time in seconds " + (endTime - startTime));
                if (endTime - startTime > 7) {
                    System.out.println("Page load time exceeded");
                } else {
                    System.out.println("Page load time normal");
                }
                System.out.println("Pass :" + (i + 1));
                System.out.println("----------------------------------------------\n");

                driver.navigate().back();
                //Блок инфы закончился
            }

        }
    }


    @AfterTest
    public void shutDown() {
        driver.quit();
    }
}



