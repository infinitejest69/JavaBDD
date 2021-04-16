package seleniumtests.pagemodels;

import org.openqa.selenium.WebDriver;
import seleniumtests.pagemodels.bbc.iplayer.IPlayerHomePage;
import seleniumtests.pagemodels.bbc.news.NewsHomePage;
import seleniumtests.pagemodels.bbc.sports.SportsHomePage;
import seleniumtests.pagemodels.bbc.weather.WeatherHomePage;
import seleniumtests.pagemodels.google.GoogleHomePage;
import seleniumtests.steps.DriverManager;

public class PageManager {

    private final WebDriver driver;
    private GoogleHomePage googleHomePage;
    private NewsHomePage newsHomePage;
    private SportsHomePage sportsHomePage;
    private IPlayerHomePage iPlayerHomePage;
    private WeatherHomePage weatherHomePage;

    public PageManager(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
    }

    public IPlayerHomePage getIPlayerHomePage() {
        return (iPlayerHomePage == null) ? iPlayerHomePage = new IPlayerHomePage(driver) : iPlayerHomePage;
    }

    public SportsHomePage getSportsHomePage() {
        return (sportsHomePage == null) ? sportsHomePage = new SportsHomePage(driver) : sportsHomePage;
    }

    public GoogleHomePage getGoogleHomePage() {
        return (googleHomePage == null) ? googleHomePage = new GoogleHomePage(driver) : googleHomePage;
    }

    public WeatherHomePage getWeatherHomePage() {
        return (weatherHomePage == null) ? weatherHomePage = new WeatherHomePage(driver) : weatherHomePage;
    }

    public NewsHomePage getNewsHomePage() {
        return (newsHomePage == null) ? newsHomePage = new NewsHomePage(driver) : newsHomePage;
    }
}
