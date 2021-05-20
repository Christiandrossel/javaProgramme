import java.awt.*;
import java.awt.event.*;

//Rechner mit Gridbaglayout

class Rechner2 extends Panel
{
  // hier Referenzen fuer Komponenten 
  // (Buttons, Textfields, Panels) vereinbaren
  String bx[] = {"M+", "7", "8","9","/",
				 "M-","4","5","6","*",
				 "MR","1","2","3","-",
				 "CE","0",".","=","+" };
  
  TextField t1 = new TextField(10);
  
  


  public Rechner2()
  {
    // Komponenten erzeugen und zu Oberflaeche zusammenbauen,
	setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	c.gridwidth = 5;
	c.gridx=0;
	c.gridy=0;
	c.fill=GridBagConstraints.BOTH;
	add(t1,c);
	
	c.gridwidth = 1;
	c.gridy=1;
	for(int i=0;i < bx.length;i++){
		Button b = new Button(bx[i]);
		add(b,c);
			c.gridx++;
		if(((i%5)==0) && (i!= 0)){
			c.gridx=0;
			c.gridy++;
		}
	}
	
	
	
	setFont(new Font("System", Font.PLAIN, 24));
	
    
    
  }

  public static void main(String args[])
  {
	  Rechner2 P=new Rechner2();
	  Frame F=new Frame("Rechner");
	  F.setLayout(new BorderLayout());
	  F.add(P);
      F.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});

      F.pack();
      F.setVisible(true);
  }
}