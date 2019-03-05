package banksystem.clients;

public class RegularClient extends Client {

	public RegularClient(int id, String name, float balance) {

		super(id, name, balance);
		commissionRate = 0.03f;
		interestRate = 0.001f;
	}

	@Override
	public String toString() {
		return "Regular Client, ID: " + getId();
	}
}
