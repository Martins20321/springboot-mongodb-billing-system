package com.estudospringmartins.mongobilling.dto;

import com.estudospringmartins.mongobilling.domain.Customer;

import java.io.Serializable;

public class ClientDTO implements Serializable {

    private String id;
    private String name;
    private String document;

    public ClientDTO(){

    }

    public ClientDTO(Customer obj){
        id = obj.getId();
        name = obj.getName();
        document = obj.getDocument();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
