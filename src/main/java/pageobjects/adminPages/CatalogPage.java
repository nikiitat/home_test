package pageobjects.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportfunctions.PageFunctionalities;

/**
 * Created by nikitatertytskyi on 10.09.17.
 */
public class CatalogPage extends PageFunctionalities {

    @FindBy(css = "a[href*=edit_product]")
    private WebElement addNewProduct;

    public CatalogPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public AddNewProductPage addNewProduct() {
        waitForElementClickable(addNewProduct);
        addNewProduct.click();
        return new AddNewProductPage(getWebDriver());
    }
}
