package es.unileon.ulebank.GUI.account;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AccountGUI extends JFrame implements ActionListener {
	
	private JLabel numeroCuenta;
	private JLabel modalidad;
	private JLabel oficina;
	private JLabel moneda;
	private JLabel disponibilidad;
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
	private JLabel titulares;
        private JLabel autorizados;
        private JLabel datosCuenta;
        private JLabel blanco;
	
	private JTextField numeroCuentaText;
	private JTextField modalidadText;
	private JTextField oficinaText;
	private JTextField monedaText;
	private JTextField disponibilidadText;
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
	
	private JButton anyadirTitular;
	private JButton anyadir2;
	
	public AccountGUI() {
		
	numeroCuenta = new JLabel("Numero de Cuenta: ");
    	numeroCuentaText = new JTextField(20);
    	
    	modalidad = new JLabel("Modalidad: ");
    	modalidadText = new JTextField(20);
    	
    	oficina = new JLabel("Oficina: ");
    	oficinaText = new JTextField(20);
    	
    	moneda = new JLabel("Moneda de la Cuenta: ");
    	monedaText = new JTextField(20);
    	
    	disponibilidad = new JLabel("Disponibilidad: ");
    	disponibilidadText = new JTextField(20);
    	
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
    	
        blanco = new JLabel("          ");
        datosCuenta = new JLabel("DATOS DE LA CUENTA");
    	titulares = new JLabel("TITULARES");
        autorizados = new JLabel("AUTORIZADOS");
    	
       	anyadirTitular = new JButton("Titular +");
       	anyadir2 = new JButton("anyadir asociado");
    	
    	this.setLayout(new GridBagLayout());
    	this.setSize(1000, 600);
    	this.setResizable(false);
    	
    	GridBagConstraints constraints =new GridBagConstraints();
        
        constraints.anchor = GridBagConstraints.WEST;
        
        constraints.gridx = 0; 
        constraints.gridy = 0;  
        constraints.gridwidth = 5; 
        constraints.gridheight = 1;
        constraints.insets = new Insets(0,0,20,0);
        this.getContentPane().add(datosCuenta, constraints);
        
        
        constraints.gridx = 0; //Empieza en la columna 0
        constraints.gridy = 1;  //Empieza en la fila 0
        constraints.gridwidth = 1; //Ocupa una columna
        constraints.gridheight = 1; //Ocupa dos filas
        constraints.insets = new Insets(0,0,0,0);
        this.getContentPane().add(numeroCuenta, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 1;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(numeroCuentaText, constraints);
        
        constraints.gridx = 2; 
        constraints.gridy = 1;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(blanco, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 1;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(modalidad, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 1;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(modalidadText, constraints);
        
        constraints.gridx = 0; 
        constraints.gridy = 2;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(moneda, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 2;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(monedaText, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 2;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(disponibilidad, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 2;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(disponibilidadText, constraints);

        constraints.gridx = 0; 
        constraints.gridy = 3;  
        constraints.gridwidth = 5; 
        constraints.gridheight = 1;
        constraints.insets = new Insets(40,0,20,0);
        this.getContentPane().add(titulares, constraints);
        
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridx = 0; 
        constraints.gridy = 4;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(nombre, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 4;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(nombreText, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 4;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(direccion, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 4;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(direccionText, constraints);
        
        constraints.gridx = 0; 
        constraints.gridy = 5;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(apellidos, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 5;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(apellidosText, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 5;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(localidad, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 5;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(localidadText, constraints);
        
        constraints.gridx = 0; 
        constraints.gridy = 6;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(fechaNacimiento, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 6;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(fechaNacimientoText, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 6;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(provincia, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 6;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(provinciaText, constraints);
        
        constraints.gridx = 0; 
        constraints.gridy = 7;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(DNI, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 7;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(DNIText, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 7;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(codigoPostal, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 7;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(codigoPostalText, constraints);
        
        constraints.gridx = 0; 
        constraints.gridy = 8;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(estadoCivil, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 8;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(estadoCivilText, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 8;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(telefono, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 8;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(telefonoText, constraints);
        
        constraints.gridx = 0; 
        constraints.gridy = 9;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(anyadirTitular, constraints);
        
        
        constraints.gridx = 0; 
        constraints.gridy = 10;  
        constraints.gridwidth = 5; 
        constraints.gridheight = 1;
        constraints.insets = new Insets(40,0,20,0);
        this.getContentPane().add(autorizados, constraints);
        
        constraints.insets = new Insets(0,0,0,0);

        
        
        anyadirTitular.addActionListener((ActionListener) this);

        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
        	
    }
	
	public static void main(String[] args) {
        AccountGUI gui = new AccountGUI();
    }
	
	

}
