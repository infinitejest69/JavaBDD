package seleniumtests.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    WebDriver driver;

    public CommonSteps(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
    }

    @Given("i navigate to {string}")
    public void iNavigateTo(String path) {
        driver.navigate().to(path);
    }


}
