package com.plazti.platzimarker.persistence.mapper;

import com.plazti.platzimarker.domain.DoProduct;
import com.plazti.platzimarker.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//Se usa el uses para decirle que en la categoria le haga el map que esta en la otra clase.
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings(
            {
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
            }
    )
    DoProduct toDoProduct(Producto entidadProducto);
    List<DoProduct> toDoProductList(List<Producto> entidadProductoList);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(DoProduct doProduct);
}


