package banksystem;

import banksystem.clients.Client;
import banksystem.log.Log;
import banksystem.log.Logger;
import banksystem.utils.ArraysHelper;

public class Bank {
	
	private static Bank instance;
	
	private Client[] clients;
	private float balance;
	
	private static float commissionSum;
	
	private Bank() {
		clients = new Client[100];
	}
	
	public static Bank getInstance() {
		
		if (instance == null) {
			instance = new Bank();
		}
		
		return instance;
	}
	
	public static void addCommission(float commission) {
		commissionSum += commission;
	}
	
	public void setBalance() {
		
		float newBalance = 0;
		
		for (Client client : clients) {
			newBalance += client.getFortune();
		}
		
		this.balance = newBalance + commissionSum;
	}
	
	public void printClientList() {
		
		for (Client client : clients) {
			if (client != null) {
				System.out.println(client);
			}
		}
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void addClient(Client client) {
		int index = ArraysHelper.getNextEmptyArrayIndex(clients);
		clients[index] = client;
		setBalance();
	}
	
	/*
	public void removeClient(int id) {
		
		Client clientToRemove = null;
		int clientToRemoveIndex = -1;
		
		for (int i=0; i<clients.length; i++) {
			if (clients[i].getId() == id) {
				clientToRemove = clients[i];
				clientToRemoveIndex = i;
				break;
			}
		}
		
		Log log = new Log(System.currentTimeMillis(), id, "Remove client " + id + " from bank", clientToRemove.getFortune());
		Logger.log(log);
		
		clients[clientToRemoveIndex] = null;
		
		setBalance();
	}
	*/
	
	public void removeClient(Client clientToRemove) {
		
		for (int i=0; i<clients.length; i++) {
			
			if (clients[i].equals(clientToRemove)) {
				clients[i] = null;
				Log log = new Log(System.currentTimeMillis(), clientToRemove.getId(), "Remove client from bank", clientToRemove.getFortune());
				Logger.log(log);
				break;
			}
		}
		
		setBalance();
	}
	
	public Client[] getClients() {
		return clients;
	}
	
	public void viewLogs() {
		
	}
}
