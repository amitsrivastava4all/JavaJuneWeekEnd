package com.brainmentors.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileCopyDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String sourcePath = "/Users/amit/Documents/songs/A.mp3";
		String desPath = "/Users/amit/Documents/songs/ACopy.mp3";
		File file = new File(sourcePath);
		if(!file.exists()) {
			System.out.println("Cant Copy File not exist ");
			return ;
		}
		final int EOF = -1;
		//RandomAccessFile
		FileInputStream fs= new FileInputStream(file);
		
		BufferedInputStream bs =new BufferedInputStream(fs);
		FileOutputStream fo = new FileOutputStream(desPath,true);
		BufferedOutputStream bo = new BufferedOutputStream(fo);
		long startTime = System.currentTimeMillis();
		System.out.println("Copy Start...");
		int singleByte =bs.read();
		while(singleByte!=EOF) {
		bo.write(singleByte);
		singleByte =bs.read();
		}
		bo.close();
		bs.close();
		fo.close();
		fs.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Data Copied..."+(endTime-startTime)+"ms");
	}

}
