package es.unileon.ulebank.temporary;

import es.unileon.ulebank.client.*;
import es.unileon.ulebank.client.types.Person;
import es.unileon.ulebank.client.types.data.Address;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Tomporary class which simulates a client "database". 
 * Intended for internal tests only.
 * 
 * @author Usuario
 */
public class TemporaryClientData {
    
    private static ArrayList<Client> clientList;
    
    /*
    public static void main(String[] args){
        
        new TemporaryClientData();
        
        Iterator<Client> it = clientList.iterator();
        
        while(it.hasNext()){
            
            System.out.println(it.next().getId().toString());
    
        }
    }*/
    
    public TemporaryClientData(){
        
        populateList();
        
    }
    
    private void populateList(){
        
        clientList = new ArrayList();
        
        Address address1 = new Address("Gonzalez Armas", 1, 3, 'C', "La Bagneza", "Leon", 24233);
        Client client1 = new Person("Oscar", "Sevilla Fernandez", address1, "married",
                                    671313555, 987774331, "Surgeon", 96538721, 'Z');
        
        clientList.add(client1);
        
        address1 = new Address("Ordogno", 3, 5, 'A', "Leon", "Leon", 24205);
        client1 = new Person("Manuel", "Quiniones Arroyo", address1, "single",
                                    615444229, 987619443, "Engineer", 74351445, 'E');
        
        clientList.add(client1);
        
        address1 = new Address("Ladreda", 2, 7, 'B', "Onzonilla", "Leon", 24431);
        client1 = new Person("David", "Alvarez Blanco", address1, "divorced",
                                    699645001, 987094231, "Bodybuilder", 48621759, 'M');
        
        clientList.add(client1);
        
    }
    
    /*
    * Getter for Client List
    *
    * @return clientList
    */
    
    public ArrayList<Client> getClientList(){
        
        return clientList;
        
    }
    
}
