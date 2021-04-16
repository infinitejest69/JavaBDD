package seleniumtests.steps;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumtests.config.Configuration;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    Configuration configuration;
    private WebDriver driver;

    public DriverManager() {
        this.configuration = new Configuration();
        this.driver = getDriver();

    }

    public WebDriver startChrome() {
        System.setProperty("webdriver.chrome.driver", configuration.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(configuration.getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) driver = startChrome();
        return driver;
    }

    @After()
    public void closeChrome() {
        driver.quit();
    }
}
