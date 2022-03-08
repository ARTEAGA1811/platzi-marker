package com.plazti.platzimarker.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ComprasProductoPK implements java.io.Serializable {
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;


    //Getters and Setters
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
