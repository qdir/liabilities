package es.unileon.aw.GUI.account;

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
	private JLabel DNI;
	private JLabel fechaNacimiento;
	private JLabel direccion;
	private JLabel titulares;
	
	private JTextField numeroCuentaText;
	private JTextField modalidadText;
	private JTextField oficinaText;
	private JTextField monedaText;
	private JTextField disponibilidadText;
	private JTextField nombreText;
	private JTextField DNIText;
	private JTextField fechaNacimientoText;
	private JTextField direccionText;
	
	private JButton anyadir1;
	private JButton anyadir2;
	
	public AccountGUI() {
		
		numeroCuenta = new JLabel("N� de Cuenta: ");
    	numeroCuentaText = new JTextField(20);
    	
    	modalidad = new JLabel("Modalidad: ");
    	modalidadText = new JTextField(20);
    	
    	oficina = new JLabel("Oficina: ");
    	oficinaText = new JTextField(20);
    	
    	moneda = new JLabel("Moneda de la Cuenta: ");
    	monedaText = new JTextField(20);
    	
    	disponibilidad = new JLabel("Disponibilidad: ");
    	disponibilidadText = new JTextField(20);
    	
    	nombre = new JLabel("Apellidos y Nombre o Raz�n Social: ");
    	nombreText = new JTextField(20);
    	
    	DNI = new JLabel("NIF-CIF: ");
    	DNIText = new JTextField(20);
    	
    	fechaNacimiento = new JLabel("Fecha Nacimiento: ");
    	fechaNacimientoText = new JTextField(20);
    	
    	direccion = new JLabel("Domicilio: ");
    	direccionText = new JTextField(20);
    	
    	titulares = new JLabel("TITULARES: ");
    	
       	anyadir1 = new JButton("anyadir titular");
       	anyadir2 = new JButton("anyadir asociado");
    	
    	this.setLayout(new GridBagLayout());
    	this.setSize(800, 400);
    	this.setResizable(false);
    	
    	GridBagConstraints constr=new GridBagConstraints();
    	
    	constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(numeroCuenta, constr); 
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(numeroCuentaText, constr);
        
        
        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        add(modalidad, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(modalidadText, constr);
        
        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(oficina, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(oficinaText, constr);
        
        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(moneda, constr); 
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(monedaText, constr);
        
        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(disponibilidad, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(disponibilidadText, constr);   
        
        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
    	constr.gridwidth = GridBagConstraints.REMAINDER;
        this.add(titulares, constr);      

        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(nombre, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(nombreText, constr);  
        
        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(DNI, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(DNIText, constr);   
        
        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(fechaNacimiento, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(fechaNacimientoText, constr);       
        
        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(direccion, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(direccionText, constr);       
        
        constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(anyadir1, constr); 
        constr.gridwidth = GridBagConstraints.REMAINDER;
        
        anyadir1.addActionListener((ActionListener) this);

        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
        	
    }
	
	public static void main(String[] args) {
        AccountGUI gui = new AccountGUI();
    }
	
	

}
