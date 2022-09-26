package com.in28minutes.springboot.myfirstwebapp.products;

import com.in28minutes.springboot.myfirstwebapp.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ProductService {
    private static List<products> Products = new ArrayList<>();

    private static int productId = 0;
    public List<products> findListOfProducts(){
        return Products.stream().toList();
    }

    public void addProducts(String productName, double productPrice, int quantity, String username){
        products Product = new products(++productId, productName,productPrice,quantity);
        Products.add(Product);
    }
    public void deleteById(int id) {
        Predicate<? super products> predicate = Product -> Product.getProductId() == id;
        Products.removeIf(predicate);
    }

    public void updateProducts(@Valid products Product){
        deleteById(Product.getProductId());
        Products.add(Product);
    }

}
