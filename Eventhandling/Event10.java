import java.awt.*;
import java.awt.event.*;

class Event10 extends Panel{
	class MyButton extends Button {
		boolean flag;
		MyButton(String label, boolean flag){
			super(label);
			this.flag=flag;
		}
		@Override
		public boolean action(Event what, Object who){
			System.out.println("action MyButton\n"+who+" Event: "+what);
			return flag;
		}
	}
	public Event10(boolean flag)
{
setFont(new Font("System",Font.PLAIN,40));
MyButton b1=new MyButton("TestButton",flag);
add(b1);
}
@Override
public boolean action(Event what, Object who)
{
System.out.println("action Panel\n"+who+" Event: "+what);
return false;
}
public static void main(String args[])
{
Frame F=new Frame();
Event10 p=new Event10(Boolean.parseBoolean(args[0]));
F.add(p);
F.setSize(300,150);
F.setVisible(true);
F.addWindowListener(new WindowAdapter(){public void windowClosing(WindowsEvent e){System.exit(0);}} );
}
}