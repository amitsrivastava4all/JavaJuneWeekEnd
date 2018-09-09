package com.brainmentors.testengine.user.views;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.user.dto.RightDTO;
import com.brainmentors.testengine.user.dto.UserDTO;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	private void createMenuBar(ArrayList<RightDTO> rights, String roleName) {
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		JMenu file = new JMenu(roleName);
		for(RightDTO right : rights) {
			JMenuItem menuItem = new JMenuItem(right.getRightName());
			file.add(menuItem);
		}
		/*JMenuItem logout = new JMenuItem("LogOut");
		file.add(logout);
		file.addSeparator();
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);*/
		menubar.add(file);
		
		
	}
	/**
	 * Create the frame.
	 */
	public DashBoard(UserDTO userDTO) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		createMenuBar(userDTO.getRights(), userDTO.getRoleName());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel msglbl = new JLabel("Welcome "+userDTO.getUserid()+" Role "+userDTO.getRoleName());
		msglbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		msglbl.setHorizontalAlignment(SwingConstants.CENTER);
		msglbl.setBounds(39, 22, 393, 51);
		contentPane.add(msglbl);
	}
}
