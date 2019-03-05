package banksystem.clients;

import banksystem.Account;
import banksystem.Bank;
import banksystem.log.Log;
import banksystem.log.Logger;
import banksystem.utils.ArraysHelper;

public abstract class Client {

	private int id;
	private String name;
	private float balance;
	private Account[] accounts;
	
	protected float commissionRate;
	protected float interestRate;
	
	public Client(int id, String name, float balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		accounts = new Account[5];
	}

	public void addAccount(Account account) {
		int index = ArraysHelper.getNextEmptyArrayIndex(accounts);
		accounts[index] = account;
		
		Log log = new Log(System.currentTimeMillis(), id, "Add new account", account.getBalance());
		Logger.log(log);
	}
	
	public Account getAccount(int index) {
		return accounts[index];
	}
	
	/*
	public void removeAccount(int id) {
		
		int accountToRemoveIndex = -1;
		Account accountToRemove = null;
		
		for (int i=0; i<accounts.length; i++) {
			if (accounts[i].getId() == id) {
				accountToRemoveIndex = i;
				accountToRemove = accounts[i];
				break;
			}
		}
		
		balance += accountToRemove.getBalance();
		
		Log log = new Log(System.currentTimeMillis(), this.id, "Remove account " + accountToRemove.getId(), accountToRemove.getBalance());
		Logger.log(log);
		
		accounts[accountToRemoveIndex] = null;
	}
	*/
	
	public void removeAccount(Account accountToRemove) {
		
		for (int i=0; i<accounts.length; i++) {
			
			if (accounts[i].equals(accountToRemove)) {
				
				balance += accountToRemove.getBalance();
				Log log = new Log(System.currentTimeMillis(), this.id, "Remove account " + accountToRemove.getId(), accountToRemove.getBalance());
				Logger.log(log);
				accounts[i] = null;
				
				break;
			}
		}
	}
	
	public void deposit(float amount) {
		
		float commission = amount * commissionRate;
		balance += (amount - commission);
		Bank.addCommission(commission);
	}
	
	public void withdraw(float amount) {
		
		float commission = amount * commissionRate;
		balance -= (amount + commission);
		Bank.addCommission(commission);
	}
	
	public void autoUpdateAccounts() {
		
		for (Account account : accounts) {
			
			float accountBalance = account.getBalance();
			float newBalance = accountBalance + (accountBalance * interestRate);
			account.setBalance(newBalance);
			
			Log log = new Log(System.currentTimeMillis(), id, "Update account " + account.getId() + " according to interest rate of " + interestRate + "%", newBalance);
			Logger.log(log);
		}
	}
	
	public float getFortune() {
		
		float fortune = balance;
		
		for (Account account : accounts) {
			fortune += account.getBalance();
		}
		
		return fortune;
	}
	
	@Override	
	public boolean equals(Object o) {
		
		if (o instanceof Client) {
			Client otherClient = (Client) o;
			if (this.id == otherClient.id) {
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + "]";
	}
}
