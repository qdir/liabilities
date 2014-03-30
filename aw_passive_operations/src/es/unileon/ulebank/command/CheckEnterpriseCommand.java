/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.command;

import es.unileon.ulebank.client.handler.EnterpriseHandler;

/**
 *
 * @author Paula
 */

          /****DUDOSO****/


public class CheckEnterpriseCommand implements Command{
        private EnterpriseHandler enterpriseCode;
        
        public CheckEnterpriseCommand(int cif, char letter){
            this.enterpriseCode= new EnterpriseHandler(letter, cif);
            
        }
    @Override
    public void execute() {
        this.enterpriseCode.compareTo(enterpriseCode);
    }
    
}
