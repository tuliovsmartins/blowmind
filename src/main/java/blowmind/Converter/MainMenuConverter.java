package blowmind.Converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import blowmind.Entity.MainMenu;
import blowmind.View.Model.MainMenuDataVM;

@Component
public class MainMenuConverter {
	
	public MainMenuDataVM convert(MainMenu mainMenu){
		
		MainMenuDataVM mainMenuDataVM = new MainMenuDataVM();
		
		mainMenuDataVM.setId(mainMenu.getId());
		mainMenuDataVM.setMain(mainMenu.getMain());
		mainMenuDataVM.setIcon(mainMenu.getIcon());
		
		return mainMenuDataVM;
		
	}
	
	public MainMenu convert(MainMenuDataVM mainMenuDataVM){
		
		MainMenu mainMenu = new MainMenu();
		
		mainMenu.setId(mainMenuDataVM.getId());
		mainMenu.setMain(mainMenuDataVM.getMain());
		mainMenu.setIcon(mainMenuDataVM.getIcon());
		
		return mainMenu;
		
	}
	
	public List<MainMenuDataVM> convertMainList(List<MainMenu> mainMenu){
		
		List<MainMenuDataVM> mainMenuDataVM = new  ArrayList<MainMenuDataVM>();
		
		for(MainMenu menus : mainMenu){
			mainMenuDataVM.add(MainMenuDataVM.convertFrom(menus));
        }
		
		return mainMenuDataVM;
		
	}

}
