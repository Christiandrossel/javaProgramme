import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Btest extends Panel{
	public Btest(){
JLabel l=new JLabel("Java:", new ImageIcon("java.png"),
								SwingConstants.LEFT);
l.setHorizontalTextPosition(SwingConstants.RIGHT );
add(l);
JButton b=new JButton("Suse",
new ImageIcon("gnome-suse.png"));
b.setHorizontalTextPosition(SwingConstants.RIGHT );
add(b) ;
	}
	public static void main(String args[]){
		Btest p = new Btest();
		JFrame f =new JFrame("Test");
		f.add(p);
		f.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
	});
	}
}