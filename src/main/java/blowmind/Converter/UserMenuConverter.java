package blowmind.Converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import blowmind.Entity.UserMenu;
import blowmind.View.Model.UserMenuDataVM;

@Component
public class UserMenuConverter {
	

	public UserMenu convert(UserMenuDataVM userMenuDataVM){
		
		UserMenu userMenu = new UserMenu();
		
		userMenu.setId(userMenuDataVM.getId());
		userMenu.setMain(userMenuDataVM.getMain());
		userMenu.setSub(userMenuDataVM.getSub());
		userMenu.setRef(userMenuDataVM.getRef());
		
		return userMenu;
		
	}
	
	public UserMenuDataVM convert(UserMenu userMenu){
		
		UserMenuDataVM userMenuDataVM = new UserMenuDataVM();
		
		userMenuDataVM.setId(userMenu.getId());
		userMenuDataVM.setMain(userMenu.getMain());
		userMenuDataVM.setSub(userMenu.getSub());
		userMenuDataVM.setRef(userMenu.getRef());
		
		return userMenuDataVM;
		
	}
	
	public List<UserMenuDataVM> convertList(List<UserMenu> userMenu){
		
		List<UserMenuDataVM> userMenuDataVM = new  ArrayList<UserMenuDataVM>();
		
		for(UserMenu menus : userMenu){
			userMenuDataVM.add(UserMenuDataVM.convertFrom(menus));
        }
		
		return userMenuDataVM;
		
	}
	
	
}
