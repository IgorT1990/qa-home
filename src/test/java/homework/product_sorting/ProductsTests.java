package homework.product_sorting;

import lesson17_setting_browser.pages.shop_main.ProductPageShop;
import lesson17_setting_browser.pages.shop_main.Products;
import lesson17_setting_browser.pages.shop_main.SortDirection;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductsTests extends BaseTestListProduct {

    @BeforeClass
    public void beforeClass() {
        goToPart("8-dresses");
    }

    @Test
    public void allProductsTest() throws InterruptedException {
        List<Products> productsList = new ProductPageShop().sortByAmount(SortDirection.ITEM_AMOUNT).getProducts();

        Assert.assertEquals(productsList.size(), 30);
    }

    @Test
    public void checkSortingTest() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop().sortByAmount(SortDirection.ITEM_AMOUNT);
        List<Products> productsAsIs = productPageShop.getProducts();

        List<Products> productsAfterSorting = productPageShop.sortBy(SortDirection.PRICE_LOW_TO_HIGH).getProducts();
        Collections.sort(productsAsIs, new Comparator<Products>() {
            @Override
            public int compare(Products o1, Products o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }


    @Test
    public void checkSortingTestCustom() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop().sortByAmount(SortDirection.ITEM_AMOUNT);
        List<Products> productAsIs = productPageShop.getProducts();

        List<Products> productsAfterSorting = productPageShop.sortBy(SortDirection.PRICE_HIGH_TO_LOW).getProducts();

        Collections.sort(productAsIs, Products.getComparatorForSorting(SortDirection.PRICE_HIGH_TO_LOW));

        Assert.assertEquals(productAsIs, productsAfterSorting);
    }


    @Test
    public void sortByNameAscendingTest() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop().sortByAmount(SortDirection.ITEM_AMOUNT);
        List<Products> productsAsIs = productPageShop.getProducts();

        List<Products> productsAfterSorting = productPageShop.sortBy(SortDirection.NAME_A_TO_Z).getProducts();

        Collections.sort(productsAsIs, Comparator.comparing(Products::getName));

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }

    @Test
    public void sortByNameDescendingTest() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop().sortByAmount(SortDirection.ITEM_AMOUNT);
        List<Products> productsAsIs = productPageShop.getProducts();

        List<Products> productsAfterSorting = productPageShop.sortBy(SortDirection.NAME_Z_TO_A).getProducts();

        Collections.sort(productsAsIs, Comparator.comparing(Products::getName).reversed());

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }
}


