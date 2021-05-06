package eBuy.business.concretes;

import java.util.ArrayList;

import eBuy.core.concretes.LoggerManager;
import eBuy.core.concretes.Utils;
import eBuy.dataAccess.abstracts.UserDao;
import eBuy.business.abstracts.UserService;
import eBuy.core.abstracts.Logger;
import eBuy.entities.concretes.User;

public class BaseUserManager implements UserService {
	public User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<User> users;
	public LoggerManager loggerManager;
	public UserDao userDao;

	public BaseUserManager(UserDao userDao) {
		this.userDao=userDao;
		loggerManager=new LoggerManager();
		this.users=new ArrayList<User>(0);
		
		users.add(new User(1,"muzafferovun@hotmail.com", "124556", "Muzaffer", "Övün", "1234", false));
		users.add(new User(2,"mustafa_kus@hotmail.com", "123456", "Mustafa", "Kuþ", "123456", true));
		users.add(new User(3,"engindemirog@kodlama.io", "123456", "Engin", "Demiroð", "", true));
	}
	@Override
	public void userRegisterForUsers() {
		// TODO Auto-generated method stub
	}
	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		for(User user:this.users) {
			if(user.geteMail()==email) return false;
		}
		return true;
	}
	@Override
	public boolean checkPassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean checkSurname(String surname) {
		// TODO Auto-generated method stub
		return false;
	}
		
	public User userRegister(UserService user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  User userAuthenticate(String autCode) {
		// TODO Auto-generated method stub
		return null;
	}


	public void userLogin(String email, String password) {
		System.out.println(email);
		for(User nuser:this.users) {
			if(nuser.geteMail()==email&&nuser.getPassword()==password ) {
				
				this.setUser(nuser);
				Utils.RunLoggers(loggerManager.log("User"),nuser.geteMail()+ " Sisteme giriþ yaptý ");
				
			}
		}
		
		
	}

	@Override
	public User userUpdate(User user, String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void userDelete(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User userRegister(String email, String password, String name, String surname) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean checkUserRegistration() {
		// TODO Auto-generated method stub
		return false;
	}

}
