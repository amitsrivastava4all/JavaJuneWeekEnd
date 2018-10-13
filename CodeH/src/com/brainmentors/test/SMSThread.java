package com.brainmentors.test;

import java.util.ArrayList;

class SMSJob implements Runnable{
	int counter ;
	private ArrayList<String> namesList;
	SMSJob(ArrayList<String> namesList){
		this.namesList = namesList;
	}
	public synchronized void run(){
		
		for(String name:namesList){
			counter++;
			System.out.println(counter+"Happy Diwali "+name+" Thread "+Thread.currentThread().getName());
		}
	}
}

public class SMSThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<>();
		for(int i = 1; i<=10; i++){
			names.add("ram"+i);
		}
		ArrayList<String> names2 = new ArrayList<>();
		for(int i = 1; i<=10; i++){
			names2.add("shyam"+i);
		}
		SMSJob sms1 = new SMSJob(names);
		Thread worker = new Thread(sms1,"ram");
		//worker.start();
		//worker.join();
		//worker.setPriority(Thread.MAX_PRIORITY);
		//System.out.println(Thread.MAX_PRIORITY);
		//SMSJob sms2 = new SMSJob(names2);
		Thread worker2 = new Thread(sms1,"shyam");
		//SMSJob sms3 = new SMSJob(names2);
		Thread worker3 = new Thread(sms1,"mike");
		//worker.start();
		worker.start();
		worker2.start();
		worker3.start();
	}

}
