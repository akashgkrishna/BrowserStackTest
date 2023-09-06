package web;
import org.openqa.selenium.*;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class GoogleSearchTest {


    public  static final String UserName = "nanduagk_u0dlgB";
    public  static final String AutomateKey = "AqGsDonpxv2vhqTUYzMc";
    public  static final String URL = "https://"+UserName+":"+AutomateKey+"@hub-cloud.browserstack.com/wd/hub";
    @Test
    public void openGoogle() throws InterruptedException, MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        ChromeDriver driver = new ChromeDriver(options);
//
//        driver.manage().window().maximize();
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("browserVersion", "latest");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("seleniumVersion", "4.1.0");
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("build", "Build3");
        capabilities.setCapability("name", "Test3");

        WebDriver driver = new RemoteWebDriver(new URL(URL),capabilities);

        // Open Google.com
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google", "Failed");

        // switching to iframe
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@role='presentation']"));
        driver.switchTo().frame(iframeElement);

        // Click on Stay signed out button
        driver.findElement(By.xpath("//button[text()='Stay signed out']")).click();

        // Switching back to Main
        driver.switchTo().defaultContent();

        // Clicking on search area
        WebElement searchField = driver.findElement(By.id("APjFqb"));

        searchField.sendKeys("TestVagrant");
        searchField.sendKeys(Keys.RETURN);

        Thread.sleep(5000);


        Assert.assertEquals(driver.getTitle(),"TestVagrant - Google Sear", "Intentional fail");
        System.out.println(driver.getTitle());

        driver.quit();
    }

}
