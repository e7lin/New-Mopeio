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
	static Animal testAnimal = new Mouse(100,200);
	public static int returnAnimalHP(Animal test) {
   	    return test.getHP();
     }
	Lava lavaPool = new Lava(600,200);
	
	BerryBush berryBush1 = new BerryBush((int)((Math.random()*400)), (int)((Math.random()*430)+70));
	BerryBush berryBush2 = new BerryBush((int)((Math.random()*480)+440), (int)((Math.random()*300)+510));
	BerryBush berryBush3 = new BerryBush((int)((Math.random()*300)+1450), (int)((Math.random()*800)+70));
	
	
	
	//creating objects and object arrays  (STEP 1)
	private boolean lava = false;
	private boolean mouseA = false;
	private boolean abilityActivate = false;
	private int abilityTimer = 0;
	int tempX;
	int tempY;
	
	private int level = 0;
	private boolean evo = false;
	public int berryInt = 0;
	public int carrotInt = 0;
	public int exp = 0;
	Berry[] berries = new Berry[100];
	Berry[] berries2 = new Berry[100];
	Berry[] berries3 = new Berry[100];
	Carrot[] carrots = new Carrot[40];
	Carrot[] carrots2 = new Carrot[40];
	Meat[] meat = new Meat[40];
	Mushroom[] shrooms = new Mushroom[40]; //maybe poison status effect?

	
	private int counter = 0;
	private int tick = 0;
	
	public void paint(Graphics g) { //The code under this method paints the objects
		super.paintComponent(g);
		bg1.paint(g);
		lavaPool.paint(g);
		berryBush1.paint(g);
		berryBush2.paint(g);
		berryBush3.paint(g);
		
		g.drawLine(900, 200, 900, 500);
		g.drawLine(600, 200, 600, 500);
		g.drawLine(600, 200, 900, 200);
		g.drawLine(600, 500, 900, 500);
		
		
		
		Color c2 = new Color(255, 136, 136);
		g.setColor(c2);
		g.fillRect(10, 30, 10*testAnimal.getHP(), 10);
		Color c4 = new Color(0,0,0);
		g.setColor(c4);
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("Healthbar :", 10, 25);
		if(abilityTimer<10) {
		g.drawString("Time until ability: " + (10-abilityTimer), 10, 65);
		}else {
			g.drawString("Ability ready" , 10, 65);
		}

		
	    for(int i = 0; i < berryInt/120; i++) {
	    	//berries[i].setX((int)(Math.random()*150) + berryBush1.getX());
	    	//berries[i].setY((int)(Math.random()*150) + berryBush1.getY());
	    	berries[i].paint(g);
	    	berries2[i].paint(g);
	    	berries3[i].paint(g);
	    		
	    	/*berryint = 0;
	    	 * if(testAnimal.getX() +80 >= meat[i].getX() && testAnimal.getX() <= meat[i].getX() && testAnimal.getY()-20 <= meat[i].getY() && testAnimal.getY()+75 >= meat[i].getY() ) {
	    		meat[i].setX(10000);
	    		meat[i].setY(10000);
	    		exp+= 25;
	    	}
	    	 */
	    	
	    	
	    
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
	    		shrooms[i].paint(g); //should make some kind of poison effect for shroom
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
	    		exp+= 25;
	    	}
	    	if(testAnimal.getX() +80 >= shrooms[i].getX() && testAnimal.getX() <= shrooms[i].getX() && testAnimal.getY()-20 <= shrooms[i].getY() && testAnimal.getY()+75 >= shrooms[i].getY() ) {
	    		shrooms[i].setX(10000);
	    		shrooms[i].setY(10000);
	    		//exp+= 25;???
	    	}
	    }
	    
	    g.drawRect(testAnimal.getX(), testAnimal.getY(), 100, 100);
	    
	    //tick
	    
	   
	    if(testAnimal.getX() +100> 600 && testAnimal.getX() + 50 < 900 && testAnimal.getY()+100 >200 && testAnimal.getY() +50 < 500 && level != 9 ) {
			lava = true;
			testAnimal.setVx(2);
			testAnimal.setVy(2);
		}else {
			lava = false;
		}
	    
	    
	    if(counter < 2000000000) {
	    	counter ++;
	    	if(mouseA) {
	    		g.drawString("squeek", testAnimal.getX()+100, testAnimal.getY());
				g.drawString("squeek", testAnimal.getX()-10, testAnimal.getY()+25);
				g.drawString("squeek", testAnimal.getX()+75, testAnimal.getY()+50);
				if(abilityTimer > 3) {
					mouseA = false;
				}
	    		
	    	}
	    	if(counter%30 == 0) { //tick .5 second
	    		//tick++;
	    		if(lava) {
	    			testAnimal.setHP(testAnimal.getHP()-10);
	    		}
	    	}
	    	
	    	if(counter%60 == 0) { //tick 1 second
		    	abilityTimer++;
		    	
	    	}
	    }
	    
	    
	    
	   // if(berryInt % 300 == 0) {
	   /// 	berries[berryInt%300].paint(g);
	   // }
	    
	   
	    testAnimal.paint(g);
		
	    
		//time interval for spawn of berries
	    if(berryInt<12000) {
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
			for(int i = 0; i<7; i++) {
				
			}
			System.out.println(testAnimal.getHP());
		}else if(level == 2 && evo) {
			Animal temp = new Pig(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(30);

			for(int i = 0; i<7; i++) {
				
			}
		}else if(level == 3 && evo) {
			Animal temp = new Otter(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(40);

			for(int i = 0; i<7; i++) {
				
			}
		}else if(level == 4 && evo) {
			Animal temp = new Vulture(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(50);

			for(int i = 0; i<7; i++) {
				
			}
		}else if(level == 5 && evo) {
			Animal temp = new Buffalo(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(60);

			for(int i = 0; i<7; i++) {
				
			}
		}else if(level == 6 && evo) {
			Animal temp = new Hippo(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(70);
			
			for(int i = 0; i<7; i++) {
				
			}
		}else if(level == 7 && evo) {
			Animal temp = new Tiger(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(80);

			for(int i = 0; i<7; i++) {
				
			}
		}else if(level == 8 && evo) {
			Animal temp = new Lion(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(90);

			for(int i = 0; i<7; i++) {
				
			}
		}else if(level == 9 && evo) {
			Animal temp = new Dragon(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(100);

			for(int i = 0; i<7; i++) {
				
			}
		}
		//end of evolution code
		if(exp >50  && level == 0) {
			level++;
			evo = true;
		}else if(exp >= 125  && level == 1) {
			level++;
			evo = true;
		}else if(exp >= 225 && level == 2) {
			level++;
			evo = true;
		}else if(exp >= 350  && level == 3) {
			level++;
			evo = true;
		}else if(exp >= 474 && level == 4) {
			level++;
			evo = true;
		}else if(exp > 599 && level == 5) {
			level++;
			evo = true;
		}else if(exp > 749  && level == 6) {
			level++;
			evo = true;
		}else if(exp > 899 && level == 7) {
			level++;
			evo = true;
		}else if(exp > 1099 && level == 8) {
			level++;
			evo = true;
		}
		
		
		if(abilityTimer>=10 && abilityActivate) {
			switch(level) {
			case 0:
				mouseA = true;
				abilityTimer = 0;
				abilityActivate = !abilityActivate;
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			}
		}
		
		//abilities?
		
		
		
		
		
		
		
		/*
 		Mouse: 0 to 50 0

		Frog: 50 - 125 1

		Pig: 125 - 225 2 

		Otter: 225 - 350 3

		Vulture: 350 to 475 4 

		Buffalo: 475- 600 5 

		Hippo: 600 - 750

		Tiger: 750 - 900 6 

		Lion: 900 - 1100 7

		Dragon: 1100 + 
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
		
		if(testAnimal.getX() >=1020 && testAnimal.getX()<=1440 && level != 6 && level != 3 && level != 1 && level != 4 && level != 9) {
			testAnimal.setVx(3);
			testAnimal.setVy(3);

			//testAnimal.setVy(1);
		}else if(testAnimal.getHP( )> 0 && !lava) {
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
		
		for(int i = 0; i < meat.length; i++) {
			int xValue = (int)(Math.random()*1800) + 50;
			int yValue = (int)(Math.random()*900)+50;
		    shrooms[i] = new Mushroom(xValue, yValue);
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
			
			switch(arg0.getKeyCode()) {
				case 38:
					testAnimal.up();
					break;
				case 40:
					testAnimal.down();
					break;
				case 39:
					testAnimal.right();
					break;
				case 37:
					testAnimal.left();
					break;
				case 83:
					level++;
					evo = true;
					break;
				case 68:
					level--;
					evo = true;
					break;
				case 32:
					//spacebar
					if(abilityTimer>10) {
					abilityActivate = true;
					}
					break;
					
				
			}
		
		System.out.println(arg0.getKeyCode());
			//arrow keys are used for moving pony up and down
			/*if(arg0.getKeyCode() == 38) {
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
				level++;
				evo = true;
			}
			if(arg0.getKeyCode() == 68) { //press D to decrease 1 evolution, for testing
				level--;
				evo = true;
			}
			if(arg0.getKeyCode() == 67) { //press c to decrement hp 10
				testAnimal.setHP(testAnimal.getHP()-10);
				System.out.println("ouch");
				
				System.out.println(testAnimal.getHP());
				
			}*/
			
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
