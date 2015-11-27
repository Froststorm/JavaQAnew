import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyNewTest {

        WebDriver driver = new FirefoxDriver();

        String baseUrl = "https://www.yahoo.com/";
        String moreYahoo = "//a[contains(text(),'More Yahoo Sites')]";
        List<String> secondLevelList;

        {
            secondLevelList = new ArrayList<String>(Arrays.asList("(//a[contains(text(),'Answers')])[2]",
                    "//a[contains(text(),'Careers')]", "(//a[contains(text(),'Celebrity')])[2]",
                    "//a[contains(text(),'Fantasy Baseball')]", "//a[contains(text(),'Fantasy Sports')]",
                    "(//a[contains(text(),'Flickr')])[2]", "(//a[contains(text(),'Games')])[2]",
                    "(//a[contains(text(),'Groups')])[2]", "//a[contains(text(),'Horoscopes')]",
                    "//a[contains(text(),'Horoscopes')]", "//a[contains(text(),'Local')]",
                    "//a[contains(text(),'Messenger')]", "(//a[contains(text(),'Music')])[2]",
                    "(//a[contains(text(),'My Yahoo')])[2]", "(//a[contains(text(),'Search')])[2]",
                    "//a[contains(text(),'Small Business')]"));

        }

        @BeforeTest
        public void beforeTestMethod () {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }

        @Test
        public void MyTestMethod1 () {
            /**
             * Метод прокликивает,пока что, лист первого уровня с проверкой времени загрузки страницы.Вывод в консоль
             * времени загрузки страницы и сообщения о выходе за пределы
             */


            /**
             TODO сделать прокликивание второго списка в первом тесте
             */
            for (int i = 1; i <= 19; i++) {
                long startTime = System.currentTimeMillis() / 1000;
                System.out.println("The start time is : " + startTime);
                if (i == 0 || i == 8) {
                    driver.findElement(By.xpath("//li[" + i + "]/a/span")).click();
                    System.out.println("Current page is: " + driver.getTitle());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    driver.get(baseUrl);


                } else {
                    driver.findElement(By.xpath("//li[" + i + "]/a/span")).click();
                    System.out.println(driver.getTitle());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    driver.get(baseUrl);

//                driver.findElement(By.xpath(home)).click(); почему то он этот xpath не ест а кликает куда ни попадя, сделал так пока что
                }

                long endTime = System.currentTimeMillis() / 1000;

//            System.out.println(" The end time is : " + endTime);  думаю оно тут не нужно .

                System.out.println("Page load time in seconds " + (endTime - startTime));

                if (endTime - startTime > 7) {
                    System.out.println("Page load time exceeded");
                } else {
                    System.out.println("Page load time normal");
                }
                System.out.println(" //li[" + i + "]/a/span " + " Pass :" + (i));
                System.out.println("----------------------------------------------\n");
            }
        }

        @AfterTest
        public void afterTestMethod () {
            driver.quit();
        }

    }


