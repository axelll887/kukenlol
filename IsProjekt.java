package org.lu.ics.labbar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;

public class IsProjekt {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IsProjekt window = new IsProjekt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IsProjekt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblKundregister = new JLabel("Kundregister");
		lblKundregister.setFont(new Font("Wingdings", Font.BOLD, 14));
		lblKundregister.setBounds(28, 23, 112, 24);
		frame.getContentPane().add(lblKundregister);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 45, 293, 16);
		frame.getContentPane().add(separator);
		
		JLabel lblFörnamnEfternamn = new JLabel("För- och Efternamn");
		lblFörnamnEfternamn.setFont(new Font("Wingdings", Font.PLAIN, 12));
		lblFörnamnEfternamn.setBounds(28, 67, 155, 16);
		frame.getContentPane().add(lblFörnamnEfternamn);
		
		textField_1 = new JTextField();
		textField_1.setBounds(24, 82, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setFont(new Font("Wingdings", Font.PLAIN, 12));
		lblAdress.setBounds(28, 120, 61, 16);
		frame.getContentPane().add(lblAdress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(24, 133, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Sök kund");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(24, 171, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblKundnummer = new JLabel("Kundnummer");
		lblKundnummer.setFont(new Font("Wingdings", Font.PLAIN, 12));
		lblKundnummer.setBounds(196, 119, 105, 16);
		frame.getContentPane().add(lblKundnummer);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 133, 130, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JCheckBox chckbxVisaOrderTillhrande = new JCheckBox("Visa ordrar tillhörande till kund ");
		chckbxVisaOrderTillhrande.setFont(new Font("Wingdings", Font.PLAIN, 11));
		chckbxVisaOrderTillhrande.setBounds(28, 235, 224, 23);
		frame.getContentPane().add(chckbxVisaOrderTillhrande);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 258, 293, 16);
		frame.getContentPane().add(separator_1);
		
		JButton btnSkapa = new JButton("Skapa");
		btnSkapa.setBounds(23, 206, 117, 29);
		frame.getContentPane().add(btnSkapa);
		
		JButton btnTaBort = new JButton("Ta bort");
		btnTaBort.setBounds(191, 171, 117, 29);
		frame.getContentPane().add(btnTaBort);
		
		table = new JTable();
		table.setBounds(28, 286, 293, 58);
		frame.getContentPane().add(table);
		
		JButton btnLggTillOrder = new JButton("Lägg till order");
		btnLggTillOrder.setBounds(28, 377, 117, 29);
		frame.getContentPane().add(btnLggTillOrder);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(28, 363, 293, 12);
		frame.getContentPane().add(separator_2);
		
		JButton btnndraKund = new JButton("Ändra kund");
		btnndraKund.setBounds(196, 206, 117, 29);
		frame.getContentPane().add(btnndraKund);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(352, 0, 39, 510);
		frame.getContentPane().add(separator_3);
		
		JLabel lblProduktregister = new JLabel("Produktregister");
		lblProduktregister.setFont(new Font("Wingdings", Font.BOLD, 14));
		lblProduktregister.setBounds(397, 27, 112, 16);
		frame.getContentPane().add(lblProduktregister);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(397, 45, 293, 12);
		frame.getContentPane().add(separator_4);
		
		JLabel lblNamn = new JLabel("Namn");
		lblNamn.setFont(new Font("Wingdings", Font.PLAIN, 12));
		lblNamn.setBounds(397, 67, 61, 16);
		frame.getContentPane().add(lblNamn);
		
		JLabel lblKategori = new JLabel("Kategori");
		lblKategori.setFont(new Font("Wingdings", Font.PLAIN, 12));
		lblKategori.setBounds(565, 66, 72, 16);
		frame.getContentPane().add(lblKategori);
		
		textField_4 = new JTextField();
		textField_4.setBounds(391, 81, 130, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(559, 81, 130, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPris = new JLabel("Pris");
		lblPris.setFont(new Font("Wingdings", Font.PLAIN, 12));
		lblPris.setBounds(397, 119, 61, 16);
		frame.getContentPane().add(lblPris);
		
		textField_6 = new JTextField();
		textField_6.setBounds(391, 133, 130, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSk = new JButton("Sök");
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSk.setBounds(391, 171, 117, 29);
		frame.getContentPane().add(btnSk);
		
		JButton btnSkapa_1 = new JButton("Skapa");
		btnSkapa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSkapa_1.setBounds(565, 171, 117, 29);
		frame.getContentPane().add(btnSkapa_1);
		
		JButton btnTaBort_1 = new JButton("Ta bort");
		btnTaBort_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTaBort_1.setBounds(391, 206, 117, 29);
		frame.getContentPane().add(btnTaBort_1);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(397, 258, 299, 12);
		frame.getContentPane().add(separator_5);
		
		table_1 = new JTable();
		table_1.setBounds(403, 286, 287, 58);
		frame.getContentPane().add(table_1);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(397, 363, 299, 12);
		frame.getContentPane().add(separator_6);
	}
}
