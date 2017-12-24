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
import javax.swing.JTextPane;
import java.awt.TextArea;

public class IsProjekt {

	private JFrame frame;
	private JTextField textField_surAndLast;
	private JTextField textField_address;
	private JTextField textField_customerNbr;
	private JTextField textField_productName;
	private JTextField textField_kategory;
	private JTextField textField_price;
	private JTextField textField_customerNbr2;
	private JTextField textField_7;
	private JTextField textField_productName2;
	private JTextField textField_serialNumber;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_total;

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
		CustomerDirectory cD = new CustomerDirectory();
		ProductDirectory pD = new ProductDirectory();
		Controller controller = new Controller(cD, pD, frame);

		frame = new JFrame();
		frame.setBounds(100, 100, 715, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblKundregister = new JLabel("Kundregister");
		lblKundregister.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKundregister.setBounds(28, 6, 112, 24);
		frame.getContentPane().add(lblKundregister);

		JSeparator separator = new JSeparator();
		separator.setBounds(28, 27, 293, 16);
		frame.getContentPane().add(separator);

		JTextArea textArea_customer = new JTextArea();
		textArea_customer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textArea_customer.setBounds(28, 228, 293, 66);
		frame.getContentPane().add(textArea_customer);
		
		JTextArea textArea_product = new JTextArea();
		textArea_product.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textArea_product.setBounds(396, 227, 287, 66);
		frame.getContentPane().add(textArea_product);

		JLabel lblSurnameAndLastname = new JLabel("För- och Efternamn");
		lblSurnameAndLastname.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSurnameAndLastname.setBounds(28, 42, 155, 16);
		frame.getContentPane().add(lblSurnameAndLastname);

		textField_surAndLast = new JTextField();
		textField_surAndLast.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_surAndLast.setBounds(24, 55, 130, 26);
		frame.getContentPane().add(textField_surAndLast);
		textField_surAndLast.setColumns(10);

		JLabel lblAddress = new JLabel("Adress");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddress.setBounds(28, 80, 61, 16);
		frame.getContentPane().add(lblAddress);

		textField_address = new JTextField();
		textField_address.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_address.setBounds(24, 93, 130, 26);
		frame.getContentPane().add(textField_address);
		textField_address.setColumns(10);

		JButton btnSearchCustomer = new JButton("Sök kund");
		btnSearchCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String customerNumber = textField_customerNbr.getText();

				Customer c = controller.findCustomer(customerNumber);
				if (customerNumber.isEmpty())
					textArea_customer.setText("Vänlig fyll i kundnummer.");

				else if (c != null) {
					textField_surAndLast.setText(c.getName());
					textField_address.setText(c.getAddress());
					textField_customerNbr.setText(c.getCustomerNumber());
					textArea_customer.setText("Person " + c.getName().toUpperCase() + " hittad.");
				} else {
					textField_surAndLast.setText("---");
					textField_address.setText("---");
					textArea_customer.setText("Personen med kundnumret " + customerNumber + " hittas ej");
				}
			}

		});
		btnSearchCustomer.setBounds(29, 131, 117, 29);
		frame.getContentPane().add(btnSearchCustomer);

		JLabel lblCustomerNumber = new JLabel("Kundnummer");
		lblCustomerNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCustomerNumber.setBounds(195, 42, 105, 16);
		frame.getContentPane().add(lblCustomerNumber);

		textField_customerNbr = new JTextField();
		textField_customerNbr.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_customerNbr.setBounds(191, 55, 130, 26);
		frame.getContentPane().add(textField_customerNbr);
		textField_customerNbr.setColumns(10);

		JCheckBox chckbxVisaOrderTillhrande = new JCheckBox("Visa ordrar tillhörande till kund ");
		chckbxVisaOrderTillhrande.setFont(new Font("Wingdings", Font.PLAIN, 11));
		chckbxVisaOrderTillhrande.setBounds(33, 195, 224, 23);
		frame.getContentPane().add(chckbxVisaOrderTillhrande);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 218, 293, 16);
		frame.getContentPane().add(separator_1);

		JButton btnCreate = new JButton("Skapa");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_surAndLast.getText();
				String customerNumber = textField_customerNbr.getText();
				String address = textField_address.getText();
				Customer c = controller.findCustomer(customerNumber);

				if (customerNumber.isEmpty() || name.isEmpty() || address.isEmpty()) {
					textArea_customer.setText("Du måste fylla i alla fält.");
				} else if (c != null) {
					textArea_customer.setText("Kundnumret finns redan");
					textField_surAndLast.setText("---");
					textField_address.setText("---");

				}else {
					c = controller.addCustomer(customerNumber, name, address);
					textArea_customer.setText("Person " + c.getName().toUpperCase() + " tillagd");
				}

			}
		});
		btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCreate.setBounds(28, 166, 117, 29);
		frame.getContentPane().add(btnCreate);

		JButton btnRemoveCustomer = new JButton("Ta bort");
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String customerNumber = textField_customerNbr.getText();
				Customer c = controller.removeCustomer(customerNumber);

				if (customerNumber.isEmpty()) {
					textArea_customer.setText("Du måste fylla i kundnumret");
				} else if (c != null) {
					textField_surAndLast.setText(c.getName());
					textField_customerNbr.setText(c.getCustomerNumber());
					textField_address.setText(c.getAddress());
					textArea_customer.setText("Personen " + c.getName().toUpperCase() + " borttagen");
				} else {
					textField_surAndLast.setText("---");
					textField_address.setText("---");
					textArea_customer.setText("Personen med kundnumret " + customerNumber + " existerar inte");
				}
			}

		});
		btnRemoveCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRemoveCustomer.setBounds(201, 131, 117, 29);
		frame.getContentPane().add(btnRemoveCustomer);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(28, 292, 293, 12);
		frame.getContentPane().add(separator_2);

		JButton btnChangeCustomer = new JButton("Ändra kund");
		btnChangeCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String customerNumber = textField_customerNbr.getText();
				Customer c = controller.findCustomer(customerNumber);

				if (customerNumber.isEmpty()) {
					textArea_customer.setText("Du måste fylla i kundnumret");
				
				} else if (c != null) {
					textArea_customer.setText("Kunden finns redan");
						
					}
				}
				
				
			
		});
		btnChangeCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnChangeCustomer.setBounds(201, 166, 117, 29);
		frame.getContentPane().add(btnChangeCustomer);

		JLabel lblProduktregister = new JLabel("Produktregister");
		lblProduktregister.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblProduktregister.setBounds(396, 10, 112, 16);
		frame.getContentPane().add(lblProduktregister);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(390, 27, 293, 12);
		frame.getContentPane().add(separator_4);

		JLabel lblName = new JLabel("Produktnamn");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblName.setBounds(396, 40, 112, 16);
		frame.getContentPane().add(lblName);

		JLabel lblKategory = new JLabel("Kategori");
		lblKategory.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblKategory.setBounds(564, 39, 72, 16);
		frame.getContentPane().add(lblKategory);

		textField_productName = new JTextField();
		textField_productName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_productName.setBounds(390, 54, 130, 26);
		frame.getContentPane().add(textField_productName);
		textField_productName.setColumns(10);

		textField_kategory = new JTextField();
		textField_kategory.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_kategory.setBounds(558, 54, 130, 26);
		frame.getContentPane().add(textField_kategory);
		textField_kategory.setColumns(10);

		JLabel lblPrice = new JLabel("Pris");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPrice.setBounds(396, 80, 61, 16);
		frame.getContentPane().add(lblPrice);

		textField_price = new JTextField();
		textField_price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_price.setBounds(390, 93, 130, 26);
		frame.getContentPane().add(textField_price);
		textField_price.setColumns(10);

		JButton btnSearchProduct = new JButton("Sök");
		btnSearchProduct.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String productName = textField_productName.getText();
				

				Product p = controller.findProduct(productName);
				if (productName.isEmpty())
					textArea_product.setText("Vänlig fyll i produktnamn.");

				else if (p != null) {
					textField_productName.setText(p.getProductName());
					textField_kategory.setText(p.getKategory());
					textField_price.setText(String.valueOf(p.getPrice()));
					
					textArea_product.setText("Produkten " + p.getProductName().toUpperCase() + " hittad.");
				} else {
					textField_price.setText("---");
					textField_kategory.setText("---");
					textArea_product.setText("Produkten med produktnamnet " +  productName  + " hittas ej");
				}
			}
				
			
		});
		btnSearchProduct.setBounds(392, 131, 117, 29);
		frame.getContentPane().add(btnSearchProduct);

		JButton btnCreateProduct = new JButton("Skapa");
		btnCreateProduct.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String productName = textField_productName.getText();
				String price1 = textField_price.getText();
				double price = Double.parseDouble(price1);
				String kategory = textField_kategory.getText();
				Product p = controller.findProduct(productName);

				if (productName.isEmpty() || kategory.isEmpty() || price == 0) {
					textArea_product.setText("Du måste fylla i alla fält.");
				} else if (p != null) {
					textArea_product.setText("Produkten finns redan");
					textField_kategory.setText("---");
					textField_price.setText("---");

				} else {
					p = controller.addProduct(productName, price, kategory);
					textArea_product.setText("Produkten " + p.getProductName().toUpperCase() + " tillagd");
				}

			}

		});
		btnCreateProduct.setBounds(566, 131, 117, 29);
		frame.getContentPane().add(btnCreateProduct);

		JButton btnRemoveProduct = new JButton("Ta bort");
		btnRemoveProduct.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productName = textField_productName.getText();

				Product p = controller.removeProduct(productName);

				if (productName.isEmpty()) {
					textArea_product.setText("Var vänlig fyll i produktnamnet.");
				} else if (p != null) {
					textField_kategory.setText(p.getKategory());
					textField_price.setText(String.valueOf(p.getPrice()));

					textArea_product.setText("Produkten " + p.getProductName().toUpperCase() + " borttagen");
				} else {
					textArea_product.setText("Produkten finns inte");
				}
			}
		});
		btnRemoveProduct.setBounds(392, 166, 117, 29);
		frame.getContentPane().add(btnRemoveProduct);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(396, 218, 293, 12);
		frame.getContentPane().add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(396, 292, 292, 12);
		frame.getContentPane().add(separator_6);

		JLabel lblAddAndRemove = new JLabel("Lägg till/ta bort order");
		lblAddAndRemove.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddAndRemove.setBounds(115, 316, 154, 16);
		frame.getContentPane().add(lblAddAndRemove);

		textField_customerNbr2 = new JTextField();
		textField_customerNbr2.setFont(new Font("Wingdings", Font.PLAIN, 12));
		textField_customerNbr2.setBounds(105, 335, 130, 26);
		frame.getContentPane().add(textField_customerNbr2);
		textField_customerNbr2.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Wingdings 2", Font.PLAIN, 12));
		textField_7.setBounds(105, 363, 130, 26);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

		JLabel lblCustomerNumber_2 = new JLabel("Kundnummer:");
		lblCustomerNumber_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCustomerNumber_2.setBounds(19, 340, 177, 16);
		frame.getContentPane().add(lblCustomerNumber_2);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 368, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblAddAndRemoveEx = new JLabel("Lägg till/ta bort exemplar");
		lblAddAndRemoveEx.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddAndRemoveEx.setBounds(484, 316, 204, 16);
		frame.getContentPane().add(lblAddAndRemoveEx);

		textField_productName2 = new JTextField();
		textField_productName2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_productName2.setBounds(483, 335, 130, 26);
		frame.getContentPane().add(textField_productName2);
		textField_productName2.setColumns(10);

		textField_serialNumber = new JTextField();
		textField_serialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_serialNumber.setBounds(483, 363, 130, 26);
		frame.getContentPane().add(textField_serialNumber);
		textField_serialNumber.setColumns(10);

		JLabel lblProductNumber = new JLabel("Produktnummer:");
		lblProductNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblProductNumber.setBounds(383, 341, 105, 16);
		frame.getContentPane().add(lblProductNumber);

		JLabel lblSerialNumber = new JLabel("Serienummer:");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSerialNumber.setBounds(383, 369, 105, 16);
		frame.getContentPane().add(lblSerialNumber);

		JButton btnAddOrder = new JButton("Lägg till");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnAddOrder.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAddOrder.setBounds(50, 401, 117, 29);
		frame.getContentPane().add(btnAddOrder);

		JButton btnRemoveOrder = new JButton("Ta bort");
		btnRemoveOrder.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRemoveOrder.setBounds(191, 401, 117, 29);
		frame.getContentPane().add(btnRemoveOrder);

		JButton btnAddEx = new JButton("Lägg till");
		btnAddEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnAddEx.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAddEx.setBounds(413, 401, 117, 29);
		frame.getContentPane().add(btnAddEx);

		JButton btnRemoveEx = new JButton("Ta bort");
		btnRemoveEx.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRemoveEx.setBounds(560, 401, 117, 29);
		frame.getContentPane().add(btnRemoveEx);

		JButton btnChangeProduct = new JButton("Ändra produkt");
		btnChangeProduct.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnChangeProduct.setBounds(566, 166, 117, 29);
		frame.getContentPane().add(btnChangeProduct);

		JLabel lblLggTilltaBort = new JLabel("Lägg till/ta bort orderrad för order");
		lblLggTilltaBort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLggTilltaBort.setBounds(84, 442, 258, 16);
		frame.getContentPane().add(lblLggTilltaBort);

		JLabel lblLggTilltaBort_1 = new JLabel("Lägg till/ta bort produkt för orderrad");
		lblLggTilltaBort_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLggTilltaBort_1.setBounds(461, 442, 248, 16);
		frame.getContentPane().add(lblLggTilltaBort_1);

		textField_10 = new JTextField();
		textField_10.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_10.setBounds(105, 489, 130, 26);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_11.setBounds(105, 462, 130, 26);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_12.setBounds(483, 462, 130, 26);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_13.setBounds(483, 489, 130, 26);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);

		JLabel lblOrderNumber = new JLabel("Ordernummer:");
		lblOrderNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblOrderNumber.setBounds(19, 467, 112, 16);
		frame.getContentPane().add(lblOrderNumber);

		JLabel lblRowNumber = new JLabel("Radnummer: ");
		lblRowNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRowNumber.setBounds(19, 494, 103, 16);
		frame.getContentPane().add(lblRowNumber);

		JLabel lblRowNumber_2 = new JLabel("Radnummer:");
		lblRowNumber_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRowNumber_2.setBounds(383, 468, 127, 16);
		frame.getContentPane().add(lblRowNumber_2);

		JLabel lblProductNumber_2 = new JLabel("Produktnummer:");
		lblProductNumber_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblProductNumber_2.setBounds(383, 494, 105, 16);
		frame.getContentPane().add(lblProductNumber_2);

		JLabel lblSummeringAv = new JLabel("Totalbelopp för en order");
		lblSummeringAv.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSummeringAv.setBounds(279, 551, 177, 16);
		frame.getContentPane().add(lblSummeringAv);

		JLabel lblOrdernummer = new JLabel("Ordernummer:");
		lblOrdernummer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblOrdernummer.setBounds(195, 565, 112, 16);
		frame.getContentPane().add(lblOrdernummer);

		JTextPane textPane_total = new JTextPane();
		textPane_total.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textPane_total.setBounds(201, 593, 287, 35);
		frame.getContentPane().add(textPane_total);

		textField_total = new JTextField();
		textField_total.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_total.setBounds(279, 561, 130, 26);
		frame.getContentPane().add(textField_total);
		textField_total.setColumns(10);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(28, 527, 655, 12);
		frame.getContentPane().add(separator_3);
		
		JButton btnSearchTotal = new JButton("Sök");
		btnSearchTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnSearchTotal.setBounds(421, 559, 117, 29);
		frame.getContentPane().add(btnSearchTotal);
		
	
		
		

	}
}

