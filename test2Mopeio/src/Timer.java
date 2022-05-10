
public class Timer {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int times;
	public static int increment = 0;
	
	public void FixedIntervalRate() {
		times+=1;
	while(increment <= 7) {
		if(times%5 == 0) {
			increment = increment+1;
		}	
	}
	}
}
