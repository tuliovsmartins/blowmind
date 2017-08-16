package blowmind.View.Model;

import blowmind.Entity.UserMenu;

public class UserMenuDataVM {

	 
	 private long id;
		private long main;
		private String sub;
		private String ref;
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getMain() {
			return main;
		}
		public void setMain(long main) {
			this.main = main;
		}
		public String getSub() {
			return sub;
		}
		public void setSub(String sub) {
			this.sub = sub;
		}
		public String getRef() {
			return ref;
		}
		public void setRef(String ref) {
			this.ref = ref;
		}
		
		public static UserMenuDataVM convertFrom(UserMenu userMenu){
			
			UserMenuDataVM userMenuDataVM = new UserMenuDataVM();
			
			userMenuDataVM.setId(userMenu.getId());
			userMenuDataVM.setMain(userMenu.getMain());
			userMenuDataVM.setRef(userMenu.getRef());
			userMenuDataVM.setSub(userMenu.getSub());
			
			return userMenuDataVM;
			
		}
}
