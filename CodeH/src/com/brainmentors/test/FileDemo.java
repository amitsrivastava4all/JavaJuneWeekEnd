package com.brainmentors.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

// SAM - SIngle Abstract Method


class MyFilter implements FilenameFilter{

	@Override
	public boolean accept(File dirPath, String fileName) {
		// TODO Auto-generated method stub
		return fileName.endsWith(".mp3");
	}
	
}

public class FileDemo {

	public static void main(String[] args) throws IOException {
		// c:\\abcd\\xyz
		String path = "/Users/amit/Documents/FileOutput/sample.txt";
		File file = new File(path);
		if(file.exists()) {
			File file2 = new File("/Users/amit/Documents/FileOutput/sample2.txt");
			file.renameTo(file2);
			//file.delete();
			System.out.println("File Deleted");
		}
		else {
			file.createNewFile();
			System.out.println("File Created...");
		}
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName()); 
		
		path ="/Users/amit/Documents/FileOutput/abcd/xyz/ee/rr/tt";
		file = new File(path);
		file.mkdirs();
		
		file = new File("/Users/amit/Documents/songs");
		MyFilter filter = new MyFilter();
		//File files [] = file.listFiles(filter);
		File files[] = file.listFiles((dirPath, fileName)-> fileName.endsWith(".mp3"));
		File files2[] = file.listFiles((dirPath, fileName)-> fileName.endsWith(".png"));
		System.out.println("No of Files "+files.length);
		Calc d = (a,b)->{
			System.out.println("A is "+a+" B is "+b);
			return a + b;
		};
		Calc c = (a,b)->a+b;
		System.out.println(c.add(100, 200));
//		for(File f : files) {
//			f.delete();
//		}
		//file.mkdir();
	}

}
@FunctionalInterface
interface Calc{
	
	public int add(int x, int y);
}
