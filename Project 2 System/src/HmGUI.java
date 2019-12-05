import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.MaskFormatter;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.sql.*;
import javax.print.*;


public class HmGUI extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;

	JFrame AddressBook;
	JComponent InputItems;
	JTextField FirstName;
	JTextField LastName;
	JTextField Address1;
	JTextField Address2;
	JTextField City;
	JTextField State;
	JFormattedTextField ZipCode;
	JFormattedTextField Phone;
	JTextField Email;
	
	String Statement = null;
	
	public static void main(String args[])
	{
		new HmGUI();	
	}
	
	public HmGUI()
	{
		//Main Frame
		
		AddressBook = new JFrame("Address Book");
		AddressBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		AddressBook.setSize(1300, 750);
		AddressBook.setLocationRelativeTo(null);
		AddressBook.setVisible(true);
		
		
		//Buttons & Toolbar
		
		/*JButton Insertion = new JButton("Insertion");
		Insertion.addActionListener(this);
		Insertion.setActionCommand("Insertion");
		*/
		
		JButton CheckIn = new JButton("CheckIn");
		CheckIn.addActionListener(this);
		CheckIn.setActionCommand("CheckIn");
		
		JButton Search = new JButton("Search");
		Search.addActionListener(this);
		Search.setActionCommand("Search");
		
		JButton CheckOut = new JButton("CheckOut");
		CheckOut.addActionListener(this);
		CheckOut.setActionCommand("CheckOut");
		
		JButton BPrint = new JButton("Bill Print");
		BPrint.addActionListener(this);
		BPrint.setActionCommand("Bill Print");
		
		JToolBar toolbar = new JToolBar();
		
		//toolbar.add(Insertion);
		toolbar.add(CheckIn);
		toolbar.add(CheckOut);
		toolbar.add(Search);
		toolbar.add(BPrint);
		
		toolbar.addSeparator();
		toolbar.setFloatable(false);
		AddressBook.add(toolbar, BorderLayout.PAGE_START);
		
		
		//Textboxes (In UpperCase)
		
		MaskFormatter ZipCodeFormat = null;
		try {
			ZipCodeFormat = new MaskFormatter("#####");
		} catch (ParseException ee) {
			ee.printStackTrace();
		}
		MaskFormatter PhoneFormat = null;
		try {
			PhoneFormat = new MaskFormatter("#########");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		FirstName = new JTextField(30);
		LastName = new JTextField();
		Address1 = new JTextField();
		Address2 = new JTextField();
		City = new JTextField();
		State = new JTextField();
		ZipCode = new JFormattedTextField(ZipCodeFormat);
		Phone = new JFormattedTextField(PhoneFormat);
		Email = new JTextField();
		
		//Labels (In LowerCase)
		
		JLabel firstname = new JLabel("  First Name: ");
		JLabel lastname = new JLabel("  Last Name: ");
		JLabel address1 = new JLabel("  Address 1: ");
		JLabel address2 = new JLabel("  Address 2: ");
		JLabel city = new JLabel("  City: ");
		JLabel state = new JLabel("  State: ");
		JLabel zipcode = new JLabel("  ZipCode: ");
		JLabel phone = new JLabel("  Phone: ");
		JLabel email = new JLabel("  Email: ");
		
		//Panel (Adding Labels and Textfields to InputItems Panel)
		
		InputItems = new JPanel();
		GroupLayout layout = new GroupLayout(InputItems);
		InputItems.setLayout(layout);
		layout.setAutoCreateGaps(true);
		
		GroupLayout.SequentialGroup Row = layout.createSequentialGroup();
		
		// Creating Groups so that they align with one another
		Row.addGroup(layout.createParallelGroup().addComponent(firstname).addComponent(lastname).
				addComponent(address1).addComponent(address2).addComponent(city).addComponent(state).
					addComponent(zipcode).addComponent(phone).addComponent(email));
		
		Row.addGroup(layout.createParallelGroup().addComponent(FirstName).addComponent(LastName).
				addComponent(Address1).addComponent(Address2).addComponent(City).addComponent(State).
					addComponent(ZipCode).addComponent(Phone).addComponent(Email));
		
		layout.setHorizontalGroup(Row);
		
		GroupLayout.SequentialGroup Col = layout.createSequentialGroup();
		
		Col.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(firstname).addComponent(FirstName));
		
		Col.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lastname).addComponent(LastName));
		
		Col.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(address1).addComponent(Address1));
		
		Col.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(address2).addComponent(Address2));
		
		Col.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(city).addComponent(City));
		
		Col.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(state).addComponent(State));
		
		Col.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(zipcode).addComponent(ZipCode));
		
		Col.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(phone).addComponent(Phone));
		
		Col.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(email).addComponent(Email));
		
		layout.setVerticalGroup(Col);
	}
	public void COut(String Query)
	{
		try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

	         // connect to database
	         Connection connection = DriverManager.getConnection(
	            "/////////////////////////////////////////////////////////////////////////////");
	         // create Statement to query database
	         Statement statement = connection.createStatement();

	         // query database
	         ResultSet resultSet =
	            statement.executeQuery("Select firstname, lastname from names");
	         
	         statement.close();
	         connection.close();
	         
			}
			catch
				( SQLException sqlException ) {
			         JOptionPane.showMessageDialog( null,
			            sqlException.getMessage(), "Database Error",
			            JOptionPane.ERROR_MESSAGE );
			         System.exit( 1 );
			      } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
}
