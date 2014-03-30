/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.command;

import es.unileon.ulebank.client.handler.EnterpriseHandler;
import es.unileon.ulebank.client.types.Enterprise;

/**
 *
 * @author Paula
 */
public class CreateEnterpriseCommand implements Command{
    private Enterprise name;
    private Enterprise address;
    private EnterpriseHandler enterpriseCode;
        
        public CreateEnterpriseCommand(Enterprise name, Enterprise address, int cif, char letter){
            this.enterpriseCode= new EnterpriseHandler(letter, cif);
            this.name = name;
            this.address=address;
        }
    @Override
    public void execute() {
        this.name.getEnterpriseName();
        this.address.getAddress();
        this.enterpriseCode.toString();
       
    }
    
}
