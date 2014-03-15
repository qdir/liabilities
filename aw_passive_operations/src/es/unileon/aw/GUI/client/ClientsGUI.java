import java.awt.*;
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

    //Declaramos los campos que vamos a utilizar y seran editables
    private JTextField nameText;
    private JTextField surnameText;
    private JTextField addressText;
    private JTextField cityText;
    private JTextField postalCodeText;
    private JTextField DNIText;
    private JTextField birthdayText;

    public ClientsGUI(){
        //Creamos etiqueta y campo
    	name = new JLabel("Nombre: ");
    	nameText = new JTextField(20);
    	
    	surname = new JLabel("Apellidos:");
    	surnameText = new JTextField();
    	
    	DNI= new JLabel("DNI: ");
    	DNIText = new JTextField();
    	
    	birthday = new JLabel("Fecha de nacimiento (dd/mm/aa): ");
    	birthdayText = new JTextField();
    	
        //Asignamos a la ventana principal el layout GridBagLayout
    	this.setLayout(new GridBagLayout());
        //tamaño de la ventana
    	this.setSize(600, 200);
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
        add(nameText, constr);
        
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
        
        //Faltan campos
        //Falta opcion elegir tipo de cuenta (desplegable)
        
        //Accion al cerrar la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        ClientsGUI gui = new ClientsGUI();
    }
}
