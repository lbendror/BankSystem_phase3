package banksystem;

public class Account {

	private int id;
	private float balance;
	
	public Account(int id, float balance) {
		this.id = id;
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
		// log this operation
	}

	public int getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o instanceof Account) {
			
			Account otherAccount = (Account) o;
			if (this.id == otherAccount.id) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
