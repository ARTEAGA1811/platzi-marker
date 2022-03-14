package com.plazti.platzimarker.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id_categoria")
  private Integer idCategoria;

  private String descripcion;

  private Boolean estado;

  //Se copia el nombre del atributo que esta en la clase de Producto.
  @OneToMany(mappedBy = "categoria")
  private List<Producto> productos;

  //Getters and setters

  public Integer getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Integer idCategoria) {
    this.idCategoria = idCategoria;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  public List<Producto> getProductos() {
    return productos;
  }

  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }


}
