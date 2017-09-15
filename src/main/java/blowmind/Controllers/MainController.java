package blowmind.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLogin(Model model) {
		return "index";
	}
	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		return "about";
	}
	
	@RequestMapping(value = "/knowledge", method = RequestMethod.GET)
	public String knowledge(Model model) {
		return "knowledge";
	}
	
	@RequestMapping(value = "/development", method = RequestMethod.GET)
	public String development(Model model) {
		return "development";
	}
	
	@RequestMapping(value = "/otrs", method = RequestMethod.GET)
	public String otrs(Model model) {
		return "otrs";
	}
	
	@RequestMapping(value = "/asterisk", method = RequestMethod.GET)
	public String asterisk(Model model) {
		return "asterisk";
	}
	
	@RequestMapping(value = "/cloud", method = RequestMethod.GET)
	public String cloud(Model model) {
		return "cloud";
	}
	
	@RequestMapping(value = "/omnichannel", method = RequestMethod.GET)
	public String omnichanne(Model model) {
		return "omnichannel";
	}
	
	@RequestMapping(value = "/integration", method = RequestMethod.GET)
	public String integration(Model model) {
		return "integration";
	}
	
	
}
