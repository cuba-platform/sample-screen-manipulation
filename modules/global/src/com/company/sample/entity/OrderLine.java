package com.company.sample.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;

@Table(name = "SAMPLE_ORDER_LINE")
@Entity(name = "sample$OrderLine")
public class OrderLine extends StandardEntity {
    private static final long serialVersionUID = 5776319199715965916L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    protected Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID")
    protected Product product;

    @Column(name = "QUANTITY", nullable = false)
    protected Double quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantity() {
        return quantity;
    }


    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }


}