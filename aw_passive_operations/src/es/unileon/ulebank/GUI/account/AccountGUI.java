package es.unileon.ulebank.GUI.account;

import es.unileon.ulebank.GUI.client.ClientsGUI;
import es.unileon.ulebank.GUI.client.FindClientGUI;
import es.unileon.ulebank.GUI.client.GUIOperations;
import es.unileon.ulebank.GUI.client.PersonPanel;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.account.types.AccountType;
import es.unileon.ulebank.account.types.CommercialAccount;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.command.CreateAccountCommand;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.transacionManager.TransactionManager;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.ws.Holder;


public class AccountGUI extends GUIOperations {

        private JPanel contentPaneUno;
        private JLabel accountData;                  
        private JLabel accountNumber;
        private HolderPanel holderPanel;
        private AuthorizedPanel authorizedPanel;
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
        private JLabel authorized;
        private JButton conti; 
        private JLabel blanco;
        private int countHolder;
        private int countAuthorized;
        private AccountGUI window;
        private boolean one = true;
        List<Client> listHolders;
        List<Client> listAuthorized;
        
        
        
public AccountGUI()  {
            
            contentPaneUno = new JPanel();            
            accountData = new JLabel("DATOS DE LA CUENTA");          
            accountNumber = new JLabel("Numero de Cuenta: ");
            accountNumberText = new JTextField(20);    
            accountNumberText.setEditable(false);
            mode = new JLabel("Modalidad: ");
            modeButton = new JComboBox();
            modeButton.addItem("La Cartilla");
            modeButton.addItem("Empresa");
            modeButton.addItem("Cuenta Plus");
            modeButton.addItem("Cuenta Personal");  
            coin = new JLabel("Moneda de la Cuenta: ");
            coinText = new JTextField(20);  
            coinText.setHorizontalAlignment(SwingConstants.CENTER);
            coinText.setText("Euros");
            coinText.setEditable(false);
            availability = new JLabel("Disponibilidad: ");
            availabilityButton = new JComboBox();
            availabilityButton.addItem("Independiente");
            availabilityButton.addItem("Mancomunada");
            availabilityButton.addItem("Indistinta");             
            addHolder = new JButton("Añadir titular");
            addAuthorized = new JButton("Añadir autorizado");           
            holders = new JLabel("TITULARES");  
            authorized = new JLabel("AUTORIZADOS");
            conti =  new JButton("Continuar");           
            blanco = new JLabel("          ");
            countHolder = 5;
            countAuthorized = 52;
            listHolders = null;
            listAuthorized = null;
            
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

            constraints.gridy = 1;  //Empieza en la fila 0
            constraints.gridwidth = 1; //Ocupa una columna
            constraints.insets = new Insets(0,0,0,0);
            contentPaneUno.add(accountNumber, constraints);

            constraints.gridx = 1;  
            contentPaneUno.add(accountNumberText, constraints);

            constraints.gridx = 2; 
            contentPaneUno.add(blanco, constraints);

            //constraints.gridx = 3; 
            //contentPaneUno.add(mode, constraints);

            //constraints.gridx = 4; 
            //contentPaneUno.add(modeButton, constraints);                        

            constraints.gridx = 0; 
            constraints.gridy = 2;  
            contentPaneUno.add(coin, constraints);

            constraints.gridx = 1; 
            contentPaneUno.add(coinText, constraints);

            constraints.gridx = 3; 
            contentPaneUno.add(availability, constraints);

            constraints.gridx = 4; 
            contentPaneUno.add(availabilityButton, constraints);

            constraints.anchor = GridBagConstraints.CENTER;
            constraints.insets = new Insets(40,0,10,0);
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 6; 
            contentPaneUno.add(holders, constraints);
            
            constraints.insets = new Insets(0,0,10,0);
            constraints.gridy = 4;
            constraints.gridwidth = 1;
            contentPaneUno.add(addHolder, constraints);
            
            constraints.insets = new Insets(40,0,10,0);
            constraints.gridy = 50;
            constraints.gridwidth = 6; 
            contentPaneUno.add(authorized, constraints);
            
            constraints.insets = new Insets(0,0,10,0);
            constraints.gridy = 51;
            constraints.gridwidth = 1; 
            contentPaneUno.add(addAuthorized, constraints);          
         
            constraints.insets = new Insets(40,0,0,0);
            constraints.gridy = 100;
            contentPaneUno.add(conti, constraints);
            
            window= this;
            
            availabilityButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (availabilityButton.getSelectedItem().toString() == "Mancomunada") {
                        one = false;
                        addHolder.setVisible(true);
                    } else if (availabilityButton.getSelectedItem().toString() == "Independiente") {
                        one = true;
                        //Comprobar numero de paneles
                    } else if (availabilityButton.getSelectedItem().toString() == "Indistinta") {
                        one = false;
                        addHolder.setVisible(true);
                    }
                }
            });
                    
            addHolder.addActionListener(new ActionListener() {
                private JTextField holderText1;
                public void actionPerformed(ActionEvent e){
                    newHolderPanel();
                    constraints.gridx = 0;
                    constraints.gridy = countHolder;
                    constraints.gridwidth = 5;
                    contentPaneUno.add(holderPanel, constraints);
                    validate();
                    countHolder++;
                    if (one == true) {
                        addHolder.setVisible(false);
                    }
                    //ClientsGUI cgui = new ClientsGUI(null, 0, holderText1,window);
                    //addHolder(cliente);
                }
            });
            
            
            addAuthorized.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                    newAuthorizedPanel();
                    constraints.gridx = 0;
                    constraints.gridy = countAuthorized;
                    constraints.gridwidth = 5;
                    contentPaneUno.add(authorizedPanel, constraints);
                    validate();
                    countAuthorized++;
                    
                }
            });
           
            
            conti.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){   

                }
            });       
        }

        public void downCountHolder() {
            countHolder--;
            addHolder.setVisible(true);
        }
        
        public JPanel newHolderPanel() {
            holderPanel = new HolderPanel(this);
            return holderPanel;
        }
        
        public JPanel newAuthorizedPanel() {
            authorizedPanel = new AuthorizedPanel(this);
            return authorizedPanel;
        }
        
        public void addHolder(Client client) {
            //listHolders.add(client);
        }
            
        public void addAuthorized(Client client) {
            //listAuthorized.add(client);
        }
   
        public void deleteHolder() {
            //le paso el id del holder, lo busco y lo elimino de la lista
        }
        
        public void deleteAuthorized() {
            //le paso el id del authorized, lo busco y lo borro de la lista
        }         
        
        public static void main(String[] args) {
            AccountGUI gui = new AccountGUI();
        }
}