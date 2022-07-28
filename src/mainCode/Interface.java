package mainCode;
import java.awt.event.*;
import java.awt.*; 
import java.sql.*;
import java.text.ParseException;
import java.util.Properties;

import javax.swing.*;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel; 

public class Interface {

	static MySqlDAO dao = new MySqlDAO(); 
	
	public static void main(String[] args) throws SQLException {
		dao.createSchema();
		showMainMenu(); 
	}

	public static void showMainMenu() {
		
		ActionListener addRenterListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAddRenterPage();
			}
		}; 
		
		ActionListener addHostListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAddHostPage();
			}
		}; 
		
		ActionListener deleteUserListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showDeleteUserPage();
			}
		}; 
		
		ActionListener postListingListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showPostListingPage();
			}
		}; 
		
		JFrame frame = new JFrame("MyBNB");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1920,1080);
	    
	    JPanel panel = new JPanel(); 
	    frame.add(panel); 
	    
	    JButton addRenter = new JButton("Add new Renter");
	    addRenter.addActionListener(addRenterListener);
	    panel.add(addRenter); 

	    JButton addHost = new JButton("Add new Host");
	    addHost.addActionListener(addHostListener); 
	    panel.add(addHost); 
	    
	    JButton deleteUser = new JButton("Delete a User");
	    deleteUser.addActionListener(deleteUserListener); 
	    panel.add(deleteUser); 

	    JButton postListing = new JButton("Post a Listing");
	    postListing.addActionListener(postListingListener); 
	    panel.add(postListing); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showPostListingPage() {
		 
		
		JFrame frame = new JFrame("Post Listing");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter Your SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterListingType = new JLabel("Enter Your Listing's Type(House, Apartment, etc.): "); 
	    panel.add(enterListingType); 
	    TextField type = new TextField(50); 
	    panel.add(type); 
	    
	    JLabel enterCity = new JLabel("Enter the Address: "); 
	    panel.add(enterCity); 
	    TextField city = new TextField(50); 
	    panel.add(city); 
	    
	    JLabel enterCountry = new JLabel("Enter the country: "); 
	    panel.add(enterCountry); 
	    TextField country = new TextField(50); 
	    panel.add(country); 
	    
	    JLabel enterPostalCode = new JLabel("Enter the Postal Code: "); 
	    panel.add(enterPostalCode); 
	    TextField postalCode = new TextField(50); 
	    panel.add(postalCode); 
	    
	    JLabel enterLatitude = new JLabel("Enter the Latitude: "); 
	    panel.add(enterLatitude); 
	    TextField latitude = new TextField(50); 
	    panel.add(latitude); 
	    
	    JLabel enterLongitude = new JLabel("Enter the Longitude: "); 
	    panel.add(enterLongitude); 
	    TextField longitude = new TextField(50); 
	    panel.add(longitude); 
	    
	    
	    JLabel success = new JLabel("Fill out all the info on this form to add the listing"); 
	    panel.add(success); 
	    
	    ActionListener submitAddListing = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean result = false;
				try {
					result = dao.postListing(SIN.getText(), type.getText(), city.getText(), country.getText(), postalCode.getText(), latitude.getText(), longitude.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				if(result) {
					success.setText("Successfully Deleted User"); 
				}else {
					success.setText("Operation Not Successful");  
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitAddListing);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showDeleteUserPage() {
		 
		
		JFrame frame = new JFrame("deleteUser");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    
	    JLabel success = new JLabel("Fill out all the info on this form to add the user"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean result = dao.deleteUser(SIN.getText()); 
				if(result) {
					success.setText("Successfully Deleted User"); 
				}else {
					success.setText("Operation Not Successful");  
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showAddRenterPage() {
		 
		
		JFrame frame = new JFrame("addRenter");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterName = new JLabel("Enter Username: "); 
	    panel.add(enterName); 
	    
	    TextField username = new TextField(50); 
	    panel.add(username); 
	    
	    JLabel enterOccupation = new JLabel("Enter occupation: "); 
	    panel.add(enterOccupation); 
	    TextField occupation = new TextField(50); 
	    panel.add(occupation); 
	    
	    JLabel enterPassword = new JLabel("Enter password: "); 
	    panel.add(enterPassword); 
	    TextField password = new TextField(50); 
	    panel.add(password); 
	    
	    JLabel enterBirthday = new JLabel("Enter birthday(in form \"yyyy-mm-dd\"): "); 
	    panel.add(enterBirthday); 
	    TextField birthday = new TextField(50); 
	    panel.add(birthday); 

	    JLabel enterPaymentMethodType = new JLabel("Enter Payment Method Type: "); 
	    panel.add(enterPaymentMethodType); 
	    TextField type = new TextField(6); 
	    panel.add(type); 
	    
	    JLabel enterCardNumber = new JLabel("Enter Payment card number: "); 
	    panel.add(enterCardNumber); 
	    TextField cardNumber = new TextField(6); 
	    panel.add(cardNumber); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterCity = new JLabel("Enter City: "); 
	    panel.add(enterCity); 
	    TextField city = new TextField(50); 
	    panel.add(city); 
	    
	    JLabel enterPostalCode = new JLabel("Enter Postal Code: "); 
	    panel.add(enterPostalCode); 
	    TextField postalCode = new TextField(6); 
	    panel.add(postalCode); 
	    
	    JLabel enterCountry = new JLabel("Enter Country: "); 
	    panel.add(enterCountry); 
	    TextField country = new TextField(6); 
	    panel.add(country); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to add the user"); 
	    panel.add(success); 
	    
	    ActionListener submitAddRenter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean result = dao.postUser(SIN.getText(), occupation.getText(), username.getText(), password.getText(), birthday.getText(), 
							type.getText(), cardNumber.getText(), city.getText(), country.getText(), postalCode.getText());
					if(result) {
						success.setText("Successfully Added User"); 
					}else {
						success.setText("Operation Not Successful");  
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitAddRenter);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showAddHostPage() {
		 
		
		JFrame frame = new JFrame("addHost");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterName = new JLabel("Enter Username: "); 
	    panel.add(enterName); 
	    
	    TextField username = new TextField(50); 
	    panel.add(username); 
	    
	    JLabel enterOccupation = new JLabel("Enter occupation: "); 
	    panel.add(enterOccupation); 
	    TextField occupation = new TextField(50); 
	    panel.add(occupation); 
	    
	    JLabel enterPassword = new JLabel("Enter password: "); 
	    panel.add(enterPassword); 
	    TextField password = new TextField(50); 
	    panel.add(password); 
	    
	    JLabel enterBirthday = new JLabel("Enter birthday(in form \"yyyy-mm-dd\"): "); 
	    panel.add(enterBirthday); 
	    TextField birthday = new TextField(50); 
	    panel.add(birthday); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterCity = new JLabel("Enter City: "); 
	    panel.add(enterCity); 
	    TextField city = new TextField(50); 
	    panel.add(city); 
	    
	    JLabel enterPostalCode = new JLabel("Enter Postal Code: "); 
	    panel.add(enterPostalCode); 
	    TextField postalCode = new TextField(6); 
	    panel.add(postalCode); 
	    
	    JLabel enterCountry = new JLabel("Enter Country: "); 
	    panel.add(enterCountry); 
	    TextField country = new TextField(6); 
	    panel.add(country); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to add the user"); 
	    panel.add(success); 
	    
	    ActionListener submitAddRenter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean result = dao.postUser(SIN.getText(), occupation.getText(), username.getText(), password.getText(), birthday.getText(), 
							city.getText(), country.getText(), postalCode.getText());
					if(result) {
						success.setText("Successfully Added User"); 
					}else {
						success.setText("Operation Not Successful");  
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitAddRenter);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	
}
