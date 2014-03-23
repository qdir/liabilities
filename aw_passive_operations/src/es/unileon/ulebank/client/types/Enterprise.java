/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client.types;

import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.handler.EnterpriseHandler;
import es.unileon.ulebank.client.types.data.Address;
import es.unileon.ulebank.handler.Handler;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Gonzalo
 */
public class Enterprise extends Client{

    private ArrayList<Person> authorizedPersons;
    private String enterpriseName;
    private Address address;
    
    
    public Enterprise(char cifLetter, int cifNumber) {
        super(new EnterpriseHandler(cifLetter, cifNumber));
        authorizedPersons = new ArrayList<Person>();
    }
    
    public Enterprise(char cifLetter, int cifNumber, String enterpriseName, Address address) {
        super(new EnterpriseHandler(cifLetter, cifNumber));
        authorizedPersons = new ArrayList<Person>();
        this.enterpriseName=enterpriseName;
        this.address = address;
    }
    
    public void addAuthorizedPerson(Person person){
        if(!existsAuthorizedPerson(person.getId()))
            authorizedPersons.add(person);
    }
    
    public Person removeAuthorizedPerson(Handler personHandler){
        Person result=null;
        Iterator<Person> iterator = authorizedPersons.iterator();
        while(iterator.hasNext()){
            Person person = iterator.next();
            if(person.getId().compareTo(personHandler)==0){
                result=person;
                authorizedPersons.remove(person);
            }
        }
        return result;
    }
    
    public boolean existsAuthorizedPerson(Handler personHandler){
        boolean result=false;
        Iterator<Person> iterator = authorizedPersons.iterator();
        while(iterator.hasNext()){
            Person person = iterator.next();
            if(person.getId().compareTo(personHandler)==0)
                result=true;
        }
        return result;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
}
