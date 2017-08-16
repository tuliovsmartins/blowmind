package blowmind.View.Model;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import blowmind.Entity.User;

public class UserDataVM implements Serializable {

	 private static final long serialVersionUID = 1L;
	
	private long id;
	@Email(message="O e-mail digitado é inválido.") @NotNull @NotEmpty(message = "O Campo e-mail é obrigatório")
	private String email;
	@NotNull @NotEmpty(message = "O Campo Nome é obrigatório")
	private String name;
	@NotNull @NotEmpty(message = "O Campo Senha é obrigatório")
	private String password;
	@NotNull @NotEmpty(message = "O Campo Cargo é obrigatório")
	private String position;
	@NotNull @NotEmpty(message = "O Campo Data de nascimento é obrigatório")
	private String birthdate;
	@CPF(message = "O CPF informado não é valido") @NotNull @NotEmpty(message = "O Campo CPF é obrigatório")
	private String document;
	private String cowntry;
	@Size(min=2, max=2, message="O campo Estado deve conter apenas a sigla") @NotEmpty(message = "O Campo Estado é obrigatório")
	private String state;
	@NotEmpty(message = "O Campo Cidade é obrigatório")
	private String city;
	@NotEmpty(message = "O Campo Bairro é obrigatório")
	private String neighborhood;
	@NotEmpty(message = "O Campo Rua é obrigatório")
	private String street;
	@NotEmpty(message = "O Campo Número é obrigatório")
	private String number;
	private String complement;
	@Size(max=10, min=10, message="O campo Cep é inválido") @NotEmpty(message = "O Campo Cep é obrigatório")
	private String postal;
	private String telephone;
	@NotNull @NotEmpty(message = "O Campo Telefone Celular é obrigatório")
	private String cellphone;
	private boolean whatsapp;
	private String image;
	private Date signindate;
	private boolean confirmed;
	private String role;
	private boolean first_login;
	
	public UserDataVM(){}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getCowntry() {
		return cowntry;
	}

	public void setCowntry(String cowntry) {
		this.cowntry = cowntry;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public boolean getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(boolean whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getSignindate() {
		return signindate;
	}

	public void setSignindate(Date signindate) {
		this.signindate = signindate;
	}

	public boolean isConfirmed() {
		return confirmed;
	}
	
	public boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean getFirst_login() {
		return first_login;
	}

	public void setFirst_login(boolean first_login) {
		this.first_login = first_login;
	}
	
	public static UserDataVM convertFrom(User user){
		
		UserDataVM userDataVM = new UserDataVM();
		
		userDataVM.setId(user.getId());
		userDataVM.setBirthdate(user.getBirthdate());
		userDataVM.setCellphone(user.getCellphone());
		userDataVM.setCity(user.getCity());
		userDataVM.setComplement(user.getComplement());
		userDataVM.setConfirmed(user.getConfirmed());
		userDataVM.setCowntry(user.getCowntry());
		userDataVM.setDocument(user.getDocument());
		userDataVM.setEmail(user.getEmail());
		userDataVM.setImage(user.getImage());
		userDataVM.setName(user.getName());
		userDataVM.setNeighborhood(user.getNeighborhood());
		userDataVM.setNumber(user.getNumber());
		userDataVM.setPosition(user.getPosition());
		userDataVM.setPostal(user.getPostal());
		userDataVM.setSignindate(user.getSignindate());
		userDataVM.setState(user.getState());
		userDataVM.setStreet(user.getStreet());
		userDataVM.setTelephone(user.getTelephone());
		userDataVM.setWhatsapp(user.getWhatsapp());
		
		return userDataVM;
		
	}
	
}
