package adminTests;

/**
 * Created by nikitatertytskyi on 15.08.17.
 */

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.adminPages.AdminPage;
import pageobjects.adminPages.CountriesPage;
import supportfunctions.BrowserInitializer;


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
        adminPage.openCatalogPage();
        countriesPage = adminPage.openCountriesPage();
//        countriesPage.sort();
        countriesPage.logout();
    }

    @Test
    public void mySortingGeoZones() {
        adminPage.login();
        countriesPage = adminPage.openCountriesPage();
        countriesPage.sortZones();
    }
}
