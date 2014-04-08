package es.unileon.ulebank.GUI.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class which represents the owner panel with all its corresponding personal info fields
 * @author Manu
 */

@SuppressWarnings("serial")
public class JClientPanel extends JPanel{
	
        /**
         * Owner's name
         */
	private JTextField name;
        
        /**
         * Owner's surname
         */
	private JTextField surname;
        
        /**
         * Owner's birth date
         */
	private JTextField birthDate;
        
        /**
         * Owner's id number
         */
	private JTextField dNI;
        
        /**
         * Owner's marital status
         */
	private JTextField maritalStatus;
        
        /**
         * Owner's address
         */
	private JTextField streetAndNum;
        
        /**
         * Owner's current residence town
         */
	private JTextField town;
        
        /**
         * Owner's province
         */
	private JTextField province;
        
        /**
         * Owner's zipCode
         */
	private JTextField zipCode;
        
        /**
         * Owner's phone number
         */
	private JTextField phoneNumber;

        
        /**
         * Class constructor
         */
	public JClientPanel(){
		
		drawPanel();
		
	}
	
	public void drawPanel(){
		
                this.setSize(947, 135);
                this.setLayout(null);

                name = new JTextField();
                name.setHorizontalAlignment(SwingConstants.CENTER);
                name.setColumns(10);
                name.setBackground(Color.WHITE);
                name.setBounds(193, 11, 222, 20);
                this.add(name);

                surname = new JTextField();
                surname.setHorizontalAlignment(SwingConstants.CENTER);
                surname.setColumns(10);
                surname.setBackground(Color.WHITE);
                surname.setBounds(193, 36, 222, 20);
                this.add(surname);

                birthDate = new JTextField();
                birthDate.setText("dd/mm/aaaa");
                birthDate.setHorizontalAlignment(SwingConstants.CENTER);
                birthDate.setColumns(10);
                birthDate.setBackground(Color.WHITE);
                birthDate.setBounds(193, 61, 111, 20);
                this.add(birthDate);

                birthDate.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent arg0) {
                                        birthDate.setText("");
                                }
                        });

                dNI = new JTextField();
                dNI.setHorizontalAlignment(SwingConstants.CENTER);
                dNI.setColumns(10);
                dNI.setBackground(Color.WHITE);
                dNI.setBounds(193, 86, 111, 20);
                this.add(dNI);

                maritalStatus = new JTextField();
                maritalStatus.setHorizontalAlignment(SwingConstants.CENTER);
                maritalStatus.setColumns(10);
                maritalStatus.setBackground(Color.WHITE);
                maritalStatus.setBounds(193, 111, 111, 20);
                this.add(maritalStatus);

                streetAndNum = new JTextField();
                streetAndNum.setHorizontalAlignment(SwingConstants.CENTER);
                streetAndNum.setColumns(10);
                streetAndNum.setBackground(Color.WHITE);
                streetAndNum.setBounds(546, 11, 244, 20);
                this.add(streetAndNum);

                town = new JTextField();
                town.setHorizontalAlignment(SwingConstants.CENTER);
                town.setColumns(10);
                town.setBackground(Color.WHITE);
                town.setBounds(546, 36, 244, 20);
                this.add(town);

                province = new JTextField();
                province.setHorizontalAlignment(SwingConstants.CENTER);
                province.setColumns(10);
                province.setBackground(Color.WHITE);
                province.setBounds(546, 61, 244, 20);
                this.add(province);

                zipCode = new JTextField();
                zipCode.setHorizontalAlignment(SwingConstants.CENTER);
                zipCode.setColumns(10);
                zipCode.setBackground(Color.WHITE);
                zipCode.setBounds(546, 86, 100, 20);
                this.add(zipCode);

                phoneNumber = new JTextField();
                phoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
                phoneNumber.setColumns(10);
                phoneNumber.setBackground(Color.WHITE);
                phoneNumber.setBounds(546, 111, 100, 20);
                this.add(phoneNumber);

                JLabel lblName = new JLabel("Nombre(s):");
                lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblName.setBounds(80, 11, 78, 14);
                this.add(lblName);

                JLabel lblSurname = new JLabel("Apellido(s):");
                lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblSurname.setBounds(80, 36, 78, 14);
                this.add(lblSurname);

                JLabel lblBirthDate = new JLabel("Fecha Nacimiento:");
                lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblBirthDate.setBounds(80, 61, 150, 14);
                this.add(lblBirthDate);

                JLabel lblIDNum = new JLabel("NIF/NIE:");
                lblIDNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblIDNum.setBounds(80, 86, 111, 14);
                this.add(lblIDNum);

                JLabel lblMaritalStatus = new JLabel("Estado Civil:");
                lblMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblMaritalStatus.setBounds(80, 111, 90, 14);
                this.add(lblMaritalStatus);

                JLabel lblstreetAndNum = new JLabel("Calle:");
                lblstreetAndNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblstreetAndNum.setBounds(482, 13, 63, 14);
                this.add(lblstreetAndNum);

                JLabel lblTown = new JLabel("Localidad:");
                lblTown.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblTown.setBounds(482, 38, 63, 14);
                this.add(lblTown);

                JLabel lblProvince = new JLabel("Provincia:");
                lblProvince.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblProvince.setBounds(482, 63, 63, 14);
                this.add(lblProvince);

                JLabel lblCP = new JLabel("C.P:");
                lblCP.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblCP.setBounds(482, 88, 51, 14);
                this.add(lblCP);   	

                JLabel lblPhoneNum = new JLabel("Tel\u00E9fono:");
                lblPhoneNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
                lblPhoneNum.setBounds(482, 113, 63, 14);
                this.add(lblPhoneNum);
		
	}

        /*
        * GETTERS AND SETTERS FOR ALL ATTRIBUTES
        */
        
	public String getName() {
		return name.getText();
	}

	public void setName(String name) {
		this.name.setText(name);
	}

	public String getSurname() {
		return surname.getText();
	}

	public void setSurname(String surname) {
		this.surname.setText(surname);;
	}

	public String getBirthDate() {
		return birthDate.getText();
	}

	public void setBirthDate(String birthDate) {
		this.birthDate.setText(birthDate);;
	}

	public String getdNI() {
		return dNI.getText();
	}

	public void setdNI(String dNI) {
		this.dNI.setText(dNI);;
	}

	public String getMaritalStatus() {
		return maritalStatus.getText();
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus.setText(maritalStatus);;
	}

	public String getStreetAndNum() {
		return streetAndNum.getText();
	}

	public void setStreetAndNum(String streetAndNum) {
		this.streetAndNum.setText(streetAndNum);;
	}

	public String getTown() {
		return town.getText();
	}

	public void setTown(String town) {
		this.town.setText(town);;
	}

	public String getProvince() {
		return province.getText();
	}

	public void setProvince(String province) {
		this.province.setText(province);;
	}

	public String getZipCode() {
		return zipCode.getText();
	}

	public void setZipCode(String zipCode) {
		this.zipCode.setText(zipCode);;
	}

	public String getPhoneNumber() {
		return phoneNumber.getText();
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.setText(phoneNumber);
	}
	
	

}
