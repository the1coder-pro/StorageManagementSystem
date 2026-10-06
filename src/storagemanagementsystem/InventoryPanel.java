package storagemanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventoryPanel extends JFrame {
    JLabel Search_lb = new JLabel("Search:");
    JTextField Search_txtF = new JTextField(10);
    JLabel Filter_lb = new JLabel("Filter By:");
    JComboBox<String> comboBox = new JComboBox<>();

    String[] columnNames = {"ID", "Name", "Barcode", "Category", "Location Code", "Quantity", "Min Threshold", "Alert Status"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    JTable inventoryTable = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(inventoryTable);

    JButton checkInBtn = new JButton("Check In");
    JButton checkOutBtn = new JButton("Check Out");
    JButton refreshBtn = new JButton("Refresh List");

    public InventoryPanel() {
        super("Inventory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 600); 

      
        setLayout(new BorderLayout());

        inventoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        inventoryTable.getColumnModel().getColumn(4).setPreferredWidth(110); // Location Code
        inventoryTable.getColumnModel().getColumn(6).setPreferredWidth(110); // Min Threshold

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topPanel.add(Search_lb);
        topPanel.add(Search_txtF);
        topPanel.add(Filter_lb);
        comboBox.addItem("Category");
        comboBox.addItem("Books");
        topPanel.add(comboBox);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        bottomPanel.add(checkInBtn);
        bottomPanel.add(checkOutBtn);
        bottomPanel.add(refreshBtn);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        //-----------------------------------------------------
        // this is the way to add rows in the tables 
        tableModel.addRow(new Object[]{"101", "Java Programming Book", "9780134685991", "Books", "Aisle 1 - Bin 4", 25, 5, "IN STOCK"});
        tableModel.addRow(new Object[]{"102", "Data Structures Guide", "9780134685992", "Books", "Aisle 2 - Bin 1", 3, 10, "LOW STOCK"});
        // --------------------------------------------------

        // =========================================================================
        // ***** EVENT HANDLING FOR BUTTONS  SHOULD BE ADDED HERE *****
        // =========================================================================

        setVisible(true);
    }
}