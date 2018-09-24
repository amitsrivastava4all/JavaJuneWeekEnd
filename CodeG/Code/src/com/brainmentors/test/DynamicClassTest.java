package com.brainmentors.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Frame to Load");
		Scanner scanner= new Scanner(System.in);
		String className  = scanner.next();
		try {
			String packageName = "com.brainmentors.testengine.user.views.";
			Object object = Class.forName(packageName+className).newInstance();
			Method method = object.getClass().getMethod("setVisible", boolean.class);
			
				method.invoke(object, true);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	/*	if(className.equals("TakeTest")) {
			TakeTest test = new TakeTest();
			test.setVisible(true);
		}
		else
		if(className.equals("UploadTest")) {	
			UploadTest obj = new UploadTest();
			obj.setVisible(true);
		}
		*/
	}

}
