package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ORDER")
class Order {

    private @Id @GeneratedValue Long  id;
    private String description;
    private Status status;

    Order(){

    }
    Order(String description, Status status){
        this.description = description;
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public Status getStatus() {
        return status;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(this instanceof Order))
            return false;
        Order o = (Order) obj;
        return Objects.equals(this.id, o.id) 
            && Objects.equals(this.description, o.description) 
            && Objects.equals(this.status, o.status);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.description, this.status);
    }
    @Override
    public String toString() {
        return "Order{" +
            "id=" + this.id +
            ", description='" + this.description + '\'' +
            ", status=" + this.status + "}";
    }

}
