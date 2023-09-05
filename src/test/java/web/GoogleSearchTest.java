package web;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class GoogleSearchTest {


    @Test
    public void openGoogle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

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

        Assert.assertEquals(driver.getTitle(),"TestVagrant - Google Search");
        System.out.println(driver.getTitle());

        driver.quit();
    }

}
