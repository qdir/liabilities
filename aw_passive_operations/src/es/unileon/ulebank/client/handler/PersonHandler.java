/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client.handler;

import es.unileon.ulebank.handler.Handler;

/**
 *
 * @author Gonzalo
 */
public class PersonHandler implements Handler{
    
    int dni;
    char letter;
    
    public PersonHandler(int dni, char letter){
        //TODO throws exception id dni isn't correct
        this.dni=dni;
    }
    @Override
    public int compareTo(Handler another) {
        return this.toString().compareTo(another.toString());
    }
    
    @Override
    public String toString(){
        return Integer.toString(dni);
    }
    /*private char getDniLetter(int dni){
        return 'A';
    }*/
    
}
