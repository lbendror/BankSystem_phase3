package banksystem.log;

public class Logger {

	private String driverName;
	
	public Logger(String driverName) {
		this.driverName = driverName;
	}
	
	public static void log(Log log) {
		System.out.println(log);
	}
}
