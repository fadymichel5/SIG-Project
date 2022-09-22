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
public class InvoicesTable extends AbstractTableModel {
    
    private final ArrayList<Invoice> invoices;
    private final String[] invoicesTableColumns = {"ID", "Date", "Customer", "Price Total"};

    public InvoicesTable(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return invoicesTableColumns.length;
    }

    @Override
    public String getColumnName(int column) {
        return invoicesTableColumns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return invoices.get(rowIndex).getId();
            case 1:
                return invoices.get(rowIndex).getDate();
            case 2:
                return invoices.get(rowIndex).getCustomer();
            case 3:
                return invoices.get(rowIndex).getTotalInvoicePrice();
        }
        return null;
    }
    
}
