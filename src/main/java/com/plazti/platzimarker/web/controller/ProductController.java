package com.plazti.platzimarker.web.controller;

import com.plazti.platzimarker.domain.DoProduct;
import com.plazti.platzimarker.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Inyectamos el servicio
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<DoProduct>> getAll() {
       //return productService.getAll();
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoProduct> getProductById(@PathVariable("id") int productId){
        //El product SErvice me retorna un optional, taca hacer un mapeo.
        return productService.getProductById(productId)
                .map(prod -> new ResponseEntity<>(prod, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DoProduct>> getByCategory(@PathVariable("categoryId") int categoryId){
        //Me devuelve un optional con la lista de productos.
//        return productService.getByCategory(categoryId)
//                .map(prodList -> new ResponseEntity<>(prodList, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        //Aqui me devuelce ok a pesar de que no encuentra nada.
        //Le resuelvo asi:
        Optional<List<DoProduct>> misProductos = productService.getByCategory(categoryId);
        if(misProductos.isPresent() && !misProductos.get().isEmpty()){
            return new ResponseEntity<>(misProductos.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }


    @PostMapping("/save")
    public ResponseEntity<DoProduct> save(@RequestBody DoProduct product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);

    }

    //Aqui le cambio a boolean, en el DoProductRepository esta como void
    //Ahora se cambia solo a un ResponseEntity
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int productId){
        return new ResponseEntity<>(
                productService.deleteById(productId)
                ? HttpStatus.OK
                : HttpStatus.NOT_FOUND
        );
    }

}
