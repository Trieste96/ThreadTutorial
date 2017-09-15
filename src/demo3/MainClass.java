package demo3;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Work w = new Work();
		w.doIt();
	}
	
	

}
class Work
{
	private int count = 0;
	
	private synchronized void increase()
	{
		count++;
	}
	public void doIt()
	{
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10000; i++)
				{
					increase();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10000; i++)
				{
					increase();
				}
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count is " + count);
	}
}