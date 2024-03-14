package ka20203422.development.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class CustomerModel {

	@Id
	private String custid;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String phoneno;
	@Column
	private String emailId;
	@Column
	private String accountno; 
	@Column
	private String amount;
	@Column
	private String accountType;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Account> account;
	
	public CustomerModel() {
	}
	public CustomerModel(String custid, String name, String address, String phoneno, String emailId, String accountno,
			String amount, String accountType) {
		this.custid = custid;
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
		this.emailId = emailId;
		this.accountno = accountno;
		this.amount = amount;
		this.accountType = accountType;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	
	
}
