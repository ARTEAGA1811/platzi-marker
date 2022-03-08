package com.plazti.platzimarker.persistence;

import com.plazti.platzimarker.persistence.crud.ProductoCrudRepository;
import com.plazti.platzimarker.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Con este @Repository se indica que esta clase se encarga de interactuar con la base de datos.
@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria( int idCategoria ){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }


    public Optional <Producto> getProductoById(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void deleteById(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
