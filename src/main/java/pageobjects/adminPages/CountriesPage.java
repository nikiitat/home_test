package pageobjects.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobjects.PageFunctionalities;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.testng.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 13.12.17.
 */
public class CountriesPage extends PageFunctionalities {

    public CountriesPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void sort() {
        getWebDriver().navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");

        List<WebElement> rows = getWebDriver().findElements(By.cssSelector("table.dataTable tr.row"));
        ArrayList<String> originalOrderCountries = new ArrayList<>();
        TreeSet<String> sortedOrderCountries = new TreeSet<>();
        ArrayList<String> originalOrderZones = new ArrayList<>();
        TreeSet<String> sortedOrderZones = new TreeSet<>();

        System.out.print(rows.size());
        for (int i = 0; i < rows.size(); i++) {
            String countryName = rows.get(i).findElements(By.cssSelector("td")).get(4).findElement((
                    By.cssSelector("a"))).getText();
            originalOrderCountries.add(countryName);
            sortedOrderCountries.add(countryName);
            if (!(rows.get(i).findElements(By.cssSelector("td")).get(5).getText()).equals("0")) {
                rows.get(i).findElements(By.cssSelector("td")).get(4).findElement((
                        By.cssSelector("a"))).click();

                List<WebElement> rowsZones = getWebDriver().findElements(By.cssSelector("table#table-zones tr"));
                originalOrderZones.clear();
                sortedOrderZones.clear();
                for (int j = 1; j < rowsZones.size() - 1; j++) {
                    String zonesName = rowsZones.get(j).findElements(By.cssSelector("td")).get(2).getText();
                    originalOrderZones.add(zonesName);
                    sortedOrderZones.add(zonesName);
                }
                assertTrue(compare(originalOrderZones, sortedOrderZones));
                System.out.println(countryName + "'s zones are displayed in an alphabetical order");
                getWebDriver().navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
            } else {
                System.out.println(countryName + " has no zones");
            }
            rows = getWebDriver().findElements(By.cssSelector("table.dataTable tr.row"));
        }
        assertTrue(compare(originalOrderCountries, sortedOrderCountries));
    }

    public void sortZones() {
        getWebDriver().navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        List<WebElement> rows = getWebDriver().findElements(By.cssSelector("table.dataTable tr.row"));
        ArrayList<String> originalOrderZones = new ArrayList<>();
        TreeSet<String> sortedOrderZones = new TreeSet<>();

        for (int i = 0; i < rows.size(); i++) {
            rows.get(i).findElements(By.cssSelector("td")).get(2).findElement((By
                    .cssSelector("a"))).click();
            originalOrderZones.clear();
            sortedOrderZones.clear();
            List<WebElement> rowsZones = getWebDriver().findElements(By.cssSelector("table#table-zones tr"));

            WebElement element = rowsZones.get(1).findElements(By.cssSelector("td")).get(2).findElement(By
                    .cssSelector("select"));
            if (element.isEnabled()) {
                for (int j = 1; j < rowsZones.size() - 1; j++) {
                    String zonesName = rowsZones.get(j).findElements(By.cssSelector("td")).get(2).findElement((
                            By.cssSelector("select option[selected='selected']"))).getText();
                    originalOrderZones.add(zonesName);
                    sortedOrderZones.add(zonesName);
                }
                assertTrue(compare(originalOrderZones, sortedOrderZones));
                System.out.println("zones are displayed in an alphabetical order");
            } else {
                System.out.println("No zones");
            }
            getWebDriver().navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            rows = getWebDriver().findElements(By.cssSelector("table.dataTable tr.row"));
        }
    }

    private boolean compare(ArrayList<String> originalOrder, TreeSet<String> sortedOrder) {
        String[] sorted = sortedOrder.toArray(new String[sortedOrder.size()]);
        for (int i = 0; i < originalOrder.size(); i++) {
            System.out.println('\t' + originalOrder.get(i) + " == " + sorted[i]);
            if (!originalOrder.get(i).toLowerCase().equals(sorted[i].toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
