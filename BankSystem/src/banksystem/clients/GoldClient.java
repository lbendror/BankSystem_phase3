package banksystem.clients;

public class GoldClient extends Client {

	public GoldClient(int id, String name, float balance) {

		super(id, name, balance);
		commissionRate = 0.02f;
		interestRate = 0.003f;
	}

	@Override
	public String toString() {
		return "Gold Client, ID: " + getId();
	}
}
