package es.unileon.ulebank.GUI.account;

import es.unileon.ulebank.GUI.client.ClientsGUI;
import es.unileon.ulebank.GUI.client.FindClientGUI;
import es.unileon.ulebank.GUI.client.GUIOperations;
import es.unileon.ulebank.GUI.client.PersonPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class AccountGUI extends GUIOperations {

        private JPanel contentPaneUno;
	
        private JLabel accountData;                  
        private JLabel accountNumber;

    public JTextField getHolderText1() {
        return holderText1;
    }

    public void setHolderText1(JTextField holderText1) {
        this.holderText1 = holderText1;
    }
	private JLabel mode;
	private JLabel coin;
	private JLabel availability;
        private JTextField accountNumberText;
	private JTextField coinText;	
        private JComboBox modeButton;
        private JComboBox availabilityButton;	

        private JButton addHolder; 
        private JButton addAuthorized;
        
        private JLabel holders;  
        private JLabel holder1;
	private JLabel DNI1;
        private JTextField holderText1;
	private JTextField DNIText1; 
        private JButton deleteHolder1;
        private JLabel holder2;
	private JLabel DNI2;
        private JTextField holderText2;
	private JTextField DNIText2;
        private JButton deleteHolder2;
        private JLabel holder3;
	private JLabel DNI3;
        private JTextField holderText3;
	private JTextField DNIText3;
        private JButton deleteHolder3;
        private JLabel holder4;
	private JLabel DNI4;
        private JTextField holderText4;
	private JTextField DNIText4;
        private JButton deleteHolder4;
        
        
        private JLabel authorized;
        private JLabel authorized1;
	private JLabel DNIAuthorized1;
        private JTextField authorizedText1;
        private JTextField DNIAuthorizedText1;
        private JButton deleteAuthorized1;
        private JLabel authorized2;
	private JLabel DNIAuthorized2;
        private JTextField authorizedText2;
        private JTextField DNIAuthorizedText2;
        private JButton deleteAuthorized2;
        private JLabel authorized3;
	private JLabel DNIAuthorized3;
        private JTextField authorizedText3;
        private JTextField DNIAuthorizedText3;
        private JButton deleteAuthorized3;
        private JLabel authorized4;
	private JLabel DNIAuthorized4;
        private JTextField authorizedText4;
        private JTextField DNIAuthorizedText4;
        private JButton deleteAuthorized4;
        private JButton conti;
 
        private JLabel blanco;
        private int countHolder;
        private int countAuthorized;
        private AccountGUI window;
        
	public AccountGUI() {
            
            contentPaneUno = new JPanel();
            
            accountData = new JLabel("DATOS DE LA CUENTA");          
            accountNumber = new JLabel("Numero de Cuenta: ");
            accountNumberText = new JTextField(20);    	
            mode = new JLabel("Modalidad: ");
            modeButton = new JComboBox();
            modeButton.addItem("La Cartilla");
            modeButton.addItem("Empresa");
            modeButton.addItem("Cuenta Plus");
            modeButton.addItem("Cuenta Personal");   	
            coin = new JLabel("Moneda de la Cuenta: ");
            coinText = new JTextField(20);   	
            availability = new JLabel("Disponibilidad: ");
            availabilityButton = new JComboBox();
            availabilityButton.addItem("Independiente");
            availabilityButton.addItem("Mancomunada");
            availabilityButton.addItem("Indistinta"); 
            
            addHolder = new JButton("Añadir titular");
            addAuthorized = new JButton("Añadir autorizado");
            
            holders = new JLabel("TITULARES"); 
            holder1 = new JLabel("Titular 1: ");
            holderText1 = new JTextField(20);
            DNI1 = new JLabel("NIF-CIF: ");
            DNIText1 = new JTextField(10);
            deleteHolder1 = new JButton("Eliminar");
            holder2 = new JLabel("Titular 2: ");
            holderText2 = new JTextField(20);
            DNI2 = new JLabel("NIF-CIF: ");
            DNIText2 = new JTextField(10);
            deleteHolder2 = new JButton("Eliminar");
            holder3 = new JLabel("Titular 3: ");
            holderText3 = new JTextField(20);
            DNI3 = new JLabel("NIF-CIF: ");
            DNIText3 = new JTextField(10);
            deleteHolder3 = new JButton("Eliminar");
            holder4 = new JLabel("Titular 4: ");
            holderText4 = new JTextField(20);
            DNI4 = new JLabel("NIF-CIF: ");
            DNIText4 = new JTextField(10);
            deleteHolder4 = new JButton("Eliminar");
            	
            authorized = new JLabel("AUTORIZADOS");
            authorized1 = new JLabel("Autorizado 1: ");
            authorizedText1 = new JTextField(20);
            DNIAuthorized1 = new JLabel("NIF-CIF: ");
            DNIAuthorizedText1 = new JTextField(10);
            deleteAuthorized1 = new JButton("Eliminar");
            authorized2 = new JLabel("Autorizado 2: ");
            authorizedText2 = new JTextField(20);
            DNIAuthorized2 = new JLabel("NIF-CIF: ");
            DNIAuthorizedText2 = new JTextField(10);
            deleteAuthorized2 = new JButton("Eliminar");
            authorized3 = new JLabel("Autorizado 3: ");
            authorizedText3 = new JTextField(20);
            DNIAuthorized3 = new JLabel("NIF-CIF: ");
            DNIAuthorizedText3 = new JTextField(10);
            deleteAuthorized3 = new JButton("Eliminar");
            authorized4 = new JLabel("Autorizado 4: ");
            authorizedText4 = new JTextField(20);
            DNIAuthorized4 = new JLabel("NIF-CIF: ");
            DNIAuthorizedText4 = new JTextField(10);
            deleteAuthorized4 = new JButton("Eliminar");
            
            conti =  new JButton("Continuar");
            
            blanco = new JLabel("          ");
            countHolder = 0;
            countAuthorized = 0;
            

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int width = this.getToolkit().getScreenSize().width;
            int height = this.getToolkit().getScreenSize().height;
            setBounds(0,0,width,height-50);
            setVisible(true);
            JScrollPane scrollpane = new JScrollPane(contentPaneUno);
            setContentPane(scrollpane);

            
            GridBagLayout layout = new GridBagLayout();

            contentPaneUno.setLayout(layout);
            


            final GridBagConstraints constraints =new GridBagConstraints();


            constraints.gridx = 0; 
            constraints.gridy = 0;  
            constraints.gridwidth = 6; 
            constraints.gridheight = 1;
            constraints.insets = new Insets(0,0,20,0);
            contentPaneUno.add(accountData, constraints);

            constraints.anchor = GridBagConstraints.WEST;

            constraints.gridx = 0; //Empieza en la columna 0
            constraints.gridy = 1;  //Empieza en la fila 0
            constraints.gridwidth = 1; //Ocupa una columna
            constraints.gridheight = 1; //Ocupa dos filas
            constraints.insets = new Insets(0,0,0,0);
            contentPaneUno.add(accountNumber, constraints);

            constraints.gridx = 1; 
            constraints.gridy = 1;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            contentPaneUno.add(accountNumberText, constraints);

            constraints.gridx = 2; 
            constraints.gridy = 1;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            contentPaneUno.add(blanco, constraints);

            constraints.gridx = 3; 
            constraints.gridy = 1;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            contentPaneUno.add(mode, constraints);

            constraints.gridx = 4; 
            constraints.gridy = 1;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            contentPaneUno.add(modeButton, constraints);

            constraints.gridx = 0; 
            constraints.gridy = 2;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            contentPaneUno.add(coin, constraints);

            constraints.gridx = 1; 
            constraints.gridy = 2;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            contentPaneUno.add(coinText, constraints);

            constraints.gridx = 3; 
            constraints.gridy = 2;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            contentPaneUno.add(availability, constraints);

            constraints.gridx = 4; 
            constraints.gridy = 2;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            contentPaneUno.add(availabilityButton, constraints);

            constraints.anchor = GridBagConstraints.CENTER;
            constraints.insets = new Insets(40,0,10,0);
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 6; 
            constraints.gridheight = 1;
            contentPaneUno.add(holders, constraints);
            
            constraints.insets = new Insets(0,0,10,0);
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 1;
            contentPaneUno.add(addHolder, constraints);
            
            constraints.insets = new Insets(0,0,0,0);
            constraints.gridx = 0;
            constraints.gridy = 5;
            contentPaneUno.add(holder1, constraints);
            
            constraints.gridx = 1;
            contentPaneUno.add(holderText1, constraints);
            
            constraints.gridx = 3;
            contentPaneUno.add(DNI1, constraints);
            
            constraints.gridx = 4;
            contentPaneUno.add(DNIText1, constraints);
            
             constraints.gridx = 5;
            contentPaneUno.add(deleteHolder1, constraints);
            
            constraints.gridx = 0;
            constraints.gridy = 6;
            contentPaneUno.add(holder2, constraints);
            
            constraints.gridx = 1;
            contentPaneUno.add(holderText2, constraints);
            
            constraints.gridx = 3;
            contentPaneUno.add(DNI2, constraints);
            
            constraints.gridx = 4;
            contentPaneUno.add(DNIText2, constraints);
            
             constraints.gridx = 5;
            contentPaneUno.add(deleteHolder2, constraints);
            
            constraints.gridx = 0;
            constraints.gridy = 7;
            contentPaneUno.add(holder3, constraints);
            
            constraints.gridx = 1;
            contentPaneUno.add(holderText3, constraints);
            
            constraints.gridx = 3;
            contentPaneUno.add(DNI3, constraints);
            
            constraints.gridx = 4;
            contentPaneUno.add(DNIText3, constraints);
            
            constraints.gridx = 5;
            contentPaneUno.add(deleteHolder3, constraints);
            
            constraints.gridx = 0;
            constraints.gridy = 8;
            contentPaneUno.add(holder4, constraints);
            
            constraints.gridx = 1;
            contentPaneUno.add(holderText4, constraints);
            
            constraints.gridx = 3;
            contentPaneUno.add(DNI4, constraints);
            
            constraints.gridx = 4;
            contentPaneUno.add(DNIText4, constraints);
            
            constraints.gridx = 5;
            contentPaneUno.add(deleteHolder4, constraints);
            
            constraints.insets = new Insets(40,0,10,0);
            constraints.gridx = 0;
            constraints.gridy = 9;
            constraints.gridwidth = 6; 
            contentPaneUno.add(authorized, constraints);
            
            constraints.insets = new Insets(0,0,10,0);
            constraints.gridy = 10;
            constraints.gridwidth = 1; 
            contentPaneUno.add(addAuthorized, constraints);
            
            constraints.insets = new Insets(0,0,0,0);
            constraints.gridy = 11;
            contentPaneUno.add(authorized1, constraints);
            
            constraints.gridx = 1;
            contentPaneUno.add(authorizedText1, constraints);
            
            constraints.gridx = 3;
            contentPaneUno.add(DNIAuthorized1, constraints);
            
            constraints.gridx = 4;
            contentPaneUno.add(DNIAuthorizedText1, constraints);
            
            constraints.gridx = 5;
            contentPaneUno.add(deleteAuthorized1, constraints);
            
            constraints.gridx = 0;
            constraints.gridy = 12;
            contentPaneUno.add(authorized2, constraints);
            
            constraints.gridx = 1;
            contentPaneUno.add(authorizedText2, constraints);
            
            constraints.gridx = 3;
            contentPaneUno.add(DNIAuthorized2, constraints);
            
            constraints.gridx = 4;
            contentPaneUno.add(DNIAuthorizedText2, constraints);
            
            constraints.gridx = 5;
            contentPaneUno.add(deleteAuthorized2, constraints);
            
            constraints.gridx = 0;
            constraints.gridy = 13;
            contentPaneUno.add(authorized3, constraints);
            
            constraints.gridx = 1;
            contentPaneUno.add(authorizedText3, constraints);
            
            constraints.gridx = 3;
            contentPaneUno.add(DNIAuthorized3, constraints);
            
            constraints.gridx = 4;
            contentPaneUno.add(DNIAuthorizedText3, constraints);
            
            constraints.gridx = 5;
            contentPaneUno.add(deleteAuthorized3, constraints);
            
            constraints.gridx = 0;
            constraints.gridy = 14;
            contentPaneUno.add(authorized4, constraints);
            
            constraints.gridx = 1;
            contentPaneUno.add(authorizedText4, constraints);
            
            constraints.gridx = 3;
            contentPaneUno.add(DNIAuthorized4, constraints);
            
            constraints.gridx = 4;
            contentPaneUno.add(DNIAuthorizedText4, constraints);
            
            constraints.gridx = 5;
            contentPaneUno.add(deleteAuthorized4, constraints);
            
            constraints.insets = new Insets(40,0,0,0);
            constraints.gridx = 0;
            constraints.gridy = 15;
            contentPaneUno.add(conti, constraints);
            
            window= this;
            
            holder1.setVisible(false);
            holderText1.setVisible(false);
            DNI1.setVisible(false);
            DNIText1.setVisible(false);
            deleteHolder1.setVisible(false);
            holder2.setVisible(false);
            holderText2.setVisible(false);
            DNI2.setVisible(false);
            DNIText2.setVisible(false);
            deleteHolder2.setVisible(false);
            holder3.setVisible(false);
            holderText3.setVisible(false);
            DNI3.setVisible(false);
            DNIText3.setVisible(false);
            deleteHolder3.setVisible(false);
            holder4.setVisible(false);
            holderText4.setVisible(false);
            DNI4.setVisible(false);
            DNIText4.setVisible(false);
            deleteHolder4.setVisible(false);
            
            authorized1.setVisible(false);
            authorizedText1.setVisible(false);
            DNIAuthorized1.setVisible(false);
            DNIAuthorizedText1.setVisible(false);
            deleteAuthorized1.setVisible(false);
            authorized2.setVisible(false);
            authorizedText2.setVisible(false);
            DNIAuthorized2.setVisible(false);
            DNIAuthorizedText2.setVisible(false);
            deleteAuthorized2.setVisible(false);
            authorized3.setVisible(false);
            authorizedText3.setVisible(false);
            DNIAuthorized3.setVisible(false);
            DNIAuthorizedText3.setVisible(false);
            deleteAuthorized3.setVisible(false);
            authorized4.setVisible(false);
            authorizedText4.setVisible(false);
            DNIAuthorized4.setVisible(false);
            DNIAuthorizedText4.setVisible(false);
            deleteAuthorized4.setVisible(false);

            addHolder.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            if (countHolder < 5) {
                                countHolder++;
                                switch(countHolder) {
                                     case 1: 
                                         holder1.setVisible(true);
                                         holderText1.setVisible(true);
                                         DNI1.setVisible(true);
                                         DNIText1.setVisible(true);
                                         deleteHolder1.setVisible(true);
                                         ClientsGUI cgui = new ClientsGUI(null, 0, holderText1,window);
                                         break;
                                     case 2: 
                                         holder2.setVisible(true);
                                         holderText2.setVisible(true);
                                         DNI2.setVisible(true);
                                         DNIText2.setVisible(true);
                                         deleteHolder2.setVisible(true);
                                         deleteHolder1.setVisible(false);
                                         break;
                                     case 3: 
                                         holder3.setVisible(true);
                                         holderText3.setVisible(true);
                                         DNI3.setVisible(true);
                                         DNIText3.setVisible(true);
                                         deleteHolder3.setVisible(true);
                                         deleteHolder2.setVisible(false);
                                         break;
                                     case 4: 
                                         holder4.setVisible(true);
                                         holderText4.setVisible(true);
                                         DNI4.setVisible(true);
                                         DNIText4.setVisible(true);
                                         deleteHolder4.setVisible(true);
                                         deleteHolder3.setVisible(false);
                                         break;
                                   
                                }
                            } else {
                                System.out.println("No se admiten mas titulares");
                            }
                        }
            });
            
            addAuthorized.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){  
                            //FindClientGUI person = new FindClientGUI();
                            if (countAuthorized < 5) {
                                countAuthorized++;
                                switch(countAuthorized) {
                                     case 1: 
                                         authorized1.setVisible(true);
                                         authorizedText1.setVisible(true);
                                         //authorizedText1.setText(person.getName());
                                         //authorizedText1.setEditable(false);
                                         DNIAuthorized1.setVisible(true);
                                         DNIAuthorizedText1.setVisible(true);
                                         deleteAuthorized1.setVisible(true);
                                         break;
                                     case 2: 
                                         authorized2.setVisible(true);
                                         authorizedText2.setVisible(true);
                                         DNIAuthorized2.setVisible(true);
                                         DNIAuthorizedText2.setVisible(true);
                                         deleteAuthorized2.setVisible(true);
                                         deleteAuthorized1.setVisible(false);
                                         break;
                                     case 3: 
                                         authorized3.setVisible(true);
                                         authorizedText3.setVisible(true);
                                         DNIAuthorized3.setVisible(true);
                                         DNIAuthorizedText3.setVisible(true);
                                         deleteAuthorized3.setVisible(true);
                                         deleteAuthorized2.setVisible(false);
                                         break;
                                     case 4: 
                                         authorized4.setVisible(true);
                                         authorizedText4.setVisible(true);
                                         DNIAuthorized4.setVisible(true);
                                         DNIAuthorizedText4.setVisible(true);
                                         deleteAuthorized4.setVisible(true);
                                         deleteAuthorized3.setVisible(false);
                                         break;                     
                                }
                            } else {
                                System.out.println("No se admiten mas autorizados");
                            }

                        }
            });
            
            deleteHolder1.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){   
                                countHolder--;
                                holder1.setVisible(false);
                                holderText1.setVisible(false);
                                DNI1.setVisible(false);
                                DNIText1.setVisible(false);
                                deleteHolder1.setVisible(false);                             
                          }
            });
            
            deleteHolder2.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){   
                                countHolder--;
                                holder2.setVisible(false);
                                holderText2.setVisible(false);
                                DNI2.setVisible(false);
                                DNIText2.setVisible(false);
                                deleteHolder2.setVisible(false);
                                deleteHolder1.setVisible(true);
                            
                          }
            });
            
            deleteHolder3.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){   
                                countHolder--;
                                holder3.setVisible(false);
                                holderText3.setVisible(false);
                                DNI3.setVisible(false);
                                DNIText3.setVisible(false);
                                deleteHolder3.setVisible(false);
                                deleteHolder2.setVisible(true);
                                
                          }
            });
            
            deleteHolder4.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){   
                                countHolder--;
                                holder4.setVisible(false);
                                holderText4.setVisible(false);
                                DNI4.setVisible(false);
                                DNIText4.setVisible(false);
                                deleteHolder4.setVisible(false);
                                deleteHolder3.setVisible(true);
                                
                          }
            });
            
            deleteAuthorized1.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){   
                                countAuthorized--;      
                                authorized1.setVisible(false);
                                authorizedText1.setVisible(false);
                                DNIAuthorized1.setVisible(false);
                                DNIAuthorizedText1.setVisible(false);
                                deleteAuthorized1.setVisible(false);
                          }
            });
            
            deleteAuthorized2.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){   
                                countAuthorized--;
                                authorized2.setVisible(false);
                                authorizedText2.setVisible(false);
                                DNIAuthorized2.setVisible(false);
                                DNIAuthorizedText2.setVisible(false);
                                deleteAuthorized2.setVisible(false);
                                deleteAuthorized1.setVisible(true);
                          }
            });
            
            deleteAuthorized3.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){   
                                countAuthorized--;
                                authorized3.setVisible(false);
                                authorizedText3.setVisible(false);
                                DNIAuthorized3.setVisible(false);
                                DNIAuthorizedText3.setVisible(false);
                                deleteAuthorized3.setVisible(false);
                                deleteAuthorized2.setVisible(true);
                          }
            });
            
            deleteAuthorized4.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){   
                                countAuthorized--;
                                authorized4.setVisible(false);
                                authorizedText4.setVisible(false);
                                DNIAuthorized4.setVisible(false);
                                DNIAuthorizedText4.setVisible(false);
                                deleteAuthorized4.setVisible(false);
                                deleteAuthorized3.setVisible(true);
                          }
            });     
            
            conti.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){   
                                
                          }
            });       
        }
   
        public static void main(String[] args) {
            AccountGUI gui = new AccountGUI();
        }
}