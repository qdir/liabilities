/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.temporary;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.handler.PersonHandler;
import es.unileon.ulebank.client.types.Person;
import java.util.ArrayList;


////////////////////INCOMPLETO/////////////////////

/**
 *
 * @author Eva
 */
public class TemporaryClients {
 
    private static ArrayList<Client> clients = new ArrayList<Client>();
    
    public TemporaryClients(){
  
    }
    
    public static void findClient(int DNI, char letter){
        System.out.println("vamos a buscar");
        System.out.println("numero clientes: "+ clients.size());
        if(clients.size()>0){
            try{
                for( int i = 0 ; i < clients.size() ; i++ ){
                    System.out.println("Dentro del for");
                    System.out.println(clients.get(i).getId().toString());
                    if(clients.get(i).getId().compareTo(new PersonHandler(DNI, letter))==0){
                        System.out.println("son iguales los DNI");
                    }
                }
            }catch(NullPointerException exception){
                exception.printStackTrace();
                System.out.println("La lista de clientes esta vacia");
            }
        }else{
             System.out.println("No hay clientes");
        }
        
    }

    public static void addClient(Person person){
    clients.add(person);
    System.out.println("Cliente añadido a la lista temporal");
    }
}
