/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.command;



import es.unileon.ulebank.client.handler.PersonHandler;
import es.unileon.ulebank.client.types.Person;
import es.unileon.ulebank.handler.MalformedHandlerException;




/**
 *
 * @author Paula
 */
public class CreateClientCommand implements Command{
   
    private Person name;
    private Person surnames;
    private Person civilState;
    private Person address;
    private Person profession;
    private PersonHandler nif;
    private Person birthDate;
    private Person phoneNumber1, phoneNumber2;
   
    
    public CreateClientCommand(Person name, Person surnames, Person civilState,Person phoneNumber1, Person phoneNumber2, Person profession, Person address, PersonHandler nif,Person birthDate, int dni, char letter) throws MalformedHandlerException {
    this.name=name;
    this.surnames=surnames;
    this.address= address;
    this.civilState=civilState;
    this.nif= new PersonHandler(dni, letter);
    this.phoneNumber1=phoneNumber1;
    this.phoneNumber2=phoneNumber2;
    this.profession=profession;
    this.birthDate=birthDate;
   
    
    }
    
    @Override
    public void execute() {
       this.name.getName();
       this.surnames.getSurnames();
       this.address.getAddress();
       this.birthDate.getBirthDate();
       this.civilState.getCivilState();
       this.profession.getProfession();
       this.phoneNumber1.getPhoneNumber(1);
       this.phoneNumber2.getPhoneNumber(2);
       this.nif.toString();
       
    }

    
    
}
