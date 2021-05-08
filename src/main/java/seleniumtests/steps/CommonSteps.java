package seleniumtests.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class CommonSteps {

    WebDriver driver;

    public CommonSteps(DriverManager driverManager) throws MalformedURLException {
        this.driver = driverManager.getDriver();
    }

    @Given("i navigate to {string}")
    public void iNavigateTo(String path) {
        driver.navigate().to(path);
    }


}
