/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client.handler;

import es.unileon.ulebank.client.handler.dniLetters.DniLetters;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;

/**
 * Identifies a person with the dni
 * @author Gonzalo Nicolas Barreales
 */
public class PersonHandler implements Handler{
    
    /**
     * DNI number
     */
    int dni;
    
    /**
     * DNI letter
     */
    char letter;
    
    /**
     * Creates the handler of the person with the dni data
     * @param dni
     * @param letter
     * @throws MalformedHandlerException if the letter doesn't match with the dni number
     */
    public PersonHandler(int dni, char letter) throws MalformedHandlerException{
        if(DniLetters.getInstance().isDniValid(dni, letter)){
            this.dni=dni;
            this.letter=letter;
        }else{
            throw new MalformedHandlerException("Incorrect DNI");
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
