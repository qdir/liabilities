package es.unileon.aw.GUI.client;
import java.awt.*;
import javax.swing.*;

public class ClientsGUI extends JFrame {

    //Declaramos las etiquetas que vamos a utilizar
    private JLabel name;
    private JLabel surname;
    //Direccion completa
    private JLabel address;
    private JLabel number;
    private JLabel portal;
    private JLabel city;
    private JLabel postalCode;
    private JLabel country;
    //
    private JLabel DNI;
    private JLabel birthday;
    private JLabel relationship;
    private JLabel phone;
    private JLabel phone2;
    private JLabel accountType;

    //Declaramos los campos que vamos a utilizar y seran editables
    private JTextField nameText;
    private JTextField surnameText;
    
    private JTextField addressText;
    private JTextField numberText;
    private JTextField portalText;
    private JTextField cityText;
    private JTextField postalCodeText;
    private JTextField countryText;
    
    private JTextField DNIText;
    private JTextField birthdayText;
    private JTextField relationshipText;
    private JTextField phoneText1;
    private JTextField phoneText2;
    
    private Choice accountTypeSeleccion;

    public ClientsGUI(){
        //Creamos etiqueta y campo
    	name = new JLabel("Nombre: ");
    	nameText = new JTextField(23);
    	
    	surname = new JLabel("Apellidos:");
    	surnameText = new JTextField(23);
    	
    	DNI= new JLabel("DNI: ");
    	DNIText = new JTextField(23);
    	
    	birthday = new JLabel("Fecha de nacimiento (dd/mm/aa): ");
    	birthdayText = new JTextField(23);
        /////////////////////////////////////
        address = new JLabel("Direccion ");
        addressText = new JTextField();
      
        number = new JLabel("Nº: ");
        numberText = new JTextField(4);
        
        portal = new JLabel("Portal: ");
        portalText = new JTextField(4);
        
        postalCode = new JLabel("CP: ");
        postalCodeText=  new JTextField();
        
        city = new JLabel("Ciudad: ");
        cityText = new JTextField();
        
        country = new JLabel("Pais: ");
        countryText = new JTextField();
        //////////////////////////////////////
        
        relationship = new JLabel("Estado civil: ");
        relationshipText = new JTextField();
        
        phone = new JLabel("Telefono: ");
        phoneText1 = new JTextField(10);
        
        phone2 = new JLabel("Telefono: ");
        phoneText2 = new JTextField(10);
        
        accountType = new JLabel("Tipo de cuenta: ");
        accountTypeSeleccion = new Choice();
        accountTypeSeleccion.addItem("Tipo Cuenta 1");
        accountTypeSeleccion.addItem("Tipo Cuenta 2");
        accountTypeSeleccion.addItem("Tipo Cuenta 3");
    	
        //Asignamos a la ventana principal el layout GridBagLayout
    	this.setLayout(new GridBagLayout());
        //tamaño de la ventana
    	this.setSize(700, 300);
        //No se podra modificar el tamaño
    	this.setResizable(false);
        
        //Creamos los ajustes para el layout. Determinan la posicion de los elementos
    	GridBagConstraints constr=new GridBagConstraints();
    	/*Fill: indica cuanto se estira un componente.
        anchor: Indica la posicion
        insets: margenes respecto a los otros componentes
        gridwidth: ancho del componente (numero de filas que ocupa)
        gridheight: alto del componente
        http://www.chuidiang.com/java/layout/GridBagLayout/GridBagLayout.php
        */
        
    	//Nombre
    	constr.fill = GridBagConstraints.HORIZONTAL;
    	constr.anchor=GridBagConstraints.WEST;
    	constr.insets=new Insets(0,0,0,0);
    	constr.gridwidth=1;
        this.add(name, constr); //Añadimos el elemento y sus propiedades para que se situe donde queremos
        constr.gridwidth = GridBagConstraints.REMAINDER;
        constr.anchor=GridBagConstraints.EAST;
        add(nameText, constr);
        
        //Apellidos
        constr.fill=GridBagConstraints.HORIZONTAL;
        constr.anchor=GridBagConstraints.WEST;
        constr.gridwidth=1; 
        add(surname, constr);
        constr.anchor=GridBagConstraints.EAST;
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(surnameText, constr);
       
        //Dirección
        constr.gridwidth = 1;//Ocupa solo una fila
        constr.anchor=GridBagConstraints.WEST;
        add(address, constr);
        constr.anchor=GridBagConstraints.EAST;
        constr.gridwidth=GridBagConstraints.REMAINDER; //salto de linea
        add(addressText, constr);
        //Portal
        constr.anchor=GridBagConstraints.WEST;
        constr.gridwidth = 1;
        add(portal, constr);
        constr.anchor=GridBagConstraints.EAST;
        add(portalText, constr);        
        //NumerO
        constr.anchor=GridBagConstraints.WEST;
        add(number,constr);
        constr.anchor=GridBagConstraints.EAST;
        add(numberText,constr);
        //Codigo Postal
        constr.anchor=GridBagConstraints.WEST;
        add(postalCode, constr);
        constr.anchor=GridBagConstraints.EAST;
        constr.gridwidth = GridBagConstraints.REMAINDER; //Si quitamos esto, nos pondrá toodo en la misma fila
        add(postalCodeText, constr);
        //Ciudad
        constr.gridwidth = 1;
        add(city, constr);
        add(cityText, constr);
        //Pais
        add(country, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(countryText, constr);
         
       

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
        
        //Estado civil
        constr.gridwidth=1;
        add(relationship, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(relationshipText, constr);
        
        //Telefono movil
        constr.gridwidth=1;
        add(phone, constr);
        add(phoneText1, constr);
        add(phone2, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(phoneText2, constr);
        
       //opcion elegir tipo de cuenta (desplegable)
        constr.gridwidth=1;
        add(accountType, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(accountTypeSeleccion, constr);
        
        
        //Accion al cerrar la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        ClientsGUI gui = new ClientsGUI();
    }
}
