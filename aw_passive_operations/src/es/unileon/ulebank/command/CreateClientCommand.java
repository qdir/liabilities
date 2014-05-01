/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.command;

import es.unileon.ulebank.client.PersonHandler;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.client.Address;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paula
 */
public class CreateClientCommand implements Command {

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
    private Office office;
    private Client client;

    public CreateClientCommand(Office office, String name, String surnames, Address address, String civilState, int phoneNumber1, int phoneNumber2, String profession, Date birthDate, char foreingLetter, int dniNumber, char dniLetter) {
        this.name = name;
        this.surnames = surnames;
        this.address = address;
        this.civilState = civilState;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.profession = profession;
        this.birthDate = birthDate;
        this.office = office;

    }

    @Override
    public void execute() {
        this.client = null;
        try {
            this.client = new Person(this.name, this.surnames, this.address, this.civilState, this.phoneNumber1, this.phoneNumber2, this.profession, this.birthDate, this.foreingLetter, this.dniNumber, this.dniLetter);
            this.office.addClient(client);
        } catch (MalformedHandlerException ex) {
            Logger.getLogger(CreateClientCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Date getEffectiveDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Handler getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        if (this.client != null) {
            this.office.deleteClient(this.client.getId());
        }
    }

    @Override
    public void redo() {
        if (this.client != null) {
            this.office.addClient(this.client);
        }
    }

}
