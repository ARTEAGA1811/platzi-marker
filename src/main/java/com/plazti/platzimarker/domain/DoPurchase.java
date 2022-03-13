package com.plazti.platzimarker.domain;

import java.time.LocalDateTime;
import java.util.List;

public class DoPurchase {

    private int purchaseId;
    private String clientId;
    private LocalDateTime purchaseDate;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<DoPurchaseItem> items;


    //Getter and Setter
    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DoPurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<DoPurchaseItem> items) {
        this.items = items;
    }
}
