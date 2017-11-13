//Assignment 1 - Introduction to Computer Graphics 
//Q2 Write a program to draw the interface of the Game of Tetris
//Runze Zhang 
//rxz160630@utdallas.edu
//Test Environment: Mac OS Serria 10.12.6
//                  MacBook Pro (13-inch, 2017, Four Thunderbolt 3 Ports)
//                  Eclipse Java EE IDE for Web Developers.Oxygen Release (4.7.0) 
//                  java version "1.8.0_144"
import java.awt.*;
import java.awt.event.*;
public class Tetris extends Frame
{
	public static void main(String[] args){new Tetris();}
	Tetris()
	{
		super("Tetris");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e){System.exit(0);}});
		setSize (600, 600);
		add("Center", new CvTetris());
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		show();
	}
}
class CvTetris extends Canvas
{ 
	int centerX, centerY;
	float pixelSize, rWidth = 230.0F, rHeight = 230.0F, xP, yP, xM, yM;
	boolean mainarea=false;
	CvTetris()
	{	
//		If the button “QUIT” is pressed, the program terminates and quits 
//		(this should not be the quit from the window’s standard pull-down menu).
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent evt)
			{
				xP = evt.getX(); yP = evt.getY();
				if((xP<iX(80))&&(xP>iX(20))&&(yP<iY(-100))&&(yP>iY(-80)))
				{
					System.exit(0);
				}
			}
		});
		//If the mouse cursor moves inside the main area, “PAUSE” (in a large font) will be displayed; 
		//	and if the cursor moves out of the area, “PAUSE” will disappear.
		addMouseMotionListener(new MouseAdapter()
		{
			public void mouseMoved(MouseEvent evtM) 
			{
				xM = evtM.getX(); yM = evtM.getY();
				if((xM<iX(0))&&(xM>iX(-100))&&(yM<iY(-100))&&(yM>iY(100)))
				{
					mainarea=true;
					repaint();
				}
				else
				{
					mainarea=false;
					repaint();
				}
			}
		});
	}
	void initgr()
	{
		Dimension d = getSize();
		int maxX = d.width - 1, maxY = d.height - 1;
		pixelSize = Math.max(rWidth/maxX, rHeight/maxY);
//		set graphic center as original point.
		centerX = maxX/2; centerY = maxY/2;
	}
	int iX(float x){return Math.round(centerX + x/pixelSize);}
	int iY(float y){return Math.round(centerY - y/pixelSize);}
//	set brick length
	int iL(float l) {return Math.round(l/pixelSize);}
//	set front size
	int iF(float f) {return Math.round(f/pixelSize);}
	float fx(int x){return (x - centerX) * pixelSize;}
	float fy(int y){return (centerY - y) * pixelSize;}
	public void paint(Graphics g)
	{
		initgr();
		//coordinate for larger Rectangle
		int bigRectltX=iX(-100),bigRectltY=iY(100);
		int bigRectlbX=iX(-100),bigRectlbY=iY(-100);
		int bigRectrtX=iX(0), bigRectrtY=iY(100);
		int bigRectrbX=iX(0), bigRectrbY=iY(-100);
		//coordinate for small Rectangle
		int smallRectltX=iX(20),smallRectltY=iY(100);
		int smallRectlbX=iX(20),smallRectlbY=iY(60);
		int smallRectrtX=iX(100), smallRectrtY=iY(100);
		int smallRectrbX=iX(100), smallRectrbY=iY(60);
		//coordinate for quit Rectangle
		int quitRectltX=iX(20),quitRectltY=iY(-80);
		int quitRectlbX=iX(20),quitRectlbY=iY(-100);
		int quitRectrtX=iX(80), quitRectrtY=iY(-80);
		int quitRectrbX=iX(80), quitRectrbY=iY(-100);
		//coordinate for pause Rectangle
		int pauseRectltX=iX(-80),pauseRectltY=iY(10);
		int pauseRectlbX=iX(-80),pauseRectlbY=iY(-10);
		int pauseRectrtX=iX(-30), pauseRectrtY=iY(10);
		int pauseRectrbX=iX(-30), pauseRectrbY=iY(-10);
		//Draw larger Rectangle
		g.drawLine(bigRectltX, bigRectltY, bigRectlbX, bigRectlbY);
		g.drawLine(bigRectrtX,bigRectrtY, bigRectrbX, bigRectrbY);
		g.drawLine(bigRectltX, bigRectltY, bigRectrtX,bigRectrtY);
		g.drawLine(bigRectlbX, bigRectlbY, bigRectrbX, bigRectrbY);
		//Draw small Rectangle
		g.drawLine(smallRectltX, smallRectltY, smallRectlbX, smallRectlbY);
		g.drawLine(smallRectrtX,smallRectrtY, smallRectrbX, smallRectrbY);
		g.drawLine(smallRectltX, smallRectltY, smallRectrtX,smallRectrtY);
		g.drawLine(smallRectlbX, smallRectlbY, smallRectrbX, smallRectrbY);
		//Draw quit Rectangle
		g.drawLine(quitRectltX, quitRectltY, quitRectlbX, quitRectlbY);
		g.drawLine(quitRectrtX,quitRectrtY, quitRectrbX, quitRectrbY);
		g.drawLine(quitRectltX, quitRectltY, quitRectrtX,quitRectrtY);
		g.drawLine(quitRectlbX, quitRectlbY, quitRectrbX, quitRectrbY);
		//draw and fill color for all bricks
		g.setColor(Color.blue);
		g.fillRect(iX(-10), iY(-90), iL(10), iL(10));
		g.fillRect(iX(-20), iY(-90), iL(10), iL(10));
		
		g.fillRect(iX(-10), iY(-80), iL(10), iL(10));
		
		g.fillRect(iX(-10), iY(-70), iL(10), iL(10));
		
		g.setColor(Color.black);
		g.drawRect(iX(-10), iY(-90), iL(10), iL(10));
		g.drawRect(iX(-20), iY(-90), iL(10), iL(10));
		
		g.drawRect(iX(-10), iY(-80), iL(10), iL(10));
		
		g.drawRect(iX(-10), iY(-70), iL(10), iL(10));
		
		g.setColor(Color.yellow);
		g.fillRect(iX(-30), iY(-90), iL(10), iL(10));
		g.fillRect(iX(-40), iY(-90), iL(10), iL(10));
		    
		g.fillRect(iX(-20), iY(-80), iL(10), iL(10));
		g.fillRect(iX(-30), iY(-80), iL(10), iL(10));
		
		g.setColor(Color.black);
		g.drawRect(iX(-30), iY(-90), iL(10), iL(10));
		g.drawRect(iX(-40), iY(-90), iL(10), iL(10));
		
		
		g.drawRect(iX(-20), iY(-80), iL(10), iL(10));
		g.drawRect(iX(-30), iY(-80), iL(10), iL(10));
		   
		g.setColor(Color.green);
		g.fillRect(iX(-50), iY(80), iL(10), iL(10));
		g.fillRect(iX(-60), iY(80), iL(10), iL(10));
		g.fillRect(iX(-50), iY(70), iL(10), iL(10));
		g.fillRect(iX(-60), iY(70), iL(10), iL(10));
		g.setColor(Color.black);
		g.drawRect(iX(-50), iY(80), iL(10), iL(10));
		g.drawRect(iX(-60), iY(80), iL(10), iL(10));
		g.drawRect(iX(-50), iY(70), iL(10), iL(10));
		g.drawRect(iX(-60), iY(70), iL(10), iL(10));
		
		g.setColor(Color.red);
		g.fillRect(iX(30), iY(80), iL(10), iL(10));
		g.fillRect(iX(40), iY(80), iL(10), iL(10));
		g.fillRect(iX(50), iY(80), iL(10), iL(10));
		g.fillRect(iX(50), iY(90), iL(10), iL(10));
		g.setColor(Color.black);
		g.drawRect(iX(30), iY(80), iL(10), iL(10));
		g.drawRect(iX(40), iY(80), iL(10), iL(10));
		g.drawRect(iX(50), iY(80), iL(10), iL(10));
		g.drawRect(iX(50), iY(90), iL(10), iL(10));
		
		Font infoFont = new Font( "Verdana", Font.BOLD, iF(10) );
		g.setFont(infoFont);
		g.drawString("Level:     1", iX(20), iY(20));
		g.drawString("Lines:     0", iX(20), iY(0));
		g.drawString("Score:     0", iX(20), iY(-20));
		
		g.drawString("QUIT", iX(35), iY(-95));
		if(mainarea)
		{
			//Draw Pause rectangle
			g.setColor(Color.cyan);
			g.drawLine(pauseRectltX, pauseRectltY, pauseRectlbX, pauseRectlbY);
			g.drawLine(pauseRectrtX,pauseRectrtY, pauseRectrbX, pauseRectrbY);
			g.drawLine(pauseRectltX, pauseRectltY, pauseRectrtX,pauseRectrtY);
			g.drawLine(pauseRectlbX, pauseRectlbY, pauseRectrbX, pauseRectrbY);
			g.setColor(Color.cyan);
			g.drawString("PAUSE", iX(-75), iY(-5));
		}

	} 
}
