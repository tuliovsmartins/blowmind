package blowmind.Converter;

import org.springframework.stereotype.Component;

import blowmind.Entity.Contact;
import blowmind.View.Model.ContactDataVM;

@Component
public class ContactConverter {

	
public ContactDataVM convert(Contact contact){
		
		ContactDataVM contactDataVM = new ContactDataVM();
		
		contactDataVM.setId(contact.getId());
		contactDataVM.setTelephone(contact.getTelephone());
		contactDataVM.setName(contact.getName());
		contactDataVM.setEmail(contact.getEmail());
		contactDataVM.setStatus(contact.getStatus());
		contactDataVM.setSubject(contact.getSubject());
		contactDataVM.setMessage(contact.getMessage());
		contactDataVM.setRegisterdate(contact.getRegisterdate());
		
		return contactDataVM;
}

public Contact convert(ContactDataVM contactDataVM){
	
	Contact contact = new Contact();
	
	contact.setId(contactDataVM.getId());
	contact.setTelephone(contactDataVM.getTelephone());
	contact.setName(contactDataVM.getName());
	contact.setEmail(contactDataVM.getEmail());
	contact.setStatus(contactDataVM.getStatus());
	contact.setSubject(contactDataVM.getSubject());
	contact.setMessage(contactDataVM.getMessage());
	contact.setRegisterdate(contactDataVM.getRegisterdate());
	
	return contact;
}
}
