
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


class NumberLabel extends JLabel{
	public NumberLabel()
	{
		setVisible(true);
		setSize(200, 200);
		setFont(new Font("Dialog", Font.BOLD, 20));
		setBounds(230, -50, 100, 200);
		setText("99");
	}
	
}
class StartStopButton extends JButton implements ActionListener{
	boolean isRunning = true;
	Thread t1, t2, t3;
	public StartStopButton(Thread t1, Thread t2, Thread t3)
	{
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		setText("Stop");
		setBounds(200, 100, 100, 30);
		setVisible(true);
		
		addActionListener(this);
	}	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(isRunning == true)
		{
			t1.suspend();
			t2.suspend();
			t3.suspend();
			isRunning = false;
			setText("Start");
		}
		else
		{
			t1.resume();
			t2.resume();
			t3.resume();
			isRunning = true;
			setText("Stop");
		}
			

		
	}
}
class Menu extends JFrame{
	public NumberLabel number1 = new NumberLabel();
	public NumberLabel number2 = new NumberLabel();
	public NumberLabel number3 = new NumberLabel();
	public Menu()
	{
		init();
		
	}
	private synchronized void init()
	{
		setTitle("Random number generator");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		getContentPane().add(number1);
		RandomThread t1 = new RandomThread(number1);
	
		int X_alignLeft = 210;
		number1.setBounds(X_alignLeft, 50, 100, 50);
		t1.start();
		
		getContentPane().add(number2);
		RandomThread t2 = new RandomThread(number2);
		number2.setBounds(X_alignLeft + 30, 50, 100, 50);
		t2.start();
		
		getContentPane().add(number3);
		RandomThread t3 = new RandomThread(number3);
		number3.setBounds(X_alignLeft + 60, 50, 100, 50);
		t3.start();
		
		JButton btn = new StartStopButton(t1, t2, t3);
		add(btn);
			
	}
	
}

class RandomThread extends Thread
{
	boolean isRunning;
	NumberLabel number;
	public RandomThread(NumberLabel lbl)
	{
		super();
		number = lbl;
	}
	public void run()
	{
		while(!isInterrupted())
		{
			Random r = new Random();
			Integer i = r.nextInt(10);
			number.setText(i.toString());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
public class RandomGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		menu.setBounds(200, 200, 500, 200);
		

	}

}
