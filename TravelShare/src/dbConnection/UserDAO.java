package dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import dbConnection.DBConnection;
import model.User;
import model.UserException;
import util.Encrypter;



public class UserDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO users VALUES (null, ?, ?,?,?,?,?)";
	private static final String CHECK_FOR_EMAIL = "SELECT user_id from users WHERE user_email LIKE ?%";
	private static final String SELECT_USER_SQL = "SELECT user_id FROM users WHERE user_email = ? AND user_password = ?";
	private static final String GET_USER_FROM_SQL = "SELECT user_id, uname, user_password, user_firstname, user_lastname, user_pictureURL FROM users WHERE user_email = ?";

	private static UserDAO instance;
	private UserDAO(){}
	
	public static synchronized UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}
	
	
	
	public void registerUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, Encrypter.encrypt(user.getPassword()));
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getPictureURL());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			user.setUserID(rs.getInt(1));

		} catch (SQLException e) {
			throw new UserException("User cannot be registered now, please try again later!", e);
		}

	}

	public boolean loginUser(String email, String password) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(SELECT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, email);
			ps.setString(2, Encrypter.encrypt(password));
			System.out.println(Encrypter.encrypt(password));
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1) > 0;
		} catch (SQLException e) {
			throw new UserException("There is no such user in our system!", e);
		}
	}			

	public User getUser(String userEmail) throws SQLException{
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement(GET_USER_FROM_SQL);
		ps.setString(1, userEmail);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User(
				rs.getInt("user_id"), 
				rs.getString("uname"), 
				rs.getString("user_password"), 
				rs.getString("user_firstname"),
				rs.getString("user_lastname"),
				rs.getString("user_pictureURL"));

		return user;
	}

	public String checkForEmail(String s) {
		final String CHECK_FOR_EMAILS = "SELECT user_id from users WHERE user_email LIKE '"+ s + "%'";
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(CHECK_FOR_EMAILS, Statement.RETURN_GENERATED_KEYS);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(CHECK_FOR_EMAILS);
			while (rs.next()) {
				  return "such email exists";
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}