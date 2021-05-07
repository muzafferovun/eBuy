package eBuy.business.concretes;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eBuy.core.concretes.Utils;
import eBuy.dataAccess.abstracts.UserDao;
import eBuy.entities.concretes.User;
import eBuy.business.abstracts.UserService;
import eBuy.core.concretes.LoggerManager;

public class LocalUserManager extends BaseUserManager implements UserService {
	
	public LocalUserManager(UserDao userDao) {
		super(userDao);
	}
	
	@Override
	public User userRegister(String email, String password, String name, String surname) {
		// TODO Auto-generated method stub
		if(!checkEmail(email)) return null;
		if(!checkPassword(password)) return null;
		if(!checkName(name)) return null;
		if(!checkSurname(surname)) return null;
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
		
		User newUser=new User(maxid, email, password, name, surname,registrationcode , false);
		super.users.add(newUser);
		
		this.user=newUser;
		this.userDao.addUser(maxid, email, password, surname, registrationcode, "false");
		Utils.RunLoggers(loggerManager.log("User"),"Doðrulama kodu olarak '"+registrationcode+"' gönderildi");
		return newUser;
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub

		for(User user:super.users) {
			if(user.geteMail()==email) {
				Utils.RunLoggers(loggerManager.log("User"),email+" Adresi ile hatalý Kayýt denemesi");
				return false;
			}
		}
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		if(Pattern.matches(regex, email)==false){
				Utils.RunLoggers(loggerManager.log("User"),email+" adresi tanýmsýz karakter içermektedir");
			return false;
			
		} 
		return true;
	}
	@Override
	public boolean checkPassword(String password) {
		// TODO Auto-generated method stub
		if(password.length()>1) return true;
		super.loggerManager.log(" Þifreniz en az 6 karakterden oluþmalý");
		
		return false;
	}
	
	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		if(name.length()>1) return true;
		super.loggerManager.log(" Ad alaný en az 2 karakter olmalý ");
		
		return false;
	}
	@Override
	public boolean checkSurname(String surname) {
		// TODO Auto-generated method stub
		if(surname.length()>1) return true;
		super.loggerManager.log(" Soyad alaný en az 2 karakter olmalý ");
		
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
			this.userDao.userRegistration(super.user.getId(),"true");
			Utils.RunLoggers(loggerManager.log("User"),super.user.geteMail()+ " Sisteme giriþ yaptý ");
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
