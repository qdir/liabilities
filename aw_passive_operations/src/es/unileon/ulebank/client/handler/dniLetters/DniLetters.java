/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client.handler.dniLetters;

/**
 *
 * @author Gonzalo
 */
public class DniLetters {
    
    private static DniLetters instance=null;
    private char[] dniLetters;
    
    private DniLetters(){
        
        char[] dniLetters = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};     
        this.dniLetters=dniLetters;
    }
    
    public static DniLetters getInstance(){
        if(instance == null)
                instance = new DniLetters();
        return instance;
    }
    
    public boolean isDniValid(int dniNumber, char dniLetter){
        boolean result = false;
        int dniRest = dniNumber % 23;
        if(dniRest<23 && dniLetters[dniRest]==dniLetter)
            result=true;
        return result;
    }
    
}
