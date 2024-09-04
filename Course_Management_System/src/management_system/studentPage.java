package management_system;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class studentPage extends JFrame {
	String studentEmailFromLogin;  
	private JPanel contentPane;
	private JTable table;
	private JTable marksTable;
	private JTable teacherDetailTable;
	private JTable marksheetTable;
	
	public studentPage(String studentEmailFromLogin) {
		this.studentEmailFromLogin = studentEmailFromLogin;
		
		studentRunner studentData = new studentRunner();
		studentData.setStudentEmail(studentEmailFromLogin);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel dashboard = new JPanel();
		dashboard.setBackground(new Color(32, 178, 170));
		dashboard.setBounds(0, 0, 210, 613);
		contentPane.add(dashboard);
		dashboard.setLayout(null);
		
		//Log Out Button
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
		
		
		//Detail Panel
		JPanel detailPanel = new JPanel();
		detailPanel.setBackground(new Color(100, 149, 237));
		detailPanel.setVisible(false);
		detailPanel.setBounds(209, 0, 847, 613);
		contentPane.add(detailPanel);
		detailPanel.setLayout(null);
		detailPanel.setVisible(false);
		
		//Teacher Detail Panel
		JPanel teacherDetails = new JPanel();
		teacherDetails.setBackground(new Color(100, 149, 237));
		teacherDetails.setBounds(209, 0, 847, 613);
		contentPane.add(teacherDetails);
		teacherDetails.setLayout(null);
		teacherDetails.setVisible(false);
		
		//MarkSheetPanel
		JPanel markSheetPanel = new JPanel();
		markSheetPanel.setBackground(new Color(100, 149, 237));
		markSheetPanel.setBounds(209, 0, 847, 613);
		contentPane.add(markSheetPanel);
		markSheetPanel.setLayout(null);
		markSheetPanel.setVisible(false);
		
		//Level 6 Subject Choosing Panel
		JPanel subjectSelectionPanel = new JPanel();
		subjectSelectionPanel.setBackground(new Color(100, 149, 237));
		subjectSelectionPanel.setBounds(210, 0, 846, 613);
		contentPane.add(subjectSelectionPanel);
		subjectSelectionPanel.setLayout(null);
		subjectSelectionPanel.setVisible(false);
		
		
		//Details Button
		JButton detailsButton = new JButton("Student Detail");
		detailsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				detailPanel.removeAll();
				detailPanel.setVisible(true);
				teacherDetails.setVisible(false);
				markSheetPanel.setVisible(false);
				subjectSelectionPanel.setVisible(false);
				
				JLabel idLabel = new JLabel("Student ID ");
				idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				idLabel.setBounds(50, 50, 200, 50);
				detailPanel.add(idLabel);
				
				JLabel nameLabel = new JLabel("Name ");
				nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				nameLabel.setBounds(50, 150, 200, 50);
				detailPanel.add(nameLabel);
				
				JLabel levelLabel = new JLabel("Student Level");
				levelLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				levelLabel.setBounds(50, 450, 200, 50);
				detailPanel.add(levelLabel);
				
				JLabel emailLabel = new JLabel("Email");
				emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				emailLabel.setBounds(50, 250, 200, 50);
				detailPanel.add(emailLabel);
				
				JLabel contactLabel = new JLabel("Contact Number");
				contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contactLabel.setBounds(50, 350, 200, 50);
				detailPanel.add(contactLabel);
				
				JLabel ID = new JLabel("");
				ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
				ID.setBounds(260, 50, 219, 50);
				detailPanel.add(ID);
				
				JLabel name = new JLabel("");
				name.setFont(new Font("Tahoma", Font.PLAIN, 15));
				name.setBounds(260, 150, 219, 50);
				detailPanel.add(name);
				
				JLabel email = new JLabel("");
				email.setFont(new Font("Tahoma", Font.PLAIN, 15));
				email.setBounds(260, 250, 219, 50);
				detailPanel.add(email);
				
				JLabel contact = new JLabel("");
				contact.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contact.setBounds(260, 350, 219, 50);
				detailPanel.add(contact);
				
				JLabel studentlevel = new JLabel("");
				studentlevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				studentlevel.setBounds(260, 450, 219, 50);
				detailPanel.add(studentlevel);
				
				
				ID.setText(studentData.getStudentID());
				name.setText(studentData.getStudentName());
				email.setText(studentData.getStudentEmail());
				contact.setText(studentData.getStudentContact());
				studentlevel.setText(String.valueOf(studentData.getStudentLevel()));
			}
		});
		detailsButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		detailsButton.setBounds(10, 70, 190, 60);
		dashboard.add(detailsButton);
		
		// View Teacher Button
		JButton viewTeacherButton = new JButton("View Teachers");
		viewTeacherButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				teacherDetails.removeAll();
				teacherDetails.setVisible(true);
				detailPanel.setVisible(false);
				markSheetPanel.setVisible(false);
				subjectSelectionPanel.setVisible(false);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 847, 613);
				teacherDetails.add(scrollPane);
				String[] test = { "Name", "Subject","Email","Contact" };
				DefaultTableModel md = new DefaultTableModel(test, 0);
				
				teacherDetailTable = new JTable(md);
				teacherDetailTable.getColumnModel().getColumn(0).setPreferredWidth(15);
				teacherDetailTable.getColumnModel().getColumn(1).setPreferredWidth(200);
				teacherDetailTable.setRowHeight(50);
				teacherDetailTable.setEnabled(false);
				
				ArrayList<ArrayList<String>> teacherDataArray = new ArrayList<ArrayList<String>>();
				teacherDataArray = new studentRunner().getTeacherName(studentData.getStudentLevel());
				for(int i = 0;i<teacherDataArray.size();i++) {
					Object[] row = teacherDataArray.get(i).toArray();
					md.addRow(row);
				}
				scrollPane.setViewportView(teacherDetailTable);
				
			}
		});
		viewTeacherButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewTeacherButton.setBounds(10, 140, 190, 60);
		dashboard.add(viewTeacherButton);
		
		
		
		JButton marksTabelButton = new JButton("Generate Marksheet");
		marksTabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				markSheetPanel.removeAll();
				detailPanel.setVisible(false);
				teacherDetails.setVisible(false);
				markSheetPanel.setVisible(true);
				subjectSelectionPanel.setVisible(false);
				
				JComboBox markLevelBox = new JComboBox();
				markLevelBox.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
				markLevelBox.setBounds(10, 75, 100, 20);
				markSheetPanel.add(markLevelBox);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 150, 830, 330);
				markSheetPanel.add(scrollPane);
				String[] test = { "Subject Name", "Full Marks","Marks Optained","Grade" };
				DefaultTableModel md = new DefaultTableModel(test, 0);
				
				marksheetTable = new JTable(md);
				marksheetTable.getColumnModel().getColumn(0).setPreferredWidth(400);
				marksheetTable.setRowHeight(50);
				marksheetTable.setEnabled(false);
				scrollPane.setViewportView(marksheetTable);
				
				
				
				JLabel selectLevel = new JLabel("Select Level");
				selectLevel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				selectLevel.setBounds(10, 30, 150, 40);
				markSheetPanel.add(selectLevel);
				
				JLabel outputLabel = new JLabel("");
				outputLabel.setBounds(10, 500, 300, 30);
				markSheetPanel.add(outputLabel);
				
				JButton getResult = new JButton("Get Marksheet");
				getResult.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
						ArrayList<ArrayList<String>> subjectNameMarksArray = new ArrayList<ArrayList<String>>();
						int studentLevel = Integer.valueOf(String.valueOf(markLevelBox.getSelectedItem()));
						while(md.getRowCount()>0) {
							md.removeRow(0);
						}
						subjectNameMarksArray = new studentRunner().getStudentsMarks(studentData.getStudentEmail(), studentLevel);
						if(subjectNameMarksArray.isEmpty()) {
							throw new Exception("Array is Empty");
						}
						for(int i = 0;i<subjectNameMarksArray.size();i++) {
							Object[] row = subjectNameMarksArray.get(i).toArray();
							md.addRow(row);
						}
						outputLabel.setText("");
						}catch(Exception exception) {
							outputLabel.setText("Student data not found in selected Level");
						}
						
					}
				});
				getResult.setFont(new Font("Tahoma", Font.PLAIN, 10));
				getResult.setBounds(10, 105, 100, 20);
				markSheetPanel.add(getResult);
				
				
			}
		});
		marksTabelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		marksTabelButton.setBounds(10, 210, 190, 60);
		dashboard.add(marksTabelButton);
		

		if(studentData.getStudentLevel()==6) {
		JButton level6Button = new JButton("Choose subjects");
		level6Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				subjectSelectionPanel.removeAll();
				detailPanel.setVisible(false);
				teacherDetails.setVisible(false);
				markSheetPanel.setVisible(false);
				subjectSelectionPanel.setVisible(true);
				
				JLabel headLabel = new JLabel("Select a subject");
				headLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				headLabel.setBounds(70, 40, 200, 50);
				subjectSelectionPanel.add(headLabel);
				
				JComboBox subjectsBox = new JComboBox();
				int j=0;
				for (String i : studentData.getSubjects(6)) {
					subjectsBox.insertItemAt(i, j);
					j++;
				}
				subjectsBox.setBounds(70, 100, 300, 40);
				subjectSelectionPanel.add(subjectsBox);
				

				JLabel remainingLabel = new JLabel("Subjects to select remaining : "+studentData.getRemainingSelection(studentEmailFromLogin));
				remainingLabel.setHorizontalAlignment(SwingConstants.LEFT);
				remainingLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				remainingLabel.setBounds(70, 150, 300, 30);
				subjectSelectionPanel.add(remainingLabel);
				
				JLabel outputLabel = new JLabel("");
				outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
				outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
				outputLabel.setBounds(20, 500, 800, 40);
				subjectSelectionPanel.add(outputLabel);
				
				
				JButton confirmButton = new JButton("Confirm Subject");
				confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
				confirmButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(studentData.getRemainingSelection(studentEmailFromLogin)>0) {
							if(subjectsBox.getSelectedIndex()==-1) {
								outputLabel.setText("First Select a subject");
							}else {
							String subjectName = String.valueOf(subjectsBox.getSelectedItem());
							if(!studentData.checkSelected(studentEmailFromLogin, subjectName)) {
								if(studentData.setSelection(studentEmailFromLogin, subjectName)) {
									outputLabel.setText(subjectName+" added to you optional subject");
									remainingLabel.setText("Subjects to select remaining : "+studentData.getRemainingSelection(studentEmailFromLogin));
								}else {
									outputLabel.setText("Error selecting subject on database");
								}
							}else {
								outputLabel.setText("You have already selected that subject");
							}
							}
						}else {
							outputLabel.setText("You have 0 subject to select left");
						}
					}
				});
				confirmButton.setBounds(400, 100, 130, 40);
				subjectSelectionPanel.add(confirmButton);

			}
		});
		level6Button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		level6Button.setBounds(10, 280, 190, 60);
		dashboard.add(level6Button);
		}
		
	}
}
