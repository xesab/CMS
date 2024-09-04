package management_system;
import java.sql.*;
public class loginRunner {
	String username;
	String password;
	String userType;
	connector connection = new connector();
	Connection con = connection.getConnection();
	public loginRunner(String username,String password,String userType) {
		this.username=username;
		this.password=password;
		this.userType=userType;
	}
	boolean usernameCheck() {
		boolean ans = false;
		try {
			PreparedStatement emailStatement = con.prepareStatement("select "+userType+"Email from "+userType+"data where "+userType+"Email = '"+username+"'");
			ResultSet usernameResult = emailStatement.executeQuery();
			usernameResult.next();
			String userNameSQL = usernameResult.getString(userType+"Email");
			if(userNameSQL.equals(username)) {
				ans = true;
			}
		
		} catch (SQLException e) {
			ans = false;
			
		}
		return ans;
	}
	boolean passwordCheck() {
		boolean ans = false;
		try {
			PreparedStatement passwordStatement = con.prepareStatement("select "+userType+"Password from "+userType+"data where "+userType+"Password = '"+password+"'");
			ResultSet passwordResult = passwordStatement.executeQuery();
			passwordResult.next();
			String userNameSQL = passwordResult.getString(userType+"Password");
			
			if(userNameSQL.equals(password)) {
				ans = true;
			}
			
		
		} catch (SQLException e) {
			ans = false;
			
		}
		return ans;
	}
}