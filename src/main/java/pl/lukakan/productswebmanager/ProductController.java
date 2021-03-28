package pl.lukakan.productswebmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/list")
    public String showProducts(@RequestParam(name = "kategoria", required = false) String categoryName, Model model) {
        List<Product> produts;
        double sumOfProductsPrices;

        if (categoryName == null) {
            produts = productRepository.getProducts();
            sumOfProductsPrices = productRepository.getSumOfPricesForAllProducts();
        } else {
            Product.Category category = Product.Category.getCategoryFromString(categoryName);
            produts = productRepository.getProductInGivenCateogry(category);
            sumOfProductsPrices = productRepository.getSumOfPricesForGivenProductCategory(category);
        }
        model.addAttribute("products", produts);
        model.addAttribute("sum", sumOfProductsPrices);
        return "list";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", Product.Category.values());
        return "/add";
    }

    @PostMapping("/add")
    public String addProductToList(Product product) {
        productRepository.add(product);
        return "redirect:/index.html";
    }

}
