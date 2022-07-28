package mainCode;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period; 

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

	//DROP database cscc43_project; CREATE database cscc43_project; 
	//GRANT select, create, alter, drop, references on cscc43_project.* to 'user'@'localhost';
	
	// *** implement database operations here *** //

    public boolean postUser(String sin, String occupation, String uname, String password, String bday, String city, String country, String postalCode, String apartmentSuite) throws SQLException, ParseException {
        if(!isAdult(bday)) return false; 
    	
    	String query = "INSERT INTO user(SIN, uoccupation, uname, password, birthday) VALUES('%s', '%s', '%s', '%s', STR_TO_DATE('%s', "; 
        query = query.format(query, sin, occupation, uname, password, bday); 
        query+= "'%Y-%m-%d')); "; 
        this.st.execute(query); 
        query = "INSERT INTO host(SIN) VALUES(%s); "; 
       	query = query.format(query, sin); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO address(postalCode, city, country, apartmentSuite) VALUES('%s', '%s', '%s', %s); "; 
       	query = query.format(query, postalCode, city, country, apartmentSuite); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO userHasAddress(SIN, postalCode, city, country, apartmentSuite) VALUES('%s', '%s', '%s', '%s', %s); "; 
       	query = query.format(query, sin, postalCode, city, country, apartmentSuite); 
       	this.st.execute(query); 
       	
       	return true; 
    }
    
    public boolean postUser(String sin, String occupation, String uname, String password, String bday, String paymentType, String cardNumber, String city, String country, String postalCode, String apartmentSuite) throws SQLException, ParseException {
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
       	
       	query = "INSERT INTO address(postalCode, city, country, apartmentSuite) VALUES('%s', '%s', '%s', %s); "; 
       	query = query.format(query, postalCode, city, country, apartmentSuite); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO userHasAddress(SIN, postalCode, city, country, apartmentSuite) VALUES('%s', '%s', '%s', '%s', %s); "; 
       	query = query.format(query, sin, postalCode, city, country, apartmentSuite); 
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
    	
    	query = "CREATE TABLE IF NOT EXISTS address(postalCode char(6), city varchar(50), country varchar(50), apartmentSuite INT, "
    			+ "PRIMARY KEY(postalCode, city, country, apartmentSuite)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS userHasAddress(SIN char(9) PRIMARY KEY, postalCode char(6) NOT NULL, city varchar(50) NOT NULL, country varchar(50) NOT NULL, apartmentSuite INT, "
    			+ "FOREIGN KEY(postalCode, city, country, apartmentSuite) REFERENCES address(postalCode, city, country, apartmentSuite) ON DELETE CASCADE, "
    			+ "UNIQUE(postalCode, city, country), "
    			+ "FOREIGN KEY(SIN) REFERENCES user(SIN) ON DELETE CASCADE); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS listing(lType varchar(50) NOT NULL, lid INT AUTO_INCREMENT PRIMARY KEY); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS hostPostListing(SIN char(9), lid INT, postDate date NOT NULL, "
    			+ "FOREIGN KEY(SIN) REFERENCES host(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(lid)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS listingHasAddress(lid INT, city varchar(50), country varchar(50), postalCode char(6), apartmentSuite INT, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(postalCode, city, country, apartmentSuite) REFERENCES address(postalCode, city, country, apartmentSuite) ON DELETE CASCADE, "
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
    	
    	query = "CREATE TABLE IF NOT EXISTS listingOffering(lid INT, offeringDate date, price double NOT NULL, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(lid, offeringDate)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS booking(bid INT AUTO_INCREMENT PRIMARY KEY); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS bookingAssociatedWithOffering(bid INT, lid INT NOT NULL, offeringDate date NOT NULL, "
    			+ "FOREIGN KEY(lid, offeringDate) REFERENCES listingOffering(lid, offeringDate) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(bid) REFERENCES booking(bid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(bid)); "; 
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
			
			query = "DELETE FROM address WHERE (postalCode, city, country, apartmentSuite) IN (select postalCode, city, country, apartmentSuite "
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

	public boolean postListing(String SIN, String type, String city, String country, String postalCode, String apartmentSuite, String latitude, String longitude) throws SQLException {
		String query = "INSERT INTO listing(ltype) VALUES('%s'); "; 
		query = query.format(query, type); 
		this.st.execute(query); 
		
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		query = "INSERT INTO hostPostListing(SIN, lid, postDate) VALUES('%s', last_insert_id(), STR_TO_DATE('%s', "; 
		query = query.format(query, SIN, date); 
		query += "'%Y-%m-%d'));"; 
		this.st.execute(query); 
		
		query = "INSERT INTO address(postalCode, city, country, apartmentSuite) VALUEs('%s', '%s', '%s', %s); "; 
		query = query.format(query, postalCode, city, country, apartmentSuite); 
		this.st.execute(query); 
		
		query = "INSERT INTO listingHasAddress(lid, postalCode, city, country, apartmentSuite) VALUEs(last_insert_id(), '%s', '%s', '%s', %s); "; 
		query = query.format(query, postalCode, city, country, apartmentSuite); 
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
		
		query = "DELETE FROM address WHERE (postalCode, city, country, apartmentSuite) IN (select postalCode, city, country, apartmentSuite FROM listingHasAddress WHERE lid=%s) "; 
		query = query.format(query, lid);  
		this.st.execute(query);
		
		query = "DELETE FROM location WHERE (latitude, longitude) IN (select latitude, longitude FROM listingAtLocation WHERE lid=%s) "; 
		query = query.format(query, lid);  
		this.st.execute(query);
		
		query = "DELETE FROM listing WHERE lid=%s "; 
		query = query.format(query, lid);  
		this.st.execute(query);
		
		return 0;
	}

	public int addListingOffering(String SIN, String lid, String offeringDate, String price) throws SQLException {
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

	public int bookListing(String SIN, String lid, String offeringDate) throws SQLException {
		String query = "select * from bookingAssociatedWithOffering WHERE lid=%s AND offeringDate=STR_TO_DATE('%s', "; 
		query = query.format(query, lid, offeringDate);  
		query += "'%Y-%m-%d') AND bid NOT IN (select bid from renterCancelBooking) AND bid NOT IN (select bid from hostCancelBooking); "; 
		ResultSet rs = this.st.executeQuery(query); 
		if(rs.next()) {
			return 1; 
		}

		query = "select * from listingOffering WHERE lid=%s AND offeringDate=STR_TO_DATE('%s', "; 
		query = query.format(query, lid, offeringDate);  
		query += "'%Y-%m-%d'); "; 
		rs = this.st.executeQuery(query); 

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
		
		query = "INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), %s, STR_TO_DATE('%s', ";
		query = query.format(query, lid, offeringDate); 
		query += "'%Y-%m-%d'));"; 
		this.st.execute(query);
		
		return 0;
	}

    
}
