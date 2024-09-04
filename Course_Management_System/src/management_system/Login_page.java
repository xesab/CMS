package management_system;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login_page extends JFrame {

	private JPanel contentPane;
	private JPasswordField password_field;
	
	public Login_page() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label_user = new JLabel("User");
		Label_user.setForeground(new Color(220, 20, 60));
		Label_user.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Label_user.setBounds(45, 120, 278, 30);
		contentPane.add(Label_user);
		
		JLabel Lable_pass = new JLabel("Password");
		Lable_pass.setForeground(new Color(220, 20, 60));
		Lable_pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Lable_pass.setBounds(45, 200, 280, 30);
		contentPane.add(Lable_pass);
		
		JFormattedTextField username_field = new JFormattedTextField();
		username_field.setBorder(null);
		username_field.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username_field.setBounds(45, 155, 280, 30);
		contentPane.add(username_field); 
		
		password_field = new JPasswordField();
		password_field.setBorder(null);
		password_field.setBounds(45, 230, 280, 30);
		contentPane.add(password_field);
		
		JComboBox userTypeBox = new JComboBox();
		userTypeBox.setModel(new DefaultComboBoxModel(new String[] {"student", "teacher", "admin"}));
		userTypeBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userTypeBox.setBounds(45, 310, 100, 25);
		contentPane.add(userTypeBox);
		
		JLabel Lable_userType = new JLabel("User Type");
		Lable_userType.setForeground(new Color(255, 0, 0));
		Lable_userType.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Lable_userType.setBounds(45, 280, 145, 30);
		contentPane.add(Lable_userType);
		
		JLabel outputLabel = new JLabel("");
		outputLabel.setForeground(new Color(240, 255, 255));
		outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outputLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		outputLabel.setBounds(0, 426, 379, 32);
		contentPane.add(outputLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginRunner log = new loginRunner(username_field.getText(),String.valueOf(password_field.getPassword()),String.valueOf(userTypeBox.getSelectedItem()));
				if(log.usernameCheck()) {
					if(log.passwordCheck()) {
						outputLabel.setText("Logging in as "+username_field.getText());
						
						if (String.valueOf(userTypeBox.getSelectedItem())=="student"){
							setVisible(false);
							new studentPage(username_field.getText()).setVisible(true);
							
						}
						else if(String.valueOf(userTypeBox.getSelectedItem())=="teacher") {
							setVisible(false);
							new teacherPage(username_field.getText()).setVisible(true);
							
						}
						else if(String.valueOf(userTypeBox.getSelectedItem())=="admin") {
							setVisible(false);
							new adminPage().setVisible(true);
							
						}
					}
					else {
						outputLabel.setText("Password is Incorrect");
					}
					
				}
				else {
					outputLabel.setText("Username is Incorrect");
				}
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginButton.setBorder(null);
		loginButton.setBackground(Color.WHITE);
		loginButton.setBounds(145, 365, 100, 35);
		contentPane.add(loginButton);
		
		JLabel collegeManagementLabel = new JLabel("College Management");
		collegeManagementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		collegeManagementLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		collegeManagementLabel.setForeground(Color.RED);
		collegeManagementLabel.setBounds(0, 10, 380, 35);
		contentPane.add(collegeManagementLabel);
		
		JLabel systemLabel = new JLabel("System");
		systemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		systemLabel.setForeground(Color.RED);
		systemLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		systemLabel.setBounds(0, 50, 380, 35);
		contentPane.add(systemLabel);
	}
}