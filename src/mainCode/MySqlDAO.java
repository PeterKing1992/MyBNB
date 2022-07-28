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

    public boolean postUser(String sin, String occupation, String uname, String password, String bday, String city, String country, String postalCode) throws SQLException, ParseException {
        if(!isAdult(bday)) return false; 
    	
    	String query = "INSERT INTO user(SIN, uoccupation, uname, password, birthday) VALUES('%s', '%s', '%s', '%s', STR_TO_DATE('%s', "; 
        query = query.format(query, sin, occupation, uname, password, bday); 
        query+= "'%Y-%m-%d')); "; 
        this.st.execute(query); 
        query = "INSERT INTO host(SIN) VALUES(%s); "; 
       	query = query.format(query, sin); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO address(postalCode, city, country) VALUES('%s', '%s', '%s'); "; 
       	query = query.format(query, postalCode, city, country); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO userHasAddress(SIN, postalCode, city, country) VALUES('%s', '%s', '%s', '%s'); "; 
       	query = query.format(query, sin, postalCode, city, country); 
       	this.st.execute(query); 
       	
       	return true; 
    }
    
    public boolean postUser(String sin, String occupation, String uname, String password, String bday, String paymentType, String cardNumber, String city, String country, String postalCode) throws SQLException, ParseException {
        if(!isAdult(bday)) return false; 
    	
    	String query = "INSERT INTO user(SIN, uoccupation, uname, password, birthday) VALUES('%s', '%s', '%s', '%s', STR_TO_DATE('%s', "; 
    	query+= "'%Y-%m-%d')); "; 
        query = query.format(query, sin, occupation, uname, password, bday); 
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
       	
       	query = "INSERT INTO address(postalCode, city, country) VALUES('%s', '%s', '%s'); "; 
       	query = query.format(query, postalCode, city, country); 
       	this.st.execute(query); 
       	
       	query = "INSERT INTO userHasAddress(SIN, postalCode, city, country) VALUES('%s', '%s', '%s', '%s'); "; 
       	query = query.format(query, sin, postalCode, city, country); 
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
    	
    	query = "CREATE TABLE IF NOT EXISTS address(postalCode char(6), city varchar(50), country varchar(50), "
    			+ "PRIMARY KEY(postalCode, city, country)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS userHasAddress(SIN char(9) PRIMARY KEY, postalCode char(6) NOT NULL, city varchar(50) NOT NULL, country varchar(50) NOT NULL, "
    			+ "FOREIGN KEY(postalCode, city, country) REFERENCES address(postalCode, city, country) ON DELETE CASCADE, "
    			+ "UNIQUE(postalCode, city, country), "
    			+ "FOREIGN KEY(SIN) REFERENCES user(SIN) ON DELETE CASCADE); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS listing(lType varchar(50) NOT NULL, lid INT AUTO_INCREMENT PRIMARY KEY); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS hostPostListing(SIN char(9) UNIQUE, lid INT, postDate date NOT NULL, "
    			+ "FOREIGN KEY(SIN) REFERENCES host(SIN) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "PRIMARY KEY(lid)); "; 
    	this.st.execute(query); 
    	
    	query = "CREATE TABLE IF NOT EXISTS listingHasAddress(lid INT, city varchar(50), country varchar(50), postalCode char(6), "
    			+ "FOREIGN KEY(lid) REFERENCES listing(lid) ON DELETE CASCADE, "
    			+ "FOREIGN KEY(postalCode, city, country) REFERENCES address(postalCode, city, country) ON DELETE CASCADE, "
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
    	
    	System.out.println("Created Database");
    }

	public boolean deleteUser(String sin) {
		String query = "DELETE FROM user WHERE SIN='%s'"; 
		query = query.format(query, sin); 
		try {
			this.st.execute(query);
		} catch (SQLException e) {
			return false; 
		} 
		return true;
	}

	public boolean postListing(String SIN, String type, String city, String country, String postalCode, String latitude, String longitude) throws SQLException {
		String query = "INSERT INTO listing(ltype) VALUE('%s') RETURNING lid; "; 
		query = query.formatted(query, type); 
		this.st.execute(query); 
		
		
		return false;
	}

    
}
