package es.unileon.aw.GUI.client;
import es.unileon.aw.client.types.Person;
import es.unileon.aw.client.types.data.Address;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

    private JPanel buttonPanel;
    private JButton continueButton;
    private JButton cancelButton;
    private JButton deleteField;
    
    public ClientsGUI(){
        //Creamos etiqueta y campo
    	name = new JLabel("*Nombre: ",JLabel.RIGHT);
    	nameText = new JTextField(23);

    	surname = new JLabel("*Apellidos:",JLabel.RIGHT);
    	surnameText = new JTextField(23);
    	
    	DNI= new JLabel("*DNI: ",JLabel.RIGHT);
    	DNIText = new JTextField(23);
    	
    	birthday = new JLabel("*Fecha de nacimiento(dd/mm/aa): ",JLabel.RIGHT);
    	birthdayText = new JTextField(23);
        /////////////////////////////////////
        address = new JLabel("*Calle ",JLabel.RIGHT);
        addressText = new JTextField();
      
        number = new JLabel("Portal: ",JLabel.RIGHT);
        numberText = new JTextField(4);
        
        portal = new JLabel("Piso: ",JLabel.RIGHT);
        portalText = new JTextField(4);
        
        postalCode = new JLabel("*CP: ",JLabel.RIGHT);
        postalCodeText=  new JTextField();
        
        city = new JLabel("Ciudad: ",JLabel.RIGHT);
        cityText = new JTextField();
        
        country = new JLabel("Pais: ",JLabel.RIGHT);
        countryText = new JTextField();
        //////////////////////////////////////
        
        relationship = new JLabel("*Estado civil: ",JLabel.RIGHT);
        relationshipText = new JTextField();
        
        phone = new JLabel("*Telefono: ",JLabel.RIGHT);
        phoneText1 = new JTextField(10);
        
        phone2 = new JLabel("Telefono: ",JLabel.RIGHT);
        phoneText2 = new JTextField(10);
        
        accountType = new JLabel("Tipo de cuenta: ",JLabel.RIGHT);
        accountTypeSeleccion = new Choice();
        accountTypeSeleccion.addItem("Tipo Cuenta 1");
        accountTypeSeleccion.addItem("Tipo Cuenta 2");
        accountTypeSeleccion.addItem("Tipo Cuenta 3");
        
        buttonPanel = new JPanel();
        continueButton = new JButton("CONTINUAR");
        cancelButton = new JButton ("CANCELAR");
        deleteField = new JButton("RESET");
    	
        //Asignamos a la ventana principal el layout GridBagLayout
    	this.setLayout(new GridBagLayout());
        //tamaño de la ventana
    	this.setSize(700, 400);
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
    	constr.insets=new Insets(5,0,0,0);
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
        constr.anchor=GridBagConstraints.EAST;
        constr.gridwidth=1;
        add(DNI, constr);
        constr.gridwidth = GridBagConstraints.REMAINDER;
        add(DNIText, constr);
        
        //Fecha de nacimiento
        constr.fill=GridBagConstraints.HORIZONTAL;
        constr.anchor=GridBagConstraints.WEST;
        constr.gridwidth=1;
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
        
        //Botones continuar y cancelar. FlowLayout de izq a dcha
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(cancelButton);
        buttonPanel.add(deleteField);
        buttonPanel.add(continueButton);
        
        constr.anchor=GridBagConstraints.SOUTH;
        constr.insets = new Insets(25, 0, 0, 0);
        add(buttonPanel, constr);
        
        DNIText.addKeyListener(new KeyAdapter(){
   @Override
   public void keyTyped(KeyEvent e){
      char caracter = e.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         e.consume();  // ignorar el evento de teclado
      }
   }
});
        
        continueButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                  validate(nameText);
                  validate(surnameText);
                  validate(addressText);
                  validate(postalCodeText);
                  validate(DNIText);
                  validate(birthdayText);
                  validate(relationshipText);
                  validate(phoneText1);
                  
                    if(validate(nameText)&&
                  validate(surnameText)&&
                  validate(addressText)&&
                  validate(postalCodeText)&&
                  validate(DNIText)&&
                  validate(birthdayText)&&
                  validate(relationshipText)&&
                  validate(phoneText1)){
                  //Crear cliente
                        int phone2;
                        if(phoneText2.getText().compareTo("")==0){
                            phone2=0;
                        }else{
                            phone2=Integer.parseInt(phoneText2.getText());
                        }
                      Person person = new Person(nameText.getText(), surnameText.getText(), null, relationshipText.getText(), Integer.parseInt(phoneText1.getText()), phone2, null, Integer.parseInt(DNIText.getText()));
                      
                      System.out.println(person.getId().toString());
                  }else{
                      System.out.println("No validado");
                  }
                }
            });
        deleteField.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    deleteFields(nameText);
                    deleteFields(surnameText);
                    deleteFields(addressText);
                    deleteFields(portalText);
                    deleteFields(numberText);
                    deleteFields(postalCodeText);
                    deleteFields(DNIText);
                    deleteFields(birthdayText);
                    deleteFields(relationshipText);
                    deleteFields(phoneText1);
                    deleteFields(phoneText2);
                    deleteFields(cityText);
                    deleteFields(countryText);     
                }
            });
        //Accion al cerrar la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    /*
    Comprobar si los campos estan vacios
    */
    public boolean validate(JTextField text){
        boolean validate = false;
        if(text.getText().trim().length()==0){
            text.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else{
            validate=true;
            text.setBorder(BorderFactory.createLineBorder(null));
        }
        return validate;
    }
    
    public void deleteFields(JTextField t){
        t.setText("");
    }
    
    
    public static void main(String[] args) {
        ClientsGUI gui = new ClientsGUI();
    }
}
