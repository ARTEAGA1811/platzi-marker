package com.plazti.platzimarker.domain.repository;

import com.plazti.platzimarker.domain.DoProduct;

import java.util.List;
import java.util.Optional;

public interface DoProductRepository {

    List<DoProduct> getAll();
    Optional<DoProduct> getByCategory(int categoryId);
    Optional<List<DoProduct>> getScarseProducts(int quantity);
    Optional<DoProduct> getProductById(int productId);
    DoProduct save(DoProduct product);
    void deleteById( int productId);

}
