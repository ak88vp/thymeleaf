package codegym.controller;

import codegym.model.Product;
import codegym.service.IProductService;
import codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String showList(Model model, String name) {
        List<Product> productList = new ArrayList<>();
        if (name == null) name = "";
        if (name.equals("")) {
            productList = productService.findAll();
        } else {
            productList = productService.findByName(name);
        }
        model.addAttribute("products", productList);
        return "/listProduct";

    }

    @GetMapping("createProduct")
    public String showCreate() {
        return "/createProduct";
    }

    @PostMapping("createProduct")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("{id}/editProduct")
    public String showEdit(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        return "/editProduct";
    }

    @PostMapping("{id}/editProduct")
    public String getEdit(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/products";
    }

    @GetMapping("{id}/deleteProduct")
    public String getDelete(@PathVariable int id) {
        productService.remove(id);
        return "redirect:/products";
    }

    @GetMapping("{id}/viewProduct")
    public String getProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/viewProduct";
    }

}
