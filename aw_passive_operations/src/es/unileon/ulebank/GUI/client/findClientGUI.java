/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.GUI.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

public class findClientGUI extends GUIOperations {
    
    private JPanel buttonPanel;
    private JTextField dniFinder;
    private JLabel dniLabel;
    private JButton find;
    
    public findClientGUI(){
        //Variables
        dniFinder = new JTextField("Introduce el DNI del cliente", 20);
        dniLabel = new JLabel("DNI", JLabel.CENTER);
        
        buttonPanel = new JPanel();
        find = new JButton("CONTINUAR");
        
        
        this.setBounds(0, 0, 300, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints cstr=new GridBagConstraints();
           
        //Etiqueta DNI
        cstr.fill = GridBagConstraints.HORIZONTAL;
    	cstr.insets=new Insets(0,0,10,0);
        cstr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(dniLabel, cstr);
        //Texto
        cstr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(dniFinder, cstr);

        //Botones
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(find);
        
        cstr.anchor=GridBagConstraints.SOUTH;
        cstr.insets = new Insets(15, 0, 0, 0);
        add(buttonPanel, cstr);
        
        dniFinder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
 
    public static void options(String text){
        if(text.compareToIgnoreCase("Introduce el DNI del cliente")==0){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
    }
}
