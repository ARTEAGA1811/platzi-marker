package com.plazti.platzimarker.domain.service;


import com.plazti.platzimarker.domain.DoProduct;
import com.plazti.platzimarker.domain.repository.DoProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Nuestros servicios son negociadores entre el repositorio y los controladores
@Service
public class ProductService {
    //Es la interfaz.
    @Autowired
    private DoProductRepository doProductRepository;


    public List<DoProduct> getAll() {
        return doProductRepository.getAll();
    }

    public Optional<List<DoProduct>> getByCategory(int categoryId){
        return doProductRepository.getByCategory(categoryId);
    }
    public Optional<List<DoProduct>> getScarseProducts(int quantity){
        return doProductRepository.getScarseProducts(quantity);
    }

    public Optional<DoProduct> getProductById(int productId){
        return doProductRepository.getProductById(productId);
    }

    public DoProduct save(DoProduct product){
        return doProductRepository.save(product);
    }

    //Aqui le cambio a boolean, en el DoProductRepository esta como void
    public boolean deleteById( int productId){
        try{
            doProductRepository.deleteById(productId);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
