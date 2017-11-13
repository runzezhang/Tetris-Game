//Assignment 2 - Algorithms for 2D Primitives 
//Enhance Tetris program
//Runze Zhang 
//rxz160630@utdallas.edu
//Test Environment: Mac OS Serria 10.12.6
//                  MacBook Pro (13-inch, 2017, Four Thunderbolt 3 Ports)
//                  Eclipse Java EE IDE for Web Developers.Oxygen Release (4.7.0) 
//                  java version "1.8.0_144"
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class Main extends Frame
{
	public static void main(String[] args){new Main();}
	Main()
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


//Class for brick design
class Brick{
	int type;
	public Brick(int type) {
		this.type=type;
	}
	int x;
	int y;
	//set brick location
	public void setLocation(int locationx, int locationy) {
		x=locationx;
		y=locationy;
	}
	public int getLocationx() {
		return x;
	}
	public int getLocationy() {
		return y;
	}
	public int getType() {
		return type;
	}
	int direction;
	public void setDirection(int direction) {
		this.direction=direction;
	}
	
	int[][] brickarray=new int[4][2];
	public void setBricks()
	{
		switch (type) 
		{
			case 1:
				switch (direction) {
				case 0:
					brickarray[0][0]=x;
					brickarray[0][1]=y;
					brickarray[1][0]=x;
					brickarray[1][1]=y-1;
					brickarray[2][0]=x-1;
					brickarray[2][1]=y;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y-1;
					break;
				case 1:
					brickarray[0][0]=x;
					brickarray[0][1]=y;
					brickarray[1][0]=x;
					brickarray[1][1]=y-1;
					brickarray[2][0]=x+1;
					brickarray[2][1]=y;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 2:
					brickarray[0][0]=x;
					brickarray[0][1]=y-1;
					brickarray[1][0]=x;
					brickarray[1][1]=y-2;
					brickarray[2][0]=x-1;
					brickarray[2][1]=y-1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y-2;
					break;
				case 3:
					brickarray[0][0]=x-1;
					brickarray[0][1]=y;
					brickarray[1][0]=x-1;
					brickarray[1][1]=y-1;
					brickarray[2][0]=x;
					brickarray[2][1]=y;
					brickarray[3][0]=x;
					brickarray[3][1]=y+1;
					break;
				}

				break;
			case 2:
				switch (direction) {
				case 0:
					brickarray[0][0]=x;
					brickarray[0][1]=y;
					brickarray[1][0]=x;
					brickarray[1][1]=y-1;
					brickarray[2][0]=x-1;
					brickarray[2][1]=y-1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y;
					break;
				case 1:
					brickarray[0][0]=x;
					brickarray[0][1]=y;
					brickarray[1][0]=x;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x+1;
					brickarray[2][1]=y;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y-1;
					break;
				case 2:
					brickarray[0][0]=x;
					brickarray[0][1]=y+1;
					brickarray[1][0]=x;
					brickarray[1][1]=y;
					brickarray[2][0]=x-1;
					brickarray[2][1]=y;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 3:
					brickarray[0][0]=x-1;
					brickarray[0][1]=y;
					brickarray[1][0]=x-1;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x;
					brickarray[2][1]=y;
					brickarray[3][0]=x;
					brickarray[3][1]=y-1;
					break;
				}
				break;
			case 3:
				switch (direction) {
				case 0:
					brickarray[0][0]=x;
					brickarray[0][1]=y;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 1:
					brickarray[0][0]=x+1;
					brickarray[0][1]=y;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y;
					brickarray[2][0]=x+1;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 2:
					brickarray[0][0]=x+2;
					brickarray[0][1]=y+2;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 3:
					brickarray[0][0]=x+1;
					brickarray[0][1]=y;
					brickarray[1][0]=x;
					brickarray[1][1]=y+2;
					brickarray[2][0]=x+1;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				}
				break;
			case 4:
				switch (direction) {
				case 0:
					brickarray[0][0]=x+2;
					brickarray[0][1]=y;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 1:
					brickarray[0][0]=x+1;
					brickarray[0][1]=y;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+2;
					brickarray[2][0]=x+1;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 2:
					brickarray[0][0]=x;
					brickarray[0][1]=y+2;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 3:
					brickarray[0][0]=x+1;
					brickarray[0][1]=y;
					brickarray[1][0]=x;
					brickarray[1][1]=y;
					brickarray[2][0]=x+1;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				}
				break;
			case 5:
				switch (direction) {
				case 0:
					brickarray[0][0]=x;
					brickarray[0][1]=y;
					brickarray[1][0]=x+1;
					brickarray[1][1]=y;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 1:
					brickarray[0][0]=x;
					brickarray[0][1]=y;
					brickarray[1][0]=x+1;
					brickarray[1][1]=y;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 2:
					brickarray[0][0]=x;
					brickarray[0][1]=y;
					brickarray[1][0]=x+1;
					brickarray[1][1]=y;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 3:
					brickarray[0][0]=x;
					brickarray[0][1]=y;
					brickarray[1][0]=x+1;
					brickarray[1][1]=y;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				}
				break;
			case 6:
				switch (direction) {
				case 0:
					brickarray[0][0]=x+1;
					brickarray[0][1]=y;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 1:
					brickarray[0][0]=x+1;
					brickarray[0][1]=y;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x+1;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 2:
					brickarray[0][0]=x;
					brickarray[0][1]=y+1;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x+1;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 3:
					brickarray[0][0]=x;
					brickarray[0][1]=y+1;
					brickarray[1][0]=x+1;
					brickarray[1][1]=y;
					brickarray[2][0]=x+1;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				}
				break;
			case 7:
				switch (direction) {
				case 0:
					brickarray[0][0]=x+3;
					brickarray[0][1]=y+1;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x;
					brickarray[2][1]=y+1;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+1;
					break;
				case 1:
					brickarray[0][0]=x+3;
					brickarray[0][1]=y;
					brickarray[1][0]=x+3;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x+3;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+3;
					brickarray[3][1]=y+3;
					break;
				case 2:
					brickarray[0][0]=x+3;
					brickarray[0][1]=y+2;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+2;
					brickarray[2][0]=x;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+1;
					brickarray[3][1]=y+2;
					break;
				case 3:
					brickarray[0][0]=x+2;
					brickarray[0][1]=y;
					brickarray[1][0]=x+2;
					brickarray[1][1]=y+1;
					brickarray[2][0]=x+2;
					brickarray[2][1]=y+2;
					brickarray[3][0]=x+2;
					brickarray[3][1]=y+3;
					break;
				}
				break;
		}
	}
}


class CvTetris extends Canvas
{ 
	static class GameTimerTask extends TimerTask {
		CvTetris c;
		GameTimerTask(CvTetris c){
			super();
			this.c=c;
		}
		@Override
		public void run() {
			c.fall();
			//System.out.println("Fuck");
			//c.repaint();
		}
	}
	int centerX, centerY;
	float pixelSize, rWidth = 230.0F, rHeight = 230.0F, xP, yP, xM, yM;
	boolean judgemainarea=false;
	boolean judgemainzreanow=false;
	
    public void setJudgemainzreanow(boolean judgemainzreanow) {
    		if(this.judgemainzreanow != judgemainzreanow) 
    		{
    			if(judgemainzreanow) 
    			{
    				if(timer!=null) {
    				timer.cancel();
    				timer=null;
    				}
    			}else 
    			{
    				timer = new Timer();
    				timer.scheduleAtFixedRate(new GameTimerTask(this), 0, 500);
    			}
    			this.judgemainzreanow = judgemainzreanow;
    		}
		
	}
	int max=7;
    int min=1;
    Random random = new Random();
    int mainrandom = random.nextInt(max)%(max-min+1) + min;
    int nextrandom = random.nextInt(max)%(max-min+1) + min;
    
    int mainbrickx=2;
    int mainbricky=1;
    
    Brick mainbrick;
    
    Timer timer;
    boolean bottom=false;
    int fallarea[][]= new int[10][21];
    int direction=0;
	CvTetris()
	{	
		addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent evt) {
                super.mouseWheelMoved(evt);
                if(judgemainarea)
                    return;
                if (evt.getWheelRotation() < 0) {
//                    System.out.println("Rotated Up... " + evt.getWheelRotation());
					if(bottom) {
						return;
					}
					direction=(direction+1);
					if(direction<0) {
						direction=direction+4;
					}
					direction=direction%4;
					mainbrick.setLocation(mainbrickx, mainbricky);
					mainbrick.setBricks();
					boolean repaintjudge=true;
					for(int x=0;x<4;x++) {
						for(int y=0;y<2;y++){
							switch(y) {
								case 0:
									if(mainbrick.brickarray[x][y]<0) {
										repaintjudge=false;
										direction=(direction-1);
										if(direction<0) {
											direction=direction+4;
										}
										direction=direction%4;
									}
									break;
								case 1:
									if(mainbrick.brickarray[x][y]>18) {
										repaintjudge=false;
										direction=(direction-1);
										if(direction<0) {
											direction=direction+4;
										}
										direction=direction%4;
									}
									break;
							}
						}
					}
					if(repaintjudge) {
					repaint();
					}

                } else {
//                    System.out.println("Rotated Down... " + evt.getWheelRotation());
                    if(bottom) {
						return;
					}
					direction=(direction-1);
					if(direction<0) {
						direction=direction+4;
					}
					direction=direction%4;
					mainbrick.setLocation(mainbrickx, mainbricky);
					mainbrick.setBricks();
					boolean repaintjudge=true;
					for(int x=0;x<4;x++) {
						for(int y=0;y<2;y++){
							switch(y) {
								case 0:
									if(mainbrick.brickarray[x][y]<0) {
										repaintjudge=false;
										direction=(direction+1);
										if(direction<0) {
											direction=direction+4;
										}
										direction=direction%4;
									}
									break;
								case 1:
									if(mainbrick.brickarray[x][y]>18) {
										repaintjudge=false;
										direction=(direction+1);
										if(direction<0) {
											direction=direction+4;
										}
										direction=direction%4;
									}
									break;
							}
						}
					}
					if(repaintjudge) {
					repaint();
					}
					}
                System.out.println("ScrollAmount: " + evt.getScrollAmount());
            }
        });
//		If the button “QUIT” is pressed, the program terminates and quits 
//		(this should not be the quit from the window’s standard pull-down menu).
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent evt)
			{
				int buttonFlag=evt.getButton();
				
				xP = evt.getX(); yP = evt.getY();
				if((xP<iX(80))&&(xP>iX(20))&&(yP<iY(-100))&&(yP>iY(-80)))
				{
					System.exit(0);
				}else if((xM<iX(0))&&(xM>iX(-100))&&(yM<iY(-100))&&(yM>iY(100))) 
				{					
				}else 
					{
						switch (buttonFlag) 
						{
						case MouseEvent.BUTTON1:
							if(bottom) {
								return;
							}
							mainbrickx=mainbrickx-1;
							mainbrick.setLocation(mainbrickx, mainbricky);
							mainbrick.setBricks();
							boolean repaintjudge=true;
							for(int x=0;x<4;x++) {
								for(int y=0;y<2;y++){
									switch(y) {
										case 0:
											if(mainbrick.brickarray[x][y]<0) {
												repaintjudge=false;
												mainbrickx=mainbrickx+1;
											}
											break;
										case 1:
											if(mainbrick.brickarray[x][y]>18) {
												repaintjudge=false;
												mainbrickx=mainbrickx+1;
											}
											break;
									}
								}
							}
							if(repaintjudge) {
							repaint();
							}
							break;
						case MouseEvent.BUTTON3:
							if(bottom) {
								return;
							}
							mainbrickx=mainbrickx+1;
							mainbrick.setLocation(mainbrickx, mainbricky);
							mainbrick.setBricks();

							boolean repaintjudge2=true;
							for(int x=0;x<4;x++) {
								for(int y=0;y<2;y++) {
									switch(y) {
										case 0:
											if(mainbrick.brickarray[x][y]>9) {
												repaintjudge2=false;
												mainbrickx=mainbrickx-1;
												break;
											}
											break;
										case 1:
											if(mainbrick.brickarray[x][y]>18) {
												repaintjudge2=false;
												mainbrickx=mainbrickx-1;
												break;
											}
											break;
									}
									
								}
							}
							if(repaintjudge2) {
							repaint();
							}
							break;
						}
					}
			}
		});
		//If the mouse cursor moves inside the main area, “PAUSE” (in a large font) will be displayed; 
		//	and if the cursor moves out of the area, “PAUSE” will disappear.
		addMouseMotionListener(new MouseAdapter()
		{
			public void mouseMoved(MouseEvent evtM) 
			{
				if(bottom) {
					return;
//					mainbricky=mainbricky+1;
				}
				xM = evtM.getX(); yM = evtM.getY();
				if((xM<iX(0))&&(xM>iX(-100))&&(yM<iY(-100))&&(yM>iY(100)))
				{
					judgemainarea=true;
					if(judgemainzreanow!=judgemainarea) 
					{
						repaint();
						setJudgemainzreanow(judgemainarea);
					}
				}
				else
				{
					judgemainarea=false;
					if(judgemainzreanow!=judgemainarea)
					{
						repaint();
						setJudgemainzreanow(judgemainarea);
					}
				}
			}
		});
		timer = new Timer();
		timer.scheduleAtFixedRate(new GameTimerTask(this), 0, 500);
	}
	public void fall() {
		if(mainbrick==null) {
			return;
		}
		//boolean bottom=false;
		if(bottom) {
			return;
		}
		mainbricky=mainbricky+1;
		mainbrick.setLocation(mainbrickx, mainbricky);
		mainbrick.setBricks();
		mainbrick.setDirection(direction);
		System.out.println(fallarea.length+" "+fallarea[0].length);
		System.out.println(mainbrick.brickarray[0][0]+" "+mainbrick.brickarray[0][1]);
		if(fallarea[mainbrick.brickarray[0][0]][mainbrick.brickarray[0][1]]!=0) {
			bottom=true;
			mainbricky=mainbricky-1;
			return;
		}
		
		if(fallarea[mainbrick.brickarray[1][0]][mainbrick.brickarray[1][1]]!=0) {
				bottom=true;
				mainbricky=mainbricky-1;
				return;	
		}
		if(fallarea[mainbrick.brickarray[2][0]][mainbrick.brickarray[2][1]]!=0) {
			bottom=true;
			mainbricky=mainbricky-1;
			return;	
		}
		if(fallarea[mainbrick.brickarray[3][0]][mainbrick.brickarray[3][1]]!=0){
			bottom=true;
			mainbricky=mainbricky-1;
			return;	
		}

		boolean repaintyjudge=true;

		for(int x=0;x<4;x++) {
			for(int y=0;y<2;y++) {
				switch(y) {
					case 0:
						if(mainbrick.brickarray[x][y]<0) {
							repaintyjudge=false;
							mainbricky=mainbricky-1;
						}
						break;
					case 1:
						if(mainbrick.brickarray[x][y]>19) {
							repaintyjudge=false;
							bottom=true;
							mainbricky=mainbricky-1;
							break;
						}
						break;
				}
			}
		}
		if(repaintyjudge) {
			repaint();
			}		
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
		//define main area as 10*20 arrays.
	    int mainarea[][]= new int[10][20];
		//set main area random brick
		this.mainbrick=new Brick(mainrandom);
		mainbrick.setLocation(mainbrickx, mainbricky);
		int type=mainbrick.getType();
		mainbrick.setDirection(direction);
		mainbrick.setBricks();
			mainarea[mainbrick.brickarray[0][0]][mainbrick.brickarray[0][1]]=type;
			mainarea[mainbrick.brickarray[1][0]][mainbrick.brickarray[1][1]]=type;
			mainarea[mainbrick.brickarray[2][0]][mainbrick.brickarray[2][1]]=type;
			mainarea[mainbrick.brickarray[3][0]][mainbrick.brickarray[3][1]]=type;
		//test data
//		mainarea[0][0]=1;
//		mainarea[1][1]=2;
//		mainarea[2][2]=3;
//		mainarea[3][3]=4;
//		mainarea[4][4]=5;
//		mainarea[5][5]=6;
		//test fallen brick
		mainarea[5][19]=7;
		mainarea[6][19]=7;
		mainarea[7][19]=7;
		mainarea[8][19]=7;
		fallarea[6][19]=7;
		fallarea[7][19]=7;
		fallarea[8][19]=7;
		fallarea[5][19]=7;
		fallarea[0][20]=7;
		fallarea[1][20]=7;
		fallarea[2][20]=7;
		fallarea[3][20]=7;
		fallarea[4][20]=7;
		fallarea[5][20]=7;
		fallarea[6][20]=7;
		fallarea[7][20]=7;
		fallarea[8][20]=7;
		fallarea[9][20]=7;
		//draw bricks;
		for(int mainareax=0; mainareax<10; mainareax++)
			for(int mainareay=0; mainareay<20; mainareay++)
			{
				if(mainarea[mainareax][mainareay]!=0) {
					int brickx=-100+10*mainareax;
					int bricky=100-10*mainareay;
					switch (mainarea[mainareax][mainareay]) {
					case 1 :
						g.setColor(Color.yellow);
						break;
					case 2 :
						//Purple
						g.setColor(new Color(127,0,255));
						break;
					case 3 :
						//dark blue
						g.setColor(new Color(0,102,204));
						break;
					case 4 :
						g.setColor(Color.red);
						break;
					case 5 :
						//dark green
						g.setColor(new Color(0,153,0));
						break;
					case 6 :
						//dark yellow
						g.setColor(new Color(204,102,0));
						break;
					case 7 :
						g.setColor(Color.blue);
						break;
					}
					g.fillRect(iX(brickx), iY(bricky), iL(10), iL(10));
					g.setColor(Color.black);
					g.drawRect(iX(brickx), iY(bricky), iL(10), iL(10));
				}
			}
		
		//define next area as 4*8 arrays.
		int nextarea[][]= new int[8][4];
		//set next area random brick
		Brick nextbrick=new Brick(nextrandom);
		nextbrick.setLocation(2, 1);
		int nexttype=nextbrick.getType();
		int nextbrickx=nextbrick.getLocationx();
		int nextbricky=nextbrick.getLocationy();
		switch (nexttype) {
		case 1:
			nextarea[nextbrickx][nextbricky]=nexttype;
			nextarea[nextbrickx+1][nextbricky]=nexttype;
			nextarea[nextbrickx-1][nextbricky+1]=nexttype;
			nextarea[nextbrickx][nextbricky+1]=nexttype;
			break;
		case 2:
			nextarea[nextbrickx][nextbricky]=nexttype;
			nextarea[nextbrickx+1][nextbricky]=nexttype;
			nextarea[nextbrickx+1][nextbricky+1]=nexttype;
			nextarea[nextbrickx+2][nextbricky+1]=nexttype;
			break;
		case 3:
			nextarea[nextbrickx][nextbricky]=nexttype;
			nextarea[nextbrickx+2][nextbricky+1]=nexttype;
			nextarea[nextbrickx][nextbricky+1]=nexttype;
			nextarea[nextbrickx+1][nextbricky+1]=nexttype;
			break;
		case 4:
			nextarea[nextbrickx+2][nextbricky]=nexttype;
			nextarea[nextbrickx+2][nextbricky+1]=nexttype;
			nextarea[nextbrickx][nextbricky+1]=nexttype;
			nextarea[nextbrickx+1][nextbricky+1]=nexttype;
			break;
		case 5:
			nextarea[nextbrickx][nextbricky]=nexttype;
			nextarea[nextbrickx+1][nextbricky]=nexttype;
			nextarea[nextbrickx][nextbricky+1]=nexttype;
			nextarea[nextbrickx+1][nextbricky+1]=nexttype;
			break;
		case 6:
			nextarea[nextbrickx+1][nextbricky]=nexttype;
			nextarea[nextbrickx+2][nextbricky+1]=nexttype;
			nextarea[nextbrickx][nextbricky+1]=nexttype;
			nextarea[nextbrickx+1][nextbricky+1]=nexttype;
			break;
		case 7:
			nextarea[nextbrickx+3][nextbricky]=nexttype;
			nextarea[nextbrickx+2][nextbricky]=nexttype;
			nextarea[nextbrickx][nextbricky]=nexttype;
			nextarea[nextbrickx+1][nextbricky]=nexttype;
			break;
		}
		//test data
//		nextarea[0][0]=1;
//		nextarea[1][1]=2;
//		nextarea[2][2]=3;
//		nextarea[3][3]=4;
		//draw bricks;
		for(int nextareax=0; nextareax<8; nextareax++)
			for(int nextareay=0; nextareay<4; nextareay++)
			{
				if(nextarea[nextareax][nextareay]!=0) {
					int nextx=20+10*nextareax;
					int nexty=100-10*nextareay;
					switch (nextarea[nextareax][nextareay]) {
					case 1 :
						g.setColor(Color.yellow);
						break;
					case 2 :
						//Purple
						g.setColor(new Color(127,0,255));
						break;
					case 3 :
						//dark blue
						g.setColor(new Color(0,102,204));
						break;
					case 4 :
						g.setColor(Color.red);
						break;
					case 5 :
						//dark green
						g.setColor(new Color(0,153,0));
						break;
					case 6 :
						//dark yellow
						g.setColor(new Color(204,102,0));
						break;
					case 7 :
						g.setColor(Color.blue);
						break;
					}
					g.fillRect(iX(nextx), iY(nexty), iL(10), iL(10));
					g.setColor(Color.black);
					g.drawRect(iX(nextx), iY(nexty), iL(10), iL(10));
				}
			}

		//score band
		Font infoFont = new Font( "Verdana", Font.BOLD, iF(10) );
		g.setFont(infoFont);
		g.drawString("Level:     1", iX(20), iY(20));
		g.drawString("Lines:     0", iX(20), iY(0));
		g.drawString("Score:     0", iX(20), iY(-20));
		//quit
		g.drawString("QUIT", iX(35), iY(-95));
		//pause option
		if(judgemainarea)
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
