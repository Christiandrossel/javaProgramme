import java.awt.*;
import java.awt.event.*;
public class ImgPanel extends Panel
{
private Image Img;
ImgPanel(Image Img)
{ this.Img=Img; }
public void paint(Graphics g)
{ g.drawImage(Img,0,0,this); }
public static void main(String args[])
{
Frame F=new Frame("ImagepanelDemo");
Image I=F.getToolkit().getImage(args[0]);
ImgPanel P=new ImgPanel(I);
F.add(P);
F.addWindowListener(new WindowAdapter()....);
F.pack();
F.setVisible(true);
}
}