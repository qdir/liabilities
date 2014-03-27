package es.unileon.ulebank.GUI.contractForm;

import es.unileon.ulebank.GUI.tools.*;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.SystemColor;

import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.util.Random;

/**
 * Class which represents the main window of the form with all its components
 * 
 * @author Emanuel Iosif Relea
 * @version 2.5
 */

public class ContractFormGUI {

        /**
         * Frame of the main window
         */
	private JFrame mainFrame;
        
        /**
         * Account number assigned to the account to be created
         */
	private JTextField accNum;
        
        /**
         * IBAN number assigned to the account to be created
         */
	private JTextField iban;
        
        /**
         * Account number assigned to the account to be created
         */
	private JTextField accNum2;
        
        /**
         * Currency used in the contract
         */
	private JTextField currency;
        
        /**
         * Name of the owner
         */
	private JTextField name;
        
        /**
         * Surname of the owner
         */
	private JTextField surname;
        
        /**
         * Birth date of the owner
         */
	private JTextField birthDate;
        
        /**
         * ID number of the owner
         */
	private JTextField iDNum;
        
        /**
         * Street number of the owner
         */
	private JTextField streetAndNum;
        
        /**
         * Owner's locality
         */
	private JTextField town;
        
        /**
         * Owner's province
         */
	private JTextField province;
        
        /**
         * Owner's ZipCode
         */
	private JTextField cP;
        
        /**
         * Authorized Person name
         */
	private JTextField nameAut;
        
        /**
         * Authorized Person surname
         */
	private JTextField surnameAut;
        
        /**
         * Authorized Person Birth Date
         */
	private JTextField birthDateAut;
        
        /**
         * Authorized Person id number
         */
	private JTextField iDNumAut;
        
        /**
         * Authorized person street and number
         */
	private JTextField streetAndNumAut;
        
        /**
         * Authorized Person's town
         */
	private JTextField townAut;
        
        /**
         * Authorized Person's Province 
         */
	private JTextField provinceAut;
        
        /**
         * Authorized Person's ZipCode
         */
	private JTextField cPAut;
        
        /**
         * Amount deposited when the account is opened
         */
	private JTextField firstDeposit;
        
        /**
         * Interest charged for the account
         */
	private JTextField interest;
        
        /**
         * Owner's marital status
         */
	private JTextField maritalStatus;
        
        /**
         * Owner's phone number
         */
	private JTextField phoneNum;
        
        /**
         * Authorized Person's marital status 
         */
	private JTextField maritalStatusAut;
        
        /**
         * Authorized Person's phone number
         */
	private JTextField phoneNumAut;
        
        /**
         * Account administration fee charged
         */
	private JTextField administrationWage;
        
        /**
         * Fee charged for unpaid transactions
         */
	private JTextField unpaidWage;
        
        /**
         * Account anual interest
         */
	private JTextField anualInterest;
        
        /**
         * Account monthly fee
         */
	private JTextField anualFee;
        
        /**
         * Monthly fee charged for Firm Accounts modality
         */
	private JTextField monthlyFeeFirm;
        
        /**
         * Monthly fee charged for "Cartilla" Account Modality 
         */
	private JTextField monthlyFeeCartilla;
        
        /**
         * Monthly fee charged for the Free Plus Account Modality
         */
	private JTextField monthlyFeePlus;
        
        /**
         * Trimestrall Fee Personal Account Modality
         */
	private JTextField trimestralFeePersonal;
        
        /**
         * Account Administration Fee
         */
	private JTextField administrationFee;
        
        /**
         * Fee charged when making a withdrawl
         */
	private JTextField withdrawFee;
        
        /**
         * Fee charged for paperwork
         */
	private JTextField paperFee;
        
        /**
         * Account Magnetic Support Fee
         */
	private JTextField magneticSupportFee;
        
        /**
         * Fee charged when the a terminal is used
         */
	private JTextField terminalFee;
        
        /**
         * Fee charged for negative ballance
         */
	private JTextField negativeBallanceFee;
        
        /**
         * Fee charged when complaints are made
         */
	private JTextField complaintFee;
        
        /**
         * Fee charged when making purchases
         */
	private JTextField buyingFee;
        
        /**
         * Percentage used to calculate the fee when making a purchase
         */
	private JTextField buyingFeePercentage;
        
        /**
         * Fee charged when making a deposit
         */
	private JTextField depositOperationFee;
        
        /**
         * Fee charged when making repayments
         */
	private JTextField repaymentFee;
        
        /**
         * Fee charged when cheques cashed
         */
	private JTextField chequeFee;
        
        /**
         * Used to determined whether the Text Fields are activated or not
         */
	private boolean flip = false;       

	public static void main(String[] args) {
		
		new ContractFormGUI();
		
	}

        /**
         * Class constructor which represents the main window
         */
	public ContractFormGUI() {
		launchWindow();
	}

        /**
         * Method which handles all the components of the main window and displays them
         */
	private void launchWindow() {
		
		mainFrame = new JFrame();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		mainFrame.setBounds(0, 0, 1000, screenSize.height-40);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setUndecorated(true);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
                mainFrame.setLocation(mainFrame.getLocation().x, 0);            
		mainFrame.getContentPane().setLayout(null);
		ImageIcon frameImage = new ImageIcon("resources/es/unileon/ulebank/GUI/contractForm/frameImage2.jpg");
		mainFrame.setIconImage(frameImage.getImage());
                
        JPicture customTitleBar = new JPicture("resources/es/unileon/ulebank/GUI/contractForm/customTitleBar.jpg");
        customTitleBar.setBounds(0, 0, 1000, 41);
        mainFrame.getContentPane().add(customTitleBar);
        customTitleBar.setLayout(null);	
        
        JPicture picture = new JPicture("resources/es/unileon/ulebank/GUI/contractForm/grayBackground3.jpg");
        picture.setBounds(0, 40, 1000, screenSize.height-40);
        mainFrame.getContentPane().add(picture);
        picture.setLayout(null);

         new JDraggable(mainFrame, customTitleBar);
										
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 22, 949, screenSize.height-158);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		picture.add(scrollPane);
		
		JPanel contentPanel = new JPanel();
		scrollPane.setViewportView(contentPanel);
		contentPanel.setPreferredSize(new Dimension(931, 7800));
		contentPanel.setLayout(null);				
		
        currency = new JTextField();
		currency.setEditable(false);
		currency.setColumns(10);
		currency.setBackground(SystemColor.menu);
		currency.setBounds(180, 340, 159, 20);
		contentPanel.add(currency);
		currency.setHorizontalAlignment(SwingConstants.CENTER);
		currency.setText("Euros");
                                                  		
		accNum = new JTextField();
		accNum.setEditable(false);
		accNum.setFont(new Font("Tahoma", Font.BOLD, 16));
		accNum.setText("2096 0059 56 3372541904");
		accNum.setBackground(UIManager.getColor("Button.background"));
		accNum.setBounds(65, 42, 222, 20);
		contentPanel.add(accNum);
		accNum.setColumns(10);               
		
		iban = new JTextField();
		iban.setEditable(false);
		iban.setText("ES30 2096 0059 5633 7254 1904");
		iban.setFont(new Font("Tahoma", Font.BOLD, 16));
		iban.setColumns(10);
		iban.setBackground(SystemColor.menu);
		iban.setBounds(65, 73, 274, 20);
		contentPanel.add(iban);				
		
                calcAccNum();
                
		accNum2 = new JTextField();
		accNum2.setEditable(false);
		accNum2.setBackground(UIManager.getColor("Button.background"));
		accNum2.setBounds(180, 307, 159, 20);
		contentPanel.add(accNum2);
		accNum2.setColumns(10);
		accNum2.setHorizontalAlignment(SwingConstants.CENTER);
		accNum2.setText(accNum.getText());						               				
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setColumns(10);
		name.setBackground(UIManager.getColor("Button.highlight"));
		name.setBounds(193, 431, 222, 20);
		contentPanel.add(name);
		
		surname = new JTextField();
		surname.setHorizontalAlignment(SwingConstants.CENTER);
		surname.setColumns(10);
		surname.setBackground(UIManager.getColor("Button.highlight"));
		surname.setBounds(193, 456, 222, 20);
		contentPanel.add(surname);
		
		birthDate = new JTextField();
		birthDate.setText("dd/mm/aaaa");
		birthDate.setHorizontalAlignment(SwingConstants.CENTER);
		birthDate.setColumns(10);
		birthDate.setBackground(UIManager.getColor("Button.highlight"));
		birthDate.setBounds(193, 481, 111, 20);
		contentPanel.add(birthDate);
		
		birthDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				birthDate.setText("");
			}
		});
		
		iDNum = new JTextField();
		iDNum.setHorizontalAlignment(SwingConstants.CENTER);
		iDNum.setColumns(10);
		iDNum.setBackground(UIManager.getColor("Button.highlight"));
		iDNum.setBounds(193, 506, 111, 20);
		contentPanel.add(iDNum);
		
		streetAndNum = new JTextField();
		streetAndNum.setHorizontalAlignment(SwingConstants.CENTER);
		streetAndNum.setColumns(10);
		streetAndNum.setBackground(UIManager.getColor("Button.highlight"));
		streetAndNum.setBounds(546, 431, 244, 20);
		contentPanel.add(streetAndNum);
		
		town = new JTextField();
		town.setHorizontalAlignment(SwingConstants.CENTER);
		town.setColumns(10);
		town.setBackground(UIManager.getColor("Button.highlight"));
		town.setBounds(546, 456, 244, 20);
		contentPanel.add(town);
		
		province = new JTextField();
		province.setHorizontalAlignment(SwingConstants.CENTER);
		province.setColumns(10);
		province.setBackground(UIManager.getColor("Button.highlight"));
		province.setBounds(546, 481, 244, 20);
		contentPanel.add(province);
		
		cP = new JTextField();
		cP.setHorizontalAlignment(SwingConstants.CENTER);
		cP.setColumns(10);
		cP.setBackground(UIManager.getColor("Button.highlight"));
		cP.setBounds(546, 506, 100, 20);
		contentPanel.add(cP);				
		
		JPanel panelOwners = new JPanel();
		panelOwners.setBackground(UIManager.getColor("Panel.background"));
		panelOwners.setBounds(0, 558, 931, 7806);
		contentPanel.add(panelOwners);
		panelOwners.setLayout(null);
		
		JPanel panelAuthorized = new JPanel();
		panelAuthorized.setBounds(0, 192, 931, 7800);
		panelOwners.add(panelAuthorized);
		panelAuthorized.setLayout(null);				
		
		nameAut = new JTextField();
		nameAut.setHorizontalAlignment(SwingConstants.CENTER);
		nameAut.setColumns(10);
		nameAut.setBackground(UIManager.getColor("Button.highlight"));
		nameAut.setBounds(193, 65, 222, 20);
		panelOwners.add(nameAut);
		
		surnameAut = new JTextField();
		surnameAut.setHorizontalAlignment(SwingConstants.CENTER);
		surnameAut.setColumns(10);
		surnameAut.setBackground(UIManager.getColor("Button.highlight"));
		surnameAut.setBounds(193, 90, 222, 20);
		panelOwners.add(surnameAut);
		
		birthDateAut = new JTextField();
		birthDateAut.setText("dd/mm/aaaa");
		birthDateAut.setHorizontalAlignment(SwingConstants.CENTER);
		birthDateAut.setColumns(10);
		birthDateAut.setBackground(UIManager.getColor("Button.highlight"));
		birthDateAut.setBounds(193, 115, 111, 20);
		panelOwners.add(birthDateAut);
		
		birthDateAut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				birthDateAut.setText("");
			}
		});
		
		iDNumAut = new JTextField();
		iDNumAut.setHorizontalAlignment(SwingConstants.CENTER);
		iDNumAut.setColumns(10);
		iDNumAut.setBackground(UIManager.getColor("Button.highlight"));
		iDNumAut.setBounds(193, 140, 111, 20);
		panelOwners.add(iDNumAut);
		
		streetAndNumAut = new JTextField();
		streetAndNumAut.setHorizontalAlignment(SwingConstants.CENTER);
		streetAndNumAut.setColumns(10);
		streetAndNumAut.setBackground(UIManager.getColor("Button.highlight"));
		streetAndNumAut.setBounds(546, 65, 244, 20);
		panelOwners.add(streetAndNumAut);
		
		townAut = new JTextField();
		townAut.setHorizontalAlignment(SwingConstants.CENTER);
		townAut.setColumns(10);
		townAut.setBackground(UIManager.getColor("Button.highlight"));
		townAut.setBounds(546, 90, 244, 20);
		panelOwners.add(townAut);
		
		provinceAut = new JTextField();
		provinceAut.setHorizontalAlignment(SwingConstants.CENTER);
		provinceAut.setColumns(10);
		provinceAut.setBackground(UIManager.getColor("Button.highlight"));
		provinceAut.setBounds(546, 115, 244, 20);
		panelOwners.add(provinceAut);
		
		cPAut = new JTextField();
		cPAut.setHorizontalAlignment(SwingConstants.CENTER);
		cPAut.setColumns(10);
		cPAut.setBackground(UIManager.getColor("Button.highlight"));
		cPAut.setBounds(546, 140, 76, 20);
		panelOwners.add(cPAut);				
		
		firstDeposit = new JTextField();
		firstDeposit.setEditable(false);
		firstDeposit.setText("0");
		firstDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		firstDeposit.setColumns(10);
		firstDeposit.setBackground(UIManager.getColor("Button.background"));
		firstDeposit.setBounds(83, 62, 56, 20);
		panelAuthorized.add(firstDeposit);															
		
		interest = new JTextField();
		interest.setBackground(UIManager.getColor("Button.background"));
		interest.setHorizontalAlignment(SwingConstants.CENTER);
		interest.setEditable(false);
		interest.setText("0");
		interest.setBounds(83, 205, 56, 20);
		panelAuthorized.add(interest);
		interest.setColumns(10); 
		
		maritalStatus = new JTextField();
		maritalStatus.setHorizontalAlignment(SwingConstants.CENTER);
		maritalStatus.setColumns(10);
		maritalStatus.setBackground(Color.WHITE);
		maritalStatus.setBounds(193, 531, 111, 20);
		contentPanel.add(maritalStatus);				
		
		phoneNum = new JTextField();
		phoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNum.setColumns(10);
		phoneNum.setBackground(Color.WHITE);
		phoneNum.setBounds(546, 532, 100, 20);
		contentPanel.add(phoneNum);				
		
		maritalStatusAut = new JTextField();
		maritalStatusAut.setHorizontalAlignment(SwingConstants.CENTER);
		maritalStatusAut.setColumns(10);
		maritalStatusAut.setBackground(Color.WHITE);
		maritalStatusAut.setBounds(192, 165, 111, 20);
		panelOwners.add(maritalStatusAut);
		
		phoneNumAut = new JTextField();
		phoneNumAut.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNumAut.setColumns(10);
		phoneNumAut.setBackground(Color.WHITE);
		phoneNumAut.setBounds(546, 165, 100, 20);
		panelOwners.add(phoneNumAut);																				
		
		administrationWage = new JTextField();
		administrationWage.setHorizontalAlignment(SwingConstants.CENTER);
		administrationWage.setText("0,15");
		administrationWage.setEditable(false);
		administrationWage.setBounds(200, 1512, 45, 20);
		panelAuthorized.add(administrationWage);
		administrationWage.setColumns(10);
		
		unpaidWage = new JTextField();
		unpaidWage.setText("0,00");
		unpaidWage.setHorizontalAlignment(SwingConstants.CENTER);
		unpaidWage.setEditable(false);
		unpaidWage.setBounds(119, 1578, 45, 20);
		panelAuthorized.add(unpaidWage);
		unpaidWage.setColumns(10);				
		
		anualInterest = new JTextField();
		anualInterest.setText("13,75");
		anualInterest.setHorizontalAlignment(SwingConstants.CENTER);
		anualInterest.setEditable(false);
		anualInterest.setColumns(10);
		anualInterest.setBounds(746, 2038, 45, 20);
		panelAuthorized.add(anualInterest);																
		
		anualFee = new JTextField();
		anualFee.setEditable(false);
		anualFee.setText("30,00");
		anualFee.setHorizontalAlignment(SwingConstants.CENTER);
		anualFee.setBounds(236, 3432, 50, 20);
		panelAuthorized.add(anualFee);
		anualFee.setColumns(10);
		
		monthlyFeeFirm = new JTextField();
		monthlyFeeFirm.setText("20,00");
		monthlyFeeFirm.setHorizontalAlignment(SwingConstants.CENTER);
		monthlyFeeFirm.setEditable(false);
		monthlyFeeFirm.setColumns(10);
		monthlyFeeFirm.setBounds(263, 3513, 50, 20);
		panelAuthorized.add(monthlyFeeFirm);
		
		monthlyFeeCartilla = new JTextField();
		monthlyFeeCartilla.setText("4,00");
		monthlyFeeCartilla.setHorizontalAlignment(SwingConstants.CENTER);
		monthlyFeeCartilla.setEditable(false);
		monthlyFeeCartilla.setColumns(10);
		monthlyFeeCartilla.setBounds(263, 3545, 50, 20);
		panelAuthorized.add(monthlyFeeCartilla);
		
		monthlyFeePlus = new JTextField();
		monthlyFeePlus.setText("3,00");
		monthlyFeePlus.setHorizontalAlignment(SwingConstants.CENTER);
		monthlyFeePlus.setEditable(false);
		monthlyFeePlus.setColumns(10);
		monthlyFeePlus.setBounds(263, 3577, 50, 20);
		panelAuthorized.add(monthlyFeePlus);
		
		trimestralFeePersonal = new JTextField();
		trimestralFeePersonal.setText("10,00");
		trimestralFeePersonal.setHorizontalAlignment(SwingConstants.CENTER);
		trimestralFeePersonal.setEditable(false);
		trimestralFeePersonal.setColumns(10);
		trimestralFeePersonal.setBounds(266, 3609, 50, 20);
		panelAuthorized.add(trimestralFeePersonal);				
		
		administrationFee = new JTextField();
		administrationFee.setText("0,25");
		administrationFee.setHorizontalAlignment(SwingConstants.CENTER);
		administrationFee.setEditable(false);
		administrationFee.setColumns(10);
		administrationFee.setBounds(327, 3700, 50, 20);
		panelAuthorized.add(administrationFee);										
		
        JPicture table1 = new JPicture("resources/es/unileon/ulebank/GUI/contractForm/table1.png");
        table1.setBounds(83, 3825, 807, 202);
        panelAuthorized.add(table1);
        table1.setLayout(null);
                
		withdrawFee = new JTextField();
		withdrawFee.setEditable(false);
		withdrawFee.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawFee.setText("Gratuito");
		withdrawFee.setBounds(495, 41, 60, 17);
		table1.add(withdrawFee);
		withdrawFee.setColumns(10);
		
		paperFee = new JTextField();
		paperFee.setText("1,50");
		paperFee.setHorizontalAlignment(SwingConstants.CENTER);
		paperFee.setEditable(false);
		paperFee.setColumns(10);
		paperFee.setBounds(495, 60, 60, 17);
		table1.add(paperFee);
		
		magneticSupportFee = new JTextField();
		magneticSupportFee.setText("6,00");
		magneticSupportFee.setHorizontalAlignment(SwingConstants.CENTER);
		magneticSupportFee.setEditable(false);
		magneticSupportFee.setColumns(10);
		magneticSupportFee.setBounds(495, 81, 60, 17);
		table1.add(magneticSupportFee);
		
		terminalFee = new JTextField();
		terminalFee.setText("6,00");
		terminalFee.setHorizontalAlignment(SwingConstants.CENTER);
		terminalFee.setEditable(false);
		terminalFee.setColumns(10);
		terminalFee.setBounds(495, 102, 60, 17);
		table1.add(terminalFee);				
		
		negativeBallanceFee = new JTextField();
		negativeBallanceFee.setText("4");
		negativeBallanceFee.setHorizontalAlignment(SwingConstants.CENTER);
		negativeBallanceFee.setEditable(false);
		negativeBallanceFee.setColumns(10);
		negativeBallanceFee.setBounds(547, 4101, 50, 20);
		panelAuthorized.add(negativeBallanceFee);
										
		complaintFee = new JTextField();
		complaintFee.setText("25,00");
		complaintFee.setHorizontalAlignment(SwingConstants.CENTER);
		complaintFee.setEditable(false);
		complaintFee.setColumns(10);
		complaintFee.setBounds(451, 4205, 50, 20);
		panelAuthorized.add(complaintFee);				
		
		buyingFee = new JTextField();
		buyingFee.setText("5,00");
		buyingFee.setHorizontalAlignment(SwingConstants.CENTER);
		buyingFee.setEditable(false);
		buyingFee.setColumns(10);
		buyingFee.setBounds(108, 4929, 50, 20);
		panelAuthorized.add(buyingFee);
		
		buyingFeePercentage = new JTextField();
		buyingFeePercentage.setText("0,18");
		buyingFeePercentage.setHorizontalAlignment(SwingConstants.CENTER);
		buyingFeePercentage.setEditable(false);
		buyingFeePercentage.setColumns(10);
		buyingFeePercentage.setBounds(305, 4929, 50, 20);
		panelAuthorized.add(buyingFeePercentage);				
		
		JPicture table2 = new JPicture("resources/es/unileon/ulebank/GUI/contractForm/table2.png");
		table2.setBounds(39, 5098, 851, 207);
		panelAuthorized.add(table2);
		table2.setLayout(null);
		
		depositOperationFee = new JTextField();
		depositOperationFee.setText("10,00");
		depositOperationFee.setHorizontalAlignment(SwingConstants.CENTER);
		depositOperationFee.setEditable(false);
		depositOperationFee.setColumns(10);
		depositOperationFee.setBounds(715, 55, 50, 17);
		table2.add(depositOperationFee);
		
		repaymentFee = new JTextField();
		repaymentFee.setText("10,00");
		repaymentFee.setHorizontalAlignment(SwingConstants.CENTER);
		repaymentFee.setEditable(false);
		repaymentFee.setColumns(10);
		repaymentFee.setBounds(715, 73, 50, 17);
		table2.add(repaymentFee);										
		
        JPicture table3 = new JPicture("resources/es/unileon/ulebank/GUI/contractForm/table3.png");
        table3.setLayout(null);
        table3.setBounds(39, 5409, 851, 96);
        panelAuthorized.add(table3);
                
		chequeFee = new JTextField();
		chequeFee.setText("10,00");
		chequeFee.setHorizontalAlignment(SwingConstants.CENTER);
		chequeFee.setEditable(false);
		chequeFee.setColumns(10);
		chequeFee.setBounds(706, 47, 50, 17);
		table3.add(chequeFee);								
        
		//INITIALIZE JLABELS HERE
        new JLabels(contentPanel, currency, interest, panelOwners, panelAuthorized);
		//INITIALIZE JPICTURES HERE
        new JPictures(contentPanel, panelAuthorized);
        //INITIALIZE JTEXTAREAS HERE
        new JTextAreas(panelAuthorized);
        //INITIALIZE JBUTTONS HERE
        JButtons buttons = new JButtons(mainFrame, customTitleBar, contentPanel, picture,
        													panelOwners, panelAuthorized);
        //INITIALIZE JCOMBOBOXES HERE
		Runnable task = new JComboBoxes(contentPanel, buttons.getAddOwnerButton(), buttons);
		
		Thread worker = new Thread(task);
        worker.start();
        buttons.setWorker(worker);
        
        Icon editIcon = new ImageIcon("resources/es/unileon/ulebank/GUI/contractForm/EditButton.jpg");
        JButton editButton = new JButton(editIcon);
		editButton.setBounds(37, (int)screenSize.getHeight()-130, 41, 41);
		picture.add(editButton);
		editButton.setOpaque(false);
		editButton.setContentAreaFilled(false);
		editButton.setBorderPainted(false);
		editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editButton.setFocusPainted(false);
        editButton.setToolTipText("Edit Contract");
        
        editButtonAction(editButton);
                
		mainFrame.setVisible(true);	

    	contentPanel.revalidate();
				
	}
        
        /**
         * Method which describes the edditButton behaviour
         * @param editButton represents the button used to enable disabled fields
         */
        private void editButtonAction(JButton editButton){
            
            editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				if (!flip){
					
					firstDeposit.setEditable(true);
					interest.setEditable(true);
					administrationWage.setEditable(true);
					unpaidWage.setEditable(true);
					anualInterest.setEditable(true);
					anualFee.setEditable(true);
					monthlyFeeCartilla.setEditable(true);
					monthlyFeeFirm.setEditable(true);
					monthlyFeePlus.setEditable(true);
					trimestralFeePersonal.setEditable(true);
					administrationFee.setEditable(true);
					negativeBallanceFee.setEditable(true);
					complaintFee.setEditable(true);
					buyingFee.setEditable(true);
					withdrawFee.setEditable(true);
					chequeFee.setEditable(true);
					repaymentFee.setEditable(true);
					depositOperationFee.setEditable(true);
					magneticSupportFee.setEditable(true);
					paperFee.setEditable(true);
					terminalFee.setEditable(true);
                                        buyingFeePercentage.setEditable(true);
					flip = true;
					
				}
				
				else{
					
					firstDeposit.setEditable(false);
					interest.setEditable(false);
					administrationWage.setEditable(false);
					unpaidWage.setEditable(false);
					anualInterest.setEditable(false);
					anualFee.setEditable(false);
					monthlyFeeCartilla.setEditable(false);
					monthlyFeeFirm.setEditable(false);
					monthlyFeePlus.setEditable(false);
					trimestralFeePersonal.setEditable(false);
					administrationFee.setEditable(false);
					negativeBallanceFee.setEditable(false);
					complaintFee.setEditable(false);
					buyingFee.setEditable(false);
					buyingFeePercentage.setEditable(false);
					withdrawFee.setEditable(false);
					chequeFee.setEditable(false);
					repaymentFee.setEditable(false);
					depositOperationFee.setEditable(false);
					magneticSupportFee.setEditable(false);
					paperFee.setEditable(false);
					terminalFee.setEditable(false);
                                        buyingFeePercentage.setEditable(false);
					flip = false;
					
				}
				
			}
		});
            
        }
        
        /**
         * Calculates the account number to assign
         */
        private void calcAccNum(){
            
            final String BANK = "2096";
            final String OFFICE = "0059";
            final String CONTROL = "56";
            final String IBAN = "ES30";
            String accNum = "";
            
            Random random = new Random();
            
            for(int i=0; i<10; i++){
                accNum = accNum + (Integer.toString(random.nextInt(10)));
            }     
            
            accNum = BANK + " " + OFFICE + " " + CONTROL + " " + accNum;
            this.accNum.setText(accNum);
            iban.setText(IBAN + " " + accNum);
        }
}
