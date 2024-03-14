package ka20203422.development.dto;

public class CustomerDto {
	private String custid;
	private String name;
	private String address;
	private String phoneno;
	private String emailId;
	private String accountno; 
	private String amount;
	private String accountType;
	
	

	public CustomerDto() {
	}
	public CustomerDto(String custid, String name, String address, String phoneno, String emailId, String accountno,
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

	
}
