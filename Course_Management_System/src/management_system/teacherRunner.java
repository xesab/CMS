package management_system;
import java.sql.*;
import java.util.ArrayList;

public class teacherRunner extends studentRunner {
	connector connection = new connector();
	Connection con = connection.getConnection();
	String teacherEmail;
	
	void setTeacherEmail(String teacherEmail){
		this.teacherEmail = teacherEmail;
	}
	
	ResultSet getAllStudentData(){
        try {
            PreparedStatement statement = con.prepareStatement("select * from studentdata");
            return statement.executeQuery();
        }
        catch (SQLException e){
        	System.out.println(e);
        }
        return null;
    }
	
	ArrayList<String> getStudentEmails(){
		ArrayList<String> arry = new ArrayList<>();
		try {
			ResultSet data = getAllStudentData();
			while(data.next()) {
				arry.add(data.getString("studentEmail"));
			}
			return arry;
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return arry;
	}
	
	ArrayList<String> getStudentEmailsLevelWise(int level){
		ArrayList<String> arry = new ArrayList<>();
		try {
			PreparedStatement statement = con.prepareStatement("select * from studentdata where studentLevel = '"+level+"'");
			ResultSet data = statement.executeQuery();
			while(data.next()) {
				arry.add(data.getString("studentEmail"));
			}
			return arry;
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return arry;
	}
	
	ResultSet getTeacherData() {
		try {
            String select = "select * from teacherData where teacherEmail = '"+teacherEmail+"'";
            PreparedStatement statement = con.prepareStatement(select);
            return statement.executeQuery();
        }
        catch (SQLException e){
        	System.out.println(e);
        }
        return null;
		
	}
	String getTeacherName(){
		try {
			ResultSet result = getTeacherData();
			result.next();
			return result.getString("teacherName");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return null;
		
	}
	String getTeacherID() {
		try {
			ResultSet result = getTeacherData();
			result.next();
			return result.getString("teacherID");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return null;
	}
	
	String getTeacherContact() {
		try {
			ResultSet result = getTeacherData();
			result.next();
			return result.getString("teacherContact");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return null;
	}
	String getTeacherEmail() {
		try {
			ResultSet result = getTeacherData();
			result.next();
			return result.getString("teacherEmail");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return null;
		
	}
	
	String getTeacherSubject() {
		try {
			ResultSet result = getTeacherData();
			result.next();
			return result.getString("teacherSubject");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return null;
		
	}
	
	String encode(String subject) {
		String ch = "_";
		String encoded = subject.replace(" ", ch);
		return encoded;
	}
	
	String decode(String subject) {
		String ch = " ";
		String encoded = subject.replace("_", ch);
		return encoded;
	}
	
	boolean setMarks(String subjectName,String Email,int level,float marks) {
		try {
			PreparedStatement statement = con.prepareStatement("update level"+level+" set "+encode(subjectName)+" = '"+marks+"' where studentEmail = '"+Email+"'");
			statement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}