import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Tiger extends Animal{
	//attributes
	public int x,y;
	public int vy = 0;
	private String fileName;
	
	//for image stuff
	private Image img; 	
	private AffineTransform tx;
	private double scaleW = 1.0, scaleH = 1.0;
	
	public Tiger() {//default constructor
		
	}
	
	public Tiger(int x,int y) {//non default constructor
		img = getImage("Tiger.png");   
		
		this.x = x;
		this.y = y;
		
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleW, scaleH);
	}
	
	public int getX() {//getter (accessor)
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setX(int newX) {//setter (mutator)
		x = newX;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		//call update to update the actual picture location
		update();
		g2.drawImage(img, tx, null);
	}

public void up() {
	img = getImage("Tiger.png");
	y-=10;
}
public void down() {
	img = getImage("TigerD.png");   
	y+=10;

}
public void left() {
	img = getImage("TigerL.png");
	x-=10;
}
public void right() {
	img = getImage("TigerR.png");
	x+=10;
}
public void update() {
		
	tx.setToTranslation(x, y);
	tx.scale(1	, 1);

	/**
	 * Code here will prevent player from leaving screen
	 */
	
	//if(y+70>500) {
	//	y-=70;
	//}
	//if(y<50) {
	//	y+=70;
		
	//}
	
	
	}
}
