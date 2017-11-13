//Assignment 1 - Introduction to Computer Graphics
//Q1:Draw a set of concentric pairs of squares
//Runze Zhang 
//rxz160630@utdallas.edu
//Test Environment: Mac OS Serria 10.12.6
//                  MacBook Pro (13-inch, 2017, Four Thunderbolt 3 Ports)
//                  Eclipse Java EE IDE for Web Developers.Oxygen Release (4.7.0)
//                    java version "1.8.0_144"
import java.awt.*;
import java.awt.event.*;

public class concentricRect extends Frame
{
	public static void main(String[] args){new concentricRect();}
	concentricRect()
	{ 
		super("concentricRect");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e){System.exit(0);
		}});
		setSize (1000, 1000);
		add("Center", new CvRect());
		show();
	} 
}
class CvRect extends Canvas
{ 
	int centerX, centerY;
	float pixelSize, rWidth = 230.0F, rHeight = 230.0F;
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
	int iR(float r) {return Math.round(r/pixelSize);}
	
	
	public void paint(Graphics g)
	{ 
	initgr();
	//set color as black
	g.setColor(Color.black);
	int r0=iR(1);
	for(int i=1;i<9;i++)
		{
			int xl=centerX-r0;
			int xr=centerX+r0;
			int yt=centerY-r0;
			int yb=centerY+r0;
	
			g.drawLine(xl,yt,xl,yb);
			g.drawLine(xl,yt,xr,yt);
			g.drawLine(xl,yb,xr,yb);
			g.drawLine(xr,yt,xr,yb);
			
			g.drawLine(xl,centerY,centerX,yb);
			g.drawLine(xl,centerY,centerX,yt);
			g.drawLine(centerX,yb,xr,centerY);
			g.drawLine(centerX,yt,xr,centerY);
			r0=2*r0;
		}
	}
}