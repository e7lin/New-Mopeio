import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Animal {
	//attributes
		public int x,y;
		public int vy = 0;
		private String fileName;
		private int hp;
		
		//for image stuff
		private Image img; 	
		private AffineTransform tx;
		private double scaleW = 1.0, scaleH = 1.0;
		
		public Animal() {//default constructor
			
		}
		
		public Animal(int x,int y) {//non default constructor
			img = getImage("Mouse.png");   //need to do something with this
			
			this.x = x;
			this.y = y;
			
			tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); 				//initialize the location of the image
		}
		
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(scaleW, scaleH);
		}
		
		public int getHP() {
			return hp;
		}
		
		public void setHP(int hp) {
			this.hp = hp;
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
		//img = getImage("Mouse.png");
		y-=10;
	}
	public void down() {
		//img = getImage("MouseD.png");   
		y+=10;

	}
	public void left() {
		//img = getImage("MouseL.png");
		x-=10;
	}
	public void right() {
		//img = getImage("MouseR.png");
		x+=10;
	}
	
	
	
	public void update() {
			
		tx.setToTranslation(x, y);
		tx.scale(1	, 1);
		//i have no idea what this tx stuff does and it's causing errors in the inheritance code    
		
		
		/**
		 * Code here will prevent player from leaving screen
		 */
		
		if(y+130>1000) {
			y-=10;
		}
		if(y<10) {
			y+=10;	
		}
		if(x<10) {
			x+=10;
		}
		if(x+120>1900) {
			x-=10;
		}
		
		
		
		
		}
}
