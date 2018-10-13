package com.brainmentors.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadDemo {

	public static void main(String[] args) throws IOException {
		String path = "/Users/amit/Documents/CoreJavaJulyWEnd/TestEngine/src/com/brainmentors/test/ReadDemo.java";
		File file = new File(path);
		final int EOF = -1;
		if(file.exists()) {
			FileInputStream fs = new FileInputStream(file);
			int singleByte = fs.read();
			while(singleByte!=EOF) {
				System.out.print((char)singleByte);
				singleByte = fs.read();
			}
			fs.close();
			
		}
		// TODO Auto-generated method stub
		System.out.println("Enter the Data to Write in a File");
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.nextLine();
		FileOutputStream fo =new FileOutputStream("/Users/amit/Documents/songs/data.txt");
		fo.write(txt.getBytes());
		fo.close();
		System.out.println("Data Write in  a file...");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
