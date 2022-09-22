/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author NB28826
 */
public class Invoice {

    public Invoice(int id, String date, String customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.items = new ArrayList<>();
    }
    private int id;
    private String date;
    private String customer;
    private ArrayList<Item> items;
    
    public double getTotalInvoicePrice(){
        Iterator iterator = items.iterator();
        double total=0.0;
        while(iterator.hasNext()){
            Item item = (Item) iterator.next();
            total+=item.getTotalItemPrice();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", date=" + date + ", customer=" + customer + '}';
    }
    
    
    
    
}
