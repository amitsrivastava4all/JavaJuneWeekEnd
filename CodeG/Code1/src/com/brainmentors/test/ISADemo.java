package com.brainmentors.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class C implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int m;
	C(){
		m = 999;
		System.out.println("C Cons Call");
	}
}
class A implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	C obj  = new C();
	String name = new String( "Amit");
	transient int f;
	A(){
		x = 100;
		y = 200;
		f = 10000;
		System.out.println("A Cons Call");
	}
	void plus() {
		x++;
		y++;
		f++;
	}
}
class B extends A {//implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int z;
	int mm;
	int gg ;
	B(){
		gg = 2000;
		
		z = 1000;
		mm = gg + z;
		System.out.println("B Cons Call");
	}
	void add() {
		z++;
	}
}
public class ISADemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		B obj = new B();
		obj.plus();
		obj.add();
		String path ="/Users/amit/Documents/FileOutput/test.dat";
//		FileOutputStream fs = new FileOutputStream(path);
//		ObjectOutputStream os = new ObjectOutputStream(fs);
//		os.writeObject(obj);
//		os.close();
//		fs.close();
//		System.out.println("Data Store...");
		FileInputStream fi = new FileInputStream(path);
		ObjectInputStream oi = new ObjectInputStream(fi);
		B e = (B)oi.readObject();
		System.out.println(e.x+" "+e.y+ " "+e.z+" "+e.f + " "+e.name +" "+ e.obj.m + " "+e.gg+ " "+e.mm);
		oi.close();
		fi.close();

	}

}
