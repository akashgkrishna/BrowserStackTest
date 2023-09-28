package web;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        Map<String, String> browserStackConfig = readBrowserStackConfig();
        driver = getWebDriver(browserStackConfig);
    }

    private WebDriver getWebDriver(Map<String, String> browserStackConfig) throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Chrome");

        // Set other BrowserStack capabilities if needed
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("browserVersion", "latest");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("seleniumVersion", "4.1.0");
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("build", "Build");
        capabilities.setCapability("name", "Test");

//        return new RemoteWebDriver(new URL(URL), capabilities);

        String browserstackURL = browserStackConfig.get("browserstackURL");

        return new RemoteWebDriver(new URL(browserstackURL), capabilities);
    }

    private Map<String, String> readBrowserStackConfig() {
        try {
            FileInputStream inputStream = new FileInputStream("browserstack.yml");
            Yaml yaml = new Yaml();
            return yaml.load(inputStream);
        } catch (FileNotFoundException e) {
            System.err.println("browserstack.yml file not found.");
        } catch (Exception e) {
            System.err.println("Error reading browserstack.yml file: " + e.getMessage());
        }
        return null;
    }
}
