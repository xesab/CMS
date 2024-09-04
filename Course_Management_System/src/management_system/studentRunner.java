package management_system;
import java.sql.*;
import java.util.ArrayList;

public class studentRunner {
	connector connection = new connector();
	Connection con = connection.getConnection();
	
	String studentEmail;
	
	void setStudentEmail(String studentEmail){
		this.studentEmail=studentEmail;
	}
	
	ResultSet getStudentData(){
        try {
            String select = "select * from studentdata where studentEmail = '"+studentEmail+"'";
            PreparedStatement statement = con.prepareStatement(select);
            return statement.executeQuery();
        }
        catch (SQLException e){
        	System.out.println(e);
        }
        return null;
    }
	
	String getStudentName(){
		try {
			ResultSet result = getStudentData();
			result.next();
			return result.getString("studentName");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return null;
		
	}
	
	String getStudentID() {
		try {
			ResultSet result = getStudentData();
			result.next();
			return result.getString("studentID");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return null;
	}
	
	int getStudentLevel() {
		try {
			ResultSet result = getStudentData();
			result.next();
			return result.getInt("studentLevel");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return 0;
	}
	
	String getStudentContact() {
		try {
			ResultSet result = getStudentData();
			result.next();
			return result.getString("studentContact");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return null;
	}
	String getStudentEmail() {
		try {
			ResultSet result = getStudentData();
			result.next();
			return result.getString("studentEmail");
		} catch (SQLException e) {
			System.out.print(e);
		}
		return null;
		
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
	
	ArrayList<ArrayList<String>> getTeacherName(int level){
		ArrayList<ArrayList<String>> arryNames = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> arrySubjects = new ArrayList<>();
		arrySubjects = getSubjects(level);
		try {
			PreparedStatement statement = con.prepareStatement("select * from teacherdata");
			ResultSet data = statement.executeQuery();
			while(data.next()){
				if(arrySubjects.contains(data.getString("teacherSubject"))) {
					ArrayList<String> teacherDetail = new ArrayList<>();
					teacherDetail.add(data.getString("teacherName"));
					teacherDetail.add(data.getString("teacherSubject"));
					teacherDetail.add(data.getString("teacherEmail"));
					teacherDetail.add(data.getString("teacherContact"));
					arryNames.add(teacherDetail);
				}
			}
			return (arryNames);
		} catch (SQLException e) {
			return null;
		}
	}
	
	String getMarks(String subjectName,String Email,int level) {
		try {
			PreparedStatement statement = con.prepareStatement("select "+encode(subjectName)+" from level"+level+" where studentEmail = '"+Email+"'");
			ResultSet data = statement.executeQuery();
			data.next();
			if (data.getString(1)==null) {
				return "Marks Not Entered";
			}
			return String.valueOf(data.getString(1));
		} catch (SQLException e) {
			return "No Marks Found";
		}
	}
	
	ArrayList<ArrayList<String>> getStudentsMarks(String studentEmail,int studentLevel){
		if(studentLevel==6) {
			ArrayList<ArrayList<String>> marksArray = new ArrayList<ArrayList<String>>();
			ArrayList<String> subjectNames = new ArrayList<>();
			subjectNames = getSubjects(studentLevel);
			for(String i : subjectNames) {
				boolean selected = checkSelected(studentEmail,i);
				if(selected) {
					ArrayList<String> arry = new ArrayList<>();
					arry.add(i);
					arry.add("100");
					String marks = getMarks(i,studentEmail,studentLevel);
					if(marks != "Marks Not Entered") {
						arry.add(marks);
						arry.add(getGrade(Float.valueOf(marks)));
					}else {
						arry.add("Marks Not Entered");
						arry.add("N/a");
					}
					marksArray.add(arry);
				}
			}
			return marksArray;
		}else {
			ArrayList<ArrayList<String>> marksArray = new ArrayList<ArrayList<String>>();
			ArrayList<String> subjectNames = new ArrayList<>();
			subjectNames = getSubjects(studentLevel);
			for(String i :subjectNames) {
				ArrayList<String> arry = new ArrayList<>();
				arry.add(i);
				arry.add("100");
				String marks = getMarks(i,studentEmail,studentLevel);
				if(marks != "Marks Not Entered") {
					arry.add(marks);
					arry.add(getGrade(Float.valueOf(marks)));
				}else {
					arry.add("Marks Not Entered");
					arry.add("N/a");
				}
				marksArray.add(arry);
			}
			return marksArray;
		}
		
	}
	String getGrade(Float marks) {
		if (marks<=100 && marks>=90) {
			return "A+";
		}else if(marks<90 && marks>=80) {
			return "A";
		}else if(marks<80 && marks>=70) {
			return "B+";
		}else if(marks<70 && marks>=60) {
			return "B";
		}else if(marks<60 && marks>=50) {
			return "C+";
		}else if(marks<50 && marks>=40) {
			return "C";
		}else if(marks<40 && marks>=30) {
			return "D+";
		}else if(marks<30 && marks>=20) {
			return "D";
		}else if(marks<20 && marks>=0){
			return "E";
		}
		return "";
	}
	boolean checkSelected(String studentEmail,String subjectName) {
		try {
			subjectName = encode(subjectName);
			PreparedStatement stm = con.prepareStatement("select "+subjectName+" from level6opt where studentEmail = '"+studentEmail+"'");
			ResultSet data = stm.executeQuery();
			data.next();
			String yes_no = String.valueOf(data.getString(subjectName));
			if(yes_no.equals("Yes")) {
				return true;
			}else {
				return false;
			}
		}catch (SQLException e) {
			return false;
		}
	}
	boolean setSelection(String studentEmail,String subjectName) {
		try {
			subjectName = encode(subjectName);
			PreparedStatement statement  = con.prepareStatement("update level6opt set "+subjectName+" = 'Yes' where studentEmail = '"+studentEmail+"'");
			statement.execute();
			return true;  
			
		}catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	int getRemainingSelection(String studentEmail) {
		int selectionLeft = 4;
		try {
			PreparedStatement statement = con.prepareStatement("select * from level6opt where studentEmail = '"+studentEmail+"'");
			ResultSet data = statement.executeQuery();
			data.next();
			ArrayList<String> subjectNames = new ArrayList<String>();
			subjectNames = getSubjects(6);
			for(String i : subjectNames) {
				if (checkSelected(studentEmail,encode(i))) {
					selectionLeft=selectionLeft-1;
				}
				
			}
			return selectionLeft;
		} catch (SQLException e) {
			System.out.print(e);
		}
		
		return selectionLeft;
	}
}
