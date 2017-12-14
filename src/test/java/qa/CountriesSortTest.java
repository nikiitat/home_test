package qa;

/**
 * Created by nikitatertytskyi on 15.08.17.
 */

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.AdminPage;
import pageobjects.BrowserInitializer;
import pageobjects.CountriesPage;


public class CountriesSortTest extends TestBase {
    private final WebDriver webDriver;
    private AdminPage adminPage;
    private CountriesPage countriesPage;

    public CountriesSortTest() {
        webDriver = BrowserInitializer.getWebDriver();
        adminPage = new AdminPage(webDriver);
        countriesPage = new CountriesPage(webDriver);
    }

    @Test
    public void mySortingCountriesTest() {
        adminPage.login();
        countriesPage = adminPage.openCountriesPage();
        countriesPage.sort();
    }

//    @Test
//    public void mySortingGeoZones() {
//        adminPage.login();
//        countriesPage = adminPage.openCountriesPage();
//        countriesPage.sortZones();
//    }
}
