package com.in28minutes.springboot.myfirstwebapp.products;

import com.in28minutes.springboot.myfirstwebapp.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
@Controller
@SessionAttributes("name")
public class ProductsController {

    productRepository productRepo ;

    public ProductsController(productRepository productRepo ) {
        super();
        this.productRepo = productRepo;
    }

    @RequestMapping("product-list")
    public String showListOfProductsPage(ModelMap model){
        String username = getLoggedInUsername(model);
        List<products> p = productRepo.findAll();
        model.addAttribute("product", p);
        return "productsList";
    }

    @RequestMapping(value = "add-products",  method = RequestMethod.GET)
    public String showAddProductPage(ModelMap model){
        products p = new products(0,"",0.0,0);
        model.put("products", p);
        return "addProducts";
    }

    @RequestMapping(value = "add-products",  method = RequestMethod.POST)
    public String AddProductPage(ModelMap model, @Valid products Products, BindingResult result){
        if(result.hasErrors()) {
            return "addProducts";
        }
        productRepo.save(Products);
        return "redirect:product-list";
    }

    @RequestMapping("delete-products")
    public String deleteProduct(@RequestParam int id){
        productRepo.deleteById(id);
        return "redirect:product-list";
    }

    @RequestMapping(value="update-product", method = RequestMethod.GET)
    public String showUpdateProductPage(@RequestParam int id, ModelMap model) {
        products Products = productRepo.findById(id).get();
        model.addAttribute("products", Products);
        return "addProducts";
    }

    @RequestMapping(value="update-product", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid products Products , BindingResult result) {

        if(result.hasErrors()) {
            return "addProducts";
        }
        productRepo.save(Products);
        return "redirect:product-list";
    }
    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
