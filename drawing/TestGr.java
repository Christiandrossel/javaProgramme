import java.awt.*;
import java.awt.event.*;
import java.util.*;
class TestGr extends Panel
{
. . .
public static void main(String args[])
{
Frame f=new Frame();
f.add(new TestGr());
f.setVisible(true);
f.setSize(500,500);
f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e){System.exit (0);}
});
}
}
