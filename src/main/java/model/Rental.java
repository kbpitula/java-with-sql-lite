package model;

public class Rental {

	private int idCustomer;
	private int idMovie;
	
	public Rental(int idRental, int idCustomer, int idMovie) {
		this.idCustomer = idCustomer;
		this.idMovie = idMovie;
	}
	
	public void setIdCustomer(int id) {
		this.idCustomer = id;
	}
	
	public int setIdCustomer() {
		return this.idCustomer;
	}
	
	public void setIdMovie(int id) {
		this.idMovie = id;
	}
	
	public int setIdMovie() {
		return this.idMovie;
	}
}
