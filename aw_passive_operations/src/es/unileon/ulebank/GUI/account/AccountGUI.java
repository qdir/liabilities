package es.unileon.ulebank.GUI.account;

import es.unileon.ulebank.GUI.client.GUIOperations;
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


public class AccountGUI extends GUIOperations{
	
	private JLabel numeroCuenta;
	private JLabel modalidad;
	private JLabel oficina;
	private JLabel moneda;
	private JLabel disponibilidad;
	private JLabel titulares;
        private JLabel autorizados;
        private JLabel datosCuenta;
        private JLabel blanco;       
        private JPanel contentPaneUno;      
        private JLabel nombre;
        private JLabel apellidos;
        private JLabel fechaNacimiento;
	private JLabel DNI;
        private JLabel estadoCivil;
	private JLabel direccion;
        private JLabel localidad;
        private JLabel provincia;
        private JLabel codigoPostal;
        private JLabel telefono;
        private JLabel titular;    
        private JLabel authorized;
        private JTextField nombreText;
        private JTextField apellidosText;
        private JTextField fechaNacimientoText;
	private JTextField DNIText;
        private JTextField estadoCivilText;
	private JTextField direccionText;
        private JTextField localidadText;
        private JTextField provinciaText;
        private JTextField codigoPostalText;
        private JTextField telefonoText;      
        private JButton addHolder; 
        private JButton addAuthorized;
	private JTextField numeroCuentaText;
	private JTextField oficinaText;
	private JTextField monedaText;	
	private JButton anyadirTitular;
	private JButton anyadirAutorizado;
        private JComboBox modalidadButton;
        private JComboBox disponibilidadButton;	
        private JLabel nameAuthorized;
	private JLabel DNIAuthorized;
        private JTextField nameAuthorizedText;
        private JTextField DNIAuthorizedText;
        
        
	public AccountGUI() {
		
            numeroCuenta = new JLabel("Numero de Cuenta: ");
            numeroCuentaText = new JTextField(20);    	
            modalidad = new JLabel("Modalidad: ");
            modalidadButton = new JComboBox();
            modalidadButton.addItem("La Cartilla");
            modalidadButton.addItem("Empresa");
            modalidadButton.addItem("Cuenta Plus");
            modalidadButton.addItem("Cuenta Personal");   	
            oficina = new JLabel("Oficina: ");
            oficinaText = new JTextField(20); 	
            moneda = new JLabel("Moneda de la Cuenta: ");
            monedaText = new JTextField(20);   	
            disponibilidad = new JLabel("Disponibilidad: ");
            disponibilidadButton = new JComboBox();
            disponibilidadButton.addItem("Independiente");
            disponibilidadButton.addItem("Mancomunada");
            disponibilidadButton.addItem("Indistinta"); 
            nombre = new JLabel("Nombre: ");
            nombreText = new JTextField(20);
            apellidos = new JLabel("Apellidos: ");
            apellidosText = new JTextField(20);
            fechaNacimiento = new JLabel("Fecha Nacimiento: ");
            fechaNacimientoText = new JTextField(20);
            DNI = new JLabel("NIF-CIF: ");
            DNIText = new JTextField(20);
            estadoCivil = new JLabel("Estado civil: ");
            estadoCivilText = new JTextField(20);
            direccion = new JLabel("Direccion: ");
            direccionText = new JTextField(20);
            localidad = new JLabel("Localidad: ");
            localidadText = new JTextField(20);
            provincia = new JLabel("Provincia: ");
            provinciaText = new JTextField(20);
            codigoPostal = new JLabel("Codigo Postal: ");
            codigoPostalText = new JTextField(20);
            telefono = new JLabel("Telefono: ");
            telefonoText = new JTextField(20);
            addHolder = new JButton("Añadir titular");
            addAuthorized = new JButton("Añadir autorizado");
            titular = new JLabel("TITULAR"); 	
            authorized = new JLabel("AUTORIZADO");
            blanco = new JLabel("          ");
            datosCuenta = new JLabel("DATOS DE LA CUENTA");
            titulares = new JLabel("TITULARES");
            autorizados = new JLabel("AUTORIZADOS");	
            anyadirTitular = new JButton("Titular +");
            anyadirAutorizado = new JButton("Autorizado +");
            nameAuthorized = new JLabel("Nombre: ");
            nameAuthorizedText = new JTextField(20);
            DNIAuthorized = new JLabel("DNI: ");
            DNIAuthorizedText = new JTextField(20);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            contentPaneUno = new JPanel();
                       
            int width = this.getToolkit().getScreenSize().width;
            int height = this.getToolkit().getScreenSize().height;
            setBounds(0,0,width,height-50);
            setVisible(true);
            JScrollPane scrollpane = new JScrollPane(contentPaneUno);
            setContentPane(scrollpane);

            
            GridLayout layout = new GridLayout();

            contentPaneUno.setLayout(layout);
            
             JPanel prueba = new JPanel();
          
             GridBagLayout prueba2 = new GridBagLayout();
             prueba.setLayout(prueba2);

            final GridBagConstraints constraints =new GridBagConstraints();

            constraints.anchor = GridBagConstraints.WEST;

            constraints.gridx = 0; 
            constraints.gridy = 0;  
            constraints.gridwidth = 5; 
            constraints.gridheight = 1;
            constraints.insets = new Insets(0,0,20,0);
            prueba.add(datosCuenta, constraints);


            constraints.gridx = 0; //Empieza en la columna 0
            constraints.gridy = 1;  //Empieza en la fila 0
            constraints.gridwidth = 1; //Ocupa una columna
            constraints.gridheight = 1; //Ocupa dos filas
            constraints.insets = new Insets(0,0,0,0);
            prueba.add(numeroCuenta, constraints);

            constraints.gridx = 1; 
            constraints.gridy = 1;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(numeroCuentaText, constraints);

            constraints.gridx = 2; 
            constraints.gridy = 1;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(blanco, constraints);

            constraints.gridx = 3; 
            constraints.gridy = 1;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(modalidad, constraints);

            constraints.gridx = 4; 
            constraints.gridy = 1;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(modalidadButton, constraints);

            constraints.gridx = 0; 
            constraints.gridy = 2;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(moneda, constraints);

            constraints.gridx = 1; 
            constraints.gridy = 2;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(monedaText, constraints);

            constraints.gridx = 3; 
            constraints.gridy = 2;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(disponibilidad, constraints);

            constraints.gridx = 4; 
            constraints.gridy = 2;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(disponibilidadButton, constraints);

            constraints.gridx = 0; 
            constraints.gridy = 3;  
            constraints.gridwidth = 5; 
            constraints.gridheight = 1;
            constraints.insets = new Insets(40,0,20,0);
            prueba.add(titulares, constraints);


            constraints.insets = new Insets(0,0,10,0);
            constraints.gridx = 0; 
            constraints.gridy = 9;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(anyadirTitular, constraints);

            constraints.gridx = 0; 
            constraints.gridy = 22;  
            constraints.gridwidth = 5; 
            constraints.gridheight = 1;
            constraints.insets = new Insets(40,0,20,0);
            prueba.add(autorizados, constraints);

            constraints.insets = new Insets(0,0,10,0);
            constraints.gridx = 0; 
            constraints.gridy = 23;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            prueba.add(anyadirAutorizado, constraints);

            anyadirTitular.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    newPanelHolder();
                    contentPaneUno.validate();
                    
                    addHolder.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){

                         }
                     });
                }
            });

            anyadirAutorizado.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    newPanelAuthorized();
                    contentPaneUno.validate();
                    addAuthorized.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){

                         }
                     });
                }
            });	
            
            contentPaneUno.add(prueba);   
        }
        
        public void newPanelHolder(){

            JPanel holder = new JPanel();
            GridBagLayout layout2 = new GridBagLayout();

            holder.setLayout(layout2);
            GridBagConstraints cons = new GridBagConstraints();

            cons.insets = new Insets(0,0,40,0);    
            cons.gridx = 0; 
            cons.gridy = 0;  
            cons.gridwidth = 5; 
            cons.gridheight = 4;
            holder.add(titular, cons);

            cons.insets = new Insets(0,0,0,0);    

            cons.gridx = 2; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(blanco, cons);

            cons.gridx = 0; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(nombre, cons);

            cons.gridx = 1; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(nombreText, cons);

            cons.gridx = 3; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(direccion, cons);

            cons.gridx = 4; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(direccionText, cons);

            cons.gridx = 0; 
            cons.gridy = 5;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(apellidos, cons);

            cons.gridx = 1; 
            cons.gridy = 5;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(apellidosText, cons);

            cons.gridx = 3; 
            cons.gridy = 5;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(localidad, cons);

            cons.gridx = 4; 
            cons.gridy = 5;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(localidadText, cons);

            cons.gridx = 0; 
            cons.gridy = 6;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(fechaNacimiento, cons);

            cons.gridx = 1; 
            cons.gridy = 6;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(fechaNacimientoText, cons);

            cons.gridx = 3; 
            cons.gridy = 6;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(provincia, cons);

            cons.gridx = 4; 
            cons.gridy = 6;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(provinciaText, cons);

            cons.gridx = 0; 
            cons.gridy = 7;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(DNI, cons);

            cons.gridx = 1; 
            cons.gridy = 7;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(DNIText, cons);

            cons.gridx = 3; 
            cons.gridy = 7;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(codigoPostal, cons);

            cons.gridx = 4; 
            cons.gridy = 7;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(codigoPostalText, cons);

            cons.gridx = 0; 
            cons.gridy = 8;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(estadoCivil, cons);

            cons.gridx = 1; 
            cons.gridy = 8;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(estadoCivilText, cons);

            cons.gridx = 3; 
            cons.gridy = 8;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(telefono, cons);

            cons.gridx = 4; 
            cons.gridy = 8;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(telefonoText, cons);

            cons.insets = new Insets(20,0,20,0);        
            cons.gridx = 0; 
            cons.gridy = 9;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            holder.add(addHolder, cons);

            contentPaneUno.add(holder);
            
        }
        
        public void newPanelAuthorized(){
            
            JPanel auth = new JPanel();
            GridBagLayout layout3 = new GridBagLayout();

            auth.setLayout(layout3);
            GridBagConstraints cons = new GridBagConstraints();
            
            cons.insets = new Insets(0,0,40,0);    
            cons.gridx = 0; 
            cons.gridy = 0;  
            cons.gridwidth = 5; 
            cons.gridheight = 4;
            auth.add(authorized, cons);

            cons.insets = new Insets(0,0,0,0);    

            cons.gridx = 2; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            auth.add(blanco, cons);
            
            cons.gridx = 0; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            auth.add(nameAuthorized, cons);

            cons.gridx = 1; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            auth.add(nameAuthorizedText, cons);

            cons.gridx = 3; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            auth.add(DNIAuthorized, cons);

            cons.gridx = 4; 
            cons.gridy = 4;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            auth.add(DNIAuthorizedText, cons);
            
            cons.insets = new Insets(20,0,20,0);        
            cons.gridx = 0; 
            cons.gridy = 9;  
            cons.gridwidth = 1; 
            cons.gridheight = 1;
            auth.add(addAuthorized, cons);
            
            contentPaneUno.add(auth);

            
        }
        
        public void addHolderToBBDD() {
            
        }
        
        public void addAuthorizedToBBDD() {
            
        }

        public static void main(String[] args) {
            AccountGUI gui = new AccountGUI();
        }
}
