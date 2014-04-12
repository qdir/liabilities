package es.unileon.ulebank.GUI.contractForm;

import java.awt.Font;
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

/**
 * Class which contains all JTextArea components used in the main window
 * @author Emanuel Iosif Relea
 */
public class JTextAreas {
    
    private final Charset ENCODING = StandardCharsets.UTF_8;
    
    public JTextAreas(JPanel panelAuthorized){
        
        /**
         * Class constructor
         * @param contentPanel represents the panel where all the Text Areas are placed
         */
        placeTextAreas(panelAuthorized);
        
    }
    
    /**
    * Places all the Text Areas in their corresponding spaces 
    * @param panelAuthorized represents the panel where all the Text Areas are placed
    */
    private void placeTextAreas(JPanel panelAuthorized){
        
        String fileText = null;
        try {
            fileText = this.readFile("resources/es/unileon/ulebank/GUI/contractForm/text/text1.txt");
        } catch (IOException ex) {
            Logger.getLogger(JTextAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

        JTextArea txtArea1 = new JTextArea();
	txtArea1.setEditable(false);
	txtArea1.setBackground(panelAuthorized.getBackground());
	txtArea1.setLineWrap(true);
	txtArea1.setWrapStyleWord(true);
        txtArea1.setText(fileText);
	txtArea1.setBounds(39, 245, 851, 82);
	panelAuthorized.add(txtArea1);
        
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
	txtArea3.setBackground(panelAuthorized.getBackground());
	txtArea3.setBounds(39, 826, 851, 119);
	panelAuthorized.add(txtArea3);
        
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
	textArea2.setBackground(panelAuthorized.getBackground());
	textArea2.setBounds(39, 494, 851, 436);
	panelAuthorized.add(textArea2);
        
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
        textArea12.setBackground(panelAuthorized.getBackground());
        textArea12.setBounds(39, 2599, 851, 65);
        panelAuthorized.add(textArea12);

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
        textArea11.setBackground(panelAuthorized.getBackground());
        textArea11.setBounds(39, 2476, 851, 87);
        panelAuthorized.add(textArea11);

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
        textArea10.setBackground(panelAuthorized.getBackground());
        textArea10.setBounds(39, 2315, 851, 153);
        panelAuthorized.add(textArea10);

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
        textArea9.setBackground(panelAuthorized.getBackground());
        textArea9.setBounds(39, 2152, 851, 137);
        panelAuthorized.add(textArea9);

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
        textArea8.setBackground(panelAuthorized.getBackground());
        textArea8.setBounds(39, 1943, 851, 227);
        panelAuthorized.add(textArea8);

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
        textArea7.setBackground(panelAuthorized.getBackground());
        textArea7.setBounds(39, 1704, 851, 256);
        panelAuthorized.add(textArea7);

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
        txtArea6.setBackground(panelAuthorized.getBackground());
        txtArea6.setBounds(39, 1483, 851, 211);
        panelAuthorized.add(txtArea6);

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
        textArea5.setBackground(panelAuthorized.getBackground());
        textArea5.setBounds(39, 1265, 851, 227);
        panelAuthorized.add(textArea5);

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
        textArea4.setBackground(panelAuthorized.getBackground());
        textArea4.setBounds(39, 965, 851, 369);
        panelAuthorized.add(textArea4);

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
        txtArea13.setBackground(panelAuthorized.getBackground());
        txtArea13.setBounds(39, 3007, 851, 49);
        panelAuthorized.add(txtArea13);

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
        textArea15.setBackground(panelAuthorized.getBackground());
        textArea15.setBounds(39, 3234, 851, 49);
        panelAuthorized.add(textArea15);

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
        textArea14.setBackground(panelAuthorized.getBackground());
        textArea14.setBounds(39, 3096, 851, 119);
        panelAuthorized.add(textArea14);

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
        textArea17.setBackground(panelAuthorized.getBackground());
        textArea17.setBounds(39, 3702, 851, 119);
        panelAuthorized.add(textArea17);

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
        textArea16.setBackground(panelAuthorized.getBackground());
        textArea16.setBounds(39, 3419, 851, 270);
        panelAuthorized.add(textArea16);

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
        textArea18.setBackground(panelAuthorized.getBackground());
        textArea18.setBounds(7, 2778, 507, 82);
        panelAuthorized.add(textArea18);

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
	txtArea18.setBackground(panelAuthorized.getBackground());
	txtArea18.setBounds(39, 4103, 851, 49);
	panelAuthorized.add(txtArea18);
        
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
	txtArea19.setBackground(panelAuthorized.getBackground());
	txtArea19.setBounds(39, 4207, 851, 49);
	panelAuthorized.add(txtArea19);
        
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
        textArea20.setBackground(panelAuthorized.getBackground());
        textArea20.setBounds(39, 4258, 851, 894);
        panelAuthorized.add(textArea20);

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
        txtArea21.setBackground(panelAuthorized.getBackground());
        txtArea21.setBounds(180, 5550, 600, 49);
        panelAuthorized.add(txtArea21);

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
        textArea23.setBackground(panelAuthorized.getBackground());
        textArea23.setBounds(39, 6700, 851, 467);
        panelAuthorized.add(textArea23);

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
        textArea22.setBackground(panelAuthorized.getBackground());
        textArea22.setBounds(39, 6501, 851, 193);
        panelAuthorized.add(textArea22);
        
    }
    
    
    /**
     * Reads text from a .txt file
     * @param path path of the file to read
     * @return returns the text contained in the file as a String
     * @throws IOException
     */
    private String readFile(String path) throws IOException {

        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return ENCODING.decode(ByteBuffer.wrap(encoded)).toString();      
    }
    
}
