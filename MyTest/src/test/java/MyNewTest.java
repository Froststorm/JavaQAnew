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
    String moreYahoo = "//a[contains(text(),'More Yahoo Sites')]";
    List<String> firsLevelList;
    List<String> secondLevelList;

    {
        firsLevelList = new ArrayList<String>(Arrays.asList("//li[1]/a/span",
                "//li[2]/a/span", "//li[3]/a/span", "//li[4]/a/span", "//li[5]/a/span",
                "//li[6]/a/span", "//li[7]/a/span", "//li[8]/a/span", "//li[9]/a/span",
                "//li[10]/a/span", "//li[11]/a/span", "//li[12]/a/span", "//li[13]/a/span",
                "//li[14]/a/span", "//li[15]/a/span", "//li[16]/a/span", "//li[17]/a/span",
                "//li[18]/a/span", "//li[19]/a/span"));

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


    @BeforeMethod
    public void beforeTestMethod() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void MyTestMethod1() {

        for (int i = 0; i < firsLevelList.size(); i++) {
            long startTime = System.currentTimeMillis() / 1000;
            System.out.println(" The start time is : " + startTime);
            if (i == 0 || i == 8) {
                driver.findElement(By.xpath(firsLevelList.get(i))).click();
                System.out.println(driver.getTitle());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.get(baseUrl);


            } else {
                driver.findElement(By.xpath(firsLevelList.get(i))).click();
                System.out.println(driver.getTitle());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.get(baseUrl);
//                driver.findElement(By.xpath(home)).click();
            }

            long endTime = System.currentTimeMillis() / 1000;
//            System.out.println(" The end time is : " + endTime);
            System.out.println("Page load time in seconds " + (endTime - startTime));

            if (endTime - startTime > 7) {
                System.out.println("Page load time exceeded");
            } else {
                System.out.println("Page load time normal");
            }
            System.out.println(firsLevelList.get(i) + " Pass :" + (i + 1));
        }
    }

    @Test(priority = 2)
    public void MyTestMethod2() {
        /**
         *Пока что закомнтил стрроки второго теста что бы понять могу ли я сделать проверку второго листа
         * в первом тесте тоже и упростить таки первый тест
         */

//
//        for (int i = 0; i < firsLevelList.size(); i++) {
//            long startTime = System.currentTimeMillis() / 1000;
//            System.out.println(" The start time is : " + startTime);
//            if (i == 0 || i == 8) {
//                driver.findElement(By.xpath(firsLevelList.get(i))).click();
//                System.out.println(driver.getTitle());
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                driver.get(baseUrl);
//
//
//            } else {
//                driver.findElement(By.xpath(firsLevelList.get(i))).click();
//                System.out.println(driver.getTitle());
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                driver.get(baseUrl);
////                driver.findElement(By.xpath(home)).click();
//            }
//
//            long endTime = System.currentTimeMillis() / 1000;
////            System.out.println(" The end time is : " + endTime);
//            System.out.println("Page load time in seconds " + (endTime - startTime));
//
//            if (endTime - startTime > 7) {
//                System.out.println("Page load time exceeded");
//            } else {
//                System.out.println("Page load time normal");
//            }
//            System.out.println(firsLevelList.get(i) + " Pass :" + (i + 1));
//        }
    }

    @AfterMethod
    public void afterTestMethod() {
        driver.close();
    }
}

