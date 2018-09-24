package com.brainmentors.testengine.user.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import com.brainmentors.testengine.utils.CommonConstants;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private void loadScreen(String fullClassName) {
		try {
			Object object = Class.forName(fullClassName).newInstance();
			Method method;
			
				method = object.getClass().getMethod("setVisible", boolean.class);
			 
		
				method.invoke(object, true);
			 
		} 
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void createMenuBar(ArrayList<RightDTO> rights, String roleName) {
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		JMenu file = new JMenu(roleName);
		for(RightDTO right : rights) {
			JMenuItem menuItem = new JMenuItem(right.getRightName());
			menuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String screenName = right.getScreenName();
					String fullClassName = CommonConstants.BASE_PATH+screenName;
					loadScreen(fullClassName);
					
				}
			});
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
