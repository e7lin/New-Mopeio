import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;


public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	//declaring variables
	Random rnd = new Random();
	Background bg1 = new Background(0,0);
	Animal testAnimal = new Mouse(100,200);
	Lava lavaPool = new Lava(600,200);
	
	BerryBush berryBush1 = new BerryBush((int)((Math.random()*400)), (int)((Math.random()*430)+70));
	BerryBush berryBush2 = new BerryBush((int)((Math.random()*480)+440), (int)((Math.random()*300)+510));
	BerryBush berryBush3 = new BerryBush((int)((Math.random()*300)+1450), (int)((Math.random()*800)+70));
	
	
	
	//creating objects and object arrays  (STEP 1)
	private int level = 0;
	private boolean evo = false;
	public int berryInt = 0;
	public int carrotInt = 0;
	public int exp = 0;
	Berry[] berries = new Berry[8];
	Berry[] berries2 = new Berry[8];
	Berry[] berries3 = new Berry[8];
	Carrot[] carrots = new Carrot[40];
	Carrot[] carrots2 = new Carrot[40];
	Meat[] meat = new Meat[20];
	
	public void paint(Graphics g) { //The code under this method paints the objects
		super.paintComponent(g);
		bg1.paint(g);
		lavaPool.paint(g);
		berryBush1.paint(g);
		berryBush2.paint(g);
		berryBush3.paint(g);

	    for(int i = 0; i < berryInt/120; i++) {
	    	//berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
	    	//berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
	    	berries[i].paint(g);
	    	berries2[i].paint(g);
	    	berries3[i].paint(g);
	    	
	    	
	    	if(testAnimal.getX() +60 >= berries[i].getX() && testAnimal.getX() <= berries[i].getX() && testAnimal.getY() <= berries[i].getY() && testAnimal.getY()+100 >= berries[i].getY() ) {
	    		berries[i].setX(10000);
	    		berries[i].setY(10000);
	    		exp+=5;
	    	}
	    	if(testAnimal.getX() + 60 >= berries2[i].getX() && testAnimal.getX() <= berries2[i].getX() && testAnimal.getY() <= berries2[i].getY() && testAnimal.getY()+100 >= berries2[i].getY() ) {
	    		berries2[i].setX(10000);
	    		berries2[i].setY(10000);
	    		exp+=5;

	    	}
	    	if(testAnimal.getX() + 60 >= berries3[i].getX() && testAnimal.getX() <= berries3[i].getX() && testAnimal.getY() <= berries3[i].getY() && testAnimal.getY()+100 >= berries3[i].getY() ) {
	    		berries3[i].setX(10000);
	    		berries3[i].setY(10000);
	    		exp+=5;
	    	}
	    	
	    }
	   
	    for(int i = 0; i < carrotInt/300; i++) {
	    	carrots[i].paint(g);
	    	carrots2[i].paint(g);
	    	if(i%2 == 0) {
	    		meat[i].paint(g);
	    	}
	    	
	    	if(testAnimal.getX() +80 >= carrots[i].getX() && testAnimal.getX() <= carrots[i].getX() && testAnimal.getY()-20 <= carrots[i].getY() && testAnimal.getY()+75 >= carrots[i].getY() ) {
	    		carrots[i].setX(10000);
	    		carrots[i].setY(10000);
	    		exp+= 10;
	    	}
	    	if(testAnimal.getX() +80 >= carrots2[i].getX() && testAnimal.getX() <= carrots2[i].getX() && testAnimal.getY()-20 <= carrots2[i].getY() && testAnimal.getY()+75 >= carrots2[i].getY() ) {
	    		carrots2[i].setX(10000);
	    		carrots2[i].setY(10000);
	    		exp+= 10;
	    	}
	    	if(testAnimal.getX() +80 >= meat[i].getX() && testAnimal.getX() <= meat[i].getX() && testAnimal.getY()-20 <= meat[i].getY() && testAnimal.getY()+75 >= meat[i].getY() ) {
	    		meat[i].setX(10000);
	    		meat[i].setY(10000);
	    		exp+= 100;
	    	}
	    }
	    
	    
	   // if(berryInt % 300 == 0) {
	   /// 	berries[berryInt%300].paint(g);
	   // }
	    

	    
	    testAnimal.paint(g);
		

		//time interval for spawn of berries
	    if(berryInt<840) {
	    	berryInt++;
	    }
		if(carrotInt<12000) {
			carrotInt++;
		}
		
		//trying to make a simple evolution thing
		if(level == 0 && evo) {
			testAnimal.setHP(10);
			Animal temp = new Mouse(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
		}else if(level == 1 && evo) {
			Animal temp = new Frog(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(20);
			berryInt = 0;
			for(int i = 0; i<7; i++) {
				berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
				berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
				berries2[i].setX((int)(Math.random()*150) + berryBush2.getX());
				berries2[i].setY((int)(Math.random()*150) + berryBush2.getY());
				berries3[i].setX((int)(Math.random()*150) + berryBush3.getX());
				berries3[i].setY((int)(Math.random()*150) + berryBush3.getY());
			}
			System.out.println(testAnimal.getHP());
		}else if(level == 2 && evo) {
			Animal temp = new Pig(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(30);
			berryInt = 0;

			for(int i = 0; i<7; i++) {
				berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
				berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
				berries2[i].setX((int)(Math.random()*150) + berryBush2.getX());
				berries2[i].setY((int)(Math.random()*150) + berryBush2.getY());
				berries3[i].setX((int)(Math.random()*150) + berryBush3.getX());
				berries3[i].setY((int)(Math.random()*150) + berryBush3.getY());
			}
		}else if(level == 3 && evo) {
			Animal temp = new Otter(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(40);
			berryInt = 0;

			for(int i = 0; i<7; i++) {
				berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
				berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
				berries2[i].setX((int)(Math.random()*150) + berryBush2.getX());
				berries2[i].setY((int)(Math.random()*150) + berryBush2.getY());
				berries3[i].setX((int)(Math.random()*150) + berryBush3.getX());
				berries3[i].setY((int)(Math.random()*150) + berryBush3.getY());
			}
		}else if(level == 4 && evo) {
			Animal temp = new Vulture(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(50);
			berryInt = 0;

			for(int i = 0; i<7; i++) {
				berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
				berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
				berries2[i].setX((int)(Math.random()*150) + berryBush2.getX());
				berries2[i].setY((int)(Math.random()*150) + berryBush2.getY());
				berries3[i].setX((int)(Math.random()*150) + berryBush3.getX());
				berries3[i].setY((int)(Math.random()*150) + berryBush3.getY());
			}
		}else if(level == 5 && evo) {
			Animal temp = new Buffalo(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(60);
			berryInt = 0;

			for(int i = 0; i<7; i++) {
				berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
				berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
				berries2[i].setX((int)(Math.random()*150) + berryBush2.getX());
				berries2[i].setY((int)(Math.random()*150) + berryBush2.getY());
				berries3[i].setX((int)(Math.random()*150) + berryBush3.getX());
				berries3[i].setY((int)(Math.random()*150) + berryBush3.getY());
			}
		}else if(level == 6 && evo) {
			Animal temp = new Hippo(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(70);
			berryInt = 0;
			
			for(int i = 0; i<7; i++) {
				berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
				berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
				berries2[i].setX((int)(Math.random()*150) + berryBush2.getX());
				berries2[i].setY((int)(Math.random()*150) + berryBush2.getY());
				berries3[i].setX((int)(Math.random()*150) + berryBush3.getX());
				berries3[i].setY((int)(Math.random()*150) + berryBush3.getY());
			}
		}else if(level == 7 && evo) {
			Animal temp = new Tiger(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(80);
			berryInt = 0;

			for(int i = 0; i<7; i++) {
				berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
				berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
				berries2[i].setX((int)(Math.random()*150) + berryBush2.getX());
				berries2[i].setY((int)(Math.random()*150) + berryBush2.getY());
				berries3[i].setX((int)(Math.random()*150) + berryBush3.getX());
				berries3[i].setY((int)(Math.random()*150) + berryBush3.getY());
			}
		}else if(level == 8 && evo) {
			Animal temp = new Lion(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(90);
			berryInt = 0;

			for(int i = 0; i<7; i++) {
				berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
				berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
				berries2[i].setX((int)(Math.random()*150) + berryBush2.getX());
				berries2[i].setY((int)(Math.random()*150) + berryBush2.getY());
				berries3[i].setX((int)(Math.random()*150) + berryBush3.getX());
				berries3[i].setY((int)(Math.random()*150) + berryBush3.getY());
			}
		}else if(level == 9 && evo) {
			Animal temp = new Dragon(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(100);
			berryInt = 0;

			for(int i = 0; i<7; i++) {
				berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
				berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
				berries2[i].setX((int)(Math.random()*150) + berryBush2.getX());
				berries2[i].setY((int)(Math.random()*150) + berryBush2.getY());
				berries3[i].setX((int)(Math.random()*150) + berryBush3.getX());
				berries3[i].setY((int)(Math.random()*150) + berryBush3.getY());
			}
		}
		//end of evolution code
		if(exp >50  && level == 0) {
			level++;
			evo = true;
		}else if(exp > 150  && level == 1) {
			level++;
			evo = true;
		}else if(exp > 275 && level == 2) {
			level++;
			evo = true;
		}else if(exp > 400  && level == 3) {
			level++;
			evo = true;
		}else if(exp > 550 && level == 4) {
			level++;
			evo = true;
		}else if(exp > 675 && level == 5) {
			level++;
			evo = true;
		}else if(exp > 800  && level == 6) {
			level++;
			evo = true;
		}else if(exp > 1000 && level == 7) {
			level++;
			evo = true;
		}else if(exp > 1000 && level == 8) {
			level++;
			evo = true;
		}
		
		/*
		 * Mouse: 0 to 50

	Frog: 50 - 150

Pig: 150 - 275

Otter: 275 - 400

Vulture: 400 to 550

Buffalo: 550 - 675

Tiger: 675 - 800

Lion: 800- 1000

Dragon: 1000 + 

		 */
		//supposed to make animal die???
		if(testAnimal.getHP() <= 0) {
			g.setFont(g.getFont().deriveFont(150f));
			
			g.fillRect(650, 500, 750, 200);
			Color c = new Color(237, 0, 0);
			g.setColor(c);
			g.drawString("You Died!", 700,650);
			testAnimal.setVx(0);
			testAnimal.setVy(0);
			//level = 0;
			//evo = true;
		}
		
		if(testAnimal.getX() >=1020 && testAnimal.getX()<=1440 && level != 6 && level != 3 && level != 1) {
			testAnimal.setVx(3);
			testAnimal.setVy(3);

			//testAnimal.setVy(1);
		}else if(testAnimal.getHP( )> 0) {
			testAnimal.setVx(10);
			testAnimal.setVy(10);
		}
		
	}//end of paint
	
/*	public void resetBerry(int[] arr, int[] arr2, int[] arr3, BerryBush b1, BerryBush b2, BerryBush b3) {
		for(int i = 0; i<7; i++) {
			arr[i].setX((int)(Math.random()*150) + b1.getX());
			arr[i].setY((int)(Math.random()*150) + b1.getY());
			arr2[i].setX((int)(Math.random()*150) + b2.getX());
			arr2[i].setY((int)(Math.random()*150) + b2.getY());
			arr3[i].setX((int)(Math.random()*150) + b3.getX());
			arr3[i].setY((int)(Math.random()*150) + b3.getY());
		}
	}*/
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	
	
	public Frame() {
		// 70 to 500 for first berry bush x; y will be from 70 down to 500
		
		for(int i = 0; i < berries.length; i++) {
			int xValue = (int)(Math.random()*150) + berryBush1.getX();
			int yValue = (int)(Math.random()*150) + berryBush1.getY();
		    berries[i] = new Berry(xValue,yValue);
		}
		
		for(int i = 0; i < berries.length; i++) {
			int xValue = (int)(Math.random()*150) + berryBush2.getX();
			int yValue = (int)(Math.random()*150) + berryBush2.getY();
		    berries2[i] = new Berry(xValue, yValue);
		}
		
		for(int i = 0; i < berries.length; i++) {
			int xValue = (int)(Math.random()*150) + berryBush3.getX();
			int yValue = (int)(Math.random()*150) + berryBush3.getY();
		    berries3[i] = new Berry(xValue, yValue);
		}
		
		for(int i = 0; i < carrots.length; i++) {
			int xValue = (int)(Math.random()*50) + 1050;
			int yValue = (int)(Math.random()*900)+50;
		    carrots[i] = new Carrot(xValue, yValue);
		}
		
		for(int i = 0; i < carrots.length; i++) {
			int xValue = (int)(Math.random()*50) + 1400;
			int yValue = (int)(Math.random()*900)+50;
		    carrots2[i] = new Carrot(xValue, yValue);
		}
		
		for(int i = 0; i < meat.length; i++) {
			int xValue = (int)(Math.random()*1800) + 50;
			int yValue = (int)(Math.random()*900)+50;
		    meat[i] = new Meat(xValue, yValue);
		}
		
		JFrame f = new JFrame("Mopeio");
		f.setSize(new Dimension(1900, 1000));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			System.out.println(arg0.getKeyCode());
			//arrow keys are used for moving pony up and down
			if(arg0.getKeyCode() == 38) {
				testAnimal.up();
				
			}
			if(arg0.getKeyCode() == 40) {
				testAnimal.down();
				
			}
			if(arg0.getKeyCode() == 39) {
				testAnimal.right();
				
			}
			if(arg0.getKeyCode() == 37) {
				testAnimal.left();
				
			}
			if(arg0.getKeyCode() == 89) { //press y
				System.out.println(testAnimal.getY());
			}
			if(arg0.getKeyCode() == 88) { //press y
				System.out.println(testAnimal.getX());
			}

			if(arg0.getKeyCode() == 83) { //press s to evolve, for testing
				exp+=100;
			}
			if(arg0.getKeyCode() == 68) { //press D to decrease 1 evolution, for testing
				level--;
				evo = true;
			}
			if(arg0.getKeyCode() == 67) { //press c to decrement hp 10
				testAnimal.setHP(testAnimal.getHP()-10);
				System.out.println("ouch");
				
				System.out.println(testAnimal.getHP());
				
			}
			
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
