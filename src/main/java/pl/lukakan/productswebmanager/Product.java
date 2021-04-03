package pl.lukakan.productswebmanager;

public class Product {
    private String name;
    private double price;
    private Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(){

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public enum Category {
        FOOD("Spożywcze"),
        HOME("Domowe"),
        OTHER("Inne");

        private String description;

        Category(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
