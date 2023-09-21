package web;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {
    public static final String UserName = "nanduagk_u0dlgB";
    public static final String AutomateKey = "AqGsDonpxv2vhqTUYzMc";
    public static final String URL = "https://" + UserName + ":" + AutomateKey + "@hub-cloud.browserstack.com/wd/hub";

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = getWebDriver();
    }

    private WebDriver getWebDriver() throws MalformedURLException {
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

        return new RemoteWebDriver(new URL(URL), capabilities);
    }
}
