package homework.stream_api;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Automobile {
    private String model;
    private int year;
    private double price;
    private String color;
    private double engineValue;

    public Automobile(String model, int year, double price, String color, double engineValue) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.engineValue = engineValue;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngineValue() {
        return engineValue;
    }

    public void setEngineValue(double engineValue) {
        this.engineValue = engineValue;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", engineValue=" + engineValue +
                '}';
    }

    public static void main(String[] args) {
        // Створення списку автомобілів
        List<Automobile> automobiles = List.of(
                new Automobile("BMW", 2021, 40000, "black", 2.0),
                new Automobile("Mercedes", 2019, 35000, "grey", 1.8),
                new Automobile("Toyota", 2020, 30000, "white", 1.6),
                new Automobile("Honda", 2018, 32000, "blue", 2.4)
        );

        // Show all cars
        System.out.println("All cars: ");
        automobiles.forEach(auto -> System.out.println(auto.getModel()));



        // Show cars with black color for instance
        String colorSearch = "black";
        List<Automobile> autoWithColor = automobiles.stream()
                .filter(auto -> auto.getColor().equalsIgnoreCase(colorSearch))
                .collect(Collectors.toList());
        System.out.println("\nAuto with color: " + colorSearch + ":");
        autoWithColor.forEach(auto -> System.out.println(auto.getModel()));



        // Show cars with price more than 35000
        double searchingPrice = 35000;
        List<Automobile> autoWithBiggerPrice = automobiles.stream()
                .filter(auto -> auto.getPrice() > searchingPrice)
                .collect(Collectors.toList());
        System.out.println("\nCar expensive than: " + searchingPrice + ":");
        autoWithBiggerPrice.forEach(auto -> System.out.println(auto.getModel()));



        // Cars with years between  ( 2018 - 2020)
        int startYear = 2018;
        int finishYear = 2020;
        List<Automobile> autoWithYearsBetween = automobiles.stream()
                .filter(auto -> auto.getYear() >= startYear && auto.getYear() <= finishYear)
                .collect(Collectors.toList());
        System.out.println("\nAuto with years from: " + startYear + " till " + finishYear + ":");
        autoWithYearsBetween.forEach(auto -> System.out.println(auto.getModel()));



        // Sort cars by price
        automobiles.sort(Comparator.comparingDouble(Automobile::getPrice).reversed());
        System.out.println("\nAutos begin with less price:");
        automobiles.forEach(auto -> System.out.println(auto.getModel() + " - " + auto.getPrice()));
    }
}

