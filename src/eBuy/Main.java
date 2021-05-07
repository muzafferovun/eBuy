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
		
		//Kullan�c� registration form testi
		
		userService.userRegister("ovun@hotmail.com","123456", "Muzaffer", "�v�n"); 
		if(userService.getUser()==null) {
			System.out.println("L�tfen Kullan�c� bilgilerinizi kontrol ediniz");
		}
		else {
			System.out.println(userService.getUser().geteMail()+" kullan�c�s� kaydedildi.");
			
		}
		//Do�rulama kodu kontrol�
		Scanner scanInput = new Scanner(System.in);

		if(userService.getUser()!=null&&!userService.getUser().isRegistration()) {
			String authCode="";
			while(!userService.getUser().isRegistration()) {
				System.out.println("Do�rulama Kodunu Giriniz");
				authCode= scanInput.nextLine().toString();
			    userService.userAuthenticate(authCode.toString());
			}
		}
		
		//login form kullan�c� giri�i
		System.out.println("Kullan�c� Giri�i :");
		userService.userLogin("muzafferovun@hotmail.com", "124556");
				//kullan�c� eri�imi sa�lanm�� ise do�rulama kodu kontrol�
		if(userService.getUser()!=null&&!userService.getUser().isRegistration()) {
			String authCode="";
			while(!userService.getUser().isRegistration()) {
				System.out.println("Do�rulama Kodunu Giriniz :"+userService.getUser().getRegistrationCode());
				authCode= scanInput.nextLine().toString();
			    userService.userAuthenticate(authCode.toString());
			}
		}
		
		//
		//login ekran�nda do�ru kullan�c� ad� ve �ifre ile do�rulama yap�lm�� kullan�c� testi
		System.out.println("Kullan�c� Giri�i :");
		userService.userLogin("engindemirog@kodlama.io", "124556");
				//kullan�c� eri�imi sa�lanm�� ise do�rulama kodu kontrol�
		if(userService.getUser()!=null&&!userService.getUser().isRegistration()) {
			String authCode="";
			while(!userService.getUser().isRegistration()) {
				System.out.println("Do�rulama Kodunu Giriniz :"+userService.getUser().getRegistrationCode());
				authCode= scanInput.nextLine().toString();
			    userService.userAuthenticate(authCode.toString());
			}
		}
		userService=new GoogleUserManager(userDao);		
		userService.userRegister("aliveli@hotmail.com","123456", "Muzaffer", "�v�n"); 
		if(userService.getUser()==null) {
			System.out.println("L�tfen Kullan�c� bilgilerinizi kontrol ediniz");
		}
		else {
			System.out.println(userService.getUser().geteMail()+" kullan�c�s� kaydedildi.");
			
		}
		//login form kullan�c� giri�i
		System.out.println("Kullan�c� Giri�i :");
		userService.userLogin("aliveli@hotmail.com", "123456");
				//kullan�c� eri�imi sa�lanm�� ise do�rulama kodu kontrol�
		if(userService.getUser()!=null&&!userService.getUser().isRegistration()) {
			String authCode="";
			while(!userService.getUser().isRegistration()) {
				System.out.println("Do�rulama Kodunu Giriniz :"+userService.getUser().getRegistrationCode());
				authCode= scanInput.nextLine().toString();
			    userService.userAuthenticate(authCode.toString());
			}
		}
		
	    scanInput.close();
		
	}

}
