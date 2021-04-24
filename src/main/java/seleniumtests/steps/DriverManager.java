package seleniumtests.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import seleniumtests.config.Configuration;
import seleniumtests.enums.ScreenShotLevel;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

  Configuration configuration;
  private WebDriver driver;

  public DriverManager() {
    this.configuration = new Configuration();
    this.driver = getDriver();
  }

  public WebDriver getDriver() {
    if (driver == null) driver = createDriver();
    return driver;
  }

  private WebDriver createDriver() {
    switch (configuration.getEnvironment()) {
      case LOCAL:
        driver = createLocalDriver();
        break;
      case REMOTE:
        driver = createRemoteDriver();
        break;
    }
    return driver;
  }

  private WebDriver createLocalDriver() {
    switch (configuration.getBrowser()) {
      case FIREFOX:
        driver = new FirefoxDriver();
        break;
      case EDGE:
        System.setProperty("webdriver.edge.driver", configuration.getDriverPath());
        driver = new EdgeDriver();
        break;
      case CHROME:
        System.setProperty("webdriver.chrome.driver", configuration.getDriverPath());
        driver = new ChromeDriver();
        break;
      case INTERNETEXPLORER:
        System.setProperty("webdriver.ie.driver", configuration.getDriverPath());
        driver = new InternetExplorerDriver();
        break;
    }
    if (configuration.getBrowserWindowSize()) driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(configuration.getImplicitlyWait(), TimeUnit.SECONDS);
    return driver;
  }

  private WebDriver createRemoteDriver() {
    try {
      switch (configuration.getBrowser()) {
        case FIREFOX:
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          driver = new RemoteWebDriver(new URL(configuration.getGridURL()), firefoxOptions);
          break;
        case CHROME:
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("start-maximized");
          driver = new RemoteWebDriver(new URL(configuration.getGridURL()), chromeOptions);
          break;
        case INTERNETEXPLORER:
          InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
          driver =
              new RemoteWebDriver(new URL(configuration.getGridURL()), internetExplorerOptions);
          break;
        case EDGE:
          EdgeOptions edgeOptions = new EdgeOptions();
          driver = new RemoteWebDriver(new URL(configuration.getGridURL()), edgeOptions);
          break;
      }
      //      if (configuration.getBrowserWindowSize()) driver.manage().window().maximize();
      //      driver.manage().timeouts().implicitlyWait(configuration.getImplicitlyWait(),
      // TimeUnit.SECONDS);

    } catch (Exception e) {
    }
    return driver;
  }

  @AfterStep()
  public void takeScreenshot(Scenario scenario) {

    ScreenShotLevel screenShotPolicy = configuration.getScreenShotPolicy();
    switch (screenShotPolicy) {
      case NONE:
        break;
      case FAIL:
        if (scenario.isFailed()) {
          screenshot(scenario);
        }
        break;
      case ALL:
        screenshot(scenario);
        break;
    }
  }

  @After()
  public void closeChrome() {
    driver.close();
    // driver.quit();
  }

  public void screenshot(Scenario scenario) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", "");
  }
}
