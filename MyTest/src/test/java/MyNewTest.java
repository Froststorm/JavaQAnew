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
    String strMoreYahoo = "More Yahoo Sites";
    String strAllYahoo = "https://everything.yahoo.com/";
    String strFirstLevelList = "//*[@id='default-p_30345789-bd']/ul[1]/li[*]/a/span";
    String strThirdLevelList = "//*[@id='main-mod']/div[*]/dl[*]/dd[*]/a";

    List<String> lstSecondLevelList = new ArrayList<String>(Arrays.asList("(//a[contains(text(),'Answers')])[2]",
            "//li[21]/div/div/ul/li[2]/a", ".//*[@id='yui_3_8_1_1_1448781627072_817']/div/div/ul/li[3]/a", "(//a[contains(text(),'Fantasy Baseball')]",
            "(//a[contains(text(),'Fantasy Sports')]", "(//a[contains(text(),'Flickr')])[2]", "(//a[contains(text(),'Games')])[2]",
            "(//a[contains(text(),'Groups')])[2]", "(//a[contains(text(),'Horoscopes')]", "(//a[contains(text(),'Local')]",
            "//a[contains(text(),'Messenger')]", "(//a[contains(text(),'Music')])[2]", "(//a[contains(text(),'My Yahoo')])[2]",
            "(//a[contains(text(),'Search')])[2]", "(//a[contains(text(),'Small Business')]"));

    List<Object> lstIterateLevels = new ArrayList<Object>(Arrays.asList(strFirstLevelList,strThirdLevelList));


    @BeforeTest
    public void beforeTestMethod() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(strBaseUrl);


    }

    @Test(priority = 2)
    public void TestMethod1() {

        /**
         * Метод Может прокликивать все 3 уровня , но нужно придумать правильное условие.
         * Время загрузки страницы и сообщения о выходе за пределы
         */
        for (Object lstIterateLevel : lstIterateLevels) {
            String item = (String) lstIterateLevel;
            List<WebElement> allElementsList = driver.findElements(By.xpath(item));
            for (int i = 0; true; i++) {

                System.out.println(allElementsList.size());                                               //Здесь выводится размер листа

                if (i >= allElementsList.size())                                                          //Здесь должен быть размер списка для прокликивания
                    break;

                if (item.equals(strThirdLevelList)) {
                    driver.get(strAllYahoo);
                }

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

    @Test(priority = 0)
    public void TestMethod2() throws Exception {


        int i = 0;
        while (true) {
            System.out.println(lstSecondLevelList.get(i)+"\n");

            driver.findElement(By.linkText(strMoreYahoo)).click();

            driver.findElement(By.xpath(lstSecondLevelList.get(i))).click();
            if (i >= lstSecondLevelList.size())                                                          //Здесь должен быть размер списка для прокликивания
                break;


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

            i++;
        }
    }


    @AfterTest
    public void shutDown() {
        driver.quit();
    }
}



