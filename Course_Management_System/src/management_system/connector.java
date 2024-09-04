package management_system;
import java.sql.*;

import javax.swing.JOptionPane;
public class connector {
	/*
	 * This is a Connector File every runner.java calls this file to work with the database
	 * Change the username and password according to your need
	 */
	public Connection con;
	public String databasename = "course_management_system";
	public String url = "jdbc:mysql://localhost:3306/"+databasename;
	public String username = "root";
	public String password = "keshab@123";
	public connector() {
		try {
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            if(e.getErrorCode() == 1049) {
            	JOptionPane.showMessageDialog(null, "No such database exists so creating new daatabase Course_management_System","Database connection Error", JOptionPane.INFORMATION_MESSAGE);
            	new RunningScripts(username, password, databasename);
            }
            
        }
	}
	Connection getConnection(){
		return con;
	}
}