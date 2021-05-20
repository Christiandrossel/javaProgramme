import java.awt.*;
import java.awt.event.*;
public class FlowLayoutPanel extends Panel{
	Button b1 = new Button("Max");
	Button b2 = new Button("Mexi");
	Button b3 = new Button("Miss");
	Button b4 = new Button("Murks");
	Button b5 = new Button("Der groﬂe Rest");
	
	public FlowLayoutPanel(){
		setFont(new Font("System",Font.PLAIN,34));
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
	}
	
	public static void main(String args[]){
		FlowLayoutPanel p = new FlowLayoutPanel();
		Frame f = new Frame("FlowLayoutPanal");
		f.add(p);
		
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		f.setVisible(true);
		f.pack();
	}
}