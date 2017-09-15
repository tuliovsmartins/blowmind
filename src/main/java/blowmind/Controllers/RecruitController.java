package blowmind.Controllers;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import blowmind.Service.MailSenderService;
import blowmind.Service.RecruitService;
import blowmind.Service.UploadFileService;
import blowmind.View.Model.RecruitDataVM;

@Controller
@RequestMapping("/")
public class RecruitController {
		
	@Autowired
	RecruitService recruitService;
	
	@Autowired
	UserController userController;
	
	@Autowired
	UploadFileService uploadFileService;
	
	@Autowired
	MailSenderService mailSenderService;
	
	@RequestMapping(value = "/recruit", method = RequestMethod.GET)
	public ModelAndView recruit(Model model, RecruitDataVM recruitDataVM) {
		
		
		ModelAndView mv = new ModelAndView("/recruit");
		
		return mv;

	}
	
	@RequestMapping(value = "/recruit", method = RequestMethod.POST)
	public ModelAndView recruitAdd(@Valid final @ModelAttribute("recruitDataVM") RecruitDataVM recruitDataVM, BindingResult result, final @RequestParam("archive") MultipartFile archive, RedirectAttributes atributes, Model model) throws MessagingException {
		
		if(result.hasErrors()){
			
			return recruit(model, recruitDataVM);
			
		} 
		
		String imageFile = null;
		imageFile = uploadFileService.fileUpload("src/main/webapp", archive, "/curriculo");
		
		recruitDataVM.setRegisterdate(new Date());
		recruitDataVM.setFile(imageFile);
		recruitDataVM.setStatus("Novo");
		//mailSenderService.sendEmail("recrutamento@blowmindsolutions.com.br", "recruit", recruitDataVM);
		recruitService.createRecruit(recruitDataVM);
		ModelAndView mv = new ModelAndView("redirect:/recruit");
		atributes.addFlashAttribute("message", "Olá " + recruitDataVM.getName() + ", recebemos seu curriculo, em breve será analisado pelo nosso departamento responsável e logo entraremos em contato.\n Boa sorte !");
		
		return mv;
		

	}
	
	@RequestMapping(value = "/user/recruitCad", method = RequestMethod.GET)
	public ModelAndView getRecruitCadList(Model model){
		
		userController.getUserInfo(model);
		List<RecruitDataVM> allRecruit = recruitService.getRecruitCadList();
		model.addAttribute("allRecruit", allRecruit);
		ModelAndView mv = new ModelAndView("/people/recruitCad");
		return mv;
	}
	
	@RequestMapping(value = "/user/recruitCad/{recruitID}", method = RequestMethod.GET)
	public ModelAndView getRecruitCadByID( @PathVariable("recruitID") long recruitID, Model model){
		
		userController.getUserInfo(model);
		RecruitDataVM recruitDataVM = recruitService.getRecruitCadByID(recruitID);
		model.addAttribute("recruitDataVM", recruitDataVM);
		ModelAndView mv = new ModelAndView("/people/recruitCadInfo");
		return mv;
	}
	
	
}
