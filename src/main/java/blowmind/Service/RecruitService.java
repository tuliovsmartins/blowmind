package blowmind.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blowmind.Converter.RecruitConverter;
import blowmind.Dao.RecruitDao;
import blowmind.View.Model.RecruitDataVM;

@Service
public class RecruitService {
	
	@Autowired
	private RecruitConverter recruitConverter;
	
	@Autowired
	private RecruitDao recruitDao;
	
	
	public RecruitDataVM createRecruit(RecruitDataVM recruitDataVM){
		
		recruitDao.create(recruitConverter.convert(recruitDataVM));
		return recruitDataVM;
		
	}
	
	public List<RecruitDataVM> getRecruitCadList(){
		
		List<RecruitDataVM> allRecruit = recruitConverter.convertMainList(recruitDao.getAll());
		return allRecruit;
		
	}
	
	public RecruitDataVM getRecruitCadByID(long recruitID){
		
		RecruitDataVM recruitDataVM = recruitConverter.convert(recruitDao.getByID(recruitID));
		return recruitDataVM;
		
	}

}
