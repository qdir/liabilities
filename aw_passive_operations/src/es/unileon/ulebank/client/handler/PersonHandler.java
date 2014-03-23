/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client.handler;

import es.unileon.ulebank.client.handler.dniLetters.DniLetters;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;

/**
 *
 * @author Gonzalo
 */
public class PersonHandler implements Handler{
    
    int dni;
    char letter;
    
    public PersonHandler(int dni, char letter){
        //TODO throws exception id dni isn't correct
        if(DniLetters.getInstance().isDniValid(dni, letter)){
            this.dni=dni;
            this.letter=letter;
        }else{
            //throw new MalformedHandlerException();
        }
    }
    @Override
    public int compareTo(Handler another) {
        return this.toString().compareTo(another.toString());
    }
    
    @Override
    public String toString(){
        return Integer.toString(dni)+letter;
    }
    
}
