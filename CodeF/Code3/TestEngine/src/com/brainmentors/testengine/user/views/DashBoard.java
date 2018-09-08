package com.brainmentors.testengine.user.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	private void createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		JMenu file = new JMenu("File");
		JMenuItem logout = new JMenuItem("LogOut");
		file.add(logout);
		file.addSeparator();
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		menubar.add(file);
		
		
	}
	/**
	 * Create the frame.
	 */
	public DashBoard(String userid) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		createMenuBar();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel msglbl = new JLabel("Welcome "+userid);
		msglbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		msglbl.setHorizontalAlignment(SwingConstants.CENTER);
		msglbl.setBounds(39, 22, 393, 51);
		contentPane.add(msglbl);
	}
}
