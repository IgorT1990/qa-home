package lesson17_setting_browser.pages.shop_main;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Comparator;

@Data
@Accessors(chain = true)
public class Products {
    public String name;
    public Double price;


    public static Comparator<Products> getComparatorForSorting(SortDirection sortDirection){
        switch (sortDirection){
            case PRICE_LOW_TO_HIGH:
                return new Comparator<Products>() {
                    @Override
                    public int compare(Products o1, Products o2) {
                        return o1.getPrice().compareTo(o2.getPrice());
                    }
                };
            case PRICE_HIGH_TO_LOW:
                return new Comparator<Products>() {
                    @Override
                    public int compare(Products o1, Products o2) {
                        return o2.getPrice().compareTo(o1.getPrice());
                    }
                };
            case NAME_A_TO_Z:
                return new Comparator<Products>() {
                    @Override
                    public int compare(Products o1, Products o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                };
            case NAME_Z_TO_A:
                return new Comparator<Products>() {
                    @Override
                    public int compare(Products o1, Products o2) {
                        return o2.getName().compareTo(o1.getName());
                    }
                };
        }
        return null;
    }
}
