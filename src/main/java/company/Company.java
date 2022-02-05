package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.Customer;
import model.Movie;

public class Company {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:company.db";
	
	private Connection conn;
	private Statement stat;
	
	public Company() {
		try {
			Class.forName(Company.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("No driver JDBC");
			e.printStackTrace();;
		}
		
		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Problem with connection");
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * This method create tables of company ( Movie Rental ).
	 * 
	 * @return true - if tables created.
	 */
	public boolean createTables() {
		String createCustomer = "CREATE TABLE IF NOT EXISTS customer (id_customer INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), idNumber int)";
		String createMovie = "CREATE TABLE IF NOT EXISTS movie (id_movie INTEGER PRIMARY KEY AUTOINCREMENT, namne varchar(255), author varchar(255))";
		String createRental = "CREATE TABLE IF NOT EXISTS rental (id_rental INTEGER PRIMARY KEY AUTOINCREMENT, id_customer int, id_movie int)";
		
		try {
			stat.execute(createCustomer);
			stat.execute(createMovie);
			stat.execute(createRental);
		} catch (SQLException e) {
			System.err.println("Error during creating table");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This method insert the customer to DB.
	 * 
	 * @param name - name of customer.
	 * @param idNumber - id number.
	 * @return true - if method insert data to DB.
	 */
	public boolean insertCustomer(String name, int idNumber) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("insert into customer values (NULL, ?, ?);");
			prepStmt.setString(1, name);
			prepStmt.setInt(2, idNumber);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Insert customer error");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This method insert the movie to DB.
	 * 
	 * @param name - name of movie.
	 * @param author - author of movie.
	 * @return true - if method insert data to DB.
	 */
	public boolean insertMovie(String name, String author) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("insert into customer values (NULL, ?, ?);");
			prepStmt.setString(1, name);
			prepStmt.setString(2, author);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Insert movie error");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This method insert the rental to DB.
	 * 
	 * @param idCustomer - id of customer.
	 * @param idMovie - id of movie.
	 * @return true - if method insert data to DB.
	 */
	public boolean insertRental(int idCustomer, int idMovie) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("insert into customer values (NULL, ?, ?);");
			prepStmt.setInt(1, idCustomer);
			prepStmt.setInt(2, idMovie);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Insert rental error");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Get all customers from DB.
	 * 
	 * @return list of customers.
	 */
	public List<Customer> selectCustomer() {
		List<Customer> customer = new LinkedList<Customer>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM customer");
			int id;
			String name;
			int idNumber;
			while(result.next()) {
				id = result.getInt("id_customer");
				name = result.getString("name");
				idNumber = result.getInt("idNumber");
				customer.add(new Customer(id, name, idNumber));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return customer;
	}
	
	/**
	 * Get all movie from DB.
	 * 
	 * @return list of movies.
	 */
	public List<Movie> selectMovie() {
		List<Movie> movieList = new LinkedList<Movie>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM movie");
			int id;
			String name;
			String author;
			while(result.next()) {
				id = result.getInt("id_movie");
				name = result.getString("name");
				author = result.getString("author");
				movieList.add(new Movie(id, name, author));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return movieList;
	}
	
	/**
	 * Close connection.
	 */
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Error with close connection");
			e.printStackTrace();
		}
	}
}
