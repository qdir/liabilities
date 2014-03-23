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


public class AccountGUI extends JFrame{
	
	private JLabel numeroCuenta;
	private JLabel modalidad;
	private JLabel oficina;
	private JLabel moneda;
	private JLabel disponibilidad;
	private JLabel titulares;
        private JLabel autorizados;
        private JLabel datosCuenta;
        private JLabel blanco;
        private JLabel titular1;
        private JLabel titular2;
        private JLabel titular3;
        private JLabel titular4;
        private JLabel autorizado1;
        private JLabel autorizado2;
        private JLabel autorizado3;
        private JLabel autorizado4;
	
	private JTextField numeroCuentaText;
	private JTextField modalidadText;
	private JTextField oficinaText;
	private JTextField monedaText;
	private JTextField disponibilidadText;
        private JTextField titular1Text;
        private JTextField titular2Text;
        private JTextField titular3Text;
        private JTextField titular4Text;
        private JTextField autorizado1Text;
        private JTextField autorizado2Text;
        private JTextField autorizado3Text;
        private JTextField autorizado4Text;
	
	private JButton anyadirTitular;
	private JButton anyadirAutorizado;
	
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
        
        titular1 = new JLabel("Titular 1: ");
        titular1Text = new JTextField(20);
        
        titular2 = new JLabel("Titular 2: ");
        titular2Text = new JTextField(20);
        
        titular3 = new JLabel("Titular 3: ");
        titular3Text = new JTextField(20);
        
        titular4 = new JLabel("Titular 4: ");
        titular4Text = new JTextField(20);
        
        autorizado1 = new JLabel("Autorizado 1: ");
        autorizado1Text = new JTextField(20);
        
        autorizado2 = new JLabel("Autorizado 2: ");
        autorizado2Text = new JTextField(20);
        
        autorizado3 = new JLabel("Autorizado 3: ");
        autorizado3Text = new JTextField(20);
        
        autorizado4 = new JLabel("Autorizado 4: ");
        autorizado4Text = new JTextField(20);
    	
        blanco = new JLabel("          ");
        datosCuenta = new JLabel("DATOS DE LA CUENTA");
    	titulares = new JLabel("TITULARES");
        autorizados = new JLabel("AUTORIZADOS");
    	
       	anyadirTitular = new JButton("Titular +");
       	anyadirAutorizado = new JButton("Autorizado +");
    	
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
        
      
        constraints.insets = new Insets(0,0,10,0);
        constraints.gridx = 0; 
        constraints.gridy = 9;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(anyadirTitular, constraints);
        
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridx = 0; 
        constraints.gridy = 10;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(titular1, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 10;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(titular1Text, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 10;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(titular2, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 10;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(titular2Text, constraints);
        
        constraints.gridx = 0; 
        constraints.gridy = 11;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(titular3, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 11;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(titular3Text, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 11;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(titular4, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 11;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(titular4Text, constraints);
        
        constraints.gridx = 0; 
        constraints.gridy = 12;  
        constraints.gridwidth = 5; 
        constraints.gridheight = 1;
        constraints.insets = new Insets(40,0,20,0);
        this.getContentPane().add(autorizados, constraints);
        
        constraints.insets = new Insets(0,0,10,0);
        constraints.gridx = 0; 
        constraints.gridy = 13;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(anyadirAutorizado, constraints);
        
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridx = 0; 
        constraints.gridy = 14;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(autorizado1, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 14;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(autorizado1Text, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 14;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(autorizado2, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 14;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(autorizado2Text, constraints);
        
        constraints.gridx = 0; 
        constraints.gridy = 15;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(autorizado3, constraints);
        
        constraints.gridx = 1; 
        constraints.gridy = 15;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(autorizado3Text, constraints);
        
        constraints.gridx = 3; 
        constraints.gridy = 15;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(autorizado4, constraints);
        
        constraints.gridx = 4; 
        constraints.gridy = 15;  
        constraints.gridwidth = 1; 
        constraints.gridheight = 1;
        this.getContentPane().add(autorizado4Text, constraints);

        
        anyadirTitular.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e){
		    HolderGUI holder = new HolderGUI();
		}
	});
        
        
        anyadirAutorizado.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e){
		    AuthorizedGUI authorized = new AuthorizedGUI();
		}
	});
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
		
    }
	
        
    public static void main(String[] args) {
        AccountGUI gui = new AccountGUI();
    }
}
