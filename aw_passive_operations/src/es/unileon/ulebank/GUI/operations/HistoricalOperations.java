/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.GUI.operations;

import com.toedter.calendar.JDateChooser;
import es.unileon.ulebank.GUI.client.GUIOperations;
import static es.unileon.ulebank.GUI.client.GUIOperations.createTable;
import static es.unileon.ulebank.GUI.client.GUIOperations.getData;
import es.unileon.ulebank.account.history.AccountHistory;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Eva
 */
public class HistoricalOperations extends GUIOperations {

    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JPanel fieldsPanel;
    private JPanel downPanel;
    private JPanel centerPanel;
    
    private JButton findTransaction;
    private JButton close;

    private JMenuBar menu;
    private JMenu help;
    private JMenuItem about;

    private Choice options;
    private JLabel find;
    private JTextField findArea;

    private JTable table;
    
    private com.toedter.calendar.JDateChooser startCalendar;
    private com.toedter.calendar.JDateChooser finishCalendar;
    
    public HistoricalOperations(final AccountHistory historyAccount) throws ParseException {
        this.setBounds(10, 10, 1000, 500);
        this.setTitle("Historial de operaciones");
        
        //PANELS
        
        mainPanel = new JPanel(new BorderLayout());
        optionsPanel = new JPanel(new FlowLayout());
        fieldsPanel = new JPanel(new FlowLayout());
        downPanel = new JPanel();
        centerPanel = new JPanel();
        mainPanel.setBackground(Color.red);
        optionsPanel.setBackground(Color.blue);
        centerPanel.setBackground(Color.YELLOW);

        //MENU
        menu = new JMenuBar();
        help = new JMenu("Ayuda");
        menu.add(help);
        about = new JMenuItem("About");
        help.add(about);

        //OPTIONS PANEL
        find = new JLabel("Tipo de busqueda: ");
        findArea = new JTextField("Introduce tu busqueda, por favor.");
        options = new Choice();
        options.addItem("Palabra clave");
        options.addItem("Fecha");
        options.addItem("Entre fechas");
        options.addItem("Desde fecha");
        options.addItem("opcion5");
        
       
        options.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
               fieldsPanel.removeAll();
               switch (e.getItem().toString()){
                   case  "Fecha": 
                    startCalendar = new JDateChooser();
                    startCalendar.setMaxSelectableDate(new Date());
                    fieldsPanel.add(startCalendar);
                    fieldsPanel.validate();
                    break;
                    
                   case "Entre fechas":
                    startCalendar = new JDateChooser();
                    startCalendar.setMaxSelectableDate(new Date());
                    fieldsPanel.add(startCalendar);
                    finishCalendar = new JDateChooser();
                    finishCalendar.setMaxSelectableDate(startCalendar.getDate());
                    fieldsPanel.add(finishCalendar);
                    fieldsPanel.validate();
                    break;
                   
                   case "Desde fecha":
                    startCalendar = new JDateChooser();
                    startCalendar.setMaxSelectableDate(new Date());
                    fieldsPanel.add(startCalendar);
                    fieldsPanel.validate(); 
                    //TODO falta metodo
                    break;
                      
                   default:
                 
                }
                        
                        optionsPanel.validate();
            }
            
        });
      
        
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
        findTransaction = new JButton("Buscar");
        findTransaction.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                table = createTable(getData(historyAccount,null, null, 1));
               switch (options.getSelectedItem()){
                       case "Fecha":
                        //Mostrar los elementos de esa fecha
                        table = createTable(getData(historyAccount,startCalendar.getDate(), null, 1));
                        break;
                       case "Entre fechas":
                        //Muestra los elementos entre dos fechas
                        table = createTable(getData(historyAccount,startCalendar.getDate(), finishCalendar.getDate(),2));    
                           break;
                       case "Desde fecha":
                        table = createTable(getData(historyAccount,startCalendar.getDate(), null,3));
                        break;
                       default:
               }  
            }
        });
      
        optionsPanel.add(find);
        optionsPanel.add(find, LEFT_ALIGNMENT);
          
        optionsPanel.add(options);
        optionsPanel.add(fieldsPanel);
        
        //TODO falta metodo 
        optionsPanel.add(findArea);
        
        
        optionsPanel.add(findTransaction);

        mainPanel.add(optionsPanel, BorderLayout.NORTH);

        ////////////////////////////////////////
         /*SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    Date date1 = sdf.parse("01/05/2014");
    Date edat1 = sdf.parse("05/05/2014");
        table = createTable(getData(historyAccount,date1, edat1,2));*/
        //////////////////////////////////////////////
        
        JScrollPane spTable = new JScrollPane(table);
        spTable.setViewportView(table);
        centerPanel.add(spTable);
        System.out.println("Tabla añadida");
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        
        mainPanel.add(downPanel, BorderLayout.SOUTH);
        
        this.setJMenuBar(menu);
        this.add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    
    }

    

}
