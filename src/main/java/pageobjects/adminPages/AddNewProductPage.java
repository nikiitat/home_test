package pageobjects.adminPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageobjects.PageFunctionalities;

import java.nio.file.Paths;

/**
 * Created by nikitatertytskyi on 10.09.17.
 */
public class AddNewProductPage extends PageFunctionalities {
    private  String newItem = "Donald duck";

    @FindBy(name = "status")
    private WebElement status;

    @FindBy(name = "name[en]")
    private WebElement name;

    @FindBy(name = "code")
    private WebElement code;

    @FindBy(css = "div#tab-general input[value='1'][type='checkbox']")
    private WebElement rubberDStatus;

    @FindBy(css = "div#tab-general input[value='0'][type='checkbox']")
    private WebElement mainStatus;

    @FindBy(css = "div.tabs a[href='#tab-information']")
    private WebElement information;

    @FindBy(css = "div#tab-information select[name='manufacturer_id']")
    private WebElement manufactureId;

    @FindBy(css = "div#tab-information input[name='keywords'][type='text']")
    private WebElement informationInput;

    @FindBy(css = "div#tab-information input[name='short_description[en]'][type='text']")
    private WebElement shortDescription;

    @FindBy(css = "div#tab-information div.trumbowyg-editor")
    private WebElement description;

    @FindBy(css = "div#tab-information input[name='head_title[en]'][type='text']")
    private WebElement headTitle;

    @FindBy(css = "div#tab-information input[name='meta_description[en]'][type='text']")
    private WebElement metaDescription;

    @FindBy(css = "div.tabs a[href='#tab-prices']")
    private WebElement tabPrices;

    @FindBy(css = "div#tab-prices input[name='purchase_price'][type='number']")
    private WebElement price;

    @FindBy(css = "div#tab-prices select[name='purchase_price_currency_code']")
    private WebElement currencyPrice;

    @FindBy(css = "div#tab-prices input[data-type='currency']")
    private WebElement price2;

    @FindBy(css = ".button-set [name='save']")
    private WebElement saveButton;

    @FindBy(css = "div#notices-wrapper")
    private WebElement message;

    @FindBy(name = "quantity")
    private WebElement quantity;

    @FindBy(name = "product_groups[]")
    private WebElement productGroups;

    @FindBy(name = "sold_out_status_id")
    private WebElement soldOutStatus;

    @FindBy(name = "new_images[]")
    private WebElement uploadImage;

    @FindBy(name = "date_valid_from")
    private WebElement validFrom;

    @FindBy(name = "date_valid_to")
    private WebElement validTo;

    public AddNewProductPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void addNewProduct(){
        waitForElementClickable(status);
        status.click();
        waitForElementClickable(name);
        name.click();
        name.clear();
        name.sendKeys("Donald duck");
        waitForElementClickable(code);
        code.click();
        code.clear();
        code.sendKeys("777");
        waitForElementClickable(rubberDStatus);
        String rubberDuckStatus = rubberDStatus.getAttribute("checked");
        if (rubberDuckStatus == null){
            rubberDStatus.click();
        }
        String mainStatusAttribute = mainStatus.getAttribute("checked");
        if (mainStatusAttribute != null){
            mainStatus.click();
        }
        waitForElementClickable(quantity);
        quantity.click();
        quantity.clear();
        quantity.sendKeys("7");
        waitForElementClickable(productGroups);
        productGroups.click();

        waitForElementClickable(soldOutStatus);
        Select soldOut = new Select(soldOutStatus);
        soldOut.selectByValue("2");

        waitForElementVisible(uploadImage);
        uploadImage.sendKeys(Paths.get(System.getProperty("user.dir")) + "/Duck.png");

        waitForElementClickable(validFrom);
        validFrom.sendKeys("25.06.2017");

        waitForElementClickable(validTo);
        validTo.sendKeys("25.08.2017");

        waitForElementClickable(information);
        information.click();

        Select manufacturer = new Select(waitForElementClickable(manufactureId));
        manufacturer.selectByValue("1");

        waitForElementVisible(informationInput);
        informationInput.sendKeys("Donald Duck");

        waitForElementVisible(shortDescription);
        shortDescription.sendKeys("Donald Duck from cartoon)");


        waitForElementClickable(description);
        description.click();
        description.sendKeys("Donald Duck best toy for your kid!");
        description.sendKeys(Keys.ENTER);
        description.sendKeys("Donald Duck is a cartoon character created in 1934 at Walt Disney Productions. Donald is an anthropomorphic white duck with a yellow-orange bill, legs, and feet. He typically wears a sailor shirt and cap with a bow tie");

        waitForElementVisible(headTitle);
        headTitle.sendKeys(newItem);

        waitForElementVisible(metaDescription);
        metaDescription.sendKeys(newItem);

        waitForElementClickable(tabPrices);
        tabPrices.click();

        waitForElementClickable(price);
        price.click();
        price.clear();
        price.sendKeys("100");

        Select currency = new Select (waitForElementClickable(currencyPrice));
        currency.selectByValue("USD");

        waitForElementClickable(price2);
        price2.click();
        price2.clear();
        price2.sendKeys("100");

        System.out.println("Press Save button");
        waitForElementClickable(saveButton);
        saveButton.click();
    }

    public String errorDisplaySaveMessage(){
        waitForElementVisible(message);
        return message.getText();
    }
}
