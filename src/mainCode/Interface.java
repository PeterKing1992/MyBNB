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
		
		ActionListener addAmenityListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAddAmenityPage();
			}
		}; 
		
		ActionListener removeListingListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showRemoveListingPage();
			}
		}; 
		
		ActionListener addListingOfferingListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAddListingOfferingPage();
			}
		}; 
		
		ActionListener bookListingListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showBookListingPage(); 
			}
		}; 
		
		ActionListener cancelBookingRenterListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showCancelBookingRenterPage(); 
			}
		};
		
		ActionListener cancelBookingHostListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showCancelBookingHostPage(); 
			}
		};
		
		ActionListener changeListingAvailabilityListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showChangeListingAvailabilityPage(); 
			}
		};
		
		ActionListener changeListingPriceListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showChangeListingPricePage(); 
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
	    
	    JButton addAmenity = new JButton("Add amenity for your listing");
	    addAmenity.addActionListener(addAmenityListener); 
	    panel.add(addAmenity); 
	    
	    JButton removeListing = new JButton("remove your listing");
	    removeListing.addActionListener(removeListingListener); 
	    panel.add(removeListing); 
	    
	    JButton addListingOffering = new JButton("Add time and date available to rent for your listing");
	    addListingOffering.addActionListener(addListingOfferingListener); 
	    panel.add(addListingOffering); 
	    
	    JButton bookListing = new JButton("Book a listing");
	    bookListing.addActionListener(bookListingListener); 
	    panel.add(bookListing); 
	    
	    JButton cancelBookingRenter = new JButton("Cancel a booking as a renter");
	    cancelBookingRenter.addActionListener(cancelBookingRenterListener); 
	    panel.add(cancelBookingRenter); 
	    
	    JButton cancelBookingHost = new JButton("Cancel a booking as a host");
	    cancelBookingHost.addActionListener(cancelBookingHostListener); 
	    panel.add(cancelBookingHost); 
	    
	    JButton changeListingAvailability = new JButton("Change Listing Availability");
	    changeListingAvailability.addActionListener(changeListingAvailabilityListener); 
	    panel.add(changeListingAvailability); 
	    
	    JButton changeListingPrice = new JButton("Change Listing Price");
	    changeListingPrice.addActionListener(changeListingPriceListener); 
	    panel.add(changeListingPrice); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
public static void showChangeListingPricePage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterLid = new JLabel("Enter Listing id of the listing you want to change: "); 
	    panel.add(enterLid); 
	    TextField lid = new TextField(50); 
	    panel.add(lid); 
	    
	    JLabel enterDate = new JLabel("Enter the date of the listing above you want to change the availability for(In format \"YYYY-MM-DD\"): "); 
	    panel.add(enterDate); 
	    TextField offeringDate = new TextField(50); 
	    panel.add(offeringDate); 
	    
	    JLabel enterPrice = new JLabel("Enter the price you want to change the listing on the said date to: "); 
	    panel.add(enterPrice); 
	    TextField price = new TextField(50); 
	    panel.add(price); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.changeListingPrice(SIN.getText(), lid.getText(), offeringDate.getText(), price.getText()); 
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == 1){
					success.setText("Unauthorized");  
				}else if(result == 2) {
					success.setText("You may not change the price since someone booked the listing on the said date, please cancel that booking first");
				}else {
					success.setText("listing offering not found on the said date");
				}
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showChangeListingAvailabilityPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterLid = new JLabel("Enter Listing id of the listing you want to change: "); 
	    panel.add(enterLid); 
	    TextField lid = new TextField(50); 
	    panel.add(lid); 
	    
	    JLabel enterDate = new JLabel("Enter the date of the listing above you want to change the availability for(In format \"YYYY-MM-DD\"): "); 
	    panel.add(enterDate); 
	    TextField offeringDate = new TextField(50); 
	    panel.add(offeringDate); 
	    
	    JLabel enterAvailability = new JLabel("Enter true if you want this listing to be available on the said date, or false if you do not want it to be available: "); 
	    panel.add(enterAvailability); 
	    TextField availability = new TextField(50); 
	    panel.add(availability); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.changeListingAvailability(SIN.getText(), lid.getText(), offeringDate.getText(), availability.getText()); 
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == 1){
					success.setText("Unauthorized");  
				}else if(result == 3) {
					success.setText("No lisitng offering found for the said listing on the said date");
				}else {
					success.setText("You may not change the availability because someone booked this listing on the said date, please cancel that booking first");
				}
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showCancelBookingHostPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterBid = new JLabel("Enter the bid of the booking you want to cancel: "); 
	    panel.add(enterBid); 
	    TextField bid = new TextField(50); 
	    panel.add(bid); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.cancelBookingHost(SIN.getText(), bid.getText());
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == 1){
					success.setText("Unauthorized");  
				}
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showCancelBookingRenterPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterBid = new JLabel("Enter the bid of the booking you want to cancel: "); 
	    panel.add(enterBid); 
	    TextField bid = new TextField(50); 
	    panel.add(bid); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.cancelBooking(SIN.getText(), bid.getText());
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == 1){
					success.setText("Unauthorized");  
				}
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showBookListingPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterLid = new JLabel("Enter listing id: "); 
	    panel.add(enterLid); 
	    TextField lid = new TextField(50); 
	    panel.add(lid); 
	    
	    JLabel enterOfferingDate = new JLabel("Enter date you want to book: "); 
	    panel.add(enterOfferingDate); 
	    TextField offeringDate = new TextField(50); 
	    panel.add(offeringDate); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.bookListing(SIN.getText(), lid.getText(), offeringDate.getText());
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == 1){
					success.setText("Listing already bookde on the said date");  
				}else if(result == 2) {
					success.setText("No listing offering found on the said date");
				}else if(result == -1) {
					success.setText("Cannot have date before today");
				}
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showAddListingOfferingPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterLid = new JLabel("Enter listing id: "); 
	    panel.add(enterLid); 
	    TextField lid = new TextField(50); 
	    panel.add(lid); 
	    
	    JLabel enterOfferingDate = new JLabel("Enter the date your listing is available for rent: "); 
	    panel.add(enterOfferingDate); 
	    TextField offeringDate = new TextField(50); 
	    panel.add(offeringDate); 
	    
	    JLabel enterPrice = new JLabel("Enter the price your listing is available to rent at the above date: "); 
	    panel.add(enterPrice); 
	    TextField price = new TextField(50); 
	    panel.add(price); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.addListingOffering(SIN.getText(), lid.getText(), offeringDate.getText(), price.getText());
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == -1) {
					success.setText("Cannot have date before today");
				}else{
					success.setText("Unauthorized");  
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
public static void showRemoveListingPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterLid = new JLabel("Enter listing id: "); 
	    panel.add(enterLid); 
	    TextField lid = new TextField(50); 
	    panel.add(lid); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to add the amenity"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.removeListing(SIN.getText(), lid.getText());
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == -1) {
					success.setText("Cannot have date before today");
				}else {
					success.setText("Unauthorized");  
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
public static void showAddAmenityPage() {
		 
		
		JFrame frame = new JFrame("deleteUser");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter SIN: "); 
	    panel.add(enterSin); 
	    TextField SIN = new TextField(50); 
	    panel.add(SIN); 
	    
	    JLabel enterLid = new JLabel("Enter listing id: "); 
	    panel.add(enterLid); 
	    TextField lid = new TextField(50); 
	    panel.add(lid); 
	    
	    JLabel enterAmenityDescription = new JLabel("Enter Amenity Description: "); 
	    panel.add(enterAmenityDescription); 
	    TextField amenityDescription = new TextField(50); 
	    panel.add(amenityDescription); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to add the amenity"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.addAmenity(SIN.getText(), lid.getText(), amenityDescription.getText());
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully added amenity"); 
				}else {
					success.setText("Unauthorized");  
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
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
	    
	    JLabel enterCity = new JLabel("Enter the City: "); 
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
	    
	    JLabel enterApartmentSuite = new JLabel("Enter the apartment/suite number: "); 
	    panel.add(enterApartmentSuite); 
	    TextField apartmentSuite = new TextField(50); 
	    panel.add(apartmentSuite); 
	    
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
					result = dao.postListing(SIN.getText(), type.getText(), city.getText(), country.getText(), postalCode.getText(), apartmentSuite.getText(), latitude.getText(), longitude.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				if(result) {
					success.setText("Successfully added Listing"); 
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
	    
	    JLabel enterApartmentSuite = new JLabel("Enter apartment/suite number: "); 
	    panel.add(enterApartmentSuite); 
	    TextField apartmentSuite = new TextField(6); 
	    panel.add(apartmentSuite); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to add the user"); 
	    panel.add(success); 
	    
	    ActionListener submitAddRenter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean result = dao.postUser(SIN.getText(), occupation.getText(), username.getText(), password.getText(), birthday.getText(), 
							type.getText(), cardNumber.getText(), city.getText(), country.getText(), postalCode.getText(), apartmentSuite.getText());
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
	    
	    JLabel enterApartmentSuite = new JLabel("Enter apartment/suite number: "); 
	    panel.add(enterApartmentSuite); 
	    TextField apartmentSuite = new TextField(6); 
	    panel.add(apartmentSuite); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to add the user"); 
	    panel.add(success); 
	    
	    ActionListener submitAddRenter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean result = dao.postUser(SIN.getText(), occupation.getText(), username.getText(), password.getText(), birthday.getText(), 
							city.getText(), country.getText(), postalCode.getText(), apartmentSuite.getText());
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
