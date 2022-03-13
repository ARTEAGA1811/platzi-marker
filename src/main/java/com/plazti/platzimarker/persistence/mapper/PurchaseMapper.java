package com.plazti.platzimarker.persistence.mapper;

import com.plazti.platzimarker.domain.DoPurchase;
import com.plazti.platzimarker.domain.DoPurchaseItem;
import com.plazti.platzimarker.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", uses = { PurchaseItemMapper.class })
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target="purchaseId"),
            @Mapping(source = "idCliente", target="clientId"),
            @Mapping(source = "fecha", target="purchaseDate"),
            @Mapping(source = "medioPago", target="paymentMethod"),
            @Mapping(source = "comentario", target="comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items")
    })

    DoPurchase toDoPurchase(Compra compra);
    List<DoPurchase> toDoPurchaseList(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(DoPurchase doPurchase);
}
