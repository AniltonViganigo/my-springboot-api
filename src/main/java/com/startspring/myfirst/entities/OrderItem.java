package com.startspring.myfirst.entities;

import com.startspring.myfirst.entities.pk.OrderItemPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    private static Long serialVerisonUID = 1L;

    @EmbeddedId
    private OrderItemPk id;
    private Integer quantity;
    private Double price;

    public OrderItem(){
    }

    public OrderItem(Order order, Product product, OrderItemPk id, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public OrderItemPk getId() {
        return id;
    }

    public void setId(OrderItemPk id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return getId().equals(orderItem.getId()) &&
                Objects.equals(getQuantity(), orderItem.getQuantity()) &&
                Objects.equals(getPrice(), orderItem.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuantity(), getPrice());
    }
}
