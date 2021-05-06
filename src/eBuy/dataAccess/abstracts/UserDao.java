package eBuy.dataAccess.abstracts;

public interface UserDao{
	void addUser(int id,String email,String password,String name,String registration,String registrationCode);
	void userRegistration(int id,String registration);
}
