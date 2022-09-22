/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NB28826
 */
public class Item {
    
    private String name;
    private double itemPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    private int itemCount;
    private Invoice invoice;

    public Item(String name, double itemPrice, int itemCount, Invoice invoice) {
        this.name = name;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.invoice = invoice;
    }
    
    public double getTotalItemPrice(){
        return itemPrice * itemCount;
    }
    
    
    
}
