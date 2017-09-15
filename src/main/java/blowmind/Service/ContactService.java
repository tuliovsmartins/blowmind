package blowmind.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blowmind.Converter.ContactConverter;
import blowmind.Dao.ContactDao;
import blowmind.View.Model.ContactDataVM;

@Service
public class ContactService {
	
	@Autowired
	private ContactConverter contactConverter;
	
	@Autowired
	private ContactDao contactDao;
	
public ContactDataVM createContact(ContactDataVM contactDataVM){
		
		contactDao.create(contactConverter.convert(contactDataVM));
		 
		return contactDataVM;
		
	}

}
