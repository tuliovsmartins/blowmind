package blowmind.Controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import blowmind.Service.UserMenuService;
import blowmind.Service.UserService;
import blowmind.View.Model.MainMenuDataVM;
import blowmind.View.Model.UserDataVM;
import blowmind.View.Model.UserMenuDataVM;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserMenuService userMenuService;
	
	
	@RequestMapping("/panel")
	public String userPanel(Model model) throws InterruptedException {
		
		getUserInfo(model);
		
		return "/user/panel";
		
	}
	
	@RequestMapping(value = "/adminUser", method = RequestMethod.GET)
	public ModelAndView adminUser(Model model, UserDataVM userDataVM) {
		
		getUserInfo(model);
		List<UserDataVM> allUsers =  userService.getAllUsers();
		ModelAndView mv = new ModelAndView("/user/adminUser");
		model.addAttribute("allUsers", allUsers);
		return mv;

	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public ModelAndView createUser(Model model, UserDataVM userDataVM) {
		
		getUserInfo(model);
		
		ModelAndView mv = new ModelAndView("/user/createUser");
		
		return mv;

	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid @ModelAttribute UserDataVM userDataVM, BindingResult result, RedirectAttributes atributes 
			, Model model ) {
		
		if(result.hasErrors()){
			
			return createUser(model, userDataVM);
			
		} 
		
			getUserInfo(model);
			userDataVM.setFirst_login(true);
			userDataVM.setSignindate(new Date());
			userService.createUser(userDataVM);
			ModelAndView mv = new ModelAndView("redirect:/user/createUser");
			atributes.addFlashAttribute("message", "Usuário" + userDataVM.getName() + "cadastrado com sucesso!");
			
			return mv;
	}
	
	public void getUserInfo(Model model){
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String email = userDetail.getUsername();
		
		UserDataVM userDataVM = userService.getByEmail(email);
		
		
		String[] fullname = userDataVM.getName().split(" ");
		if(fullname.length > 0) {
	        userDataVM.setName(fullname[0] + " " + fullname[fullname.length -1]);
	    }
				
		List<UserMenuDataVM> userMenuDataVM = userMenuService.getUserMenu();
		List<MainMenuDataVM> mainMenuDataVM = userMenuService.getMainMenu();
		
		
		model.addAttribute("user", userDataVM);
		model.addAttribute("mainMenu", mainMenuDataVM);
		model.addAttribute("userMenu", userMenuDataVM);
		
	}
	

	@RequestMapping(value = "/getUserDetails", method = RequestMethod.POST)
	public Object getByEmail(Model model, String email, UserDataVM userDataVM) {
		
		return userDataVM;

	}

}
