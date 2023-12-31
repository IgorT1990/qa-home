package lesson17_setting_browser.pages.shop_main;

import lesson17_setting_browser.driver.WebDriverHolder;
import lesson17_setting_browser.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductPageShop extends BasePage {

    @FindBy(id = "selectProductSort")
    private WebElement sortByElement;

    @FindBy(id = "nb_item")
    private WebElement showAll;

    public ProductPageShop(){
        super();
    }

    public List<Products> getProducts(){
        List<WebElement> productItems = WebDriverHolder.getInstance().getDriver().findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
        List<Products> productList = new ArrayList<>();

        String xpathProductName;
        String xpathProductPrice;

        int i = 1;

        for (WebElement product : productItems){
            xpathProductName = "//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[1]/div/a[1]";
            xpathProductPrice = "//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[2]/div[1]/span";

            String productName = product.findElement(By.xpath(xpathProductName)).getAttribute("title");
            String productPriceAsString = product.findElement(By.xpath(xpathProductPrice)).getText();

            productPriceAsString = productPriceAsString.replace(",", ".");
            productPriceAsString = productPriceAsString.replace(" ", "");

            Double productPrice = Double.parseDouble(productPriceAsString.replace("₴", ""));

            Products productsModel = new Products().setName(productName).setPrice(productPrice);
            productList.add(productsModel);
            i++;
        }
        return productList;
    }

    public ProductPageShop sortBy(SortDirection sortDirection) throws InterruptedException {
        Select select = new Select(sortByElement);
        select.selectByValue(sortDirection.getValue());
        sleep(1500);
        return new ProductPageShop();
    }

    public ProductPageShop sortByAmount(SortDirection sortDirection) throws InterruptedException {
        Select select = new Select(showAll);
        select.selectByValue(sortDirection.getValue());
        sleep(1500);
        return new ProductPageShop();
    }
}
