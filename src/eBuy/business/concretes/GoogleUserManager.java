package eBuy.business.concretes;

import java.util.regex.Pattern;

import eBuy.business.abstracts.UserService;
import eBuy.core.concretes.Utils;
import eBuy.dataAccess.abstracts.UserDao;
import eBuy.entities.concretes.User;

public class GoogleUserManager extends BaseUserManager implements UserService {
	
	public GoogleUserManager(UserDao userDao) {
		super(userDao);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public User userRegister(String email, String password, String name, String surname) {
		// TODO Auto-generated method stub
		if(!checkEmail(email)) return null;
		if(!checkPassword(email)) return null;
		int maxid=0;
		for(User user:super.users) {
			if(user.getId()>maxid) maxid=user.getId();
		}
		maxid++;
		
		
		   String metin = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                  + "0123456789"
	                  + "abcdefghijklmnopqrstuvxyz"; 
	 
	    StringBuilder sb = new StringBuilder(6); 
	 
	    for (int i = 0; i < 6; i++) { 
	      int index= (int)(metin.length()* Math.random()); 
	      sb.append(metin.charAt(index)); 
	    } 
	    String registrationcode=sb.toString();
		
		User newUser=new User(maxid, email, password, name, surname,registrationcode , true);
		super.users.add(newUser);
		this.user=newUser;
		Utils.RunLoggers(loggerManager.log("User"),"Do�rulama kodu olarak '"+registrationcode+"' g�nderildi");
		return newUser;
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub

		for(User user:super.users) {
			if(user.geteMail()==email) {
				Utils.RunLoggers(loggerManager.log("User"),email+" Adresi ile hatal� Kay�t denemesi");
				return false;
			}
		}
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		if(Pattern.matches(regex, email)==false){
				Utils.RunLoggers(loggerManager.log("User"),email+" adresi tan�ms�z karakter i�ermektedir");
			return false;
			
		} 
		return true;
	}
	@Override
	public boolean checkPassword(String password) {
		// TODO Auto-generated method stub
		if(password.length()>1) return true;
		super.loggerManager.log(" �ifreniz en az 6 karakterden olu�mal�");
		
		return false;
	}
	
	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		if(name.length()>1) return true;
		super.loggerManager.log(" Ad alan� en az 2 karakter olmal� ");
		
		return false;
	}
	@Override
	public boolean checkSurname(String surname) {
		// TODO Auto-generated method stub
		if(surname.length()>1) return true;
		super.loggerManager.log(" Soyad alan� en az 2 karakter olmal� ");
		
		return false;
	}
		
	public User userRegister(UserService user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User userAuthenticate(String autCode) {
		// TODO Auto-generated method stub
		if(super.user.getRegistrationCode().equals(autCode) ) {
			super.user.setRegistration(true);
			Utils.RunLoggers(loggerManager.log("User"),super.user.geteMail()+ " Sisteme giri� yapt� ");
		}
		
		return this.user;
	}

	@Override
	public void userLogin(String email, String Password) {
		// TODO Auto-generated method stub
		super.userLogin(email, Password);
	
	}
	@Override
	public boolean checkUserRegistration() {
		
	
		return false;
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

}
