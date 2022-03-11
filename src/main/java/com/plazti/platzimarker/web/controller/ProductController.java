package com.plazti.platzimarker.web.controller;

import com.plazti.platzimarker.domain.DoProduct;
import com.plazti.platzimarker.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Inyectamos el servicio
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<DoProduct> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<DoProduct> getProductById(@PathVariable("id") int productId){
        System.out.println("productId: " + productId);
        return productService.getProductById(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<DoProduct>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }


    @PostMapping("/save")
    public DoProduct save(@RequestBody DoProduct product){
        return productService.save(product);
    }

    //Aqui le cambio a boolean, en el DoProductRepository esta como void
    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable("id") int productId){
        return productService.deleteById(productId);
    }

}
