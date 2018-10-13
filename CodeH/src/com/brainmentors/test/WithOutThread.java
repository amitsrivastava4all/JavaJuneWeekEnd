package com.brainmentors.test;

class Job implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 1; i<=5 ; i++){
			System.out.println("JOB I is "+i + " "+Thread.currentThread().getName());
		
		
	}
	
}
}
/*class Job
{
	void run(){
		for(int i = 1; i<=5 ; i++){
			System.out.println("JOB I is "+i+" Name "+Thread.currentThread());
			
		}
	}
}*/
public class WithOutThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job job  = new Job();
		Thread worker = new Thread(job,"Ram");
		worker.start();  // call run
		Job job2  = new Job();
		Thread worker2 = new Thread(job2,"Shyam");
		worker2.start();  // call run
		//job.run();
		//Thread.currentThread().setName("Hello");
		for(int i = 1; i<=5 ; i++){
			System.out.println("Main I is "+i+" name "+Thread.currentThread().getName());
			
		}
	}
}

