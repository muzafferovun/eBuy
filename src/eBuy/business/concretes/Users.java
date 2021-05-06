package eBuy.business.concretes;

import java.util.List;

import eBuy.business.abstracts.UserService;
import eBuy.entities.concretes.User;

public class Users {
	public Users() {
	}
	private User addUser(int id,String email,String password,String name, String surname,boolean authentication,String authenticationCode) {
		return (new User(1,email, password, name, surname, authenticationCode, authentication));
	}
	
}
