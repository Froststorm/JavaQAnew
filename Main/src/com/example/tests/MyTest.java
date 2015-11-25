package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

class MyTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.nba.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  void test() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Teams")).click();
    driver.findElement(By.linkText("Video")).click();
    driver.findElement(By.xpath("//nav[@id='sib3-nav']/div/ul/li[8]/a/span")).click();
    driver.findElement(By.xpath("//div[@id='main-container']/div/div/div[2]/div/section/div/div/div/div/div[2]/div[3]/div[4]/div[2]/a/span/span")).click();
    driver.findElement(By.xpath("//div[@id='main-container']/div/div/div[2]/section/div/div/div/div/div/div/a[5]/div/span")).click();
    driver.findElement(By.linkText("Broadcaster Schedule")).click();
    driver.findElement(By.cssSelector("img.nba-logo")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
