package seleniumtests.steps.bbc;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import seleniumtests.pagemodels.PageManager;
import seleniumtests.pagemodels.bbc.weather.WeatherHomePage;
import seleniumtests.steps.DriverManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BBCWeatherSteps {

    WebDriver driver;
    PageManager pageManager;
    WeatherHomePage weatherHomePage;

    public BBCWeatherSteps(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
        this.pageManager = new PageManager(driverManager);
        weatherHomePage = pageManager.getWeatherHomePage();
    }

    @When("i input the location {string}")
    public void iInputTheLocation(String location) {
        weatherHomePage.inputLocation(location);
    }

    @And("click search")
    public void clickSearch() {
        weatherHomePage.clickSubmit();
    }

    @Then("i see current weather for {string}")
    public void iSeeCurrentWeatherFor(String location) {
        assertThat(weatherHomePage.getLocationText()).isEqualToIgnoringCase(location);
    }
}
