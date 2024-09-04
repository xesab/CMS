package management_system;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class teacherPage extends JFrame {

	private JPanel contentPane;
	private String teacherEmailFromLogin;
	private JTextField marksField;
	private JTable marksheetTable;

	public teacherPage(String teacherEmailFromLogin) {
		this.teacherEmailFromLogin = teacherEmailFromLogin;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
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
		
		
		//Detail Panel
		JPanel detailPanel = new JPanel();
		detailPanel.setBackground(new Color(100, 149, 237));
		detailPanel.setVisible(false);
		detailPanel.setBounds(209, 0, 847, 613);
		contentPane.add(detailPanel);
		detailPanel.setLayout(null);
		detailPanel.setVisible(false);
		
		//Mark Add Panel
		JPanel setMarksPanel = new JPanel();
		setMarksPanel.setBackground(new Color(100, 149, 237));
		setMarksPanel.setBounds(209, 0, 847, 613);
		contentPane.add(setMarksPanel);
		setMarksPanel.setLayout(null);
		setMarksPanel.setVisible(false);
		
		//MarkSheetPanel
		JPanel markSheetPanel = new JPanel();
		markSheetPanel.setBackground(new Color(100, 149, 237));
		markSheetPanel.setBounds(209, 0, 847, 613);
		contentPane.add(markSheetPanel);
		markSheetPanel.setLayout(null);
		markSheetPanel.setVisible(false);
		
		JButton studentDataButton = new JButton("Get Student Data");
		studentDataButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				detailPanel.setVisible(true);
				setMarksPanel.setVisible(false);
				markSheetPanel.setVisible(false);
				teacherRunner Data = new teacherRunner();
				
				JComboBox<String> studentBox = new JComboBox<String>();
				int j=0;
				for (String i : Data.getStudentEmails()) {
					studentBox.insertItemAt(i, j);
					j++;
				}
				studentBox.setBounds(10, 50, 240, 39);
				detailPanel.add(studentBox);
				
				//Show Panel
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
				ID.setBounds(560, 50, 219, 50);
				detailPanel.add(ID);
				
				JLabel name = new JLabel("");
				name.setFont(new Font("Tahoma", Font.PLAIN, 15));
				name.setBounds(560, 150, 219, 50);
				detailPanel.add(name);
				
				JLabel email = new JLabel("");
				email.setFont(new Font("Tahoma", Font.PLAIN, 15));
				email.setBounds(560, 250, 219, 50);
				detailPanel.add(email);
				
				JLabel contact = new JLabel("");
				contact.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contact.setBounds(560, 350, 219, 50);
				detailPanel.add(contact);
				
				JLabel studentlevel = new JLabel("");
				studentlevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				studentlevel.setBounds(560, 450, 219, 50);
				detailPanel.add(studentlevel);
				
				JButton getData = new JButton("Get Data");
				getData.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						teacherRunner studentdata = new teacherRunner();
						studentdata.setStudentEmail(String.valueOf(studentBox.getSelectedItem()));
						ID.setText(studentdata.getStudentID());
						name.setText(studentdata.getStudentName());
						email.setText(studentdata.getStudentEmail());
						contact.setText(studentdata.getStudentContact());
						studentlevel.setText(String.valueOf(studentdata.getStudentLevel()));
					}
				});
				getData.setBounds(10, 120, 120, 30);
				detailPanel.add(getData);
				
				
			}
		});
		studentDataButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		studentDataButton.setBounds(10, 80, 190, 50);
		dashboard.add(studentDataButton);
		
		//Set Marks Panel Button
		JButton setMarksPanelButton = new JButton("Set Student Marks");
		setMarksPanelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				detailPanel.setVisible(false);
				setMarksPanel.setVisible(true);
				markSheetPanel.setVisible(false);
				setMarksPanel.removeAll();
				
				teacherRunner Data = new teacherRunner();
				Data.setTeacherEmail(teacherEmailFromLogin);
				
				JComboBox<String> studentBox = new JComboBox<String>();
				studentBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
				studentBox.setBounds(250, 50, 240, 39);
				setMarksPanel.add(studentBox);
				
				JLabel selectLevelLabel = new JLabel("Select Student Level");
				selectLevelLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				selectLevelLabel.setBounds(10, 10, 200, 40);
				setMarksPanel.add(selectLevelLabel);
				
				JComboBox levelBox = new JComboBox();
				levelBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
				levelBox.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
				levelBox.setBounds(10, 50, 50, 40);
				setMarksPanel.add(levelBox);
				
				JButton getEmailButton = new JButton("Get Emails");
				getEmailButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						studentBox.removeAllItems();
						int j=0;
						for (String i : Data.getStudentEmailsLevelWise(Integer.valueOf(String.valueOf(levelBox.getSelectedItem())))) {
							studentBox.insertItemAt(i, j);
							j++;
						}
						
					}
				});
				getEmailButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				getEmailButton.setBounds(10, 100, 100, 30);
				setMarksPanel.add(getEmailButton);
				
				marksField = new JTextField();
				marksField.setBounds(10, 260, 150, 30);
				setMarksPanel.add(marksField);
				marksField.setColumns(10);
				
				JLabel selectStudentLabel = new JLabel("Select Student");
				selectStudentLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				selectStudentLabel.setBounds(250, 10, 240, 40);
				setMarksPanel.add(selectStudentLabel);
				
				JButton getMarksButton = new JButton("Get Marks");
				getMarksButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						teacherRunner studentData = new teacherRunner();
						studentData.setStudentEmail(String.valueOf(studentBox.getSelectedItem()));
						int level = studentData.getStudentLevel();
						marksField.setText(new teacherRunner().getMarks(Data.getTeacherSubject(), String.valueOf(studentBox.getSelectedItem()),level));
					}
				});
				getMarksButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				getMarksButton.setBounds(250, 100, 125, 30);
				setMarksPanel.add(getMarksButton);
				
				JLabel subjectNameLabel = new JLabel("");
				subjectNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				subjectNameLabel.setBounds(10, 200, 800, 50);
				setMarksPanel.add(subjectNameLabel);
				subjectNameLabel.setText(Data.getTeacherSubject());
				
				JLabel outputLabel = new JLabel("");
				outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
				outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				outputLabel.setBounds(10, 445, 827, 50);
				setMarksPanel.add(outputLabel);
				
				JButton setMarksButton = new JButton("Set Marks");
				setMarksButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(marksField.getText().equals("")) {
							outputLabel.setText("!!! Enter marks properly from 1 to 100 !!!");
						}else {
							teacherRunner studentData = new teacherRunner();
							studentData.setStudentEmail(String.valueOf(studentBox.getSelectedItem()));
							int level = studentData.getStudentLevel();
							float marksFromField = Float.valueOf(marksField.getText());
							if(marksFromField>=0 && marksFromField<=100) {
								if(new teacherRunner().setMarks(Data.getTeacherSubject(), String.valueOf(studentBox.getSelectedItem()),level,marksFromField)) {
									outputLabel.setText("!!! Marks successfully added to database !!!");
								}else {
									outputLabel.setText("!!! Error adding marks to database !!!");
								}
							}else {
								outputLabel.setText("!!! Enter marks properly from 1 to 100 !!!");
							}
						}
						
						
					}
				});
				setMarksButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				setMarksButton.setBounds(10, 300, 100, 30);
				setMarksPanel.add(setMarksButton);
				
			}
		});
		setMarksPanelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		setMarksPanelButton.setBounds(10, 140, 190, 50);
		dashboard.add(setMarksPanelButton);
		
		JButton marksTabelButton = new JButton("Generate Marksheet");
		marksTabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				markSheetPanel.removeAll();
				detailPanel.setVisible(false);
				setMarksPanel.setVisible(false);
				markSheetPanel.setVisible(true);
				
				teacherRunner Data = new teacherRunner();
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
			}
		});
		
		marksTabelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		marksTabelButton.setBounds(10, 200, 190, 60);
		dashboard.add(marksTabelButton);
	}
}
