package banksystem.log;

import java.text.SimpleDateFormat;

public class Log {

	private long timestamp;
	private int clientId;
	private String description;
	private float amount;
	
	private static SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public Log(long timestamp, int clientId, String description, float amount) {
		this.timestamp = timestamp;
		this.clientId = clientId;
		this.description = description;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return timestampFormat.format(timestamp) + ": Client ID: " + clientId + "; Description: " + description + "; Amount: " + amount;
	}
}
