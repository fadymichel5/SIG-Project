/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NB28826
 */
public class ItemsTable extends AbstractTableModel  {

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    
    private ArrayList<Item> items;
    private String[] itemsTableColumns = {"ID", "Name", "Price", "Count", "Total"};

    public ItemsTable(ArrayList<Item> items) {
        this.items = items;
    }
    
    @Override
    public int getRowCount() {
        return items.size();
    }
    
    @Override
    public String getColumnName(int column) {
        return itemsTableColumns[column];
    }

    @Override
    public int getColumnCount() {
        return itemsTableColumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return items.get(rowIndex).getInvoice().getId();
            case 1:
                return items.get(rowIndex).getName();
            case 2:
                return items.get(rowIndex).getItemPrice();
            case 3:
                return items.get(rowIndex).getItemCount();
            case 4:
                return items.get(rowIndex).getTotalItemPrice();
        }
        return null;
    }
    
}
