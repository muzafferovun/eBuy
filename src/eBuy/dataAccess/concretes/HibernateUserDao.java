package eBuy.dataAccess.concretes;


import eBuy.core.concretes.LoggerManager;
import eBuy.core.concretes.Utils;
import eBuy.dataAccess.abstracts.UserDao;

public class HibernateUserDao implements UserDao{
	private LoggerManager loggerManager;
	public HibernateUserDao(){
		loggerManager=new LoggerManager();
	}
	@Override
	public void addUser(int id, String email, String password, String name, String registration,
			String registrationCode) {
		
		Utils.RunLoggers(loggerManager.log("User"),email+" kullan�c�s�n�n Hibernate kayd� ger�ekle�tirildi ");
		
	}
	@Override
	public void userRegistration(int id, String registration) {
		// TODO Auto-generated method stub
		Utils.RunLoggers(loggerManager.log("User"),id+" id li User Do�rulama Hibernate kayd� ger�ekle�tirildi ");
		
	}

}
