package blowmind.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blowmind.Configs.Encrypt;
import blowmind.Converter.UserConverter;
import blowmind.Dao.UserDao;
import blowmind.View.Model.UserDataVM;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private Encrypt encrypt;
	
	public boolean checkDuplicateEmail(String email, UserDataVM userDataVM){
		
		UserDataVM result = userDao.getByEmail(email);
		
		if(result.getEmail() == "" || result.getEmail() == null){

			return true;
			
		}else{
			
			return false;
		}
	}
	
	public UserDataVM createUser( UserDataVM userDataVM){
		
		userDataVM.setPassword(encrypt.passwordEncoder().encode(userDataVM.getPassword()));
		userDao.create(userConverter.convert(userDataVM));
		 
		return userDataVM;
		
	}
	
	public List<UserDataVM> getAllUsers(){
		
		List<UserDataVM> allUsers = userConverter.convertMainList(userDao.getAll()); 
		return allUsers;
	}
	
	public boolean validatePassword(UserDataVM user, String password_rep){
		
		if (user.getPassword().equals(password_rep)) {  		
			return true;
	  	}else{
	  		
			return false;
	  	}
	}
	
	public UserDataVM getByEmail(String email){
		 
		UserDataVM result = null ;
		
		try {
				
				result = userDao.getByEmail(email);  
		    
			}
			    catch (Exception ex) {
			     return result;
		    }
		    return result;
		
		
	}
	
	
}
