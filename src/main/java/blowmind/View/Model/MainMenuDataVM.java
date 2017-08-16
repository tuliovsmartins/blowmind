package blowmind.View.Model;

import blowmind.Entity.MainMenu;

public class MainMenuDataVM {
	
	private long id;
	private String main;
	private String icon;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}

	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public static MainMenuDataVM convertFrom(MainMenu mainMenu){
		
		MainMenuDataVM mainMenuDataVM = new MainMenuDataVM();
		
		mainMenuDataVM.setId(mainMenu.getId());
		mainMenuDataVM.setMain(mainMenu.getMain());
		mainMenuDataVM.setIcon(mainMenu.getIcon());
		
		return mainMenuDataVM;
		
	}
	
}
