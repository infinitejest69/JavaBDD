package seleniumTests.Steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
  WebDriver driver;

  @Given("^user is on Home Page$")
  public void user_is_on_Home_Page() {
    System.setProperty(
        "webdriver.chrome.driver", "C:\\Users\\Andy\\Documents\\DevTools\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.shop.demoqa.com");
  }

  @Given("user is on Google Home Page")
  public void userIsOnGoogleHomePage() {}
}
