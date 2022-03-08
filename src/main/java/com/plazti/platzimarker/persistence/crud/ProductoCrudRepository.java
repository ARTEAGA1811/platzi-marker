package com.plazti.platzimarker.persistence.crud;

import com.plazti.platzimarker.persistence.entity.Producto;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository  extends CrudRepository<Producto, Integer> {
    //SE lo puede tambien usar de manera nativa
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)


    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
