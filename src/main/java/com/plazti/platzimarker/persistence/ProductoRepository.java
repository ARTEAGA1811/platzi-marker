package com.plazti.platzimarker.persistence;

import com.plazti.platzimarker.domain.DoProduct;
import com.plazti.platzimarker.domain.repository.DoProductRepository;
import com.plazti.platzimarker.persistence.crud.ProductoCrudRepository;
import com.plazti.platzimarker.persistence.entity.Producto;
import com.plazti.platzimarker.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Con este @Repository se indica que esta clase se encarga de interactuar con la base de datos.
@Repository
public class ProductoRepository implements DoProductRepository {
    //INYECCION DE DEPENDENCIAS
    //estos atributos no estan inicializados, por lo que estan en null
    //Esto nos traera problemas. Por eso se usa @Autowired para inicializarlos. esto es parte de spring.
    //Cuando se usa el @Autowired, hay que estar seguros que este atributo que vamos a inyectar es un componente de spring.

    @Autowired
    private ProductoCrudRepository productoCrudRepository; //este esta aun en la persistencia
    @Autowired
    private ProductMapper mapper; //mapeador

    @Override
    public List<DoProduct> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toDoProductList(productos);
    }

    @Override
    public Optional<List<DoProduct>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toDoProductList(productos));
    }

    @Override
    public Optional<List<DoProduct>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        //Como no tengo que me mapee los prodouctos, hago lo siguiente
        return productos
                .map(prods -> mapper.toDoProductList(prods));
    }

    @Override
    public Optional<DoProduct> getProductById(int productId) {
        //El findById ya retorna un Optional
        return productoCrudRepository.findById(productId)
                .map(prod -> mapper.toDoProduct(prod));
    }

    @Override
    public DoProduct save(DoProduct product) {
        Producto miProducto = mapper.toProducto(product);
        return mapper.toDoProduct(productoCrudRepository.save(miProducto));
    }

    @Override
    public void deleteById(int productId){
        productoCrudRepository.deleteById(productId);
    }

}
