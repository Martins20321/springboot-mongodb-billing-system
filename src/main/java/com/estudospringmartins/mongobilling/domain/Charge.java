package com.estudospringmartins.mongobilling.domain;

import com.estudospringmartins.mongobilling.domain.enums.ChargeStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "charge")
public class Charge implements Serializable {

    @Id
    private String id;
    private String description;
    private Date dueDate;
    private Double amount;
    private ChargeStatus status;

    private Customer customer;
    public Charge(){

    }
    public Charge(String id, String description, Date dueDate, Double amount, ChargeStatus status, Customer customer) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.amount = amount;
        this.status = status;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ChargeStatus getStatus() {
        return status;
    }

    public void setStatus(ChargeStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Charge charge = (Charge) o;
        return Objects.equals(id, charge.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
