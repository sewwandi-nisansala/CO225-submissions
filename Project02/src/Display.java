
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Display extends javax.swing.JFrame {

    private DefaultTableModel dtm_stockTable;
    private DefaultTableModel dtm_ItemlogTable;
    private SimpleDateFormat dateFormat;
    private ClientFileAccess clientFileAccess;

    public Display() {

    }

    public Display(List<Stock> stockList) {
        initComponents();
        setTitle("Auction Server");
        dtm_stockTable = (DefaultTableModel) stockTable.getModel();
        dtm_ItemlogTable = (DefaultTableModel) itemLogTable.getModel();
        dateFormat = new SimpleDateFormat("yyyyMMdd");
        clientFileAccess = new ClientFileAccess();
        Timer timer = new Timer(500, e -> {
            dtm_stockTable.setRowCount(0);
            for (Stock stock : stockList) {
                if (stock.getSymbol().equals("FB") || stock.getSymbol().equals("VRTU") || stock.getSymbol().equals("MSFT") || stock.getSymbol().equals("GOOGL") || stock.getSymbol().equals("YHOO") || stock.getSymbol().equals("XLNX") || stock.getSymbol().equals("TSLA") || stock.getSymbol().equals("TXN")) {
                    Object[] rowdata = {stock.getSymbol(), stock.getSecurityName(), stock.getPrice()};
                    dtm_stockTable.addRow(rowdata);
                }

            }
        });
        timer.start();
    }



    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemLogTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        logTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        symbolComboBox = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(36, 113, 163));

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Symbol", "Security Name", "Price"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        stockTable.setGridColor(new java.awt.Color(204, 204, 204));
        stockTable.setOpaque(false);
        stockTable.setRequestFocusEnabled(false);
        stockTable.setRowHeight(40);
        jScrollPane1.setViewportView(stockTable);


        itemLogTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Date", "Time", "Name", "Symbol", "Previous Price", "Bid"
                }
        ));
        itemLogTable.setRowHeight(35);
        jScrollPane2.setViewportView(itemLogTable);

        jLabel1.setBackground(new java.awt.Color(40, 28, 51));
        jLabel1.setForeground(new java.awt.Color(229, 232, 232));
        jLabel1.setText("                    Initial Stock Details");
        jLabel1.setOpaque(true);


        jLabel2.setBackground(new java.awt.Color(40, 28, 51));
        jLabel2.setForeground(new java.awt.Color(229, 232, 232));
        jLabel2.setText("              Current Stock Details");
        jLabel2.setOpaque(true);

        symbolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Symbol", "FB", "VRTU", "MSFT", "GOOGL", "YHOO", "XLNX", "TSLA", "TXN." }));
        symbolComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbolComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(symbolComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                        .addComponent(symbolComboBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                           .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void symbolComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symbolComboBoxActionPerformed
        dtm_ItemlogTable.setRowCount(0);
        List<Client> allClients;
        try {
            allClients = clientFileAccess.getAllClients(dateFormat.format(new Date()) + "_auction.txt");
            for (Client client : allClients) {
                if (client.getSymbol().equals(symbolComboBox.getSelectedItem().toString())) {
                    Object[] rowdata = {client.getName(), client.getDate(), client.getTime(), client.getSymbol(), client.getPre_price(), client.getNew_price()};
                    dtm_ItemlogTable.addRow(rowdata);
                } else {
                    if (symbolComboBox.getSelectedItem().toString().equals("Select Symbol")) {
                        Object[] rowdata = {client.getName(), client.getDate(), client.getTime(), client.getSymbol(), client.getPre_price(), client.getNew_price()};
                        dtm_ItemlogTable.addRow(rowdata);
                    }
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JTable itemLogTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable logTable;
    private javax.swing.JTable stockTable;
    private javax.swing.JComboBox<String> symbolComboBox;


    //update the stock list when the price is changed
    public void updateStockList(List<Stock> stockList) {
        dtm_stockTable.setRowCount(0);
        for (Stock stock : stockList) {
            if (stock.getSymbol().equals("FB") || stock.getSymbol().equals("VRTU") || stock.getSymbol().equals("MSFT") || stock.getSymbol().equals("GOOGL") || stock.getSymbol().equals("YHOO") || stock.getSymbol().equals("XLNX") || stock.getSymbol().equals("TSLA") || stock.getSymbol().equals("TXN")) {
                Object[] rowdata = {stock.getSymbol(), stock.getSecurityName(), stock.getPrice()};
                dtm_stockTable.addRow(rowdata);
            }
        }
    }

    //display the bidders
    public void updateAuctionLog(ClientFileAccess clientFileAccess) throws IOException {
        symbolComboBox.setSelectedItem("Select Symbol");
        dtm_ItemlogTable.setRowCount(0);
        List<Client> allClients = clientFileAccess.getAllClients(dateFormat.format(new Date()) + "_auction.txt");
        for (Client client : allClients) {
            Object[] rowdata = {client.getName(), client.getDate(), client.getTime(), client.getSymbol(), client.getPre_price(), client.getNew_price()};
            dtm_ItemlogTable.addRow(rowdata);

        }
    }


}
