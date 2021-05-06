package eBuy.entities.concretes;

public class User {
	private int id;
	private String eMail;
	private String password;
	private boolean registration;
	private String registrationCode;
	private String name;
	private String surname;
	public User(int id, String eMail, String password, String name,String surname, String registrationCode, boolean registration) {
		super();
		this.id = id;
		this.eMail = eMail;
		this.password = password;
		this.registration = registration;
		this.registrationCode = registrationCode;
		this.name = name;
		this.surname = surname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRegistration() {
		return registration;
	}
	public void setRegistration(boolean registration) {
		this.registration = registration;
	}
	public String getRegistrationCode() {
		return registrationCode;
	}
	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
