/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.command;

import es.unileon.ulebank.client.EnterpriseHandler;
import es.unileon.ulebank.client.Enterprise;
import es.unileon.ulebank.handler.Handler;
import java.util.Date;

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

    @Override
    public Date getEffectiveDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Handler getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
