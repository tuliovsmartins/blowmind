package blowmind.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blowmind.Converter.MainMenuConverter;
import blowmind.Converter.UserMenuConverter;
import blowmind.Dao.MainMenuDao;
import blowmind.Dao.UserMenuDao;
import blowmind.View.Model.MainMenuDataVM;
import blowmind.View.Model.UserMenuDataVM;

@Service
public class UserMenuService {
	
	@Autowired
	UserMenuDao userMenuDao;
	
	@Autowired
	MainMenuDao mainMenuDao;
	
	@Autowired
	UserMenuConverter userMenuConverter;
	
	@Autowired
	MainMenuConverter mainMenuConverter;
	
	public List<UserMenuDataVM> getUserMenu(){
				
			List<UserMenuDataVM> userMenuDataVM = userMenuConverter.convertList(userMenuDao.getAll());  
		    
		    return userMenuDataVM;
		
		
	}
	
	public List<MainMenuDataVM> getMainMenu(){
		
		List<MainMenuDataVM> mainMenuDataVM = mainMenuConverter.convertMainList(mainMenuDao.getMainMenu());  
	    
	    return mainMenuDataVM;
	
	
}

}
