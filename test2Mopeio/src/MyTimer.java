import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyTimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int times = 0;
	public static int increment = 0; 
	
	public void FixedIntervalRate() {
		times+=1;
	while(increment <= 7) {
		if(times%300 == 0) {
			increment = increment+1;
		}	
	}
	}
	public void update() {
		FixedIntervalRate();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		update();
	}
}
