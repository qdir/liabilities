package es.unileon.ulebank.GUI.contractForm;

import java.awt.Font;
import java.awt.SystemColor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 * Class which contains all JTextArea components used in the main window
 * @author Emanuel Iosif Rele
 */
public class JTextAreas {
    
    private final Charset ENCODING = StandardCharsets.UTF_8;
    
    public JTextAreas(JPanel contentPanel){
        
        /**
         * Class constructor
         * @param contentPanel represents the panel where all athe Text Areas are placed
         */
        placeTextAreas(contentPanel);
        
    }
    
    /**
    * Places all the Text Areas in their corresponding spaces 
    * @param contentPanel represents the panel where all the Text Areas are placed
    */
    private void placeTextAreas(JPanel contentPanel){
        
        String fileText = null;
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text1.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextArea txtArea1 = new JTextArea();
	txtArea1.setEditable(false);
	txtArea1.setBackground(UIManager.getColor("Button.background"));
	txtArea1.setLineWrap(true);
	txtArea1.setWrapStyleWord(true);
        txtArea1.setText(fileText);
	txtArea1.setBounds(39, 995, 851, 82);
	contentPanel.add(txtArea1);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text3.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextArea txtArea3 = new JTextArea();
	txtArea3.setWrapStyleWord(true);
        txtArea3.setText(fileText);
	txtArea3.setLineWrap(true);
	txtArea3.setEditable(false);
	txtArea3.setBackground(SystemColor.menu);
	txtArea3.setBounds(39, 1576, 851, 119);
	contentPanel.add(txtArea3);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text2.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	JTextArea textArea2 = new JTextArea();
	textArea2.setWrapStyleWord(true);
        textArea2.setText(fileText);
	textArea2.setLineWrap(true);
	textArea2.setEditable(false);
	textArea2.setBackground(SystemColor.menu);
	textArea2.setBounds(39, 1244, 851, 436);
	contentPanel.add(textArea2);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text12.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextArea textArea12 = new JTextArea();
        textArea12.setWrapStyleWord(true);
        textArea12.setText(fileText);
        textArea12.setLineWrap(true);
        textArea12.setEditable(false);
        textArea12.setBackground(SystemColor.menu);
        textArea12.setBounds(39, 3349, 851, 65);
        contentPanel.add(textArea12);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text11.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea11 = new JTextArea();
        textArea11.setWrapStyleWord(true);
        textArea11.setText(fileText);
        textArea11.setLineWrap(true);
        textArea11.setEditable(false);
        textArea11.setBackground(SystemColor.menu);
        textArea11.setBounds(39, 3226, 851, 87);
        contentPanel.add(textArea11);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text10.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea10 = new JTextArea();
        textArea10.setWrapStyleWord(true);
        textArea10.setText(fileText);     
        textArea10.setLineWrap(true);
        textArea10.setEditable(false);
        textArea10.setBackground(SystemColor.menu);
        textArea10.setBounds(39, 3065, 851, 153);
        contentPanel.add(textArea10);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text9.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea9 = new JTextArea();
        textArea9.setWrapStyleWord(true);
        textArea9.setText(fileText);
        textArea9.setLineWrap(true);
        textArea9.setEditable(false);
        textArea9.setBackground(SystemColor.menu);
        textArea9.setBounds(39, 2902, 851, 137);
        contentPanel.add(textArea9);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text8.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea8 = new JTextArea();
        textArea8.setWrapStyleWord(true);
        textArea8.setText(fileText);
        textArea8.setLineWrap(true);
        textArea8.setEditable(false);
        textArea8.setBackground(SystemColor.menu);
        textArea8.setBounds(39, 2693, 851, 227);
        contentPanel.add(textArea8);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text7.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea7 = new JTextArea();
        textArea7.setWrapStyleWord(true);
        textArea7.setText(fileText);
        textArea7.setLineWrap(true);
        textArea7.setEditable(false);
        textArea7.setBackground(SystemColor.menu);
        textArea7.setBounds(39, 2454, 851, 256);
        contentPanel.add(textArea7);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text6.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea txtArea6 = new JTextArea();
        txtArea6.setWrapStyleWord(true);
        txtArea6.setText(fileText);
        txtArea6.setLineWrap(true);
        txtArea6.setEditable(false);
        txtArea6.setBackground(SystemColor.menu);
        txtArea6.setBounds(39, 2233, 851, 211);
        contentPanel.add(txtArea6);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text5.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea5 = new JTextArea();
        textArea5.setWrapStyleWord(true);
        textArea5.setText(fileText);
        textArea5.setLineWrap(true);
        textArea5.setEditable(false);
        textArea5.setBackground(SystemColor.menu);
        textArea5.setBounds(39, 2015, 851, 227);
        contentPanel.add(textArea5);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text4.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea4 = new JTextArea();
        textArea4.setWrapStyleWord(true);
        textArea4.setText(fileText);
        textArea4.setLineWrap(true);
        textArea4.setEditable(false);
        textArea4.setBackground(SystemColor.menu);
        textArea4.setBounds(39, 1715, 851, 369);
        contentPanel.add(textArea4);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text13.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea txtArea13 = new JTextArea();
        txtArea13.setWrapStyleWord(true);
        txtArea13.setText(fileText);
        txtArea13.setLineWrap(true);
        txtArea13.setEditable(false);
        txtArea13.setBackground(SystemColor.menu);
        txtArea13.setBounds(39, 3757, 851, 49);
        contentPanel.add(txtArea13);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text15.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea15 = new JTextArea();
        textArea15.setWrapStyleWord(true);
        textArea15.setText(fileText);
        textArea15.setLineWrap(true);
        textArea15.setEditable(false);
        textArea15.setBackground(SystemColor.menu);
        textArea15.setBounds(39, 3984, 851, 49);
        contentPanel.add(textArea15);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text14.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea14 = new JTextArea();
        textArea14.setWrapStyleWord(true);
        textArea14.setText(fileText);
        textArea14.setLineWrap(true);
        textArea14.setEditable(false);
        textArea14.setBackground(SystemColor.menu);
        textArea14.setBounds(39, 3846, 851, 119);
        contentPanel.add(textArea14);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text17.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextArea textArea17 = new JTextArea();
        textArea17.setWrapStyleWord(true);
        textArea17.setText(fileText);
        textArea17.setLineWrap(true);
        textArea17.setEditable(false);
        textArea17.setBackground(SystemColor.menu);
        textArea17.setBounds(39, 4452, 851, 119);
        contentPanel.add(textArea17);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text16.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea16 = new JTextArea();
        textArea16.setWrapStyleWord(true);
        textArea16.setText(fileText);
        textArea16.setLineWrap(true);
        textArea16.setEditable(false);
        textArea16.setBackground(SystemColor.menu);
        textArea16.setBounds(39, 4169, 851, 270);
        contentPanel.add(textArea16);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text18.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea18 = new JTextArea();
        textArea18.setWrapStyleWord(true);
        textArea18.setLineWrap(true);
        textArea18.setText(fileText);
        textArea18.setEditable(false);
        textArea18.setFont(new Font("Tahoma", Font.BOLD, 16));
        textArea18.setBackground(UIManager.getColor("Button.background"));
        textArea18.setBounds(7, 3528, 507, 82);
        contentPanel.add(textArea18);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text182.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextArea txtArea18 = new JTextArea();
	txtArea18.setWrapStyleWord(true);
        txtArea18.setText(fileText);
	txtArea18.setLineWrap(true);
	txtArea18.setEditable(false);
	txtArea18.setBackground(SystemColor.menu);
	txtArea18.setBounds(39, 4853, 851, 49);
	contentPanel.add(txtArea18);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text19.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextArea txtArea19 = new JTextArea();
	txtArea19.setWrapStyleWord(true);
        txtArea19.setText(fileText);
	txtArea19.setLineWrap(true);
	txtArea19.setEditable(false);
	txtArea19.setBackground(SystemColor.menu);
	txtArea19.setBounds(39, 4957, 851, 49);
	contentPanel.add(txtArea19);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text20.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextArea textArea20 = new JTextArea();
        textArea20.setWrapStyleWord(true);
        textArea20.setText(fileText);
        textArea20.setLineWrap(true);
        textArea20.setEditable(false);
        textArea20.setBackground(SystemColor.menu);
        textArea20.setBounds(39, 5008, 851, 894);
        contentPanel.add(textArea20);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text21.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextArea txtArea21 = new JTextArea();
        txtArea21.setWrapStyleWord(true);
        txtArea21.setText(fileText);        
        txtArea21.setLineWrap(true);
        txtArea21.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtArea21.setEditable(false);
        txtArea21.setBackground(SystemColor.menu);
        txtArea21.setBounds(180, 6300, 592, 49);
        contentPanel.add(txtArea21);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text23.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextArea textArea23 = new JTextArea();
        textArea23.setWrapStyleWord(true);
        textArea23.setText(fileText);
        textArea23.setLineWrap(true);
        textArea23.setEditable(false);
        textArea23.setBackground(SystemColor.menu);
        textArea23.setBounds(39, 7450, 851, 467);
        contentPanel.add(textArea23);
        
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text22.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea textArea22 = new JTextArea();
        textArea22.setWrapStyleWord(true);
        textArea22.setText(fileText);      
        textArea22.setLineWrap(true);
        textArea22.setEditable(false);
        textArea22.setBackground(SystemColor.menu);
        textArea22.setBounds(39, 7251, 851, 193);
        contentPanel.add(textArea22);
        
    }
    
    private String readFile(String path) throws IOException {

        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return ENCODING.decode(ByteBuffer.wrap(encoded)).toString();      
    }
    
}
