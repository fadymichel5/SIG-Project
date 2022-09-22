/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Invoice;
import model.InvoicesTable;
import model.Item;
import model.ItemsTable;
import view.CreateInvoiceDialog;
import view.CreateItemDialog;
import view.NewJFrame;

/**
 *
 * @author NB28826
 */
public class InvoicesActions implements ActionListener,ListSelectionListener {
    private NewJFrame frame;
    private CreateInvoiceDialog createInvoiceDialog;
    private CreateItemDialog createItemDialog;

    public InvoicesActions(NewJFrame frame) {
        this.frame = frame;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch(action){
            case "Load": 
                load();
                break;
            case "Save" : 
                save();
                break;
            case "Create Invoice" : 
                create_invoice();
                break;
            case "Delete Invoice" :
                delete_invoice();
                break;
            case "Add Item" :
                add_item();
                break;
            case "Delete Item" : 
                delete_item();
                break;
            case "Confirm Create Invoice":
                confirm_create_invoice();
                break;
            case "Confirm Create Item" : 
                confirm_create_item();
                break;
                
        }
    }
    
    private void load() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    JFileChooser fileChooser = new JFileChooser();
        try {
            int display = fileChooser.showOpenDialog(frame);
            if (display == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                Path invoiceHeaderPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(invoiceHeaderPath);
                ArrayList<Invoice> invAll = new ArrayList<>();
                for (String invoiceHeaderLine : headerLines) {
                    String[] invData = invoiceHeaderLine.split(",");
                    int invoiceNumber = Integer.parseInt(invData[0]);
                    String invoiceDate = invData[1];
                    String invoiceCustomer = invData[2];

                    Invoice invoice = new Invoice(invoiceNumber, invoiceDate, invoiceCustomer);
                    invAll.add(invoice);
                }
                display = fileChooser.showOpenDialog(frame);
                if (display == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileChooser.getSelectedFile();
                    Path lineHeaderPath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineFileLines = Files.readAllLines(lineHeaderPath);
                    for (String lineFileLine : lineFileLines) {
                        String[] lineData = lineFileLine.split(",");
                        int num = Integer.parseInt(lineData[0]);
                        String item = lineData[1];
                        double price = Double.parseDouble(lineData[2]);
                        int count = Integer.parseInt(lineData[3]);
                        Invoice inv = null;
                        for (Invoice invoice : invAll) {
                            if (num == invoice.getId()) {
                                inv = invoice;
                                break;
                            }
                        }
                        Item newLine = new Item(item, price, count, inv);
                        inv.getItems().add(newLine);
                    }

                }
                frame.setInvs(invAll);
                InvoicesTable invoicesTable = new InvoicesTable(invAll);
                frame.setInvoicesTable(invoicesTable);
                frame.getInvoicesTableView().setModel(invoicesTable);
                frame.getInvoicesTable().fireTableDataChanged();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    

    private void save() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        JFileChooser fileChooser = new JFileChooser();
        ArrayList<Invoice> Invoices = frame.getInvs();
        ArrayList<Item> items = null;
        try {
            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                FileWriter headerWriter = new FileWriter(headerFile);
                for (Invoice saveInv : Invoices) {
                    String invoiceID = "" + saveInv.getId();
                    String invoiceDate = saveInv.getDate();
                    String customerName = saveInv.getCustomer();
                    headerWriter.write(invoiceID + "," + invoiceDate + "," + customerName + "\n");
                    headerWriter.flush();
                }
                headerWriter.close();
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileChooser.getSelectedFile();
                    FileWriter lineWriter = new FileWriter(lineFile);
                    for (Invoice saveInvoice : Invoices) {
                        items = saveInvoice.getItems();
                        for (Item item : items) {
                            String itemID = "" + item.getInvoice().getId();
                            String itemName = item.getName();
                            String itemPrice = "" + item.getItemPrice();
                            String count = "" + item.getItemCount();
                            lineWriter.write(itemID + "," + itemName + "," + itemPrice + "," + count + "\n");
                            lineWriter.flush();
                        }
                    }
                    lineWriter.close();
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
      
    }
    
    private void create_invoice() {
        createInvoiceDialog = new CreateInvoiceDialog(frame,true);
        createInvoiceDialog.setVisible(true);
    }
    
    private void delete_invoice() {
        int row = frame.getInvoicesTableView().getSelectedRow();
        if (row != -1) {
            frame.getInvs().remove(row);
            frame.getInvoicesTable().fireTableDataChanged();
        }
    }
    
    private void confirm_create_invoice() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String invoiceDate = createInvoiceDialog.getDateField().getText();
        String invoiceCustoner = createInvoiceDialog.getCustomerField().getText();
        int invoiceID = frame.getInvs().size()+1;

        Invoice invoice = new Invoice(invoiceID, invoiceDate, invoiceCustoner);
        frame.getInvs().add(invoice);
        frame.getInvoicesTable().fireTableDataChanged();

        cancel_create_invoice();
    }

    private void cancel_create_invoice() {
        createInvoiceDialog.setVisible(false);
        createInvoiceDialog.dispose();
        createInvoiceDialog = null;
    }
    
    private void add_item() {
        createItemDialog = new CreateItemDialog(frame,true);
        createItemDialog.setVisible(true);
    }

    private void delete_item() {
        int row = frame.getItemsTableView().getSelectedRow();
        if (row != -1) {
            ItemsTable lineTableModel = (ItemsTable) frame.getItemsTableView().getModel();
            lineTableModel.getItems().remove(row);
            lineTableModel.fireTableDataChanged();
            frame.getInvoicesTable().fireTableDataChanged();
        }
    }
    
    private void confirm_create_item() {
        String itemName = createItemDialog.getNameField().getText();
        double itemPrice = Double.parseDouble(createItemDialog.getPriceField().getText());
        int itemCount = Integer.parseInt(createItemDialog.getCountField().getText());

        int selectedInvoiceRow = frame.getInvoicesTableView().getSelectedRow();
        if (selectedInvoiceRow != -1) {
            Invoice invoice = frame.getInvs().get(selectedInvoiceRow);
            Item item = new Item(itemName, itemPrice, itemCount, invoice);
            invoice.getItems().add(item);

            ItemsTable lineTableModel = (ItemsTable) frame.getItemsTableView().getModel();
            lineTableModel.fireTableDataChanged();
            frame.getInvoicesTable().fireTableDataChanged();
            frame.getInvoiceTotalLabel().setText("" + invoice.getTotalInvoicePrice());
        }
        createItemDialog.setVisible(false);
        createItemDialog.dispose();
        createItemDialog = null;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int row = frame.getInvoicesTableView().getSelectedRow();
        if (row != -1) {
            Invoice currentInvoiceData = frame.getInvs().get(row);
            frame.getInvoiceIDLabel().setText("" + currentInvoiceData.getId());
            frame.getInvoiceDateLabel().setText(currentInvoiceData.getDate());
            frame.getCustomerNameLabel().setText(currentInvoiceData.getCustomer());
            frame.getInvoiceTotalLabel().setText("" + currentInvoiceData.getTotalInvoicePrice());
            ItemsTable lineTableModel = new ItemsTable(currentInvoiceData.getItems());
            frame.getItemsTableView().setModel(lineTableModel);
            lineTableModel.fireTableDataChanged();
        }
    }
    
    
    
}
