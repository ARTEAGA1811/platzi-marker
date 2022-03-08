package com.plazti.platzimarker.domain;

public class DoProduct {

    private int productId;
    private String name;
    private String categoryId;
    private double price;
    private int stock;
    private boolean active;
    //Ojo: se lo usa en terminos de dominio, por eso se usa el del dominio, no de la persistencia.
    private DoCategory category;

    //Getter and Setter


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public DoCategory getCategory() {
        return category;
    }

    public void setCategory(DoCategory category) {
        this.category = category;
    }
}
