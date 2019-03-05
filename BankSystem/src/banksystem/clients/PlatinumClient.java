package banksystem.clients;

public class PlatinumClient extends Client {

	public PlatinumClient(int id, String name, float balance) {

		super(id, name, balance);
		commissionRate = 0.01f;
		interestRate = 0.005f;
	}

	@Override
	public String toString() {
		return "Platinum Client, ID: " + getId();
	}
}
