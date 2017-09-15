package demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLock {

	Random rd = new Random();
	List<Integer>list1 = new ArrayList<Integer>();
	List<Integer>list2 = new ArrayList<Integer>();
	
	private void process1()
	{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list1.add(rd.nextInt(100));
		
	}
	
	private void process2()
	{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list2.add(rd.nextInt(100));
		
	}
	
	private void process()
	{
		for(int i=0; i<10000; i++)
		{
			process1();
			process2();
		}
	}
	public void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable() {
			public void run()
			{
				process();
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run()
			{
				process();
			}
		});
		t2.start();
	}

}
