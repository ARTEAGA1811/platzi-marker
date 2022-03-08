package com.plazti.platzimarker.persistence.mapper;

import com.plazti.platzimarker.domain.DoCategory;
import com.plazti.platzimarker.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            //Fuente: la entidad, objetivo: el objeto del dominio
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    DoCategory toDoCategory(Categoria entity);

    //Para mapear la inversa
    @InheritInverseConfiguration
    //SE agrega este de la entidad porque se ignora este atributo en el dominio.
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(DoCategory obj);

}
