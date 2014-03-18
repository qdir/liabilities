/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client.types;

import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.handler.PersonHandler;
import es.unileon.ulebank.client.types.data.Address;
import es.unileon.ulebank.handler.Handler;

/**
 *
 * @author Gonzalo
 */
public class Person extends Client{
    
    private String name;
    private String surnames;
    private Address address;
    private String civilState;
    private int[] phoneNumbers;
    private String profession;
    
    public Person(int dniNumber){
        super(new PersonHandler(dniNumber));
        phoneNumbers = new int[2];
    }

    public Person(String name, String surnames, Address address, String civilState, int phoneNumber1, int phoneNumber2, String profession, int dniNumber) {
        super(new PersonHandler(dniNumber));
        this.name = name;
        this.surnames = surnames;
        this.address = address;
        this.civilState = civilState;
        this.phoneNumbers = new int[2];
        this.phoneNumbers[0]=phoneNumber1;
        this.phoneNumbers[1]=phoneNumber2;
        this.profession = profession;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCivilState() {
        return civilState;
    }

    public void setCivilState(String civilState) {
        this.civilState = civilState;
    }

    public int getPhoneNumber(int pos) {
        if(pos<=1 && pos>=0)
            return phoneNumbers[pos];
        else
            return 0;
    }

    public void replacePhoneNumber(int pos,int phoneNumbers) {
        if(pos<=1 && pos>=0)
            this.phoneNumbers[pos] = phoneNumbers;
       //else
            //TODO Exception
    }

    public void removePhoneNumber(int pos){
        //TODO
    }
    
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    
}
