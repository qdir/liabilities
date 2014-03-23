/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.GUI.account;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author JesusNieto
 */
public class AuthorizedGUI extends JFrame implements ActionListener {
    
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
        private JLabel blanco;
        private JLabel autorizado;
    
        
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
        
        private JButton anyadir;
        
        public AuthorizedGUI() {
            
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
            
            autorizado = new JLabel("AUTORIZADO");
            
            anyadir = new JButton("Añadir autorizado");
            
            
            this.setLayout(new GridBagLayout());
            this.setSize(800, 400);
            this.setResizable(false);
    	
            GridBagConstraints constraints =new GridBagConstraints();
            
            constraints.insets = new Insets(0,0,40,0);    
            constraints.gridx = 0; 
            constraints.gridy = 0;  
            constraints.gridwidth = 5; 
            constraints.gridheight = 4;
            this.getContentPane().add(autorizado, constraints);
        
            constraints.anchor = GridBagConstraints.WEST;
            constraints.insets = new Insets(0,0,0,0); 
            constraints.gridx = 2; 
            constraints.gridy = 4;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            this.getContentPane().add(blanco, constraints);
            
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
            
            constraints.insets = new Insets(20,0,20,0);        
            constraints.gridx = 0; 
            constraints.gridy = 9;  
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            this.getContentPane().add(anyadir, constraints);
            
             
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setVisible(true);
            
            anyadir.addActionListener(this);
        }
        
        
        public static void main(String[] args) {
            AuthorizedGUI gui = new AuthorizedGUI();
        }
    
        public void actionPerformed(ActionEvent e) {
            this.dispose();
        }
    
}
