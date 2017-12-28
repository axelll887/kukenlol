package Githubtest;

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

public class IsProjekt {

	private JFrame frame;
	private JTextField textField_surAndLast;
	private JTextField textField_address;
	private JTextField textField_customerNbr;
	private JTextField textField_productName;
	private JTextField textField_kategory;
	private JTextField textField_productPrice;
	private JTextField textField_customerNumberOrder;
	private JTextField textField_orderID;
	private JTextField textField_produktNameCopy;
	private JTextField textField_serialNumber;
	private JTextField textField_orderLineNbr;
	private JTextField textField_orderIdLine;
	private JTextField textField_orderLineNbrAdd;
	private JTextField textField_13;
	private JTextField textField_orderNbrTotal;
	private JTextField textField_deliveryDate;
	private JTable table;
	private JTextField textField_quantity;

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
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.setBounds(100, 100, 1046, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblKundregister = new JLabel("Kundregister");
		lblKundregister.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblKundregister.setBounds(28, 6, 112, 24);
		frame.getContentPane().add(lblKundregister);

		JTextArea textArea_customer = new JTextArea();
		textArea_customer.setBounds(28, 214, 293, 66);
		frame.getContentPane().add(textArea_customer);

		JTextArea textArea_product = new JTextArea();
		textArea_product.setBounds(396, 228, 313, 66);
		frame.getContentPane().add(textArea_product);

		JSeparator separator = new JSeparator();
		separator.setBounds(28, 27, 293, 16);
		frame.getContentPane().add(separator);

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

		JButton btnCreate = new JButton("Skapa");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_surAndLast.getText();
				String customerNumber = textField_customerNbr.getText();
				String address = textField_address.getText();
				Customer aCustomer = controller.findCustomer(customerNumber);

				if (textField_surAndLast.getText().isEmpty() || textField_customerNbr.getText().isEmpty()
						|| textField_address.getText().isEmpty()) {
					textArea_customer.setText("Du måste fylla i alla fält.");
				}

				else if (aCustomer != null)
					textArea_customer.setText("Personnummret finns redan");

				else {
					aCustomer = controller.addCustomer(name, customerNumber, address);
					textArea_customer.setText("Person " + aCustomer.getName().toUpperCase() + " tillagd");
				}

			}
		});
		btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCreate.setBounds(28, 166, 117, 29);
		frame.getContentPane().add(btnCreate);

		JButton btnRemoveCustomer = new JButton("Ta bort");
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerNumber = textField_customerNbr.getText();

				Customer aPerson = controller.removeCustomer(customerNumber);
				if (aPerson != null) {

					textField_surAndLast.setText(aPerson.getName());
					textField_address.setText(aPerson.getAddress());

					textArea_customer.setText("Kund " + aPerson.getName().toUpperCase() + " borttagen.");
				} else {
					textArea_customer.setText("Kunden finns inte.");

				}

			}
		});

		btnRemoveCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnRemoveCustomer.setBounds(201, 131, 117, 29);
		frame.getContentPane().add(btnRemoveCustomer);

		JButton btnSearchCustomer = new JButton("Sök kund");
		btnSearchCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerNumber = textField_customerNbr.getText();

				Customer aPerson = controller.findCustomer(customerNumber);
				if (aPerson != null) {
					textField_surAndLast.setText(aPerson.getName());
					textField_customerNbr.setText(aPerson.getCustomerNumber());
					textField_address.setText(aPerson.getAddress());
					textArea_customer.setText("Person " + aPerson.getName().toUpperCase() + " hittad.");
				} else {
					textArea_customer.setText("Personen inte hittad.");
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

		JCheckBox chckbxVisaOrderTillhrande = new JCheckBox(
				"Visa ordrar tillhörande till kund (Denna gör ingenting jsut nu)");
		chckbxVisaOrderTillhrande.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxVisaOrderTillhrande.setBounds(33, 195, 324, 23);
		frame.getContentPane().add(chckbxVisaOrderTillhrande);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 218, 293, 16);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(28, 282, 293, 12);
		frame.getContentPane().add(separator_2);

		JButton btnChangeCustomer = new JButton("Ändra kund");
		btnChangeCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerNumber = textField_customerNbr.getText();
				String name = textField_surAndLast.getText();
				String address = textField_address.getText();

				Customer aPerson = controller.findCustomer(customerNumber);

				if (textField_surAndLast.getText().isEmpty() || textField_address.getText().isEmpty()) {
					textArea_customer.setText("Du måste fylla i ett namn och adress");

				} else if (aPerson != null) {
					aPerson.setAddress(address);
					aPerson.setName(name);
					textArea_customer.setText("Kund med kundnr: " + aPerson.getCustomerNumber() + " är ändrad");
				} else {
					textArea_customer.setText("Det finns ingen kund med det kundnumret");

				}
			}
		});
		btnChangeCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnChangeCustomer.setBounds(201, 166, 117, 29);
		frame.getContentPane().add(btnChangeCustomer);

		JLabel lblProduktregister = new JLabel("Produktregister");
		lblProduktregister.setFont(new Font("Times New Roman", Font.PLAIN, 12));
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

		textField_productPrice = new JTextField();
		textField_productPrice.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_productPrice.setBounds(390, 93, 130, 26);
		frame.getContentPane().add(textField_productPrice);
		textField_productPrice.setColumns(10);

		JButton btnCreateProduct = new JButton("Skapa");
		btnCreateProduct.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_productName.getText();
				String pris = textField_productPrice.getText();
				double price = Double.parseDouble(pris);
				String kategory = textField_kategory.getText();
				Product p = controller.findProduct(name);

				/*
				 * DEN VILL LÄSA IN PRIS SOM STRING (DET ÄR EN DOUBLE), SÅ JAG HAR CASTAT OM
				 * DEN.
				 */

				if (textField_productName.getText().isEmpty() || textField_productPrice.getText().isEmpty()
						|| textField_kategory.getText().isEmpty()) {
					textArea_product.setText("Du måste fylla i alla fält.");
				}

				else if (p != null)
					textArea_product.setText("Produkten finns redan");

				else {
					p = controller.addProduct(name, price, kategory);
					textArea_product.setText("Produkt " + p.getName().toUpperCase() + " tillagd");
				}

			}
		});
		btnCreateProduct.setBounds(391, 166, 117, 29);
		frame.getContentPane().add(btnCreateProduct);

		JButton btnRemoveProduct = new JButton("Ta bort");
		btnRemoveProduct.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_productName.getText();

				Product p = controller.removeProduct(name);
				if (p != null) {

					textField_productName.setText(p.getName());
					textField_productPrice.setText("Du måste fixa denna");
					/*
					 * DENNA ÄR DET PROBLEM MED.... NÄR DU SKRIVER IN TILL TEXTFIELD SÅ ÄR DET SOM
					 * EN STRING. ALLTSÅ PRIS SOM ÄR EN DOUBLE SKRIVS IN SOM STRING, JAG LYCKADES
					 * LÖSA DETTA GENOM ATT CASTA OM STRINGEN TILL DOUBLE SE " double price=
					 * Double.parseDouble(pris); VID SKAPA KNAPPEN. PROBLEMET NU ÄR VI VILL ATT DEN
					 * SKA VISA PRISET NÄR MAN SÖKER/TAR BORT. DÅ VILL DEN VISA EN STRING I
					 * TEXTLABELN. VETTEFAN HUR MAN CASTAR OM DEN IGEN... ALLT FUNKAR BARA ATT SOM
					 * PRIS STÅR DET"DU MÅSTE FIXA DETTA"
					 */

					textArea_product.setText("Produkt " + p.getName().toUpperCase() + " borttagen.");
				} else {
					textArea_product.setText("Produkten finns inte.");

				}

			}
		});
		btnRemoveProduct.setBounds(566, 131, 117, 29);
		frame.getContentPane().add(btnRemoveProduct);

		JButton btnSearchProduct = new JButton("Sök");
		btnSearchProduct.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_productName.getText();

				Product p = controller.findProduct(name);
				if (p != null) {
					textField_productName.setText(p.getName());
					textField_productPrice.setText("du måste fixa denna");

					// *FÖRKLARING TILL DU MÅSTE FIXA DENNA FINNS LTIE LÄNGRE NER

					textField_kategory.setText(p.getKategory());
					textArea_product.setText("Produkten " + p.getName().toUpperCase() + " hittad.");
				} else {
					textArea_product.setText("Produkten inte hittad.");
				}
			}
		});
		btnSearchProduct.setBounds(392, 131, 117, 29);
		frame.getContentPane().add(btnSearchProduct);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(396, 218, 293, 12);
		frame.getContentPane().add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(396, 292, 292, 12);
		frame.getContentPane().add(separator_6);

		JLabel lblAddAndRemove = new JLabel("Lägg till/ta bort order");
		lblAddAndRemove.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddAndRemove.setBounds(105, 292, 154, 16);
		frame.getContentPane().add(lblAddAndRemove);

		textField_customerNumberOrder = new JTextField();
		textField_customerNumberOrder.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_customerNumberOrder.setBounds(105, 335, 130, 26);
		frame.getContentPane().add(textField_customerNumberOrder);
		textField_customerNumberOrder.setColumns(10);

		textField_orderID = new JTextField();
		textField_orderID.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_orderID.setBounds(105, 363, 130, 26);
		frame.getContentPane().add(textField_orderID);
		textField_orderID.setColumns(10);

		JLabel lblCustomerNumber_2 = new JLabel("Kundnummer:");
		lblCustomerNumber_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCustomerNumber_2.setBounds(19, 340, 177, 16);
		frame.getContentPane().add(lblCustomerNumber_2);

		JLabel lblNewLabel_orderID = new JLabel("orderID:");
		lblNewLabel_orderID.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_orderID.setBounds(28, 368, 61, 16);
		frame.getContentPane().add(lblNewLabel_orderID);

		JLabel lblAddAndRemoveEx = new JLabel("Lägg till/ta bort exemplar");
		lblAddAndRemoveEx.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddAndRemoveEx.setBounds(473, 316, 204, 16);
		frame.getContentPane().add(lblAddAndRemoveEx);

		textField_produktNameCopy = new JTextField();
		textField_produktNameCopy.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_produktNameCopy.setBounds(483, 335, 130, 26);
		frame.getContentPane().add(textField_produktNameCopy);
		textField_produktNameCopy.setColumns(10);

		textField_serialNumber = new JTextField();
		textField_serialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_serialNumber.setBounds(483, 363, 130, 26);
		frame.getContentPane().add(textField_serialNumber);
		textField_serialNumber.setColumns(10);

		JLabel lblproductName = new JLabel("Produktnamn");
		lblproductName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblproductName.setBounds(383, 341, 105, 16);
		frame.getContentPane().add(lblproductName);

		JLabel lblSerialNumber = new JLabel("Serienummer:");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSerialNumber.setBounds(383, 369, 105, 16);
		frame.getContentPane().add(lblSerialNumber);

		JButton btnAddOrder = new JButton("Lägg till");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String orderID = textField_orderID.getText();
				String deliveryDate = textField_deliveryDate.getText();
				String customerNumber = textField_customerNumberOrder.getText();
				Customer p = controller.findCustomer(customerNumber);

				if (textField_deliveryDate.getText().isEmpty() || textField_customerNumberOrder.getText().isEmpty()) {
					textArea_customer.setText("Du måste fylla i alla fält förutom orderID");
				}

				else if (p != null) {
					controller.generateOrderId++;
					String ordrID = String.valueOf(controller.generateOrderId);

					controller.addOrder(ordrID, deliveryDate, customerNumber);
					textArea_customer.setText("Order: " + ordrID + " tillhör kund: " + p.getName().toUpperCase());
				} else {
					textArea_customer.setText("Det finns ingen kund med det kundnumret");

				}
			}
		});
		btnAddOrder.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAddOrder.setBounds(50, 401, 117, 29);
		frame.getContentPane().add(btnAddOrder);

		JButton btnRemoveOrder = new JButton("Ta bort");
		btnRemoveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// String customerNumber = textField_customerNumberOrder.getText();
				String orderID = textField_orderID.getText();
				// Customer p = controller.findCustomer(customerNumber);
				// Order o = p.findOrder(orderID);

				if (textField_orderID.getText().isEmpty()) {
					textArea_customer.setText("Du måste skriva in ett orderID");
				}

				for (Customer ca : controller.getCustomers().values()) {
					for (Order or : ca.getOrders().values()) {
						if (or.getOrderID().equals(orderID)) {
							ca.removeOrder(orderID);
							textArea_customer.setText("Order: " + orderID + " tillhörande: "
									+ ca.getName().toUpperCase() + " är borttagen");
						} else {
							textArea_customer.setText("Det finns ingen order med detta ID");
						}
					}
				}
			}
		});

		// if (o != null) {
		// o.getCustomer();
		// textArea_customer.setText("Exemplar " + o.getOrderID() + " tillhörande
		// kund:"+ o.getCustomerName().toUpperCase() + " är borttagen");
		// o.getCustomer().removeOrder(orderID);
		// } else {
		// textArea_customer.setText("Det finns inget exemplar med detta nummret");
		// }
		//
		//

		btnRemoveOrder.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnRemoveOrder.setBounds(191, 401, 117, 29);
		frame.getContentPane().add(btnRemoveOrder);

		JButton btnAddEx = new JButton("Lägg till");
		btnAddEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = textField_produktNameCopy.getText();
				// String serialNumber = textField_serialNumber.getText();
				Product p = controller.findProduct(name);

				if (textField_produktNameCopy.getText().isEmpty() || textField_produktNameCopy.getText().isEmpty()) {
					textArea_product.setText("Du måste fylla i alla fält.");
				} else if (p == null) {
					textArea_product.setText("Det finns ingen sådan produkt");

				}
				// else {
				// Copy c = p.findCopy(serialNumber);

				// if (c != null) {
				// textArea_product.setText("Serienumret finns redan");
				// }
				else {
					controller.generateSerialNbr++;
					String CNBR = String.valueOf(controller.generateSerialNbr);

					Copy copyNew = controller.createCopy(CNBR);

					p.addCopy(copyNew);
					textArea_product.setText("Exemplar " + copyNew.getserialNumber().toUpperCase() + " tillhörande: "
							+ p.getName().toUpperCase() + " tillagd");
				}
			}
			// }

			/*
			 * JAG VET INTE OM DET FÅR SE UT SÅHÄR I APPLIKATIONSKLASSEN, EXEMPEL
			 * "	Copy c = p.findCopy(serialNumber); " EGENTLIGEN BORDE DET VÄL STÅ NÅGOT
			 * LIKNANDE COPY C = CONTROLLER.FINDCOPY(SERIALNUMBER)????
			 * 
			 * 
			 * 
			 * 
			 */

		});
		btnAddEx.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAddEx.setBounds(413, 401, 117, 29);
		frame.getContentPane().add(btnAddEx);

		JButton btnRemoveEx = new JButton("Ta bort");
		btnRemoveEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// String name = textField_produktNameCopy.getText();
				String serialNumber = textField_serialNumber.getText();
				// Product p = controller.findProduct(name);
				// Copy c = p.findCopy(serialNumber);
				boolean ok = false;
				Product foundProduct = null;
				if (textField_serialNumber.getText().isEmpty()) {
					textArea_product.setText("Du måste fylla i ett serienummer");
				}
				for (Product pa : controller.getProducts().values()) {
					for (Copy cop : pa.getCopies().values()) {
						if (cop.getserialNumber().equals(serialNumber)) {
							foundProduct = pa;
						}
					}

					if (foundProduct != null) {
						foundProduct.removeCopy(serialNumber);
						textArea_product.setText("Exemplar: " + serialNumber + " tillhörande:"
								+ foundProduct.getName().toUpperCase() + " är borttagen");
					} else {
						textArea_product.setText("Det finns inget exemplar med detta numret");
					}
				}

			}
		});

		// if (c != null) {
		//
		// textArea_product.setText("Exemplar " + c.getserialNumber().toUpperCase() + "
		// borttagen");
		// p.removeCopy(serialNumber);
		// }

		// {
		//
		// // String customerNumber = textField_customerNumberOrder.getText();
		// String orderID = textField_orderID.getText();
		// // Customer p = controller.findCustomer(customerNumber);
		// // Order o = p.findOrder(orderID);
		//
		// if ( textField_orderID.getText().isEmpty()) {
		// textArea_customer.setText("Du måste skriva in ett orderID");
		// }
		//
		// for ( Customer ca : controller.getCustomers().values()) {
		// for ( Order or : ca.getOrders().values()) {
		// if ( or.getOrderID().equals(orderID)) {
		// ca.removeOrder(orderID);
		// textArea_customer.setText("Order :" + orderID + " tillhörande:" +
		// ca.getName() + "är borttagen");
		// }
		// else {
		// textArea_customer.setText("Det finns inget exemplar med detta numret");
		// }
		// }
		// }
		// }
		// });

		btnRemoveEx.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnRemoveEx.setBounds(560, 401, 117, 29);
		frame.getContentPane().add(btnRemoveEx);

		JButton btnChangeProduct = new JButton("Ändra produkt");
		btnChangeProduct.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnChangeProduct.setBounds(566, 166, 117, 29);
		frame.getContentPane().add(btnChangeProduct);

		JLabel lblLggTilltaBort = new JLabel("Lägg till/ta bort orderrad för order");
		lblLggTilltaBort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLggTilltaBort.setBounds(63, 423, 258, 16);
		frame.getContentPane().add(lblLggTilltaBort);

		JLabel lblLggTilltaBort_1 = new JLabel("Lägg till/ta bort produkt för orderrad");
		lblLggTilltaBort_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLggTilltaBort_1.setBounds(434, 423, 248, 16);
		frame.getContentPane().add(lblLggTilltaBort_1);

		textField_orderLineNbr = new JTextField();
		textField_orderLineNbr.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_orderLineNbr.setBounds(105, 462, 130, 26);
		frame.getContentPane().add(textField_orderLineNbr);
		textField_orderLineNbr.setColumns(10);

		textField_orderIdLine = new JTextField();
		textField_orderIdLine.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_orderIdLine.setBounds(105, 442, 130, 26);
		frame.getContentPane().add(textField_orderIdLine);
		textField_orderIdLine.setColumns(10);

		textField_orderLineNbrAdd = new JTextField();
		textField_orderLineNbrAdd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_orderLineNbrAdd.setBounds(483, 442, 130, 26);
		frame.getContentPane().add(textField_orderLineNbrAdd);
		textField_orderLineNbrAdd.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_13.setBounds(483, 462, 130, 26);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);

		JLabel lblOrderNumber = new JLabel("orderID:");
		lblOrderNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblOrderNumber.setBounds(28, 442, 112, 16);
		frame.getContentPane().add(lblOrderNumber);

		JLabel lblRowNumber = new JLabel("Radnummer: ");
		lblRowNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRowNumber.setBounds(28, 466, 103, 16);
		frame.getContentPane().add(lblRowNumber);

		JLabel lblRowNumber_2 = new JLabel("Radnummer:");
		lblRowNumber_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRowNumber_2.setBounds(381, 442, 127, 16);
		frame.getContentPane().add(lblRowNumber_2);

		JLabel lblProductName = new JLabel("Produktnamn:");
		lblProductName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblProductName.setBounds(381, 466, 105, 16);
		frame.getContentPane().add(lblProductName);

		JLabel lblSummeringAv = new JLabel("Totalbelopp för en order");
		lblSummeringAv.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSummeringAv.setBounds(269, 558, 177, 16);
		frame.getContentPane().add(lblSummeringAv);

		JLabel lblOrdernummer = new JLabel("Ordernummer:");
		lblOrdernummer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblOrdernummer.setBounds(188, 579, 112, 16);
		frame.getContentPane().add(lblOrdernummer);

		textField_orderNbrTotal = new JTextField();
		textField_orderNbrTotal.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_orderNbrTotal.setBounds(279, 573, 130, 26);
		frame.getContentPane().add(textField_orderNbrTotal);
		textField_orderNbrTotal.setColumns(10);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(28, 549, 655, 12);
		frame.getContentPane().add(separator_3);

		textField_deliveryDate = new JTextField();
		textField_deliveryDate.setBounds(105, 306, 130, 26);
		frame.getContentPane().add(textField_deliveryDate);
		textField_deliveryDate.setColumns(10);

		JLabel lblLeveransdatum = new JLabel("Leveransdatum:");
		lblLeveransdatum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLeveransdatum.setBounds(11, 312, 78, 16);
		frame.getContentPane().add(lblLeveransdatum);

		table = new JTable();
		table.setBounds(745, 131, 287, 300);
		frame.getContentPane().add(table);

		JTextArea textArea_showOrderTotal = new JTextArea();
		textArea_showOrderTotal.setBounds(164, 599, 408, 45);
		frame.getContentPane().add(textArea_showOrderTotal);

		JButton btnAddOrderLine = new JButton("Lägg till");
		btnAddOrderLine.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAddOrderLine.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String orderID = textField_orderIdLine.getText();

				if (textField_orderIdLine.getText().isEmpty()) {
					textArea_customer.setText("Du måste fylla i ett orderID");

				}

				Order ord = controller.findOrder(orderID);
				if (ord != null) {

					controller.generateOrderLineNbr++;
					String ORDERLINENBR = String.valueOf(controller.generateOrderLineNbr);

					OrderLine ol = controller.createOrderLine(ORDERLINENBR);

					ord.addOrderLine(ol);
					textArea_customer.setText("Rad: " + ol.getNumber() + " tillhörande orderID: " + ord.getOrderID()
							+ " hos: " + ord.getCustomerName().toUpperCase() + " är tillagd");

				} else {
					textArea_customer.setText("Det finns ingen sådan order");
				}
			}
		});
		// {
		//
		// String name = textField_produktNameCopy.getText();
		// Product p = controller.findProduct(name);
		//
		//
		// if (textField_produktNameCopy.getText().isEmpty() ||
		// textField_produktNameCopy.getText().isEmpty()) {
		// textArea_product.setText("Du måste fylla i alla fält.");
		// } else if (p == null) {
		// textArea_product.setText("Det finns ingen sådan produkt");
		//
		// }
		//
		// else {
		// controller.generateSerialNbr++;
		// String CNBR = String.valueOf(controller.generateSerialNbr);
		//
		// Copy copyNew = controller.createCopy(CNBR);
		//
		// p.addCopy(copyNew);
		// textArea_product.setText("Exemplar " +
		// copyNew.getserialNumber().toUpperCase() + " tillhörande: " +
		// p.getName().toUpperCase() + " tillagd");
		// }
		// }
		//
		//
		// });
		btnAddOrderLine.setBounds(50, 527, 117, 29);
		frame.getContentPane().add(btnAddOrderLine);

		JButton btnTaBort = new JButton("Ta bort");
		btnTaBort.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String number = textField_orderLineNbr.getText();

				if (textField_orderLineNbr.getText().isEmpty()) {
					textArea_customer.setText("Du måste skriva in ett orderID");
				}

				for (Customer ca : controller.getCustomers().values()) {
					for (Order or : ca.getOrders().values()) {
						for (OrderLine ol : or.getOrderLines().values()) {
							if (ol.getNumber().equals(number)) {
								or.removeOrderLines(number);
								textArea_customer.setText("Orderrad: " + ol.getNumber() + " tillhörande: "
										+ ca.getName().toUpperCase() + " är borttagen");
							} else {
								textArea_customer.setText("Det finns ingen orderrad med detta nummer");
							}
						}
					}
				}
			}
		});
		btnTaBort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnTaBort.setBounds(201, 527, 117, 29);
		frame.getContentPane().add(btnTaBort);

		JLabel lblNewLabel = new JLabel("Kvantitet:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(383, 489, 61, 16);
		frame.getContentPane().add(lblNewLabel);

		textField_quantity = new JTextField();
		textField_quantity.setBounds(483, 480, 130, 26);
		frame.getContentPane().add(textField_quantity);
		textField_quantity.setColumns(10);

		JButton btnLggTill = new JButton("Lägg till");
		btnLggTill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String number = textField_orderLineNbrAdd.getText();
				String name = textField_13.getText();
				String quantityString = textField_quantity.getText();

				if (textField_orderLineNbrAdd.getText().isEmpty() || textField_13.getText().isEmpty()
						|| textField_quantity.getText().isEmpty()) {

					textArea_product.setText("Du måste fylla i alla fält");
				}
              
				else {
					int quantity = Integer.valueOf(quantityString);
					String ok = controller.addCopyToOrderLine(quantity, number, name);
					if (ok==null) {
						textArea_product.setText(quantity + " stycken " + name + " är tillagda på orderrad: " + number);
					}
					else {
						textArea_product.setText(ok);
						
					
					

					}
				}
			}
		});
		btnLggTill.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLggTill.setBounds(403, 517, 117, 29);
		frame.getContentPane().add(btnLggTill);

		JButton btnTaBort_1 = new JButton("Ta bort");
		btnTaBort_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTaBort_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnTaBort_1.setBounds(535, 518, 117, 29);
		frame.getContentPane().add(btnTaBort_1);

		JButton btnVisa = new JButton("Visa");
		btnVisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderID = textField_orderNbrTotal.getText();
				int i = controller.getTotalCostForOrder(orderID);
                if (orderID!=null) {
				String str = String.valueOf(i + " KR");
                
				textArea_showOrderTotal.setText(str);}
			else { textArea_showOrderTotal.setText("Det finns ingen order med detta ID");
			
			}
			}
		});
		btnVisa.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnVisa.setBounds(413, 573, 117, 29);
		frame.getContentPane().add(btnVisa);

	}
}
