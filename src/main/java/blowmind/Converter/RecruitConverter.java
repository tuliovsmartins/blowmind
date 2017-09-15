package blowmind.Converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import blowmind.Entity.Recruit;
import blowmind.View.Model.RecruitDataVM;

@Component
public class RecruitConverter {
	
public Recruit convert(RecruitDataVM recruitDataVM){
		
		Recruit recruit = new Recruit();
		
		recruit.setBirthdate(recruitDataVM.getBirthdate());
		recruit.setEmail(recruitDataVM.getEmail());
		recruit.setName(recruitDataVM.getName());
		recruit.setGender(recruitDataVM.getGender());
		recruit.setTelephone(recruitDataVM.getTelephone());
		recruit.setText(recruitDataVM.getText());
		recruit.setFile(recruitDataVM.getFile());
		recruit.setPosition(recruitDataVM.getPosition());
		recruit.setStatus(recruitDataVM.getStatus());
		recruit.setRegisterdate(recruitDataVM.getRegisterdate());
		
		return recruit;
}

public RecruitDataVM convert(Recruit recruit){
	
	RecruitDataVM recruitDataVM = new RecruitDataVM();
	
	recruitDataVM.setBirthdate(recruit.getBirthdate());
	recruitDataVM.setEmail(recruit.getEmail());
	recruitDataVM.setName(recruit.getName());
	recruitDataVM.setGender(recruit.getGender());
	recruitDataVM.setTelephone(recruit.getTelephone());
	recruitDataVM.setText(recruit.getText());
	recruitDataVM.setFile(recruit.getFile());
	recruitDataVM.setPosition(recruit.getPosition());
	recruitDataVM.setStatus(recruit.getStatus());
	recruitDataVM.setRegisterdate(recruit.getRegisterdate());
	
	return recruitDataVM;
}

public List<RecruitDataVM> convertMainList(List<Recruit> recruit){
	
	List<RecruitDataVM> recruitDataVM = new  ArrayList<RecruitDataVM>();
	
	for(Recruit recruits : recruit){
		recruitDataVM.add(RecruitDataVM.convertFrom(recruits));
    }
	
	return recruitDataVM;
	
}

}
