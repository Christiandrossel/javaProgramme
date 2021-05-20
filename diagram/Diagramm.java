import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

class Diagramm extends Frame{
	protected Graphics g;
	int w = 1000;
	int h = 1000;
	int prozent =25;
	Diagramm()throws Exception{
		super("LOL");
		g=getGraphics();
		setSize(1000,1000);
		setVisible(true);
	}
	public void paint(Graphics g){
		super.paint(g);
		int r = getHeight()<getWidth()?
		getHeight()/4:getWidth()/4;
		drawCircle(g,getWidth()/2,getHeight()/2,r);
		g.setColor(Color.WHITE);
		g.fillArc(getWidth()/2-r, getHeight()/2-r,r*2,r*2,0,(int)(3.6*prozent));
	}
	private void drawCircle(Graphics g, int x, int y, int radius)
	{
		g.fillOval(x-radius,y-radius, radius*2, radius*2);
	}
	public static void main(String[] args) throws Exception
	{
		Diagramm d = new Diagramm();
	}
}