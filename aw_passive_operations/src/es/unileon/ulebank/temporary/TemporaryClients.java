/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.temporary;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.handler.PersonHandler;
import es.unileon.ulebank.client.types.Person;
import es.unileon.ulebank.client.types.data.Address;
import java.util.ArrayList;
import java.util.Date;


////////////////////INCOMPLETO/////////////////////

/**
 *
 * @author Eva
 */
public class TemporaryClients {
 
    private static ArrayList<Client> clients = new ArrayList<Client>();
    
    public TemporaryClients(){
       
        Address addressTest = new Address("Jose maria fernandez", 20, 8, 'D', "Leon", "Leon", 25001);
        Client clientTest = new Person("Maria", "Fernandez Gomez", addressTest, "married",
                                    666123456, 918456138, "estudiante" , 71463465, 'G', new Date(1995, 10, 5));
     clients.add(clientTest);
    }
    
    public static Client findClient(int DNI, char letter){
        System.out.println("vamos a buscar");
        System.out.println("numero clientes: "+ clients.size());
        Client person = null;
        if(clients.size()>0){
            try{
                for( int i = 0 ; i < clients.size() ; i++ ){
                    System.out.println("Dentro del for");
                    System.out.println(clients.get(i).getId().toString());
                    if(clients.get(i).getId().compareTo(new PersonHandler(DNI, letter))==0){
                        System.out.println("son iguales los DNI");
                        person = clients.get(i);
                        i=clients.size();
                    }
                }
            }catch(NullPointerException exception){
                exception.printStackTrace();
                System.out.println("La lista de clientes esta vacia");
            }
        }else{
             System.out.println("No hay clientes");
        }
        return person;
        
    }

    public static void addClient(Person person){
        clients.add(person);
        System.out.println("Cliente añadido a la lista temporal");
    }
}
