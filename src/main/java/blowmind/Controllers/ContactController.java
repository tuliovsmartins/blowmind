package blowmind.Controllers;

import java.util.Date;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import blowmind.Service.ContactService;
import blowmind.Service.MailSenderService;
import blowmind.View.Model.ContactDataVM;

@Controller
@RequestMapping("/")
public class ContactController {

	
	@Autowired
	ContactService contactService;
	
	@Autowired
	MailSenderService mailSenderService;
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(Model model, ContactDataVM contactDataVM) {
		
		ModelAndView mv = new ModelAndView("/contact");
		
		return mv;

	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public ModelAndView recruitAdd(@Valid final @ModelAttribute("contactDataVM") ContactDataVM contactDataVM, BindingResult result, RedirectAttributes atributes, Model model) throws MessagingException {
		
		if(result.hasErrors()){
			
			return contact(model, contactDataVM);
			
		} 
		
		contactDataVM.setRegisterdate(new Date());
		contactDataVM.setStatus("Novo");
		mailSenderService.sendEmail(contactDataVM.getEmail(), "extern", contactDataVM);
		mailSenderService.sendEmail("contato@blowmindsolutions.com.br", "intern", contactDataVM);
		contactService.createContact(contactDataVM);
		ModelAndView mv = new ModelAndView("redirect:/contact");
		atributes.addFlashAttribute("message", "Olá " + contactDataVM.getName() + ", recebemos sua mensagem e logo entraremos em contato.\n Obrigado !");
		
		return mv;

	}
}
