package blowmind.View.Model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import blowmind.Entity.Recruit;

public class RecruitDataVM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	@Email(message="O e-mail digitado é inválido.") @NotNull @NotEmpty(message = "O Campo e-mail é obrigatório")
	private String email;
	@NotNull @NotEmpty(message = "O Campo Nome é obrigatório")
	private String name;
	@NotNull @NotEmpty(message = "O Campo Data de nascimento é obrigatório")
	private String birthdate;
	private String position;
	private String gender;
	@NotNull @NotEmpty(message = "O Campo Telefone é obrigatório")
	private String telephone;
	@Lob
	private String text;
	private String file;
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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

	
public static RecruitDataVM convertFrom(Recruit recruit){
		
	RecruitDataVM recruitDataVM = new RecruitDataVM();
		
	recruitDataVM.setId(recruit.getId());
	recruitDataVM.setBirthdate(recruit.getBirthdate());
	recruitDataVM.setTelephone(recruit.getTelephone());
	recruitDataVM.setGender(recruit.getGender());
	recruitDataVM.setName(recruit.getName());
	recruitDataVM.setEmail(recruit.getEmail());
	recruitDataVM.setFile(recruit.getFile());
	recruitDataVM.setPosition(recruit.getPosition());
	recruitDataVM.setStatus(recruit.getStatus());
	recruitDataVM.setText(recruit.getText());
	recruitDataVM.setRegisterdate(recruit.getRegisterdate());
		
		
		return recruitDataVM;
		
	}
	
}
