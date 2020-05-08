package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {

    String operationType;
    ArrayList<Dentists> dentists;
    ArrayList<Orders> orders;
    ArrayList<BuyerData> buyers;
    BuyerData buyer;
    Orders order;;
    Dentists dentist;
    Long id;

    public PackageData(){}

    public PackageData(String operationType, ArrayList<Dentists> dentists, ArrayList<Orders> orders, ArrayList<BuyerData> buyers, BuyerData buyer, Orders order, Dentists dentist, Long id) {
        this.operationType = operationType;
        this.dentists = dentists;
        this.orders = orders;
        this.buyers = buyers;
        this.buyer = buyer;
        this.order = order;
        this.dentist = dentist;
        this.id = id;
    }

    public void setBuyers(ArrayList<BuyerData> buyers) {
        this.buyers = buyers;
    }

    public void setBuyer(BuyerData buyer) {
        this.buyer = buyer;
    }

    public ArrayList<BuyerData> getBuyers() {
        return buyers;
    }

    public BuyerData getBuyer() {
        return buyer;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setDentists(ArrayList<Dentists> dentists) {
        this.dentists = dentists;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public void setDentist(Dentists dentist) {
        this.dentist = dentist;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public ArrayList<Dentists> getDentists() {
        return dentists;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }


    public Orders getOrder() {
        return order;
    }

    public Dentists getDentist() {
        return dentist;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", dentists=" + dentists +
                ", orders=" + orders +
                ", buyers=" + buyers +
                ", buyer=" + buyer +
                ", order=" + order +
                ", dentist=" + dentist +
                ", id=" + id +
                '}';
    }
}
