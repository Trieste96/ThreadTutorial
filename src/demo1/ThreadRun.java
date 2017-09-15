package demo1;


class Runner extends Thread{

	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println("Hello" + " " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
public class ThreadRun {

	public static void main(String[] args) {
		Runner r = new Runner();
		r.start();
		
		Runner r1 = new Runner();
		r1.start();

	}

}
