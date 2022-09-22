package view;

import controller.InvoicesActions;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.Invoice;
import model.InvoicesTable;

public class NewJFrame extends javax.swing.JFrame {
    private ArrayList<Invoice> invs;
    private InvoicesActions invoicesActions = new InvoicesActions(this);
    private InvoicesTable invoicesTable;

    public InvoicesActions getInvoicesActions() {
        return invoicesActions;
    }

    public void setInvoicesActions(InvoicesActions invoicesActions) {
        this.invoicesActions = invoicesActions;
    }

    public InvoicesTable getInvoicesTable() {
        return invoicesTable;
    }

    public void setInvoicesTable(InvoicesTable invoicesTable) {
        this.invoicesTable = invoicesTable;
    }
    
    
    public ArrayList<Invoice> getInvs() {
        return invs;
    }

    public void setInvs(ArrayList<Invoice> invs) {
        this.invs = invs;
    }
    public NewJFrame() {
        initComponents();
    }

    public JTable getItemsTableView() {
        return itemsTableView;
    }

    public void setItemsTableView(JTable itemsTableView) {
        this.itemsTableView = itemsTableView;
    }

    public JLabel getCustomerNameLabel() {
        return customerNameLabel;
    }

    public void setCustomerNameLabel(JLabel customerNameLabel) {
        this.customerNameLabel = customerNameLabel;
    }

    public JLabel getInvoiceDateLabel() {
        return invoiceDateLabel;
    }

    public void setInvoiceDateLabel(JLabel invoiceDateLabel) {
        this.invoiceDateLabel = invoiceDateLabel;
    }

    public JLabel getInvoiceIDLabel() {
        return invoiceIDLabel;
    }

    public void setInvoiceIDLabel(JLabel invoiceIDLabel) {
        this.invoiceIDLabel = invoiceIDLabel;
    }

    public JLabel getInvoiceTotalLabel() {
        return invoiceTotalLabel;
    }

    public void setInvoiceTotalLabel(JLabel invoiceTotalLabel) {
        this.invoiceTotalLabel = invoiceTotalLabel;
    }

    public JTable getInvoicesTableView() {
        return invoicesTableView;
    }

    public void setInvoicesTableView(JTable invoicesTableView) {
        this.invoicesTableView = invoicesTableView;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTableView = new javax.swing.JTable();
        invoicesTableView.getSelectionModel().addListSelectionListener(invoicesActions);
        createInvoiceButton = new javax.swing.JButton();
        createInvoiceButton.addActionListener(invoicesActions);
        deleteInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton.addActionListener(invoicesActions);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invoiceIDLabel = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTableView = new javax.swing.JTable();
        addItemButton = new javax.swing.JButton();
        addItemButton.addActionListener(invoicesActions);
        deleteItemButton = new javax.swing.JButton();
        deleteItemButton.addActionListener(invoicesActions);
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        loadButton = new javax.swing.JMenuItem();
        loadButton.addActionListener(invoicesActions);
        saveButton = new javax.swing.JMenuItem();
        saveButton.addActionListener(invoicesActions);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Customer", "Price Total"
            }
        ));
        jScrollPane1.setViewportView(invoicesTableView);

        createInvoiceButton.setText("Create Invoice");

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Invoice ID");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        itemsTableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(itemsTableView);

        addItemButton.setText("Add Item");
        addItemButton.setActionCommand("Add Item");

        deleteItemButton.setText("Delete Item");

        menu.setText("File");

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        menu.add(loadButton);

        saveButton.setText("Save");
        menu.add(saveButton);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createInvoiceButton)
                        .addGap(34, 34, 34)
                        .addComponent(deleteInvoiceButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceIDLabel)
                            .addComponent(invoiceDateLabel)
                            .addComponent(customerNameLabel)
                            .addComponent(invoiceTotalLabel)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addItemButton)
                .addGap(95, 95, 95)
                .addComponent(deleteItemButton)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvoiceButton)
                    .addComponent(deleteInvoiceButton))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoiceIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(invoiceDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customerNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(invoiceTotalLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addItemButton)
                    .addComponent(deleteItemButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadButtonActionPerformed

    private void deleteInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvoiceButtonActionPerformed
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JLabel invoiceIDLabel;
    private javax.swing.JLabel invoiceTotalLabel;
    private javax.swing.JTable invoicesTableView;
    private javax.swing.JTable itemsTableView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadButton;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem saveButton;
    // End of variables declaration//GEN-END:variables
}
