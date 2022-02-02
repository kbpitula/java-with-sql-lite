package model;

public class Customer {

	private int id;
	private String name;
	private int idNumber;
	
	public Customer(int id, String name, int idNumber) {
		this.id = id;
		this.name = name;
		this.idNumber = idNumber;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
	public void getIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
}
