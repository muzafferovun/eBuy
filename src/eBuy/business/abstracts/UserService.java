package eBuy.business.abstracts;
import eBuy.entities.concretes.User;

public interface UserService {
	User userRegister(String email,String password,String name,String surname);
	User  userAuthenticate(String autCode);
	boolean checkUserRegistration();
	void userLogin(String email,String Password);
	User userUpdate(User user,String email,String password);
	void userDelete(User user);
	void userRegisterForUsers();
	User getUser();
	boolean checkEmail(String email);
	boolean checkName(String name);
	boolean checkSurname(String surname);
	boolean checkPassword(String password);
	
}
