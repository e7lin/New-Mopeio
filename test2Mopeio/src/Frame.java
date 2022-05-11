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
	MyTimer test = new MyTimer();
	
	BerryBush berryBush1 = new BerryBush((int)((Math.random()*400)), (int)((Math.random()*430)+70));
	
	
	
	//creating objects and object arrays  (STEP 1)
	private int level = 0;
	private boolean evo = false;
	public int berryInt = 0;
	Berry[] berries = new Berry[7];

	
	public void paint(Graphics g) { //The code under this method paints the objects
		super.paintComponent(g);
		bg1.paint(g);
		lavaPool.paint(g);
		berryBush1.paint(g);
	    for(int i = 0; i < berryInt/120; i++) {
	    	berries[i].paint(g);
	    }
	   
		
	   // if(berryInt % 300 == 0) {
	   /// 	berries[berryInt%300].paint(g);
	   // }
	    
	    testAnimal.paint(g);
		

		//time interval for spawn of berries
	    if(berryInt<2100) {
			berryInt++;
		}
		
		
		//trying to make a simple evolution thing
		if(level == 0) {
			testAnimal.setHP(10);

		}else if(level == 1 && evo) {
			Animal temp = new Frog(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(20);
			System.out.println(testAnimal.getHP());
		}else if(level == 2 && evo) {
			Animal temp = new Pig(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(30);

		}else if(level == 3 && evo) {
			Animal temp = new Otter(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(40);

		}else if(level == 4 && evo) {
			Animal temp = new Vulture(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(50);

		}else if(level == 5 && evo) {
			Animal temp = new Buffalo(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(60);

		}else if(level == 6 && evo) {
			Animal temp = new Hippo(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(70);

		}else if(level == 7 && evo) {
			Animal temp = new Tiger(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(80);

		}else if(level == 8 && evo) {
			Animal temp = new Lion(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(90);

		}else if(level == 9 && evo) {
			Animal temp = new Dragon(testAnimal.getX(), testAnimal.getY());
			testAnimal = temp;
			evo = false;
			testAnimal.setHP(100);

		}
		//end of evolution code
		
		
		if(testAnimal.getHP() == 0) {
			g.setFont(g.getFont().deriveFont(150f));
			
			g.fillRect(650, 500, 750, 200);
			Color c = new Color(237, 0, 0);
			g.setColor(c);
			g.drawString("You Died!", 700,650);
		}
		
		if(testAnimal.getX() >=1020 && testAnimal.getX()<=1440 && level != 6 && level != 3 && level != 1) {
			testAnimal.setVx(3);
			testAnimal.setVy(3);

			//testAnimal.setVy(1);
		}else {
			testAnimal.setVx(10);
			testAnimal.setVy(10);
		}
		
	}//end of paint
	
	
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		// 70 to 500 for first berry bush x; y will be from 70 down to 500
		
		for(int i = 0; i < berries.length; i++) {
			int xValue = (int)(Math.random()*150) + berryBush1.getX();
			int yValue = (int)(Math.random()*150) + berryBush1.getY();
		    berries[i] = new Berry(xValue, yValue);
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
