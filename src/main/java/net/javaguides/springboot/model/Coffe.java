package net.javaguides.springboot.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "coffe")
public class Coffe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "delivery_price")
    private BigDecimal delivery_price;
    @Column(name = "selling_price")
    private BigDecimal selling_price;
    @Column(name = "quantity")
    private BigDecimal quantity;
    @Column(name = "net_weight")
    private BigDecimal net_weight;
    @Column(name = "type")
    private String type;
    @Column(name = "producer")
    private String producer;
    @Column(name = "coffee_compos")
    private String coffee_compos;
    @Column(name = "image")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(BigDecimal delivery_price) {
        this.delivery_price = delivery_price;
    }

    public BigDecimal getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(BigDecimal selling_price) {
        this.selling_price = selling_price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getNet_weight() {
        return net_weight;
    }

    public void setNet_weight(BigDecimal net_weight) {
        this.net_weight = net_weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCoffee_compos() {
        return coffee_compos;
    }

    public void setCoffee_compos(String coffee_compos) {
        this.coffee_compos = coffee_compos;
    }
}
