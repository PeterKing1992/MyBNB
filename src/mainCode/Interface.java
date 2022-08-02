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
		
		ActionListener renterCommentOnHostListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showRenterCommentOnHostPage(); 
			}
		};
		
		ActionListener hostCommentOnRenterListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showHostCommentOnRenterPage(); 
			}
		};
		
		ActionListener renterCommentOnListingListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showRenterCommentOnListingPage(); 
			}
			
		};
		
		ActionListener findListingByLocationListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showFindListingByLocationPage(); 
			}
			
		};
		
		ActionListener findListingByPostalCodeListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showFindListingByPostalCodePage(); 
			}
			
		};
		
		ActionListener findListingByAddressListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showFindListingByAddressPage(); 
			}
			
		};
		
		ActionListener reportNumberOfBookingsByCityListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showReportNumberOfBookingsByCityPage(); 
			}
			
		};
		
		ActionListener reportNumberOfBookingsByCityAndPostalCodeListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showReportNumberOfBookingsByCityAndPostalCodePage(); 
			}
			
		};
		
		ActionListener reportNumberOfListingsListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showReportNumberOfListingsPage(); 
			}
			
		};
		
		ActionListener reportHostsRankByCountryCityListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showReportHostsRankByCountryCityPage(); 
			}
			
		};
		
		ActionListener reportCommercialHostsListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showReportCommercialHostsPage(); 
			}
			
		};
		
		ActionListener reportRentersRankListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showReportRentersRankPage();  
			}
			
		};
		
		JFrame frame = new JFrame("MyBNB");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1920,1080);
	    
//	    JPanel panel = new JPanel(new GridLayout(0, 1)); 
//	    frame.add(panel); 
	    
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    JPanel panel = new JPanel(new GridLayout(0, 1)); 
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    //
	    
	    JLabel basicOps = new JLabel("Basic Operations"); 
	    panel.add(basicOps); 
	    
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
	    
	    JButton renterCommentOnHost = new JButton("Comment on a Host as a renter");
	    renterCommentOnHost.addActionListener(renterCommentOnHostListener); 
	    panel.add(renterCommentOnHost); 
	    
	    JButton hostCommentOnRenter = new JButton("Comment on a renter as a Host");
	    hostCommentOnRenter.addActionListener(hostCommentOnRenterListener); 
	    panel.add(hostCommentOnRenter); 
	    
	    JButton renterCommentOnListing = new JButton("Comment on a listing as a renter");
	    renterCommentOnListing.addActionListener(renterCommentOnListingListener); 
	    panel.add(renterCommentOnListing); 
	    
	    JLabel findListings = new JLabel("Find Listings"); 
	    panel.add(findListings); 
	    
	    JButton findListingByLocation = new JButton("Find listing by location(latitude and longitude)");
	    findListingByLocation.addActionListener(findListingByLocationListener); 
	    panel.add(findListingByLocation); 
	    
	    JButton findListingByPostalCode = new JButton("Find listing by postalCode");
	    findListingByPostalCode.addActionListener(findListingByPostalCodeListener); 
	    panel.add(findListingByPostalCode); 
	    
	    JButton findListingByAddress = new JButton("Find listing by address");
	    findListingByAddress.addActionListener(findListingByAddressListener); 
	    panel.add(findListingByAddress); 
	    
	    JLabel reports = new JLabel("Reports"); 
	    panel.add(reports); 
	    
	    JButton reportNumberOfBookingsByCity = new JButton("Check Report of Number of bookings by city");
	    reportNumberOfBookingsByCity.addActionListener(reportNumberOfBookingsByCityListener); 
	    panel.add(reportNumberOfBookingsByCity); 
	    
	    JButton reportNumberOfBookingsByCityAndPostalCode = new JButton("Check Report of Number of bookings by postal code within a city");
	    reportNumberOfBookingsByCityAndPostalCode.addActionListener(reportNumberOfBookingsByCityAndPostalCodeListener); 
	    panel.add(reportNumberOfBookingsByCityAndPostalCode); 
	    
	    JButton reportNumberOfListings = new JButton("Check Report of Total Number of listings");
	    reportNumberOfListings.addActionListener(reportNumberOfListingsListener); 
	    panel.add(reportNumberOfListings); 
	    
	    JButton reportHostsRankByArea = new JButton("Check Rank of Hosts Based on their Total Number of Listings per Area");
	    reportHostsRankByArea.addActionListener(reportHostsRankByCountryCityListener); 
	    panel.add(reportHostsRankByArea); 
	    
	    JButton reportCommercialHosts = new JButton("Check Report of Commercial Hosts By City");
	    reportCommercialHosts.addActionListener(reportCommercialHostsListener); 
	    panel.add(reportCommercialHosts); 
	    
	    JButton reportRentersRank = new JButton("Check Rank of Renters Based on their Total Number of bookings within a period");
	    reportRentersRank.addActionListener(reportRentersRankListener); 
	    panel.add(reportRentersRank); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showRentersRankPage(ResultSet rs) {
		
		JFrame frame = new JFrame("new result");
	    frame.setSize(1280,720);
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
	    
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    
	    JPanel panel = new JPanel(new GridLayout(0, 3)); 
	    
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    
	    
	    //    lid,latitude,longitude,price, type, postalCode, apartmentSuite, city, country
	    
	    JLabel sinTitle = new JLabel("SIN"); 
	    panel.add(sinTitle); 
	    
	    JLabel usernameTitle = new JLabel("username"); 
	    panel.add(usernameTitle); 
	    
	    JLabel numBookingsTitle = new JLabel("<HTML>Number Of Bookings<HTML>"); 
	    panel.add(numBookingsTitle); 
	    
	    try {
			while(rs.next()) {
				JLabel sin = new JLabel(rs.getString("SIN")); 
			    panel.add(sin); 
			    JLabel username = new JLabel(rs.getString("uname")); 
			    panel.add(username); 
			    JLabel numBookings = new JLabel(rs.getString("count(bid)")); 
			    panel.add(numBookings); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showReportRentersRankPage() {
		 
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterTimeWindow = new JLabel("<HTML>Enter The Time Window You would like to rank the renters based on their number of bookings in(separate the beginning date and end date by comma and write the dates in form \"YYYY-MM-dd\", E.g.\"2022-01-01,2023-01-01\"): <HTML>"); 
	    panel.add(enterTimeWindow);
	    TextField timeWindow = new TextField(50); 
	    panel.add(timeWindow);
	    
	    JLabel enterCity = new JLabel("<HTML>Enter the City Name you want to do rank the renters by their number of bookings in(optional, leave it blank if you do not want to use it): <HTML>"); 
	    panel.add(enterCity); 
	    TextField city = new TextField(50); 
	    panel.add(city); 
		
		ActionListener submitListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.rankRentersByBookings(timeWindow.getText(), city.getText());   
					showRentersRankPage(rs); 
				} catch (SQLException e1) {
//					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submit = new JButton("submit");
	    submit.addActionListener(submitListener);
	    panel.add(submit); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showReportCommercialHostsPage() {
		 
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterCountry = new JLabel("<HTML>Enter the country you want to find the commercial hosts in: <HTML>"); 
	    panel.add(enterCountry);
	    TextField country = new TextField(50); 
	    panel.add(country);
	    
	    JLabel enterCity = new JLabel("<HTML>Enter the City you want to find the commercial hosts in: <HTML>"); 
	    panel.add(enterCity); 
	    TextField city = new TextField(50); 
	    panel.add(city); 
		
		ActionListener submitListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.reportCommercialHosts(country.getText(), city.getText());   
					showCommercialHostsPage(rs); 
				} catch (SQLException e1) {
//					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submit = new JButton("submit");
	    submit.addActionListener(submitListener);
	    panel.add(submit); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showCommercialHostsPage(ResultSet rs) {
		
		JFrame frame = new JFrame("new result");
	    frame.setSize(1280,720);
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
	    
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    
	    JPanel panel = new JPanel(new GridLayout(0, 3)); 
	    
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    
	    
	    //    lid,latitude,longitude,price, type, postalCode, apartmentSuite, city, country
	    
	    JLabel sinTitle = new JLabel("SIN"); 
	    panel.add(sinTitle); 
	    
	    JLabel usernameTitle = new JLabel("username"); 
	    panel.add(usernameTitle); 
	    
	    JLabel numListingsTitle = new JLabel("<HTML>Ratio of listing owned against total number of listings in the city<HTML>"); 
	    panel.add(numListingsTitle); 
	    
	    try {
			while(rs.next()) {
				JLabel sin = new JLabel(rs.getString("SIN")); 
			    panel.add(sin); 
			    JLabel username = new JLabel(rs.getString("uname")); 
			    panel.add(username); 
			    JLabel numListings = new JLabel(rs.getString("ratio")); 
			    panel.add(numListings); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showReportHostsRankByCountryCityPage() {
		 
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterCountry = new JLabel("<HTML>Enter the country you want to rank the hosts by their number of listings in: <HTML>"); 
	    panel.add(enterCountry);
	    TextField country = new TextField(50); 
	    panel.add(country);
	    
	    JLabel enterCity = new JLabel("<HTML>Enter the City Name you want to do rank the hosts by their number of listings in(optional, leave it blank if you do not want to use it): <HTML>"); 
	    panel.add(enterCity); 
	    TextField city = new TextField(50); 
	    panel.add(city); 
		
		ActionListener submitListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.rankHostsByCountryCity(country.getText(), city.getText());   
					showHostsRankByCountryCityPage(rs); 
				} catch (SQLException e1) {
//					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submit = new JButton("submit");
	    submit.addActionListener(submitListener);
	    panel.add(submit); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showHostsRankByCountryCityPage(ResultSet rs) {
		 
		JFrame frame = new JFrame("new result");
	    frame.setSize(1280,720);
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
	    
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    
	    JPanel panel = new JPanel(new GridLayout(0, 3)); 
	    
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    
	    
	    //    lid,latitude,longitude,price, type, postalCode, apartmentSuite, city, country
	    JLabel sinTitle = new JLabel("SIN"); 
	    panel.add(sinTitle); 
	    
	    JLabel usernameTitle = new JLabel("username"); 
	    panel.add(usernameTitle); 
	    
	    JLabel numListingsTitle = new JLabel("Number of Listings owned"); 
	    panel.add(numListingsTitle); 
	    
	    try {
			while(rs.next()) {
				JLabel sin = new JLabel(rs.getString("SIN")); 
			    panel.add(sin); 
			    JLabel username = new JLabel(rs.getString("uname")); 
			    panel.add(username); 
			    JLabel numListings = new JLabel(rs.getString("count(lid)")); 
			    panel.add(numListings); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showReportNumberOfListingsPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 1)); 
	    frame.add(panel); 
	    
	    ActionListener numberOfListingsByCountryListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.reportNumberOfListingsByCountry();  
					showNumberOfListingsByCountryPage(rs); 
				} catch (SQLException e1) {
//					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
		
		ActionListener numberOfListingsByCountryAndCityListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.reportNumberOfListingsByCountryAndCity();   
					showNumberOfListingsByCountryAndCityPage(rs); 
				} catch (SQLException e1) {
//					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
		
		ActionListener numberOfListingsByCountryAndCityAndPostalCodeListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.reportNumberOfListingsByCountryAndCityAndPostalCode();   
					showNumberOfListingsByCountryAndCityAndPostalCodePage(rs); 
				} catch (SQLException e1) {
//					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submitNumerOfListingsByCountry = new JButton("Show Number Of Listings By Country");
	    submitNumerOfListingsByCountry.addActionListener(numberOfListingsByCountryListener);
	    panel.add(submitNumerOfListingsByCountry); 
	    
	    JButton submitNumberOfListingsByCountryAndCity = new JButton("Show Number Of Listings By Country and City");
	    submitNumberOfListingsByCountryAndCity.addActionListener(numberOfListingsByCountryAndCityListener);
	    panel.add(submitNumberOfListingsByCountryAndCity); 
	    
	    JButton submitNumberOfListingsByCountryAndCityAndPostalCode = new JButton("Show Number Of Listings By Country and City and Postal Code");
	    submitNumberOfListingsByCountryAndCityAndPostalCode.addActionListener(numberOfListingsByCountryAndCityAndPostalCodeListener);
	    panel.add(submitNumberOfListingsByCountryAndCityAndPostalCode); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showNumberOfListingsByCountryAndCityAndPostalCodePage(ResultSet rs) {
		 
		JFrame frame = new JFrame("new result");
	    frame.setSize(1280,720);
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
	    
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    JPanel panel = new JPanel(new GridLayout(0, 4)); 
	    
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    
	    
	//    lid,latitude,longitude,price, type, postalCode, apartmentSuite, city, country
	    JLabel countryTitle = new JLabel("country"); 
	    panel.add(countryTitle); 
	    
	    JLabel cityTitle = new JLabel("city"); 
	    panel.add(cityTitle); 
	    
	    JLabel postalCodeTitle = new JLabel("postalCode"); 
	    panel.add(postalCodeTitle); 
	    
	    JLabel numberOfListingsTitle = new JLabel("Number of Listings"); 
	    panel.add(numberOfListingsTitle); 
	    
	    try {
			while(rs.next()) {
				JLabel country = new JLabel(rs.getString("country")); 
				panel.add(country); 
				JLabel city = new JLabel(rs.getString("city")); 
				panel.add(city); 
				JLabel postalCode = new JLabel(rs.getString("postalcode")); 
				panel.add(postalCode); 
				JLabel numberOfListings = new JLabel(rs.getString("count(lid)")); 
			    panel.add(numberOfListings); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showNumberOfListingsByCountryAndCityPage(ResultSet rs) {
		 
		JFrame frame = new JFrame("new result");
	    frame.setSize(1280,720);
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
	    
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    JPanel panel = new JPanel(new GridLayout(0, 3)); 
	    
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    
	    
	//    lid,latitude,longitude,price, type, postalCode, apartmentSuite, city, country
	    JLabel countryTitle = new JLabel("country"); 
	    panel.add(countryTitle); 
	    
	    JLabel cityTitle = new JLabel("city"); 
	    panel.add(cityTitle); 
	    
	    JLabel numberOfListingsTitle = new JLabel("Number of Bookings"); 
	    panel.add(numberOfListingsTitle); 
	    
	    try {
			while(rs.next()) {
				JLabel country = new JLabel(rs.getString("country")); 
				panel.add(country); 
				JLabel city = new JLabel(rs.getString("city")); 
				panel.add(city); 
				JLabel numberOfListings = new JLabel(rs.getString("count(lid)")); 
			    panel.add(numberOfListings); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showNumberOfListingsByCountryPage(ResultSet rs) {
		 
		JFrame frame = new JFrame("new result");
	    frame.setSize(1280,720);
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
	    
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    
	    
	//    lid,latitude,longitude,price, type, postalCode, apartmentSuite, city, country
	    JLabel countryTitle = new JLabel("Country"); 
	    panel.add(countryTitle); 
	    
	    JLabel numberOfListingsTitle = new JLabel("Number of Listings"); 
	    panel.add(numberOfListingsTitle); 
	    
	    try {
			while(rs.next()) {
				JLabel country = new JLabel(rs.getString("country")); 
				panel.add(country); 
				JLabel numberOfListings = new JLabel(rs.getString("count(lid)")); 
			    panel.add(numberOfListings); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showReportNumberOfBookingsByCityAndPostalCodePage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterTimeWindow = new JLabel("<HTML>Enter the time window you want to run the report by(enter dates in form(yyyy-MM-dd) separate the start and end by comma E.g. \"2021-01-01,2022-01-01\"): <HTML>"); 
	    panel.add(enterTimeWindow); 
	    TextField timeWindow = new TextField(50); 
	    panel.add(timeWindow); 
	    
	    JLabel enterCity = new JLabel("<HTML>Enter the City Name you want to do query in: <HTML>"); 
	    panel.add(enterCity); 
	    TextField city = new TextField(50); 
	    panel.add(city); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.reportNumberOfBookingsByCityAndPostalCode(city.getText(), timeWindow.getText());  
					showNumberOfBookingsByCityAndPostalCodePage(rs); 
				} catch (SQLException e1) {
//					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showNumberOfBookingsByCityAndPostalCodePage(ResultSet rs) {
		 
		JFrame frame = new JFrame("new result");
	    frame.setSize(1280,720);
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
	    
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    JPanel panel = new JPanel(new GridLayout(0, 3)); 
	    
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    
	    
	//    lid,latitude,longitude,price, type, postalCode, apartmentSuite, city, country
	    JLabel cityTitle = new JLabel("City"); 
	    panel.add(cityTitle); 
	    
	    JLabel postalCodeTitle = new JLabel("Postal Code"); 
	    panel.add(postalCodeTitle); 
	    
	    JLabel numberOfBookingsTitle = new JLabel("Number of Bookings"); 
	    panel.add(numberOfBookingsTitle); 
	    
	    try {
			while(rs.next()) {
				JLabel city = new JLabel(rs.getString("city")); 
			    panel.add(city); 
				JLabel postalCode = new JLabel(rs.getString("postalCode")); 
				panel.add(postalCode); 
				JLabel numberOfListings = new JLabel(rs.getString("count(bid)")); 
			    panel.add(numberOfListings); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showReportNumberOfBookingsByCityPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterTimeWindow = new JLabel("<HTML>Enter the time window you want to run the report by(enter dates in form(yyyy-MM-dd) separate the start and end by comma E.g. \"2021-01-01,2022-01-01\"): <HTML>"); 
	    panel.add(enterTimeWindow); 
	    TextField timeWindow = new TextField(50); 
	    panel.add(timeWindow); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.reportNumberOfBookingsByCity(timeWindow.getText());  
					showNumberOfBookingsByCityPage(rs); 
				} catch (SQLException e1) {
//					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showNumberOfBookingsByCityPage(ResultSet rs) {
		 
		
		JFrame frame = new JFrame("new result");
	    frame.setSize(1280,720);
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
	    
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    
	    
	//    lid,latitude,longitude,price, type, postalCode, apartmentSuite, city, country
	    JLabel cityTitle = new JLabel("City"); 
	    panel.add(cityTitle); 
	    JLabel numberOfBookingsTitle = new JLabel("Number of Bookings"); 
	    panel.add(numberOfBookingsTitle); 
	    
	    try {
			while(rs.next()) {
				JLabel city = new JLabel(rs.getString("city")); 
				panel.add(city); 
				JLabel numberOfListings = new JLabel(rs.getString("count(bid)")); 
			    panel.add(numberOfListings); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    frame.setVisible(true);
    
    
	}
	
	public static void showFindListingByAddressPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterPostalCode = new JLabel("Enter PostalCode: "); 
	    panel.add(enterPostalCode); 
	    TextField postalCode = new TextField(50); 
	    panel.add(postalCode); 
	    
	    JLabel enterStreet = new JLabel("Enter street: "); 
	    panel.add(enterStreet); 
	    TextField street = new TextField(50); 
	    panel.add(street); 
	    
	    JLabel enterProvince = new JLabel("Enter Province: "); 
	    panel.add(enterProvince); 
	    TextField province = new TextField(50); 
	    panel.add(province); 
	    
	    JLabel enterCity = new JLabel("Enter City: "); 
	    panel.add(enterCity); 
	    TextField city = new TextField(50); 
	    panel.add(city); 
	    
	    JLabel enterCountry = new JLabel("Enter Country: "); 
	    panel.add(enterCountry); 
	    TextField country = new TextField(50); 
	    panel.add(country); 
	    
	    JLabel enterApartmentSuite = new JLabel("Enter Apartment/Suite Number: "); 
	    panel.add(enterApartmentSuite); 
	    TextField apartmentSuite = new TextField(50); 
	    panel.add(apartmentSuite); 
	    
	    JLabel enterTimeWindow = new JLabel("<HTML>Enter the time window you want the listing to be available(enter dates in form(yyyy-MM-dd) separate the start and end by comma E.g. \"2021-01-01,2022-01-01\"): <HTML>"); 
	    panel.add(enterTimeWindow); 
	    TextField timeWindow = new TextField(50); 
	    panel.add(timeWindow); 
	    
	    JLabel enterAmenities = new JLabel("<HTML>Enter the amenities you would like the listing to have(separate each amenity by comma E.g. \"swimming pool,large house,beach\") leave empty if you do not want to use this option: <HTML>"); 
	    panel.add(enterAmenities); 
	    TextField amenities = new TextField(100); 
	    panel.add(amenities); 
	    
	    JLabel enterPriceRange = new JLabel("<HTML>Enter the priceRange you want the listing to be available(enter price in dollars separate the lower and upper bounds by comma E.g. \"25,75\"): <HTML>"); 
	    panel.add(enterPriceRange); 
	    TextField priceRange = new TextField(50); 
	    panel.add(priceRange); 
	    
	    JLabel success = new JLabel("Fill out all the neccessary info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.findListingByAddress(postalCode.getText(), street.getText(), province.getText(), city.getText(), country.getText(), apartmentSuite.getText(), timeWindow.getText(), amenities.getText(), priceRange.getText()); 
					showListingQueryResultPage(rs); 
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showFindListingByPostalCodePage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterPostalCode = new JLabel("Enter PostalCode: "); 
	    panel.add(enterPostalCode); 
	    TextField postalCode = new TextField(50); 
	    panel.add(postalCode); 
	    
	    JLabel enterTimeWindow = new JLabel("<HTML>Enter the time window you want the listing to be available(enter dates in form(yyyy-MM-dd) separate the start and end by comma E.g. \"2021-01-01,2022-01-01\"): <HTML>"); 
	    panel.add(enterTimeWindow); 
	    TextField timeWindow = new TextField(50); 
	    panel.add(timeWindow); 
	    
	    JLabel enterDistance = new JLabel("<HTML>Enter the distance of the listing to find within the location specified(leave empty for default distance): <HTML>"); 
	    panel.add(enterDistance); 
	    TextField distance = new TextField(50); 
	    panel.add(distance); 
	    
	    JLabel enterPriceRank = new JLabel("<HTML>Enter the way to rank the resultingListings by price(\"asc\" for ascending order \"desc\" for descending order) leave empty for default: <HTML>"); 
	    panel.add(enterPriceRank); 
	    TextField priceRank = new TextField(50); 
	    panel.add(priceRank); 
	    
	    JLabel enterAmenities = new JLabel("<HTML>Enter the amenities you would like the listing to have(separate each amenity by comma E.g. \"swimming pool,large house,beach\") leave empty if you do not want to use this option: <HTML>"); 
	    panel.add(enterAmenities); 
	    TextField amenities = new TextField(100); 
	    panel.add(amenities); 
	    
	    JLabel enterPriceRange = new JLabel("<HTML>Enter the priceRange you want the listing to be available(enter price in dollars separate the lower and upper bounds by comma E.g. \"25,75\"): <HTML>"); 
	    panel.add(enterPriceRange); 
	    TextField priceRange = new TextField(50); 
	    panel.add(priceRange); 
	    
	    JLabel success = new JLabel("Fill out all the neccessary info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.findListingByPostalCode(postalCode.getText(), timeWindow.getText(), distance.getText(), priceRank.getText(), amenities.getText(), priceRange.getText()); 
					showListingQueryResultPage(rs); 
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showFindListingByLocationPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterLatitude = new JLabel("Enter the latitude: "); 
	    panel.add(enterLatitude); 
	    TextField latitude = new TextField(50); 
	    panel.add(latitude); 
	    
	    JLabel enterLongitude = new JLabel("Enter the longitude: "); 
	    panel.add(enterLongitude); 
	    TextField longitude = new TextField(50); 
	    panel.add(longitude); 
	    
	    JLabel enterTimeWindow = new JLabel("<HTML>Enter the time window you want the listing to be available(enter dates in form(yyyy-MM-dd) separate the start and end by comma E.g. \"2021-01-01,2022-01-01\"): <HTML>"); 
	    panel.add(enterTimeWindow); 
	    TextField timeWindow = new TextField(50); 
	    panel.add(timeWindow); 
	    
	    JLabel enterDistance = new JLabel("<HTML>Enter the distance of the listing to find within the location specified(leave empty for default distance): <HTML>"); 
	    panel.add(enterDistance); 
	    TextField distance = new TextField(50); 
	    panel.add(distance); 
	    
	    JLabel enterPriceRank = new JLabel("<HTML>Enter the way to rank the resultingListings by price(\"asc\" for ascending order \"desc\" for descending order) leave empty for default: <HTML>"); 
	    panel.add(enterPriceRank); 
	    TextField priceRank = new TextField(50); 
	    panel.add(priceRank); 
	    
	    JLabel enterAmenities = new JLabel("<HTML>Enter the amenities you would like the listing to have(separate each amenity by comma E.g. \"swimming pool,large house,beach\") leave empty if you do not want to use this option: <HTML>"); 
	    panel.add(enterAmenities); 
	    TextField amenities = new TextField(100); 
	    panel.add(amenities); 
	    
	    JLabel enterPriceRange = new JLabel("<HTML>Enter the priceRange you want the listing to be available(enter price in dollars separate the lower and upper bounds by comma E.g. \"25,75\"): <HTML>"); 
	    panel.add(enterPriceRange); 
	    TextField priceRange = new TextField(50); 
	    panel.add(priceRange); 
	    
	    JLabel success = new JLabel("Fill out all the neccessary info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs = dao.findListingByLocation(latitude.getText(), longitude.getText(), timeWindow.getText(), distance.getText(), priceRank.getText(), amenities.getText(), priceRange.getText()); 
					showListingQueryResultPage(rs); 
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showListingQueryResultPage(ResultSet rs) {
	 
	
		JFrame frame = new JFrame("new result");
	    frame.setSize(1280,720);
	    JPanel mainPanel = new JPanel(new GridLayout(0, 1)); 
	    
//	    GridLayout gridLayout = new GridLayout(0, 9, 0, 0); 
	    JPanel panel = new JPanel(new GridLayout(0, 9)); 
	    
	    JScrollPane scroller = new JScrollPane(panel); 
	    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.add(mainPanel, BorderLayout.NORTH);
	    frame.add(scroller, BorderLayout.CENTER);
	    
	    
	//    lid,latitude,longitude,price, type, postalCode, apartmentSuite, city, country
	    
	    JLabel lidTitle = new JLabel("lid"); 
	    panel.add(lidTitle); 
	    
	    JLabel latitudeTitle = new JLabel("latitude"); 
	    panel.add(latitudeTitle); 
	    
	    JLabel longitudeTitle = new JLabel("longitude"); 
	    panel.add(longitudeTitle); 
	    
	    JLabel priceTitle = new JLabel("Price"); 
	    panel.add(priceTitle); 
	    
	    JLabel typeTitle = new JLabel("type"); 
	    panel.add(typeTitle); 
	    
	    JLabel postalCodeTitle = new JLabel("postal code"); 
	    panel.add(postalCodeTitle); 
	    
	    JLabel apartmentSuiteTitle = new JLabel("apartment/suite"); 
	    panel.add(apartmentSuiteTitle); 
	    
	    JLabel cityTitle = new JLabel("city"); 
	    panel.add(cityTitle); 
	    
	    JLabel countryTitle = new JLabel("country"); 
	    panel.add(countryTitle); 
	    
	    try {
			while(rs.next()) {
				JLabel lid = new JLabel(rs.getString("lid")); 
			    panel.add(lid); 
				
			    JLabel latitude = new JLabel(rs.getString("latitude")); 
			    panel.add(latitude); 
			    
			    JLabel longitude = new JLabel(rs.getString("longitude")); 
			    panel.add(longitude); 
			    
			    JLabel price = new JLabel(rs.getString("avg(price)")); 
			    panel.add(price); 
			    
			    JLabel type = new JLabel(rs.getString("ltype")); 
			    panel.add(type); 
			    
			    JLabel postalCode = new JLabel(rs.getString("postalCode")); 
			    panel.add(postalCode); 
			    
			    JLabel apartmentSuite = new JLabel(rs.getString("apartmentSuite")); 
			    panel.add(apartmentSuite); 
			    
			    JLabel city = new JLabel(rs.getString("city")); 
			    panel.add(city); 
			    
			    JLabel country = new JLabel(rs.getString("country")); 
			    panel.add(country); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    frame.setVisible(true);
    
    
	}

	public static void showRenterCommentOnListingPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterSin = new JLabel("Enter the your SIN: "); 
	    panel.add(enterSin); 
	    TextField sin = new TextField(50); 
	    panel.add(sin); 
	    
	    JLabel enterLid = new JLabel("Enter the listingId of the listing you want to comment on: "); 
	    panel.add(enterLid); 
	    TextField lid = new TextField(50); 
	    panel.add(lid); 
	    
	    JLabel enterRating = new JLabel("Enter Your rating on this renter: "); 
	    panel.add(enterRating); 
	    TextField rating = new TextField(50); 
	    panel.add(rating); 
	    
	    JLabel enterContent = new JLabel("Enter Your comment on this renter: "); 
	    panel.add(enterContent); 
	    TextField comment = new TextField(2000); 
	    panel.add(comment); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.renterCommentOnListing(sin.getText(), lid.getText(), rating.getText(), comment.getText()); 
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == 1){
					success.setText("Unauthorized, you have not recently stayed at the said listing");  
				}
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showHostCommentOnRenterPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterHostSin = new JLabel("Enter the your SIN: "); 
	    panel.add(enterHostSin); 
	    TextField host = new TextField(50); 
	    panel.add(host); 
	    
	    JLabel enterRenterSin = new JLabel("Enter the SIN of the renter you want to comment on: "); 
	    panel.add(enterRenterSin); 
	    TextField renter = new TextField(50); 
	    panel.add(renter); 
	    
	    JLabel enterRating = new JLabel("Enter Your rating on this renter: "); 
	    panel.add(enterRating); 
	    TextField rating = new TextField(50); 
	    panel.add(rating); 
	    
	    JLabel enterContent = new JLabel("Enter Your comment on this renter: "); 
	    panel.add(enterContent); 
	    TextField comment = new TextField(2000); 
	    panel.add(comment); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.hostCommentOnRenter(renter.getText(), host.getText(), rating.getText(), comment.getText()); 
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == 1){
					success.setText("Unauthorized, renter has not completed a stay at your listing recently");  
				}
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
	    frame.setVisible(true);
	    
	    
	}
	
	public static void showRenterCommentOnHostPage() {
		 
		
		JFrame frame = new JFrame("new operation");
	    frame.setSize(1280,720);
	    
	    JPanel panel = new JPanel(new GridLayout(0, 2)); 
	    frame.add(panel); 
	    
	    JLabel enterRenterSin = new JLabel("Enter Your SIN: "); 
	    panel.add(enterRenterSin); 
	    TextField renter = new TextField(50); 
	    panel.add(renter); 
	    
	    JLabel enterHostSin = new JLabel("Enter the SIN of the host you want to comment on: "); 
	    panel.add(enterHostSin); 
	    TextField host = new TextField(50); 
	    panel.add(host); 
	    
	    JLabel enterRating = new JLabel("Enter Your rating on this host: "); 
	    panel.add(enterRating); 
	    TextField rating = new TextField(50); 
	    panel.add(rating); 
	    
	    JLabel enterContent = new JLabel("Enter Your comment on this host: "); 
	    panel.add(enterContent); 
	    TextField comment = new TextField(2000); 
	    panel.add(comment); 
	    
	    JLabel success = new JLabel("Fill out all the info on this form to execute operation"); 
	    panel.add(success); 
	    
	    ActionListener submitDeleteUser = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				try {
					result = dao.renterCommentOnHost(renter.getText(), host.getText(), rating.getText(), comment.getText()); 
				} catch (SQLException e1) {
					success.setText("server error");
					e1.printStackTrace();
				} 
				if(result == 0) {
					success.setText("Successfully completed operation"); 
				}else if(result == 1){
					success.setText("Unauthorized, you have not stayed in this host's listing recently");  
				}
			}
		};
	    
	    JButton submitForm = new JButton("Submit");
	    submitForm.addActionListener(submitDeleteUser);
	    panel.add(submitForm); 
	    
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
	    
	    JLabel enterStreet = new JLabel("Enter the Street: "); 
	    panel.add(enterStreet); 
	    TextField street = new TextField(50); 
	    panel.add(street); 
	    
	    JLabel enterProvince = new JLabel("Enter the province/state: "); 
	    panel.add(enterProvince); 
	    TextField province = new TextField(50); 
	    panel.add(province); 
	    
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
					result = dao.postListing(SIN.getText(), type.getText(), city.getText(), country.getText(), postalCode.getText(), street.getText(), province.getText(), apartmentSuite.getText(), latitude.getText(), longitude.getText());
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
	    
	    JLabel enterStreet = new JLabel("Enter Street: "); 
	    panel.add(enterStreet); 
	    TextField street = new TextField(50); 
	    panel.add(street); 
	    
	    JLabel enterProvince = new JLabel("Enter Province: "); 
	    panel.add(enterProvince); 
	    TextField province = new TextField(50); 
	    panel.add(province); 
	    
	    JLabel enterCountry = new JLabel("Enter Country: "); 
	    panel.add(enterCountry); 
	    TextField country = new TextField(50); 
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
							type.getText(), cardNumber.getText(), city.getText(), country.getText(),postalCode.getText(), street.getText(), province.getText(), apartmentSuite.getText());
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
	    
	    JLabel enterStreet = new JLabel("Enter Street: "); 
	    panel.add(enterStreet); 
	    TextField street = new TextField(6); 
	    panel.add(street); 
	    
	    JLabel enterProvince = new JLabel("Enter province/state: "); 
	    panel.add(enterProvince); 
	    TextField province = new TextField(6); 
	    panel.add(province); 
	    
	    JLabel enterCountry = new JLabel("Enter Country: "); 
	    panel.add(enterCountry); 
	    TextField country = new TextField(50); 
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
							city.getText(), country.getText(), postalCode.getText(), street.getText(), province.getText(), apartmentSuite.getText());
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
