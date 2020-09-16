package jm1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class SalesEntry extends JFrame {

	private JPanel contentPane;
	private JTextField CreditLimit;
	private JTextField UnitPriceField;
	private JTextField textField_4;
	private JTextField Name;
	private JTextField QtyField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesEntry frame = new SalesEntry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SalesEntry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(59, 32, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblCreditLimit = new JLabel("Credit Limit:");
		lblCreditLimit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCreditLimit.setBounds(59, 71, 90, 14);
		contentPane.add(lblCreditLimit);
		
		CreditLimit = new JTextField();
		CreditLimit.setBounds(150, 64, 229, 30);
		contentPane.add(CreditLimit);
		CreditLimit.setColumns(10);
		
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInformation.setBounds(59, 104, 90, 14);
		contentPane.add(lblInformation);
		
		final JTextArea textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("I am " + Name.getText() + " and my credit limit is " +CreditLimit.getText() +".");
			}
			
			public void mouseExited(MouseEvent arg0) {
				textArea.setText("");
			}
		});
		textArea.setBounds(89, 129, 290, 62);
		contentPane.add(textArea);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItem.setBounds(59, 213, 46, 14);
		contentPane.add(lblItem);
		
		JLabel lblPrice = new JLabel("Unit Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(59, 254, 66, 14);
		contentPane.add(lblPrice);
		
		UnitPriceField = new JTextField();
		UnitPriceField.setBounds(138, 251, 228, 23);
		contentPane.add(UnitPriceField);
		UnitPriceField.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(138, 321, 228, 30);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		String[] items = new String[]{"Please Seclect","Umbrella", "Shoes", "Hat", "Towel"};
		final JComboBox comboBox = new JComboBox(items);
		comboBox.setBounds(138, 211, 228, 20);
		contentPane.add(comboBox);
		
		final JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					PrintWriter printWriter = new PrintWriter(new FileWriter("Sales.text", true));
					printWriter.write(Name.getText() +":"+ CreditLimit.getText()+ ":" +comboBox.getSelectedItem() +":"+ UnitPriceField.getText()+":"+ QtyField.getText()+":" +textField_4.getText() +"\n"); 
					JOptionPane.showMessageDialog(btnConfirm, "Save Succesfully!","",JOptionPane.INFORMATION_MESSAGE);
					printWriter.close();
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnConfirm.setBounds(198, 362, 89, 23);
		contentPane.add(btnConfirm);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double unitPrice = Double.parseDouble(UnitPriceField.getText());
				int Qty = Integer.parseInt(QtyField.getText());
				double Total = unitPrice * Qty;
				textField_4.setText(Double.toString(Total));
				
			}
		});
		btnTotal.setBounds(59, 325, 66, 23);
		contentPane.add(btnTotal);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(150, 25, 229, 30);
		contentPane.add(Name);
		
		
		QtyField = new JTextField();
		QtyField.setColumns(10);
		QtyField.setBounds(138, 287, 228, 23);
		contentPane.add(QtyField);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQty.setBounds(59, 291, 66, 14);
		contentPane.add(lblQty);
	}
}
