package es.unileon.ulebank.GUI.contractForm;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

import java.awt.Color;

/**
 * Class which represents the main window of the form with all its components
 * 
 * @author Emanuel Iosif Relea
 * @version 2.5
 */

public class ContractFormGUI {

	private JFrame mainFrame;
	private JTextField accNum;
	private JTextField iban;
	private JTextField accNum2;
	private JTextField currency;
	private JTextField name;
	private JTextField surname;
	private JTextField birthDate;
	private JTextField iDNum;
	private JTextField streetAndNum;
	private JTextField town;
	private JTextField province;
	private JTextField cP;
	private JTextField nameAut;
	private JTextField surnameAut;
	private JTextField birthDateAut;
	private JTextField iDNumAut;
	private JTextField streetAndNumAut;
	private JTextField townAut;
	private JTextField provinceAut;
	private JTextField cPAut;
	private JTextField firstDeposit;
	private JTextField interest;
	private JTextField maritalStatus;
	private JTextField phoneNum;
	private JTextField maritalStatusAut;
	private JTextField phoneNumAut;
	private JTextField administrationWage;
	private JTextField unpaidWage;
	private JTextField anualInterest;
	private JTextField anualFee;
	private JTextField monthlyFeeFirm;
	private JTextField monthlyFeeCartilla;
	private JTextField monthlyFeePlus;
	private JTextField trimestralFeePersonal;
	private JTextField administrationFee;
	private JTextField withdrawFee;
	private JTextField paperFee;
	private JTextField magneticSupportFee;
	private JTextField terminalFee;
	private JTextField negativeBallanceFee;
	private JTextField complaintFee;
	private JTextField buyingFee;
	private JTextField buyingFeePercentage;
	private JTextField depositOperationFee;
	private JTextField repaymentFee;
	private JTextField chequeFee;
	private boolean flip = false;

	public static void main(String[] args) {
		
		new ContractFormGUI();
		
	}

	public ContractFormGUI() {
		launchWindow();
	}

	private void launchWindow() {
		
		mainFrame = new JFrame();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		mainFrame.setBounds(100, 100, 1000, screenSize.height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setUndecorated(true);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.getContentPane().setLayout(null);
		ImageIcon frameImage = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/frameImage2.jpg");
		mainFrame.setIconImage(frameImage.getImage());
		
		JPicture customTitleBar = new JPicture("resources/es/unileon/aw/GUI/contractForm/customTitleBar.jpg");
		customTitleBar.setBounds(0, 0, 1000, 41);
		mainFrame.getContentPane().add(customTitleBar);
		customTitleBar.setLayout(null);
		
		Icon editIcon = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/EditButton.jpg");
		Icon acceptIcon = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/AcceptButton.jpg");
		Icon denyIcon = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/DenyButton.jpg");
		
		JPicture picture = new JPicture("resources/es/unileon/aw/GUI/contractForm/grayBackground3.jpg");
		picture.setBounds(0, 40, 1000, screenSize.height);
		mainFrame.getContentPane().add(picture);
		picture.setLayout(null);
		
		new JDraggable(mainFrame, customTitleBar);
		
		Icon closeIcon = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/closeButton.jpg");
		Icon minimizeIcon = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/minimizeButton.jpg");
		
		JButton closeButton = new JButton(closeIcon);
		closeButton.setBounds(972, 8, 23, 23);
		customTitleBar.add(closeButton);
		
		closeButton.setOpaque(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setFocusPainted(false);
		
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.dispose();
				
			}
		});
		
		JButton minimizeButton = new JButton(minimizeIcon);
		minimizeButton.setBounds(948, 8, 23, 23);
		customTitleBar.add(minimizeButton);
		
		minimizeButton.setOpaque(false);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		minimizeButton.setFocusPainted(false);
		
		minimizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.setExtendedState(JFrame.ICONIFIED);
				
			}
		});
		
		String[] mod = {"La Cartilla+", "Empresa", "Cuenta Plus", "Cuenta Personal"};
		
		String[] disp = { "Independiente", "Mancomunada", "Indistinta"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 22, 949, screenSize.height-118);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		picture.add(scrollPane);
		
		JPanel contentPanel = new JPanel();
		scrollPane.setViewportView(contentPanel);
		contentPanel.setPreferredSize(new Dimension(931, 7800));
		contentPanel.setLayout(null);
		
		JPicture uleBankLogo = new JPicture("resources/es/unileon/aw/GUI/contractForm/UleBankLogo.png");
		uleBankLogo.setBounds(572, 0, 349, 110);
		contentPanel.add(uleBankLogo);
		
		JLabel contratoApertura = new JLabel("CONTRATO DE APERTURA DE CUENTA CORRIENTE");
		contratoApertura.setFont(new Font("Tahoma", Font.BOLD, 16));
		contratoApertura.setBounds(10, 11, 429, 20);
		contentPanel.add(contratoApertura);
		
		JLabel lblAccNum = new JLabel("N\u00BA");
		lblAccNum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccNum.setBounds(10, 42, 26, 20);
		contentPanel.add(lblAccNum);
		
		accNum = new JTextField();
		accNum.setEditable(false);
		accNum.setFont(new Font("Tahoma", Font.BOLD, 16));
		accNum.setText("2096 0059 56 3372541904");
		accNum.setBackground(UIManager.getColor("Button.background"));
		accNum.setBounds(65, 42, 222, 20);
		contentPanel.add(accNum);
		accNum.setColumns(10);
		
		JLabel lblIban = new JLabel("IBAN");
		lblIban.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIban.setBounds(10, 73, 45, 20);
		contentPanel.add(lblIban);
		
		iban = new JTextField();
		iban.setEditable(false);
		iban.setText("ES30 2096 0059 5633 7254 1904");
		iban.setFont(new Font("Tahoma", Font.BOLD, 16));
		iban.setColumns(10);
		iban.setBackground(SystemColor.menu);
		iban.setBounds(65, 73, 274, 20);
		contentPanel.add(iban);
		
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
		
		accNum2 = new JTextField();
		accNum2.setEditable(false);
		accNum2.setBackground(UIManager.getColor("Button.background"));
		accNum2.setBounds(180, 307, 159, 20);
		contentPanel.add(accNum2);
		accNum2.setColumns(10);
		accNum2.setHorizontalAlignment(SwingConstants.CENTER);
		accNum2.setText(accNum.getText());
		
		currency = new JTextField();
		currency.setEditable(false);
		currency.setColumns(10);
		currency.setBackground(SystemColor.menu);
		currency.setBounds(180, 340, 159, 20);
		contentPanel.add(currency);
		currency.setHorizontalAlignment(SwingConstants.CENTER);
		currency.setText("Euros");
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox modality = new JComboBox(mod);
		modality.setBounds(579, 305, 147, 20);
		contentPanel.add(modality);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox disponibility = new JComboBox(disp);
		
		disponibility.setBounds(579, 338, 147, 20);
		contentPanel.add(disponibility);
		
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
		
		JLabel lblSeparator = new JLabel("-----------------------------------------"
				+ "-----------------------------------------------------------------------"
				+ "-----------------------------------------------------------------");
		lblSeparator.setBounds(83, 565, 718, 14);
		contentPanel.add(lblSeparator);
		
		JLabel lblAuthorized = new JLabel("AUTORIZADOS");
		lblAuthorized.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAuthorized.setBounds(83, 597, 100, 14);
		contentPanel.add(lblAuthorized);
		
		JLabel lblNameAut = new JLabel("Nombre(s):");
		lblNameAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNameAut.setBounds(83, 627, 78, 14);
		contentPanel.add(lblNameAut);
		
		JLabel lblSurnameAut = new JLabel("Apellido(s):");
		lblSurnameAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurnameAut.setBounds(83, 652, 78, 14);
		contentPanel.add(lblSurnameAut);
		
		JLabel lblBirthDateAut = new JLabel("Fecha Nacimiento:");
		lblBirthDateAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBirthDateAut.setBounds(83, 677, 100, 14);
		contentPanel.add(lblBirthDateAut);
		
		JLabel lblIDNumAut = new JLabel("NIF/NIE:");
		lblIDNumAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIDNumAut.setBounds(83, 701, 111, 14);
		contentPanel.add(lblIDNumAut);
		
		JLabel lblstreetAndNumAut = new JLabel("Calle:");
		lblstreetAndNumAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblstreetAndNumAut.setBounds(482, 627, 63, 14);
		contentPanel.add(lblstreetAndNumAut);
		
		JLabel lblTownAut = new JLabel("Localidad:");
		lblTownAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTownAut.setBounds(482, 652, 63, 14);
		contentPanel.add(lblTownAut);
		
		JLabel lblProvinceAut = new JLabel("Provincia:");
		lblProvinceAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProvinceAut.setBounds(482, 677, 63, 14);
		contentPanel.add(lblProvinceAut);
		
		JLabel lblCPAut = new JLabel("C.P:");
		lblCPAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCPAut.setBounds(482, 701, 51, 14);
		contentPanel.add(lblCPAut);
		
		nameAut = new JTextField();
		nameAut.setHorizontalAlignment(SwingConstants.CENTER);
		nameAut.setColumns(10);
		nameAut.setBackground(UIManager.getColor("Button.highlight"));
		nameAut.setBounds(193, 625, 222, 20);
		contentPanel.add(nameAut);
		
		surnameAut = new JTextField();
		surnameAut.setHorizontalAlignment(SwingConstants.CENTER);
		surnameAut.setColumns(10);
		surnameAut.setBackground(UIManager.getColor("Button.highlight"));
		surnameAut.setBounds(193, 650, 222, 20);
		contentPanel.add(surnameAut);
		
		birthDateAut = new JTextField();
		birthDateAut.setText("dd/mm/aaaa");
		birthDateAut.setHorizontalAlignment(SwingConstants.CENTER);
		birthDateAut.setColumns(10);
		birthDateAut.setBackground(UIManager.getColor("Button.highlight"));
		birthDateAut.setBounds(193, 675, 111, 20);
		contentPanel.add(birthDateAut);
		
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
		iDNumAut.setBounds(193, 700, 111, 20);
		contentPanel.add(iDNumAut);
		
		streetAndNumAut = new JTextField();
		streetAndNumAut.setHorizontalAlignment(SwingConstants.CENTER);
		streetAndNumAut.setColumns(10);
		streetAndNumAut.setBackground(UIManager.getColor("Button.highlight"));
		streetAndNumAut.setBounds(546, 625, 244, 20);
		contentPanel.add(streetAndNumAut);
		
		townAut = new JTextField();
		townAut.setHorizontalAlignment(SwingConstants.CENTER);
		townAut.setColumns(10);
		townAut.setBackground(UIManager.getColor("Button.highlight"));
		townAut.setBounds(546, 650, 244, 20);
		contentPanel.add(townAut);
		
		provinceAut = new JTextField();
		provinceAut.setHorizontalAlignment(SwingConstants.CENTER);
		provinceAut.setColumns(10);
		provinceAut.setBackground(UIManager.getColor("Button.highlight"));
		provinceAut.setBounds(546, 675, 244, 20);
		contentPanel.add(provinceAut);
		
		cPAut = new JTextField();
		cPAut.setHorizontalAlignment(SwingConstants.CENTER);
		cPAut.setColumns(10);
		cPAut.setBackground(UIManager.getColor("Button.highlight"));
		cPAut.setBounds(546, 700, 76, 20);
		contentPanel.add(cPAut);
		
		JLabel label_9 = new JLabel("---------------------------------------------------"
				+ "--------------------------------------------------------------------"
				+ "----------------------------------------------------------");
		label_9.setBounds(83, 752, 718, 14);
		contentPanel.add(label_9);
		
		JLabel lblFirstDeposit = new JLabel("3 - IMPORTE PRIMER INGRESO");
		lblFirstDeposit.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstDeposit.setBounds(39, 777, 200, 14);
		contentPanel.add(lblFirstDeposit);
		
		firstDeposit = new JTextField();
		firstDeposit.setEditable(false);
		firstDeposit.setText("0");
		firstDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		firstDeposit.setColumns(10);
		firstDeposit.setBackground(UIManager.getColor("Button.background"));
		firstDeposit.setBounds(83, 812, 56, 20);
		contentPanel.add(firstDeposit);
		
		JLabel lblCurrency2 = new JLabel("");
		lblCurrency2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrency2.setBounds(149, 815, 90, 14);
		contentPanel.add(lblCurrency2);
		lblCurrency2.setText(currency.getText());
		
		JLabel lblPeriodicidad = new JLabel("4 - PERIODICIDAD Y FECHAS DE LIQUIDACI\u00D3N");
		lblPeriodicidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPeriodicidad.setBounds(39, 853, 300, 14);
		contentPanel.add(lblPeriodicidad);
		
		JLabel lblPeriod = new JLabel("6 Mes(es)");
		lblPeriod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeriod.setBounds(83, 890, 147, 14);
		contentPanel.add(lblPeriod);
		
		JLabel lblInterestType = new JLabel("5 - TIPO DE INTERES");
		lblInterestType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInterestType.setBounds(39, 926, 141, 14);
		contentPanel.add(lblInterestType);
		
		interest = new JTextField();
		interest.setBackground(UIManager.getColor("Button.background"));
		interest.setHorizontalAlignment(SwingConstants.CENTER);
		interest.setEditable(false);
		interest.setText("0");
		interest.setBounds(83, 955, 56, 20);
		contentPanel.add(interest);
		interest.setColumns(10);
		
		JLabel lblCurrency3 = new JLabel("Euros");
		lblCurrency3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrency3.setBounds(149, 957, 90, 14);
		contentPanel.add(lblCurrency3);
		
		JLabel lblFecha = new JLabel("18/03/2014");
		lblFecha.setBounds(103, 996, 182, 14);
		contentPanel.add(lblFecha);
		
		JTextArea txtArea1 = new JTextArea();
		txtArea1.setEditable(false);
		txtArea1.setBackground(UIManager.getColor("Button.background"));
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		txtArea1.setText("En Le\u00F3n a                          UleBank y los titulares identificados "
				+ "en el apartado 2 anterior, convienen en la apertura de una cuenta corriente con "
				+ "el n\u00FAmero identicado en el cabezamiento, en la localidad de Le\u00F3n y que "
				+ "expresamente ambas partes designan como lugar del cumplimiento de las obligaciones "
				+ "derivadas de este contrato, el cual se regir\u00E1 por las siguientes");
		txtArea1.setBounds(39, 995, 851, 82);
		contentPanel.add(txtArea1);
		
		JLabel lblClausula = new JLabel("CL\u00C1USULAS");
		lblClausula.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblClausula.setBounds(388, 1128, 147, 20);
		contentPanel.add(lblClausula);
		
		JLabel lblMaritalStatus = new JLabel("Estado Civil:");
		lblMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaritalStatus.setBounds(83, 534, 90, 14);
		contentPanel.add(lblMaritalStatus);
		
		maritalStatus = new JTextField();
		maritalStatus.setHorizontalAlignment(SwingConstants.CENTER);
		maritalStatus.setColumns(10);
		maritalStatus.setBackground(Color.WHITE);
		maritalStatus.setBounds(193, 531, 111, 20);
		contentPanel.add(maritalStatus);
		
		JLabel lblPhoneNum = new JLabel("Tel\u00E9fono:");
		lblPhoneNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNum.setBounds(482, 532, 63, 14);
		contentPanel.add(lblPhoneNum);
		
		phoneNum = new JTextField();
		phoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNum.setColumns(10);
		phoneNum.setBackground(Color.WHITE);
		phoneNum.setBounds(546, 532, 100, 20);
		contentPanel.add(phoneNum);
		
		JLabel lblMaritalStatusAut = new JLabel("Estado Civil:");
		lblMaritalStatusAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaritalStatusAut.setBounds(83, 727, 90, 14);
		contentPanel.add(lblMaritalStatusAut);
		
		maritalStatusAut = new JTextField();
		maritalStatusAut.setHorizontalAlignment(SwingConstants.CENTER);
		maritalStatusAut.setColumns(10);
		maritalStatusAut.setBackground(Color.WHITE);
		maritalStatusAut.setBounds(192, 725, 111, 20);
		contentPanel.add(maritalStatusAut);
		
		phoneNumAut = new JTextField();
		phoneNumAut.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNumAut.setColumns(10);
		phoneNumAut.setBackground(Color.WHITE);
		phoneNumAut.setBounds(546, 725, 100, 20);
		contentPanel.add(phoneNumAut);
		
		JLabel lblPhoneNumAut = new JLabel("Tel\u00E9fono:");
		lblPhoneNumAut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNumAut.setBounds(482, 727, 63, 14);
		contentPanel.add(lblPhoneNumAut);
		
		Icon addIcon = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/AddButton.png");
		
		JButton addOwner = new JButton(addIcon);
		addOwner.setBounds(193, 403, 23, 23);
		contentPanel.add(addOwner);
		addOwner.setOpaque(false);
		addOwner.setContentAreaFilled(false);
		addOwner.setBorderPainted(false);
		addOwner.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addOwner.setFocusPainted(false);
		
		JButton addAuthorized = new JButton(addIcon);
		addAuthorized.setBounds(193, 594, 23, 23);
		contentPanel.add(addAuthorized);
		addAuthorized.setOpaque(false);
		addAuthorized.setContentAreaFilled(false);
		addAuthorized.setBorderPainted(false);
		addAuthorized.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addAuthorized.setFocusPainted(false);
		
		JLabel lblThirdClause = new JLabel("3 - FORMAS DE DISPOSICI\u00D3N");
		lblThirdClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThirdClause.setBounds(39, 1675, 200, 14);
		contentPanel.add(lblThirdClause);
		
		JLabel lblSecondClause = new JLabel("2 - DOCUMENTOS DE PAGO");
		lblSecondClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSecondClause.setBounds(39, 1536, 177, 14);
		contentPanel.add(lblSecondClause);
		
		JTextArea txtArea3 = new JTextArea();
		txtArea3.setWrapStyleWord(true);
		txtArea3.setText("Previa solicitud de los Titulares, la Caja les facilitar\u00E1 cheques "
				+ "de esta cuenta corriente, pudiendo exigir en el momento de la entrega el "
				+ "correspondiente acuse de recibo. Los Titulares se obligan a custodiar los "
				+ "cheques con la diligencia debida y a comunicar a la Caja, a la mayor brevedad,"
				+ " cualquier p\u00E9rdida o extrav\u00EDo, sustracci\u00F3n, robo, destrucci\u00F3n "
				+ "o usa indebido de los mismos, siendo responsable de los da\u00F1os y perjuicios "
				+ "que puedan ocasionarse por su culpa a negligencia, quedando advertido de que el "
				+ "env\u00EDo de cheques por correo ordinario constituye un acto de negligente custodia.");
		txtArea3.setLineWrap(true);
		txtArea3.setEditable(false);
		txtArea3.setBackground(SystemColor.menu);
		txtArea3.setBounds(39, 1576, 851, 119);
		contentPanel.add(txtArea3);
		
		JLabel lblFirstClause = new JLabel("1 - INGRESOS Y CARGOS");
		lblFirstClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstClause.setBounds(39, 1203, 177, 14);
		contentPanel.add(lblFirstClause);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setWrapStyleWord(true);
		textArea2.setText("La cuenta se constituye inicialmente con la imposici\u00F3n cuyo importe "
				+ "figura en el apartado 3 anterior, pudiendo realizarse ingresos en la misma "
				+ "mediante efectivo, cheques o cualquier otra forma de abono admitida en derecho, "
				+ "as\u00ED como domiciliarse cobros. Cuando las entregas no sean en efectivo, se "
				+ "abonar\u00E1n en la cuenta salvo buen fin, pudiendo la Caja condicionar su "
				+ "disposici\u00F3n hasta la efectiva realizaci\u00F3n de las mismas. En cumplimiento "
				+ "del servicio de caja, inherente a este contrato, los Titulares podr\u00E1n disponer "
				+ "del saldo de la cuenta mediante la utilizaci\u00F3n de cheques facilitadas por la "
				+ "Caja u otros documentos o medios que la propia Caja tenga o pueda establecer, o "
				+ "resulten id\u00F3neos a tal fin. En consecuencia podr\u00E1 librar o aceptar"
				+ " t\u00EDtulos cambiarlos contra esta cuenta y domiciliar los pagos, peri\u00F3dicos "
				+ "o no, que considere oportunos, reserv\u00E1ndose la Caja la facultad de no atender "
				+ "aqu\u00E9llos que, con o sin previa orden de los Titulares, le sean presentados y "
				+ "le ofrezcan cualquier tipo de duda o reparo respecto de su autenticidad o identidad "
				+ "de las personas que intervienen en la operaci\u00F3n. Cuando estos documentos "
				+ "sean atendidos por otras Entidades, los Titulares autorizan a adeudar su importe "
				+ "sin que necesariamente deban acompa\u00F1arse dichos documentos, sin perjuicio de "
				+ "su posterior entrega o justificaci\u00F3n conforme a la legislaci\u00F3n vigente. "
				+ "Por las conformidades vinculantes que la Caja preste a otras Entidades por documentos"
				+ " librados o domiciliados en esta cuenta por los Titulares, \u00E9stos autorizan a "
				+ "la Caja para retener su importe en la cuenta, con lo que el saldo disponible "
				+ "quedar\u00E1 disminuido en ese imparte desde el mismo momento en que se otorgue "
				+ "dicha conformidad. Los apuntes en cuenta practicados por la Caja podr\u00E1n ser "
				+ "corregidos por \u00E9sta en caso de error. A los efectos del c\u00E1lculo de "
				+ "intereses, a todas las partidas de cargo y abono se les aplicar\u00E1n las normas "
				+ "de valoraci\u00F3n que procedan y resulten en cada momento de las vigentes publicadas"
				+ " por la Caja. La Caja remitir\u00E1 a los Titulares informaci\u00F3n sobre las "
				+ "operaciones realizadas en la cuenta. No obstante, la Caja podr\u00E1 entregar a "
				+ "los titulares una libreta informativa que les facilite el control de la cuenta, "
				+ "si bien el saldo que presente la libreta no reflejar\u00E1 la exacta situaci\u00F3n"
				+ " de la cuenta hasta tanto no haya sido actualizada conforme a los registros "
				+ "contables de la Caja.");
		textArea2.setLineWrap(true);
		textArea2.setEditable(false);
		textArea2.setBackground(SystemColor.menu);
		textArea2.setBounds(39, 1244, 851, 436);
		contentPanel.add(textArea2);
		
		JLabel lblFourthClause = new JLabel("4 - INTERESES ORDINARIOS");
		lblFourthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFourthClause.setBounds(39, 1975, 200, 14);
		contentPanel.add(lblFourthClause);
		
		JLabel lblInterest = new JLabel("18/03/2014");
		lblInterest.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterest.setBounds(235, 2128, 36, 14);
		contentPanel.add(lblInterest);
		lblInterest.setText(interest.getText());
		
		JLabel lblFifthClause = new JLabel("5 - COMISIONES Y GASTOS");
		lblFifthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFifthClause.setBounds(39, 2195, 200, 14);
		contentPanel.add(lblFifthClause);
		
		administrationWage = new JTextField();
		administrationWage.setHorizontalAlignment(SwingConstants.CENTER);
		administrationWage.setText("0,15");
		administrationWage.setEditable(false);
		administrationWage.setBounds(200, 2262, 45, 20);
		contentPanel.add(administrationWage);
		administrationWage.setColumns(10);
		
		unpaidWage = new JTextField();
		unpaidWage.setText("0,00");
		unpaidWage.setHorizontalAlignment(SwingConstants.CENTER);
		unpaidWage.setEditable(false);
		unpaidWage.setBounds(119, 2328, 45, 20);
		contentPanel.add(unpaidWage);
		unpaidWage.setColumns(10);
		
		JLabel lblSixthClause = new JLabel("6 - MODIFICACI\u00D3N DE INTERESES, COMISIONES Y GASTOS");
		lblSixthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSixthClause.setBounds(39, 2410, 367, 14);
		contentPanel.add(lblSixthClause);
		
		JLabel lblSeventhClause = new JLabel("7 - DESCUBIERTOS EN CUENTA");
		lblSeventhClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeventhClause.setBounds(39, 2648, 200, 14);
		contentPanel.add(lblSeventhClause);
		
		anualInterest = new JTextField();
		anualInterest.setText("13,75");
		anualInterest.setHorizontalAlignment(SwingConstants.CENTER);
		anualInterest.setEditable(false);
		anualInterest.setColumns(10);
		anualInterest.setBounds(746, 2788, 45, 20);
		contentPanel.add(anualInterest);
		
		JLabel lblEigthClause = new JLabel("8 - COMPENSACI\u00D3N");
		lblEigthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEigthClause.setBounds(39, 2855, 147, 14);
		contentPanel.add(lblEigthClause);
		
		JLabel lblNinthClause = new JLabel("9 - RESOLUCI\u00D3N DEL CONTRATO");
		lblNinthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNinthClause.setBounds(39, 3015, 211, 14);
		contentPanel.add(lblNinthClause);
		
		JLabel lblTenthClause = new JLabel("10 - DOMICILIOS");
		lblTenthClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenthClause.setBounds(39, 3179, 123, 14);
		contentPanel.add(lblTenthClause);
		
		JLabel lblEleventhClause = new JLabel("11 - ENTREGA DE DOCUMENTOS");
		lblEleventhClause.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEleventhClause.setBounds(39, 3306, 200, 14);
		contentPanel.add(lblEleventhClause);
		
		JTextArea textArea12 = new JTextArea();
		textArea12.setWrapStyleWord(true);
		textArea12.setText("En este mismo acto los Titulares reciben, junto con una copia de "
				+ "este contrato, un ejemplar de las Tarifas de Comisiones y gastos repercutibles "
				+ "y las normas sobre fechas de valoraci\u00F3n aplicables a este contrato.");
		textArea12.setLineWrap(true);
		textArea12.setEditable(false);
		textArea12.setBackground(SystemColor.menu);
		textArea12.setBounds(39, 3349, 851, 65);
		contentPanel.add(textArea12);
		
		JTextArea textArea11 = new JTextArea();
		textArea11.setWrapStyleWord(true);
		textArea11.setText("Los Titulares fijan como domicilio, a efectos de todos los "
				+ "requerimientos y notificaciones derivados de este contrato, el "
				+ "rese\u00F1ado en el apartado 1, salvo que se acredite su cambio en "
				+ "forma fehaciente. En consecuencia, se tendr\u00E1n por recibidos a "
				+ "todos los efectos legales, cuantos requerimientos y notificaciones "
				+ "dirija la Caja a los expresados domicilios.");
		textArea11.setLineWrap(true);
		textArea11.setEditable(false);
		textArea11.setBackground(SystemColor.menu);
		textArea11.setBounds(39, 3226, 851, 87);
		contentPanel.add(textArea11);
		
		JTextArea textArea10 = new JTextArea();
		textArea10.setWrapStyleWord(true);
		textArea10.setText("Los Titulares podr\u00E1n cancelar la cuenta en cualquier "
				+ "momento y previo aviso a la Caja con quince d\u00EDas de antelaci\u00F3n. "
				+ "En el supuesto de concurrencia de varios Titulares, la cancelaci\u00F3n "
				+ "deber\u00E1 ser suscrita por todos ellos. En el momento de la cancelaci\u00F3n "
				+ "los Titulares deber\u00E1n devolver los cheques y cualesquiera otros "
				+ "instrumentos de pago que obren en su poder y correspondan a esta cuenta."
				+ " Igualmente, la Caja podr\u00E1 cancelar la cuenta previo aviso a los "
				+ "Titulares con quince d\u00EDas de antelaci\u00F3n. Notificada la "
				+ "cancelaci\u00F3n y transcurrido el plazo de preaviso, el saldo acreedor "
				+ "de la cuenta dejar\u00E1 de devengar intereses. En cualquier caso, "
				+ "transcurrido un a\u00F1o desde que la cuenta presente saldo cero, la "
				+ "Caja podr\u00E1 cancelar la cuenta sin necesidad de preaviso.");
		textArea10.setLineWrap(true);
		textArea10.setEditable(false);
		textArea10.setBackground(SystemColor.menu);
		textArea10.setBounds(39, 3065, 851, 153);
		contentPanel.add(textArea10);
		
		JTextArea textArea9 = new JTextArea();
		textArea9.setWrapStyleWord(true);
		textArea9.setText("La CAJA queda autorizada para compensar los saldos y operaciones "
				+ "resultantes de las distintas cuentas u operaciones que tenga o haga cualquiera"
				+ " de los Titulares de la cuenta. En consecuencia, la Caja podr\u00E1 abonar o "
				+ "cargar en cuenta, respectivamente, los saldos deudores o acreedores de otras "
				+ "cuentas corrientes, libretas de ahorro o dep\u00F3sitos de efectivo y valores,"
				+ " que figuren a nombre de los Titulares, aunque sea en forma solidaria con terceras"
				+ " personas, existentes en cualquiera de las Sucursales de la CAJA. A tal fin, "
				+ "la CAJA queda facultada, irrevocablemente, para cancelar las imposiciones a "
				+ "plazo, incluso anticipadamente, y proceder a la venta de valores o efectos "
				+ "depositados en la misma.");
		textArea9.setLineWrap(true);
		textArea9.setEditable(false);
		textArea9.setBackground(SystemColor.menu);
		textArea9.setBounds(39, 2902, 851, 137);
		contentPanel.add(textArea9);
		
		JTextArea textArea8 = new JTextArea();
		textArea8.setWrapStyleWord(true);
		textArea8.setText("La Caja no se obliga a aceptar disposiciones en descubierto. En "
				+ "consecuencia, el saldo que en cualquier momento resulte a favor de la "
				+ "Caja, seg\u00FAn sus libros y registros, deber\u00E1 ser reintegrado "
				+ "por los Titulares inmediatamente sin necesidad de requerimiento alguno, "
				+ "pudiendo la Caja reclamar dicho importe en v\u00EDa judicial mediante "
				+ "certificaci\u00F3n por ella expedida del saldo de la cuenta, acompa\u00F1ada "
				+ "del extracto de la misma. Dicha certificaci\u00F3n acreditar\u00E1 "
				+ "suficientemente, en principio, la cantidad exigible, sin perjuicio "
				+ "del derecho de los Titulares a impugnar partidas concretas de la cuenta. "
				+ "Todos los Titulares de la cuenta responden solidariamente ante la Caja "
				+ "de los descubiertos que se puedan producir en la misma. De conformidad "
				+ "con lo establecido en la Circular del Banco de Espa\u00F1a 8/1990, los "
				+ "descubiertos en cuenta devengar\u00E1n a favor de la Caja el inter\u00E9s "
				+ "nominal anual que en cada momento tenga la Caja publicado en el Tabl\u00F3n "
				+ "de Anuncios y comunicado al Banco de Espa\u00F1a, y que al momento de "
				+ "la firma de este contrato es el                 por ciento. Los intereses "
				+ "se liquidar\u00E1n en la misma forma y con la misma periodicidad y fechas "
				+ "que los intereses ordinarios.");
		textArea8.setLineWrap(true);
		textArea8.setEditable(false);
		textArea8.setBackground(SystemColor.menu);
		textArea8.setBounds(39, 2693, 851, 227);
		contentPanel.add(textArea8);
		
		JTextArea textArea7 = new JTextArea();
		textArea7.setWrapStyleWord(true);
		textArea7.setText("No obstante el inter\u00E9s ordinario y las comisiones y gastos "
				+ "pactados en este contrato, la Caja podr\u00E1 modificar unos y otras en "
				+ "cualquier momento. Cualquier modificaci\u00F3n que suponga un mayor ingreso "
				+ "o un menor coste para el cliente, surtir\u00E1 efecto a partir del momento"
				+ " en que la Caja decida su aplicaci\u00F3n. Por el contrario, las que le "
				+ "supongan mayor coste o menor ingreso, ser\u00E1n comunicadas por la Caja"
				+ " mediante su publicaci\u00F3n en el Tabl\u00F3n de Anuncios de todas sus "
				+ "Sucursales, con una antelaci\u00F3n de dos meses a la fecha de su "
				+ "aplicaci\u00F3n; durante este plazo los Titulares podr\u00E1n, si as\u00ED "
				+ "les conviniere, cancelar la cuenta. Transcurrido el mismo, se entender\u00E1 "
				+ "que los Titulares han aceptado la modificaci\u00F3n anunciada. En todo "
				+ "caso, desde el d\u00EDa siguiente a aquel en que el titular de mayor edad "
				+ "cumpla los 30 a\u00F1os, tanto las comisiones como el tipo de inter\u00E9s"
				+ " que devengar\u00E1 la cuenta ser\u00E1n los que en ese momento tenga la"
				+ " CAJA establecidos para las cuentas corrientes ordinarias. El mismo d\u00EDa"
				+ " de su fijaci\u00F3n la CAJA lo comunicar\u00E1 a los titulares en el "
				+ "domicilio indicado en este contrato por cualquier medio que deje constancia"
				+ " de su env\u00EDo; la comunicaci\u00F3n de la CAJA se tendr\u00E1 por "
				+ "recibida y por aceptadas las nuevas comisiones y tipo de inter\u00E9s si, "
				+ "en el plazo de quince d\u00EDas a contar desde el inicio de dicho periodo,"
				+ " los titulares no han comunicado a la CAJA la no recepci\u00F3n de la misma.");
		textArea7.setLineWrap(true);
		textArea7.setEditable(false);
		textArea7.setBackground(SystemColor.menu);
		textArea7.setBounds(39, 2454, 851, 256);
		contentPanel.add(textArea7);
		
		JTextArea txtArea6 = new JTextArea();
		txtArea6.setWrapStyleWord(true);
		txtArea6.setText("Esta cuenta devengar\u00E1 las siguientes "
				+ "comisiones:\r\n\r\nComisi\u00F3n de administraci\u00F3n:                 EUROS "
				+ "por apunte, no comput\u00E1ndose a estos efectos los que correspondientes a "
				+ "intereses, comisiones, ingresos en efectivo y pago de cheques de la "
				+ "cuenta.\r\n\r\nComisi\u00F3n por reclamaci\u00F3n de impagados: Por la "
				+ "primera reclamaci\u00F3n escrita en cada descubierto que, en su caso se "
				+ "produzca, los TITULARES abonar\u00E1n la cantidad de                 EUROS."
				+ " Esta comisi\u00F3n se liquidar\u00E1 al momento de emitir la "
				+ "reclamaci\u00F3n.\r\nTodos los gastos, incluso requerimientos y notificaciones"
				+ " necesarios o voluntarios, que se originen como consecuencia de la "
				+ "formalizaci\u00F3n de este contrato o del nacimiento, cumplimiento o extinci\u00F3n"
				+ " de las obligaciones dimanantes del mismo, ser\u00E1n de cuenta de los Titulares.");
		txtArea6.setLineWrap(true);
		txtArea6.setEditable(false);
		txtArea6.setBackground(SystemColor.menu);
		txtArea6.setBounds(39, 2233, 851, 211);
		contentPanel.add(txtArea6);
		
		JTextArea textArea5 = new JTextArea();
		textArea5.setWrapStyleWord(true);
		textArea5.setText("Los saldos a favor de los titulares de la cuenta devengar\u00E1n intereses"
				+ " al tipo nominal anual indicado en el apartado 5. Los intereses ser\u00E1n "
				+ "liquidados en las fechas y con la periodicidad que se se\u00F1ala en el apartado"
				+ " 4. Cada una de las liquidaciones de intereses ser\u00E1 notificada por la Caja"
				+ " a los Titulares, pudiendo \u00E9stos, en el plazo de quince d\u00EDas a contar"
				+ " de la fecha de liquidaci\u00F3n, manifestar por escrito su conformidad o "
				+ "discrepancia a la misma; de no hacer uso de este derecho en el plazo convenido,"
				+ " se entender\u00E1 prestada su conformidad. En cumplimiento de la normativa "
				+ "vigente se hace constar que el importe de los intereses absolutos devengados "
				+ "se calcular\u00E1 mediante la siguiente f\u00F3rmula: Intereses = Suma "
				+ "de N\u00FAmeros X Tipo de inter\u00E9s / Divisor fijo; donde N\u00FAmeros = Saldos"
				+ " por valoraci\u00F3n X D\u00EDas de permanencia y Divisor fijo = 36.500 \u00F3"
				+ " 36,600 si el a\u00F1o fuere bisiesto. El importe de los intereses, una vez "
				+ "deducida la retenci\u00F3n fiscal vigente en cada momento, ser\u00E1 abonado"
				+ " en la cuenta 2096 0059 56 3372541904 EUR. La tasa anual equivalente (TAE) "
				+ "que resulta para esta operaci\u00F3n es el       por ciento, calculada conforme"
				+ " a las reglas establecidas en la Circular del Banco de Espa\u00F1a, n\u00FAmero"
				+ " 8/1990 (B.O.E. 20-09-90).");
		textArea5.setLineWrap(true);
		textArea5.setEditable(false);
		textArea5.setBackground(SystemColor.menu);
		textArea5.setBounds(39, 2015, 851, 227);
		contentPanel.add(textArea5);
		
		JTextArea textArea4 = new JTextArea();
		textArea4.setWrapStyleWord(true);
		textArea4.setText("La forma de disposici\u00F3n convenida por las Titulares es la reflejada"
				+ " en el apartado 2, entendi\u00E9ndose conjunta (mancomunada) caso de no constar"
				+ " otra indicaci\u00F3n. Si la disposici\u00F3n fuere indistinta (solidaria), se"
				+ " entender\u00E1 que cada uno de los Titulares podr\u00E1 disponer de la integridad"
				+ " del saldo de la cuenta por cualquiera de los medios indicados en este contrato."
				+ " Las facultades reconocidas a las Titulares, o atribuidas a las personas por"
				+ " ellos autorizadas, ser\u00E1n v\u00E1lidas tal y como hayan sido establecidas"
				+ ", mientras la Caja no reciba en forma aut\u00E9ntica e indubitada comunicaci\u00F3n"
				+ " de su modificaci\u00F3n, renuncia o revocaci\u00F3n. Los Titulares relevan "
				+ "a la Caja de toda responsabilidad en todos aquellos supuestos en que se realicen"
				+ " operaciones con apoderados, representantes o personas cuyas facultades sobre "
				+ "la cuenta hubiesen sido modificadas, limitadas o extinguidas en casos tales como:"
				+ " revocaci\u00F3n de firmas o poderes, fallecimiento del poderdante, mayor\u00EDas "
				+ "de edad, incapacitaci\u00F3n legal, etc., siempre que la Caja no hubiera sido "
				+ "notificada de las mismos, a\u00FAn cuando tales hechos modificativos consten en"
				+ " documento p\u00FAblico o hayan sido inscritos en Registros P\u00FAblicos. En "
				+ "los supuestos de cotitularidad, las modificaciones, renuncias o revocaciones de"
				+ " las facultades de los Titulares y/o autorizados han de ser ordenadas por todos"
				+ " los Titulares, salvo que las mismas vengan ordenadas por autoridad competente."
				+ " En caso de fallecimiento de alguno de los Titulares de la cuenta, los herederos"
				+ ", legatarios o ejecutores testamentarios del fallecido no podr\u00E1n disponer"
				+ " de su saldo mientras no acrediten su derecho, sin perjuicio del cumplimiento"
				+ " de sus obligaciones fiscales. En el caso de recibir de los Titulares de la"
				+ " cuenta o sus causahabientes, instrucciones contradictorias entre s\u00ED sobre"
				+ " la forma de disposici\u00F3n, la Caja se reserva la facultad de consignar"
				+ " judicialmente el saldo existente en la cuenta de no mediar instrucciones"
				+ " coincidentes y un\u00E1nimes. Los gastos de consignaci\u00F3n correr\u00E1n"
				+ " a cargo de aquellos.");
		textArea4.setLineWrap(true);
		textArea4.setEditable(false);
		textArea4.setBackground(SystemColor.menu);
		textArea4.setBounds(39, 1715, 851, 369);
		contentPanel.add(textArea4);
		
		JLabel lblCommonNotes = new JLabel("NOTAS COMUNES PARA TODOS LOS EPIGRAFES");
		lblCommonNotes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCommonNotes.setBounds(39, 3657, 442, 20);
		contentPanel.add(lblCommonNotes);
		
		JLabel lblNote1 = new JLabel("1 - NORMAS DE VALORACI\u00D3N");
		lblNote1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNote1.setBounds(39, 3720, 200, 14);
		contentPanel.add(lblNote1);
		
		JTextArea txtArea13 = new JTextArea();
		txtArea13.setWrapStyleWord(true);
		txtArea13.setText("Las valoraciones de esta Tarifa se corresponder\u00E1n con "
				+ "las contenidas en el anexo IV de la Circular del Banco de Espa\u00F1a"
				+ " n\u00B0 8/1990 de 7 de Septiembre.");
		txtArea13.setLineWrap(true);
		txtArea13.setEditable(false);
		txtArea13.setBackground(SystemColor.menu);
		txtArea13.setBounds(39, 3757, 851, 49);
		contentPanel.add(txtArea13);
		
		JLabel lblNote2 = new JLabel("2 - \u00C1MBITO DE APLICACI\u00D3N");
		lblNote2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNote2.setBounds(39, 3805, 200, 14);
		contentPanel.add(lblNote2);
		
		JLabel lblNote3 = new JLabel("3 - GASTOS");
		lblNote3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNote3.setBounds(39, 3941, 100, 14);
		contentPanel.add(lblNote3);
		
		JTextArea textArea15 = new JTextArea();
		textArea15.setWrapStyleWord(true);
		textArea15.setText("Ser\u00E1n a cargo del cliente cedente u ordenante el Impuesto"
				+ " sobre el Valor A\u00F1adido (IVA), los gastos de correo, t\u00E9lex, "
				+ "telegramas, timbres y tel\u00E9fono, si los hubiera.");
		textArea15.setLineWrap(true);
		textArea15.setEditable(false);
		textArea15.setBackground(SystemColor.menu);
		textArea15.setBounds(39, 3984, 851, 49);
		contentPanel.add(textArea15);
		
		JTextArea textArea14 = new JTextArea();
		textArea14.setWrapStyleWord(true);
		textArea14.setText("La presente Tarifa es de general aplicaci\u00F3n por la Caja "
				+ "de Ahorros a sus clientes, empresas o particulares, con excepci\u00F3n "
				+ "de las operaciones interbancarias directas realizadas con otras Cajas "
				+ "de Ahorros Confederadas, Bancos, Cajas Rurales y Cooperativas de"
				+ " Cr\u00E9dito inscritas en el Banco de Espa\u00F1a, en las que se"
				+ " aplicar\u00E1n las Tarifas correspondientes.En las operaciones o"
				+ " servicios solicitados por nuestros clientes, no contemplados en "
				+ "la presente tarifa, que realicen con car\u00E1cter excepcional o "
				+ "singular se aplicar\u00E1n las condiciones particulares que se establezcan "
				+ "en cada caso.");
		textArea14.setLineWrap(true);
		textArea14.setEditable(false);
		textArea14.setBackground(SystemColor.menu);
		textArea14.setBounds(39, 3846, 851, 119);
		contentPanel.add(textArea14);
		
		JPicture uleBankLogo2 = new JPicture("resources/es/unileon/aw/GUI/contractForm/UleBankLogo.png");
		uleBankLogo2.setBounds(572, 3500, 349, 110);
		contentPanel.add(uleBankLogo2);
		
		JLabel lblEpigrafe8 = new JLabel("EP\u00CDGRAFE 8 - MANTENIMIENTO Y ADMINISTRACI\u00D3N DE CUENTAS");
		lblEpigrafe8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEpigrafe8.setBounds(39, 4069, 607, 20);
		contentPanel.add(lblEpigrafe8);
		
		JLabel lblEpigrafe1 = new JLabel("1 - COMISI\u00D3N DE MANTENIMIENTO");
		lblEpigrafe1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEpigrafe1.setBounds(39, 4126, 248, 14);
		contentPanel.add(lblEpigrafe1);
		
		anualFee = new JTextField();
		anualFee.setEditable(false);
		anualFee.setText("30,00");
		anualFee.setHorizontalAlignment(SwingConstants.CENTER);
		anualFee.setBounds(236, 4182, 50, 20);
		contentPanel.add(anualFee);
		anualFee.setColumns(10);
		
		monthlyFeeFirm = new JTextField();
		monthlyFeeFirm.setText("20,00");
		monthlyFeeFirm.setHorizontalAlignment(SwingConstants.CENTER);
		monthlyFeeFirm.setEditable(false);
		monthlyFeeFirm.setColumns(10);
		monthlyFeeFirm.setBounds(263, 4263, 50, 20);
		contentPanel.add(monthlyFeeFirm);
		
		monthlyFeeCartilla = new JTextField();
		monthlyFeeCartilla.setText("4,00");
		monthlyFeeCartilla.setHorizontalAlignment(SwingConstants.CENTER);
		monthlyFeeCartilla.setEditable(false);
		monthlyFeeCartilla.setColumns(10);
		monthlyFeeCartilla.setBounds(263, 4295, 50, 20);
		contentPanel.add(monthlyFeeCartilla);
		
		monthlyFeePlus = new JTextField();
		monthlyFeePlus.setText("3,00");
		monthlyFeePlus.setHorizontalAlignment(SwingConstants.CENTER);
		monthlyFeePlus.setEditable(false);
		monthlyFeePlus.setColumns(10);
		monthlyFeePlus.setBounds(263, 4327, 50, 20);
		contentPanel.add(monthlyFeePlus);
		
		trimestralFeePersonal = new JTextField();
		trimestralFeePersonal.setText("10,00");
		trimestralFeePersonal.setHorizontalAlignment(SwingConstants.CENTER);
		trimestralFeePersonal.setEditable(false);
		trimestralFeePersonal.setColumns(10);
		trimestralFeePersonal.setBounds(266, 4359, 50, 20);
		contentPanel.add(trimestralFeePersonal);
		
		JLabel lblEpigrafe2 = new JLabel("2 - COMISI\u00D3N DE ADMINISTRACI\u00D3N");
		lblEpigrafe2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEpigrafe2.setBounds(39, 4410, 248, 14);
		contentPanel.add(lblEpigrafe2);
		
		administrationFee = new JTextField();
		administrationFee.setText("0,25");
		administrationFee.setHorizontalAlignment(SwingConstants.CENTER);
		administrationFee.setEditable(false);
		administrationFee.setColumns(10);
		administrationFee.setBounds(327, 4450, 50, 20);
		contentPanel.add(administrationFee);
		
		JLabel lblEpigrafe3 = new JLabel("3 - COMISI\u00D3N POR INFORMACI\u00D3N SOBRE MOVIMIENTOS DE LA CUENTA");
		lblEpigrafe3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEpigrafe3.setBounds(39, 4532, 463, 14);
		contentPanel.add(lblEpigrafe3);
		
		JTextArea textArea17 = new JTextArea();
		textArea17.setWrapStyleWord(true);
		textArea17.setText("En cuentas corrientes, se percibir\u00E1 una comisi\u00F3n de                  euros"
				+ " por apunte. Del cobro de esta comisi\u00F3n estar\u00E1n excluidos los apuntes que se"
				+ " generen como consecuencia de: Adeudo/abono de intereses, adeudo de comisiones, "
				+ "ingresos y reintegros en efectivo y adeudo de cheques. Quedan exentas de esta "
				+ "comisi\u00F3n las cuentas acogidas a Tarifa Plana. Los adeudos por estos conceptos "
				+ "se efectuar\u00E1n coincidiendo con la liquidaci\u00F3n peri\u00F3dica de la cuenta.");
		textArea17.setLineWrap(true);
		textArea17.setEditable(false);
		textArea17.setBackground(SystemColor.menu);
		textArea17.setBounds(39, 4452, 851, 119);
		contentPanel.add(textArea17);
		
		JTextArea textArea16 = new JTextArea();
		textArea16.setWrapStyleWord(true);
		textArea16.setText("- General:\r\nSe percibir\u00E1 una comisi\u00F3n anual de                  euros,"
				+ " que ser\u00E1 satisfecha en el momento de realizarse la liquidaci\u00F3n de intereses"
				+ " pactada. Cuando hubiere de practicarse m\u00E1s de una liquidaci\u00F3n en el "
				+ "per\u00EDodo de un a\u00F1o, esta comisi\u00F3n se percibir\u00E1 en cada una de "
				+ "ellas en cuant\u00EDa proporcional al n\u00FAmero de liquidaciones a efectuar en "
				+ "el a\u00F1o\r\n- Cuentas Tarifa Plana:\r\n   * Modalidad \"Empresa\".\r\n   Se "
				+ "percibir\u00E1 una comisi\u00F3n mensual de                  euros (ver nota 3).\r\n   "
				+ "* Modalidad \"La Cartilla +\".\r\n   Se percibir\u00E1 una comisi\u00F3n mensual "
				+ "de                  euros (ver nota 4)\r\n   * Modalidad \"Cuenta Plus\".\r\n   Se"
				+ " percibir\u00E1 una comisi\u00F3n mensual de                  euros (ver nota 5)\r\n   "
				+ "* Modalidad \"Cuenta Banca Personal\".\r\n   Se percibir\u00E1 una comisi\u00F3n trimestral"
				+ " de                  euros (ver nota 6)");
		textArea16.setLineWrap(true);
		textArea16.setEditable(false);
		textArea16.setBackground(SystemColor.menu);
		textArea16.setBounds(39, 4169, 851, 270);
		contentPanel.add(textArea16);
		
		JTextArea textArea18 = new JTextArea();
		textArea18.setWrapStyleWord(true);
		textArea18.setLineWrap(true);
		textArea18.setText("FOLLETO PARCIAL DE TARIFAS DE COMISIONES, GASTOS REPERCUTIBLES Y NORMAS DE "
				+ "VALORACION APLICABLES A LIBRETAS DE AHORRO A LA VISTA Y CUENTAS CORRIENTES");
		textArea18.setEditable(false);
		textArea18.setFont(new Font("Tahoma", Font.BOLD, 16));
		textArea18.setBackground(UIManager.getColor("Button.background"));
		textArea18.setBounds(7, 3528, 507, 82);
		contentPanel.add(textArea18);
		
		JPicture table1 = new JPicture("resources/es/unileon/aw/GUI/contractForm/table1.png");
		table1.setBounds(83, 4575, 807, 202);
		contentPanel.add(table1);
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
		
		JLabel lblEpigrafe4 = new JLabel("4 - DESCUBIERTOS EN CUENTA");
		lblEpigrafe4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEpigrafe4.setBounds(39, 4813, 200, 14);
		contentPanel.add(lblEpigrafe4);
		
		negativeBallanceFee = new JTextField();
		negativeBallanceFee.setText("4");
		negativeBallanceFee.setHorizontalAlignment(SwingConstants.CENTER);
		negativeBallanceFee.setEditable(false);
		negativeBallanceFee.setColumns(10);
		negativeBallanceFee.setBounds(547, 4851, 50, 20);
		contentPanel.add(negativeBallanceFee);
		
		JTextArea txtArea18 = new JTextArea();
		txtArea18.setWrapStyleWord(true);
		txtArea18.setText("Por descubiertos en cuenta corriente o saldos deudores en cuenta de ahorro, se percibir\u00E1 el                  por ciento sobre el mayor saldo deudor en cada periodo de liquidaci\u00F3n.");
		txtArea18.setLineWrap(true);
		txtArea18.setEditable(false);
		txtArea18.setBackground(SystemColor.menu);
		txtArea18.setBounds(39, 4853, 851, 49);
		contentPanel.add(txtArea18);
		
		JLabel lblEpigrafe5 = new JLabel("5 - GESTI\u00D3N DE RECLAMACI\u00D3N DE DESCUBIERTOS");
		lblEpigrafe5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEpigrafe5.setBounds(39, 4918, 338, 14);
		contentPanel.add(lblEpigrafe5);
		
		complaintFee = new JTextField();
		complaintFee.setText("25,00");
		complaintFee.setHorizontalAlignment(SwingConstants.CENTER);
		complaintFee.setEditable(false);
		complaintFee.setColumns(10);
		complaintFee.setBounds(451, 4955, 50, 20);
		contentPanel.add(complaintFee);
		
		JTextArea txtArea19 = new JTextArea();
		txtArea19.setWrapStyleWord(true);
		txtArea19.setText("Por cada posici\u00F3n deudora que se presente, se percibir\u00E1 un "
				+ "importe fijo de                  euros por una sola vez, cuando se genere la "
				+ "primera reclamaci\u00F3n por escrito solicitando su regularizaci\u00F3n.");
		txtArea19.setLineWrap(true);
		txtArea19.setEditable(false);
		txtArea19.setBackground(SystemColor.menu);
		txtArea19.setBounds(39, 4957, 851, 49);
		contentPanel.add(txtArea19);
		
		buyingFee = new JTextField();
		buyingFee.setText("5,00");
		buyingFee.setHorizontalAlignment(SwingConstants.CENTER);
		buyingFee.setEditable(false);
		buyingFee.setColumns(10);
		buyingFee.setBounds(108, 5679, 50, 20);
		contentPanel.add(buyingFee);
		
		buyingFeePercentage = new JTextField();
		buyingFeePercentage.setText("0,18");
		buyingFeePercentage.setHorizontalAlignment(SwingConstants.CENTER);
		buyingFeePercentage.setEditable(false);
		buyingFeePercentage.setColumns(10);
		buyingFeePercentage.setBounds(305, 5679, 50, 20);
		contentPanel.add(buyingFeePercentage);
		
		JLabel lblEpigrafe15 = new JLabel("EP\u00CDGRAFE 15 - OPERACIONES DE CUENTAS A LA VISTA");
		lblEpigrafe15.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEpigrafe15.setBounds(39, 5740, 429, 20);
		contentPanel.add(lblEpigrafe15);
		
		JLabel lblOperation1 = new JLabel("1 - LIBRETAS DE AHORRO");
		lblOperation1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOperation1.setBounds(39, 5807, 182, 14);
		contentPanel.add(lblOperation1);
		
		JPicture table2 = new JPicture("resources/es/unileon/aw/GUI/contractForm/table2.png");
		table2.setBounds(39, 5848, 851, 207);
		contentPanel.add(table2);
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
		
		JTextArea textArea20 = new JTextArea();
		textArea20.setWrapStyleWord(true);
		textArea20.setText("Nota 1 .- Los descubiertos en cuenta corriente se consideran operaciones"
				+ " de cr\u00E9dito a todos los efectos. Esta comisi\u00F3n no se aplicar\u00E1 en "
				+ "los descubiertos en cuenta por valoraci\u00F3n.\r\n\r\nNota 2.- Para los cr\u00E9ditos"
				+ " que se concedan en forma de descubiertos en cuentas corrientes de consumidores, "
				+ "la tasa anual equivalente (TAE) que suponga el cobro de comisiones de descubierto"
				+ " y los intereses devengados por el descubierto en el periodo de liquidaci\u00F3n"
				+ ", no ser\u00E1 superior a 2,5 veces el tipo de inter\u00E9s legal del "
				+ "dinero.\r\n\r\nNota 3.- La percepci\u00F3n de esta Tarifa Plana excluye el "
				+ "cobro de la comisi\u00F3n general de mantenimiento y de la comisi\u00F3n de "
				+ "administraci\u00F3n, e incluye los siguientes servicios sin comisi\u00F3n/cuota:\r\n- "
				+ "Las diez primeras operaciones al mes de transferencia en euros a entidades "
				+ "financieras ubicadas en territorio nacional sin limite de importe, o a estados "
				+ "miembros de la Uni\u00F3n Europea por importe igual o inferior a 50.000,00 euros "
				+ "(Reguladas por la Ley 9/1999 de 12 de abril) o de ingresos de cheques y pagar\u00E9s "
				+ "nacionales en euros domiciliados en una entidad financiera en Espa\u00F1a (sin "
				+ "incluir, en su caso, la comisi\u00F3n de devoluci\u00F3n).\r\n- Emisi\u00F3n, "
				+ "mantenimiento y renovaci\u00F3n de dos tarjetas de cr\u00E9dito \"Business plata\" "
				+ "o \"Business oro\" principal o asociada.\r\n- Mantenimiento de un M\u00F3dulo "
				+ "Empresas del Servicio L\u00EDne@Espa\u00F1a.\r\n- Las \u00F3rdenes de pago de n\u00F3minas"
				+ " con abono en cuenta.\r\n\r\nNota 4.- La percepci\u00F3n de esta Tarifa Plana excluye"
				+ " el cobro de la comisi\u00F3n general de mantenimiento y de la comisi\u00F3n de "
				+ "administraci\u00F3n, e incluye los siguientes servicios sin comisi\u00F3n/cuota:\r\n- "
				+ "Las dos primeras operaciones al mes de ingresos de cheques y pagar\u00E9s nacionales"
				+ " en euros domiciliados en una entidad financiera en Espa\u00F1a (no incluye la "
				+ "comisi\u00F3n de devoluci\u00F3n).\r\n- Las dos primeras operaciones al mes de "
				+ "transferencia en euros a entidades financieras ubicadas en territorio nacional "
				+ "sin l\u00EDmite de importe o a estados miembros de la UE por importe igual o inferior "
				+ "a 50.000,00 euros (Reguladas por la Ley 9/1999 de 12 de abril).\r\n- Emisi\u00F3n, "
				+ "mantenimiento y renovaci\u00F3n de cuatro tarjetas de cr\u00E9dito tipo ordinaria "
				+ "principal o asociada.\r\n- Una orden de pago peri\u00F3dica.\r\n\r\nNota 5.- La "
				+ "percepci\u00F3n de esta Tarifa Plana excluye el cobro de la comisi\u00F3n general "
				+ "de mantenimiento y de la c\u00F3misi\u00F3n de administraci\u00F3n, e incluye los "
				+ "siguientes servicios sin comisi\u00F3n/cuota.\r\n- Las tres primeras operaciones "
				+ "al mes de ingresos de cheques y pagar\u00E9s nacionales en euros domiciliados "
				+ "en una entidad financiera en Espa\u00F1a (no incluye la comisi\u00F3n de "
				+ "devoluci\u00F3n).\r\n- Las tres primeras operaciones al mes de transferencia"
				+ " b\u00E1sica.\r\n- Emisi\u00F3n, mantenimiento y renovaci\u00F3n de hasta cuatro"
				+ " tarjetas L\u00EDnea Espa\u00F1a 10 o Premium Gold pertenecientes como m\u00E1ximo"
				+ " a 2 titulares y 2 tarjetas por titular.\r\n- Seis primeros meses gratuitos "
				+ "del Servicio de env\u00EDo autom\u00E1tico de mensajes SMS.\r\n- Una orden de "
				+ "pago peri\u00F3dica.\r\n\r\nNota 6.- La percepci\u00F3n de esta Tarifa Plana "
				+ "excluye el cobro de la comisi\u00F3n general de mantenimiento y de la comisi\u00F3n "
				+ "de administraci\u00F3n, e incluye los siguientes servicios sin comisi\u00F3n/cuota:\r\n- "
				+ "Las cinco primeras operaciones al mes de ingresos de cheques y pagar\u00E9s "
				+ "nacionales en euros domiciliados en una entidad financiera en Espa\u00F1a "
				+ "(no incluye la comisi\u00F3n de devoluci\u00F3n).\r\n- Las cinco primeras "
				+ "operaciones al mes de transferencia b\u00E1sica.\r\n- Servicio de env\u00EDo "
				+ "autom\u00E1tico de mensajes SMS.\r\nAdem\u00E1s, incluye una tarifa especial "
				+ "para las operaciones de compra o venta de valores en mercados secundarios "
				+ "espa\u00F1oles, cualquiera que sea el canal utilizado, de                   euros"
				+ " por operaci\u00F3n m\u00E1s                    por ciento sobre el valor efectivo.");
		textArea20.setLineWrap(true);
		textArea20.setEditable(false);
		textArea20.setBackground(SystemColor.menu);
		textArea20.setBounds(39, 5008, 851, 894);
		contentPanel.add(textArea20);
		
		JLabel lblOperation2 = new JLabel("2 - CUENTAS CORRIENTES");
		lblOperation2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOperation2.setBounds(39, 6104, 182, 14);
		contentPanel.add(lblOperation2);
		
		JPicture table3 = new JPicture("resources/es/unileon/aw/GUI/contractForm/table3.png");
		table3.setLayout(null);
		table3.setBounds(39, 6159, 851, 96);
		contentPanel.add(table3);
		
		chequeFee = new JTextField();
		chequeFee.setText("10,00");
		chequeFee.setHorizontalAlignment(SwingConstants.CENTER);
		chequeFee.setEditable(false);
		chequeFee.setColumns(10);
		chequeFee.setBounds(706, 47, 50, 17);
		table3.add(chequeFee);
		
		JTextArea txtArea21 = new JTextArea();
		txtArea21.setWrapStyleWord(true);
		txtArea21.setText("LIMITES SOBRE VALORACI\u00D3N DE CARGOS Y ABONOS EN CUENTAS "
				+ "ACTIVAS Y\r\n   PASIVAS, EN CUENTAS CORRIENTES, DE CR\u00C9DITO Y LIBRETAS "
				+ "DE AHORRO");
		txtArea21.setLineWrap(true);
		txtArea21.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtArea21.setEditable(false);
		txtArea21.setBackground(SystemColor.menu);
		txtArea21.setBounds(180, 6300, 592, 49);
		contentPanel.add(txtArea21);
		
		JPicture table4 = new JPicture("resources/es/unileon/aw/GUI/contractForm/table4.png");
		table4.setBounds(39, 6382, 851, 787);
		contentPanel.add(table4);
		table4.setLayout(null);
		
		JLabel lblAuthorize = new JLabel("AUTORIZACIONES");
		lblAuthorize.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthorize.setBounds(39, 7209, 123, 14);
		contentPanel.add(lblAuthorize);
		
		JLabel lblPersonalDataProcessing = new JLabel("TRATAMIENTO AUTOMATIZADO DE DATOS PERSONALES");
		lblPersonalDataProcessing.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPersonalDataProcessing.setBounds(39, 7400, 400, 14);
		contentPanel.add(lblPersonalDataProcessing);
		
		JTextArea textArea23 = new JTextArea();
		textArea23.setWrapStyleWord(true);
		textArea23.setText("Los datos de caracter personal solicitados y recogidos en este "
				+ "document\u00B0 seran incorporados a los ficheros de tratarniento manual "
				+ "a autornatizado titularidad de ULEBANK. Ademas de para la finalidad propia"
				+ " del contrato a cuyo efecto se recogen los datos, Caja UleBank padre "
				+ "utilizer las mismos para el envie de comunicaciones relatives a cualquiera"
				+ " de sus productos y ofertas.\r\nLos interesados prestan su consentimiento "
				+ "expreso para que puedan ser cedidos a las Entidades del Grupo Caja UleBank,"
				+ " para la reatizacion de actividades propias de su objeto social, qua "
				+ "comprenden las de tipo financiero y parafinanciero en sus distintas "
				+ "modalidades. Tambien autorizan expresamente a que dichos datos puedan ser "
				+ "cedidos a empresas cuya actividad consista en la gestian y reparto de "
				+ "documentos, ofertas publicitarias sabre productos, servicios, promociones"
				+ " especiales, yenta directa y otras actividades anelogas.\r\nLos interesados"
				+ " tendran derecho, en los terminos previstos en Ley Orgenica 15/99, de 13 "
				+ "de diciembre, de Proteccion de Datos de Caracter Personal (LOPD), y en las"
				+ " normas qua resulten de aplicacion, a conocer, rectificar y canceler los "
				+ "datos de caracter personal incluidos en los ficheros automatizados de UleBank"
				+ " de Inversiones, Caja de Ahorros y Monte de Piedad. Estos derechos padran "
				+ "ser elercitados dirigiendose par escrito a UleBank, Servicio de Atencion "
				+ "al Cliente, Avda. de Madrid, 120, 24005 Leon, o bien mediante correo "
				+ "electronico al gestores.\r\nDe acuerdo can lo prevenido en la Ley 34/2002"
				+ " de 11 de julio sabre Informacion y Comercio Electr\u00F3nico, las "
				+ "interesados autarizan expresamente el envio de comunicaciones publicitarias"
				+ " o promocionales, relatives a productos, servicias o pramociones de Caja "
				+ "UleBank o de alguna de sus empresas participadas, a traves del correo "
				+ "electr\u00F3nico u otro media de comunicacian electrinica equivalente, "
				+ "incluido el envio de mensajes a traves de telefono movil o SMS.\r\nLos "
				+ "destinatarios podran ejercer el derecho de oposicion en cada una de las "
				+ "comunicaciones realizadas par carreo electr\u00F3nico u otra media "
				+ "electrinico equivalente, mediante mensaje a la direccion de carreo "
				+ "electronic\u00B0 de UleBank gestores, o bien dirigiendose par escrito a UleBank,"
				+ " Servicio de Atencion al Cliente, Avda. de Madrid, 120, 24005 Le\u00F3n.");
		textArea23.setLineWrap(true);
		textArea23.setEditable(false);
		textArea23.setBackground(SystemColor.menu);
		textArea23.setBounds(39, 7450, 851, 467);
		contentPanel.add(textArea23);
		
		JTextArea textArea22 = new JTextArea();
		textArea22.setWrapStyleWord(true);
		textArea22.setText("Para el caso de que as Titulares a los Autorizados entreguen a "
				+ "cedan a Is Caja dacumentos en gestion de cobra o descuento pare su abono "
				+ "en la cuenta, autorizan a la entidad en que se encuentre domiciliado el "
				+ "pago de los documentos cedidos pare que, actuanda par su cuenta e interes,"
				+ " requiera de pago a los obligados que resulten par razOn de dichas "
				+ "documentas para el caso de qua estos resultaren impagados; facultando, "
				+ "asimismo, a este entidad y a la Caja para que, cualquiera de ellas, "
				+ "facilite informacion a prestadores de servicios sabre solvencia patrimonial"
				+ " y credit\u00B0, en relacian a los incumplimientos relativos a los "
				+ "documentos cedidos. Los Titulares y las Autarizados se obligan a comunicar"
				+ " de forma inmediata y suficiente a la Caja el pago posterior de la deuda "
				+ "par el obligado, asumiendo las responsabilidades qua pudieran derivarse de"
				+ " incurnplimiento de tal obligacian y, en cansecuencia, de; mantenimiento "
				+ "inexact\u00B0 de datos en los ficheros de los prestadares de servicios "
				+ "antes indicados.");
		textArea22.setLineWrap(true);
		textArea22.setEditable(false);
		textArea22.setBackground(SystemColor.menu);
		textArea22.setBounds(39, 7251, 851, 193);
		contentPanel.add(textArea22);
		
		JButton editButton = new JButton(editIcon);
		editButton.setBounds(37, (int)screenSize.getHeight()-90, 41, 41);
		picture.add(editButton);
		editButton.setOpaque(false);
		editButton.setContentAreaFilled(false);
		editButton.setBorderPainted(false);
		editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editButton.setFocusPainted(false);
		
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
		
		JButton denyButton = new JButton(denyIcon);
		denyButton.setBounds(918, (int)screenSize.getHeight()-90, 41, 41);
		picture.add(denyButton);
		denyButton.setOpaque(false);
		denyButton.setContentAreaFilled(false);
		denyButton.setBorderPainted(false);
		denyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		denyButton.setFocusPainted(false);
		
		denyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(mainFrame,
				    "Operation Canceled!",
				    "Operation Canceled!",
				    JOptionPane.ERROR_MESSAGE);
				
				mainFrame.dispose();
				
			}
		});
		
		JButton acceptButton = new JButton(acceptIcon);
		acceptButton.setBounds(854, (int)screenSize.getHeight()-90, 41, 41);
		picture.add(acceptButton);
		acceptButton.setOpaque(false);
		acceptButton.setContentAreaFilled(false);
		acceptButton.setBorderPainted(false);
		acceptButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		acceptButton.setFocusPainted(false);
		
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				new SignatureFrame();
				
			}
		});
		
		mainFrame.setVisible(true);
				
	}
}
