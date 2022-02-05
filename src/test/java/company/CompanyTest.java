package company;

import java.util.List;

import company.Company;
import model.Customer;
import model.Movie;

/**
 * Test class to add and select data form DB.
 */
public class CompanyTest {

	public static void main(String[] args) {
		Company b = new Company();
		// Add customers
		b.insertCustomer("John B.", 335512312);
		b.insertCustomer("Lucy L.", 213122230);
		b.insertCustomer("Bob T.", 231232220);
		
		// Add Movies to db
		b.insertMovie("Lord Of The Rings", "Peter Jackson");
		b.insertMovie("The Godfather", "Francis Coppola");
		b.insertMovie("Sami swoi", "Sylwester Chęciński");
		
		List<Customer> customer = b.selectCustomer();
		List<Movie> movie = b.selectMovie();
		
		System.out.println("List of customer: ");
		for(Customer c: customer) {
			assert c != null;
			System.out.println("Id: " + c.getId() + " Name: " + c.getName() + " Id Number: " +c.getIdNumber());
		}
		
		System.out.println("List of Movies: ");
		for(Movie m: movie) {
			assert m != null;
			System.out.println("Id: " + m.getId() + " Name: " + m.getName() + " Author: " + m.getAuthor());
		}
	}
}
