package com.example.osman.restaurantmsandroid.domain;

import java.io.Serializable;

/**
 * Created by Osman on 2016-04-18.
 */
public class OrderInvoice implements Serializable{
    private Long id;
    private String invoiceDate;
    private double orderAmount;
    private String invoiceStatus;

    public Long getId() {
        return id;
    }
    public String getInvoiceDate() {
        return invoiceDate;
    }
    public double getOrderAmount() {
        return orderAmount;
    }
    public String getInvoiceStatus() {
        return invoiceStatus;
    }
    public OrderInvoice(Builder builder)
    {
        this.id = builder.id;
        this.invoiceDate = builder.invoiceDate;
        this.orderAmount = builder.orderAmount;
        this.invoiceStatus = builder.invoiceStatus;
    }

    public static class Builder {
        private Long id;
        private String invoiceDate;
        private double orderAmount;
        private String invoiceStatus;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder invoiceDate(String value) {
            this.invoiceDate = value;
            return this;
        }

        public Builder orderAmount(double value) {
            this.orderAmount = value;
            return this;
        }

        public Builder invoiceStatus(String value) {
            this.invoiceStatus = value;
            return this;
        }

        public Builder copy(OrderInvoice value) {
            this.id = value.id;
            this.invoiceDate = value.invoiceDate;
            this.orderAmount = value.orderAmount;
            this.invoiceStatus = value.invoiceStatus;

            return this;
        }

        public OrderInvoice build() {
            return new OrderInvoice(this);

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInvoice that = (OrderInvoice) o;

        if (Double.compare(that.orderAmount, orderAmount) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (invoiceDate != null ? !invoiceDate.equals(that.invoiceDate) : that.invoiceDate != null)
            return false;
        return invoiceStatus != null ? invoiceStatus.equals(that.invoiceStatus) : that.invoiceStatus == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (invoiceDate != null ? invoiceDate.hashCode() : 0);
        temp = Double.doubleToLongBits(orderAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (invoiceStatus != null ? invoiceStatus.hashCode() : 0);
        return result;
    }
}
