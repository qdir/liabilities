import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;


public class ClientsGUI extends JFrame {

	 //Declaramos las etiquetas que vamos a utilizar
    private JLabel name;
    private JLabel surname;
    private JLabel address;
    private JLabel city;
    private JLabel postalCode;
    private JLabel DNI;
    private JLabel birthday;
    private JLabel relationship;
    private JLabel phone;
    private JLabel phone2;
    private JLabel accountType;

    //Declaramos los campos que vamos a utilizar
    private JTextField nameText;
    private JTextField surnameText;
    private JTextField addressText;
    private JTextField cityText;
    private JTextField postalCodeText;
    private JTextField DNIText;
    private JTextField birthdayText;

    public ClientsGUI(){
    	name = new JLabel("Nombre: ");
    	nameText = new JTextField();
    	
    	surname = new JLabel("Apellidos:");
    	surnameText = new JTextField(20);
    	
    	DNI= new JLabel("DNI: ");
    	DNIText = new JTextField();
    	
    	birthday = new JLabel("Fecha de nacimiento (dd/mm/aa): ");
    	birthdayText = new JTextField();
    	
    	this.setLayout(new GridBagLayout());
    	this.setSize(600, 200);
    	this.setResizable(false);
    	GridBagConstraints constr=new GridBagConstraints();
    	
    	//Nombre
    	constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(name, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(nameText, constr);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
        //Apellidos
        constr.fill=GridBagConstraints.HORIZONTAL;
        constr.anchor=GridBagConstraints.WEST;
        constr.gridwidth=1;
        constr.insets=new Insets(0,0,0,0);
        add(surname, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(surnameText, constr);
       
        //DNI
        constr.fill=GridBagConstraints.HORIZONTAL;
        constr.anchor=GridBagConstraints.WEST;
        constr.gridwidth=1;
        constr.insets=new Insets(0,0,0,0);
        add(DNI, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(DNIText, constr);
        
        //Fecha de nacimiento
        constr.fill=GridBagConstraints.HORIZONTAL;
        constr.anchor=GridBagConstraints.WEST;
        constr.gridwidth=1;
        constr.insets=new Insets(0,0,0,0);
        add(birthday, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(birthdayText, constr);
        
        
    }
    
    public static void main(String[] args) {
        //TODO
        ClientsGUI gui = new ClientsGUI();
    }
}
