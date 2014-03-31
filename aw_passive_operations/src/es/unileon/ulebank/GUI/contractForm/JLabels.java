package es.unileon.ulebank.GUI.contractForm;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class which contains all the JLabels used in the main window
 * @author Emanuel Iosif Relea
 */
public class JLabels {
    
    /**
     * Class constructor
     * @param contentPanel panel where the JLabels are placed
     * @param currency currency used in the contract
     * @param interest interest for the contract
     */
    public JLabels(JPanel contentPanel, JTextField currency, JTextField interest,
    									JPanel panelOwners, JPanel panelAuthorized){
        
        placeLabels(contentPanel, currency, interest, panelOwners, panelAuthorized);
        
    }
    
    /**
     * Places all the JLabels in the main window
     * @param contentPanel panel where the JLabels are placed
     * @param currency currency used in the contract
     * @param interest interest for the contract
     */
    private void placeLabels(JPanel contentPanel,JTextField currency, JTextField interest,
    											JPanel panelOwners, JPanel panelAuthorized){
        
        JLabel contratoApertura = new JLabel("CONTRATO DE APERTURA DE CUENTA CORRIENTE");
	contratoApertura.setFont(new Font("Tahoma", Font.BOLD, 16));
	contratoApertura.setBounds(10, 11, 429, 20);
	contentPanel.add(contratoApertura);
		
	JLabel lblAccNum = new JLabel("N\u00BA");
	lblAccNum.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblAccNum.setBounds(10, 42, 26, 20);
	contentPanel.add(lblAccNum);
        
        JLabel lblIban = new JLabel("IBAN");
	lblIban.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblIban.setBounds(10, 73, 45, 20);
	contentPanel.add(lblIban);
         
        JLabel lblSections = new JLabel("APARTADOS");
	lblSections.setFont(new Font("Times New Roman", Font.BOLD, 24));
	lblSections.setBounds(388, 192, 147, 20);
	contentPanel.add(lblSections);
		
	JLabel involvedParties = new JLabel("2 - INTERVENIENTES");
	involvedParties.setFont(new Font("Tahoma", Font.BOLD, 13));
	involvedParties.setBounds(39, 381, 130, 14);
	contentPanel.add(involvedParties);
		
	JLabel owners = new JLabel("TITULARES");
	owners.setFont(new Font("Tahoma", Font.BOLD, 12));
	owners.setBounds(83, 406, 76, 14);
	contentPanel.add(owners);
		
	JLabel lblAccConf = new JLabel("1 - DATOS CUENTA");
	lblAccConf.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblAccConf.setBounds(39, 273, 130, 14);
	contentPanel.add(lblAccConf);
		
	JLabel lblaccNum2 = new JLabel("N\u00BA de Cuenta:");
	lblaccNum2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblaccNum2.setBounds(83, 309, 87, 14);
	contentPanel.add(lblaccNum2);
		
	JLabel lblModality = new JLabel("Modalidad:");
	lblModality.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblModality.setBounds(482, 307, 78, 14);
	contentPanel.add(lblModality);
		
	JLabel lblCurrency = new JLabel("Moneda:");
	lblCurrency.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblCurrency.setBounds(83, 342, 78, 14);
	contentPanel.add(lblCurrency);
		
	JLabel lblDisponibility = new JLabel("Disponibilidad:");
	lblDisponibility.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblDisponibility.setBounds(482, 340, 78, 14);
	contentPanel.add(lblDisponibility);
                
        JLabel lblName = new JLabel("Nombre(s):");
	lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblName.setBounds(83, 431, 78, 14);
	contentPanel.add(lblName);
		
	JLabel lblSurname = new JLabel("Apellido(s):");
	lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblSurname.setBounds(83, 456, 78, 14);
	contentPanel.add(lblSurname);
		
	JLabel lblBirthDate = new JLabel("Fecha Nacimiento:");
	lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblBirthDate.setBounds(83, 481, 100, 14);
	contentPanel.add(lblBirthDate);
		
	JLabel lblIDNum = new JLabel("NIF/NIE:");
	lblIDNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblIDNum.setBounds(83, 507, 111, 14);
	contentPanel.add(lblIDNum);
		
	JLabel lblstreetAndNum = new JLabel("Calle:");
	lblstreetAndNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblstreetAndNum.setBounds(482, 433, 63, 14);
	contentPanel.add(lblstreetAndNum);
		
	JLabel lblTown = new JLabel("Localidad:");
	lblTown.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblTown.setBounds(482, 458, 63, 14);
	contentPanel.add(lblTown);
		
	JLabel lblProvince = new JLabel("Provincia:");
	lblProvince.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblProvince.setBounds(482, 482, 63, 14);
	contentPanel.add(lblProvince);
		
	JLabel lblCP = new JLabel("C.P:");
	lblCP.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblCP.setBounds(482, 507, 51, 14);
	contentPanel.add(lblCP);
	
	JLabel lblMaritalStatus = new JLabel("Estado Civil:");
	lblMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblMaritalStatus.setBounds(83, 534, 90, 14);
	contentPanel.add(lblMaritalStatus);
        
        JLabel lblPhoneNum = new JLabel("Tel\u00E9fono:");
	lblPhoneNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblPhoneNum.setBounds(482, 532, 63, 14);
	contentPanel.add(lblPhoneNum);
        
        JLabel lblSeparator = new JLabel("-----------------------------------------"
			+ "-----------------------------------------------------------------------"
			+ "-----------------------------------------------------------------");
	lblSeparator.setBounds(83, 5, 718, 14);
	panelOwners.add(lblSeparator);
		
	JLabel lblAuthorized = new JLabel("AUTORIZADOS");
	lblAuthorized.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblAuthorized.setBounds(83, 37, 100, 14);
	panelOwners.add(lblAuthorized);
		
	JLabel lblNameAut = new JLabel("Nombre(s):");
	lblNameAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblNameAut.setBounds(83, 67, 78, 14);
	panelOwners.add(lblNameAut);
		
	JLabel lblSurnameAut = new JLabel("Apellido(s):");
	lblSurnameAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblSurnameAut.setBounds(83, 92, 78, 14);
	panelOwners.add(lblSurnameAut);
		
	JLabel lblBirthDateAut = new JLabel("Fecha Nacimiento:");
	lblBirthDateAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblBirthDateAut.setBounds(83, 117, 100, 14);
	panelOwners.add(lblBirthDateAut);
		
	JLabel lblIDNumAut = new JLabel("NIF/NIE:");
	lblIDNumAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblIDNumAut.setBounds(83, 141, 111, 14);
	panelOwners.add(lblIDNumAut);
		
	JLabel lblstreetAndNumAut = new JLabel("Calle:");
	lblstreetAndNumAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblstreetAndNumAut.setBounds(482, 67, 63, 14);
	panelOwners.add(lblstreetAndNumAut);
		
	JLabel lblTownAut = new JLabel("Localidad:");
	lblTownAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblTownAut.setBounds(482, 92, 63, 14);
	panelOwners.add(lblTownAut);
		
	JLabel lblProvinceAut = new JLabel("Provincia:");
	lblProvinceAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblProvinceAut.setBounds(482, 117, 63, 14);
	panelOwners.add(lblProvinceAut);
		
	JLabel lblCPAut = new JLabel("C.P:");
	lblCPAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblCPAut.setBounds(482, 141, 51, 14);
	panelOwners.add(lblCPAut);		
        
        JLabel lblMaritalStatusAut = new JLabel("Estado Civil:");
	lblMaritalStatusAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblMaritalStatusAut.setBounds(83, 167, 90, 14);
	panelOwners.add(lblMaritalStatusAut);
        
        JLabel lblPhoneNumAut = new JLabel("Tel\u00E9fono:");
	lblPhoneNumAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblPhoneNumAut.setBounds(482, 167, 63, 14);
	panelOwners.add(lblPhoneNumAut);
        
        JLabel label_9 = new JLabel("---------------------------------------------------"
			+ "--------------------------------------------------------------------"
			+ "----------------------------------------------------------");
	label_9.setBounds(83, 2, 718, 14);
	panelAuthorized.add(label_9);
		
	JLabel lblFirstDeposit = new JLabel("3 - IMPORTE PRIMER INGRESO");
	lblFirstDeposit.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblFirstDeposit.setBounds(39, 27, 200, 14);
	panelAuthorized.add(lblFirstDeposit);
        
        JLabel lblCurrency2 = new JLabel("");
	lblCurrency2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblCurrency2.setBounds(149, 65, 90, 14);
	panelAuthorized.add(lblCurrency2);
	lblCurrency2.setText(currency.getText());
		
	JLabel lblPeriodicidad = new JLabel("4 - PERIODICIDAD Y FECHAS DE LIQUIDACI\u00D3N");
	lblPeriodicidad.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblPeriodicidad.setBounds(39, 103, 300, 14);
	panelAuthorized.add(lblPeriodicidad);
		
	JLabel lblPeriod = new JLabel("6 Mes(es)");
	lblPeriod.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblPeriod.setBounds(83, 140, 147, 14);
	panelAuthorized.add(lblPeriod);
		
	JLabel lblInterestType = new JLabel("5 - TIPO DE INTERES");
	lblInterestType.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblInterestType.setBounds(39, 176, 141, 14);
	panelAuthorized.add(lblInterestType);
        
        JLabel lblCurrency3 = new JLabel("Euros");
	lblCurrency3.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblCurrency3.setBounds(149, 207, 90, 14);
	panelAuthorized.add(lblCurrency3);
		
	JLabel lblDate = new JLabel(getDate());
	lblDate.setBounds(103, 246, 182, 14);
	panelAuthorized.add(lblDate);
        
        JLabel lblClausula = new JLabel("CL\u00C1USULAS");
	lblClausula.setFont(new Font("Times New Roman", Font.BOLD, 24));
	lblClausula.setBounds(388, 378, 147, 20);
	panelAuthorized.add(lblClausula);
        
        JLabel lblThirdClause = new JLabel("3 - FORMAS DE DISPOSICI\u00D3N");
	lblThirdClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblThirdClause.setBounds(39, 925, 200, 14);
	panelAuthorized.add(lblThirdClause);
		
	JLabel lblSecondClause = new JLabel("2 - DOCUMENTOS DE PAGO");
	lblSecondClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblSecondClause.setBounds(39, 786, 177, 14);
	panelAuthorized.add(lblSecondClause);
        
        JLabel lblFirstClause = new JLabel("1 - INGRESOS Y CARGOS");
	lblFirstClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblFirstClause.setBounds(39, 453, 177, 14);
	panelAuthorized.add(lblFirstClause);
        
        JLabel lblFourthClause = new JLabel("4 - INTERESES ORDINARIOS");
	lblFourthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblFourthClause.setBounds(39, 1225, 200, 14);
	panelAuthorized.add(lblFourthClause);
		
	JLabel lblInterest = new JLabel("18/03/2014");
	lblInterest.setHorizontalAlignment(SwingConstants.CENTER);
	lblInterest.setBounds(235, 1378, 36, 14);
	panelAuthorized.add(lblInterest);
	lblInterest.setText(interest.getText());
		
	JLabel lblFifthClause = new JLabel("5 - COMISIONES Y GASTOS");
	lblFifthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblFifthClause.setBounds(39, 1445, 200, 14);
	panelAuthorized.add(lblFifthClause);
        
        JLabel lblSixthClause = new JLabel("6 - MODIFICACI\u00D3N DE INTERESES, COMISIONES Y GASTOS");
	lblSixthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblSixthClause.setBounds(39, 1660, 367, 14);
	panelAuthorized.add(lblSixthClause);
		
	JLabel lblSeventhClause = new JLabel("7 - DESCUBIERTOS EN CUENTA");
	lblSeventhClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblSeventhClause.setBounds(39, 1898, 200, 14);
	panelAuthorized.add(lblSeventhClause);
        
        JLabel lblEigthClause = new JLabel("8 - COMPENSACI\u00D3N");
	lblEigthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblEigthClause.setBounds(39, 2105, 147, 14);
	panelAuthorized.add(lblEigthClause);
		
	JLabel lblNinthClause = new JLabel("9 - RESOLUCI\u00D3N DEL CONTRATO");
	lblNinthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNinthClause.setBounds(39, 2265, 211, 14);
	panelAuthorized.add(lblNinthClause);
		
	JLabel lblTenthClause = new JLabel("10 - DOMICILIOS");
	lblTenthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblTenthClause.setBounds(39, 2429, 123, 14);
	panelAuthorized.add(lblTenthClause);
		
	JLabel lblEleventhClause = new JLabel("11 - ENTREGA DE DOCUMENTOS");
	lblEleventhClause.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblEleventhClause.setBounds(39, 2556, 200, 14);
	panelAuthorized.add(lblEleventhClause);
        
        JLabel lblCommonNotes = new JLabel("NOTAS COMUNES PARA TODOS LOS EPIGRAFES");
	lblCommonNotes.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblCommonNotes.setBounds(39, 2907, 442, 20);
	panelAuthorized.add(lblCommonNotes);
		
	JLabel lblNote1 = new JLabel("1 - NORMAS DE VALORACI\u00D3N");
	lblNote1.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNote1.setBounds(39, 2970, 200, 14);
	panelAuthorized.add(lblNote1);
        
        JLabel lblNote2 = new JLabel("2 - \u00C1MBITO DE APLICACI\u00D3N");
	lblNote2.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNote2.setBounds(39, 3055, 200, 14);
	panelAuthorized.add(lblNote2);
		
	JLabel lblNote3 = new JLabel("3 - GASTOS");
	lblNote3.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNote3.setBounds(39, 3191, 100, 14);
	panelAuthorized.add(lblNote3);
        
        JLabel lblEpigrafe8 = new JLabel("EP\u00CDGRAFE 8 - MANTENIMIENTO Y ADMINISTRACI\u00D3N DE CUENTAS");
	lblEpigrafe8.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblEpigrafe8.setBounds(39, 3319, 607, 20);
	panelAuthorized.add(lblEpigrafe8);
		
	JLabel lblEpigrafe1 = new JLabel("1 - COMISI\u00D3N DE MANTENIMIENTO");
	lblEpigrafe1.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblEpigrafe1.setBounds(39, 3376, 248, 14);
	panelAuthorized.add(lblEpigrafe1);
        
        JLabel lblEpigrafe2 = new JLabel("2 - COMISI\u00D3N DE ADMINISTRACI\u00D3N");
	lblEpigrafe2.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblEpigrafe2.setBounds(39, 3660, 248, 14);
	panelAuthorized.add(lblEpigrafe2);
        
        JLabel lblEpigrafe3 = new JLabel("3 - COMISI\u00D3N POR INFORMACI\u00D3N SOBRE MOVIMIENTOS DE LA CUENTA");
	lblEpigrafe3.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblEpigrafe3.setBounds(39, 3782, 463, 14);
	panelAuthorized.add(lblEpigrafe3);
        
        JLabel lblEpigrafe4 = new JLabel("4 - DESCUBIERTOS EN CUENTA");
	lblEpigrafe4.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblEpigrafe4.setBounds(39, 4063, 200, 14);
	panelAuthorized.add(lblEpigrafe4);
        
        JLabel lblEpigrafe5 = new JLabel("5 - GESTI\u00D3N DE RECLAMACI\u00D3N DE DESCUBIERTOS");
	lblEpigrafe5.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblEpigrafe5.setBounds(39, 4168, 338, 14);
	panelAuthorized.add(lblEpigrafe5);
        
        JLabel lblEpigrafe15 = new JLabel("EP\u00CDGRAFE 15 - OPERACIONES DE CUENTAS A LA VISTA");
	lblEpigrafe15.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblEpigrafe15.setBounds(39, 4990, 429, 20);
	panelAuthorized.add(lblEpigrafe15);
		
	JLabel lblOperation1 = new JLabel("1 - LIBRETAS DE AHORRO");
	lblOperation1.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblOperation1.setBounds(39, 5057, 182, 14);
	panelAuthorized.add(lblOperation1);
        
        JLabel lblOperation2 = new JLabel("2 - CUENTAS CORRIENTES");
	lblOperation2.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblOperation2.setBounds(39, 5354, 182, 14);
	panelAuthorized.add(lblOperation2);
        
        JLabel lblAuthorize = new JLabel("AUTORIZACIONES");
	lblAuthorize.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblAuthorize.setBounds(39, 6459, 123, 14);
	panelAuthorized.add(lblAuthorize);
		
	JLabel lblPersonalDataProcessing = new JLabel("TRATAMIENTO AUTOMATIZADO DE DATOS PERSONALES");
	lblPersonalDataProcessing.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblPersonalDataProcessing.setBounds(39, 6650, 400, 14);
	panelAuthorized.add(lblPersonalDataProcessing);
                             
    }
    
    /**
     * Retrieves system's current date
     * @return date Current system date in dd/MM/yyyy format
     */
    private String getDate(){
        
        String date;
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        date = dateFormat.format(cal.getTime());
        
        return date;
    }
    
}
