package com.plazti.platzimarker.persistence.mapper;


import com.plazti.platzimarker.domain.DoPurchaseItem;
import com.plazti.platzimarker.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//El uses es porque usamos el producto en el ignore.
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            //@Mapping(source = "total", target = "total") como los dos son iguales, puedo omitir este mapeo.
            @Mapping(source = "estado", target = "active")
    })
    DoPurchaseItem toDoPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(DoPurchaseItem item);
}
