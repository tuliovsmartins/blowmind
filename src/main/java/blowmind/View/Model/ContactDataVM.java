package blowmind.View.Model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import blowmind.Entity.Contact;

public class ContactDataVM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	@Email(message="O e-mail digitado é inválido.") @NotNull @NotEmpty(message = "O Campo e-mail é obrigatório")
	private String email;
	@NotNull @NotEmpty(message = "O Campo Nome é obrigatório")
	private String name;
	@NotNull @NotEmpty(message = "O Campo Telefone é obrigatório")
	private String telephone;
	@NotNull @NotEmpty(message = "O Campo Assunto é obrigatório")
	private String subject;
	@Lob @NotNull @NotEmpty(message = "O Campo Mensagem é obrigatório")
	private String message;
	private String status;
	private Date registerdate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	
	public static ContactDataVM convertFrom(Contact contact){
		
		ContactDataVM contactDataVM = new ContactDataVM();
			
		contactDataVM.setId(contact.getId());
		contactDataVM.setTelephone(contact.getTelephone());
		contactDataVM.setName(contact.getName());
		contactDataVM.setEmail(contact.getEmail());
		contactDataVM.setStatus(contact.getStatus());
		contactDataVM.setMessage(contact.getMessage());
		contactDataVM.setRegisterdate(contact.getRegisterdate());
			
			
			return contactDataVM;
			
		}

}
