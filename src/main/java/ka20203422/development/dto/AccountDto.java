package ka20203422.development.dto;

public class AccountDto {
		private String fromAccount;
		private String toAccount;
		private String Amount;
		private String transactionID;
		
		public String getFromAccount() {
			return fromAccount;
		}
		public void setFromAccount(String fromAccount) {
			this.fromAccount = fromAccount;
		}
		public String getToAccount() {
			return toAccount;
		}
		public void setToAccount(String toAccount) {
			this.toAccount = toAccount;
		}
		public String getAmount() {
			return Amount;
		}
		public void setAmount(String amount) {
			Amount = amount;
		}
		public String getTransactionID() {
			return transactionID;
		}
		public void setTransactionID(String transactionID) {
			this.transactionID = transactionID;
		}

}
