package dbConnection;

	
	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBConnection {
		private Connection connection;
		private static DBConnection theOneDBConnection;
		
		private static final String DB_HOSTNAME = "127.0.0.1";
		private static final String DB_PORT = "3306";
		private static final String DATABASE = "travel_share";
		private static final String DB_USER = "root";
		private static final String DB_PASSWORD = "BratinDol14";
		
		private DBConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				this.connection = 
						DriverManager.getConnection("jdbc:mysql://" + 
								DB_HOSTNAME + ":" + 
								DB_PORT + "/" + DATABASE, 
								DB_USER, DB_PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public synchronized static DBConnection getInstance() {
			if (theOneDBConnection == null) {
				theOneDBConnection = new DBConnection();
			}
			return theOneDBConnection;
		}

		public Connection getConnection() {
			return connection;
		}
		
	

}
