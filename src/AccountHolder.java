
public class AccountHolder {

	private int accountNumber;
	private String accountHolderName;
	private String branchName;
	private int balance;

	@Override
	public String toString() {
		return "AccountHolder [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", branchName=" + branchName + ", balance=" + balance + "]";
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public AccountHolder(int accountNumber, String accountHolderName, String branchName, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.branchName = branchName;
		this.balance = balance;
	}
	
	public AccountHolder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
