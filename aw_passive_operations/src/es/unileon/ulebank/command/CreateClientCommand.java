/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.command;



import es.unileon.ulebank.client.handler.PersonHandler;
import es.unileon.ulebank.client.types.Person;
import es.unileon.ulebank.client.types.data.Address;
import es.unileon.ulebank.handler.MalformedHandlerException;
import java.util.Date;




/**
 *
 * @author Paula
 */
public class CreateClientCommand implements Command{
   
    private String name;
    private String surnames;
    private String civilState;
    private Address address;
    private String profession;
    private char foreingLetter;
    private int dniNumber;
    private char dniLetter;
    private Date birthDate;
    private int phoneNumber1, phoneNumber2;
   
   
    
    public CreateClientCommand(String name, String surnames, Address address, String civilState, int phoneNumber1, int phoneNumber2, String profession,Date birthDate,char foreingLetter, int dniNumber, char dniLetter) throws MalformedHandlerException {
 
    this.name=name;
    this.surnames=surnames;
    this.address= address;
    this.civilState=civilState;
    this.phoneNumber1=phoneNumber1;
    this.phoneNumber2=phoneNumber2;
    this.profession=profession;
    this.birthDate=birthDate;
   
    
    }
    
    @Override
    public void execute() throws MalformedHandlerException {
        Person client = null;
       
       client = new Person(this.name, this.surnames, this.address, this.civilState, this.phoneNumber1, this.phoneNumber2, this.profession, this.birthDate,this.foreingLetter, this.dniNumber, this.dniLetter);
       
    }

    
    
}
