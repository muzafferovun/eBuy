package eBuy;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import eBuy.business.abstracts.UserService;
import eBuy.business.concretes.BaseUserManager;
import eBuy.business.concretes.GoogleUserManager;
import eBuy.business.concretes.LocalUserManager;
import eBuy.dataAccess.abstracts.UserDao;
import eBuy.dataAccess.concretes.HibernateUserDao;
import eBuy.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDao userDao=new HibernateUserDao();
		UserService userService=new LocalUserManager(userDao);
		
		//Kullanýcý registration form testi
		
		userService.userRegister("ovun@hotmail.com","123456", "Muzaffer", "Övün"); 
		if(userService.getUser()==null) {
			System.out.println("Lütfen Kullanýcý bilgilerinizi kontrol ediniz");
		}
		else {
			System.out.println(userService.getUser().geteMail()+" kullanýcýsý kaydedildi.");
			
		}
		//Doðrulama kodu kontrolü
		Scanner scanInput = new Scanner(System.in);

		if(userService.getUser()!=null&&!userService.getUser().isRegistration()) {
			String authCode="";
			while(!userService.getUser().isRegistration()) {
				System.out.println("Doðrulama Kodunu Giriniz");
				authCode= scanInput.nextLine().toString();
			    userService.userAuthenticate(authCode.toString());
			}
		}
		
		//login form kullanýcý giriþi
		System.out.println("Kullanýcý Giriþi :");
		userService.userLogin("muzafferovun@hotmail.com", "124556");
				//kullanýcý eriþimi saðlanmýþ ise doðrulama kodu kontrolü
		if(userService.getUser()!=null&&!userService.getUser().isRegistration()) {
			String authCode="";
			while(!userService.getUser().isRegistration()) {
				System.out.println("Doðrulama Kodunu Giriniz :"+userService.getUser().getRegistrationCode());
				authCode= scanInput.nextLine().toString();
			    userService.userAuthenticate(authCode.toString());
			}
		}
		
		//
		//login ekranýnda doðru kullanýcý adý ve þifre ile doðrulama yapýlmýþ kullanýcý testi
		System.out.println("Kullanýcý Giriþi :");
		userService.userLogin("engindemirog@kodlama.io", "124556");
				//kullanýcý eriþimi saðlanmýþ ise doðrulama kodu kontrolü
		if(userService.getUser()!=null&&!userService.getUser().isRegistration()) {
			String authCode="";
			while(!userService.getUser().isRegistration()) {
				System.out.println("Doðrulama Kodunu Giriniz :"+userService.getUser().getRegistrationCode());
				authCode= scanInput.nextLine().toString();
			    userService.userAuthenticate(authCode.toString());
			}
		}
		userService=new GoogleUserManager(userDao);		
		userService.userRegister("aliveli@hotmail.com","123456", "Muzaffer", "Övün"); 
		if(userService.getUser()==null) {
			System.out.println("Lütfen Kullanýcý bilgilerinizi kontrol ediniz");
		}
		else {
			System.out.println(userService.getUser().geteMail()+" kullanýcýsý kaydedildi.");
			
		}
		//login form kullanýcý giriþi
		System.out.println("Kullanýcý Giriþi :");
		userService.userLogin("aliveli@hotmail.com", "123456");
				//kullanýcý eriþimi saðlanmýþ ise doðrulama kodu kontrolü
		if(userService.getUser()!=null&&!userService.getUser().isRegistration()) {
			String authCode="";
			while(!userService.getUser().isRegistration()) {
				System.out.println("Doðrulama Kodunu Giriniz :"+userService.getUser().getRegistrationCode());
				authCode= scanInput.nextLine().toString();
			    userService.userAuthenticate(authCode.toString());
			}
		}
		
	    scanInput.close();
		
	}

}
