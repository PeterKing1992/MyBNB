package mainCode;
import java.awt.TextField;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List; 

public class MySqlDAO {
	public Connection conn;
    public Statement st;

	public MySqlDAO() {
        String url = "jdbc:mysql://127.0.0.1/cscc43_project";
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, "root", "hezonglianheng");
            this.st = this.conn.createStatement();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isAdult(String bday) throws ParseException {
//		java.util.Date date=new SimpleDateFormat("yyyy-mm-dd").parse(bday);
		java.util.Date UtilToday = new Date(System.currentTimeMillis()); 

		Date date = Date.valueOf(bday); 
		Date today = new java.sql.Date(UtilToday.getTime()); 
		
		Period period = Period.between(((java.sql.Date) date).toLocalDate(), ((java.sql.Date) today).toLocalDate()); 
		int years = period.getYears(); 
		if(years >= 18) {
			return true; 
		}
		return false; 
	}
	
	public boolean isBeforeToday(String dateToCheck) {
//		java.util.Date date=new SimpleDateFormat("yyyy-mm-dd").parse(bday);
		java.util.Date UtilToday = new Date(System.currentTimeMillis()); 

		Date date = Date.valueOf(dateToCheck); 
		Date today = new java.sql.Date(UtilToday.getTime()); 
		
		
		long days = today.getTime() - date.getTime(); 
		if(days > 0) return true; 
		return false; 
	}

	//DROP database cscc43_project; CREATE database cscc43_project; 
	//GRANT select, create, alter, drop, references on cscc43_project.* to 'user'@'localhost';
	
	// *** implement database operations here *** //

    public boolean postUser(String sin, String occupation, String uname, String password, String bday, String city, String country, String postalCode, String street, String province, String apartmentSuite) throws SQLException, ParseException {
        if(!isAdult(bday)) return false; 
    	
    	String query = "INSERT INTO user(SIN, uoccupation, uname, password, birthday) VALUES('%s', '%s', '%s', '%s', STR_TO_DATE('%s', "; 
        query = query.format(query, sin, occupation, uname, password, bday); 
        query+= "'%Y-%m-%d')); "; 
        this.st.execute(query); 
        query = "INSERT INTO host(SIN) VALUES(%s); "; 
       	query = query.format(query, sin); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO address(postalCode, street, province, city, country, apartmentSuite) VALUES('%s', '%s', '%s', '%s', '%s', %s); "; 
       	query = query.format(query, postalCode, street, province, city, country, apartmentSuite); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO userHasAddress(SIN, postalCode, street, province, city, country, apartmentSuite) VALUES('%s', '%s', '%s', '%s', '%s', '%s', %s); "; 
       	query = query.format(query, sin, postalCode, street, province, city, country, apartmentSuite); 
       	this.st.execute(query); 
       	
       	return true; 
    }
    
    public boolean postUser(String sin, String occupation, String uname, String password, String bday, String paymentType, String cardNumber, String city, String country, String postalCode, String street, String province, String apartmentSuite) throws SQLException, ParseException {
        if(!isAdult(bday)) return false; 
    	
    	String query = "INSERT INTO user(SIN, uoccupation, uname, password, birthday) VALUES('%s', '%s', '%s', '%s', STR_TO_DATE('%s', "; 
    	query = query.format(query, sin, occupation, uname, password, bday); 
    	query+= "'%Y-%m-%d')); "; 
        this.st.execute(query); 
        query = "INSERT INTO renter(SIN) VALUES('%s'); "; 
       	query = query.format(query, sin); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO paymentMethod(type, cardNumber) VALUES('%s', '%s'); "; 
       	query = query.format(query,paymentType, cardNumber); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO hasPaymentMethod(SIN, type, cardNumber) VALUES('%s', '%s', '%s'); "; 
       	query = query.format(query,sin, paymentType, cardNumber); 
       	this.st.execute(query); 
       	
       	query = "INSERT IGNORE INTO address(postalCode, street, province, city, country, apartmentSuite) VALUES('%s', '%s', '%s', '%s', '%s', %s); "; 
       	query = query.format(query, postalCode, street, province, city, country, apartmentSuite); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO userHasAddress(SIN, postalCode, street, province, city, country, apartmentSuite) VALUES('%s', '%s', '%s', '%s', '%s', '%s', %s); "; 
       	query = query.format(query, sin, postalCode, street, province, city, country, apartmentSuite); 
       	this.st.execute(query); 
       	
       	return true; 
    }
    
    public void createSchema() throws SQLException {
    	
    	String query = "CREATE TABLE IF NOT EXISTS user(SIN char(9) PRIMARY KEY, uname varchar(20) NOT NULL, "
    			+ "uoccupation varchar(100) NOT NULL, password varchar(20) NOT NULL, birthday date); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS renter(SIN char(9), FOREIGN KEY(SIN) REFERENCES user(SIN) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(SIN));  "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS host(SIN char(9), FOREIGN KEY(SIN) REFERENCES user(SIN) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(SIN));  "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS paymentMethod(type varchar(50), cardNumber char(12), PRIMARY KEY(type, cardNumber)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS hasPaymentMethod(SIN char(9), "
    			+ "type varchar(50), "
    			+ "cardNumber char(12), "
    			+ "FOREIGN KEY(SIN) REFERENCES renter(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(type, cardNumber) REFERENCES paymentMethod(type, cardNumber) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(type, cardNumber, SIN)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS address(postalCode char(6), street varchar(50), province varchar(50), city varchar(50), country varchar(50), apartmentSuite INT, "
    			+ "PRIMARY KEY(postalCode, street, province, city, country, apartmentSuite)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS userHasAddress(SIN char(9) PRIMARY KEY, postalCode char(6) NOT NULL, street varchar(50) NOT NULL, province varchar(50) not null, city varchar(50) NOT NULL, country varchar(50) NOT NULL, apartmentSuite INT, "
    			+ "FOREIGN KEY(postalCode, street, province, city, country, apartmentSuite) REFERENCES address(postalCode, street, province, city, country, apartmentSuite) ON DELETE CASCADE, "
    			+ "UNIQUE(postalCode, street, province, city, country, apartmentSuite), "
    			+ "FOREIGN KEY(SIN) REFERENCES user(SIN) ON DELETE CASCADE); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS listing(lType varchar(50) NOT NULL, lid INT AUTO_INCREMENT PRIMARY KEY); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS hostPostListing(SIN char(9), lid INT, postDate date NOT NULL, "
    			+ "FOREIGN KEY(SIN) REFERENCES host(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(lid)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS listingHasAddress(lid INT, city varchar(50), country varchar(50), postalCode char(6), street varchar(50), province varchar(50), apartmentSuite INT, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(postalCode, street, province, city, country, apartmentSuite) REFERENCES address(postalCode, street, province, city, country, apartmentSuite) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(lid)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS location(latitude double, longitude double, "
    			+ "PRIMARY KEY(latitude, longitude)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS listingAtLocation(lid INT, latitude double, longitude double, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(latitude, longitude) REFERENCES location(latitude, longitude) ON DELETE CASCADE, "
    			+ "UNIQUE(latitude, longitude), "
    			+ "PRIMARY KEY(lid)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS amenity(amenityId INT PRIMARY KEY AUTO_INCREMENT, amenityDescription varchar(50)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS listingOfferAmenity(lid INT, amenityId INT, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(amenityId) REFERENCES amenity(amenityId), "
    			+ "PRIMARY KEY(amenityId)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS listingOffering(lid INT, offeringDate date, price double NOT NULL, isAvailable boolean NOT NULL DEFAULT true, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(lid, offeringDate)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS booking(bid INT AUTO_INCREMENT PRIMARY KEY); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS bookingAssociatedWithOffering(bid INT, lid INT NOT NULL, offeringDate date NOT NULL, "
    			+ "FOREIGN KEY(lid, offeringDate) REFERENCES listingOffering(lid, offeringDate) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(bid) REFERENCES booking(bid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(bid, lid, offeringDate)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS renterBookBooking(SIN char(9) NOT NULL, bid INT, bookDate date NOT NULL, "
    			+ "FOREIGN KEY(SIN) REFERENCES renter(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(bid) REFERENCES booking(bid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(bid)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS renterCancelBooking(SIN char(9) NOT NULL, bid INT, cancelDate date NOT NULL, "
    			+ "FOREIGN KEY(SIN) REFERENCES renter(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(bid) REFERENCES booking(bid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(bid)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS hostCancelBooking(SIN char(9) NOT NULL, bid INT, cancelDate date NOT NULL, "
    			+ "FOREIGN KEY(SIN) REFERENCES host(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(bid) REFERENCES booking(bid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(bid)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS renterCommentOnHost(commentId INT AUTO_INCREMENT PRIMARY KEY, renter char(9) NOT NULL, host char(9) NOT NULL, commentDate date NOT NULL, "
    			+ "rating DOUBLE NOT NULL, content TEXT NOT NULL, "
    			+ "FOREIGN KEY(renter) REFERENCES renter(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(host) REFERENCES host(SIN) ON DELETE CASCADE "
    			+ "); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS hostCommentOnRenter(commentId INT AUTO_INCREMENT PRIMARY KEY, host char(9) NOT NULL, renter char(9) NOT NULL, commentDate DATE NOT NULL, "
    			+ "rating DOUBLE NOT NULL, content TEXT NOT NULL, "
    			+ "FOREIGN KEY(renter) REFERENCES renter(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(host) REFERENCES host(SIN) ON DELETE CASCADE "
    			+ "); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS renterCommentOnListing(commentId INT AUTO_INCREMENT primary key, renter char(9) NOT NULL, lid INT NOT NULL, commentDate DATE NOT NULL, "
    			+ "rating DOUBLE NOT NULL, content TEXT NOT NULL, "
    			+ "FOREIGN KEY(renter) REFERENCES renter(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE ); "; 
    	this.st.execute(query); 
    	
    	System.out.println("Created Database");
    }

	public boolean deleteUser(String sin) {
		String query = "DELETE FROM paymentMethod WHERE (type, cardNumber) IN (select type, cardNumber from renterHasPaymentMethod WHERE SIN = '%s')"; 
		query = query.format(query, sin); 
		try {
			this.st.execute(query);
			
			query = "DELETE FROM listing WHERE (lid) IN (select lid from hostPostListing WHERE SIN = '%s'); "; 
			query = query.format(query, sin); 
			
			query = "DELETE FROM booking WHERE (bid) IN (select bid from renterBookBooking WHERE SIN = '%s'); "; 
			query = query.format(query, sin);
			
			query = "DELETE FROM address WHERE (postalCode, street, province, city, country, apartmentSuite) IN (select postalCode, street, province, city, country, apartmentSuite "
					+ "from userHasAddress WHERE SIN = '%s'); "; 
			query = query.format(query, sin);
			
			query = "DELETE FROM booking WHERE (bid) IN (select bid from renterCancelBooking WHERE SIN = '%s'); "; 
			query = query.format(query, sin);
			
			query = "DELETE FROM booking WHERE (bid) IN (select bid from hostCancelBooking WHERE SIN = '%s'); "; 
			query = query.format(query, sin);
		} catch (SQLException e) {
			return false; 
		} 
		return true;
	}

	public boolean postListing(String SIN, String type, String city, String country, String postalCode, String street, String province, String apartmentSuite, String latitude, String longitude) throws SQLException {
		String query = "INSERT INTO listing(ltype) VALUES('%s'); "; 
		query = query.format(query, type); 
		this.st.execute(query); 
		
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		query = "INSERT INTO hostPostListing(SIN, lid, postDate) VALUES('%s', last_insert_id(), STR_TO_DATE('%s', "; 
		query = query.format(query, SIN, date); 
		query += "'%Y-%m-%d'));"; 
		this.st.execute(query); 
		
		query = "INSERT INTO address(postalCode, street, province, city, country, apartmentSuite) VALUEs('%s', '%s', '%s', '%s', '%s', %s); "; 
		query = query.format(query, postalCode, street, province, city, country, apartmentSuite); 
		this.st.execute(query); 
		
		query = "INSERT INTO listingHasAddress(lid, postalCode, street, province, city, country, apartmentSuite) VALUEs(last_insert_id(), '%s', '%s', '%s', '%s', '%s', %s); "; 
		query = query.format(query, postalCode, street, province, city, country, apartmentSuite); 
		this.st.execute(query); 
		
		query = "INSERT INTO location(latitude, longitude) VALUEs(%s, %s); "; 
		query = query.format(query, latitude, longitude); 
		this.st.execute(query); 
		
		query = "INSERT INTO listingAtLocation(lid, latitude, longitude) VALUEs(last_insert_id(), %s, %s); "; 
		query = query.format(query, latitude, longitude); 
		this.st.execute(query); 
		
		return true;
	}

	public int addAmenity(String SIN, String lid, String amenityDescription) throws SQLException {
		String query = "select * from hostPostListing WHERE SIN='%s' AND lid=%s; "; 
		query = query.format(query, SIN, lid);  
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		query = "INSERT INTO amenity(amenityDescription) VALUES('%s'); "; 
		query = query.format(query, amenityDescription);  
		this.st.execute(query);
		
		query = "INSERT INTO listingOfferAmenity(lid, amenityId) VALUES(%s, last_insert_id()); "; 
		query = query.format(query, lid);  
		this.st.execute(query);
		
		return 0;
	}

	public int removeListing(String SIN, String lid) throws SQLException {
		String query = "select * from hostPostListing WHERE SIN='%s' AND lid=%s; "; 
		query = query.format(query, SIN, lid);  
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		
		query = "DELETE FROM address WHERE (postalCode, street, province, city, country, apartmentSuite) IN (select postalCode, street, province, city, country, apartmentSuite FROM listingHasAddress WHERE lid=%s) "; 
		query = query.format(query, lid);  
		this.st.execute(query);
		
		query = "DELETE FROM location WHERE (latitude, longitude) IN (select latitude, longitude FROM listingAtLocation WHERE lid=%s) "; 
		query = query.format(query, lid);  
		this.st.execute(query);
		
		query = "DELETE FROM listing WHERE lid=%s "; 
		query = query.format(query, lid);  
		this.st.execute(query);
		
		query = "DELETE FROM booking WHERE bid IN (select bid from bookingAssociatedWithOffering WHERE lid=%s); "; 
		query = query.format(query, lid);  
		this.st.execute(query);
		
		query = "DELETE FROM listingOffering WHERE lid=%s "; 
		query = query.format(query, lid);  
		this.st.execute(query);
		
		return 0;
	}

	public int addListingOffering(String SIN, String lid, String offeringDate, String price) throws SQLException {
//		if(isBeforeToday(offeringDate)) return -1; 
		String query = "select * from hostPostListing WHERE SIN='%s' AND lid=%s; "; 
		query = query.format(query, SIN, lid);  
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		query = "INSERT INTO listingOffering(lid, price, offeringDate) VALUES('%s', %s, STR_TO_DATE('%s', "; 
		query = query.format(query, lid, price, offeringDate);  
		query += "'%Y-%m-%d'));"; 
		this.st.execute(query);
		
		return 0;
	}

	public int bookListing(String SIN, String lid, String dateRange) throws SQLException, ParseException {
		String[] dateRangeArray = dateRange.split(","); 
		String startDate = dateRangeArray[0]; 
		String endDate = dateRangeArray[1]; 
		
//		if(isBeforeToday(offeringDate)) return -1; 
		String query = "SELECT lid "
				+ "FROM listingOffering "
				+ "WHERE isAvailable=true AND offeringDate between '%s' AND '%s' AND lid=%s GROUP BY lid HAVING count(offeringDate)>=(DATEDIFF('%s', '%s') + 1) "; 
		query = query.format(query, startDate, endDate, lid, endDate, startDate); 
		ResultSet rs = this.st.executeQuery(query); 
		
		if(!rs.next()) {
			return 2; 
		}
		
		query = "INSERT INTO booking() VALUES(null); "; 
		this.st.execute(query);
		
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		query = "INSERT INTO renterBookBooking(SIN, bid, bookDate) VALUES('%s', last_insert_id(), STR_TO_DATE('%s',"; 
		query = query.format(query, SIN, date);  
		query += "'%Y-%m-%d')); "; 
		this.st.execute(query);
		
		java.util.Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate); 
		java.util.Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate); 
		
		while(start.getTime() <= end.getTime()) {
		
			String offeringDate = new SimpleDateFormat("yyyy-MM-dd").format(start.getTime()); 
			
			query = "INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), %s, STR_TO_DATE('%s', ";
			query = query.format(query, lid, offeringDate); 
			query += "'%Y-%m-%d'));"; 
			this.st.execute(query);
	
			query = "UPDATE listingOffering SET isAvailable=false WHERE lid=%s AND offeringDate=STR_TO_DATE('%s', "; 
			query = query.format(query, lid, offeringDate);  
			query += "'%Y-%m-%d'); "; 
			this.st.execute(query);
			
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(start); 
			cal.add(Calendar.DATE, 1); 
			start = cal.getTime(); 
		}
		
		return 0;
	}

	public int cancelBooking(String SIN, String bid) throws SQLException {
		String query = "SELECT * FROM renterBookBooking WHERE SIN='%s' AND bid=%s; "; 
		query = query.format(query, SIN, bid); 
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		query = "INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('%s', %s, STR_TO_DATE('%s', "; 
		query = query.format(query, SIN, bid, date); 
		query += "'%Y-%m-%d'));"; 
		this.st.execute(query); 
		
		query = "UPDATE listingOffering SET isAvailable=true WHERE (lid, offeringDate) IN (SELECT lid, offeringDate from bookingAssociatedWithOffering WHERE bid=%s); "; 
		query = query.format(query, bid); 
		this.st.execute(query); 
		
		return 0;
	}

	public int cancelBookingHost(String SIN, String bid) throws SQLException {
		String query = "SELECT * from hostPostListing where SIN='%s' AND lid IN (select lid from bookingAssociatedWithOffering where bid=%s); "; 
		query = query.format(query, SIN, bid); 
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		query = "INSERT INTO hostCancelBooking(SIN, bid, cancelDate) VALUES('%s', %s, STR_TO_DATE('%s', "; 
		query = query.format(query, SIN, bid, date); 
		query += "'%Y-%m-%d'));"; 
		this.st.execute(query); 
		
		query = "UPDATE listingOffering SET isAvailable=true WHERE (lid, offeringDate) IN (SELECT lid, offeringDate from bookingAssociatedWithOffering WHERE bid=%s); "; 
		query = query.format(query, bid); 
		this.st.execute(query); 
		
		return 0;
	}

	public int changeListingAvailability(String SIN, String lid, String offeringDate, String available) throws SQLException {
//		if(isBeforeToday(offeringDate)) return -1; 
		String query = "SELECT * from hostPostListing where SIN = '%s' AND lid=%s ; "; 
		query = query.format(query, SIN, lid); 
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		
		query = "SELECT bid from bookingAssociatedWithOffering WHERE bid NOT IN(select bid from renterCancelBooking) AND bid NOT IN(select bid from hostCancelBooking) "
				+ "AND lid=%s AND offeringDate=STR_TO_DATE('%s', "; 
		query = query.format(query, lid, offeringDate); 
		query += "'%Y-%m-%d'); "; 
		rs = this.st.executeQuery(query); 
		if(rs.next()) {
			return 2; 
		}
		
		query = "SELECT * from listingOffering where lid=%s AND offeringDate=STR_TO_DATE('%s', "; 
		query = query.format(query, lid, offeringDate); 
		query += "'%Y-%m-%d'); "; 
		rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 3; 
		}
		
		query = "UPDATE listingOffering SET isAvailable=%s WHERE lid=%s AND offeringDate=STR_TO_DATE('%s', "; 
		query = query.format(query, available, lid, offeringDate); 
		query += "'%Y-%m-%d'); "; 
		this.st.execute(query); 
		
		return 0;
	}

	public int changeListingPrice(String SIN, String lid, String offeringDate, String price) throws SQLException {
//		if(isBeforeToday(offeringDate)) return -1; 
		String query = "SELECT * from hostPostListing where SIN = '%s' AND lid=%s ; "; 
		query = query.format(query, SIN, lid); 
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		
		query = "SELECT bid from bookingAssociatedWithOffering WHERE bid NOT IN(select bid from renterCancelBooking) AND bid NOT IN(select bid from hostCancelBooking) "
				+ "AND lid=%s AND offeringDate=STR_TO_DATE('%s', "; 
		query = query.format(query, lid, offeringDate); 
		query += "'%Y-%m-%d'); "; 
		rs = this.st.executeQuery(query); 
		if(rs.next()) {
			return 2; 
		}
		
		query = "SELECT * from listingOffering where lid=%s AND offeringDate=STR_TO_DATE('%s', "; 
		query = query.format(query, lid, offeringDate); 
		query += "'%Y-%m-%d'); "; 
		rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 3; 
		}
		
		query = "UPDATE listingOffering SET price=%s WHERE lid=%s AND offeringDate=STR_TO_DATE('%s', "; 
		query = query.format(query, price, lid, offeringDate); 
		query += "'%Y-%m-%d'); "; 
		this.st.execute(query); 
		
		return 0;
	}

	public int renterCommentOnHost(String renter, String host, String rating, String content) throws SQLException {
		String query = "SELECT * FROM renterBookBooking natural join booking natural join bookingAssociatedWithOffering "
				+ "WHERE bid NOT IN (SELECT bid from renterCancelBooking) AND bid NOT IN (SELECT bid FROM hostCancelBooking) "
				+ "AND SIN='%s' AND DATEDIFF(offeringDate, CURDATE())>(-2000) AND DATEDIFF(offeringDate, CURDATE())<0 AND lid IN(SELECT lid FROM hostPostListing WHERE SIN='%s'); "; 
		query = query.format(query, renter, host); 
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		
		query = "INSERT INTO renterCommentOnHost(rating, content, commentDate, renter, host) VALUES(%s, '%s', DATE(NOW()), '%s', '%s'); "; 
		query = query.format(query, rating, content, renter, host); 
		this.st.execute(query); 
		
		return 0;
	}

	public int hostCommentOnRenter(String renter, String host, String rating, String content) throws SQLException {
		String query = "SELECT * FROM renterBookBooking natural join booking natural join bookingAssociatedWithOffering "
				+ "WHERE bid NOT IN (SELECT bid from renterCancelBooking) AND bid NOT IN (SELECT bid FROM hostCancelBooking) "
				+ "AND SIN='%s' AND DATEDIFF(offeringDate, CURDATE())>(-2000) AND DATEDIFF(offeringDate, CURDATE())<0 AND lid IN(SELECT lid FROM hostPostListing WHERE SIN='%s'); "; 
		query = query.format(query, renter, host); 
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		
		query = "INSERT INTO hostCommentOnRenter(rating, content, commentDate, renter, host) VALUES(%s, '%s', DATE(NOW()), '%s', '%s'); "; 
		query = query.format(query, rating, content, renter, host); 
		this.st.execute(query); 
		return 0;
	}

	public int renterCommentOnListing(String SIN, String lid, String rating, String content) throws SQLException {
		String query = "SELECT * FROM renterBookBooking natural join booking natural join bookingAssociatedWithOffering "
				+ "WHERE bid NOT IN (SELECT bid from renterCancelBooking) AND bid NOT IN (SELECT bid FROM hostCancelBooking) "
				+ "AND SIN='%s' AND DATEDIFF(offeringDate, CURDATE())>(-2000) AND DATEDIFF(offeringDate, CURDATE())<0 AND lid=%s; "; 
		query = query.format(query, SIN, lid); 
		ResultSet rs = this.st.executeQuery(query); 
		if(!rs.next()) {
			return 1; 
		}
		
		query = "INSERT INTO renterCommentOnListing(rating, content, commentDate, renter, lid) VALUES(%s, '%s', DATE(NOW()), '%s', %s); "; 
		query = query.format(query, rating, content, SIN, lid); 
		this.st.execute(query); 
		
		return 0;
	}

	public ResultSet findListingByLocation(String latitude, String longitude, String timeWindow, String distance, String priceRank, String amenities, String priceRange) throws SQLException {
		String distanceDefault = "30"; 
		String startDate = ""; 
		String endDate = ""; 
		
		
		if(!distance.equals("")) {
			distanceDefault = distance; 
		}
		
		if(!timeWindow.equals("")) {
			String[] temp = timeWindow.split(","); 
			startDate = temp[0]; 
			endDate = temp[1]; 
		}
		
		String rankStatement = " ORDER BY SQRT(POWER((latitude-%s), 2) + POWER((longitude-%s), 2)) ASC"; 
		rankStatement = rankStatement.format(rankStatement, latitude, longitude); 
		
		String query = "SELECT lid,latitude,longitude,AVG(price), ltype, postalCode, street, apartmentSuite, province, city, country "
				+ "FROM listingOffering NATURAL JOIN listingAtLocation NATURAL JOIN listing NATURAL JOIN listingHasAddress "
				+ "WHERE SQRT(POWER((latitude-%s), 2) + POWER((longitude-%s), 2))<=%s AND isAvailable=true ";
		query = query.format(query, latitude, longitude, distanceDefault); 
		
		if(!timeWindow.equals("")) {
			String temporalFilter = "AND (lid, offeringDate) IN (SELECT lid, offeringDate FROM (SELECT lid FROM listingOffering WHERE isAvailable=true AND offeringDate between '%s' AND '%s' GROUP BY lid HAVING count(offeringDate)>=(DATEDIFF('%s', '%s') + 1)) AS passTemporal NATURAL JOIN listingOffering) "; 
			temporalFilter = temporalFilter.format(temporalFilter, startDate, endDate, endDate, startDate); 
			query += temporalFilter; 
		}
		
		if(!priceRank.equals("")) {
			rankStatement = "ORDER BY AVG(price) " + priceRank; 
		}
		
		if(!priceRange.equals("")) {
			String[] priceRangeArray = priceRange.split(","); 
			String lowerBound = priceRangeArray[0]; 
			String upperBound = priceRangeArray[1]; 
			String priceRangeFilter = "AND (price BETWEEN %s AND %s) ";
			priceRangeFilter = priceRangeFilter.format(priceRangeFilter, lowerBound, upperBound); 
			query += priceRangeFilter; 
		}
		
		if(!amenities.equals("")) {
			String[] amenitiesArray = amenities.split(","); 
			String amenitiesFilter = ""; 
			for(String amenity:amenitiesArray) {
				String newConstraint = "AND lid IN (SELECT lid FROM listingOfferAmenity NATURAL JOIN amenity WHERE amenityDescription='%s') ";
				newConstraint = newConstraint.format(newConstraint, amenity); 
				query += newConstraint; 
			}
		}
		
		query = query + "GROUP BY lid " + rankStatement; 
		
		return this.st.executeQuery(query);
	}

	public ResultSet findListingByPostalCode(String postalCode, String timeWindow, String distance, String priceRank, String amenities, String priceRange) throws SQLException {
		String distanceDefault = "300"; 
		String startDate = ""; 
		String endDate = ""; 
		
		
		if(!distance.equals("")) {
			distanceDefault = distance; 
		}
		
		if(!timeWindow.equals("")) {
			String[] temp = timeWindow.split(","); 
			startDate = temp[0]; 
			endDate = temp[1]; 
		}
		
		String rankStatement = " ORDER BY ABS(HEX(postalCode) - HEX('%s')) ASC"; 
		rankStatement = rankStatement.format(rankStatement, postalCode); 
		
		String query = "SELECT lid,latitude,longitude,AVG(price), ltype, postalCode, street, apartmentSuite, province, city, country "
				+ "FROM listingOffering NATURAL JOIN listingAtLocation NATURAL JOIN listing NATURAL JOIN listingHasAddress "
				+ "WHERE ABS(HEX(postalCode) - HEX('%s'))<=%s AND isAvailable=true ";
		query = query.format(query, postalCode, distanceDefault); 
		
		if(!timeWindow.equals("")) {
			String temporalFilter = "AND (lid, offeringDate) IN (SELECT lid, offeringDate FROM (SELECT lid FROM listingOffering WHERE isAvailable=true AND offeringDate between '%s' AND '%s' GROUP BY lid HAVING count(offeringDate)>=(DATEDIFF('%s', '%s') + 1)) AS passTemporal NATURAL JOIN listingOffering) "; 
			temporalFilter = temporalFilter.format(temporalFilter, startDate, endDate, endDate, startDate); 
			query += temporalFilter; 
		}
		
		if(!priceRank.equals("")) {
			rankStatement = "ORDER BY AVG(price) " + priceRank; 
		}
		
		if(!priceRange.equals("")) {
			String[] priceRangeArray = priceRange.split(","); 
			String lowerBound = priceRangeArray[0]; 
			String upperBound = priceRangeArray[1]; 
			String priceRangeFilter = "AND (price BETWEEN %s AND %s) ";
			priceRangeFilter = priceRangeFilter.format(priceRangeFilter, lowerBound, upperBound); 
			query += priceRangeFilter; 
		}
		
		if(!amenities.equals("")) {
			String[] amenitiesArray = amenities.split(","); 
			String amenitiesFilter = ""; 
			for(String amenity:amenitiesArray) {
				String newConstraint = "AND lid IN (SELECT lid FROM listingOfferAmenity NATURAL JOIN amenity WHERE amenityDescription='%s') ";
				newConstraint = newConstraint.format(newConstraint, amenity); 
				query += newConstraint; 
			}
		}
		
		query = query + "GROUP BY lid " + rankStatement; 
		
		return this.st.executeQuery(query);
	}

	public ResultSet findListingByAddress(String postalCode, String street, String province, String city, String country, 
		String apartmentSuite, String timeWindow, String amenities, String priceRange) throws SQLException {
		String startDate = ""; 
		String endDate = ""; 
		
		if(!timeWindow.equals("")) {
			String[] temp = timeWindow.split(","); 
			startDate = temp[0]; 
			endDate = temp[1]; 
		}
		
		String query = "SELECT lid,latitude,longitude,AVG(price), ltype, postalCode, street, apartmentSuite, province, city, country "
				+ "FROM listingOffering NATURAL JOIN listingAtLocation NATURAL JOIN listing NATURAL JOIN listingHasAddress "
				+ "WHERE postalCode='%s' AND street='%s' AND province='%s' AND city='%s' AND country='%s' AND apartmentSuite=%s AND isAvailable=true ";
		query = query.format(query, postalCode, street, province, city, country, apartmentSuite); 
		
		if(!timeWindow.equals("")) {
			String temporalFilter = "AND (lid, offeringDate) IN (SELECT lid, offeringDate FROM (SELECT lid FROM listingOffering WHERE isAvailable=true AND offeringDate between '%s' AND '%s' GROUP BY lid HAVING count(offeringDate)>=(DATEDIFF('%s', '%s') + 1)) AS passTemporal NATURAL JOIN listingOffering) "; 
			temporalFilter = temporalFilter.format(temporalFilter, startDate, endDate, endDate, startDate); 
			query += temporalFilter; 
		}
		
		if(!priceRange.equals("")) {
			String[] priceRangeArray = priceRange.split(","); 
			String lowerBound = priceRangeArray[0]; 
			String upperBound = priceRangeArray[1]; 
			String priceRangeFilter = "AND (price BETWEEN %s AND %s) ";
			priceRangeFilter = priceRangeFilter.format(priceRangeFilter, lowerBound, upperBound); 
			query += priceRangeFilter; 
		}
		
		if(!amenities.equals("")) {
			String[] amenitiesArray = amenities.split(","); 
			String amenitiesFilter = ""; 
			for(String amenity:amenitiesArray) {
				String newConstraint = "AND lid IN (SELECT lid FROM listingOfferAmenity NATURAL JOIN amenity WHERE amenityDescription='%s') ";
				newConstraint = newConstraint.format(newConstraint, amenity); 
				query += newConstraint; 
			}
		}
		
		query = query + "GROUP BY lid "; 
		
		return this.st.executeQuery(query);
	}

	public ResultSet reportNumberOfBookingsByCity(String timeWindow) throws SQLException {
		String startDate = ""; 
		String endDate = ""; 
		
		if(!timeWindow.equals("")) {
			String[] temp = timeWindow.split(","); 
			startDate = temp[0]; 
			endDate = temp[1]; 
		}
		
		String query = "SELECT city, count(bid) FROM bookingAssociatedWithOffering NATURAL JOIN listingOffering NATURAL JOIN listingHasAddress "; 
		
		if(!timeWindow.equals("")) {
			String temporalFilter = "WHERE offeringDate between '%s' AND '%s' "; 
			temporalFilter = temporalFilter.format(temporalFilter, startDate, endDate); 
			query += temporalFilter; 
		}
		
		query = query + "GROUP BY city "; 
		
		return this.st.executeQuery(query); 
	}

	public ResultSet reportNumberOfBookingsByCityAndPostalCode(String city, String timeWindow) throws SQLException {
		String startDate = ""; 
		String endDate = ""; 
		
		if(!timeWindow.equals("")) {
			String[] temp = timeWindow.split(","); 
			startDate = temp[0]; 
			endDate = temp[1]; 
		}
		
		String query = "SELECT postalCode, count(bid) FROM bookingAssociatedWithOffering NATURAL JOIN listingOffering NATURAL JOIN listingHasAddress WHERE city='%s' "; 
		query = query.format(query, city); 
		
		if(!timeWindow.equals("")) {
			String temporalFilter = "AND offeringDate between '%s' AND '%s' "; 
			temporalFilter = temporalFilter.format(temporalFilter, startDate, endDate); 
			query += temporalFilter; 
		}
		
		query = query + "GROUP BY postalCode "; 
		
		return this.st.executeQuery(query); 
	}

	public ResultSet reportNumberOfListingsByCountry() throws SQLException {
		String query = "SELECT country, count(lid) FROM listing NATURAL JOIN listingHasAddress GROUP BY country"; 
		return this.st.executeQuery(query);
	}

	public ResultSet reportNumberOfListingsByCountryAndCity() throws SQLException {
		String query = "SELECT country, city, count(lid) FROM listing NATURAL JOIN listingHasAddress GROUP BY country, city"; 
		return this.st.executeQuery(query);
	}

	public ResultSet reportNumberOfListingsByCountryAndCityAndPostalCode() throws SQLException {
		String query = "SELECT country, city, postalCode, count(lid) FROM listing NATURAL JOIN listingHasAddress GROUP BY country, city, postalCode"; 
		return this.st.executeQuery(query);
	}

	public ResultSet rankHostsByCountryCity(String country, String city) throws SQLException {
		String query = "SELECT SIN, uname, count(lid) FROM user NATURAL JOIN host NATURAL JOIN hostPostListing NATURAL JOIN listingHasAddress WHERE country='%s' ";
		query = query.format(query, country); 
		
		if(!city.equals("")) {
			String cityConstraint = "AND city='%s' "; 
			cityConstraint = cityConstraint.format(cityConstraint, city); 
			query += cityConstraint; 
		}
		
		query += "GROUP BY SIN ORDER BY count(lid) DESC"; 
		
		return this.st.executeQuery(query);
	}

	public ResultSet reportCommercialHosts(String country, String city) throws SQLException {
		String query = "SELECT SIN, uname, count(lid)/(SELECT count(lid) FROM listingHasAddress WHERE country='%s' AND city='%s' GROUP BY country, city) as ratio FROM user NATURAL JOIN host NATURAL JOIN hostPostListing NATURAL JOIN listingHasAddress WHERE country ='%s' AND city='%s' "
				+ "GROUP BY SIN HAVING count(lid)/(SELECT count(lid) FROM listingHasAddress WHERE country='%s' AND city='%s' GROUP BY country, city) > 0.1"; 
		query = query.format(query, country, city, country, city, country, city); 
		return this.st.executeQuery(query);
	}

	public ResultSet rankRentersByBookings(String timeWindow, String city) throws SQLException {
		String startDate = ""; 
		String endDate = ""; 
		
		String[] temp = timeWindow.split(","); 
		startDate = temp[0]; 
		endDate = temp[1]; 
		
		
		String query = "SELECT SIN, uname, count(bid) FROM user NATURAL JOIN renter NATURAL JOIN renterBookBooking NATURAL JOIN bookingAssociatedWithOffering NATURAL JOIN listingHasAddress "; 
		String temporalFilter = "WHERE offeringDate between '%s' AND '%s' "; 
		temporalFilter = temporalFilter.format(temporalFilter, startDate, endDate); 
		query += temporalFilter; 
		
		if(!city.equals("")) {
			String cityConstraint = "AND city='%s' "; 
			cityConstraint = cityConstraint.format(cityConstraint, city); 
			query += cityConstraint; 
		}
		
		
		query = query + "GROUP BY SIN "; 
		
		if(!city.equals("")) {
			query += "HAVING count(bid) >= 2 "; 
		}
		
		query += "ORDER BY count(bid) DESC "; 
		
		return this.st.executeQuery(query); 
	}

	public ResultSet reportHostsWithLargestCancellations() throws SQLException {
		String query = "SELECT SIN, uname, count(bid) FROM user NATURAL JOIN host NATURAL JOIN hostCancelBooking GROUP BY SIN HAVING count(bid) >= all(select count(bid) FROM HOST NATURAL JOIN hostCancelBooking GROUP BY SIN) "; 
		return this.st.executeQuery(query); 
	}

	public ResultSet reportRentersWithLargestCancellations() throws SQLException {
		String query = "SELECT SIN, uname, count(bid) FROM user NATURAL JOIN renter NATURAL JOIN renterCancelBooking GROUP BY SIN HAVING count(bid) >= all(select count(bid) FROM renter NATURAL JOIN renterCancelBooking GROUP BY SIN) "; 
		return this.st.executeQuery(query);
	}

	public ResultSet findBookingByLid(String lid) throws SQLException {
		String query = "SELECT SIN, uname, bid, offeringDate, lid FROM user NATURAL JOIN renterBookBooking NATURAL JOIN bookingAssociatedWithOffering WHERE lid=%s AND bid NOT IN (SELECT bid FROM renterCancelBooking) AND bid NOT IN (SELECT bid FROM hostCancelBooking) ORDER BY bookDate DESC"; 
		query = query.format(query, lid); 
		return this.st.executeQuery(query); 
	}

	public ResultSet findBookingBySIN(String SIN) throws SQLException {
		String query = "SELECT SIN, uname, bid, offeringDate, lid FROM user NATURAL JOIN renterBookBooking NATURAL JOIN bookingAssociatedWithOffering WHERE SIN='%s' AND bid NOT IN (SELECT bid FROM renterCancelBooking) AND bid NOT IN (SELECT bid FROM hostCancelBooking) ORDER BY bookDate DESC"; 
		query = query.format(query, SIN); 
		return this.st.executeQuery(query); 
	}

	public ResultSet findCommentsByLid(String lid) throws SQLException {
		String query = "SELECT SIN, uname, rating, content, commentDate FROM user u JOIN renterCommentOnListing r ON u.SIN=r.renter WHERE r.lid=%s ORDER BY r.commentDate DESC"; 
		query = query.format(query, lid); 
		return this.st.executeQuery(query); 
	}

	public ResultSet findCommentsBySIN(String SIN) throws SQLException {
		String query = "SELECT SIN, uname, rating, content, commentDate FROM user u JOIN renterCommentOnHost r ON u.SIN=r.renter WHERE r.host=%s ORDER BY r.commentDate DESC"; 
		query = query.format(query, SIN); 
		return this.st.executeQuery(query); 
	}

	public double suggestPriceForListing(String SIN, String latitude, String longitude) throws SQLException {
		String query = "SELECT * FROM hostPostListing WHERE SIN='%s'"; 
		query = query.format(query, SIN); 
		ResultSet rs = this.st.executeQuery(query); 
		if(rs.next()) {
			return -1; //User has done this before
		}

		query = "SELECT AVG(price) FROM listingOffering NATURAL JOIN listingAtLocation WHERE SQRT(POWER((latitude-%s), 2) + POWER((latitude-%s), 2)) < 30";
		query = query.format(query, latitude, longitude); 
		rs = this.st.executeQuery(query); 
		
		if(rs.next()) {
			return rs.getDouble("AVG(price)"); 
		}
		return 0; 
	}

	public ResultSet suggestAmenitiesForListing(String SIN, String latitude, String longitude) throws SQLException {

		String query = "SELECT DISTINCT amenityDescription FROM (SELECT lid, count(bid) FROM bookingAssociatedWithOffering NATURAL JOIN listingOffering NATURAL JOIN listingAtLocation "
				+ "WHERE SQRT(POWER(latitude-%s, 2) + POWER(latitude-%s, 2)) < 30 GROUP BY lid ORDER BY count(bid) DESC LIMIT 5) AS T NATURAL JOIN listingOfferAmenity NATURAL JOIN amenity";
		query = query.format(query, latitude, longitude); 
		return this.st.executeQuery(query); 
	}

	public List getTopNps(ArrayList<String> nps) throws SQLException {
		List topNps = new ArrayList<String>(); 
		
		String query = "DROP TABLE IF EXISTS nounPhrase ";  
		this.st.execute(query); 
		
		query = "CREATE TABLE nounPhrase(nounId INT AUTO_INCREMENT PRIMARY KEY, phrase TEXT NOT NULL)"; 
		this.st.execute(query); 
		
		for(String np: nps) {
//			if(!np.equals("I") && !np.equals("i")) {				
				query = "INSERT INTO nounPhrase(phrase) VALUES('%s')"; 
				query = query.format(query, np); 
				this.st.execute(query); 
//			}
		}
		
		query = "SELECT phrase FROM nounPhrase WHERE phrase NOT LIKE 'I ' AND phrase NOT LIKE 'you ' AND phrase NOT LIKE 'we ' AND phrase NOT LIKE 'me ' AND "
				+ "phrase NOT LIKE 'us ' AND phrase NOT Like 'he ' AND phrase NOT LIKE 'she '"
				+ " GROUP BY phrase ORDER BY count(nounId) DESC LIMIT 10"; 
		ResultSet rs = this.st.executeQuery(query); 
		
		while(rs.next()) {
			topNps.add(rs.getString("phrase")); 
		}
		
		return topNps; 
	}

	

    
}
