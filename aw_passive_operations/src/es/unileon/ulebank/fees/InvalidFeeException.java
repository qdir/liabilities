/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.brokerage.fees;

/**
 *
 * @author roobre
 */
public class InvalidFeeException extends Exception {
    public InvalidFeeException() {
        super("Fee factor must be a positive double");
    }
}
