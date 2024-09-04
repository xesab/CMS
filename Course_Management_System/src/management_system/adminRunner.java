package management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class adminRunner extends teacherRunner{
	connector connect = new connector();
	Connection con = connect.getConnection();
	
	boolean addStudent(String studentName,String studentContact,int studentLevel, String studentPassword,String studentEmail){
		try {
			PreparedStatement statement = con.prepareStatement("insert into studentdata (studentName,studentContact,studentLevel,studentPassword,studentEmail) values"
					+ "("+"'"+studentName+"',"+studentContact+","+studentLevel+",'"+studentPassword+"','"+studentEmail+"')");
			statement.execute();
			
			PreparedStatement statement_2 = con.prepareStatement("insert into level"+studentLevel+"(studentEmail) values ('"+studentEmail+"')");
			statement_2.execute();
			
			if(studentLevel==6) {
				PreparedStatement stm = con.prepareStatement("insert into level6opt (studentEmail,Complex_System,Project_and_Professionalism) values ('"+studentEmail+"','Yes','Yes')");
				stm.execute();
			}
			return true;
			
		} catch (SQLException e) {
			return false;
		}
		
	}
	boolean updateStudent(String studentEmail,int newstudentLevel) {
		try {
			PreparedStatement statement = con.prepareStatement("update studentdata set studentLevel = '"+newstudentLevel+"' where studentEmail = '"+studentEmail+"'");
			statement.execute();
			if (newstudentLevel==6) {
				PreparedStatement stm = con.prepareStatement("insert into level6 (studentEmail) values ('"+studentEmail+"')");
				stm.execute();
				PreparedStatement stm1 = con.prepareStatement("insert into level6opt (studentEmail,Complex_System,Project_and_Professionalism) values ('"+studentEmail+"','Yes','Yes')");
				stm1.execute();
				return true;
			}else if (newstudentLevel==5) {
				PreparedStatement stm2 = con.prepareStatement("insert into level5 (studentEmail) values ('"+studentEmail+"')");
				stm2.execute();
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}
	boolean checkStudent(String studentEmail,int studentLevel) {
		try {
			PreparedStatement statement = con.prepareStatement("select * from level"+studentLevel+" where studentEmail = '"+studentEmail+"'");
			ResultSet data = statement.executeQuery();
			data.next();
			String nameFromDatabase = String.valueOf(data.getString("studentEmail"));
			if(nameFromDatabase.equals(studentEmail)){
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}
	boolean removeStudent(String studentEmail,int studentLevel) {
		try {
			PreparedStatement statement = con.prepareStatement("delete from studentdata where studentEmail = '"+studentEmail+"'");
			statement.execute();
			//Increment Correction
			PreparedStatement atstm = con.prepareStatement("alter table studentdata auto_increment=1");
			atstm.execute();
			
			if(checkStudent(studentEmail,4)) {
				PreparedStatement state1 = con.prepareStatement("delete from level4 where studentEmail = '"+studentEmail+"'");
				state1.execute();
			}
			if(checkStudent(studentEmail,5)) {
				PreparedStatement state2 = con.prepareStatement("delete from level5 where studentEmail = '"+studentEmail+"'");
				state2.execute();
			}
			if(checkStudent(studentEmail,6)) {
				PreparedStatement state3 = con.prepareStatement("delete from level6 where studentEmail = '"+studentEmail+"'");
				state3.execute();
			}
			
			if(studentLevel==6) {
				PreparedStatement stm = con.prepareStatement("delete from level6opt where studentEmail = '"+studentEmail+"'");
				stm.execute();
			}
			
			return true;
			
		} catch (SQLException e) {
			return false;
		}
	}
	
	ResultSet getAllTeacherData(){
        try {
            PreparedStatement statement = con.prepareStatement("select * from teacherdata");
            return statement.executeQuery();
        }
        catch (SQLException e){
        	System.out.println(e);
        }
        return null;
    }
	
	ArrayList<String> getTeacherEmails(){
		ArrayList<String> arry = new ArrayList<>();
		try {
			ResultSet data = getAllTeacherData();
			while(data.next()) {
				arry.add(data.getString("teacherEmail"));
			}
			return arry;
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return arry;
		
	}
	boolean removeTeacher(String teacherEmail) {
		try {
			PreparedStatement statement = con.prepareStatement("delete from teacherdata where teacherEmail = '"+teacherEmail+"'");
			statement.execute();
			//Increment Correction
			PreparedStatement atstm = con.prepareStatement("alter table teacherdata auto_increment=1");
			atstm.execute();
			return true;
			
		} catch (SQLException e) {
			return false;
		}
	}
	boolean addTeacher(String teacherName,String teacherContact, String teacherPassword, String teacherEmail,String teacherSubject){
		try {
			PreparedStatement statement = con.prepareStatement("insert into teacherdata (teacherName,teacherSubject,teacherEmail,teacherPassword,teacherContact)"
					+ " values ("+"'"+teacherName+"',"+"'"+teacherSubject+"',"+"'"+teacherEmail+"',"+"'"+teacherPassword+"',"+teacherContact+")");
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	ArrayList<String> getSubjects(int level) {
		ArrayList<String> arry = new ArrayList<>();
		try {
			PreparedStatement statement = con.prepareStatement("show columns from level"+level);
			ResultSet data = statement.executeQuery();
			data.next();
			while(data.next()) {
				arry.add(decode(data.getString("field")));
			}
			
		} catch (SQLException e) {
			System.out.print(e);
		}
		return arry;
		
	}
	ArrayList<String> getAllSubjects(){
		ArrayList<String> arry = new ArrayList<>();
		ArrayList<String> arryLevel4 = new ArrayList<>();
		ArrayList<String> arryLevel5 = new ArrayList<>();
		ArrayList<String> arryLevel6 = new ArrayList<>();
		arryLevel4 = getSubjects(4);
		arryLevel5 = getSubjects(5);
		arryLevel6 = getSubjects(6);
		arry.addAll(arryLevel4);
		arry.addAll(arryLevel5);
		arry.addAll(arryLevel6);
		return arry;
	}
	
	boolean addSubject(int level,String subjectName) {
		try {
			PreparedStatement statement = con.prepareStatement("alter table level"+level+" add "+encode(subjectName)+" FLOAT");
			statement.execute();
			if(level==6) {
				PreparedStatement s = con.prepareStatement("alter table level6opt add "+encode(subjectName)+" varchar(5)");
				s.execute();
			}
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	boolean removeSubject(int level,String subjectName) {
		try {
			PreparedStatement check = con.prepareStatement("select count(*) from level"+level);
			ResultSet data = check.executeQuery();
			data.next();
			if(data.getInt(1)>0) {
				return false;
			}
			PreparedStatement statement = con.prepareStatement("alter table level"+level+" drop "+encode(subjectName));
			statement.execute();
			if(level==6) {
				PreparedStatement s = con.prepareStatement("alter table level6opt drop "+encode(subjectName));
				s.execute();
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
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
	boolean changeSubjectName(String subject,String newSubject,String level) {
		try {
			PreparedStatement statement = con.prepareStatement("alter table level"+level+" rename column "+encode(subject)+" to "+encode(newSubject));
			statement.execute();
			if(level=="6") {
				PreparedStatement stm = con.prepareStatement("alter table level6opt rename column "+encode(subject)+" to "+encode(newSubject));
				stm.execute();
				
			}
			return true;
		} catch (SQLException e) {
			System.out.print(e);
			return false;
		}
	}
	String hasPassed(String studentEmail,int studentLevel) {
		ArrayList<ArrayList<String>> markSheet = new ArrayList<ArrayList<String>>();
		markSheet = getStudentsMarks(studentEmail,studentLevel);
		ArrayList<String> marks = new ArrayList<String>();
		for(int i = 0; i<markSheet.size();i++) {
			marks.add(markSheet.get(i).get(2));
		}
		if(marks.contains("Marks Not Entered")) {
			return "Marks of subject/s missing.";
		}
		for(String i : marks) {
			if(Float.valueOf(i)<40) {
				return "Student has failed";
			}
		}
		return "Student has passed";
	}
}