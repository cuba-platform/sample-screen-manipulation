/*
 * Copyright (c) 2016 screen-manipulation
 */
package com.company.sample.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * @author knst
 */
@Table(name = "SAMPLE_ORDER")
@Entity(name = "sample$Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -3292919444177021479L;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_")
    protected Date date;

    @Column(name = "NUM", length = 100)
    protected String num;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    @OrderBy("createTs")
    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")
    protected List<OrderLine> orderLines;

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }


}