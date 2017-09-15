package blowmind.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resourcetax")
public class ResourceTax {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	//Decimo terceiro
	private String thirthensalary;
	//Férias
	private String vacation;
	//um terço das férias
	private String vacationthirdpart;
	//inss
	private String inss;
	//Seguro Acidente de Trabalho (SAT)
	private String sat;
	//salário educação
	private String educationsalary;
	// FGTS
	private String fgts;
	// Provisão de recisão FGTS
	private String fgtsrecisiontax;
	//Previdenciário sobre 13º / Férias / DSR
	private String dsr;
	// PLR
	private String plr;
	// Vale Transporte
	private String vt;
	// Vale Refeição
	private String vr;
	// Vale Alimentação
	private String va;
	// Plano de saúde
	private String healthcare;
	// Plano odontológico
	private String tothcare;
	//Outras Taxas
	private String othertax1;
	private String othertax2;
	private String othertax3;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getThirthensalary() {
		return thirthensalary;
	}
	public void setThirthensalary(String thirthensalary) {
		this.thirthensalary = thirthensalary;
	}
	public String getVacation() {
		return vacation;
	}
	public void setVacation(String vacation) {
		this.vacation = vacation;
	}
	public String getVacationthirdpart() {
		return vacationthirdpart;
	}
	public void setVacationthirdpart(String vacationthirdpart) {
		this.vacationthirdpart = vacationthirdpart;
	}
	public String getInss() {
		return inss;
	}
	public void setInss(String inss) {
		this.inss = inss;
	}
	public String getSat() {
		return sat;
	}
	public void setSat(String sat) {
		this.sat = sat;
	}
	public String getEducationsalary() {
		return educationsalary;
	}
	public void setEducationsalary(String educationsalary) {
		this.educationsalary = educationsalary;
	}
	public String getFgts() {
		return fgts;
	}
	public void setFgts(String fgts) {
		this.fgts = fgts;
	}
	public String getFgtsrecisiontax() {
		return fgtsrecisiontax;
	}
	public void setFgtsrecisiontax(String fgtsrecisiontax) {
		this.fgtsrecisiontax = fgtsrecisiontax;
	}
	public String getDsr() {
		return dsr;
	}
	public void setDsr(String dsr) {
		this.dsr = dsr;
	}
	public String getPlr() {
		return plr;
	}
	public void setPlr(String plr) {
		this.plr = plr;
	}
	public String getVt() {
		return vt;
	}
	public void setVt(String vt) {
		this.vt = vt;
	}
	public String getVr() {
		return vr;
	}
	public void setVr(String vr) {
		this.vr = vr;
	}
	public String getVa() {
		return va;
	}
	public void setVa(String va) {
		this.va = va;
	}
	public String getHealthcare() {
		return healthcare;
	}
	public void setHealthcare(String healthcare) {
		this.healthcare = healthcare;
	}
	public String getTothcare() {
		return tothcare;
	}
	public void setTothcare(String tothcare) {
		this.tothcare = tothcare;
	}
	public String getOthertax1() {
		return othertax1;
	}
	public void setOthertax1(String othertax1) {
		this.othertax1 = othertax1;
	}
	public String getOthertax2() {
		return othertax2;
	}
	public void setOthertax2(String othertax2) {
		this.othertax2 = othertax2;
	}
	public String getOthertax3() {
		return othertax3;
	}
	public void setOthertax3(String othertax3) {
		this.othertax3 = othertax3;
	}
	
	
	
}
