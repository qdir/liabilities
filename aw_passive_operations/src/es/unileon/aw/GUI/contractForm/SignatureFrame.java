package es.unileon.aw.GUI.contractForm;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.JButton;

public class SignatureFrame {

	private JFrame frame;

	public SignatureFrame() {
		
		launchFrame();
	}

	private void launchFrame() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setResizable(false);
		ImageIcon frameImage = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/frameImage2.jpg");
		frame.setIconImage(frameImage.getImage());
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPicture picture = new JPicture("resources/es/unileon/aw/GUI/contractForm/grayBackground3.jpg");
		picture.setBounds(0, 0, 810, 422);
		frame.getContentPane().add(picture);
		
		new JDraggable(frame, picture);
		picture.setLayout(null);
		
		JLabel lblMessage = new JLabel("IT IS NECESSARY FOR BOTH PARTIES TO SIGN THE DOCUMENT");
		lblMessage.setBounds(208, 11, 381, 16);
		lblMessage.setForeground(UIManager.getColor("Button.shadow"));
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 13));
		picture.add(lblMessage);
		
		JLabel lblOwnerSignature = new JLabel("Owners/Authorized Signature");
		lblOwnerSignature.setForeground(UIManager.getColor("Button.shadow"));
		lblOwnerSignature.setBounds(116, 61, 199, 14);
		picture.add(lblOwnerSignature);
		
		JLabel lblBankSignature = new JLabel("UleBank Signature");
		lblBankSignature.setForeground(UIManager.getColor("Button.shadow"));
		lblBankSignature.setBounds(555, 61, 191, 14);
		picture.add(lblBankSignature);
		
		JDrawable drawable = new JDrawable();
		drawable.setBounds(10, 82, 381, 280);
		picture.add(drawable);
		
		JDrawable drawable_1 = new JDrawable();
		drawable_1.setBounds(419, 82, 381, 280);
		picture.add(drawable_1);
		
		Icon acceptIcon = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/AcceptButton2.png");
		Icon denyIcon = new ImageIcon("resources/es/unileon/aw/GUI/contractForm/DenyButton2.png");
		
		JButton acceptButton = new JButton(acceptIcon);
		acceptButton.setBounds(713, 382, 33, 33);
		picture.add(acceptButton);
		acceptButton.setOpaque(false);
		acceptButton.setContentAreaFilled(false);
		acceptButton.setBorderPainted(false);
		acceptButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		acceptButton.setFocusPainted(false);
		
		JButton denyButton = new JButton(denyIcon);
		denyButton.setBounds(767, 382, 33, 33);
		picture.add(denyButton);
		denyButton.setOpaque(false);
		denyButton.setContentAreaFilled(false);
		denyButton.setBorderPainted(false);
		denyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		denyButton.setFocusPainted(false);
		
		denyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(frame,
				    "Operation Canceled!",
				    "Operation Canceled!",
				    JOptionPane.ERROR_MESSAGE);
				
				frame.dispose();
				
			}
		});
		
		
		frame.setVisible(true);
			
	}
}
