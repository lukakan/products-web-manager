package pl.lukakan.productswebmanager;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
        //test data
        products.add(new Product("Czekolada", 3.99, Product.Category.FOOD));
        products.add(new Product("Mleko", 2, Product.Category.FOOD));
        products.add(new Product("Odkurzacz", 350.99, Product.Category.HOME));
        products.add(new Product("Zmywarka", 650, Product.Category.HOME));
        products.add(new Product("Rakieta tenisowa", 120.5, Product.Category.OTHER));
        products.add(new Product("Opona", 180, Product.Category.OTHER));
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductInGivenCateogry(Product.Category category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public double getSumOfPricesForAllProducts() {
        return getSumOfPrices(products);
    }

    public double getSumOfPricesForGivenProductCategory(Product.Category category) {
        List<Product> filteredProducts = getProductInGivenCateogry(category);
        return getSumOfPrices(filteredProducts);
    }

    private double getSumOfPrices(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }


}
