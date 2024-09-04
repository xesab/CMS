package management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RunningScripts {
	private String username;
	private String password;
	private String databaseName;
	public RunningScripts(String usernameFromConnector,String passwordFromConnector,String databaseNameFromConnector) {
		this.username=usernameFromConnector;
		this.password=passwordFromConnector;
		this.databaseName=databaseNameFromConnector;
		   Connection con;
		   String url = "jdbc:mysql://localhost:3306/";
		   try {
	           con = DriverManager.getConnection(url,username,password);
	           
	           //Check and Creating Schema
	           PreparedStatement databaseQuery = con.prepareStatement("CREATE DATABASE  IF NOT EXISTS "+databaseName);
	           databaseQuery.execute();
	           
	           PreparedStatement use = con.prepareStatement("USE "+databaseName);
	           use.execute();
	           
	           //Admin Table Creation
	           PreparedStatement dropadmin = con.prepareStatement("DROP TABLE IF EXISTS admindata");
	           dropadmin.execute();
	           
	           PreparedStatement adminTable = con.prepareStatement("CREATE TABLE admindata (\r\n"
	           		+ "  adminID int NOT NULL AUTO_INCREMENT,\r\n"
	           		+ "  adminEmail varchar(45) DEFAULT NULL,\r\n"
	           		+ "  adminPassword varchar(45) DEFAULT NULL,\r\n"
	           		+ "  PRIMARY KEY (adminID)\r\n"
	           		+ ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
	           adminTable.execute();
	           
	           PreparedStatement lockAdmin = con.prepareStatement("LOCK TABLES admindata WRITE");
	           lockAdmin.execute();
	           
	           PreparedStatement addAdmin = con.prepareStatement("INSERT INTO admindata VALUES (1,'admin','password')");
	           addAdmin.execute();
	           
	           PreparedStatement unlockAdmin = con.prepareStatement("UNLOCK TABLES");
	           unlockAdmin.execute();
	           
	           
	           //Level 4 table creation
	           PreparedStatement dropLevel4 = con.prepareStatement("DROP TABLE IF EXISTS level4");
	           dropLevel4.execute();
	           
	           PreparedStatement level4 = con.prepareStatement("CREATE TABLE `level4` (\r\n"
	           		+ "  `studentEmail` varchar(50) DEFAULT NULL,\r\n"
	           		+ "  `Academin_Skills` float DEFAULT NULL,\r\n"
	           		+ "  `Fundamentals_of_Computing` float DEFAULT NULL,\r\n"
	           		+ "  `Embedded_System_Programming` float DEFAULT NULL,\r\n"
	           		+ "  `Internet_Software_Architecture` float DEFAULT NULL,\r\n"
	           		+ "  `Computational_Mathematics` float DEFAULT NULL,\r\n"
	           		+ "  `Introductory_Programming_and_Problem_Solving` float DEFAULT NULL\r\n"
	           		+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
	           level4.execute();
	           
	           PreparedStatement lockLevel4 = con.prepareStatement("LOCK TABLES `level4` WRITE");
	           lockLevel4.execute();
	           
	           PreparedStatement addLevel4 = con.prepareStatement("INSERT INTO `level4` VALUES ('keshab@gmail.com',76,89,91,86,86,86),('level4@failed.com',76,89,65,34,12,6),('level4@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL)");
	           addLevel4.execute();
	           
	           PreparedStatement unlockLevel4 = con.prepareStatement("UNLOCK TABLES");
	           unlockLevel4.execute();
	           
	           
	           //Level 5 Table Creation
	           PreparedStatement dropLevel5 = con.prepareStatement("DROP TABLE IF EXISTS `level5`");
	           dropLevel5.execute();
	           
	           PreparedStatement level5 = con.prepareStatement("CREATE TABLE `level5` (\r\n"
	           		+ "  `studentEmail` varchar(50) DEFAULT NULL,\r\n"
	           		+ "  `Concept_of_AI` float DEFAULT NULL,\r\n"
	           		+ "  `Object_Oriented_Design_and_Programming` float DEFAULT NULL,\r\n"
	           		+ "  `Numerical_Methods_and_Concurrency` float DEFAULT NULL,\r\n"
	           		+ "  `Distributed_and_Cloud_System_Programming` float DEFAULT NULL,\r\n"
	           		+ "  `Collaborative_Development` float DEFAULT NULL,\r\n"
	           		+ "  `Human_Computer_Interaction` float DEFAULT NULL\r\n"
	           		+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
	           level5.execute();
	           
	           PreparedStatement lockLevel5 = con.prepareStatement("LOCK TABLES `level5` WRITE");
	           lockLevel5.execute();
	           
	           PreparedStatement addLevel5 = con.prepareStatement("INSERT INTO `level5` VALUES ('keshab@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL)");
	           addLevel5.execute();
	           
	           PreparedStatement unlockLevel5 = con.prepareStatement("UNLOCK TABLES");
	           unlockLevel5.execute();
	           
	           
	           //Level 6 Table Creation
	           PreparedStatement dropLevel6 = con.prepareStatement("DROP TABLE IF EXISTS `level6`");
	           dropLevel6.execute();
	           
	           PreparedStatement level6 = con.prepareStatement("CREATE TABLE `level6` (\r\n"
	           		+ "  `studentEmail` varchar(50) DEFAULT NULL,\r\n"
	           		+ "  `Complex_System` float DEFAULT NULL,\r\n"
	           		+ "  `High_Performance_Computing` float DEFAULT NULL,\r\n"
	           		+ "  `Project_and_Professionalism` float DEFAULT NULL,\r\n"
	           		+ "  `Artificial_Intelligence_and_Machine_Learning` float DEFAULT NULL,\r\n"
	           		+ "  `Big_Data` float DEFAULT NULL\r\n"
	           		+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
	           level6.execute();
	           
	           PreparedStatement lockLevel6 = con.prepareStatement("LOCK TABLES `level6` WRITE");
	           lockLevel6.execute();
	           
	           PreparedStatement unlockLevel6 = con.prepareStatement("UNLOCK TABLES");
	           unlockLevel6.execute();
	           
	           
	           //Level 6 Opt Creation
	           PreparedStatement dropLevel6opt = con.prepareStatement("DROP TABLE IF EXISTS `level6opt`");
	           dropLevel6opt.execute();
	           
	           PreparedStatement level6opt = con.prepareStatement("CREATE TABLE `level6opt` (\r\n"
	           		+ "  `studentEmail` varchar(50) DEFAULT NULL,\r\n"
	           		+ "  `Complex_System` varchar(5) DEFAULT NULL,\r\n"
	           		+ "  `High_Performance_Computing` varchar(5) DEFAULT NULL,\r\n"
	           		+ "  `Project_and_Professionalism` varchar(5) DEFAULT NULL,\r\n"
	           		+ "  `Artificial_Intelligence_and_Machine_Learning` varchar(5) DEFAULT NULL,\r\n"
	           		+ "  `Big_Data` varchar(5) DEFAULT NULL,\r\n"
	           		+ "  UNIQUE KEY `studentEmail_UNIQUE` (`studentEmail`)\r\n"
	           		+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
	           level6opt.execute();
	           
	           PreparedStatement lockLevel6opt = con.prepareStatement("LOCK TABLES `level6opt` WRITE");
	           lockLevel6opt.execute();
	           
	           PreparedStatement unlockLevel6opt = con.prepareStatement("UNLOCK TABLES");
	           unlockLevel6opt.execute();
	           
	           
	           
	           //Student Data creation 
	           PreparedStatement dropStudent = con.prepareStatement("DROP TABLE IF EXISTS `studentdata`");
	           dropStudent.execute();
	           
	           PreparedStatement studentTable = con.prepareStatement("CREATE TABLE `studentdata` (\r\n"
	           		+ "  `studentID` int NOT NULL AUTO_INCREMENT,\r\n"
	           		+ "  `studentName` varchar(50) DEFAULT NULL,\r\n"
	           		+ "  `studentContact` varchar(20) DEFAULT NULL,\r\n"
	           		+ "  `studentLevel` int DEFAULT NULL,\r\n"
	           		+ "  `studentPassword` varchar(45) DEFAULT NULL,\r\n"
	           		+ "  `studentEmail` varchar(45) DEFAULT NULL,\r\n"
	           		+ "  PRIMARY KEY (`studentID`),\r\n"
	           		+ "  UNIQUE KEY `studentEmail_UNIQUE` (`studentEmail`)\r\n"
	           		+ ") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
	           studentTable.execute();
	           
	           PreparedStatement lockStudent = con.prepareStatement("LOCK TABLES `studentdata` WRITE");
	           lockStudent.execute();
	           
	           PreparedStatement addStudent = con.prepareStatement("INSERT INTO `studentdata` VALUES (1,'Keshab Saud','9861120645',5,'ksb123','keshab@gmail.com'),(2,'Level 4 Failed','6666666666',4,'123','level4@failed.com'),(3,'Level 4 studiying','123456789',4,'123123','level4@gmail.com')");
	           addStudent.execute();
	           
	           PreparedStatement unlockStudent = con.prepareStatement("UNLOCK TABLES");
	           unlockStudent.execute();
	           
	           
	           //Teacher Table Creation
	           PreparedStatement dropTeacher = con.prepareStatement("DROP TABLE IF EXISTS `teacherdata`");
	           dropTeacher.execute();
	           
	           PreparedStatement teacherTable = con.prepareStatement("CREATE TABLE `teacherdata` (\r\n"
	           		+ "  `teacherID` int NOT NULL AUTO_INCREMENT,\r\n"
	           		+ "  `teacherName` varchar(50) DEFAULT NULL,\r\n"
	           		+ "  `teacherSubject` varchar(50) DEFAULT NULL,\r\n"
	           		+ "  `teacherEmail` varchar(50) DEFAULT NULL,\r\n"
	           		+ "  `teacherPassword` varchar(50) DEFAULT NULL,\r\n"
	           		+ "  `teacherContact` varchar(20) DEFAULT NULL,\r\n"
	           		+ "  PRIMARY KEY (`teacherID`),\r\n"
	           		+ "  UNIQUE KEY `teacherEmail_UNIQUE` (`teacherEmail`)\r\n"
	           		+ ") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
	           teacherTable.execute();
	           
	           PreparedStatement lockTeacher = con.prepareStatement("LOCK TABLES `teacherdata` WRITE");
	           lockTeacher.execute();
	           
	           PreparedStatement addTeacher = con.prepareStatement("INSERT INTO `teacherdata` VALUES (1,'Yugant Basnet','Object Oriented Design and Programming','yugant@gmail.com','yug@123','1234567890'),(2,'Kushal S','Object Oriented Design and Programming','kushal@gmail.com','k@123','12456378'),(3,'Ramesh Tmls','Numerical Methods and Concurrency','ramesh@gmail.com','r@123','986930463'),(4,'Prabesh Gurung','Concepts and Technologies of AI','prabesh@gmail.com','p@123','9861130541'),(5,'Prasidha Sir','Distributed and Cloud System Programming','prasidha@gmail.com','p@123','986021512'),(6,'Big Data teacher','Big Data','bigdata@gmail.com','t123','9875445554');");
	           addTeacher.execute();
	           
	           PreparedStatement unlockTeacher = con.prepareStatement("UNLOCK TABLES");
	           unlockTeacher.execute();
	           
	       } catch (SQLException e) {
	           System.out.println(e);
	       }
	}
   public static void main(String args[]) throws Exception {
	   
	   
   }
}