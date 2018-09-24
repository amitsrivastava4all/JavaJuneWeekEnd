package com.brainmentors.testengine.user.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.brainmentors.testengine.user.dao.UserDAO;
import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.utils.CommonUtils;

public class LoginView extends JFrame {
	private Logger logger = Logger.getLogger(LoginView.class);
	private JPanel contentPane;
	private JTextField usertxt;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
						
					LoginView frame = new LoginView();
					frame.setVisible(true);
			
	}
	private void checkLogin() {
		String userid = usertxt.getText();
		String password = new String(passwordField.getPassword());
		UserDAO userDAO = new UserDAO();
		try {
			logger.debug("Check login called "+userid);
			UserDTO userDTO = userDAO.doLogin(userid, password);
			logger.debug("After Checking Login "+userDTO);
			//String message = userDAO.doLogin(userid, password);
		if(userDTO!=null) {
			DashBoard dashBoard = new DashBoard(userDTO);
			dashBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
			dashBoard.setVisible(true);
		}
		else {
		JOptionPane.showMessageDialog(this, "Invalid Userid or Password", "Test Engine", JOptionPane.INFORMATION_MESSAGE);
		}
		}
		catch(ClassNotFoundException | SQLException e) {
			logger.error(CommonUtils.getStringofStackTrace(e));
			
			JOptionPane.showMessageDialog(this, "Some DB Issue ", "Test Engine", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * Create the frame.
	 */
	public LoginView() {
		logger.debug("LoginView Design Starts.....");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblLogin.setBounds(198, 21, 77, 35);
		contentPane.add(lblLogin);
		
		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setBounds(27, 90, 61, 16);
		contentPane.add(lblUserid);
		
		usertxt = new JTextField();
		usertxt.setBounds(95, 85, 236, 26);
		contentPane.add(usertxt);
		usertxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(16, 150, 61, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 145, 217, 26);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		btnLogin.setBounds(26, 209, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(158, 209, 117, 29);
		contentPane.add(btnReset);
		logger.debug("Logn View Design Ends");
	}
}
