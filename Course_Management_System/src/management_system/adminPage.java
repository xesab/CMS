package management_system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class adminPage extends JFrame {

	private JPanel contentPane;
	private JTextField teacherName;
	private JTextField teacherContact;
	private JTextField teacherEmail;
	private JTextField teacherPassword;
	private JTextField studentName;
	private JTextField studentContact;
	private JTextField studentEmail;
	private JTextField studentPassword;
	private JTextField subjectNameField;
	private JTextField newSubjectNameField;
	private JTable marksheetTable;
	
	public adminPage() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel dashboard = new JPanel();
		dashboard.setBackground(new Color(32, 178, 170));
		dashboard.setBounds(0, 0, 210, 613);
		contentPane.add(dashboard);
		dashboard.setLayout(null);
		
		// Log Out Button
		JButton logOutButton = new JButton("Log Out");
		logOutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_page logpage = new Login_page();
				logpage.setVisible(true);
				logpage.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		logOutButton.setBounds(24, 582, 85, 21);
		dashboard.add(logOutButton);
		
		
		//Panels
		
		//Detail Panel
		JPanel detailPanel = new JPanel();
		detailPanel.setBackground(new Color(100, 149, 237));
		detailPanel.setVisible(false);
		detailPanel.setBounds(209, 0, 847, 613);
		contentPane.add(detailPanel);
		detailPanel.setLayout(null);  
		detailPanel.setVisible(false);
		
		//Student Add Panel
		JPanel studentAddPanel = new JPanel();
		studentAddPanel.setBackground(new Color(100, 149, 237));
		studentAddPanel.setBounds(209, 0, 847, 613);
		contentPane.add(studentAddPanel);
		studentAddPanel.setLayout(null);
		studentAddPanel.setVisible(false);
		
		//Teacher Detail Panel
		JPanel teacherPanel = new JPanel();
		teacherPanel.setBackground(new Color(100, 149, 237));
		teacherPanel.setBounds(209, 0, 847, 613);
		contentPane.add(teacherPanel);
		teacherPanel.setLayout(null);
		teacherPanel.setVisible(false);
		
		//Teacher Add Panel
		JPanel addTeacherPanel = new JPanel();
		addTeacherPanel.setBackground(new Color(100, 149, 237));
		addTeacherPanel.setBounds(210, 0, 846, 613);
		contentPane.add(addTeacherPanel);
		addTeacherPanel.setLayout(null);
		addTeacherPanel.setVisible(false);
		
		//Remove Add Subject Panel
		JPanel subjectAddRemovePanel = new JPanel();
		subjectAddRemovePanel.setBackground(new Color(100, 149, 237));
		subjectAddRemovePanel.setBounds(209, 0, 847, 613);
		contentPane.add(subjectAddRemovePanel);
		subjectAddRemovePanel.setLayout(null);
		subjectAddRemovePanel.setVisible(false);
		
		//MarkSheetPanel
		JPanel markSheetPanel = new JPanel();
		markSheetPanel.setBackground(new Color(100, 149, 237));
		markSheetPanel.setBounds(209, 0, 847, 613);
		contentPane.add(markSheetPanel);
		markSheetPanel.setLayout(null);
		markSheetPanel.setVisible(false);
		
		
		//Detail Panel button
		JButton studentDataButton = new JButton("Student Details");
		studentDataButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Show Panel
				detailPanel.removeAll();
				studentAddPanel.setVisible(false);
				markSheetPanel.setVisible(false);
				teacherPanel.setVisible(false);
				detailPanel.setVisible(true);
				subjectAddRemovePanel.setVisible(false);
				addTeacherPanel.setVisible(false);
				
				teacherRunner Data = new teacherRunner();
				int j=0;
				JComboBox<String> studentBox = new JComboBox<String>();
				for (String i : Data.getStudentEmails()) {
					studentBox.insertItemAt(i, j);
					j++;
				}
				studentBox.setBounds(10, 50, 240, 40);
				detailPanel.add(studentBox);
				
				JLabel idLabel = new JLabel("Student ID ");
				idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				idLabel.setBounds(350, 50, 200, 50);
				detailPanel.add(idLabel);
				
				JLabel nameLabel = new JLabel("Name ");
				nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				nameLabel.setBounds(350, 150, 200, 50);
				detailPanel.add(nameLabel);
				
				JLabel levelLabel = new JLabel("Student Level");
				levelLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				levelLabel.setBounds(350, 450, 200, 50);
				detailPanel.add(levelLabel);
				
				JLabel emailLabel = new JLabel("Email");
				emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				emailLabel.setBounds(350, 250, 200, 50);
				detailPanel.add(emailLabel);
				
				JLabel contactLabel = new JLabel("Contact Number");
				contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contactLabel.setBounds(350, 350, 200, 50);
				detailPanel.add(contactLabel);
				
				JLabel ID = new JLabel("");
				ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
				ID.setBounds(560, 50, 230, 50);
				detailPanel.add(ID);
				
				JLabel name = new JLabel("");
				name.setFont(new Font("Tahoma", Font.PLAIN, 15));
				name.setBounds(560, 150, 230, 50);
				detailPanel.add(name);
				
				JLabel email = new JLabel("");
				email.setFont(new Font("Tahoma", Font.PLAIN, 15));
				email.setBounds(560, 250, 230, 50);
				detailPanel.add(email);
				
				JLabel contact = new JLabel("");
				contact.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contact.setBounds(560, 350, 230, 50);
				detailPanel.add(contact);
				
				JLabel studentlevel = new JLabel("");
				studentlevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				studentlevel.setBounds(560, 450, 230, 50);
				detailPanel.add(studentlevel);
				
				JButton getData = new JButton("Get Data");
				getData.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						adminRunner studentdata = new adminRunner();
						studentdata.setStudentEmail(String.valueOf(studentBox.getSelectedItem()));
						ID.setText(studentdata.getStudentID());
						name.setText(studentdata.getStudentName());
						email.setText(studentdata.getStudentEmail());
						contact.setText(studentdata.getStudentContact());
						studentlevel.setText(String.valueOf(studentdata.getStudentLevel()));
					}
				});
				getData.setBounds(10, 120, 150, 30);
				detailPanel.add(getData);
				
				JButton deleteStudentButton = new JButton("Remove Student");
				deleteStudentButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						new adminRunner().removeStudent(email.getText(),Integer.parseInt(studentlevel.getText()));
					}
				});
				deleteStudentButton.setBounds(10, 155, 150, 30);
				detailPanel.add(deleteStudentButton);
				
				
			}
		});
		studentDataButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		studentDataButton.setBounds(10, 80, 190, 50);
		dashboard.add(studentDataButton);
		
		
		
		//Add Student Button
		JButton addStudentButton = new JButton("Add Student");
		addStudentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				detailPanel.setVisible(false);
				teacherPanel.setVisible(false);
				markSheetPanel.setVisible(false);
				subjectAddRemovePanel.setVisible(false);
				addTeacherPanel.setVisible(false);
				studentAddPanel.setVisible(true);
				studentAddPanel.removeAll();
				
				
				studentName = new JTextField();
				studentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				studentName.setBounds(100, 110, 200, 40);
				studentAddPanel.add(studentName);
				studentName.setColumns(10);
				
				studentContact = new JTextField();
				studentContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
				studentContact.setColumns(10);
				studentContact.setBounds(340, 110, 200, 40);
				studentAddPanel.add(studentContact);
				
				studentEmail = new JTextField();
				studentEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
				studentEmail.setColumns(10);
				studentEmail.setBounds(100, 185, 200, 40);
				studentAddPanel.add(studentEmail);
				
				studentPassword = new JTextField();
				studentPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
				studentPassword.setColumns(10);
				studentPassword.setBounds(340, 185, 200, 40);
				studentAddPanel.add(studentPassword);
				
				JLabel nameLabel = new JLabel("Name");
				nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
				nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				nameLabel.setBounds(100, 70, 200, 35);
				studentAddPanel.add(nameLabel);
				
				JLabel contactLabel = new JLabel("Contact");
				contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
				contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				contactLabel.setBounds(340, 70, 200, 35);
				studentAddPanel.add(contactLabel);
				
				JLabel levelLabel = new JLabel("Level");
				levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
				levelLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				levelLabel.setBounds(575, 70, 200, 35);
				studentAddPanel.add(levelLabel);
				
				JLabel emailLabel = new JLabel("Email");
				emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
				emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				emailLabel.setBounds(100, 150, 200, 35);
				studentAddPanel.add(emailLabel);
				
				JLabel passwordLabel = new JLabel("Password");
				passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
				passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				passwordLabel.setBounds(340, 150, 200, 35);
				studentAddPanel.add(passwordLabel);
				
				JLabel outputLabel = new JLabel("");
				outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
				outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				outputLabel.setBounds(10, 450, 810, 35);
				studentAddPanel.add(outputLabel);
				
				JComboBox studentLevel = new JComboBox();
				studentLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				studentLevel.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
				studentLevel.setSelectedIndex(-1);
				studentLevel.setBounds(575, 110, 200, 40);
				studentAddPanel.add(studentLevel);
				
				JButton addButton = new JButton("Add Student");
				addButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (studentName.getText().equals("") && studentContact.getText().equals("") && studentLevel.getSelectedIndex()==-1 && studentEmail.getText().equals("") && studentPassword.getText().equals("")) {
							outputLabel.setText("!!! Information is / are missing !!!");
						}
						else {
							adminRunner run = new adminRunner();
							if(run.addStudent(studentName.getText(), studentContact.getText(), Integer.valueOf(String.valueOf(studentLevel.getSelectedItem())), studentPassword.getText(), studentEmail.getText())) {
								outputLabel.setText("Student Added Successfully");
								studentName.setText("");
								studentContact.setText("");
								studentLevel.setSelectedIndex(-1);
								studentPassword.setText("");
								studentEmail.setText("");
							}
							else {
								outputLabel.setText("!!! Error adding student Either Email or Contact already present !!!");
							}
							
						}
						
					}
				});
				addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				addButton.setBounds(340, 265, 200, 40);
				studentAddPanel.add(addButton);
				
				
			}
		});
		addStudentButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addStudentButton.setBounds(10, 140, 190, 50);
		dashboard.add(addStudentButton);
		
		
		//Teacher Detail panel button
		JButton teacherDetailButton = new JButton("Teacher Details");
		teacherDetailButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentAddPanel.setVisible(false);
				markSheetPanel.setVisible(false);
				detailPanel.setVisible(false);
				subjectAddRemovePanel.setVisible(false);
				addTeacherPanel.setVisible(false);
				teacherPanel.setVisible(true);
				teacherPanel.removeAll();
				
				JComboBox teacherEmailList = new JComboBox();
				adminRunner Data = new adminRunner();
				teacherEmailList.setFont(new Font("Tahoma", Font.PLAIN, 15));
				int j = 0;
				for (String i : Data.getTeacherEmails()) {
					teacherEmailList.insertItemAt(i, j);
					j++;
				}
				teacherEmailList.setBounds(10, 50, 240, 40);
				teacherPanel.add(teacherEmailList);
				
				JLabel IDlabel = new JLabel("Teacher ID");
				IDlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				IDlabel.setBounds(280, 70, 200, 50);
				teacherPanel.add(IDlabel);
				
				JLabel teacherID = new JLabel("");
				teacherID.setFont(new Font("Tahoma", Font.PLAIN, 15));
				teacherID.setBounds(490, 70, 230, 50);
				teacherPanel.add(teacherID);
				
				JLabel nameLabel = new JLabel("Teacher Name");
				nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				nameLabel.setBounds(280, 160, 200, 50);
				teacherPanel.add(nameLabel);
				
				JLabel emailLabel = new JLabel("Teacher Email");
				emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				emailLabel.setBounds(280, 250, 200, 50);
				teacherPanel.add(emailLabel);
				
				JLabel contactLabel = new JLabel("Teacher Contact");
				contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contactLabel.setBounds(280, 340, 200, 50);
				teacherPanel.add(contactLabel);
				
				JLabel subjectLabel = new JLabel("Teacher Subject");
				subjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				subjectLabel.setBounds(280, 430, 200, 50);
				teacherPanel.add(subjectLabel);
				
				JLabel teacherName = new JLabel("");
				teacherName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				teacherName.setBounds(490, 160, 230, 50);
				teacherPanel.add(teacherName);
				
				JLabel teacherEmail = new JLabel("");
				teacherEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
				teacherEmail.setBounds(490, 250, 230, 50);
				teacherPanel.add(teacherEmail);
				
				JLabel teacherContact = new JLabel("");
				teacherContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
				teacherContact.setBounds(490, 340, 230, 50);
				teacherPanel.add(teacherContact);
				
				JLabel teacherSubject = new JLabel("");
				teacherSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
				teacherSubject.setBounds(490, 430, 347, 50);
				teacherPanel.add(teacherSubject);
				
				JButton getTeacherData = new JButton("Get Data");
				getTeacherData.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						adminRunner data = new adminRunner();
						data.setTeacherEmail(String.valueOf(teacherEmailList.getSelectedItem()));
						teacherEmail.setText(data.getTeacherEmail());
						teacherName.setText(data.getTeacherName());
						teacherID.setText(data.getTeacherID());
						teacherContact.setText(data.getTeacherContact());
						teacherSubject.setText(data.getTeacherSubject());
						
						
					}
				});
				getTeacherData.setBounds(10, 120, 150, 30);
				teacherPanel.add(getTeacherData);
				
				JButton deleteTeacherButton = new JButton("Remove Teacher");
				deleteTeacherButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						new adminRunner().removeTeacher(String.valueOf(teacherEmailList.getSelectedItem()));
					}
				});
				deleteTeacherButton.setBounds(10, 155, 150, 30);
				teacherPanel.add(deleteTeacherButton);

			}
		});
		teacherDetailButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		teacherDetailButton.setBounds(10, 200, 190, 50);
		dashboard.add(teacherDetailButton);
		
		
		
		//Teacher add panel button
		JButton addTeacherPageButton = new JButton("Add Teacher");
		addTeacherPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentAddPanel.setVisible(false);
				markSheetPanel.setVisible(false);
				detailPanel.setVisible(false);
				teacherPanel.setVisible(false);
				subjectAddRemovePanel.setVisible(false);
				addTeacherPanel.setVisible(true);
				addTeacherPanel.removeAll();
				
				teacherName = new JTextField();
				teacherName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				teacherName.setBounds(200, 106, 200, 40);
				addTeacherPanel.add(teacherName);
				teacherName.setColumns(10);
				
				teacherContact = new JTextField();
				teacherContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
				teacherContact.setColumns(10);
				teacherContact.setBounds(440, 105, 200, 40);
				addTeacherPanel.add(teacherContact);
				
				teacherEmail = new JTextField();
				teacherEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
				teacherEmail.setColumns(10);
				teacherEmail.setBounds(200, 185, 200, 40);
				addTeacherPanel.add(teacherEmail);
				
				teacherPassword = new JTextField();
				teacherPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
				teacherPassword.setColumns(10);
				teacherPassword.setBounds(440, 185, 200, 40);
				addTeacherPanel.add(teacherPassword);
				
				JLabel nameLabel = new JLabel("Name");
				nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
				nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				nameLabel.setBounds(200, 70, 200, 35);
				addTeacherPanel.add(nameLabel);
				
				JLabel contactLabel = new JLabel("Contact");
				contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
				contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				contactLabel.setBounds(440, 70, 200, 35);
				addTeacherPanel.add(contactLabel);
				
				JLabel emailLabel = new JLabel("Email");
				emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
				emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				emailLabel.setBounds(200, 145, 200, 35);
				addTeacherPanel.add(emailLabel);
				
				JLabel passwordLabel = new JLabel("Password");
				passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
				passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				passwordLabel.setBounds(440, 145, 200, 35);
				addTeacherPanel.add(passwordLabel);
				
				JLabel outputLabel = new JLabel("");
				outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
				outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				outputLabel.setBounds(10, 450, 810, 35);
				addTeacherPanel.add(outputLabel);
				
				JComboBox subjectsBox = new JComboBox();
				adminRunner Data = new adminRunner();
				subjectsBox.setBounds(200, 290, 445, 40);
				int j = 0;
				for (String i : Data.getAllSubjects()) {
					subjectsBox.insertItemAt(i, j);
					j++;
				}
				addTeacherPanel.add(subjectsBox);
				
				JLabel subjectLabel = new JLabel("Select Subject");
				subjectLabel.setHorizontalAlignment(SwingConstants.CENTER);
				subjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				subjectLabel.setBounds(200, 245, 440, 35);
				addTeacherPanel.add(subjectLabel);
				
				JButton addTeacherButton = new JButton("Add Teacher");
				addTeacherButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(teacherName.getText().equals("") && teacherContact.getText().equals("") && teacherPassword.getText().equals("") && teacherEmail.getText().equals("") && (subjectsBox.getSelectedIndex() == -1) )  {
							outputLabel.setText("!!! Information is/are missing !!!");
						}
						else {
							if (new adminRunner().addTeacher(teacherName.getText(), teacherContact.getText(), teacherPassword.getText(), teacherEmail.getText(), String.valueOf(subjectsBox.getSelectedItem()))) {
								outputLabel.setText("Teacher Added Successfully");
								teacherName.setText("");
								teacherContact.setText("");
								teacherEmail.setText("");
								teacherPassword.setText("");
								subjectsBox.setSelectedIndex(-1);
							}
							else {
								outputLabel.setText("!!! Error adding student Either Email or Contact already present !!!");
							}
						}
						
					}
				});
				addTeacherButton.setBounds(320, 350, 200, 30);
				addTeacherPanel.add(addTeacherButton);
				
			}
		});
		addTeacherPageButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addTeacherPageButton.setBounds(10, 260, 190, 50);
		dashboard.add(addTeacherPageButton);
		
		
		
		//Subject manage panel button
		JButton subjectManageButton = new JButton("Manage Subjects");
		subjectManageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				studentAddPanel.setVisible(false);
				markSheetPanel.setVisible(false);
				detailPanel.setVisible(false);
				teacherPanel.setVisible(false);
				addTeacherPanel.setVisible(false);
				subjectAddRemovePanel.setVisible(true);
				subjectAddRemovePanel.removeAll();
				
				JComboBox levelBox2 = new JComboBox();
				levelBox2.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
				levelBox2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				levelBox2.setBounds(60, 70, 80, 40);
				subjectAddRemovePanel.add(levelBox2);
				
				JLabel selectLevel = new JLabel("Select Level");
				selectLevel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				selectLevel.setBounds(60, 30, 300, 40);
				subjectAddRemovePanel.add(selectLevel);
				
				JComboBox allSubjectsBox = new JComboBox();
				adminRunner Data = new adminRunner();
				allSubjectsBox.setBounds(60, 170, 450, 40);
				subjectAddRemovePanel.add(allSubjectsBox);
				
				JLabel deletSubjectLabel = new JLabel("Select Subject To Delete");
				deletSubjectLabel.setHorizontalAlignment(SwingConstants.CENTER);
				deletSubjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				deletSubjectLabel.setBounds(60, 120, 450, 40);
				subjectAddRemovePanel.add(deletSubjectLabel);
				
				subjectNameField = new JTextField();
				subjectNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				subjectNameField.setBounds(60, 390, 450, 40);
				subjectAddRemovePanel.add(subjectNameField);
				subjectNameField.setColumns(10);
				
				JLabel subjectSelectLabel = new JLabel("Enter Subject Name to add");
				subjectSelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
				subjectSelectLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				subjectSelectLabel.setBounds(60, 335, 450, 40);
				subjectAddRemovePanel.add(subjectSelectLabel);
				
				JLabel levelLabel = new JLabel("Select Level");
				levelLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				levelLabel.setBounds(60, 447, 120, 40);
				subjectAddRemovePanel.add(levelLabel);
				
				JComboBox levelBox = new JComboBox();
				levelBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
				levelBox.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
				levelBox.setBounds(60, 490, 80, 40);
				subjectAddRemovePanel.add(levelBox);
				
				
				JLabel outputLabel = new JLabel("");
				outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
				outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				outputLabel.setBounds(10, 550, 830, 50);
				subjectAddRemovePanel.add(outputLabel);
				
				JButton btnNewButton = new JButton("Get Subjects");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						allSubjectsBox.removeAllItems();
						int j = 0;
						for (String i : Data.getSubjects(Integer.valueOf(String.valueOf(levelBox2.getSelectedItem())))) {
							allSubjectsBox.insertItemAt(i, j);
							j++;
						}
						allSubjectsBox.setSelectedIndex(0);
					}
				});
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton.setBounds(200, 70, 120, 40);
				subjectAddRemovePanel.add(btnNewButton);
				
				
				JButton deleteSubject = new JButton("Delete Subject");
				deleteSubject.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(allSubjectsBox.getSelectedIndex()==-1) {
							outputLabel.setText("!!! Please select the subject first !!!");
						}
						else {
							if(new adminRunner().removeSubject(Integer.valueOf(String.valueOf(levelBox2.getSelectedItem())), String.valueOf(allSubjectsBox.getSelectedItem()))) {
								outputLabel.setText("!!! Subject successfully deleted !!!");
							}else {
								outputLabel.setText("!!! Couldn't delete subject, either student still studying this subject !!!");
							}
						}
					}
				});
				deleteSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
				deleteSubject.setBounds(520, 170, 160, 40);
				subjectAddRemovePanel.add(deleteSubject);
				
				JButton btnAddSubject = new JButton("Add Subject");
				btnAddSubject.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(subjectNameField.getText().equals("")) {
							outputLabel.setText("!!! Please enter a subject name first !!!");
						}
						else if (new adminRunner().addSubject(Integer.valueOf(String.valueOf(levelBox.getSelectedItem())),subjectNameField.getText())){
							outputLabel.setText("!!! Successfully added subject !!!");
							subjectNameField.setText("");
						}
						else {
							outputLabel.setText("!!! Error adding subject or subject already present !!!");
						}
					}
				});
				btnAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnAddSubject.setBounds(200, 490, 160, 40);
				subjectAddRemovePanel.add(btnAddSubject);
				
				newSubjectNameField = new JTextField();
				newSubjectNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				newSubjectNameField.setBounds(60, 285, 450, 40);
				subjectAddRemovePanel.add(newSubjectNameField);
				newSubjectNameField.setColumns(10);
				
				JLabel editLabel = new JLabel("Enter new name to for selected Subject");
				editLabel.setHorizontalAlignment(SwingConstants.CENTER);
				editLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				editLabel.setBounds(60, 235, 450, 40);
				subjectAddRemovePanel.add(editLabel);
				
				JButton editSubjectNameButton = new JButton("Edit Subject Name");
				editSubjectNameButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String levelF = String.valueOf(levelBox2.getSelectedItem());
						String subjectNameF = String.valueOf(allSubjectsBox.getSelectedItem());
						String newSubjectNameF = newSubjectNameField.getText();
						if(newSubjectNameF.equals("")) {
							outputLabel.setText("Enter new subject name");
						}else if(levelBox.getSelectedIndex()==-1) {
							outputLabel.setText("First select the level of subject");
						}else if(allSubjectsBox.getSelectedIndex()==-1) {
							outputLabel.setText("First select the name of subject");
						}else if(new adminRunner().changeSubjectName(subjectNameF, newSubjectNameF, levelF)){
							outputLabel.setText("Subject Name successfully changed");
							newSubjectNameField.setText("");
						}else {
							outputLabel.setText("Error changing subject name is database");
						}
					}
				});
				editSubjectNameButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				editSubjectNameButton.setBounds(520, 285, 160, 40);
				subjectAddRemovePanel.add(editSubjectNameButton);

			}
		});
		subjectManageButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subjectManageButton.setBounds(10, 320, 190, 50);
		dashboard.add(subjectManageButton);
		
		JButton marksTabelButton = new JButton("Generate Marksheet");
		marksTabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				markSheetPanel.removeAll();
				studentAddPanel.setVisible(false);
				detailPanel.setVisible(false);
				teacherPanel.setVisible(false);
				addTeacherPanel.setVisible(false);
				subjectAddRemovePanel.setVisible(false);
				markSheetPanel.setVisible(true);
				
				adminRunner Data = new adminRunner();
				JComboBox studentEmailBox = new JComboBox();
				int j=0;
				for (String i : Data.getStudentEmails()) {
					studentEmailBox.insertItemAt(i, j);
					j++;
				}
				studentEmailBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
				studentEmailBox.setBounds(10, 60, 200, 30);
				markSheetPanel.add(studentEmailBox);
				
				JComboBox levelBox = new JComboBox();
				levelBox.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
				levelBox.setBounds(10, 100, 50, 20);
				markSheetPanel.add(levelBox);
				
				JLabel outputLabel = new JLabel("");
				outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				outputLabel.setBounds(250, 120, 400, 30);
				markSheetPanel.add(outputLabel);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 160, 830, 450);
				markSheetPanel.add(scrollPane);
				String[] test = { "Subject Name", "Full Marks","Marks Optained","Grade" };
				DefaultTableModel md = new DefaultTableModel(test, 0);
				
				marksheetTable = new JTable(md);
				marksheetTable.getColumnModel().getColumn(0).setPreferredWidth(400);
				marksheetTable.setRowHeight(50);
				marksheetTable.setEnabled(false);
				
				scrollPane.setViewportView(marksheetTable);
				
				JLabel selectStudentLabel = new JLabel("Select Student Email");
				selectStudentLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				selectStudentLabel.setBounds(10, 10, 250, 40);
				markSheetPanel.add(selectStudentLabel);
				
				
				JButton getMarksheetbutton = new JButton("Generate Marksheet");
				getMarksheetbutton.setFont(new Font("Tahoma", Font.PLAIN, 10));
				getMarksheetbutton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
						int studentLevel = Integer.valueOf(String.valueOf((levelBox.getSelectedItem())));
						Data.setStudentEmail(String.valueOf(studentEmailBox.getSelectedItem()));
						while(md.getRowCount()>0) {
							md.removeRow(0);
						}
						ArrayList<ArrayList<String>> subjectNameMarksArray = new ArrayList<ArrayList<String>>();
						subjectNameMarksArray = new studentRunner().getStudentsMarks(Data.getStudentEmail(), studentLevel);
						if(subjectNameMarksArray.isEmpty()) {
							throw new Exception("Array is Empty");
						}
						for(int i = 0;i<subjectNameMarksArray.size();i++) {
							Object[] row = subjectNameMarksArray.get(i).toArray();
							md.addRow(row);
						}
						outputLabel.setText("");
						}catch(Exception exp) {
							outputLabel.setText("Error finding result at selected level");
						}
					}
				});
				getMarksheetbutton.setBounds(10, 130, 150, 20);
				markSheetPanel.add(getMarksheetbutton);
				
				JButton passStudentButton = new JButton("Update Level");
				passStudentButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						adminRunner run = new adminRunner();
						run.setStudentEmail(String.valueOf(studentEmailBox.getSelectedItem()));
						String answer = run.hasPassed(run.getStudentEmail(), run.getStudentLevel());
						if(answer.equals("Marks of subject/s missing.")) {
							outputLabel.setText("Marks of student missing so student level cannot be updated.");
						}else if(answer.equals("Student has failed")) {
							outputLabel.setText("Student has failed and cannot go to next level");
						}else if(answer.equals("Student has passed")) {
							if(run.updateStudent(run.getStudentEmail(),run.getStudentLevel()+1)) {
								outputLabel.setText("Student has passed and has be successfully moved to next level");
							}else {
								outputLabel.setText("Student already present in next level Or Error moving student");
							}
						}
					}
				});
				passStudentButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
				passStudentButton.setBounds(720, 130, 100, 20);
				markSheetPanel.add(passStudentButton);
				
			}
		});
		marksTabelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		marksTabelButton.setBounds(10, 380, 190, 60);
		dashboard.add(marksTabelButton);
	}
}