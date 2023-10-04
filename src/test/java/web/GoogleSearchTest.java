package web;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    @Test(groups = {"sanity", "regression"})
    public void openGoogleAndSearch() throws InterruptedException {
        // Arrange
        String expectedTitle = "TestVagrant - Google Search";
        String searchTerm = "TestVagrant";

        // Act
        driver.get("https://www.google.com");

        // switching to iframe
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@role='presentation']"));
        driver.switchTo().frame(iframeElement);

        // Click on Stay signed out button
        driver.findElement(By.xpath("//button[text()='Stay signed out']")).click();

        // Switching back to Main
        driver.switchTo().defaultContent();

        // Clicking on search area
        WebElement searchField = driver.findElement(By.id("APjFqb"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);

        // Assert
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
    }

    @Test(groups = {"regression"})
    public void openGoogleAndSearchWithImage() throws InterruptedException {
        // Arrange
        String expectedTitle = "Google Images";

        // Act
        driver.get("https://www.google.com");

        // switching to iframe
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@role='presentation']"));
        driver.switchTo().frame(iframeElement);

        // Click on Stay signed out button
        driver.findElement(By.xpath("//button[text()='Stay signed out']")).click();

        // Switching back to Main
        driver.switchTo().defaultContent();

        // Clicking on Images link
        driver.findElement(By.xpath("//a[text()='Images']")).click();

        // Assert
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
    }

    @Test(groups = {"sanity", "regression"})
    public void openGoogleAndSearchGmail() throws InterruptedException {
        //Test to fail assertion

        // Arrange
        String expectedTitle = "Gmail: Private and secure email at no cost | Google Workspace";

        // Act
        driver.get("https://www.google.com");

        // switching to iframe
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@role='presentation']"));
        driver.switchTo().frame(iframeElement);

        // Click on Stay signed out button
        driver.findElement(By.xpath("//button[text()='Stay signed out']")).click();

        // Switching back to Main
        driver.switchTo().defaultContent();

        /// Clicking on Images link
        driver.findElement(By.xpath("//a[text()='Gmail']")).click();

        // Assert
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
    }
}
