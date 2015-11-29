import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anrii on 28.11.2015.
 */
public class MytestMethod {
    public WebDriver getDriver() {
        return driver;
    }

    public String getStrBaseUrl() {
        return strBaseUrl;
    }

    public String getMoreYahoo() {
        return moreYahoo;
    }

    public String getStrAllYahoo() {
        return strAllYahoo;
    }

    public String getStrBaseNavLIST() {
        return strBaseNavLIST;
    }

    public String getStrAllProductsList() {
        return strAllProductsList;
    }

    public List<String> getSecondLevelList() {
        return secondLevelList;
    }

    public MytestMethod() {
    }

    public MytestMethod(String strBaseNavLIST, String strAllProductsList) {
        this.strBaseNavLIST = strBaseNavLIST;
        this.strAllProductsList = strAllProductsList;
    }

    public MytestMethod(WebDriver driver, String strBaseUrl, String moreYahoo, String strAllYahoo, String strBaseNavLIST, String strAllProductsList, List<String> secondLevelList) {
        this.driver = driver;
        this.strBaseUrl = strBaseUrl;
        this.moreYahoo = moreYahoo;
        this.strAllYahoo = strAllYahoo;
        this.strBaseNavLIST = strBaseNavLIST;
        this.strAllProductsList = strAllProductsList;
        this.secondLevelList = secondLevelList;
    }

    WebDriver driver = new FirefoxDriver();
    String strBaseUrl = "https://www.yahoo.com/";
    String moreYahoo = "//a[contains(text(),'More Yahoo Sites')]";
    String strAllYahoo =  "https://everything.yahoo.com/";
    String strBaseNavLIST = ".//*[@id='Navigation']//ul//li/a";
    String strAllProductsList ="//*[@id='main-mod']/div[1]";
    List<String> secondLevelList = new ArrayList<String>(Arrays.asList("(//a[contains(text(),'Answers')])[2]",
            "//a[contains(text(),'Careers')]", "(//a[contains(text(),'Celebrity')])[2]",
            "//a[contains(text(),'Fantasy Baseball')]", "//a[contains(text(),'Fantasy Sports')]",
            "(//a[contains(text(),'Flickr')])[2]", "(//a[contains(text(),'Games')])[2]",
            "(//a[contains(text(),'Groups')])[2]", "//a[contains(text(),'Horoscopes')]",
            "//a[contains(text(),'Horoscopes')]", "//a[contains(text(),'Local')]",
            "//a[contains(text(),'Messenger')]", "(//a[contains(text(),'Music')])[2]",
            "(//a[contains(text(),'My Yahoo')])[2]", "(//a[contains(text(),'Search')])[2]",
            "//a[contains(text(),'Small Business')]"));






}
