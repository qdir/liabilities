/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.operations;

import es.unileon.ulebank.GUI.client.GUIOperations;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eva
 */
public class HistoricalOperations extends GUIOperations {

    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JPanel downPanel;
    private JPanel centerPanel;

    private JMenuBar menu;
    private JMenu help;
    private JMenuItem about;

    private Choice options;
    private JLabel find;
    private JTextField findArea;

    private JTable table;
    private DefaultTableModel tableModel;

    public HistoricalOperations() {
        this.setBounds(10, 10, 1000, 500);
        //PANELS
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.red);
        optionsPanel = new JPanel(new FlowLayout());
        optionsPanel.setBackground(Color.BLUE);
        downPanel = new JPanel();
        centerPanel = new JPanel();

        //MENU
        menu = new JMenuBar();
        help = new JMenu("Ayuda");
        menu.add(help);
        about = new JMenuItem("About");
        help.add(about);

    //OPTIONS PANEL
        find = new JLabel("Tipo de busqueda: ");
        optionsPanel.add(find);
        options = new Choice();
        options.addItem("Palabra clave");
        options.addItem("fecha");
        options.addItem("opcion3");
        options.addItem("opcion4");
        options.addItem("opcion5");
        findArea = new JTextField("Introduce tu busqueda, por favor.");
        findArea.addFocusListener(new FocusListener() {

            //Methods to clean the field
            @Override
            public void focusGained(FocusEvent e) {
                if (findArea.getText().compareToIgnoreCase("Introduce tu busqueda, por favor.") == 0) {
                    findArea.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (findArea.getText().compareToIgnoreCase("") == 0) {
                    findArea.setText("Introduce tu busqueda, por favor.");
                }
            }
        });

        optionsPanel.add(find, LEFT_ALIGNMENT);
        optionsPanel.add(options);
        optionsPanel.add(findArea, RIGHT_ALIGNMENT);

        mainPanel.add(optionsPanel, BorderLayout.NORTH);

        ////////////////////////////////////////
        Object[][] data = {
            {"foperacion", "fvalor", "cargo", "prueba de tabla", new Double(20.00), new Double(100.000)}};
        //TODO deberia haber un metodo para recuperar los valores en funcion de nuestra busqueda.

        //////////////////////////////////////////////
        table = createTable(data);
        JScrollPane spTable = new JScrollPane(table);
        spTable.setViewportView(table);
        centerPanel.add(spTable);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        
        mainPanel.add(downPanel, BorderLayout.SOUTH);
        
        this.setJMenuBar(menu);
        this.add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    
    }

    private JTable createTable(Object[][] data) {
        String[] columnNames = {"Fecha operación",
            "Fecha valor",
            "Tipo",
            "concepto",
            "Importe",
            "Saldo"};

        JTable resultTable = new JTable(data, columnNames);
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultTable.setModel(tableModel);

        return resultTable;
    }

}
